package com.example.staff.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.staff.entity.EmployeeEntity;

public class ExelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "ФИО", "Должность", "Мобильный тел.", "Местный тел.", "Дата рождения", "Табельный номер",
			"Логин", "Почта", "Модель автомобиля", "Номер автомобиля", "Комментарий по автомобилю", "Фактическое подразделение",
			"Штатное подразделение", "Комментарий по сотруднику"};
	static String SHEET = "Сотрудники ОЭРП";
	
	public static ByteArrayInputStream employeesToExcel(List<EmployeeEntity> employees) {

	    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
	      Sheet sheet = workbook.createSheet(SHEET);

	      // Header
	      Row headerRow = sheet.createRow(0);

	      for (int col = 0; col < HEADERs.length; col++) {
	        Cell cell = headerRow.createCell(col);
	        cell.setCellValue(HEADERs[col]);
	      }

	      int rowIdx = 1;
	      for (EmployeeEntity employee : employees) {
	        Row row = sheet.createRow(rowIdx++);

	        try {row.createCell(0).setCellValue(employee.getName());} catch(Exception ex) {row.createCell(0).setCellValue("");};
	        try {row.createCell(1).setCellValue(employee.getPosition().getPosition());} catch(Exception ex) {row.createCell(1).setCellValue("");};
	        try {row.createCell(2).setCellValue(employee.getMobilePhone());} catch(Exception ex) {row.createCell(2).setCellValue("");};
	        try {row.createCell(3).setCellValue(employee.getLocalPhone());} catch(Exception ex) {row.createCell(3).setCellValue("");};
	        try {row.createCell(4).setCellValue(employee.getBirthday());} catch(Exception ex) {row.createCell(4).setCellValue("");};
	        try {row.createCell(5).setCellValue(employee.getEmployeeId());} catch(Exception ex) {row.createCell(5).setCellValue("");};
	        try {row.createCell(6).setCellValue(employee.getLogin());} catch(Exception ex) {row.createCell(6).setCellValue("");};
	        try {row.createCell(7).setCellValue(employee.getEmail());} catch(Exception ex) {row.createCell(7).setCellValue("");};
	        try {row.createCell(8).setCellValue(employee.getCar().getCarModel().getCarModel());} catch(Exception ex) {row.createCell(8).setCellValue("");};
	        try {row.createCell(9).setCellValue(employee.getCar().getCarNumber());} catch(Exception ex) {row.createCell(9).setCellValue("");};
	        try {row.createCell(10).setCellValue(employee.getCar().getCarComment());} catch(Exception ex) {row.createCell(10).setCellValue("");};
	        
	        try {row.createCell(11).setCellValue(employee.getFactDepartment().getFunctionGroup().getFunctionGroup());} 
	        catch(Exception ex) {try {row.createCell(11).setCellValue(employee.getFactDepartment().getGroupe().getGroupe());}
	           catch(Exception ex2) {row.createCell(11).setCellValue(employee.getFactDepartment().getDivision().getDivision());}};
	        		
	           try {row.createCell(12).setCellValue(employee.getStaffDepartment().getFunctionGroup().getFunctionGroup());} 
		        catch(Exception ex) {try {row.createCell(12).setCellValue(employee.getStaffDepartment().getGroupe().getGroupe());}
		           catch(Exception ex2) {row.createCell(12).setCellValue(employee.getStaffDepartment().getDivision().getDivision());}};
		           
	        try {row.createCell(13).setCellValue(employee.getEmployeeComment());} catch(Exception ex) {row.createCell(13).setCellValue("");};
	      }

	      workbook.write(out);
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
	    }
	  }

}
