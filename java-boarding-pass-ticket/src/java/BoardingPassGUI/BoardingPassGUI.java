package BoardingPassGUI;

import BoardingPass.BoardingPass;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.ParseException;
import java.util.Locale;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;

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
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JRadioButton otherGenderRadioButton;

    private JPanel agePanel;
    private JLabel ageLabel;
    private JSpinner ageSpinner;

    private JPanel datePanel;
    private JLabel dateLabel;
    private DatePicker datePicker;

    private JPanel originPanel;
    private JLabel originLabel;
    private JTextField originTextField;

    private JPanel destinationPanel;
    private JLabel destinationLabel;
    private JTextField destinationTextField;

    private JPanel departureTimePanel;
    private JLabel departureTimeLabel;
    private DateTimePicker departureTimePicker;

    private JPanel submitButtonPanel;
    private JButton submitButton;

    public BoardingPassGUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Generate Boarding Pass");
        frame.setLayout(new GridLayout(10, 1, 10, 5));
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

        genderPanel = new JPanel(new GridLayout(1, 4,10, 0));
        genderPanel.add(genderLabel = new JLabel("Gender: "));
        genderPanel.add(maleRadioButton = new JRadioButton("Male"));
        genderPanel.add(femaleRadioButton = new JRadioButton("Female"));
        genderPanel.add(otherGenderRadioButton = new JRadioButton("Other"));
        ButtonGroup bg = new ButtonGroup();
        bg.add(maleRadioButton); bg.add(femaleRadioButton); bg.add(otherGenderRadioButton);

        genderPanel.setBorder(padding);
        frame.add(genderPanel);

        agePanel = new JPanel(new BorderLayout(10, 0));
        agePanel.add(ageLabel = new JLabel("Age: "), BorderLayout.WEST);
        agePanel.add(ageSpinner = new JSpinner(new SpinnerNumberModel(1,1,999,1)), BorderLayout.EAST);
        Component ageSpinnerEditor = ageSpinner.getEditor();
        JFormattedTextField jftf = ((JSpinner.DefaultEditor) ageSpinnerEditor).getTextField();
        jftf.setColumns(10);
        ((NumberFormatter) jftf.getFormatter()).setAllowsInvalid(false);

        agePanel.setBorder(padding);
        frame.add(agePanel);

        datePanel = new JPanel(new BorderLayout(10, 0));
        datePanel.add(dateLabel = new JLabel("Date: "), BorderLayout.WEST);
        DatePickerSettings datePickerSettings = new DatePickerSettings(Locale.getDefault());
        datePickerSettings.setAllowEmptyDates(false);
        datePanel.add(datePicker = new DatePicker(datePickerSettings), BorderLayout.EAST);
        datePanel.setBorder(padding);
        frame.add(datePanel);

        originPanel = new JPanel(new BorderLayout(10, 0));
        originPanel.add(originLabel = new JLabel("Origin: "), BorderLayout.WEST);
        originPanel.add(originTextField = new JTextField(20), BorderLayout.EAST);
        originPanel.setBorder(padding);
        frame.add(originPanel);

        destinationPanel = new JPanel(new BorderLayout(10, 0));
        destinationPanel.add(destinationLabel = new JLabel("Destination: "), BorderLayout.WEST);
        destinationPanel.add(destinationTextField = new JTextField(20), BorderLayout.EAST);
        destinationPanel.setBorder(padding);
        frame.add(destinationPanel);

        departureTimePanel = new JPanel(new BorderLayout(10, 0));
        departureTimePanel.add(departureTimeLabel = new JLabel("DepartureTime: "), BorderLayout.WEST);
        DatePickerSettings datePickerSettings2 = new DatePickerSettings(Locale.getDefault());
        datePickerSettings2.setAllowEmptyDates(false);
        TimePickerSettings timePickerSettings = new TimePickerSettings(Locale.getDefault());
        timePickerSettings.setAllowEmptyTimes(false);
        timePickerSettings.generatePotentialMenuTimes(TimePickerSettings.TimeIncrement.FifteenMinutes, null, null);
        departureTimePanel.add(departureTimePicker = new DateTimePicker(datePickerSettings2, timePickerSettings), BorderLayout.EAST);
        departureTimePanel.setBorder(padding);
        frame.add(departureTimePanel);

        submitButtonPanel = new JPanel(new BorderLayout(10, 0));
        submitButtonPanel.add(submitButton = new JButton("Submit"), BorderLayout.CENTER);
        submitButton.addActionListener(a -> createBoardingPass());
        submitButtonPanel.setBorder(padding);
        frame.add(submitButtonPanel);

        frame.pack();
        frame.setVisible(true);
    }

    private void createBoardingPass() {
        try {
            ageSpinner.commitEdit();
        } catch (ParseException e) {
            System.out.println("Issue parsing age field");
            e.printStackTrace();
            return;
        }
        BoardingPass.Gender gender;
        if(maleRadioButton.isSelected())
            gender = BoardingPass.Gender.Male;
        else if(femaleRadioButton.isSelected())
            gender = BoardingPass.Gender.Female;
        else
            gender = BoardingPass.Gender.Other;             // TODO check that fields are not empty
        new BoardingPass(   nameTextField.getText(),
                            emailTextField.getText(),
                            phoneNumberTextField.getText(),
                            gender,
                            (Integer)ageSpinner.getValue(),
                            datePicker.getText(),
                            originTextField.getText(),
                            destinationTextField.getText(),
                            departureTimePicker.getDateTimePermissive().toString()
        );

        frame.getContentPane().removeAll();
        frame.setLayout(new GridLayout(1, 1));

        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        JPanel successPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        JLabel successLabel = new JLabel("Successfully created boarding pass.");
        successPanel.add(successLabel);
        JButton closeButton = new JButton("Close");
        successPanel.add(closeButton);
        closeButton.addActionListener(a -> frame.dispose());
        successPanel.setBorder(padding);

        frame.add(successPanel);
        frame.revalidate();
        frame.repaint();
        frame.pack();
    }
}
