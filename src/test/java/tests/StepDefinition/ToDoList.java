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
import pageFactory.toDo.ToDoPage;

public class ToDoList {
    WebDriver driver = null;
    ToDoPage toDoPage;

    @Before
    public void driverSetup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("window-size=1400,2100");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @Given("User in todo list page")
    public void user_in_todo_list_page() {
        driver.navigate().to("http://todomvc.com/examples/vue/");
    }

    @When("User Enter Todo item and press enter")
    public void user_enter_todo_item_and_press_enter() {
        toDoPage = PageFactory.initElements(driver,ToDoPage.class);
        toDoPage.setTodo("Test123");
    }

    @Then("User should be able to create a to do item")
    public void user_should_be_able_to_create_a_to_do_item() {

    }
    @And("Refresh the page")
    public void refresh_the_page() {

    }
    @Then("User should be able to see previously created item")
    public void user_should_be_able_to_see_previously_created_item() {

    }

    @When("user double click on existing item")
    public void user_double_click_on_existing_item() {

    }
    @And("Edit existing text")
    public void edit_existing_text() {

    }
    @Then("Edited text should be displayed")
    public void edited_text_should_be_displayed() {

    }

    @After
    public void driverQuit(){
//        driver.quit();
    }
}
