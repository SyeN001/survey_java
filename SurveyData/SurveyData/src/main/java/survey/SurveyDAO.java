/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package survey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Simamkele Ndwandwa
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SurveyDAO extends MySQLConnection {
	// Method to insert a new survey response
	public void insertSurveyResponse(SurveyResponse response) {
		String query = "INSERT INTO survey_responses (name, age, favorite_food, rating, date_submitted, like_pizza, "
                        + "eat_out, rating_eat_out) VALUES (?, ?, ?, ?, NOW(), ?, ?, ?)";
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, response.getName());
			stmt.setInt(2, response.getAge());
			stmt.setString(3, response.getFavoriteFood());
			stmt.setInt(4, response.getRating());
			stmt.setBoolean(5, response.isLikePizza());
			stmt.setBoolean(6, response.isEatOut());
			stmt.setInt(7, response.getRatingEatOut());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Method to retrieve all survey responses
	public List<SurveyResponse> getAllSurveyResponses() {
		String query = "SELECT * FROM survey_responses";
		try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query);
                        ResultSet resultSet = stmt.executeQuery()) {
			List<SurveyResponse> responses = new ArrayList<>();
			while (resultSet.next()) {
				SurveyResponse response = new SurveyResponse();
				response.setId(resultSet.getInt("id"));
				response.setName(resultSet.getString("name"));
				response.setAge(resultSet.getInt("age"));
				response.setFavoriteFood(resultSet.getString("favorite_food"));
				response.setRating(resultSet.getInt("rating"));
				response.setDateSubmitted(resultSet.getTimestamp("date_submitted"));
				response.setLikePizza(resultSet.getBoolean("like_pizza"));
				response.setEatOut(resultSet.getBoolean("eat_out"));
				response.setRatingEatOut(resultSet.getInt("rating_eat_out"));
				responses.add(response);
			}
			return responses;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Add more methods for update, delete, and other operations as needed
}
