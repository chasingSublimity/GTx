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
}