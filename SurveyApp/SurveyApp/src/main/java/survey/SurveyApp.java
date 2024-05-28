/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package survey;
import javax.swing.*;


/**
 *
 * @author Simamkele Ndwandwa
 */
public class SurveyApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Database.createNewDatabase();
            new SurveyForm().setVisible(true);
        });
    }
}

