package Base;

import Report.ExtentReportManager;
import drivers.ChromeDriverManager;
import drivers.DriverManager;
import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;


public class BaseTest {
    @BeforeClass
    public void BeforeClass(){
        DriverManager driverManager = new ChromeDriverManager();
        driverManager.createWebDriver();

        WebDriver driver = driverManager.getDriver();
        DriverFactory.setDriverThreadLocal(driver);
    }

    @BeforeMethod
    public void BeforeMethod(Method method){
        //khởi tạo testcase trong extent rerport
        //getName() trả về tên của method đang được gọi
        ExtentReportManager.createTest(method.getName());
    }

    @AfterMethod
    public void AfterMethod(ITestResult testResult){
        if(testResult.getStatus() == ITestResult.FAILURE){
            //capture screenshot khi test fail
            ExtentReportManager.captureScreenshot(DriverFactory.getDriver(), testResult.getMethod().getMethodName());
            //ghi lỗi vào extent report
            ExtentReportManager.fail(testResult.getThrowable().toString());
        }
    }

    @AfterClass
    public void AfterClass(){
        WebDriver driver = DriverFactory.getDriver();
        if(driver != null){
            driver.quit();
        }
        DriverFactory.removeDriver();
    }
}
