package general;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Day {

    protected final int day;

    public Day(int day) {
        this.day = day;
    }

    public abstract Object part1();
    public abstract Object part2();

    public void printParts() {
        System.out.println("Part 1: " + part1());
        System.out.println("Part 2: " + part2());
    }
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

        public ArrayList<Integer> readIntArray() {
            String[] input = read().get(0).split(",");
            ArrayList<Integer> result = new ArrayList<>();

            for (String num : input) {
                result.add(Integer.parseInt(num));
            }

            return result;
        }

        public ArrayList<ArrayList<String>> readStringArray() {
            ArrayList<String> input = read();
            ArrayList<ArrayList<String>> result = new ArrayList<>();

            for (String line : input) {
                result.add(new ArrayList<>(List.of(line.split(" "))));
            }

            return result;
        }
    }
}
