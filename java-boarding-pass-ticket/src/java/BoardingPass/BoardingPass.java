package BoardingPass;

import java.util.Random;

public class BoardingPass {
    private String name;
    private String email;
    private String phoneNumber;

    private String gender;
    private String age;
    private String date;
    private String origin;
    private String destination;                 //TODO maybe change types of certain variables later
    private String departureTime;
    private String estimatedTimeArrival;
    private String ticketPrice;
    private String boardingPassNumber;

    private static final String ALPHANUMERIC = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789"; // Took out easily-confused characters 0-O, 1-I

    public BoardingPass(String name, String email, String phoneNumber, String gender, String age, String date, String origin, String destination, String departureTime) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
        this.date = date;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;

        this.estimatedTimeArrival = generateTimeArrival();
        this.ticketPrice = generateTicketPrice();
        this.boardingPassNumber = generateBoardingPassNumber();
    }

    private String generateTimeArrival() {          // TODO
        return null;
    }

    private String generateTicketPrice() {          // TODO
        return null;
    }

    private String generateBoardingPassNumber() {   // TODO maybe check if duplicate exists (very unlikely)
        Random rand = new Random();
        StringBuilder passNum = new StringBuilder(); // Mutable, and more memory efficient than using String
        for (int i = 0; i <= 15; i++) {
            passNum.append(ALPHANUMERIC.charAt(rand.nextInt(ALPHANUMERIC.length())));
        }
        return passNum.toString();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getDate() {
        return date;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getEstimatedTimeArrival() {
        return estimatedTimeArrival;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public String getBoardingPassNumber() {
        return boardingPassNumber;
    }
}
