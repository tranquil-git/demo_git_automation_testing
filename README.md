## Project Structure
```
demo_git_automation_testing/
├── src/main/java/
│   ├── Base/
│   │   ├── BasePage.java
│   │   └── BaseTest.java
│   ├── Constant/
│   │   └── TimeOutConstants.java
│   ├── Listeners/
│   │   └── TestListener.java
│   ├── Report/
│   │   └── ExtentReportManager.java
│   ├── drivers/
│   │   ├── DriverFactory.java
│   │   ├── DriverManager.java
│   │   ├── EdgeDriverManager.java
│   │   └── ChromeDriverManager.java
│   └── page/
│       └── LoginPage.java
├── src/test/java/
│   └── testcases/
│       └── LoginTest.java
└── src/test/resources/
    ├── log4j2.xml
    └── regression.xml
```
