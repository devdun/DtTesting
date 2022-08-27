package pageFactory.toDo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(partialLinkText = ToDoXpathContents.CLEAR_COMPLETED_LINK_TEXT)
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

    public String getItemLeftCount() {
        return itemLeftCount.getText();
    }

    public void doubleClickOnItem() {
        Actions actionItem = new Actions(driver);
        List<WebElement> listItems = driver.findElements(By.xpath(ToDoXpathContents.TODO_LIST_ITEM));
        actionItem.moveToElement(listItems.get(3)).doubleClick().build().perform();
    }

    public void editItem() {
        this.doubleClickOnItem();
        editToDoItem.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        editToDoItem.sendKeys("Edited test");
        editToDoItem.sendKeys(Keys.ENTER);
    }

    public void deleteItem(int deleteItem) {
        List<WebElement> listItems = driver.findElements(By.xpath(ToDoXpathContents.LIST_ITEMS));
        List<WebElement> deleteItems = driver.findElements(By.xpath(ToDoXpathContents.DELETE_ITEM));
        new Actions(driver)
                .moveToElement(listItems.get(deleteItem))
                .perform();
        deleteItems.get(deleteItem).click();
    }
}
