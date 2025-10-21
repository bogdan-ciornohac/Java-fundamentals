import java.util.Arrays;
import java.util.Random;

public class Main {
    int count;

    {
        System.out.print(count + "-");
    }

    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextInt(10));

        System.out.printf("Proba:%d\n",1);
        final var one = 1;

        String block = """
                 "doe\"""
                 "deer\"""
                """;
        System.out.println("*" + block + "*");

        var blocky = """
                squirrel \s
                pigeon   \
                termite""";
        System.out.print(blocky);

        var num1 = Integer.parseInt("11");
        var num2 = Integer.valueOf("B", 16);
        System.out.println(Integer.max(num1, num2));

        double x = 39.21;
        float y = 2.1f;
        var z = x + y;

        boolean healthy;
        if (healthy = false)
            System.out.print("Good!");

        long ear = 10000000000l;
        short sosd = (short) ear;
        System.out.println(sosd);
        int pig = (short) 4;
        long goat = (int) 2;
        goat -= 1.0;

        printDetails(123.0f);
        Number zooPatrons = Integer.valueOf(1_000);

        String birds = "Jay";
        for (String bird : birds.split(""))  // DOES NOT COMPILE
            System.out.print(bird + " ");

        if (num1 < 6) System.out.println("Too Low");
        else System.out.println("Just Right");

        printReptile(6);
        String a = "abc";
        String b = a.toUpperCase();
        b = b.replace("B", "2").replace('C', '3');
        System.out.println("a=" + a);
        System.out.println("b=" + b);

        var builder = new StringBuilder("pigeon dirty");
        builder.replace(3, 100, "");
        System.out.println(builder);


        
    }



    void compareIntegers(Number number) {
        if (number instanceof Integer data) {
            System.out.print(data.compareTo(5));
        }
    }

    public static void printDetails(Number height) {
        String message = switch (height) {
            case Integer i -> "Rounded: " + i;
            case Double d -> "Precise: " + d;
            case Number n -> "Unknown: " + n;

        };

        var tailFeathers = 3;
        final var one = 1;
        switch (tailFeathers) {
            case one: System.out.print(3 + " ");
            default: case 3: System.out.print(5 + " ");
        }
        System.out.print(message);
    }

    public static void printReptile(int category) {
        var type = switch (category) {
            case 1, 2 -> {
                yield "Snake";
            }
            case 3, 4 -> "Lizard";
            case 5, 6 -> "Turtle";
            case 7, 8 -> "Alligator";
            default -> throw new IllegalStateException("Unexpected value: " + category);
        };
        System.out.print(type);
    }

    void getHatSize(Number measurement) {
        boolean keepGoing = true;
        int result = 15, meters = 10;
        do {
            meters--;
            if (meters==8) keepGoing = false;
            result -= 2;
        } while (keepGoing);
    }
}
