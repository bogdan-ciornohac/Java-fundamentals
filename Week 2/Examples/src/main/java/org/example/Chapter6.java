package org.example;

abstract class Bird {
    private final void fly() {
        System.out.println("Bird");
    }

    protected Bird() {
        System.out.print("Wow-");
    }
}

public class Chapter6 extends Bird {
    public Chapter6() {
        System.out.print("Oh-");
    }

    protected void fly() {
        System.out.println("Pelican");
    }

    public static void main(String[] args) {
        var chirp = new Chapter6();
        chirp.fly();
    }
}