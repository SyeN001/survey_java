/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package survey;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Simamkele Ndwandwa
 */
public class SurveyService {
    
    private static final String DATABASE_URL = "jdbc:sqlite:survey.db";

    public void saveSurvey(Survey survey) {
        String sql = "INSERT INTO surveys(name, age, likesPizza, likesPasta, "
                + "likesPapAndWors, likesOther, ratingMovies, ratingRadio, "
                + "ratingEatingOut, ratingTV) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, survey.getName());
            pstmt.setInt(2, survey.getAge());
            pstmt.setBoolean(3, survey.isLikesPizza());
            pstmt.setBoolean(4, survey.isLikesPasta());
            pstmt.setBoolean(5, survey.isLikesPapAndWors());
            pstmt.setBoolean(6, survey.isLikesOther());
            pstmt.setInt(7, survey.getRatingMovies());
            pstmt.setInt(8, survey.getRatingRadio());
            pstmt.setInt(9, survey.getRatingEatingOut());
            pstmt.setInt(10, survey.getRatingTV());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Survey> getAllSurveys() {
        List<Survey> surveys = new ArrayList<>();
        String sql = "SELECT * FROM surveys";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Survey survey = new Survey();
                survey.setId(rs.getInt("id"));
                survey.setFullName(rs.getString("name"));
                survey.setAge(rs.getInt("age"));
                survey.setLikesPizza(rs.getBoolean("likesPizza"));
                survey.setLikesPasta(rs.getBoolean("likesPasta"));
                survey.setLikesPapAndWors(rs.getBoolean("likesPapAndWors"));
                survey.setLikesOther(rs.getBoolean("likesOther"));
                survey.setRatingMovies(rs.getInt("ratingMovies"));
                survey.setRatingRadio(rs.getInt("ratingRadio"));
                survey.setRatingEatingOut(rs.getInt("ratingEatingOut"));
                survey.setRatingTV(rs.getInt("ratingTV"));
                surveys.add(survey);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return surveys;
    }

    public int getTotalNumberOfSurveys() {
        String sql = "SELECT COUNT(*) FROM surveys";
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public double getAverageAge() {
        String sql = "SELECT AVG(age) FROM surveys";
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public int getOldestPersonAge() {
        String sql = "SELECT MAX(age) FROM surveys";
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public int getYoungestPersonAge() {
        String sql = "SELECT MIN(age) FROM surveys";
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public double getPercentageOfPeopleWhoLikePizza() {
        String sql = "SELECT (SUM(CASE WHEN likesPizza = 1 THEN 1 ELSE 0 END) * 100.0 / COUNT(*)) FROM surveys";
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public double getPercentageOfPeopleWhoLikePasta() {
        String sql = "SELECT (SUM(CASE WHEN likesPasta = 1 THEN 1 ELSE 0 END) * 100.0 / COUNT(*)) FROM surveys";
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public double getPercentageOfPeopleWhoLikePapAndWors() {
        String sql = "SELECT (SUM(CASE WHEN likesPapAndWors = 1 THEN 1 ELSE 0 END) * 100.0 / COUNT(*)) FROM surveys";
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public double getAverageRatingMovies() {
        String sql = "SELECT AVG(ratingMovies) FROM surveys";
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public double getAverageRatingRadio() {
        String sql = "SELECT AVG(ratingRadio) FROM surveys";
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public double getAverageRatingEatingOut() {
        String sql = "SELECT AVG(ratingEatingOut) FROM surveys";
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public double getAverageRatingTV() {
        String sql = "SELECT AVG(ratingTV) FROM surveys";
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
