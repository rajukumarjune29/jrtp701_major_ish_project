package com.ish;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ReadSSNTextData {
	public static void main(String[] args) throws SQLException {
		File file = new File(
				"E:\\eclipse_workspace\\JRTP701_Project\\SSA-Web-API\\src\\main\\resources\\state-ssn.txt");
		Connection connection = null;
		try {

			DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:mysql:///jrtp701_ish_db", "root",
					"root");
			connection = dataSource.getConnection();
			int i = 1;
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String textLine = (String) scanner.nextLine();
				String[] textLineArr = textLine.split("=");
				String code = textLineArr[0].trim();
				String stateName = textLineArr[1].trim();

				if (code.contains("-")) {
					String[] codearray = code.split("-");
					int startCode = Integer.parseInt(codearray[0]);
					int endCode = Integer.parseInt(codearray[1]);
					while (startCode <= endCode) {
						String query = "insert into US_STATE(state_id,state_code,state_name) values(" + i + ","
								+ startCode + ",'" + stateName + "')";
						System.out.println(query);
						PreparedStatement statement = connection.prepareStatement(query);
						statement.execute();
						startCode++;
						i++;
					}
				} else {
					String query = "insert into US_STATE(state_id,state_code,state_name) values(" + i + "," + code + ",'"
							+ stateName + "')";
					PreparedStatement statement = connection.prepareStatement(query);
					statement.execute();
					i++;
				}
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

}
