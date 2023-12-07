package day1;

import general.Day;

import java.util.ArrayList;
import java.util.Collections;

public class Day1 extends Day {
    public Day1() {
        super(1);
    }

    private final ArrayList<String> input = new Day.ReadFile("./src/day1/input.txt").read();

    public static void main(String[] args) {
        new Day1().printParts();
    }

    @Override
    public Object part1() {
        return calculateCalories().get(0);
    }

    @Override
    public Object part2() {
        ArrayList<Integer> elves = calculateCalories();
        return elves.get(0) + elves.get(1) + elves.get(2);
    }

    public ArrayList<Integer> calculateCalories() {
        ArrayList<Integer> elves = new ArrayList<>();
        int calorieCount = 0;
        for (String calories : input) {
            if (!calories.isEmpty()) {
                calorieCount += Integer.parseInt(calories);
            } else {
                elves.add(calorieCount);
                calorieCount = 0;
            }
        }
        Collections.sort(elves);
        Collections.reverse(elves);
        return elves;
    }
}
