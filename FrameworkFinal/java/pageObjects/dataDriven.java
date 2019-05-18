package pageObjects;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

public ArrayList<String> getData(int testcaseNumber) throws IOException  {
		ArrayList<String> list=new ArrayList<String>();
		FileInputStream fis=new FileInputStream("F:\\Selenium\\LoginData.xlsx");
		
		System.out.println("Reading file......Success!!");
		//accepts fileinputstream argument
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		System.out.println("Getting no of sheets in the workbook...");
		int sheetscount=workbook.getNumberOfSheets();
		System.out.println("No.of sheets--->"+sheetscount);
		for(int i=0;i<sheetscount;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("LoginData")) {
				System.out.println("Found required Sheet!");
				XSSFSheet sheet=workbook.getSheetAt(i);
				
				//Identify testcases column by scanning the entire 1st row
				
				Iterator<Row> rows=sheet.iterator();
				Row firstrow=rows.next();
				Iterator<Cell> cells=firstrow.cellIterator();
				int k=0;
				int column=0;
				while(cells.hasNext()) {
					Cell value=cells.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						System.out.println("Found required column!");
						column=k;
						break;
					}
					k++;
				}
				System.out.println("Required column index-->"+column);
				
				while(rows.hasNext()) {
					Row r=rows.next();
					if(r.getCell(column).getNumericCellValue()==testcaseNumber) {
						System.out.println("Found Testcase "+testcaseNumber);
						Iterator<Cell> cv=r.cellIterator();
						System.out.println("Printing the cell values");
						while(cv.hasNext()) {
							Cell c=cv.next();
							if(c.getCellTypeEnum()==CellType.STRING) {
								list.add(c.getStringCellValue());
							}
							else {
								list.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								
							}
						}
						
					}
				}				
			}
			
		}
		return list;
	}

}
