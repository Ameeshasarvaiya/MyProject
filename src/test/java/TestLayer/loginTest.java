package TestLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMClass;
import pompackage.PomLogin;
import testdata.ExcelSheet;

public class loginTest extends BaseHRMClass {
	
	PomLogin Log;
	public loginTest() {
		super();
	}
    
	
	@BeforeMethod
	public void initsetup() {
		initiation();
		screenshots("Login");
		
		Log=new PomLogin();
	}
    @Test(priority=1)
    public void Title() {
    	String Actual=Log.verify();
    	System.out.println(Actual);
    	Assert.assertEquals(Actual, "OrangeHRM");
    }
    @DataProvider
    public Object[][]Details(){
    	Object result[][]=ExcelSheet.readdata("Sheet1");
		return result;
    
    }
    @Test(priority=2, dataProvider="Details")
    public void Login(String name, String password) {
    Log.typeusername(name);	
    Log.typepassword(password);
   // Log.clickbtn();
    	
    }
    @AfterMethod
    public void close() {
    driver.close();	
}}