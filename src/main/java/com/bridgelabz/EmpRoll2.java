package com.bridgelabz;

import java.sql.*;

public class EmpRoll2 {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://127.0.0.1:3306/emppayroll?useSSL=false";
        String username = "root";
        String password = "123456789";
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("cannot find the driver in the classpath!", e);
        }
        try {
            System.out.println("connecting to database:" + jdbcURL);
            con = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("connection done successful!!" + con);
            Statement statement = con.createStatement();
           // statement.executeUpdate("alter table employee add column phone varchar(30);");
           // statement.executeUpdate("alter table employee add column address varchar(60);");
            statement.executeUpdate("alter table employee add column tax varchar(30);");
            ResultSet resultSet = statement.executeQuery("  select * from employee");
            while (resultSet.next()) {
                System.out.println("id:" + resultSet.getInt("id"));
                System.out.println("name:" + resultSet.getString("name"));
                System.out.println("salary:" + resultSet.getDouble("salary"));
                System.out.println("department:" + resultSet.getString("department"));
                System.out.println("Joining_Date:" + resultSet.getDate("Joining_Date"));
                System.out.println("Gender:" + resultSet.getString("Gender"));
                System.out.println("phone:" + resultSet.getInt("phone"));
                System.out.println("address:" + resultSet.getString("address"));
                System.out.println("tax:" + resultSet.getString("tax"));


            }
        } catch (Exception e) {
            //  e.printStackTrace();
        }
    }
}