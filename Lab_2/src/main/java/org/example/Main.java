package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<MyChain> chains = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String zaavar = """
                
                0. Garah
                1. Shine chain uusgeh 
                2. Chain dotorh elementuudiig harah
                3. Chain dotor element nemeh 
                4. Chain ustgah
                5. Chain negdeliig harah
                6. Chain ogtloliig harah
                """;
        System.out.println(zaavar);

        String input = scanner.nextLine();
        while (!input.equals("0")) {
            switch (input) {
                case "1":
                    createChain();
                    break;
                case "2":
                    getElements();
                    break;
                case "3":
                    addElement();
                    break;
                case "4":
                    deleteChain();
                    break;
                case "5":
                    getUnion();
                    break;
                case "6":
                    getIntersection();
                    break;
            }
            System.out.println(zaavar);
            input = scanner.nextLine();
        }
    }

    private static void createChain() {
        MyChain chain = new MyChain();
        chains.add(chain);
        System.out.println("Amjilttai chain nemlee.");
    }

    private static void getChainSize() {
        for (int i = 0; i < chains.size(); i++) {
            System.out.printf("%d index deh chain %d elementtei.\n", i, chains.get(i).size());
        }
    }

    private static void getElements() {
        for (int i = 0; i < chains.size(); i++) {
            System.out.printf("%d index deh chain %d elementtei.\n", i, chains.get(i).size());
            for (int j = 0; j < chains.get(i).size(); j++) {
                System.out.printf("     %d. %s\n", j + 1, chains.get(i).get(j).toString());
            }
        }
    }

    private static void addElement() {
        System.out.println("hed deh indexiin chain iig songoh ve?");
        String index = scanner.nextLine();
        if (!index.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("Zovhon too oruulna uu!");
        }
        int convertedIndex = Integer.parseInt(index);
        if (convertedIndex < 0 || convertedIndex >= chains.size()) {
            throw new IndexOutOfBoundsException("Bolomjit index oruulna uu!");
        }

        System.out.println("Oruulah elementuudee zaigaar tusgaarlaj bichne uu : ");
        String[] elements = scanner.nextLine().split("\\s+");
        chains.get(convertedIndex).addRange(elements);
        System.out.println("Amjilttai nemlee");
    }

    private static void deleteChain() {
        System.out.println("hed deh indexiin chain iig songoh ve?");
        String index = scanner.nextLine();
        if (!index.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("Zovhon too oruulna uu!");
        }
        int convertedIndex = Integer.parseInt(index);
        if (convertedIndex < 0 || convertedIndex >= chains.size()) {
            throw new IndexOutOfBoundsException("Bolomjit index oruulna uu!");
        }
        chains.remove(convertedIndex);
    }

    private static void getUnion() {
        System.out.println("hed hed deh indexiin chain iig songoh ve? (2 index iig zaigaar tusgaarlaj oruulna)");
        String[] index = scanner.nextLine().split("\\s+");
        if (index.length != 2) {
            throw new IllegalArgumentException("2 indexiig zaigaar tusgaarlaj oruulna!");
        }
        if (!index[0].matches("^[0-9]+$") || !index[1].matches("^[0-9]+$")) {
            throw new IllegalArgumentException("Zovhon too oruulna uu!");
        }

        int convertedIndex1 = Integer.parseInt(index[0]);
        int convertedIndex2 = Integer.parseInt(index[1]);
        System.out.println(chains.get(convertedIndex1).union(chains.get(convertedIndex2)));
    }

    private static void getIntersection() {
        System.out.println("hed hed deh indexiin chain iig songoh ve?");
        String[] index = scanner.nextLine().split("\\s+");
        if (!index[0].matches("^[0-9]+$") || !index[1].matches("^[0-9]+$")) {
            throw new IllegalArgumentException("Zovhon too oruulna uu!");
        }
        int convertedIndex1 = Integer.parseInt(index[0]);
        int convertedIndex2 = Integer.parseInt(index[1]);
        System.out.println(chains.get(convertedIndex1).intersection(chains.get(convertedIndex2)));
    }
}