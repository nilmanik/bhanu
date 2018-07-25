package automationPractice.bhanu.excelReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import automationPractice.bhanu.testBase.TestBase;




/*public class ExcelReader {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	 String path;
	 //="E:\\framework28-04-2018\\uiAutomation\\src\\main\\java\\com\\test\\automation\\uiAutomation\\data\\testData.xlsx";
	*//**
	 * @param File Name
	 * @param Sheet Name
	 * @return
	 
	 *//*
	
	public ExcelReader(String path){
		this.path=path;
		try {
			FileInputStream fs = new FileInputStream(path);
			ExcelWBook = new XSSFWorkbook(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			int totalNoOfRows = ExcelWSheet.getLastRowNum();
			System.out.println(totalNoOfRows);
			int totalNoOfCols = ExcelWSheet.getRow(0).getLastCellNum();
			
			
			arrayExcelData = new String[totalNoOfRows][totalNoOfCols];
			
			for (int i= 1 ; i <= totalNoOfRows; i++) {
				Row=ExcelWSheet.getRow(i);

				for (int j=0; j < totalNoOfCols; j++) {
					Cell=Row.getCell(j);
					if(Cell.getCellType()==Cell.CELL_TYPE_STRING){
					arrayExcelData[i-1][j] = Cell.getStringCellValue();
					}
					else if(Cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
						String numValue=String.valueOf(Cell.getNumericCellValue());
						arrayExcelData[i-1][j]=numValue;
					}
					else{
						arrayExcelData[i-1][j]=String.valueOf(Cell.getBooleanCellValue());
					}
					}
				return arrayExcelData;
			}
		
		} catch (Exception e) {
			System.out.println("exception from reading excel file"+e.getMessage());
			e.printStackTrace();
		}
		return arrayExcelData;
	}*/
public class ExcelReader {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	static String path=null;
	
	//cel=new ExcelReader();tyuio/.ll;p
   public static String user=getParticularDataFromExcel("loginTestData", 1, 0);
   public static String pass=getParticularDataFromExcel("loginTestData", 1, 1);
	/**
	 * @param File Name
	 * @param Sheet Name
	 * @return
	 * 
	 */
	public Object[][] getExcelData(String Path, String sheetName) {
		Object[][] arrayExcelData = null;
		 //Path="E:\\framework28-04-2018\\uiAutomation\\src\\main\\java\\com\\test\\automation\\uiAutomation\\data\\testData1.xlsx";
		try {
			FileInputStream fs = new FileInputStream(TestBase.path);
			ExcelWBook = new XSSFWorkbook(fs);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			int totalNoOfRows = ExcelWSheet.getLastRowNum();
			System.out.println(totalNoOfRows);
			int totalNoOfCols = ExcelWSheet.getRow(0).getLastCellNum();
			
			
			arrayExcelData = new String[totalNoOfRows][totalNoOfCols];
			
			for (int i= 1 ; i <= totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j] = getCellData( i, j);
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		 
		try{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			int dataType = Cell.getCellType();
			if  (dataType == 3) {
				return "";
			}
			else{
				String CellData = Cell.getStringCellValue();
				return CellData;
			}}
			catch (Exception e){
			System.out.println(e.getMessage());
			throw (e);
			}}
	public static String getParticularDataFromExcel(String sheetName,int rowNum,int colNum){
		try {
			//String path="E:\\framework28-04-2018\\uiAutomation\\src\\main\\java\\com\\test\\automation\\uiAutomation\\data\\testData1.xlsx";
			FileInputStream fs = new FileInputStream(TestBase.path);
			ExcelWBook = new XSSFWorkbook(fs);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			Row=ExcelWSheet.getRow(rowNum);
			int data=Row.getCell(colNum).getCellType();
			if(data==2){
				return "";
			}
			else{
				return Row.getCell(colNum).getStringCellValue();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
	}
	


	public static Object getCellData(String sheetName,int RowNum, int ColNum) throws Exception {
		 
		try{
			int Col_Num=0;
			int index=ExcelWBook.getSheetIndex(sheetName);
			ExcelWSheet=ExcelWBook.getSheetAt(index);
			Row=ExcelWSheet.getRow(0);
			//Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			for(int i=0;i<Row.getLastCellNum();i++){
				if(Row.getCell(i).getStringCellValue().equals(ColNum)){
					Col_Num=i;
					break;
				}
			}
			Row=ExcelWSheet.getRow(RowNum-1);
			Cell=Row.getCell(Col_Num);
			if(Cell.equals("")){
				return Cell.getStringCellValue();
			}
			
	
			else if(Cell.equals(10)){
				return Cell.getNumericCellValue();
			}
		
		}
			catch (Exception e){
			System.out.println(e.getMessage());
			throw (e);
			}
		return null;
	}
	/*public static String getParticularDataFromExcel(String sheetName,int rowNum,int colNum){
		try {
			FileInputStream fs = new FileInputStream(path);
			ExcelWBook = new XSSFWorkbook(fs);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			Row=ExcelWSheet.getRow(rowNum);
			int data=Row.getCell(colNum).getCellType();
			if(data==2){
				return "";
			}
			else{
				return Row.getCell(colNum).getStringCellValue();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
	}*/
	
}
