package com.softserve.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    
    public static void main(String[] args) throws SQLException {
        String username = "postgres";
        String password = "root";
        //String url = "jdbc:postgresql://localhost:5432/greencity";
        String url = "jdbc:postgresql://localhost:5432/lv519";
        DriverManager.registerDriver(new org.postgresql.Driver());
        Connection con = DriverManager.getConnection(url, username, password);
        if (con != null) {
            System.out.println("Connection Successful! \n");
        } else {
            System.out.println("Connection ERROR \n");
            System.exit(1);
        }
        //
        Statement st = con.createStatement();
        //st.execute("CREATE DATABASE Lv519;");
        //st.execute("\\c Lv519;");
        //
//        st.execute("CREATE TABLE COMPANY ("
//              +" id serial NOT NULL PRIMARY KEY,"
//              + " name CHAR(45) NOT NULL);");
        //
        //st.execute("INSERT INTO person (city,name) VALUES ('Berlin','Dietrich');");
        //st.execute("INSERT INTO person (city,name) VALUES ('New-York','Tom');");
        //st.execute("INSERT INTO person (city,name) VALUES ('New Orleans','Petro');");
        //st.execute("UPDATE person SET city='Paris' WHERE name LIKE 'iv%';");
        //st.execute("DELETE FROM person WHERE city='Paris';");
        //ResultSet rs = st.executeQuery("SELECT * FROM person;");
        //
        st.execute("INSERT INTO company (name) VALUES ('Dietrich');");
        ResultSet rs = st.executeQuery("SELECT * FROM company;");
        //
        int columnCount = rs.getMetaData().getColumnCount();
        // Resultset.getMetaData () get the information
        for (int i = 1; i <= columnCount; i++) {
            System.out.print(rs.getMetaData().getColumnName(i) + "\t");
        }
        System.out.println();
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
        //System.out.println("before close");
        if (rs != null) {
            rs.close();
        }
        if (st != null) {
            st.close();
        }
        if (con != null) {
            con.close();
        }
    }
}
