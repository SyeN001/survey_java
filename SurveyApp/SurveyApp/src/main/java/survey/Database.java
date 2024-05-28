/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package survey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Simamkele Ndwandwa
 */
public class Database {
    
    private static final String DB_URL = "jdbc:sqlite:survey.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createNewDatabase() {
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            if (conn != null) {
                stmt.execute("CREATE TABLE IF NOT EXISTS surveys (\n"
                        + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                        + " name TEXT NOT NULL,\n"
                        + " age INTEGER NOT NULL,\n"
                        + " likesPizza BOOLEAN,\n"
                        + " likesPasta BOOLEAN,\n"
                        + " likesPapAndWors BOOLEAN,\n"
                        + " likesOther BOOLEAN,\n"
                        + " ratingMovies INTEGER,\n"
                        + " ratingRadio INTEGER,\n"
                        + " ratingEatingOut INTEGER,\n"
                        + " ratingTV INTEGER\n"
                        + ");");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

