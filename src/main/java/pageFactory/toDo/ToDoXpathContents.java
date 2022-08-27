package pageFactory.toDo;

public class ToDoXpathContents {
    public static final String TODO_INPUT = "//header/input";
    public static final String ITEM_LEFT_COUNT = "//span[@class='todo-count']//strong";
    public static final String ALL_LINK_TEXT= "All";
    public static final String ACTIVE_LINK_TEXT= "Active";
    public static final String COMPLETED_LINK_TEXT= "Completed";
    public static final String CLEAR_COMPLETED_LINK_TEXT= "//button[@class='clear-completed']";
    public static final String TODO_LIST_ITEM= "//li//div[@class='view']";
    public static final String LIST_CHECKBOXES= "//li//input[@type='checkbox']";
    public static final String EDIT_TODO_ITEM= "//li[@class='todo editing']//input[@class='edit']";
    public static final String LIST_ITEMS_TODO = "//li[@class='todo']//label";
    public static final String LIST_ITEMS_COMPLETED= "//li[@class='todo completed']//label";
    public static final String DELETE_ITEM= "//button[@class='destroy']";
    public static final String FILTER_PANEL= "//ul[@class='filters']";
}
