package com.amplience;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class GitHubPageTest {

    private WebDriver driver;
    private String baseUrl;

    @BeforeClass
    public void setUp() {
        // Set the path to the edgedriver executable
        System.setProperty("webdriver.edge.driver", "C:/Program Files/msedgedriver.exe");

        // Creates a new instance of the EdgeDriver
        driver = new EdgeDriver();

        // Sets the base URL
        baseUrl = "https://github.com";
    }

    @Test
    public void testGitHubPage() {
        // Navigates to the user's GitHub page
        driver.get(baseUrl + "/6wl");

        // Verifies that the name is correct
        WebElement nameElement = driver
                .findElement(By.xpath("//span[@class='p-name vcard-fullname d-block overflow-hidden']"));
        String name = nameElement.getText();
        Assert.assertEquals(name, "Gregory Loscombe");

        WebElement locationElement = driver.findElement(By.xpath("//span[@class='p-label']"));
        String location = locationElement.getText();
        Assert.assertEquals(location, "Manchester");

        WebElement reposElement = driver
                .findElement(By.xpath("//a[@href='/6wl?tab=repositories']//span[@class='Counter']"));
        String repos = reposElement.getText();
        // part 1 states 6 but part 2 states 7, I've left it to highlight a test failure
        // as the github profile only has 6 repos
        Assert.assertEquals(repos, "7");

        WebElement gistsElement = driver.findElement(By.xpath("//a[@href='/6wl?tab=gists']//span[@class='Counter']"));
        String gists = gistsElement.getText();
        Assert.assertEquals(gists, "11");

        WebElement followersElement = driver
                .findElement(By.xpath("//a[@href='/6wl/followers']//span[@class='Counter']"));
        String followers = followersElement.getText();
        Assert.assertEquals(followers, "21");

        WebElement followingElement = driver
                .findElement(By.xpath("//a[@href='/6wl/following']//span[@class='Counter']"));
        String following = followingElement.getText();
        Assert.assertEquals(following, "34");
    }

    @AfterClass
    public void tearDown() {
        // Closes the browser window
        driver.quit();
    }
}
