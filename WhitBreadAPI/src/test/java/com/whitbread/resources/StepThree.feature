#Author: Rakesh S

@StepThree
Feature: Get Customer account by email address
	Get Customer account by email address
	
	@GetCustomer
	Scenario: Delete Customer Account
		Given: URL available in the file
		When deleteCustomer API is called with <email> 
		Then <response> is deleted
		 
	Examples:
			| email           | response      |
	 		| abcd1@gmail.com | true |
      | efgh1@gmail.com | true |
      | steve@gmail.com | true |
      | rakes@gmail.com | true   |
      | Phil@@gmail.com | true   |
      | Pil@..gmail.com | true   |
      |                 | Missing Authentication Token |

    