package com.ujiuye.demo1.controller;

import com.ujiuye.demo1.pojo.Person;
import com.ujiuye.demo1.service.UserService;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    UserService service;

    @RequestMapping("getAll")
    public ModelAndView getAll(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("users",service.getAll());
        mav.setViewName("show_person");
        return mav;
    }

    @PostMapping("uploadExcel")
    public String uploadExcel(MultipartFile excel) throws IOException {
        InputStream is = excel.getInputStream();
        XSSFWorkbook wb = new XSSFWorkbook(is);
        XSSFSheet sheet = wb.getSheetAt(0);
        int rowNum = sheet.getPhysicalNumberOfRows();
        //注意i=1,因为第一行是列名
        for (int i=1;i<rowNum;i++){
            XSSFRow row = sheet.getRow(i);

            /*第一列*/
            XSSFCell cellName = row.getCell(0);
            /*cellName.setCellType(CellType.STRING);*/
            String name = cellName.getStringCellValue();

            /*第二列*/
            XSSFCell cellAge = row.getCell(1);
            /*cellAge.setCellType(CellType.NUMERIC);*/
            int age = (int)cellAge.getNumericCellValue();

            /*第三列*/
            XSSFCell cellBirth = row.getCell(2);
            Date birthday = cellBirth.getDateCellValue();

            /*赋值对象*/
            Person person =new Person();
            person.setAge(age);
            person.setName(name);
            person.setBirthday(birthday);

            /*写入数据库*/
            service.add(person);
        }
        return "redirect:/user/getAll.action";
    }

    @RequestMapping("daochuExcel")
    public void daochuExcel(Writer writer){
        List<Person> all = service.getAll();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();

        //第一行为字段名
        XSSFRow ziduan = sheet.createRow(0);
        ziduan.createCell(0).setCellValue("id");
        ziduan.createCell(1).setCellValue("name");
        ziduan.createCell(2).setCellValue("birthday");
        ziduan.createCell(3).setCellValue("age");

        for (int i=0;i<all.size();i++){
            XSSFRow row = sheet.createRow(i+1);
            Person person = all.get(i);
            row.createCell(0).setCellValue(person.getPerson_id());
            row.createCell(1).setCellValue(person.getName());
            row.createCell(2).setCellValue(person.getBirthday());
            row.createCell(3).setCellValue(person.getAge());
        }
        try {
            workbook.write(new FileOutputStream("d:/temp/test2.xlsx"));
            writer.write("导出成功！");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
