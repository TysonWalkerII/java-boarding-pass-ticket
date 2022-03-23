package BoardingPassGUI;

import javax.swing.*;
import java.awt.*;

public class BoardingPassGUI {
    private JFrame frame;
    private JPanel panel;

    private JTextField userName;
    private JTextField userEmail;
    private JTextField userPhoneNumber;
    private JTextField userGender;
    private JTextField userAge;
    private JTextField userDate;
    private JTextField userDestination;
    private JTextField userDepartureTime;

    private JButton submitButton;

    public BoardingPassGUI() {
        frame = new JFrame();
        frame.setSize(500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel);

        panel.add(userName = new JTextField());
        panel.add(userEmail = new JTextField());
        panel.add(userPhoneNumber = new JTextField());
        panel.add(userGender = new JTextField());
        panel.add(userAge = new JTextField());
        panel.add(userDate = new JTextField());
        panel.add(userDestination = new JTextField());
        panel.add(userDepartureTime = new JTextField());

        panel.add(submitButton = new JButton("Submit"));

        frame.setVisible(true);
    }
}
