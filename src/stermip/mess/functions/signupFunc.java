package stermip.mess.functions;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;

import stermip.mess.Main;
import stermip.myApi.CryptWithMD5;

public class signupFunc {
	public static boolean signupProcess(String yourName, String password, 
			String confirmPassword, String monthOfManagement,
			String yearOfManagement, String numberOfMembers){
		
		int errors = 0;
		String msg="";
		if(!password.equals(confirmPassword)){
			errors++;
			msg = errors+". password did not match\n";
		}
		if(yourName.equals("") || monthOfManagement.equals("")||
				yearOfManagement.equals("") || numberOfMembers.equals("")){
			errors++;
			msg = msg + errors+". some fields are empty\n";
		}
		int yom=0,nom=0;
		try{
			yom = Integer.parseInt(yearOfManagement);
			nom = Integer.parseInt(numberOfMembers);
		}catch(Exception e){
			errors++;
			msg = msg+ errors+ ". inconsistent data\n";
		}
		if(errors>0){
			warningMsg.msg = msg;
			return false;
		}
		try{
			///write code here
			Connection conn = Main.conn;
			PreparedStatement sql_statement = null;
			String jdbc_insert_sql = "INSERT INTO manager"
	            + "(NAME,PASSWORD,STATUS,YEAR, MONTH, MEMBERS) VALUES"
	            + "(?,?,'active',?,?,?)";
			sql_statement = conn.prepareStatement(jdbc_insert_sql);
			sql_statement.setString(1,yourName);
			sql_statement.setString(2, CryptWithMD5.cryptWithMD5(password));
			sql_statement.setInt(3, yom);
			sql_statement.setString(4, monthOfManagement);
			sql_statement.setInt(5,nom);
			sql_statement.execute();
			return true;
			
		}catch(Exception e){
			warningMsg.msg = "Error in writing information\n";
			
			e.printStackTrace();
			return false;
		}

	}
}

/*
 * 
 * try {
			FileInputStream file = new FileInputStream(new File("C:\\update.xls"));

			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheetAt(0);
			Cell cell = null;

			//Update the value of cell
			cell = sheet.getRow(1).getCell(2);
			cell.setCellValue(cell.getNumericCellValue() * 2);
			cell = sheet.getRow(2).getCell(2);
			cell.setCellValue(cell.getNumericCellValue() * 2);
			cell = sheet.getRow(3).getCell(2);
			cell.setCellValue(cell.getNumericCellValue() * 2);
			
			file.close();
			
			FileOutputStream outFile =new FileOutputStream(new File("C:\\update.xls"));
			workbook.write(outFile);
			outFile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
