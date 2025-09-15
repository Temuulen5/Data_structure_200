package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyChainTest {

    @Test
    void toArray() {
        MyChain myChain = new MyChain();
        myChain.add(0, "Hello");
        myChain.add(1, 45);
        myChain.add(2, false);

        Object[] chainArray = myChain.toArray();
        Object[] result = {"Hello", 45, false};

        assertArrayEquals(result, chainArray);
    }

    @Test
    void addRange() {
        Object[] elements = {"apple", 7};
        MyChain myChain = new MyChain();
        myChain.add(0, "Hello");
        myChain.add(1, 45);
        myChain.add(2, false);
        myChain.addRange(elements);

        Object[] result = {"Hello", 45, false, "apple", 7};

        assertArrayEquals(result, myChain.toArray());
    }

    @Test
    void union() {
        MyChain chain1 = new MyChain();
        chain1.add(0, 1);
        chain1.add(1, false);
        chain1.add(2, 3);
        MyChain chain2 = new MyChain();
        chain2.add(0, 3);
        chain2.add(1, 4);
        MyChain union = chain2.union(chain1);

        Object[] result = {1, false, 3, 4};

        assertArrayEquals(result, union.toArray());
    }

    @Test
    void intersection() {
        MyChain chain1 = new MyChain();
        chain1.add(0, 1);
        chain1.add(1, false);
        chain1.add(2, 3);
        MyChain chain2 = new MyChain();
        chain2.add(0, 3);
        chain2.add(1, false);
        chain2.add(2, 4);
        MyChain intersection = chain2.intersection(chain1);

        Object[] result = {3, false};

        assertArrayEquals(result, intersection.toArray());
    }
}