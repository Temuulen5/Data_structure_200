package org.example;

import dataStructures.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MyStack implements Stack {

    public MyStack() {
        this.elements = new ArrayList<>();
    }

    private List<Object> elements;

    @Override
    public boolean empty() {
        return this.elements.isEmpty();
    }

    @Override
    public Object peek() {
        if (this.elements.isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.elements.get(this.elements.size() - 1);
    }

    @Override
    public Object pop() {
        if (this.elements.isEmpty()) {
            throw new NoSuchElementException();
        }
        Object obj = this.elements.get(this.elements.size() - 1);
        this.elements.remove(this.elements.size() - 1);
        return obj;
    }

    @Override
    public void push(Object theObject) {
        this.elements.addLast(theObject);
    }

    public int size() {
        return this.elements.size();
    }

    public void inputStack(List<Object> elements) {
        for (Object element : elements) {
            this.elements.add(element);
        }
    }

    public void printStack() {
        for (int i = 0; i < this.size(); i++) {
            IO.print("    " + this.elements.get(i));
        }
        IO.println("");
    }

    public void PrintStack(MyStack myStack) {
        for (int i = 0; i < myStack.size(); i++) {
            IO.print("    " + myStack.elements.get(i));
        }
        IO.println("");
    }

    public void splitStack() {
        int splitIndex = this.elements.size() / 2;

        List<Object> group1 = new ArrayList<>();
        for (int i = 0; i < splitIndex; i++) {
            group1.add(this.elements.get(i));
        }
        IO.println(group1);

        List<Object> group2 = new ArrayList<>();
        for (int i = splitIndex; i < this.elements.size(); i++) {
            group2.add(this.elements.get(i));
        }
        IO.println(group2);
    }

    public MyStack combineStack(List<Object> stack) {
        MyStack combination = new MyStack();
        combination.inputStack(this.elements);
        combination.inputStack(stack);
        return combination;
    }
}
