package test;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.way2automation.twitter.utils.Utility;
import com.way2automation.twitter.utils.excel_reader;

public class testCase1 {
	
	@BeforeTest
	public void isTestExecutable(){
		
		excel_reader excel = new excel_reader(System.getProperty("user.dir")+"\\POMwithFactory\\src\\com\\way2automation\\twitter\\testdata\\testdata.xlsx");
		if(!Utility.isExecutable("Userregisteration", excel))
			throw new SkipException("Skipping the test case as the run mode is set to NO");
		
		
	}
	
	
	
	@Test
	public void testLogin(){
		
		System.out.println("Executing login test");
		
	}

}
