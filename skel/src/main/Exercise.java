package main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise {

    public void solve(Scanner sc, BufferedWriter bw) throws IOException {
        String wordToChange = sc.nextLine();
        String replacement = sc.nextLine();

        while (sc.hasNext()) {
            String newLine = sc.nextLine();

            if (newLine.contains(wordToChange)) {
                String replaced = newLine.replace(wordToChange, replacement);
                bw.write(replaced);
            } else bw.write(newLine);

            if (sc.hasNext()) bw.write("\n");
        }
        bw.flush();
    }
}

