package pageFactory.toDo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonOperations;

public class ToDoPage {
    public WebDriver driver;
    private CommonOperations commonOperations;

    public ToDoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        commonOperations = new CommonOperations(null);
    }

   @FindBy(xpath = ToDoXpathContents.TODO_INPUT)
    private WebElement todoInput;

    public void setTodo(String todoText){
        todoInput.clear();
        todoInput.sendKeys(todoText);
        todoInput.sendKeys(Keys.ENTER);
    }
}
