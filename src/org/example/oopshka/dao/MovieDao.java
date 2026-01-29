package org.example.oopshka.dao;

import org.example.oopshka.DB;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;
import Movie.Movie;

@Repository
public class MovieDao {



    public int insertMovie(Movie m) throws SQLException {
        String sql = "INSERT INTO movies(name, duration, description, year) VALUES (?, ?, ?, ?) RETURNING id";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, m.getName());
            ps.setString(2, m.getDuration());
            ps.setString(3, m.getDescription());
            ps.setInt(4, m.getYear());

            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                int id = rs.getInt(1);
                m.setId(id);
                return id;
            }
        }
    }

    public void MovieaddColumn(String name) throws SQLException{
        String sql = "ALTER TABLE movies ADD COLUMN " + name + " VARCHAR(320)";

        try (Connection con = DB.getConnection();
             Statement abob = con.createStatement()) {
            abob.execute(sql);
        }
    }

    public List<Movie> getAllMovies() throws SQLException {
        String sql = "SELECT id, name, duration, description, year FROM movies ORDER BY id";
        List<Movie> list = new ArrayList<>();

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Movie(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("duration"),
                        rs.getString("description"),
                        rs.getInt("year")
                ));
            }
        }
        return list;
    }

    public boolean updateMovieYear(int id, int newYear) throws SQLException {
        String sql = "UPDATE movies SET year = ? WHERE id = ?";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, newYear);
            ps.setInt(2, id);
            return ps.executeUpdate() == 1;
        }
    }

    public boolean updateMovieName(int id, String newName) throws SQLException{
        String sql = "UPDATE movies SET name = ? WHERE id = ?";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, newName);
            ps.setInt(2, id);
            return ps.executeUpdate() == 1;
        }
    }

    public boolean updateMovieDescription(int id, String newDescription) throws SQLException{
        String sql = "UPDATE movies SET description = ? WHERE id = ?";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, newDescription);
            ps.setInt(2, id);
            return ps.executeUpdate() == 1;
        }
    }

    public boolean deleteMovie(int id) throws SQLException {
        String sql = "DELETE FROM movies WHERE id = ?";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        }
    }
}
