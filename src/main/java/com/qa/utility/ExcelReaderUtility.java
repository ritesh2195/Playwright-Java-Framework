package com.qa.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderUtility {

    public String filepath;

    FileInputStream fis=null;

    Workbook workbook=null;

    Sheet sheet=null;

    Row row=null;;

    Cell cell=null;;

    public  FileOutputStream fileOut =null;

    String fileExtension=null;

    public ExcelReaderUtility(String filepath) throws IOException{

        this.filepath = filepath;

        fileExtension = filepath.substring(filepath.indexOf(".x"));

        try {

            fis = new FileInputStream(filepath);

            if(fileExtension.equals(".xlsx")){

                workbook = new XSSFWorkbook(fis);


            } else if(fileExtension.equals(".xls")){

                workbook = new HSSFWorkbook(fis);

            }

            sheet = workbook.getSheetAt(0);

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            fis.close();

        }

    }

    public int getRowCount(String sheetname){

        int sheetIndex = workbook.getSheetIndex(sheetname);

        if(sheetIndex==-1){

            return 0;

        } else {

            sheet = workbook.getSheetAt(sheetIndex);

            return sheet.getLastRowNum()+1;
        }

    }

    public String getCellData(String sheetName,String colName,int rowNum){

        try{

            if(rowNum<=0)

                return "";

            int sheetIndex = workbook.getSheetIndex(sheetName);

            if(sheetIndex==-1)

                return "";

            sheet = workbook.getSheetAt(sheetIndex);

            row = sheet.getRow(0);

            int colNum=-1;

            for(int i=0;i<row.getLastCellNum();i++){

                if(row.getCell(i).getStringCellValue().equals(colName))

                    colNum=i;

            }
            if(colNum==-1)

                return "";

            sheet = workbook.getSheetAt(sheetIndex);

            row = sheet.getRow(rowNum-1);

            if(row==null)

                return "";

            cell = row.getCell(colNum);

            if(cell==null)

                return "";

            cell = row.getCell(colNum);

            if(cell==null)

                return "";

            if(cell.getCellType()==CellType.STRING) {

                return cell.getStringCellValue();

            } else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA){

                String cellText  = String.valueOf(cell.getNumericCellValue());

                if (DateUtil.isCellDateFormatted(cell)) {

                    // format in form of M/D/YY

                    double d = cell.getNumericCellValue();

                    Calendar cal =Calendar.getInstance();

                    cal.setTime(DateUtil.getJavaDate(d));

                    cellText =
                            (String.valueOf(cal.get(Calendar.YEAR))).substring(2);

                    cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
                            cal.get(Calendar.MONTH)+1 + "/" +
                            cellText;
                }

                return cellText;

            }else if(cell.getCellType()==CellType.BLANK)

                return "";

            else

                return String.valueOf(cell.getBooleanCellValue());

        }catch(Exception e){

            e.printStackTrace();

            return "row "+rowNum+" or column "+colName +" does not exist in xls";

        }

    }

    // returns the data from a cell
    public String getCellData(String sheetname,int colNum,int rowNum){

        try{

            if(rowNum <=0)

                return "";

            int sheetIndex = workbook.getSheetIndex(sheetname);

            if(sheetIndex==-1)

                return "";

            sheet = workbook.getSheetAt(sheetIndex);

            row = sheet.getRow(rowNum-1);

            if(row==null)

                return "";

            cell = row.getCell(colNum-1);

            if(cell==null)

                return "";

            if(cell.getCellType()==CellType.STRING)

                return cell.getStringCellValue();

            else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA ){

                return String.valueOf(cell.getNumericCellValue());

            }else if(cell.getCellType()==CellType.BLANK)

                return "";

            else

                return String.valueOf(cell.getBooleanCellValue());

        }catch(Exception e){

            e.printStackTrace();

            return "row "+rowNum+" or column "+colNum +" does not exist  in xls";

        }
    }

    // returns number of columns in a sheet
    public int getColumnCount(String sheetName){

        // check if sheet exists
        if(isSheetExist(sheetName))

            return -1;

        sheet = workbook.getSheet(sheetName);

        row = sheet.getRow(0);

        if(row==null)

            return -1;

        return row.getLastCellNum();

    }

    private boolean isSheetExist(String sheetName) {
        // TODO Auto-generated method stub
        return false;
    }

    public int getCellRowNum(String sheetName,String colName,String cellValue){

        for(int i=1;i<=getRowCount(sheetName);i++){

            if(getCellData(sheetName,colName,i).equalsIgnoreCase(cellValue)){

                return i;

            }
        }

        return -1;

    }
}
