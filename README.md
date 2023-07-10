
A small Spring MVC web app with REST API.
# Features

- Spring MVC application

- Forms
	- "/createuser" has a form for user input.
	- "userform.html" template inside src/main/resources has 3 fields: name, email, age

- Form Validation
	- "Player.java" has implemented validation for the fields 
	- "WelcomeController.java" checks for valid post data in 
	- @PostMapping("/createuser")public String createPlayer(){...}

- Form Data Persistence
	- "WelcomeController.java" checks for valid post data in 
	@PostMapping("/createuser")public String createPlayer(){...} and 
	saves it to the database in cloud if it is valid. 
	- "/allusers" shows the persisting user data in a table.

- A page that users can go to that lists the items created from the form in requirement 1 using Templates/Thymeleaf
	- "/allusers" to view all created list items.
	- "allusers.html" template inside src/main/resources implements the functionality.

- List Filtering
	- "/findbyage?age=25" filters the list by age

- API Information
	- "/currentcount" returns the number of page hits since the server was online
    - This api is called asynchronously every 3 seconds and the results displayed on every page
	- All the html templates inside src/main/resources except "saved.html" calls the api asynchronously
	and every html templates displays the counter.

- Dependency Injection
	"PlayerRespistory.java" and "PageCounter.java" are injected
	in "WelcomeController.java" and "PageCountController" inside src/main/java

- Use of Lombok
	- "Player.java" inside src/main/java implements lombok
 
- Unit tests for Classes
	- "WelcomeControllerTest.java" and "PageCountController" in src/test/java