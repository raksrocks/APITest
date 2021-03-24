#Author: Rakesh S

@StepTwo
Feature: Get Customer account by email address
	Get Customer account by email address
	
	@GetCustomer
	Scenario: GetAPI Customer Account
		Given: URL available in the file
		When getCustomer API is called with <email> 
		Then customerId <customerId> is returned
		 
	Examples:
			| email           | customerId      |
	 		| abcd1@gmail.com | abcd1@gmail.com |
      | efgh1@gmail.com | efgh1@gmail.com |
      | steve@gmail.com | steve@gmail.com |
      | rakes@gmail.com | rakes@gmail.com   |
      | Phil@@gmail.com | Phil@@gmail.com   |
      | Pil@..gmail.com | Pil@..gmail.com   |
      |                 | Missing Authentication Token |

    