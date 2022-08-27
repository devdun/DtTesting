Feature: todo list

  Background:
    Given User in todo list page

  @Create
  Scenario: Verify can create single ToDo item item left count
    When User Enter Todo item and press enter
      | Todo_item 0 |
    Then User should be able to create a to do item
    And Item count should be 1

  @CreateMultiple
  Scenario: Verify create multiple Todo items and item left count
    When User Enter Todo item and press enter
      | Todo_item @CreateMultiple Test 0 |
      | Todo_item @CreateMultiple Test 1 |
      | Todo_item @CreateMultiple Test 2 |
      | Todo_item @CreateMultiple Test 3 |
    Then Refresh the page and check
      | Todo_item @CreateMultiple Test 0 |
      | Todo_item @CreateMultiple Test 1 |
      | Todo_item @CreateMultiple Test 2 |
      | Todo_item @CreateMultiple Test 3 |


  @Edit
  Scenario: Verify edit ToDo item
    When User Enter Todo item and press enter
      | Todo_item @Edit Test 0 |
      | Todo_item @Edit Test 1 |
    Then user double click on existing item 1 and edit
    Then Edited text should be displayed

  @Complete
  Scenario: Verify complete ToDo item and item left count change accordingly
    When User Enter Todo item and press enter
      | Todo_item @Complete Test 0 |
      | Todo_item @Complete Test 1 |
      | Todo_item @Complete Test 2 |
      | Todo_item @Complete Test 3 |
    Then User tick to complete ToDo items
    Then Item left count change to 0 accordingly
    And completed items display under completed tab
      | Todo_item @Complete Test 0 |
      | Todo_item @Complete Test 1 |
      | Todo_item @Complete Test 2 |
      | Todo_item @Complete Test 3 |

  @RemoveIncompleteItem
  Scenario: Verify remove an incomplete ToDo item and item left count change accordingly
    When User Enter Todo item and press enter
      | Todo_item @RemoveIncompleteItem Test 0 |
      | Todo_item @RemoveIncompleteItem Test 1 |
    Then User delete an todo item 0
    Then Deleted item should not displayed
      | Todo_item @RemoveIncompleteItem Test 0 |

  @RemoveCompletedItem
  Scenario: Verify can remove completed ToDo item and item left count not affected
    When User Enter Todo item and press enter
      | Todo_item @RemoveCompletedItem Test 0 |
      | Todo_item @RemoveCompletedItem Test 1 |
    Then User tick 0 checkbox to complete ToDo item
    Then User delete an completed item 0

    @AllActiveCompleted
      Scenario: Verify user can see correct items under correct lists
      When User Enter Todo item and press enter
        | Todo_item @AllActiveCompleted Test 0 |
        | Todo_item @AllActiveCompleted Test 1 |
        | Todo_item @AllActiveCompleted Test 3 |
        | Todo_item @AllActiveCompleted Test 4 |
      Then User tick 0 checkbox to complete ToDo item
      Then User navigate to "All" list and check count is 4
      And User navigate to "Active" list and check count is 3
      And User navigate to "Completed" list and check count is 1

  @ClearCompletedItem
  Scenario: Verify can Clear completed ToDo items and item left count not affected
    When User Enter Todo item and press enter
      | Todo_item @ClearCompletedItem Test 0 |
      | Todo_item @ClearCompletedItem Test 1 |
    Then User tick to complete ToDo items
    Then User click clear completed button to clear all
    Then Filter class should be "invisible"

