package ua.opnu;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
    }

    private static void task1() {
        System.out.println("=== Завдання 1: MyOptional ===");

        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName);
        System.out.println("isPresent: " + middleName.isPresent());
        System.out.println("orElse: " + middleName.orElse("немає"));

        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username);
        System.out.println("isPresent: " + username.isPresent());
        System.out.println("get(): " + username.get());
        System.out.println("orElse: " + username.orElse("guest"));

        try {
            String test = middleName.get();
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        try {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }
    }

    private static void task2() {
        System.out.println("\n=== Завдання 2: BookData ===");

        BookData[] books = {
                new BookData("Clean Code", "R. Martin", 10, 40),
                new BookData("Effective Java", "J. Bloch", 5, 24),
                new BookData("Algorithms", "R. Sedgewick", 8, 32),
                new BookData("Java Puzzlers", "J. Bloch", 4, 16)
        };
        Arrays.sort(books);
        for (BookData book : books) {
            System.out.println(book);
        }
    }

    private static void task3() {
        System.out.println("\n=== Завдання 3: Printer ===");

        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
    }

    private static void task4() {
        System.out.println("\n=== Завдання 4: filter ===");

        GenericUtils utils = new GenericUtils();
        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        Integer[] even = utils.filter(numbers, n -> n % 2 == 0);
        System.out.println("Парні: " + Arrays.toString(even));

        String[] words = {"java", "generic", "tuple", "go"};
        String[] longWords = utils.filter(words, s -> s.length() > 4);
        System.out.println("Довгі слова: " + Arrays.toString(longWords));
    }

    private static void task5() {
        System.out.println("\n=== Завдання 5: contains ===");

        GenericUtils utils = new GenericUtils();
        String[] names = {"Anna", "Ivan", "Olga"};
        Integer[] numbers = {10, 20, 30};

        System.out.println("contains(names, \"Ivan\"): " + utils.contains(names, "Ivan"));
        System.out.println("contains(names, \"Petro\"): " + utils.contains(names, "Petro"));
        System.out.println("contains(numbers, 20): " + utils.contains(numbers, 20));
        System.out.println("contains(numbers, 25): " + utils.contains(numbers, 25));
    }

    private static void task6() {
        System.out.println("\n=== Завдання 6: Tuple ===");

        GenericTwoTuple<String, Integer> student = new GenericTwoTuple<>("Іванов Петро", 95);
        System.out.println("Студент: " + student.first + ", рейтинг: " + student.second);
        System.out.println(student);

        GenericThreeTuple<String, Integer, Double> product =
                new GenericThreeTuple<>("Ноутбук", 3, 24999.99);
        System.out.println("Товар: " + product.getFirst() + ", кількість: " + product.getSecond()
                + ", ціна: " + product.getThree());
        System.out.println(product);
    }
}