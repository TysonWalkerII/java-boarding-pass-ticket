package BoardingPassGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class BoardingPassGUI {
    private JFrame frame;

    private JPanel namePanel;
    private JLabel nameLabel;
    private JTextField nameTextField;

    private JPanel emailPanel;
    private JLabel emailLabel;
    private JTextField emailTextField;

    private JPanel phoneNumberPanel;
    private JLabel phoneNumberLabel;
    private JTextField phoneNumberTextField;

    private JPanel genderPanel;
    private JLabel genderLabel;
    private JTextField genderTextField;

    private JPanel agePanel;
    private JLabel ageLabel;
    private JTextField ageTextField;

    private JPanel datePanel;
    private JLabel dateLabel;
    private JTextField dateTextField;

    private JPanel destinationPanel;
    private JLabel destinationLabel;
    private JTextField destinationTextField;

    private JPanel departureTimePanel;
    private JLabel departureTimeLabel;
    private JTextField departureTimeTextField;

    private JPanel submitButtonPanel;
    private JButton submitButton;

    public BoardingPassGUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Generate Boarding Pass");
        frame.setLayout(new GridLayout(9, 1, 10, 5));
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        namePanel = new JPanel(new BorderLayout(10, 0));
        namePanel.add(nameLabel = new JLabel("Name: "), BorderLayout.WEST);
        namePanel.add(nameTextField = new JTextField(20), BorderLayout.EAST);
        namePanel.setBorder(padding);
        frame.add(namePanel);

        emailPanel = new JPanel(new BorderLayout(10, 0));
        emailPanel.add(emailLabel = new JLabel("Email: "), BorderLayout.WEST);
        emailPanel.add(emailTextField = new JTextField(20), BorderLayout.EAST);
        emailPanel.setBorder(padding);
        frame.add(emailPanel);

        phoneNumberPanel = new JPanel(new BorderLayout(10, 0));
        phoneNumberPanel.add(phoneNumberLabel = new JLabel("Phone Number: "), BorderLayout.WEST);
        phoneNumberPanel.add(phoneNumberTextField = new JTextField(20), BorderLayout.EAST);
        phoneNumberPanel.setBorder(padding);
        frame.add(phoneNumberPanel);

        genderPanel = new JPanel(new BorderLayout(10, 0));
        genderPanel.add(genderLabel = new JLabel("Gender: "), BorderLayout.WEST);
        genderPanel.add(genderTextField = new JTextField(20), BorderLayout.EAST);
        genderPanel.setBorder(padding);
        frame.add(genderPanel);

        agePanel = new JPanel(new BorderLayout(10, 0));
        agePanel.add(ageLabel = new JLabel("Age: "), BorderLayout.WEST);
        agePanel.add(ageTextField = new JTextField(20), BorderLayout.EAST);
        agePanel.setBorder(padding);
        frame.add(agePanel);

        datePanel = new JPanel(new BorderLayout(10, 0));
        datePanel.add(dateLabel = new JLabel("Date: "), BorderLayout.WEST);
        datePanel.add(dateTextField = new JTextField(20), BorderLayout.EAST);
        datePanel.setBorder(padding);
        frame.add(datePanel);

        destinationPanel = new JPanel(new BorderLayout(10, 0));
        destinationPanel.add(destinationLabel = new JLabel("Destination: "), BorderLayout.WEST);
        destinationPanel.add(destinationTextField = new JTextField(20), BorderLayout.EAST);
        destinationPanel.setBorder(padding);
        frame.add(destinationPanel);

        departureTimePanel = new JPanel(new BorderLayout(10, 0));
        departureTimePanel.add(departureTimeLabel = new JLabel("DepartureTime: "), BorderLayout.WEST);
        departureTimePanel.add(departureTimeTextField = new JTextField(20), BorderLayout.EAST);
        departureTimePanel.setBorder(padding);
        frame.add(departureTimePanel);

        submitButtonPanel = new JPanel(new BorderLayout(10, 0));
        submitButtonPanel.add(submitButton = new JButton("Submit"), BorderLayout.CENTER);
        submitButtonPanel.setBorder(padding);
        frame.add(submitButtonPanel);

        frame.pack();
        frame.setVisible(true);
    }
}
