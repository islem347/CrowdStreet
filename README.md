# CrowdStreet

Test automation for "Create an Account" feature 

I used Cucumber BDD Framework and Selenium WebDriver to automate the webpage.

In order to make the code readable and easy to maintain, I implement Page Object Model Design pattern where I created Specific java class for the corresponding webpage.
I also created an abstract BasePage where I store the WebElements that are common for the different Web Pages and I used PageFactory class in order to instantiate the elements by using @FindBy annotation and link to the Driver instance.

I have my scenario written in gherkin language in the feature file to make it very clear and understandable by the non-technical team
My scenarios are linked to my Runner class as well as the step definition package in order to implement the steps and the execution of the test 

Also, I have a utilities package where I have my Driver class that can run on chrome or Firefox locally.
And I have created a configuration Reader class that can access and read my data stored in configuration properties such us the type of browser, the URL and the password.

In order to run the test, we can run from the runner class, where I can specify which scenario to run by using Tags.
Where also I can add different plugins to have multiple reports such us HTML reports or Cucumber reports  

I usede JavaFaker dependency in order to enter fake data needed to create a new account, except for the password in order to meet the requirement of the password.

Thank you for reading and feel free to add any changes.






