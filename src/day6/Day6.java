package day6;

import general.Day;

public class Day6 extends Day {
    public Day6() {
        super(6);
    }

    private final String input = new ReadFile("./src/day6/input.txt").read().get(0);

    public static void main(String[] args) {
        new Day6().printParts();
    }

    @Override
    public Object part1() {
        for (int i = 0; i < input.length() - 3; i++) {
            String substr = input.substring(i, i + 4);
            if (substr.chars().distinct().count() == 4) {
                return i + 4;
            }
        }
        return 0;
    }

    @Override
    public Object part2() {
        for (int i = 0; i < input.length() - 13; i++) {
            String substr = input.substring(i, i + 14);
            if (substr.chars().distinct().count() == 14) {
                return i + 14;
            }
        }
        return 0;
    }
}
