/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package survey;
    
import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 *
 * @author Simamkele Ndwandwa
 */
public class SurveyResults extends JFrame { 
    final SurveyService surveyService;

    public SurveyResults() {
        surveyService = new SurveyService();
        createResultsView();
    }

    private void createResultsView() {
        setTitle("Survey Results");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        List<Survey> surveys = surveyService.getAllSurveys();

        if (surveys.isEmpty()) {
            add(new JLabel("No Surveys Available"));
        } else {
            int totalSurveys = surveys.size();
            double averageAge = surveys.stream().mapToInt(Survey::getAge).average().orElse(0);
            int maxAge = surveys.stream().mapToInt(Survey::getAge).max().orElse(0);
            int minAge = surveys.stream().mapToInt(Survey::getAge).min().orElse(0);
            long likesPizzaCount = surveys.stream().filter(Survey::isLikesPizza).count();
            long likesPastaCount = surveys.stream().filter(Survey::isLikesPasta).count();
            long likesPapAndWorsCount = surveys.stream().filter(Survey::isLikesPapAndWors).count();

            double avgRatingMovies = surveys.stream().mapToInt(Survey::getRatingMovies).average().orElse(0);
            double avgRatingRadio = surveys.stream().mapToInt(Survey::getRatingRadio).average().orElse(0);
            double avgRatingEatingOut = surveys.stream().mapToInt(Survey::getRatingEatingOut).average().orElse(0);
            double avgRatingTV = surveys.stream().mapToInt(Survey::getRatingTV).average().orElse(0);

            add(new JLabel("Total number of surveys: " + totalSurveys));
            add(new JLabel("Average age: " + String.format("%.1f", averageAge)));
            add(new JLabel("Oldest person who participated in survey: " + maxAge));
            add(new JLabel("Youngest person who participated in survey: " + minAge));
            add(new JLabel("Percentage of people who like Pizza: " + String.format("%.1f", (likesPizzaCount * 100.0) / totalSurveys) + "%"));
            add(new JLabel("Percentage of people who like Pasta: " + String.format("%.1f", (likesPastaCount * 100.0) / totalSurveys) + "%"));
            add(new JLabel("Percentage of people who like Pap and Wors: " + String.format("%.1f", (likesPapAndWorsCount * 100.0) / totalSurveys) + "%"));
            add(new JLabel("Average rating for Movies: " + String.format("%.1f", avgRatingMovies)));
            add(new JLabel("Average rating for Radio: " + String.format("%.1f", avgRatingRadio)));
            add(new JLabel("Average rating for Eating Out: " + String.format("%.1f", avgRatingEatingOut)));
            add(new JLabel("Average rating for TV: " + String.format("%.1f", avgRatingTV)));
        }
    }
}
