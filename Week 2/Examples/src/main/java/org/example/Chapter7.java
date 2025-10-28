package org.example;

interface Visitors {
    void printVisitors();
}

enum SeasonWithVisitors implements Visitors {
    WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium");

    private final String visitors;
    public static final String DESCRIPTION = "Weather enum";

    private SeasonWithVisitors(String visitors) {
        System.out.print("constructing,");
        System.out.println(visitors);
        this.visitors = visitors;
    }

    @Override
    public void printVisitors() {
        System.out.println(visitors);
    }
}

public class Chapter7 {
    public static void main(String[] args) {
        System.out.print("begin,");
        var firstCall = SeasonWithVisitors.SUMMER;
        System.out.print("middle,");
        var secondCall = SeasonWithVisitors.SUMMER;
        System.out.print("end");
    }
}
