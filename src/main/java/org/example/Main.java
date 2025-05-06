package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try {
            //1. Load and register the driver
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            
            //2. Establish the connection with the database
            String url = "jdbc:mysql://localhost:3306/sakila";
            String userName = "root";
            String passWord = "<Mysql789[&]>";

            Connection con = DriverManager.getConnection(url, userName, passWord);

            //3. Create the statement object
            Statement st = con.createStatement();

            //4. Prepare send and execute the query
            String sqlQuery = "SELECT * FROM ACTOR";
            ResultSet rs = st.executeQuery(sqlQuery);

            //5. Process the result from result set
                while(rs.next()) {
                    int id = rs.getInt(1);
                    String firstName = rs.getString(2);
                    String lastName = rs.getString(3);

                    System.out.println(id + " " + firstName + " " + lastName);
                }

            //6. Close the connection

                con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}