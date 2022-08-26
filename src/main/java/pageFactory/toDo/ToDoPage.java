package pageFactory.toDo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonOperations;

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

    @FindBy(partialLinkText = ToDoXpathContents.ITEM_LEFT_COUNT)
    private WebElement itemLeftCount;

    public void setTodo(String todoText){
        todoInput.clear();
        todoInput.sendKeys(todoText);
        todoInput.sendKeys(Keys.ENTER);
    }

    public void clickAllBtn(){
        allListBtn.click();
    }

    public void clickActiveBtn(){
        activeListBtn.click();
    }

    public void clickCompletedBtn(){
        completedListBtn.click();
    }

    public void clickClearCompletedBtn(){
        clearCompletedListBtn.click();
    }

    public void clickAllCheckboxes(){
        List<WebElement> checkboxes = driver.findElements(By.xpath("//li//input[@type='checkbox']"));
        for (WebElement checkbox : checkboxes) {
//            String value = checkboxes.get(i).getAttribute("value");
            checkbox.click();
        }
    }

    public String getItemLeftCount(){
        return itemLeftCount.getText();
    }
}
