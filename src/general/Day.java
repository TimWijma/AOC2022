package general;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day {
    public static class ReadFile {
        private final String path;

        public ReadFile(String path) {
            this.path = path;
        }

        public ArrayList<String> read() {

            ArrayList<String> result = new ArrayList<>();

            try {
                File input = new File(path);
                Scanner myReader = new Scanner(input);
                while (myReader.hasNextLine()) {
                    result.add(myReader.nextLine());
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            return result;
        }
    }
}
