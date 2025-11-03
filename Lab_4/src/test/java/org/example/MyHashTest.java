package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashTest {

    @Test
    void updateElement() {
        MyHash hash = new MyHash(11);

        hash.put(10, "Ten");
        hash.put(20, "Twenty");

        Object oldValue = hash.updateElement(10, "UpdatedTen");
        assertEquals("Ten", oldValue);
        assertEquals("UpdatedTen", hash.get(10));

        assertNull(hash.updateElement(99, "DoesNotExist"), "Should return null if key not found");
    }

    @Test
    void updateKey() {
        MyHash hash = new MyHash(11);

        hash.put(1, "One");
        hash.put(2, "Two");

        Object value = hash.updateKey(1, 11);
        assertEquals("One", hash.get(11));
    }

    @Test
    void delete() {
        MyHash hash = new MyHash(11);
        hash.put("A", 100);
        hash.put("B", 200);

        hash.delete("A");
        assertNull(hash.get("A"));
        assertEquals(200, hash.get("B"));

        hash.delete("C");
        assertEquals(200, hash.get("B"));
    }
}