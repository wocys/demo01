import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class POIDemo {
    public static void main(String[] args) throws IOException, InvalidFormatException {
//        create();
//        get1();
//        get2();
//        each1();

    }

    public static void each1() throws IOException {
        FileInputStream fis = new FileInputStream("d:/temp/test.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);

        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i=0;i<rowNum;i++){
            XSSFRow row = sheet.getRow(i);
            int cellNum = row.getPhysicalNumberOfCells();

            for (int j=0;j<cellNum;j++){
                XSSFCell cell = row.getCell(j);
                cell.setCellType(CellType.STRING);
                String value = cell.getStringCellValue();
                System.out.print(value+"\t");
            }
            System.out.println();
        }
        fis.close();
    }

    public static void get2() throws IOException, InvalidFormatException {
        FileInputStream fis = new FileInputStream("d:/temp/test.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sheet0");
        Row row = sheet.getRow(2);
        Cell cell = row.getCell(2);
        String value = cell.getStringCellValue();
        System.out.println(value);
        fis.close();
    }

    public static void get1() throws IOException {
        FileInputStream fis = new FileInputStream("d:/temp/test.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        //wb.getSheet("Sheet0");
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row = sheet.getRow(2);
        XSSFCell cell = row.getCell(2);
        String value = cell.getStringCellValue();
        System.out.println(value);
        fis.close();
    }

    public static void create() throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet();

        XSSFRow row = sheet.createRow(2);
        XSSFCell cell = row.createCell(2);
        cell.setCellValue("测试");

        FileOutputStream fos = new FileOutputStream("d:/temp/test.xlsx");
        wb.write(fos);
        fos.close();
    }
}
