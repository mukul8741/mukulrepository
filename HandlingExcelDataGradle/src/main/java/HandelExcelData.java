import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HandelExcelData {

	public static void main(String[] args) {
		
//		XSSFWorkbook workbook = new XSSFWorkbook();
//		
//		XSSFSheet sheet = workbook.createSheet("Employee Data");
//		
//		Row row = sheet.createRow(0);
//		
//		Cell cell;
//		
//        for(int i = 0; i<5; i++) {
//			
//        	cell = row.createCell(i);
//        	
//			cell.setCellValue("Column " + i); 
//			
//		}
//		
//        row = sheet.createRow(1);
//        
//		for(int i = 0; i<5; i++) {
//			
//		    cell = row.createCell(i);
//			
//			cell.setCellValue((int) i); 
//			
//		}
//		
//		try {
//			
//			FileOutputStream out = new FileOutputStream(new File("FirstExample.xlsx"));
//			workbook.write(out);
//			out.close();
//			System.out.println("done");
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
		
		try {
			
			FileInputStream in = new FileInputStream(new File("FirstExample.xlsx"));
			
			XSSFWorkbook workBook2 = new XSSFWorkbook(in);
			
			XSSFSheet sheet2 = workBook2.getSheetAt(0);
			
			Iterator<Row> list1 = sheet2.iterator();
			
			while(list1.hasNext()) {
				
				Row row1 = list1.next();
				Iterator<Cell> list2 = row1.cellIterator();
				
				while(list2.hasNext()) {
					
					Cell cell2 = list2.next();
					
//					System.out.println(cell2.getCellType());
					
					switch(cell2.getCellType()) {
					
					case NUMERIC: System.out.print(cell2.getNumericCellValue() + "      ");
					              break;
					case STRING: System.out.print(cell2.getStringCellValue() + " ");
					              break;
					
					}
					
				}
				
				System.out.println("");
				
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
