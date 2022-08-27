package pageFactory.toDo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedList;
import java.util.List;


public class ToDoPage {
    public WebDriver driver;

    public ToDoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ToDoXpathContents.TODO_INPUT)
    private WebElement todoInput;

    @FindBy(partialLinkText = ToDoXpathContents.ALL_LINK_TEXT)
    private WebElement allListBtn;

    @FindBy(partialLinkText = ToDoXpathContents.ACTIVE_LINK_TEXT)
    private WebElement activeListBtn;

    @FindBy(partialLinkText = ToDoXpathContents.COMPLETED_LINK_TEXT)
    private WebElement completedListBtn;

    @FindBy(xpath = ToDoXpathContents.CLEAR_COMPLETED_LINK_TEXT)
    private WebElement clearCompletedListBtn;

    @FindBy(xpath = ToDoXpathContents.ITEM_LEFT_COUNT)
    private WebElement itemLeftCount;

    @FindBy(xpath = ToDoXpathContents.TODO_LIST_ITEM)
    private WebElement toDoItemList;

    @FindBy(xpath = ToDoXpathContents.EDIT_TODO_ITEM)
    private WebElement editToDoItem;

    public void setTodo(String todoText) {
        todoInput.clear();
        todoInput.sendKeys(todoText);
        todoInput.sendKeys(Keys.ENTER);
    }

    public void clickAllBtn() {
        allListBtn.click();
    }

    public void clickActiveBtn() {
        activeListBtn.click();
    }

    public void clickCompletedBtn() {
        completedListBtn.click();
    }

    public void clickClearCompletedBtn() {
        clearCompletedListBtn.click();
    }

    public void clickAllCheckboxes() {
        List<WebElement> checkboxes = driver.findElements(By.xpath(ToDoXpathContents.LIST_CHECKBOXES));
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }
    }

    public void clickSpecificCheckbox(int specificCheckBox) {
        List<WebElement> checkboxes = driver.findElements(By.xpath(ToDoXpathContents.LIST_CHECKBOXES));
        checkboxes.get(specificCheckBox).click();
    }

    public int getItemLeftCount() {
        return Integer.parseInt(itemLeftCount.getText());
    }

    public void doubleClickOnItem(int clickedItem) {
        Actions actionItem = new Actions(driver);
        List<WebElement> listItems = driver.findElements(By.xpath(ToDoXpathContents.TODO_LIST_ITEM));
        actionItem.moveToElement(listItems.get(clickedItem)).doubleClick().build().perform();
    }

    public String getTodoItemValue(int getTodoItemValue) {
        List<WebElement> listItems = driver.findElements(By.xpath(ToDoXpathContents.TODO_LIST_ITEM));
        return listItems.get(getTodoItemValue).getText();
    }

    public List<String> getItemValues() {
        List<WebElement> listItems = driver.findElements(By.xpath(ToDoXpathContents.TODO_LIST_ITEM));
        List<String> myList = new LinkedList<>();
        for (WebElement listItem : listItems) {
            myList.add(listItem.getText());
        }
        return myList;
    }

    public void editItem(int editItem,String editText) {
        this.doubleClickOnItem(editItem);
        editToDoItem.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        editToDoItem.sendKeys(editText);
        editToDoItem.sendKeys(Keys.ENTER);
    }

    public void deleteToDoItem(int deleteItem) {
        List<WebElement> listItems = driver.findElements(By.xpath(ToDoXpathContents.LIST_ITEMS_TODO));
        List<WebElement> deleteItems = driver.findElements(By.xpath(ToDoXpathContents.DELETE_ITEM));
        new Actions(driver)
                .moveToElement(listItems.get(deleteItem))
                .perform();
        deleteItems.get(deleteItem).click();
    }

    public void deleteCompletedItem(int deleteCompletedItem) {
        List<WebElement> listItems = driver.findElements(By.xpath(ToDoXpathContents.LIST_ITEMS_COMPLETED));
        List<WebElement> deleteItems = driver.findElements(By.xpath(ToDoXpathContents.DELETE_ITEM));
        new Actions(driver)
                .moveToElement(listItems.get(deleteCompletedItem))
                .perform();
        deleteItems.get(deleteCompletedItem).click();
    }

    public boolean visibilityOfFilterPanel(){
       return driver.findElement(By.xpath(ToDoXpathContents.FILTER_PANEL)).isDisplayed();
    }
}
