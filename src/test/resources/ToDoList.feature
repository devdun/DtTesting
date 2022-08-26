Feature: todo list

  @Create
  Scenario: Verify can create ToDo item item left count
    Given User in todo list page
    When User Enter Todo item and press enter
    Then User should be able to create a to do item
    And Refresh the page
    Then User should be able to see previously created item

  @Edit
  Scenario: Verify edit ToDo item
    Given User in todo list page
    When user double click on existing item
    And Edit existing text
    Then Edited text should be displayed
#
#  @Complete
#  Scenario: Verify complete ToDo item and item left count
#
#  @CreateMultiple
#  Scenario: Verify create multiple Todo items and item left count
#
#  @RemoveIncompleteItem
#  Scenario: Verify remove incomplete ToDo item and item left  count
#
#  @RemoveCompletedItem
#  Scenario: Verify can remove completed ToDo item and item left count
#
#  Scenario Outline: Create ToDo item
#    Given login to chrome
#    When Enter User name password
#    Then login
#
#    Examples:
#
#      | username | password  |
#      | User1    | password1 |
#      | User2    | password2 |
#      | User3    | password3 |