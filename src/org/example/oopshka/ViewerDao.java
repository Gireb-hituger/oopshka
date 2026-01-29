package org.example.oopshka;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Viewer.Viewer;

public class ViewerDao {

    public int insertViewer(Viewer v) throws SQLException {
        String sql = "INSERT INTO viewers(first_name, last_name, movie) VALUES (?, ?, ?) RETURNING id";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, v.getFirstName());
            ps.setString(2, v.getLastName());
            ps.setString(3, v.getMovie());

            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                int id = rs.getInt(1);
                // v.setId(id); // если добавишь setId
                return id;
            }
        }
    }

    public List<Viewer> getAllViewers() throws SQLException {
        String sql = "SELECT id, first_name, last_name, movie FROM viewers ORDER BY id";
        List<Viewer> list = new ArrayList<>();

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Viewer(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("movie")
                ));
            }
        }
        return list;
    }

    public boolean updateViewerMovie(int id, String newMovie) throws SQLException {
        String sql = "UPDATE viewers SET movie = ? WHERE id = ?";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, newMovie);
            ps.setInt(2, id);
            return ps.executeUpdate() == 1;
        }
    }

    public boolean updateViewerFirstName(int id, String firstName) throws SQLException {
        String sql = "UPDATE viewers SET firstName = ? WHERE id = ?";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, firstName);
            ps.setInt(2, id);
            return ps.executeUpdate() == 1;
        }
    }

    public boolean updateViewerLastName(int id, String lastName) throws SQLException {
        String sql = "UPDATE viewers SET lastName = ? WHERE id = ?";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, lastName);
            ps.setInt(2, id);
            return ps.executeUpdate() == 1;
        }
    }



    public boolean deleteViewer(int id) throws SQLException {
        String sql = "DELETE FROM viewers WHERE id = ?";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        }
    }
}
