package org.example;
import java.util.ArrayList;

abstract class Listas<item> {
    protected ArrayList<item> Lista;

    public Listas() {
        Lista = new ArrayList<>();
    }

    public void add(item a) {
        Lista.add(a);
    }
    public item get() {
        if (!Lista.isEmpty()) {
            return Lista.removeFirst();
        } else {
            return null;
        }
    }
}