package com.ld.reading;


import com.ld.entity.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author luisdany
 */
public class ReadExcel {


    public ReadExcel(){

    }


    private XSSFWorkbook getFile(){

        String path = "";

        XSSFWorkbook workbook = null;
        try{
            FileInputStream excelFile = new FileInputStream(new File(path));
            workbook = new XSSFWorkbook(excelFile);
        }catch(IOException e){
            e.printStackTrace();
        }

        return workbook;

    }


    private int rowsToIgnore = 3;
    private int maxCellSize = 3;

    private void readXls(){

        XSSFWorkbook workbook = getFile();
        List<Student> students = new ArrayList<>();
        try {

            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            int rowCounter = 0;

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();

                if (rowCounter > rowsToIgnore) {

                    Iterator<Cell> cellIterator = currentRow.iterator();

                    int cellCounter = 0;
                    Student student = new Student();
                    while (cellIterator.hasNext()) {

                        Cell currentCell = cellIterator.next();

                        if (cellCounter < maxCellSize) {

                            if (currentCell.getColumnIndex() == 0) {
                                Double cellValue = currentCell.getNumericCellValue();
                                System.out.println("Valor del id " + cellValue + "intvalue " + cellValue.intValue());
                                student.setIdStudent(cellValue.intValue());
                            } else if (currentCell.getColumnIndex() == 1) {
                                student.setCode(currentCell.getStringCellValue().replaceAll(" ", ""));
                            } else if (currentCell.getColumnIndex() == 2) {
                                student.setName(currentCell.getStringCellValue());
                            }

                        }

                        cellCounter++;

                    }
                    System.out.println(student.toString());
                    students.add(student);
                }

                rowCounter++;

            }

        }catch (Exception e){

        }

    }

}
