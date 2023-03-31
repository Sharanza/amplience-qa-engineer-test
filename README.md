# How to Run Amplience API and GitHub Page Test

## This project contains two tests:

AmplienceAPITest: This test validates the response of a RESTful API endpoint and checks the status code, headers, and body of the response.

GitHubPageTest: This test navigates to a user's GitHub page and checks if certain elements, such as the user's name, location, repositories, gists, followers, and following, are present and correct.

### To run these tests, you will need the following installed on your system:

* Java Development Kit (JDK)
* Apache Maven
* EdgeDriver (Microsoft Edge webdriver)

### Step 1: Clone the Repository

Clone the repository using Git:

`git clone https://github.com/Sharanza/amplience-qa-engineer-test.git`

### Step 2: Install Dependencies

Navigate to the root directory of the project and run the following command to install the dependencies:

`mvn install`

### Step 3: Run Amplience API Test

To run the Amplience API test, execute the following command:

`mvn test -Dtest=AmplienceAPITest`

The output should display the status of the test, along with any errors or failures.

### Step 4: Run GitHub Page Test

Before running the GitHub Page test, make sure that the EdgeDriver executable is located in the correct directory (in this case, `C:/Program Files/msedgedriver.exe`). If it is not, update the `setProperty()` method in the `setUp()` method of the `GitHubPageTest` class to point to the correct location.

To run the GitHub Page test, execute the following command:

`mvn test -Dtest=GitHubPageTest`

The output should display the status of the test, along with any errors or failures.

Note: If you encounter any issues while running the tests, please ensure that all dependencies are installed correctly and that the paths are set up correctly.