package day4;

import general.Day2021;

import java.util.ArrayList;
import java.util.Arrays;

public class Day4 extends Day2021 {
    public Day4() {
        super(4);
    }

    private final ArrayList<String> input = new ReadFile("./src/day4/input.txt").read();

    public static void main(String[] args) {
        new Day4().printParts();
    }

    @Override
    public Object part1() {
        int overlapping = 0;
        for (String line: input) {
            int[] pairs = Arrays.stream(line.split("[-,]")).mapToInt(Integer::parseInt).toArray();
            int A1 = pairs[0];
            int A2 = pairs[1];
            int B1 = pairs[2];
            int B2 = pairs[3];

            if (A1 >= B1 && A1 <= B2 && A2 <= B2 && A2 >= B1) {
                overlapping++;
            } else if (B1 >= A1 && B1 <= A2 && B2 <= A2 && B2 >= A1) {
                overlapping++;
            }
        }
        return overlapping;
    }

    @Override
    public Object part2() {
        int overlapping = 0;
        for (String line: input) {
            int[] pairs = Arrays.stream(line.split("[-,]")).mapToInt(Integer::parseInt).toArray();
            int A1 = pairs[0];
            int A2 = pairs[1];
            int B1 = pairs[2];
            int B2 = pairs[3];

            if (A1 <= B1 && A2 >= B1) {
                overlapping++;
            } else if (B1 <= A1 && B2 >= A1) {
                overlapping++;
            }
        }
        return overlapping;
    }
}
