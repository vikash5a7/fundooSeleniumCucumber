Feature: Register

	@sanity
  Scenario Outline: Registration in fundoo
  	Given User Launch Chrome browser
    When User opens URL "http://localhost:4200/login"
    Then user click on registration button
    And User enters first name as "<fname>" and last name as "<lname>"
    And user enter email as "<email>"
    And enter user his password as "<password>" and confimation password as "<confirmation>" 
    And User should enter his phone number as "<number>"
    And User Click on sumbmit button
    Then close browser
    
    Examples: 
      | fname  | lname |      email     						| password 	| confirmation | number   |
      | vikash |kumar  | vikashjasdfs2@gmail.com		| rakesh12 	| rakesh12     |9140909090|
      | xyz 	 |jkasd  | email@gmail.com						| rakesh12 	| raemsh1      |909090909 |
      |     	 |jkasd  | email@gmail.com						|          	| raemsh1      |909090909 |
      | xyz 	 |jkasd  | email@gmail.com						| rakesh12 	| raemsh1      |909090909 |
      | xyz 	 |jkasd  | email@gmail.com						| rakesh12 	| raemsh1      |909090909 |
      | xyz 	 |jkasd  | email@gmail.com						| rakesh12 	| raemsh1      |          |
      | xyz 	 |jkasd  | email@gmail.com						| rakesh12 	|              |909090909 |
      
      
