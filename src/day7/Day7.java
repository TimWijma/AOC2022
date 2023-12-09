package day7;

import general.Day;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Day7 extends Day {
    public Day7() {
        super(7);
    }

    private final List<String> input = new ReadFile("./src/day7/input.txt").read();

    public static void main(String[] args) {
        new Day7().printParts();
    }

    @Override
    public Object part1() {
        Directory home = createFileSystem();

        AtomicInteger sum = new AtomicInteger(0);
        loopDirectories(home, sum);

        return sum;
    }

    @Override
    public Object part2() {
        Directory home = createFileSystem();

        AtomicInteger smallest = new AtomicInteger(Integer.MAX_VALUE);
        smallestDelete(home, home.size, smallest);

        return smallest;
    }

    public Directory createFileSystem() {
        Directory home = new Directory("/", null);
        home.parent = home;
        Directory currentDir = home;

        for(String command: input) {
            if (command.equals("$ cd /")) {
                currentDir = home;
                continue;
            }

            String[] arguments = command.split(" ");
            if (arguments[0].equals("$")) {
                if (arguments[1].equals("cd")) {
                    if (arguments[2].equals("..")) {
                        currentDir = currentDir.parent;
                    } else {
                        currentDir = currentDir.subDirectories.get(arguments[2]);
                    }
                }
            } else {
                if (arguments[0].equals("dir")) {
                    currentDir.subDirectories.put(arguments[1], new Directory(arguments[1], currentDir));
                } else {
                    File file = new File(arguments[1], Integer.parseInt(arguments[0]));
                    currentDir.files.add(file);

                    Directory temp = currentDir;
                    temp.size += file.size;
                    while (!temp.name.equals("/")) {
                        temp = temp.parent;
                        temp.size += file.size;
                    }
                }
            }
        }

        return home;
    }

    public void loopDirectories(Directory directory, AtomicInteger sum) {
        if(!directory.subDirectories.isEmpty()) {
            for (Directory subDir: directory.subDirectories.values()) {
                if (subDir.size < 100000) {
                    sum.addAndGet(subDir.size);
                }
                loopDirectories(subDir, sum);
            }
        }
    }

    public void smallestDelete(Directory directory, int totalFileSize, AtomicInteger sum) {
        if(!directory.subDirectories.isEmpty()) {
            for (Directory subDir: directory.subDirectories.values()) {
                int updateSize = totalFileSize - subDir.size;

                if (70000000 - updateSize > 30000000) {
                    sum.set(Math.min(sum.get(), subDir.size));
                }
                smallestDelete(subDir, totalFileSize, sum);
            }
        }
    }
}

class File {
    public String name;
    public int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }
}

class Directory {
    public String name;
    public int size;
    public List<File> files;
    public Map<String, Directory> subDirectories;
    public Directory parent;

    public Directory(String name, Directory parent) {
        this.name = name;
        this.size = 0;
        this.files = new ArrayList<>();
        this.subDirectories = new HashMap<>();
        this.parent = parent;
    }
}