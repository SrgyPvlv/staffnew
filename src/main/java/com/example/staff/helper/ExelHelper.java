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

import com.example.staff.entity.CarEntity;
import com.example.staff.entity.DeviceEntity;
import com.example.staff.entity.EmployeeEntity;
import com.example.staff.entity.SertificateEntity;

public class ExelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "ФИО", "Должность", "Мобильный тел.", "Местный тел.", "Дата рождения", "Табельный номер",
			"Логин", "Почта", "Модель автомобиля", "Номер автомобиля", "Комментарий по автомобилю", "Фактическое подразделение",
			"Штатное подразделение", "Комментарий по сотруднику"};
	static String[] CARHEADERs = {"Модель автомобиля", "Номер автомобиля", "Комментарий по автомобилю", "Сотрудник",
			"Должность", "Мобильный тел.", "Фактическое подразделение", "Штатное подразделение"};
	static String[] SERTIFICATEHEADERs = {"Тип удостоверения", "Номер удостоверения", "Группа безопасности", "Дата выдачи",
			"Дата окончания", "Сотрудник", "Должность", "Фактическое подразделение", "Штатное подразделение"};
	static String[] DEVICEHEADERs = {"Тип прибора", "Наименование прибора", "Номер прибора", "Владелец прибора", "Фактическое подразделение",
			"Комментарий", "Номер бухучета", "Место хранения", "Подлежит поверке", "Находится в поверке", "Дата сдачи/возврата в/из поверку/и"};
	static String SHEET = "Сотрудники ОЭРП";
	static String CARSHEET = "Автомобили ОЭРП";
	static String SERTIFICATESHEET = "Удостоверения ОЭРП";
	static String DEVICESSHEET = "Приборы ОЭРП";
	
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
	
	public static ByteArrayInputStream carsToExcel(List<CarEntity> cars) {

	    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
	      Sheet sheet = workbook.createSheet(CARSHEET);

	      // Header
	      Row headerRow = sheet.createRow(0);

	      for (int col = 0; col < CARHEADERs.length; col++) {
	        Cell cell = headerRow.createCell(col);
	        cell.setCellValue(CARHEADERs[col]);
	      }

	      int rowIdx = 1;
	      for (CarEntity car : cars) {
	        Row row = sheet.createRow(rowIdx++);

	        try {row.createCell(0).setCellValue(car.getCarModel().getCarModel());} catch(Exception ex) {row.createCell(0).setCellValue("");};
	        try {row.createCell(1).setCellValue(car.getCarNumber());} catch(Exception ex) {row.createCell(1).setCellValue("");};
	        try {row.createCell(2).setCellValue(car.getCarComment());} catch(Exception ex) {row.createCell(2).setCellValue("");};
	        try {row.createCell(3).setCellValue(car.getEmployee().getName());} catch(Exception ex) {row.createCell(3).setCellValue("");};
	        try {row.createCell(4).setCellValue(car.getEmployee().getPosition().getPosition());} catch(Exception ex) {row.createCell(4).setCellValue("");};
	        try {row.createCell(5).setCellValue(car.getEmployee().getMobilePhone());} catch(Exception ex) {row.createCell(5).setCellValue("");};
	        
	        try {row.createCell(6).setCellValue(car.getEmployee().getFactDepartment().getFunctionGroup().getFunctionGroup());} 
	        catch(Exception ex) {try {row.createCell(6).setCellValue(car.getEmployee().getFactDepartment().getGroupe().getGroupe());}
	           catch(Exception ex2) {try {row.createCell(6).setCellValue(car.getEmployee().getFactDepartment().getDivision().getDivision());}
	           catch(Exception ex3) {row.createCell(6).setCellValue("");}}
	           };
	           
	           try {row.createCell(7).setCellValue(car.getEmployee().getStaffDepartment().getFunctionGroup().getFunctionGroup());} 
		        catch(Exception ex) {try {row.createCell(7).setCellValue(car.getEmployee().getStaffDepartment().getGroupe().getGroupe());}
		           catch(Exception ex2) {try {row.createCell(7).setCellValue(car.getEmployee().getStaffDepartment().getDivision().getDivision());}
		           catch(Exception ex3) {row.createCell(7).setCellValue("");}}
		           };
	  	      
	      }

	      workbook.write(out);
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
	    }
	  }
	
	public static ByteArrayInputStream sertificatesToExcel(List<SertificateEntity> sertificates) {

	    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
	      Sheet sheet = workbook.createSheet(SERTIFICATESHEET);

	      // Header
	      Row headerRow = sheet.createRow(0);

	      for (int col = 0; col < SERTIFICATEHEADERs.length; col++) {
	        Cell cell = headerRow.createCell(col);
	        cell.setCellValue(SERTIFICATEHEADERs[col]);
	      }

	      int rowIdx = 1;
	      for (SertificateEntity sertificate : sertificates) {
	        Row row = sheet.createRow(rowIdx++);

	        try {row.createCell(0).setCellValue(sertificate.getSertificateName().getSertificateName());} catch(Exception ex) {row.createCell(0).setCellValue("");};
	        try {row.createCell(1).setCellValue(sertificate.getSertificateNumber());} catch(Exception ex) {row.createCell(1).setCellValue("");};
	        try {row.createCell(2).setCellValue(sertificate.getApprovalGruppa().getApprovalGruppa());} catch(Exception ex) {row.createCell(2).setCellValue("");};
	        try {row.createCell(3).setCellValue(sertificate.getIssueDate());} catch(Exception ex) {row.createCell(3).setCellValue("");};
	        try {row.createCell(4).setCellValue(sertificate.getExpirationDate());} catch(Exception ex) {row.createCell(4).setCellValue("");};
	        try {row.createCell(5).setCellValue(sertificate.getEmployee().getName());} catch(Exception ex) {row.createCell(5).setCellValue("");};
	        try {row.createCell(6).setCellValue(sertificate.getEmployee().getPosition().getPosition());} catch(Exception ex) {row.createCell(6).setCellValue("");};
	        
	        try {row.createCell(7).setCellValue(sertificate.getEmployee().getFactDepartment().getFunctionGroup().getFunctionGroup());} 
	        catch(Exception ex) {try {row.createCell(7).setCellValue(sertificate.getEmployee().getFactDepartment().getGroupe().getGroupe());}
	           catch(Exception ex2) {row.createCell(7).setCellValue(sertificate.getEmployee().getFactDepartment().getDivision().getDivision());}};
	        		
	           try {row.createCell(8).setCellValue(sertificate.getEmployee().getStaffDepartment().getFunctionGroup().getFunctionGroup());} 
		        catch(Exception ex) {try {row.createCell(8).setCellValue(sertificate.getEmployee().getStaffDepartment().getGroupe().getGroupe());}
		           catch(Exception ex2) {row.createCell(8).setCellValue(sertificate.getEmployee().getStaffDepartment().getDivision().getDivision());}};  
	      }

	      workbook.write(out);
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
	    }
	  }
	
	public static ByteArrayInputStream devicesToExcel(List<DeviceEntity> devices) {

	    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
	      Sheet sheet = workbook.createSheet(DEVICESSHEET);

	      // Header
	      Row headerRow = sheet.createRow(0);

	      for (int col = 0; col < DEVICEHEADERs.length; col++) {
	        Cell cell = headerRow.createCell(col);
	        cell.setCellValue(DEVICEHEADERs[col]);
	      }

	      int rowIdx = 1;
	      for (DeviceEntity device : devices) {
	        Row row = sheet.createRow(rowIdx++);

	        try {row.createCell(0).setCellValue(device.getDeviceType().getDeviceTypeName());} catch(Exception ex) {row.createCell(0).setCellValue("");};
	        try {row.createCell(1).setCellValue(device.getDeviceName().getDeviceName());} catch(Exception ex) {row.createCell(1).setCellValue("");};
	        try {row.createCell(2).setCellValue(device.getDeviceNumber());} catch(Exception ex) {row.createCell(2).setCellValue("");};
	        try {row.createCell(3).setCellValue(device.getEmployee().getName());} catch(Exception ex) {row.createCell(3).setCellValue("");};
	        
	        try {row.createCell(4).setCellValue(device.getEmployee().getFactDepartment().getFunctionGroup().getFunctionGroup());} 
	        catch(Exception ex) {try {row.createCell(4).setCellValue(device.getEmployee().getFactDepartment().getGroupe().getGroupe());}
	           catch(Exception ex2) {row.createCell(4).setCellValue(device.getEmployee().getFactDepartment().getDivision().getDivision());}};
	        
	        try {row.createCell(5).setCellValue(device.getDeviceComment());} catch(Exception ex) {row.createCell(5).setCellValue("");};
	        try {row.createCell(6).setCellValue(device.getDeviceAccounting());} catch(Exception ex) {row.createCell(6).setCellValue("");};
	        try {row.createCell(7).setCellValue(device.getStorePlace());} catch(Exception ex) {row.createCell(7).setCellValue("");};
	        try {if(device.isVerificationNeed()) {row.createCell(8).setCellValue("да");}else{row.createCell(8).setCellValue("нет");}} catch(Exception ex) {row.createCell(8).setCellValue("");};
	        try {if(device.isInVerification()) {row.createCell(9).setCellValue("да");}else{row.createCell(9).setCellValue("нет");}} catch(Exception ex) {row.createCell(9).setCellValue("");};
	        try {row.createCell(10).setCellValue(device.getDateMoving());} catch(Exception ex) {row.createCell(10).setCellValue("");};
	          
	      }

	      workbook.write(out);
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
	    }
	  }

}
