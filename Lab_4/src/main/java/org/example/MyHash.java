package org.example;

import dataStructures.HashChains;
import dataStructures.HashTable;

public class MyHash extends HashChains {

    public MyHash(int theDivisor) {
        super(theDivisor);
    }

    public Object updateElement(Object key, Object value) {
        Object object = get(key);
        if (object != null) {
            put(key, value);
        }
        return object;
    }

    public Object updateKey(Object key, Object newKey) {
        Object object = get(key);
        if (object != null) {
            remove(key);
            put(newKey, object);
        }
        return object;
    }

    public void delete(Object key) {
        Object object = get(key);
        if (object != null) {
            remove(key);
        }
    }
}
