package org.example.oopshka;

import java.sql.*;

public class ShowTables {

    public static void printTables() throws SQLException {
        String sql = """
            SELECT table_name
            FROM information_schema.tables
            WHERE table_schema = 'public'
        """;

        try (Connection con = DB.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("Tables in database:");
            while (rs.next()) {
                System.out.println(rs.getString("table_name"));
            }
        }
    }
}