/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package survey;
import java.util.List;
/**
 *
 * @author Simamkele Ndwandwa
 */
public class SurveyStatistics {
   
     public void calculateStatistics(List<SurveyResponse> responses) {
		int totalSurveys = responses.size();
		double averageAge = calculateAverageAge(responses);
		double pizzaPercentage = calculatePercentage(responses, "Pizza");
		double sushiPercentage = calculatePercentage(responses, "Sushi");
		double tacosPercentage = calculatePercentage(responses, "Tacos");
		double averageRating = calculateAverageRating(responses);
		
		displayStatistics(totalSurveys, averageAge, pizzaPercentage, sushiPercentage, 
                        tacosPercentage, averageRating);
	}
	
	private double calculateAverageAge(List<SurveyResponse> responses) {
		// Calculate average age
         return 0;
		// Calculate average age
	}
	
	private double calculatePercentage(List<SurveyResponse> responses, String foodOption) {
		// Calculate percentage of people who like the given food option
         return 0;
		// Calculate percentage of people who like the given food option
	}
	
	private double calculateAverageRating(List<SurveyResponse> responses) {
		// Calculate average rating
         return 0;
		// Calculate average rating
	}
	
	private void displayStatistics(int totalSurveys, double averageAge, double pizzaPercentage, double sushiPercentage, double tacosPercentage, double averageRating) {
		// Display survey statistics in a GUI component
	}
}
