package com.b1;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

// URL:
// https://github.com/b1naryzer0/javabeginnerstuff

// Tutorial can be found at
// https://www.youtube.com/watch?v=Qgl81fPcLc8

// for the differences between public, private and protected access modifiers see for example
// https://www.geeksforgeeks.org/public-vs-protected-vs-package-vs-private-access-modifier-in-java/

public class Main {
    private static String arg1 = "test";
    private static int int1 = 100;
    private static double dbl1 = 100.40;
    private static String b1coding = "b1naryzer0 coding";

    public static void main(String[] args) {
        headsay("main");
        arg1 = "Test ok";
        int1 = 200;
        dbl1 = 200.24;
        String brand = "b1";
        Date date = new Date();
        Object[] objArray = {arg1, int1, dbl1, brand, date};
        String[] strArray = Arrays.stream(objArray).map(Object::toString).toArray(String[]::new);
        tabsay(Arrays.toString(strArray));

        Primitives();
        ReferenceTypes();
        Classes();

        charsay(b1coding);
        chartabsay(b1coding);
        chartabprettysay(b1coding);

        headsay("checkForString()");
        checkForString(b1coding, "coding");
        checkForString(b1coding, "sleeping");

        headsay("compareString()");
        compareString(b1coding, "b1naryzer0 coding");
        compareString(b1coding, "b1naryzer0 sleeping");

        importKeywords();
        reservedKeywords();

        arithmeticOperations();

        thisIsAnInsanelyLongMethodNameToTestHeadsay();
    }

    //////////////////////////////////////////////////////////////
    // methods started directly from main()

    private static void Primitives(){
        headsay("Primitives()");
        byte theByte = -128;
        short theShort = 32_000;
        int theInt = 787_835_222;
        long theLong = 923_409_812L;

        float theFloat = 3.14F;
        double doublePi = 3.1415;

        boolean isAdult = true;
        char nameInitial = 'A';

        Object[] objArray2 = {theByte, theShort, theInt, theLong, theFloat, doublePi, isAdult, nameInitial};
        String[] strArray2 = Arrays.stream(objArray2).map(Object::toString).toArray(String[]::new);
        tabsay(Arrays.toString(strArray2));
    }

    private static void ReferenceTypes(){
        headsay("ReferenceTypes()");
        // non-primitive data types AKA reference types
        String name = "Amigoscode"; // => the new String() isn't needed. String magic
        // String name = "AMIGOSCODE";
        String now = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String nowday = LocalDate.now().format(DateTimeFormatter.ofPattern("dd"));
        String[] strArray3 = {name, now, nowday};
        tabsay(Arrays.toString(strArray3));
    }

    private static void Classes(){
        headsay("Classes()");
        Person alex = new Person("Alex", 42);
        tabsay("before changing alex: " + alex.name + " " + alex.age + " " + alex.name + " " + alex.age);
        alex.name = "Alexandra";
        tabsay("before changing alex: " + alex.name + " " + alex.age + " " + alex.name + " " + alex.age);
    }

    private static void importKeywords(){
        headsay("importKeywords()");
        // instead of importing system classes you can reference them directly
        // but usually this is strictly not recommended, because one would
        // like to have all needed imports at the top of the file
        // the only use case is when you use methods of different packages
        // which have the exact same name as for example Date() which resides both
        // in java.util.Date and java.sql.Date
        // which could cause compiler problems
        // => to be kept in mind but rarely used
        java.util.Date date = new java.util.Date();
        java.time.LocalDate localDate = java.time.LocalDate.now();
        java.time.LocalDateTime localDateTime = java.time.LocalDateTime.now();
        System.out.println(date);
        System.out.println(localDate);
        System.out.println(localDateTime);
    }

    private static void reservedKeywords(){
        headsay("reservedKeywords()");
        System.out.println("These won't work because they use reserved keywords: ");
        System.out.println("int public = 0; - public is reserved");
        System.out.println("String final = \"final\"; - final is reserved");
        System.out.println("others are private, protected, void, class, etc.");
    }

    private static void arithmeticOperations(){
        // Arithmetic Operations
        headsay("Arithmetic Operations");
        int ten = 10;
        int two = 2;
        int addition = ten + two;
        System.out.println(ten + "+" + two + "=" + addition);
        System.out.println(ten + "-" + two + "=" + (ten - two));
        System.out.println(ten + "*" + two + "=" + (ten * two));
        System.out.println(ten + "/" + two + "=" + (ten / two));
        System.out.println(ten + "%" + two + "=" + (ten % two));
        System.out.println("10+2+90=" + (10+2+90)); // notice the needed () brackets here!
        System.out.println("10-2=" + (10-2));
        System.out.println("10*2=" + (10*2));
        System.out.println("10%3=" + (10%3));
    }

    private static void thisIsAnInsanelyLongMethodNameToTestHeadsay(){
        headsay("thisIsAnInsanelyLongMethodNameToTestHeadsay()");
    }


    ///////////////////////////////////////////////////////////////////
    // classes and general functions
    ///////////////////////////////////////////////////////////////////

    static class Person {
        String name;
        int age;
        Person (String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    private static void headsay(String str){
        // method to generate evenly distributed header lines with a fixed length
        System.out.println();
        String hashes = "";
        //  if str is uneven, add a space
        if (!(str.length() % 2 == 0))
             str += " ";
        //  generate the # string, equally long for left and right
        for (int i = 1; i < (30 - str.length() / 2); i++)
            hashes += "#";
        // output the final header string
        System.out.println((hashes + " " + str + " " + hashes).replace("  ", " #"));
    }

    private static void tabsay(String str){
        System.out.println(str.replaceAll("[\\[\\]]", "") + "\t");
    }

    private static void charsay(String str){
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
    }

    private static void chartabsay(String str){
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + "\t");
        }
        System.out.println();
    }

    private static void chartabprettysay(String str){
        System.out.print("- - ~ ~ o o = =  ");
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + "\t");
        }
        System.out.print("= = o o ~ ~ - -");
        System.out.println();
    }

    private static void checkForString(String str1, String str2) {
        // outputs true if str1 contains str2, otherwise false
        System.out.println(str1 + " contains " + str2 + " is " + str1.contains(str2));
    }

    private static void compareString(String str1, String str2) {
        // outputs true if str2 is exactly the same as str1
        System.out.println(str2 + " equals " + str1 + " is " + str2.equals(str1));

    }
}
