/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package survey;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Simamkele Ndwandwa
 */
public class SurveyGUI extends JFrame {
	// GUI components
	private JTextField nameField;
	private JTextField ageField;
	private JCheckBox pizzaCheckBox;
	private JCheckBox sushiCheckBox;
	private JCheckBox tacosCheckBox;
	private JRadioButton rating1;
	private JRadioButton rating2;
	private JRadioButton rating3;
	private JRadioButton rating4;
	private JRadioButton rating5;
	private JButton submitButton;

	public SurveyGUI() {
		setTitle("Survey Application");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		// Add labels and text fields
		add(new JLabel("Name:"));
		nameField = new JTextField(20);
		add(nameField);

		add(new JLabel("Age:"));
		ageField = new JTextField(5);
		add(ageField);

		// Add checkboxes
		pizzaCheckBox = new JCheckBox("Pizza");
		sushiCheckBox = new JCheckBox("Sushi");
		tacosCheckBox = new JCheckBox("Tacos");
		add(pizzaCheckBox);
		add(sushiCheckBox);
		add(tacosCheckBox);

		// Add radio buttons
		rating1 = new JRadioButton("1");
		rating2 = new JRadioButton("2");
		rating3 = new JRadioButton("3");
		rating4 = new JRadioButton("4");
		rating5 = new JRadioButton("5");
		add(rating1);
		add(rating2);
		add(rating3);
		add(rating4);
		add(rating5);

		// Add submit button
		//submitButton = new JButton("Submit");
		//add(submitButton);
        submitButton.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = nameField.getText();
		int age = Integer.parseInt(ageField.getText());
		boolean likePizza = pizzaCheckBox.isSelected();
		boolean likeSushi = sushiCheckBox.isSelected();
		boolean likeTacos = tacosCheckBox.isSelected();
		int rating = getSelectedRating();
		
		SurveyResponse response = new SurveyResponse();
		response.setName(name);
		response.setAge(age);
		response.setLikePizza(likePizza);
		response.setLikeSushi(likeSushi);
		response.setLikeTacos(likeTacos);
		response.setRating(rating);
		
		SurveyDAO surveyDAO = new SurveyDAO();
		surveyDAO.insertSurveyResponse(response);
		
		// Clear the input fields
		nameField.setText("");
		ageField.setText("");
		pizzaCheckBox.setSelected(false);
		sushiCheckBox.setSelected(false);
		tacosCheckBox.setSelected(false);
		rating1.setSelected(false);
		rating2.setSelected(false);
		rating3.setSelected(false);
		rating4.setSelected(false);
		rating5.setSelected(false);
	}
});

// Helper method to get the selected rating
       private int getSelectedRating() {
	if (rating1.isSelected()) {
		return 1;
	} else if (rating2.isSelected()) {
		return 2;
	} else if (rating3.isSelected()) {
		return 3;
	} else if (rating4.isSelected()) {
		return 4;
	} else if (rating5.isSelected()) {
		return 5;
	} else {
		return 0;
	}
}
		// Add action listener to submit button
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Call the insertSurveyResponse method here
			}
		
	// Create a new JPanel to display survey statistics
     JPanel statisticsPanel = new JPanel();
     statisticsPanel.setLayout(new FlowLayout());

// Add a JTextArea to display the statistics
JTextArea statisticsTextArea = new JTextArea(10, 20);
statisticsPanel.add(statisticsTextArea);

// Call the calculateStatistics method to display the statistics
SurveyStatistics surveyStatistics = new SurveyStatistics();
surveyStatistics.calculateStatistics(responses);

// Add the statisticsPanel to the main GUI
add(statisticsPanel, BorderLayout.SOUTH);

