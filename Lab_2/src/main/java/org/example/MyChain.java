package org.example;


import dataStructures.Chain;

public class MyChain extends Chain {

    public MyChain(MyChain other) {
        for (int i = 0; i < other.size(); i++) {
            this.add(this.size(), other.get(i)); // or however you add elements
        }
    }

    public MyChain() {
        this.firstNode = null;
        this.size = 0;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size()];

        for (int i = 0; i < size(); i++) {
            arr[i] = this.get(i);
        }
        return arr;
    }

    public void addRange(Object[] elements) {
        for (Object element : elements) {
            this.add(size(), element);
        }
    }

    public MyChain union(MyChain myChain) {
        MyChain unionChain = new MyChain(myChain);
        for (int i = 0; i < this.size(); i++) {
            if (!contains(this.get(i), unionChain)) {
                unionChain.add(unionChain.size(), this.get(i));
            }
        }
        return unionChain;
    }

    private boolean contains(Object element, MyChain chain) {
        for (int i = 0; i < chain.size(); i++) {
            if (chain.get(i).equals(element)) {
                return true;
            }
        }
        return false;
    }

    public MyChain intersection(MyChain chain) {
        MyChain intersection = new MyChain();
        int intersectionSize = intersection.size();
        for (int i = 0; i < this.size(); i++) {
            if (contains(this.get(i), chain)) {
                intersection.add(intersectionSize, this.get(i));
                intersectionSize++;
            }
        }

        return intersection;
    }
}
