package test;

import java.io.*;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import main.Exercise;
import org.junit.Assert;

public class Checker {
  public static long filesCompareByLine(String path1, String path2) throws IOException {
    try (BufferedReader bf1 = new BufferedReader(new FileReader(path1));
        BufferedReader bf2 = new BufferedReader(new FileReader(path2))) {

      long lineNumber = 1;
      String line1 = "", line2 = "";
      while ((line1 = bf1.readLine()) != null) {
        line2 = bf2.readLine();
        if (line2 == null || !line1.equals(line2)) {
          return lineNumber;
        }
        lineNumber++;
      }
      if (bf2.readLine() == null) {
        return -1;
      } else {
        return lineNumber;
      }
    }
  }

  public static void testCase(int testNumber) {

    File inputFile = new File("./test/in/test" + String.valueOf(testNumber) + "a.in");
      File inputFile2 = new File("./test/in/test" + String.valueOf(testNumber) + "b.in");
    String outputPath = "./test/out/test" + String.valueOf(testNumber) + ".out";
    String referencePath = "./test/ref/test" + String.valueOf(testNumber) + ".ref";

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("./test/out/", "test" + String.valueOf(testNumber) + ".out")));
         Scanner sc1 = new Scanner(new FileReader(inputFile));
         Scanner sc2 = new Scanner(new FileReader(inputFile2))) {

      Exercise exercise = new Exercise();
      exercise.solve(sc1, sc2, bw);

      long differingLine = filesCompareByLine(outputPath, referencePath);
      Assert.assertEquals(differingLine, -1);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    testCase(1);
  }
}
