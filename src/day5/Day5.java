package day5;

import general.Day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5 extends Day {
    public Day5() {
        super(5);
    }

    private final ArrayList<String> input = new ReadFile("./src/day5/input.txt").read();

    public static void main(String[] args) {
        new Day5().printParts();
    }

    public void parseInput(List<Stack<Character>> stacks, List<List<Integer>> moves) {
        for (String s : input) {
            if (s.startsWith("move")) {
                Matcher m = Pattern.compile("\\d+").matcher(s);
                List<String> matches = new ArrayList<>();
                while (m.find()) {
                    matches.add(m.group(0));
                }

                moves.add(List.of(
                        Integer.parseInt(matches.get(0)),
                        Integer.parseInt(matches.get(1)),
                        Integer.parseInt(matches.get(2))
                ));
            } else {
                int index = s.indexOf('[' );
                while (index >= 0) {
                    int stackToAdd = index / 4;
                    while (stackToAdd >= stacks.size()) {
                        stacks.add(new Stack<>());
                    }
                    stacks.get(stackToAdd).add(s.charAt(index + 1));
                    index = s.indexOf('[', index + 1);
                }
            }
        }

        for (Stack<Character> stack : stacks) {
            Collections.reverse(stack);
        }
    }

    @Override
    public Object part1() {
        List<Stack<Character>> stacks = new ArrayList<>();
        List<List<Integer>> moves = new ArrayList<>();
        parseInput(stacks, moves);

        for (var move : moves) {
            int amount = move.get(0);
            int from = move.get(1) - 1;
            int to = move.get(2) - 1;

            for (int i = 0; i < amount; i++) {
                stacks.get(to).push(stacks.get(from).pop());
            }
        }

        StringBuilder result = new StringBuilder();
        for (Stack<Character> stack : stacks) {
            result.append(stack.peek());
        }
        return result.toString();
    }

    @Override
    public Object part2() {
        List<Stack<Character>> stacks = new ArrayList<>();
        List<List<Integer>> moves = new ArrayList<>();
        parseInput(stacks, moves);

        for (var move : moves) {
            int amount = move.get(0);
            int from = move.get(1) - 1;
            int to = move.get(2) - 1;

            List<Character> tempList = new ArrayList<>();
            for (int i = 0; i < amount; i++) {
//                stacks.get(to).push(stacks.get(from).pop());
                tempList.add(stacks.get(from).pop());
            }
            Collections.reverse(tempList);
            stacks.get(to).addAll(tempList);
        }

        StringBuilder result = new StringBuilder();
        for (Stack<Character> stack : stacks) {
            result.append(stack.peek());
        }
        return result.toString();
    }
}
