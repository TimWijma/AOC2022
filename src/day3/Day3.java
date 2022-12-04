package day3;

import general.Day2021;

import java.util.ArrayList;

public class Day3 extends Day2021 {
    public Day3() {
        super(3);
    }

    private final ArrayList<String> input = new ReadFile("./src/day3/input.txt").read();

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
        int prioritySum = 0;
        for (int i = 0; i < input.size() / 3; i++) {
            for (char letter: input.get(i * 3).toCharArray()) {
                if (input.get(i * 3).indexOf(letter) != -1 && input.get(i * 3 + 1).indexOf(letter) != -1 && input.get(i * 3 + 2).indexOf(letter) != -1) {
                    prioritySum += getPriority(letter);
                    break;
                }
            }

        }
        return prioritySum;
    }

    public int getPriority(int code) {
        if (code >= 65 && code <= 90) {
            return code - 38;
        } else {
            return code - 96;
        }
    }
}
