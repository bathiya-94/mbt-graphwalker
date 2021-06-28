package com.mbtroads;

import org.graphwalker.core.machine.ExecutionContext;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ArticleCreationTest extends ExecutionContext implements ArticleCreationModel {
    String appTitle = "";

    String pageHeading = "";

    private static WebDriver driver;


    String alertMessage = "";

    String expectedTitle = "Knowledgebase";

    @Override
    public void e_OpenApp() {
        System.out.println("Running: e_OpenApp: Opening Browser");
        driver.get("http://localhost:3002");
        appTitle = driver.getTitle();
        pageHeading = driver.findElement(By.tagName("h1")).getText();

    }

    @Override
    public void e_GoToAddArticlePage() {
        System.out.println("Running: e_GoToAddArticlePage(): Going to Add Articles");
        driver.findElement(By.name("AddArticle")).click();
        pageHeading = driver.findElement(By.tagName("h1")).getText();
    }

    @Override
    public void v_FailedArticleAddition() {
        System.out.println("Running: v_FailedArticleAddition");
        System.out.println("Page Title = " + pageHeading + " Alert Message = " + alertMessage);
        Assert.assertEquals("Add Article", pageHeading);
    }

    @Override
    public void e_Logout() {
        System.out.println("Running:e_Logout()");
        driver.findElement(By.name("Logout")).click();
        driver.get("http://localhost:3002/users/logout");
        pageHeading = driver.findElement(By.tagName("h1")).getText();
        System.out.println("Page Heading " + pageHeading);
    }

    @Override
    public void v_LogInPage() {
        System.out.println("Login Page; Page Title = " + pageHeading + " App Title = " + appTitle);
        Assert.assertEquals("Login", pageHeading);
    }

    @Override
    public void e_LoginWithValidCred() {
        System.out.println("Running: e_LoginWithValidCred: Right Credentials");
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("bathiya123");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.name("submit")).click();

        pageHeading = driver.findElement(By.tagName("h1")).getText();
    }

    @Override
    public void v_HomePage() {
        System.out.println("Running: v_HomePage");
        System.out.println("Home Page; Page Title = " + pageHeading + " App Title = " + appTitle);
        Assert.assertEquals("Articles", pageHeading);
        Assert.assertEquals(expectedTitle, appTitle);
    }


    @Override
    public void e_GoToSignedInHomePage() {
        System.out.println("Running: e_GoToSignedInHomePage()");
        driver.findElement(By.name("kb")).click();
        pageHeading = driver.findElement(By.tagName("h1")).getText();
    }

    @Override
    public void e_ArticleAddtionWithoutData() {
        System.out.println("Running: e_ArticleAddtionWithoutData()");
        driver.findElement(By.name("title")).clear();
        driver.findElement(By.name("title")).sendKeys("Model Based Testing");
        driver.findElement(By.name("body")).clear();
        driver.findElement(By.name("body")).sendKeys(" ");
        driver.findElement(By.name("submit")).click();

        pageHeading = driver.findElement(By.tagName("h1")).getText();
    }

    @Override
    public void v_SignedInHome() {
        System.out.println("Running: v_SignedInHome");
        System.out.println("Home Page; Page Title = " + pageHeading);
        Assert.assertEquals("Articles", pageHeading);
    }


    @Override
    public void v_AddArticle() {
        System.out.println("Running: v_AddArticle()");
        System.out.println("Home Page; Page Title = " + pageHeading);
        Assert.assertEquals("Add Article", pageHeading);
    }

    @Override
    public void v_FailedLogin() {
        System.out.println("Running: v_FailedLogin");
        System.out.println("Home Page; Page Title = " + pageHeading + " Alert Message = " + alertMessage);
        Assert.assertEquals("Login", pageHeading);
        Assert.assertEquals("Wrong password", alertMessage);
    }

    @Override
    public void v_Start() {
        System.out.println("Running: v_Start");
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Override
    public void e_GoToHomePage() {
        System.out.println("Running: GoToHomePage()");
        driver.get("http://localhost:3002/");
        pageHeading = driver.findElement(By.tagName("h1")).getText();

    }

    @Override
    public void e_GoToLogIn() {
        System.out.println("Running: e_GotoLogIn: Going to LogIn");
        driver.get("http://localhost:3002/users/login");
        pageHeading = driver.findElement(By.tagName("h1")).getText();

    }

    @Override
    public void e_GoToLogin() {
        System.out.println("Running: e_GotoLogIn: Going to LogIn");
        driver.get("http://localhost:3002/users/login");
        pageHeading = driver.findElement(By.tagName("h1")).getText();
    }

    @Override
    public void e_LoginWrongCred() {
        System.out.println("Running: e_LoginWrongCred: Bad credentials");
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("bathiya123");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("23");
        driver.findElement(By.name("submit")).click();

        pageHeading = driver.findElement(By.tagName("h1")).getText();
        alertMessage = driver.findElement(By.className("alert-error")).getText();
        System.out.println("Alert Message: " + alertMessage);
    }

    @Override
    public void e_AddNewArticle() {
        System.out.println("Running: e_AddNewArticle(): Adding new article with title and body");
        driver.findElement(By.name("title")).clear();
        driver.findElement(By.name("title")).sendKeys("Model Based Testing");
        driver.findElement(By.name("body")).clear();
        driver.findElement(By.name("body")).sendKeys("Graphwalker + Selenium");
        driver.findElement(By.name("submit")).click();

        pageHeading = driver.findElement(By.tagName("h1")).getText();

    }
}
