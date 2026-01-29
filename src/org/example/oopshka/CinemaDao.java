package org.example.oopshka;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Cinema.Cinema;

public class CinemaDao {

    public int insertCinema(Cinema m) throws SQLException {
        String sql = "INSERT INTO cinema(name, hallscount) VALUES (?, ?) RETURNING id";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, m.getName());
            ps.setInt(2, m.getHallsCount());

            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                int id = rs.getInt(1);
                m.setId(id);
                return id;
            }
        }
    }

    public List<Cinema> getAllCinemas() throws SQLException {
        String sql = "SELECT id, name, hallscount FROM cinema ORDER BY id";
        List<Cinema> list = new ArrayList<>();

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Cinema(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("hallscount")
                ));
            }
        }
        return list;
    }

    public boolean updateCinemahallscount(int id, int newHallsCount) throws SQLException {
        String sql = "UPDATE cinema SET hallscount = ? WHERE id = ?";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, newHallsCount);
            ps.setInt(2, id);
            return ps.executeUpdate() == 1;
        }
    }

    public boolean updateCinemaName(int id, String newName) throws SQLException{
        String sql = "UPDATE cinema SET name = ? WHERE id = ?";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, newName);
            ps.setInt(2, id);
            return ps.executeUpdate() == 1;
        }
    }

    public boolean deleteCinema(int id) throws SQLException {
        String sql = "DELETE FROM cinema WHERE id = ?";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        }
    }
}
