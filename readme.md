## Selenium Automation

The project is build using:
 
   *   TestNg 7.1.0
   *   Selenium 3.141.59
   

        
### Run Test Suite

   * TestRunner
     
        You can run the test suite using your IDE and running suite file
        
             src\test\resources\test-suite.xml
             
   * Maven execution
        
        maven can be used to run test suite.  
     
            mvn clean install

### Driver

Chrome version 81 for windows, placed in: 

        /src/test/resources/webdrivers/chromedriver.exe
            
### Test. 

To add new test you need to create a new class under tests package. @BeforeSuite configures the driver 
You need to set up your test with @BeforeTest TesNg annotation. 
       
        com/example/automation/tests
        

