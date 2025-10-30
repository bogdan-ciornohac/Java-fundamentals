package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collectors;

public class Chapter8 {
    public void start(){
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();

        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();

        System.out.println(d1);
        System.out.println(d2);
        // Built in functional interface exercises
        //1.Check is a number is even
        System.out.println("\nFunctional interfaces exercises");
        Predicate<Integer> checkIsEven = num -> num % 2 == 0;
        System.out.println(checkIsEven.test(10));
        System.out.println(checkIsEven.test(21));

        //2.Convert a string to uppercase
        Function<String,String> toUpperCase = String::toUpperCase;
        System.out.println(toUpperCase.apply("TesssTTtttTTTtt"));

        //3.Print each element of a list
        List<String> list = List.of("alex","andrei","bogdan");
        Consumer<String> printList = System.out::println;
        list.forEach(printList);

        //4.Provide a default random number
        Random rand = new Random();
        Supplier<Double> randNum = () -> rand.nextDouble();

        System.out.println(randNum.get());

        //5.Check if a string start with A
        Predicate<String> predicate = str -> str.startsWith("A") && str.length() > 3;
        System.out.println(predicate.test("Ana"));
        System.out.println(predicate.test("Andrew"));


        Predicate<String> startsWithA = str -> str.startsWith("A");
        Predicate<String> longerThan3 = str -> str.length() > 3;
        Predicate<String> condition = startsWithA.and(longerThan3);

        System.out.println(condition.test("Ana"));
        System.out.println(condition.test("Andrew"));

        //6.Convert a number to string and get its length
        Function<Integer,String> convertToString = String::valueOf;
        Function<String,Integer> getStringLength = String::length;
        Function<Integer,Integer> convertAndMeasure = convertToString.andThen(getStringLength);

        System.out.println(convertAndMeasure.apply(129));

        //7.Print a greeting for each username
        Consumer<String> printHello = s -> System.out.println("Hello "+s+"!");
        Consumer<String> printGreeting = printHello.andThen(s -> System.out.println("Have a nice day"));

        printGreeting.accept("Alex");

        //8.Return a constant message
        Supplier<String> messageSupplier = () -> "Hello World!";

        System.out.println(messageSupplier.get());

        class Person{
            private int age;

            Person(int age){
                this.age = age;
            }

            @Override
            public String toString() {
                return "Person{" +
                        "age=" + age +
                        '}';
            }
        }

        //9.Filter a list of  people older than 18
        List<Person> people = List.of(new Person(12), new Person(19),new Person(21),new Person(10));
        Predicate<Person> checkAge = person -> person.age > 18;

        List<Person> adults = people.stream().filter(checkAge).toList();
        adults.forEach(System.out::println);

        //10.Transform a list of integers into their squares
        List<Integer> nums = List.of(1,2,3,4,5);
        Function<Integer, Integer> square = num -> num*num;

        nums.stream().map(square).forEach(System.out::println);

        //11.Print all employees salaries with prefix
        class Employee{
            private double salary;
            Employee(double salary){
                this.salary = salary;
            }
        }

        List<Employee> employees = List.of(new Employee(1200), new Employee(1900),new Employee(1000));
        Consumer<Employee>  printEmployee = employee -> System.out.println("Salary: "+employee.salary);

        employees.forEach(printEmployee);

       method();

        int length = 3;

        for (int i = 0; i<3; i++) {
            if (i%2 == 0) {
                Supplier<Integer> supplier = () -> length; // A
                System.out.println(supplier.get());        // B
            } else {
                int j = i;
                Supplier<Integer> supplier = () -> j;      // C
                System.out.println(supplier.get());        // D
            }
        }
        Set<?> set = Set.of("lion", "tiger", "bear");
        var s = Set.copyOf(set);
        Consumer<Object> consumer =  System.out::println;
        s.forEach(consumer);

    }
    public void method() {
        x((var x) -> {}, (var x, var y) -> false);
    }
    public void x(Consumer<String> x, BinaryOperator<Boolean> y) {}

    public void remove(List<Character> chars) {
        char end = 'z';
        Predicate<Character> predicate = c -> {
            char start = 'a'; return start <= c && c <= end; };

        char start = 'a';
    }
}
