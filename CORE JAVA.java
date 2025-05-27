import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class JavaExercises {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("\nChoose an exercise to run (1-41) or 0 to exit:");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                case 1 -> exercise1_HelloWorld();
                case 2 -> exercise2_SimpleCalculator();
                case 3 -> exercise3_EvenOrOdd();
                case 4 -> exercise4_LeapYear();
                case 5 -> exercise5_MultiplicationTable();
                case 6 -> exercise6_DataTypes();
                case 7 -> exercise7_TypeCasting();
                case 8 -> exercise8_OperatorPrecedence();
                case 9 -> exercise9_GradeCalculator();
                case 10 -> exercise10_NumberGuessingGame();
                case 11 -> exercise11_Factorial();
                case 12 -> exercise12_MethodOverloading();
                case 13 -> exercise13_RecursiveFibonacci();
                case 14 -> exercise14_ArraySumAverage();
                case 15 -> exercise15_StringReversal();
                case 16 -> exercise16_PalindromeChecker();
                case 17 -> exercise17_ClassAndObjectCreation();
                case 18 -> exercise18_InheritanceExample();
                case 19 -> exercise19_InterfaceImplementation();
                case 20 -> exercise20_TryCatchExample();
                case 21 -> exercise21_CustomException();
                case 22 -> exercise22_FileWriting();
                case 23 -> exercise23_FileReading();
                case 24 -> exercise24_ArrayListExample();
                case 25 -> exercise25_HashMapExample();
                case 26 -> exercise26_ThreadCreation();
                case 27 -> exercise27_LambdaExpressions();
                case 28 -> exercise28_StreamAPI();
                case 29 -> exercise29_RecordsExample();
                case 30 -> exercise30_PatternMatchingSwitch();
                case 31 -> exercise31_BasicJDBCConnection();
                case 32 -> exercise32_InsertUpdateJDBC();
                case 33 -> exercise33_TransactionHandling();
                case 34 -> exercise34_JavaModules(); // Note: Simplified, real modules require separate files/projects
                case 35 -> exercise35_TCPClientServerChat(); // Simplified example
                case 36 -> exercise36_HTTPClientAPI();
                case 37 -> exercise37_JavapBytecodeInspection(); // Just print instructions, can't run javap here
                case 38 -> exercise38_DecompileClassFile(); // Only instructions, no code
                case 39 -> exercise39_ReflectionExample();
                case 40 -> exercise40_VirtualThreads();
                case 41 -> exercise41_ExecutorServiceCallable();
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // 1. Hello World Program
    static void exercise1_HelloWorld() {
        System.out.println("Hello, World!");
    }

    // 2. Simple Calculator
    static void exercise2_SimpleCalculator() {
        System.out.print("Enter first number: ");
        double a = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double b = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Choose operation (+, -, *, /): ");
        char op = scanner.nextLine().charAt(0);

        double result;
        switch (op) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '*' -> result = a * b;
            case '/' -> {
                if (b == 0) {
                    System.out.println("Cannot divide by zero.");
                    return;
                }
                result = a / b;
            }
            default -> {
                System.out.println("Invalid operation.");
                return;
            }
        }
        System.out.println("Result: " + result);
    }

    // 3. Even or Odd Checker
    static void exercise3_EvenOrOdd() {
        System.out.print("Enter an integer: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.println(n + " is " + (n % 2 == 0 ? "Even" : "Odd"));
    }

    // 4. Leap Year Checker
    static void exercise4_LeapYear() {
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        System.out.println(year + (isLeap ? " is a leap year." : " is not a leap year."));
    }

    // 5. Multiplication Table
    static void exercise5_MultiplicationTable() {
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d\n", num, i, num * i);
        }
    }

    // 6. Data Type Demonstration
    static void exercise6_DataTypes() {
        int i = 42;
        float f = 3.14f;
        double d = 2.71828;
        char c = 'A';
        boolean b = true;

        System.out.println("int: " + i);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: " + c);
        System.out.println("boolean: " + b);
    }

    // 7. Type Casting Example
    static void exercise7_TypeCasting() {
        double d = 9.99;
        int i = (int) d;
        System.out.println("Double to int: " + i);

        int j = 5;
        double e = j;
        System.out.println("Int to double: " + e);
    }

    // 8. Operator Precedence
    static void exercise8_OperatorPrecedence() {
        int result = 10 + 5 * 2;
        System.out.println("Expression: 10 + 5 * 2");
        System.out.println("Result: " + result);
        System.out.println("Multiplication has higher precedence than addition, so 5 * 2 is evaluated first.");
    }

    // 9. Grade Calculator
    static void exercise9_GradeCalculator() {
        System.out.print("Enter marks (0-100): ");
        int marks = scanner.nextInt();
        scanner.nextLine();

        char grade;
        if (marks >= 90) grade = 'A';
        else if (marks >= 80) grade = 'B';
        else if (marks >= 70) grade = 'C';
        else if (marks >= 60) grade = 'D';
        else grade = 'F';

        System.out.println("Grade: " + grade);
    }

    // 10. Number Guessing Game
    static void exercise10_NumberGuessingGame() {
        int target = new Random().nextInt(100) + 1;
        int guess = 0;
        System.out.println("Guess the number between 1 and 100.");

        while (guess != target) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            scanner.nextLine();

            if (guess < target) System.out.println("Too low!");
            else if (guess > target) System.out.println("Too high!");
            else System.out.println("Correct! The number was " + target);
        }
    }

    // 11. Factorial Calculator
    static void exercise11_Factorial() {
        System.out.print("Enter a non-negative integer: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        if (n < 0) {
            System.out.println("Invalid input.");
            return;
        }

        long fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;

        System.out.println("Factorial of " + n + " is " + fact);
    }

    // 12. Method Overloading
    static void exercise12_MethodOverloading() {
        System.out.println("add(2, 3) = " + add(2, 3));
        System.out.println("add(2.5, 3.5) = " + add(2.5, 3.5));
        System.out.println("add(1, 2, 3) = " + add(1, 2, 3));
    }

    static int add(int a, int b) {
        return a + b;
    }

    static double add(double a, double b) {
        return a + b;
    }

    static int add(int a, int b, int c) {
        return a + b + c;
    }

    // 13. Recursive Fibonacci
    static void exercise13_RecursiveFibonacci() {
        System.out.print("Enter n for Fibonacci: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        if (n <= 0) {
            System.out.println("Invalid input.");
            return;
        }
        System.out.println("Fibonacci number " + n + " is " + fibonacci(n));
    }

    static int fibonacci(int n) {
        if (n <= 2) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 14. Array Sum and Average
    static void exercise14_ArraySumAverage() {
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        scanner.nextLine();

        int sum = 0;
        for (int val : arr) sum += val;

        double avg = n > 0 ? (double) sum / n : 0;
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + avg);
    }

    // 15. String Reversal
    static void exercise15_StringReversal() {
        System.out.print("Enter a string: ");
        String s = scanner.nextLine();
        String reversed = new StringBuilder(s).reverse().toString();
        System.out.println("Reversed: " + reversed);
    }

    // 16. Palindrome Checker
    static void exercise16_PalindromeChecker() {
        System.out.print("Enter a string: ");
        String s = scanner.nextLine();
        String clean = s.replaceAll("[^a-zA-Z
