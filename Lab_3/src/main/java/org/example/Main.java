package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static MyStack stack = new MyStack();
    private static List<MyStack> combinedStacks = new ArrayList<>();

    static void main() {
        String zaavar = """
                0. Garah
                1. Stack oruulah
                2. Stack hevleh
                3. Stack salgah
                4. Stack negtgeh
                """;
        IO.println(zaavar);

        String input = IO.readln();
        while (!input.equals("0")) {
            switch (input) {
                case "1":
                    IO.println("oruulah elementuudee zaigaar tusgaarlaj oruulna uu!");
                    String[] data = IO.readln().split("\\s+");
                    for (String element : data) {
                        stack.push(element);
                    }
                    break;
                case "2":
                    IO.println("-----------------ORIGINAL----------------");
                    stack.printStack();
                    IO.println();
                    IO.println("-----------------COMBINED----------------");
                    for (MyStack s : combinedStacks) {
                        s.printStack();
                    }
                    break;
                case "3":
                    stack.splitStack();
                    IO.println();
                    break;
                case "4":
                    IO.println("shine stack iin elementuudiig zaigaar tusgaarlaj oruulna uu");
                    List<Object> newStack = List.of(IO.readln().split("\\s+"));
                    MyStack combination = stack.combineStack(newStack);
                    combinedStacks.add(combination);
                    IO.println(combination + "\n");
                    break;
            }
            IO.println(zaavar);
            input = IO.readln();
        }
    }
}
