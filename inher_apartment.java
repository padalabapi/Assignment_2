import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class ResidentialSociety {
    String societyName;
    String location;
    String secretaryName;

    public ResidentialSociety(String societyName, String location, String secretaryName) {
        this.societyName = societyName;
        this.location = location;
        this.secretaryName = secretaryName;
    }
}

class Building extends ResidentialSociety {
    String buildingName;
    int totalNumberOfApartments;
    ArrayList<Apartment> apartments = new ArrayList<Apartment>();

    public Building(String societyName, String location, String secretaryName, String buildingName, int totalNumberOfApartments) {
        super(societyName, location, secretaryName);
        this.buildingName = buildingName;
        this.totalNumberOfApartments = totalNumberOfApartments;
    }
}

class Apartment extends Building {
    int apartmentNumber;
    String ownerName;
    String electricMeterNumber;

    public Apartment(String societyName, String location, String secretaryName, String buildingName, int totalNumberOfApartments, int apartmentNumber, String ownerName, String electricMeterNumber) {
        super(societyName, location, secretaryName, buildingName, totalNumberOfApartments);
        this.apartmentNumber = apartmentNumber;
        this.ownerName = ownerName;
        this.electricMeterNumber = electricMeterNumber;
    }
}

public class inher_apartment {
    static ArrayList<Apartment> apartments = new ArrayList<Apartment>();

    public static void main(String[] args) {
        // create a residential society object
        ResidentialSociety residentialSociety = new ResidentialSociety("ABC Apartment", "Bangalore", "John Doe");

        // create three building objects
        Building buildingA = new Building(residentialSociety.societyName, residentialSociety.location, residentialSociety.secretaryName, "A", 10);
        Building buildingB = new Building(residentialSociety.societyName, residentialSociety.location, residentialSociety.secretaryName, "B", 10);
        Building buildingC = new Building(residentialSociety.societyName, residentialSociety.location, residentialSociety.secretaryName, "C", 10);

        // read data from CSV file and initialize the apartments
        try {
            BufferedReader reader = new BufferedReader(new FileReader("apartments.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                int apartmentNumber = Integer.parseInt(values[0]);
                String buildingName = values[1];
                String ownerName = values[2];
                String electricMeterNumber = values[3];

                Apartment apartment = new Apartment(residentialSociety.societyName, residentialSociety.location, residentialSociety.secretaryName, buildingName, 10, apartmentNumber, ownerName, electricMeterNumber);
                apartments.add(apartment);
                            // add each apartment object to its respective building
            if (buildingName.equals("A")) {
                buildingA.apartments.add(apartment);
            } else if (buildingName.equals("B")) {
                buildingB.apartments.add(apartment);
            } else if (buildingName.equals("C")) {
                buildingC.apartments.add(apartment);
            }
        }
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    // menu-driven console application to view society, building and apartment information
    Scanner sc = new Scanner(System.in);
    int choice;
    do {
        System.out.println("\nResidential Society Information System");
        System.out.println("1. View Apartment Details");
        System.out.println("2. View Building Details");
        System.out.println("3. View Society Details");
        System.out.println("4. Exit");
        System.out.print("Enter your option: ");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                viewApartmentDetails();
                break;
            case 2:
                viewBuildingDetails();
                break;
            case 3:
                viewSocietyDetails();
                break;
            case 4:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    } while (choice != 4);
    sc.close();
}

// function to view apartment details
public static void viewApartmentDetails() {
    System.out.println("\nApartment Details");
    System.out.println("Apartment Number\tBuilding Name\tOwner Name\tElectric Meter Number");
    for (Apartment apartment : apartments) {
        System.out.println(apartment.apartmentNumber + "\t\t" + apartment.buildingName + "\t\t" + apartment.ownerName + "\t\t" + apartment.electricMeterNumber);
    }
}

// function to view building details
public static void viewBuildingDetails() {
    System.out.println("\nBuilding Details");
    System.out.println("Building Name\tTotal Number of Apartments");
    System.out.println("A\t\t10");
    System.out.println("B\t\t10");
    System.out.println("C\t\t10");
}

// function to view society details
public static void viewSocietyDetails() {
    System.out.println("\nSociety Details");
    System.out.println("Society Name\tLocation\tSecretary Name");
    System.out.println(apartments.get(0).societyName + "\t\t" + apartments.get(0).location + "\t" + apartments.get(0).secretaryName);
}
