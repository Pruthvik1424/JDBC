package com.xworkz.tourism;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementInsertData {

    public static void main(String[] args) {
        System.out.println("load and register the Driver class");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String jdbcUrl ="jdbc:mysql://localhost:3306/Tourism";
        String userName = "root";
        String password = "Xworkzodc@123";

        String query = "Insert INTO Waterfalls(id,name,river_name,place,state,pincode)  values(1,'Gaganachukki_falls','kaveri','Chamarajanagar','karnataka',571313)";
        String query1 = "Insert INTO Waterfalls(id,name,river_name,place,state,pincode)  values(2,'Barachukki_falls','kaveri','Mandya','karnataka',571401)";
        String query2= "Insert INTO Waterfalls(id,name,river_name,place,state,pincode)  values(3,'Abbi_falls','kaveri','Madikeri','karnataka',571201)";
        String query3= "Insert INTO Waterfalls(id,name,river_name,place,state,pincode)  values(4,'jog_falls','Sharavathi','Shivamoggah','karnataka',577201)";

        Connection connection = null;
        Statement statement = null;

        try {
          connection = DriverManager.getConnection(jdbcUrl,userName,password);
         statement = connection.createStatement();
       boolean exce = statement.execute(query);
            System.out.println(exce);
            boolean exce1 = statement.execute(query1);
            boolean exce2= statement.execute(query2);
            boolean exce3 = statement.execute(query3);

            System.out.println(exce1);
            System.out.println(exce2);
            System.out.println(exce3);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if(statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Statement and connection is closed");


    }
}
