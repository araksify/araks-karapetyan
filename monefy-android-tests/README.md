### A list of ideas/bullet points I would test for

|Test                                                                    | Priority*   |Automation Suite |
|---------------------------------------------------------------------------|---------------|---------|
|Add an expense using built in calculator | High | Smoke, Regression  |
|Add an income using built in calculator |High | Smoke, Regression |
|Verify categories for income|High|Regression|
|Add expenses via quick category options | High | Smoke, Regression |
|Search a record using note |High|Smoke, Regression|
|Search a record using category name |Moderate| Regression |
|Make a record for a specific date|High|Regression|
|Add an expense or income with various amounts|Moderate|Regression|
|Verify balance after adding income and expense| High| End2End
|Access to paid features|High| Regression
|Verify available accounts on left menu|Moderate|Regression|
|Verify available accounts on account settings|Moderate|Regression|
|Add an account from settings editing available fields|High|Regression|
|Add an account and use that account to make a transfer|Moderate|End2End|
|Make a transfer from home screen|High|Smoke, Regression|
|Make a transfer from using specific date|High|Regression|
|Make a transfer from account section settings|Low|Regression|
|Add Budget Mode with valid amount|High|Regression|
|Add Budget with invalid number|Low|Regression|
|Add an expense and income for previous date, verify carry over feature|Moderate|End2End|
|Change language|Moderate|Regression|
|Change currency|High|Regression|
|Change first day of week|Moderate|Regression|
|Change first day of month, and verify transactions with monthly filter|Moderate|End2End|
|Verify reviewing application|High|Manual
|Verify Privacy Policy WebView|High|Regression|
|Verify Creating data backup|Moderate|Regression|
|Verify Restoring data|Moderate|Regression|
|Verify Clearing data|Low|Regression|
|Verify Period filters on left menu using rich backup file|Moderate|End2End|
|Choose specific date on date picker|High|Regression|
|Edit date entry on date picker|Low|Regression|
|Scroll home page to individual date|High|Regression|
|Verify data on app update |High| Manual|

**Setting priorities I considered the possible impact on the user and how frequently they gonna use it.


### More about automation suite pros and cons

| |Pros|Cons|
|---|---|---|
|**Regression Testing**|||
||Will cover most of the features in low level, preventing unexpected issues||
||Can be added to CI preventing issues on early stage|Maintenance needed with every related feature change|
**Smoke Testing**|||
||Time efficient and easy to verify in different environments|Does not have big coverage|
**End2End Testing**|||
||Covers the whole flow and makes sure features communicate accurately|Tests are complex, adds more time on debugging|
|||Maintenance needed regularly|
|||Costs more time on CI pipelines|
**Manual Testing** |||
||Can cover cases not possible to automate|Costs are higher running tests regularly|

  ### Automated Framework Setup
  For automating test cases I used Appium with Java, knowing it is the most common tech stack among mobile QA Engineers, and it has a lot of community support. It's also open source which makes it possible to contribute to fixing Appium issues blocking automation. Other advantages are being cross-platform, possibility to run on real devices, integrate tests with Ci/CD. 
  For Test annotations and configuration I used TestNG, and for managing project dependencies I used Maven.
  The framework has Page Object Model pattern. Page related locators and methods are separated in page classes, making tests shorter and more readable and page objects reusable.
  
 ##### Tools 
- Java (via homebrew)  
- Android sdk tools  
- TestNG  
- Appium  
- Maven (via homebrew)  
- Node JS  
  
##### Setting environmental paths in profiles
```bash  
export ANDROID_HOME=/<path_to_android_sdk>/sdk  
export JAVA_HOME=$(/usr/libexec/java_home)  
export PATH=$PATH:$ANDROID_HOME/tools  
export PATH=$PATH:$ANDROID_HOME/platforms  
export PATH=$PATH:$ANDROID_HOME/platform-tools  
export PATH=$PATH:$JAVA_HOME/bin  
```    
  
##### Preconditions
1. Make sure your Android emulator (or real device) is ready for testing. You can check running ```adb devices``` in terminal to see running devices.
2. Copy device ID and paste it as ```deviceName``` in Appium config ```common/BaseClass.java```  
3. Place ```.apk``` file in the project root directory ```monefy-android-tests```  
4. Update ```apkPath``` App config ```common/BaseClass.java``` with ```.apk``` file name  
5. To make sure all dependencies are set, you might need to download dependencies from the editor.  ( POM -> MVN -> Download resources) and Reimport  
  
##### Running the tests
1. Go to project root directory ```cd monefy-android-tests```  
2. Run ```mvn test```
Alternatively you can run from editor

Default suit is currently set to be regressionTestXML. However, can be set to support other suits (smokeTest, End2EndTest), including all tests matching the suit.

Please also note, that localisation is not supported at this stage, and device language/country should be set English.