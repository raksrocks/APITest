#Author: Rakesh S

@StepOne
Feature: Creates a Customer account provided the input
  Create a customer with given details

  @CreateWithDataTable
  Scenario: Create a customer account
    Given URL available in the file
    And The customer data as
      | email           | password | firstName | lastName | title | 
      | abcd1@gmail.com | M@rV3l   | David     | Allen    | Mr    | 
      | efgh1@gmail.com | M@rV3l   |    sfsd   | Allen    | Mr    | 
      | steve@gmail.com | M@rV3l   |    Stephe | Allen    |       | 
      | rakes@gmail.com | M@rV3l   |           | Allen    | Mr    |
      | Phil@@gmail.com | M@rV3l   |    Phil   | Lname    | Dr    |
      | Pil@..gmail.com | M@rV3l   |    Phil   | Lname    | Dr    |
       
    When  send POST request to API
    Then verify the Status for <email> as <status>

 Examples: 
      | email | status |
      | abcd1@gmail.com | success |
      | efgh1@gmail.com | success |
      | steve@gmail.com | success |
      | rakes@gmail.com | error   |
      | Phil@@gmail.com | error   |
      | Pil@..gmail.com | error   |
      
  @CreateWithOutline
  Scenario Outline: Create a customer account by calling API
  Given URL available in the file
  When I give <email> and <password> and <firstName> and <lastName> and <title>
  Then the result should be <statusCode>
  
  Examples:
      | email           | password | firstName | lastName | title | statusCode     |
      | abcd1@gmail.com | M@rV3l   | David     | Allen    | Mr    | success        |
      | efgh1@gmail.com | M@rV3l   |    sfsd   | Allen    | Mr    | success        |
      | efgh1@gmail.com |          |           | Allen    | Mr    | Missing mandatory data    |
      | steve@..gmail.com | M@rV3l |    Stephe | Allen    | Rev   | Error! Database insertion crashed, looks like we have a bug here |
      
    