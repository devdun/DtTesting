Feature: todo list

  Background:
    Given User in todo list page

  @Create
  Scenario: Verify can create single ToDo item item left count
    When User Enter Todo item and press enter
      |Todo_item 0|
    Then User should be able to create a to do item
    And Refresh the page
    Then User should be able to see previously created item

  @CreateMultiple
  Scenario: Verify create multiple Todo items and item left count
    When User Enter Todo item and press enter
      |Todo_item @CreateMultiple Test 0|
      |Todo_item @CreateMultiple Test 1|
      |Todo_item @CreateMultiple Test 2|
      |Todo_item @CreateMultiple Test 3|

  @Edit
  Scenario: Verify edit ToDo item
    When User Enter Todo item and press enter
      |Todo_item @Edit Test 0|
      |Todo_item @Edit Test 1|
    Then user double click on existing item and edit
    Then Edited text should be displayed

  @Complete
  Scenario: Verify complete ToDo item and item left count change accordingly
    When User Enter Todo item and press enter
      |Todo_item @Complete Test 0|
      |Todo_item @Complete Test 1|
      |Todo_item @Complete Test 2|
      |Todo_item @Complete Test 3|
  Then User tick to complete ToDo items
  Then Item left count change accordingly


#  @RemoveIncompleteItem
#  Scenario: Verify remove incomplete ToDo item and item left count change accordingly
#
#  @RemoveCompletedItem
#  Scenario: Verify can remove completed ToDo item and item left count not affected
#
#  @ClearCompletedItem
#  Scenario: Verify can Clear completed ToDo items and item left count not affected
#
