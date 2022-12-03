package day3;

import general.Day2021;

import java.util.ArrayList;

public class Day3 extends Day2021 {
    public Day3() {
        super(3);
    }

    private final ArrayList<String> input = new ReadFile("./src/day3/example.txt").read();

    public static void main(String[] args) {
        new Day3().printParts();
    }

    @Override
    public Object part1() {
        int prioritySum = 0;
        for (String line: input) {
            String halfOne = line.substring(0, (line.length()/2));
            String halfTwo = line.substring((line.length()/2));
            for (char letter: halfOne.toCharArray()) {
                if (halfTwo.indexOf(letter) != -1) {
                    prioritySum += getPriority(letter);
                    break;
                }
            }
        }
        return prioritySum;
    }

    @Override
    public Object part2() {
        for (int i = 0; i < input.size() / 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(i * 3 + j);
            }
        }
        return 0;
    }

    public int getPriority(int code) {
        if (code >= 65 && code <= 90) {
            return code - 38;
        } else {
            return code - 96;
        }
    }
}
