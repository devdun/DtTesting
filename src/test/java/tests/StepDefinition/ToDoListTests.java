package tests.StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageFactory.toDo.ToDoPage;

import java.time.Duration;
import java.util.List;


public class ToDoListTests {
    WebDriver driver = null;
    ToDoPage toDoPage;

    @Before
    public void driverSetup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("window-size=1400,2100");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMillis(100));
    }

    @Given("User in todo list page")
    public void user_in_todo_list_page() {
        driver.navigate().to("http://todomvc.com/examples/vue/");
    }

    @When("User Enter Todo item and press enter")
    public void user_enter_todo_item_and_press_enter(List<String> testdata) {
        toDoPage = PageFactory.initElements(driver, ToDoPage.class);
        for (int i = 0; i < testdata.size(); i++) {
            toDoPage.setTodo(String.valueOf(testdata.get(i)));
        }
        //Verify Created count
        int count = toDoPage.getItemLeftCount();
        Assert.assertEquals(count,testdata.size(),"Compare with created count");
    }

    @Then("Item count should be {int}")
    public void item_count_should_be(Integer int1) {
        //Verify Created count
        int count = toDoPage.getItemLeftCount();
        Assert.assertEquals(count,int1,"Compare with given count");
    }

    @Then("User should be able to create a to do item")
    public void user_should_be_able_to_create_a_to_do_item() {
        List<String> actualData = toDoPage.getItemValues();
        Assert.assertTrue(actualData.size()>0);
    }

    @Then("Refresh the page and check")
    public void refresh_the_page_and_check(List<String> createdToDoItems) {
        driver.navigate().refresh();
        List<String> actualData = toDoPage.getItemValues();
        toDoPage.clickCompletedBtn();
        Assert.assertEquals(actualData, createdToDoItems,"actual data vs refreshed data set");
    }

    @When("user double click on existing item {int} and edit")
    public void user_double_click_on_existing_item_and_edit(Integer edit1) {
        //EDit item  1=0 , 2=1 , 3=2 , 4=3 etc.
        toDoPage.editItem(edit1,"This is Edited");
    }

    @Then("Edited text should be displayed")
    public void edited_text_should_be_displayed() {
        String editedTodoItem = toDoPage.getTodoItemValue(1);
        Assert.assertEquals(editedTodoItem,"This is Edited");
    }

    @Then ("User tick to complete ToDo items")
    public void user_tick_to_complete_todo_items(){
        //select all checkboxes
        toDoPage.clickAllCheckboxes();
    }

    @Then ("Item left count change to {int} accordingly")
    public void item_left_count_change_accordingly(Integer itemLeft){
        int count = toDoPage.getItemLeftCount();
        Assert.assertEquals(count,itemLeft);
    }

    @And("completed items display under completed tab")
    public void completed_Items_Display_Under_Completed_Tab(List<String> testData){
        List<String> actualData = toDoPage.getItemValues();
        toDoPage.clickCompletedBtn();
        Assert.assertEquals(actualData, testData,"actual data vs given data set");
    }

    @Then("User delete an todo item {int}")
    public void user_delete_an_todo_item(Integer int1) {
        //Delete Item
        toDoPage.deleteToDoItem(int1);
    }

    @Then("User delete an completed item {int}")
    public void user_delete_an_completed_item(Integer int1) {
        //Delete Item
        toDoPage.deleteCompletedItem(int1);
    }

    @Then("Deleted item should not displayed")
    public void deleted_item_should_not_displayed(List<String> testData) {
        List<String> actualData = toDoPage.getItemValues();
        Assert.assertFalse(actualData.contains(testData));
    }

    @Then("User tick {int} checkbox to complete ToDo item")
    public void user_tick_checkbox_to_complete_to_do_item(Integer specificCheckBox) {
        toDoPage.clickSpecificCheckbox(specificCheckBox);
    }

    @Then("User navigate to {string} list and check count is {int}")
    public void user_navigate_to_list_and_check_count_is(String listName, Integer givenSize) {
        if (listName.equalsIgnoreCase("all")) {
            toDoPage.clickAllBtn();
            List<String> actualData = toDoPage.getItemValues();
            Assert.assertEquals(actualData.size(),givenSize);
        } else if (listName.equalsIgnoreCase("Active")){
            toDoPage.clickActiveBtn();
            List<String> actualData = toDoPage.getItemValues();
            Assert.assertEquals(actualData.size(),givenSize);
        }else if (listName.equalsIgnoreCase("Completed")){
            toDoPage.clickCompletedBtn();
            List<String> actualData = toDoPage.getItemValues();
            Assert.assertEquals(actualData.size(),givenSize);
        }
    }

    @Then("User click clear completed button to clear all")
    public void user_click_clear_completed_button_to_clear_all() {
        toDoPage.clickClearCompletedBtn();
    }

    @Then("Filter class should be {string}")
    public void filter_class_should_be(String status) {
        if (status.equalsIgnoreCase("invisible")){
            boolean actualStatus = toDoPage.visibilityOfFilterPanel();
            Assert.assertFalse(actualStatus);
        }else if(status.equalsIgnoreCase("visible")){
            boolean actualStatus = toDoPage.visibilityOfFilterPanel();
            Assert.assertTrue(actualStatus);
        }
    }

    @After
    public void driverQuit() {
        driver.quit();
    }


}
