package org.example;



public class Main{
    String getNumOfGills() { return "14"; }

    public static void main(String[] args) {
        Object o = new Object();
        String proba = "";
        Chapter7.main(args);
        Chapter8 c8 = new Chapter8();

        c8.start();

    }
}

class Mammal {
    private void sneeze() {
    }

    public Mammal(int age) {
        System.out.print("Mammal");
    }
}
