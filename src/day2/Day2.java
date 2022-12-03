package day2;

import general.Day2021;

import java.util.ArrayList;
import java.util.HashMap;

public class Day2 extends Day2021 {
    public Day2() {
        super(2);
    }

    private final ArrayList<String> input = new ReadFile("./src/day2/input.txt").read();

    public static void main(String[] args) {
        new Day2().printParts();
    }

    @Override
    public Object part1() {
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put("A X", 4); // rock -> rock = 3 + 1
        scores.put("A Y", 8); // paper -> rock = 6 + 2
        scores.put("A Z", 3); // scissors -> rock = 0 + 3
        scores.put("B X", 1); // rock -> paper = 0 + 1
        scores.put("B Y", 5); // paper -> paper = 3 + 2
        scores.put("B Z", 9); // scissors -> paper = 6 + 3
        scores.put("C X", 7); // rock -> scissors = 1 + 6
        scores.put("C Y", 2); // paper -> scissors = 0 + 2
        scores.put("C Z", 6); // scissors -> scissors = 3 + 3
        int score = 0;
        for (String line: input) {
            score += scores.get(line);
        }
        return score;
    }

    @Override
    public Object part2() {
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put("A X", 3); // lose against rock
        scores.put("A Y", 4); // draw
        scores.put("A Z", 8); // win against rock
        scores.put("B X", 1); // lose against paper
        scores.put("B Y", 5); // draw
        scores.put("B Z", 9); // win against paper
        scores.put("C X", 2); // lose against scissors
        scores.put("C Y", 6); // draw
        scores.put("C Z", 7); // win against scissors
        int score = 0;
        for (String line: input) {
            score += scores.get(line);
        }
        return score;
    }
}
