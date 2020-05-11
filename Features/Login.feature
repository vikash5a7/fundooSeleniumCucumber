Feature: Login

  @sanity
  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome browser
    When User opens URL "http://localhost:4200/login"
    And User enters Email as "vikashkumargupta5a7@gmail.com" and Password as "vikash"
    And Click on Login
    Then Page Title should be "Fundoo Note Dashboard"
    When User click on Log out link
    Then Page Title should be "Fundoo Notes"
    And close browser

 @sanity
	Scenario Outline: Login with DDT
		Given User Launch Chrome browser
    When User opens URL "http://localhost:4200/login"
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page Title should be "Fundoo Note Dashboard"
    When User click on Log out link
    Then Page Title should be "Fundoo Notes"
    And close browser
    
    Examples: 
      | email  | password |
      | vikashkumargupta5a7@gmail.com | vikash1    		|
      | vikashkumar1@gmail.com  			| vikashkumar   |
      | vikashkumargupta5a7@gmail.com |	vikas    			|
      | 				 											| vikash1			  |
      | vikashkumargupta5a7@gmail.com | vikash1    		|
      | vikashkumargupta5a7@gmail.com | 				   		|
     
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      