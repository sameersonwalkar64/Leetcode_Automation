package demo;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.util.test.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }
    public static void log(boolean element ,String mess1, String mess2)  {
        String log = element? mess1: mess2;
        System.out.println(log);
    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");

    // verify URL of Leetcode
        driver.get("https://leetcode.com/");
        String URL = driver.getCurrentUrl();
        System.out.println(URL);
        boolean containLeetcode = URL.contains("leetcode");
        // String log = containLeetcode ? "URL containd leetcode": "URL does not contains leetcode";
        TestCases.log(containLeetcode,"URL containd leetcode","URL does not contains leetcode");
        // System.out.println(log);


    
        System.out.println("end Test case: testCase01");
    }

    public void textCase02() throws InterruptedException  {
        System.out.println("Start Test case: testCase02");
        driver.get("https://www.google.com");
        driver.get("https://leetcode.com/");

    // verify View question button display or not on view question button
        WebElement viewQuestionButton = driver.findElement(By.xpath("//p[text()='View Questions ']"));
        boolean viewQuestionButtonDisplayedORNOt = viewQuestionButton.isDisplayed();
        TestCases.log(viewQuestionButtonDisplayedORNOt,"View question button is display","View question button is not display");

    // verify veiw button clickable not not
        boolean verifyViewQuestionButtonCkickable = viewQuestionButton.isEnabled();
        TestCases.log(verifyViewQuestionButtonCkickable,"View question button is clickble","View question button is not clickble");

    // clicking on view question button
        viewQuestionButton.click();
        Thread.sleep(2000);
    // verify ulr contains problemset or not
        String URLContainsPrroblemset = driver.getCurrentUrl();
        boolean verifyProblemSetUrl = URLContainsPrroblemset.contains("problemset");
        TestCases.log(verifyProblemSetUrl,"URL contains problemset","URL not containing problemset");

    // retriving details of 1st five questons
        List<WebElement> questionList = driver.findElements(By.xpath("//div[@role='rowgroup']//div/div[@class='truncate']/a"));


        for(int i=1; i<6; i++)  {
            //div[@role='rowgroup']//div/div[@class='truncate']/a
            // WebElement titleElement = driver.findElement(By.xpath("./div[@class='truncate']/a"));
            String questionTitle = questionList.get(i).getText();
            System.out.println(questionTitle);
            
        }
    
    //  clicking on 1st question and verify same question url
        WebElement Question_1st = questionList.get(1);
        String title=Question_1st.getText();
        System.out.println(title);
        Question_1st.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flex items-start gap-2']//div/a")));

        String title1 = driver.findElement(By.xpath("//div[@class='flex items-start gap-2']//div/a")).getText();
        System.out.println(title1);
        boolean verifyTitle = title.contains(title1);
        TestCases.log(verifyTitle, "Question have same title after click on question", "Question haven't same title after click on question");
        System.out.println("end Test case: testCase02");

    }
    public void testCase03() throws InterruptedException  {
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.google.com");
        driver.get("https://leetcode.com/");

    // verify View question button display or not on view question button
        WebElement viewQuestionButton = driver.findElement(By.xpath("//p[text()='View Questions ']"));
        boolean viewQuestionButtonDisplayedORNOt = viewQuestionButton.isDisplayed();
        TestCases.log(viewQuestionButtonDisplayedORNOt,"View question button is display","View question button is not display");

    // verify veiw button clickable not not
        boolean verifyViewQuestionButtonCkickable = viewQuestionButton.isEnabled();
        TestCases.log(verifyViewQuestionButtonCkickable,"View question button is clickble","View question button is not clickble");

    // clicking on view question button
        viewQuestionButton.click();
        Thread.sleep(4000);
    // verify ulr contains problemset or not
        String URLContainsPrroblemset = driver.getCurrentUrl();
        boolean verifyProblemSetUrl = URLContainsPrroblemset.contains("problemset");
        TestCases.log(verifyProblemSetUrl,"URL contains problemset","URL not containing problemset");

    // clicking on two sum problem
        WebElement twoSumElement= driver.findElement(By.xpath("//a[text()='Two Sum']"));
        twoSumElement.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flex items-start gap-2']//div/a")));

    // verify url contain
        String url = driver.getCurrentUrl();
        boolean verifyURLContain = url.contains("two-sum");
        TestCases.log(verifyURLContain,"URL containing two_sum","URL containing two_sum");

        System.out.println("end Test case: testCase03");

    }
    public void testCase04() throws InterruptedException  {
        System.out.println("Start Test case: testCase04");
        driver.get("https://www.google.com");
        driver.get("https://leetcode.com/");

        // verify View question button display or not on view question button
        WebElement viewQuestionButton = driver.findElement(By.xpath("//p[text()='View Questions ']"));
        boolean viewQuestionButtonDisplayedORNOt = viewQuestionButton.isDisplayed();
        TestCases.log(viewQuestionButtonDisplayedORNOt,"View question button is display","View question button is not display");

    // verify veiw button clickable not not
        boolean verifyViewQuestionButtonCkickable = viewQuestionButton.isEnabled();
        TestCases.log(verifyViewQuestionButtonCkickable,"View question button is clickble","View question button is not clickble");

    // clicking on view question button
        viewQuestionButton.click();
        Thread.sleep(4000);
    // verify ulr contains problemset or not
        String URLContainsPrroblemset = driver.getCurrentUrl();
        boolean verifyProblemSetUrl = URLContainsPrroblemset.contains("problemset");
        TestCases.log(verifyProblemSetUrl,"URL contains problemset","URL not containing problemset");

    // clicking on two sum problem
        WebElement twoSumElement= driver.findElement(By.xpath("//a[text()='Two Sum']"));
        twoSumElement.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flex items-start gap-2']//div/a")));

    // verify url contain
        String url = driver.getCurrentUrl();
        boolean verifyURLContain = url.contains("two-sum");
        TestCases.log(verifyURLContain,"URL containing two_sum","URL containing two_sum");

    // Verify submission button visiable and clickable
        WebElement submissionButtonElement = driver.findElement(By.xpath("//div[@class='normal absolute left-0 top-0 whitespace-nowrap font-normal' and text()='Submissions']"));

        Boolean submissionButtonDisplayed = submissionButtonElement.isDisplayed();
        TestCases.log(submissionButtonDisplayed,"Submission button is Displayed","Submission button is Displayed");

        Boolean submissionButtonIsClickable = submissionButtonElement.isEnabled();
        TestCases.log(submissionButtonIsClickable,"Submission Button is clickable","Submission Button is clickable");
        submissionButtonElement.click();

    // Verify Register and Sign in Button displayed
    // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement resisterAndSignInElement = driver.findElement(By.xpath("//a[@href='/accounts/login/?next=%2Fproblems%2Ftwo-sum%2Fsubmissions%2F']"));
        wait.until(ExpectedConditions.visibilityOf(resisterAndSignInElement));
        Boolean resisterAndSignInDisplayed = resisterAndSignInElement.isDisplayed();
        TestCases.log(resisterAndSignInDisplayed,"Resister and Sign In Button Displayed","Resister and Sign In Button is not Displayed");
        String buttonMessage=resisterAndSignInElement.getText();
        Boolean isTextDisplayed=buttonMessage.equals("Register or Sign In");
        TestCases.log(isTextDisplayed, "Register and sign in button text is displayed", "Register and sign in button text is not displayed");
        System.out.println("end Test case: testCase04");
    }


}

