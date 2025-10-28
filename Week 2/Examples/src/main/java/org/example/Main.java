package org.example;

import java.time.LocalDate;

interface Aquatic {
  int getNumOfGills(int p);
 }

public class Main implements  Aquatic {
    String getNumOfGills() { return "14"; }
      int getNumOfGills(int input) { return 15; }
    public static void main(String[] args) {
        Object o = new Object();
        String proba = "";
        Chapter7.main(args);
        System.out.println(new Main().getNumOfGills(-1));
    }
}

class Mammal {
    private void sneeze() {
    }

    public Mammal(int age) {
        System.out.print("Mammal");
    }
}
