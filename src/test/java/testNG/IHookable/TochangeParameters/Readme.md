## IHookable

If a test class implements this interface, its run() method will be invoked instead of each @Test method found. The invocation of the test method will then be performed upon invocation of the callBack() method of the IHookCallBack parameter. 

This is useful to test classes that require tests to run against specific browser, which can be implemented as follows:

public void run(final IHookCallBack icb, ITestResult testResult) {  
// Preferably initialized in a Configuration method   
driver = getWebdriver(); 

driver.get("http://www.xxx.co.in");

