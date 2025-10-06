package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    private MyStack stack;

    @BeforeEach
    void setUp() {
        stack = new MyStack();
    }

    @Test
    void Initialize() {
        assertTrue(stack.empty());
        assertEquals(0, stack.size());
    }

    @Test
    void Push() {
        stack.push("A");
        assertFalse(stack.empty());
        assertEquals(1, stack.size());
        assertEquals("A", stack.peek());
    }

    @Test
    void PushMany() {
        stack.push("A");
        stack.push("B");
        stack.push("C");

        assertEquals(3, stack.size());
        assertEquals("C", stack.peek());
    }

    @Test
    void Pop() {
        stack.push("X");
        stack.push("Y");

        assertEquals("Y", stack.pop());
        assertEquals(1, stack.size());
        assertEquals("X", stack.peek());
    }

    @Test
    void PopOnEmpty() {
        assertTrue(stack.empty());
        assertThrows(NoSuchElementException.class, () -> stack.pop());
    }

    @Test
    void Peek() {
        stack.push(100);
        stack.push(200);

        assertEquals(200, stack.peek());
        assertEquals(2, stack.size());
        assertEquals(200, stack.peek());
    }

    @Test
    void PeekOnEmpty() {
        assertThrows(NoSuchElementException.class, () -> stack.peek());
    }

    @Test
    void isEmpty() {
        assertTrue(stack.empty());
        stack.push("item");
        assertFalse(stack.empty());
        stack.pop();
        assertTrue(stack.empty());
    }

    @Test
    void Size() {
        assertEquals(0, stack.size());
        stack.push("a");
        assertEquals(1, stack.size());
        stack.push("b");
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
    }

    @Test
    void InputStack() {
        List<Object> input = List.of("first", "second", "third");
        stack.inputStack(input);

        assertEquals(3, stack.size());
        assertEquals("third", stack.peek());
    }

    @Test
    void CombineStack() {
        stack.push("A");
        stack.push("B");

        List<Object> other = List.of("C", "D");
        MyStack combined = stack.combineStack(other);

        assertEquals(4, combined.size());
        assertEquals("D", combined.peek());

        assertEquals(2, stack.size());
        assertEquals("B", stack.peek());
    }

    @Test
    void SplitStackEvenSize() {
        stack.inputStack(List.of(1, 2, 3, 4));
        assertDoesNotThrow(() -> stack.splitStack());
    }

    @Test
    void SplitStackOddSize() {
        stack.inputStack(List.of("a", "b", "c"));
        assertDoesNotThrow(() -> stack.splitStack());
    }

    @Test
    void SplitStackEmpty() {
        assertDoesNotThrow(() -> stack.splitStack());
    }

    @Test
    void PrintStack() {
        assertDoesNotThrow(() -> stack.printStack());

        stack.push("test");
        assertDoesNotThrow(() -> stack.printStack());
    }
}