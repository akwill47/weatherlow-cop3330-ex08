package ex08.base;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
 *  UCF COP3330 Summer 2021 Assignment 8 Solution
 *  Copyright 2021 William Weatherlow
 */
public class App {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        App myApp = new App();
        System.out.print("How many people? ");
        int numPeople = myApp.readInput();
        System.out.print("How many pizzas do you have? ");
        int numPizza = myApp.readInput();
        System.out.print("How many slices per pizza? ");
        int numSlices = myApp.readInput();

        myApp.displayPizzaInfo(numPeople,numPizza,numSlices);
    }
    private int readInput(){

        return in.nextInt();
    }

    private void displayPizzaInfo(int numPeople, int numPizza, int numSlices){
        int extraSlices = (numPizza * numSlices) % numPeople;
        int givenSlices = ((numPizza * numSlices) - extraSlices) / numPeople;
        System.out.printf("%d people with %d pizzas (%d slices)\nEach person gets %d pieces of pizza.\nThere are %d leftover pieces.",numPeople,numPizza,(numPizza * numSlices),givenSlices,extraSlices);
    }
}
