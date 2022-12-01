package day1;

import general.Day;

import java.util.ArrayList;
import java.util.Collections;

public class Day1 {

    private static final ArrayList<Integer> elves = new ArrayList<>();
    private static final ArrayList<String> input = new Day.ReadFile("./src/day1/input.txt").read();


    public static void main(String[] args) {
        calculateCalories();
        Collections.sort(elves);
        Collections.reverse(elves);
        System.out.println("Part 1: " + elves.get(0));
        System.out.println("Part 2: " + (elves.get(0) + elves.get(1) + elves.get(2)));
    }

    public static void calculateCalories() {
        int calorieCount = 0;
        for (String calories : input) {
            if (!calories.equals("")) {
                calorieCount += Integer.parseInt(calories);
            } else {
                elves.add(calorieCount);
                calorieCount = 0;
            }
        }
    }
}
