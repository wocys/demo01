import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Demo {
    public static void main2(String[] args) throws  Exception {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet();
        //索引从0开始
        XSSFRow row = sheet.createRow(2);
        XSSFCell cell = row.createCell(2);
        cell.setCellValue("测试");

        FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\demo.xlsx");
        wb.write(fos);

    }

    public static void main1(String[] args) throws  Exception{


        FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\demo.xlsx");

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        //wb.getSheet("Sheet0");
        XSSFRow row = sheet.getRow(2);
        XSSFCell cell = row.getCell(2);
        String value = cell.getStringCellValue();
        System.out.println(value);

    }

    public static void main(String[] args) throws  Exception{
        FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\demo.xlsx");

        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(2);
        Cell cell = row.getCell(2);
        String value = cell.getStringCellValue();
        System.out.println(value);
    }

}
