package org.example.oopshka;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

public class DBInit {

    public static void createTables() throws SQLException {
        System.out.println("Enter your SQL order:\n");
        Scanner sc = new Scanner(System.in);
        String createTable = sc.nextLine();

        try (Connection con = DB.getConnection();
             Statement st = con.createStatement()) {

            st.execute(createTable);
        }
    }

    public static void dropTables() throws SQLException {
        try (Connection con = DB.getConnection();
             Statement st = con.createStatement()) {

            System.out.println("Enter your SQL order:\n");
            Scanner sc = new Scanner(System.in);
            String deleteTable = sc.nextLine();

            st.execute(deleteTable);
        }
    }
}
