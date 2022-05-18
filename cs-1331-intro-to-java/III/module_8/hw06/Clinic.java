import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class Clinic {
  File patientFile;
  int day;

  public Clinic (File file) {
    this.patientFile = file;
    this.day = 1;
  }

  public Clinic(String fileName) {
    this(new File(fileName));
  }

  String nextDay(File f) throws FileNotFoundException {
    Scanner input = new Scanner(System.in);
    Scanner fileScan = null;
    String patientsSeen = "";

    try {
      fileScan = new Scanner(f);
      String line = null;
      String[] tokens = null;
  
      while (fileScan.hasNextLine()) {
        line = fileScan.nextLine();
        tokens = line.split(",");

        String name = tokens[0];
        String type = tokens[1];
        if (type.equals("Cat") && type.equals("Dog")) {
          throw new InvalidPetException();
        }

        System.out.printf(
          "Consultation for %s the %s at %s.\nWhat is the health of %s?\n",
          name, type, tokens[3], name
        );

        boolean success = false;
        double health = 0;
        while (!success) {
          try {
            health = input.nextDouble();
            success = true;
          } catch (InputMismatchException e) {
            input.nextLine();
            System.out.println("Please try again");
            System.out.println("What is the health?");
          }
        }

          success = false;
          int painLevel = 0;
          while (!success) {
            try {
              System.out.printf(
                "On a scale of 10, how much pain is %s in right now?\n",
                name
              );
              painLevel = input.nextInt();
              success = true;

            } catch (InputMismatchException e) {
              input.nextLine();
              System.out.println("Please enter a number");
            }
          }

        Pet p = type.equals("Dog")
          ? new Dog(name, health, painLevel, Double.parseDouble(tokens[2]))
          : new Cat(name, health, painLevel, Integer.parseInt(tokens[2]));

        p.speak();
        int timeToTreat = p.treat();
        String timeOut = addTime(tokens[3], timeToTreat);
        patientsSeen += String.format(
          "%s,%s,%s,%s,%s,%s,%f,%d\n",  
          name, type, tokens[2], day, tokens[3], timeOut, health, painLevel
        );
      }
    } finally {
      day++;
      if (fileScan != null) {
        fileScan.close();
      }
      input.close();

    }
    return patientsSeen;
  }

  String nextDay(String fileName) throws FileNotFoundException {
    return nextDay(new File(fileName));
  }

  private String addTime(String timeIn, int treatmentTime) {
    int parsedTimeIn = Integer.parseInt(timeIn);
    return Integer.toString(parsedTimeIn - treatmentTime);
  }

  boolean addToFile(String patientInfo) {
    Scanner fileScan = new Scanner(patientInfo);
    String[] patientTokens = patientInfo.split(",");

    boolean isNewPatient = false;
    while (fileScan.hasNextLine()) {
      String line = null;
      String[] tokens = null;
      line = fileScan.nextLine();
      tokens = line.split(",");

      String name = tokens[0];
      if (patientInfo.indexOf(name) > 0) {
        isNewPatient = true;
        break;
      }
    }
    fileScan.close();

    Boolean wasWriteSuccessful = true;
    PrintWriter filePrint = null;
    try {
      filePrint = new PrintWriter(patientFile);
      
      String printString = isNewPatient
        ? String.format(
            "%s,%s,%d,%s,%d,%d,%f,%d\n",
            patientTokens[0], patientTokens[1], Integer.parseInt(patientTokens[2]),
            patientTokens[3], patientTokens[4], patientTokens[5], 
            Double.parseDouble(patientTokens[6]), Integer.parseInt(patientTokens[7])
          ) 
        : String.format(
          "%s,%s,%s,%s,%f,%d\n",
          patientTokens[0], patientTokens[3], patientTokens[4], patientTokens[5], 
          Double.parseDouble(patientTokens[6]), Integer.parseInt(patientTokens[7])
        );

        filePrint.append(printString);
    } catch (FileNotFoundException e) {
      wasWriteSuccessful = false;
    } finally {
      if (filePrint != null) {
        filePrint.close();   
      }
    }
    return wasWriteSuccessful;
  }
}