package org.example;

public enum FormatoDeTorneo {
    DIRECTA(1),
    DOBLE(2),
    LIGA(3);
    private int id;
    private FormatoDeTorneo(int id) {
        this.id= id;
    }

    public int getId() {
        return id;
    }
}
