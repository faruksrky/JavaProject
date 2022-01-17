package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Find_PrimeNumber_EraAlgorithm fpm = new Find_PrimeNumber_EraAlgorithm();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please give a number which is find how many numbers is prime :");
        int givenNumber =  sc.nextInt();
        System.out.println(" Number of prime numbers until : " +  fpm.NumberofPrimeNumbers(givenNumber));
    }
}
