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

public class SurveyForm extends JFrame {
    private JTextField nameField;
    private JTextField ageField;
    private JTextField emailField;
    private JTextField dobField; // Date of Birth field
    private JTextField contactNumberField;
    private JCheckBox pizzaCheckBox;
    private JCheckBox pastaCheckBox;
    private JCheckBox papAndWorsCheckBox;
    private JCheckBox otherCheckBox;
    private JRadioButton[][] ratingButtons;
    private JButton submitButton;
    private JButton viewResultsButton;
    private final SurveyService surveyService;

    public SurveyForm() {
        surveyService = new SurveyService();
        createForm();
    }

    private void createForm() {
        setTitle("Lifestyle Preferences Survey");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 1;

        nameField = new JTextField(20);
        ageField = new JTextField(20);
        emailField = new JTextField(20);
        dobField = new JTextField(20); // For simplicity, use a text field for Date of Birth
        contactNumberField = new JTextField(20);

        pizzaCheckBox = new JCheckBox("Pizza");
        pastaCheckBox = new JCheckBox("Pasta");
        papAndWorsCheckBox = new JCheckBox("Pap and Wors");
        otherCheckBox = new JCheckBox("Other");

        ratingButtons = new JRadioButton[4][5];
        for (int i = 0; i < 4; i++) {
            ButtonGroup group = new ButtonGroup();
            for (int j = 0; j < 5; j++) {
                ratingButtons[i][j] = new JRadioButton();
                group.add(ratingButtons[i][j]);
            }
        }

        submitButton = new JButton("Submit");
        viewResultsButton = new JButton("View Survey Results");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });

        viewResultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SurveyResults().setVisible(true);
            }
        });

        // Placing "View Survey Results" button at the top right corner
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        add(viewResultsButton, gbc);

        // Resetting constraints for the rest of the form
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = 1;
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(new JLabel("Full Name(s):"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(new JLabel("Age:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        add(ageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        add(new JLabel("Date of Birth:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        add(dobField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        add(new JLabel("Contact Number:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        add(contactNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        add(new JLabel("Favorite Food:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        add(pizzaCheckBox, gbc);
        gbc.gridx = 2;
        add(pastaCheckBox, gbc);
        gbc.gridx = 3;
        add(papAndWorsCheckBox, gbc);
        gbc.gridx = 4;
        add(otherCheckBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        add(new JLabel("Please rate your level of agreement on a scale from 1 to 5, with 1 being 'Strongly Agree' and 5 being 'Strongly Disagree'."), gbc);

        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        add(new JLabel("Strongly Agree"), gbc);
        gbc.gridx = 2;
        gbc.insets = new Insets(5, 20, 5, 5);
        add(new JLabel("Agree"), gbc);
        gbc.gridx = 3;
        gbc.insets = new Insets(5, 40, 5, 5);
        add(new JLabel("Neutral"), gbc);
        gbc.gridx = 4;
        gbc.insets = new Insets(5, 60, 5, 5);
        add(new JLabel("Disagree"), gbc);
        gbc.gridx = 5;
        gbc.insets = new Insets(5, 80, 5, 5);
        add(new JLabel("Strongly Disagree"), gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        addRatingRow(gbc, 9, "I like to watch movies:", ratingButtons[0]);
        addRatingRow(gbc, 10, "I like to listen to radio:", ratingButtons[1]);
        addRatingRow(gbc, 11, "I like to eat out:", ratingButtons[2]);
        addRatingRow(gbc, 12, "I like to watch TV:", ratingButtons[3]);

        gbc.gridy = 13;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        add(submitButton, gbc);
    }

    private void addRatingRow(GridBagConstraints gbc, int row, String label, JRadioButton[] buttons) {
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel(label), gbc);
        gbc.insets = new Insets(5, 10, 5, 5); // Push Strongly Agree buttons 2 steps to the left
        for (int i = 0; i < buttons.length; i++) {
            switch (i) {
                case 1 -> gbc.insets = new Insets(5, 30, 5, 5); // Agree buttons pushed to the right
                case 2 -> gbc.insets = new Insets(5, 60, 5, 5); // Neutral buttons pushed 3 steps to the right
                case 3 -> gbc.insets = new Insets(5, 90, 5, 5); // Disagree buttons pushed 6 steps to the right
                case 4 -> gbc.insets = new Insets(5, 120, 5, 5); // Strongly Disagree buttons pushed 6 steps to the right
            }
            gbc.gridx = i + 1;
            add(buttons[i], gbc);
        }
        gbc.insets = new Insets(5, 5, 5, 5); // Reset insets for the next row
    }

    private void handleSubmit() {
        // Validation for Full Name(s)
        String fullName = nameField.getText().trim();
        if (fullName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your Full Name(s).");
            return;
        }
        int age;
        try {
            age = Integer.parseInt(ageField.getText());
            if (age < 5 || age > 120) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid age between 5 and 120.");
            return;
        }

        // Validation for Email
        String email = emailField.getText().trim();
        if (email.isEmpty() || !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address.");
            return;
        }

        // Validation for Contact Number
        String contactNumber = contactNumberField.getText().trim();
        if (contactNumber.isEmpty() || !contactNumber.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid 10-digit contact number.");
            return;
        }

        boolean likesPizza = pizzaCheckBox.isSelected();
        boolean likesPasta = pastaCheckBox.isSelected();
        boolean likesPapAndWors = papAndWorsCheckBox.isSelected();
        boolean likesOther = otherCheckBox.isSelected();
        int ratingMovies = getSelectedRating(ratingButtons[0]);
        int ratingRadio = getSelectedRating(ratingButtons[1]);
        int ratingEatingOut = getSelectedRating(ratingButtons[2]);
        int ratingTV = getSelectedRating(ratingButtons[3]);

        if (ratingMovies == -1 || ratingRadio == -1 || ratingEatingOut == -1 || ratingTV == -1) {
            JOptionPane.showMessageDialog(this, "Please select a rating for all categories.");
            return;
        }

        // If all validations pass, proceed to save survey
        Survey survey = new Survey();
        survey.setFullName(fullName); // Use setFullName instead of setName
        survey.setAge(age);
        survey.setLikesPizza(likesPizza);
        survey.setLikesPasta(likesPasta);
        survey.setLikesPapAndWors(likesPapAndWors);
        survey.setLikesOther(likesOther);
        survey.setRatingMovies(ratingMovies);
        survey.setRatingRadio(ratingRadio);
        survey.setRatingEatingOut(ratingEatingOut);
        survey.setRatingTV(ratingTV);

        surveyService.saveSurvey(survey);
        JOptionPane.showMessageDialog(this, "Survey submitted successfully!");
        clearForm();
    }

    private int getSelectedRating(JRadioButton[] buttons) {
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].isSelected()) {
                return i + 1;
            }
        }
        return -1;
    }

    private void clearForm() {
        nameField.setText("");
        ageField.setText("");
        dobField.setText("");
        contactNumberField.setText("");
        pizzaCheckBox.setSelected(false);
        pastaCheckBox.setSelected(false);
        papAndWorsCheckBox.setSelected(false);
        otherCheckBox.setSelected(false);

        for (JRadioButton[] buttonGroup : ratingButtons) {
            clearButtonGroup(buttonGroup);
        }
    }

    private void clearButtonGroup(JRadioButton[] buttons) {
        for (JRadioButton button : buttons) {
            button.setSelected(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SurveyForm().setVisible(true);
            }
        });
    }
}
