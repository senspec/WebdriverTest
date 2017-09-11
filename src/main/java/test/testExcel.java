package test;

import com.way2automation.twitter.utils.excel_reader;

public class testExcel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(System.getProperty("user.dir"));
		excel_reader excel = new excel_reader(System.getProperty("user.dir")+"\\POMwithFactory\\src\\com\\way2automation\\twitter\\testdata\\testdata.xlsx");
		
		String sheetName="testcases";
		for(int rowNum=2;rowNum<=excel.getRowCount(sheetName);rowNum++){
			//System.out.println(excel.getCellData(sheetName, "test_name", rowNum));
			
			if(excel.getCellData(sheetName, "runmode", rowNum).equalsIgnoreCase("Y")){
				System.out.println(excel.getCellData(sheetName, "test_name", rowNum));
				
				
			}
			
		}
		

	}

}
