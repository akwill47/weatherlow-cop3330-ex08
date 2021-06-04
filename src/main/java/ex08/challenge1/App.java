package ex08.challenge1;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
Exercise 8 - Pizza Party
Division isn’t always exact, and sometimes you’ll write programs that will need to deal with the leftovers as a whole number instead of a decimal.

Write a program to evenly divide pizzas. Prompt for the number of people, the number of pizzas, and the number of slices per pizza.
Ensure that the number of pieces comes out even. Display the number of pieces of pizza each person should get.
If there are leftovers, show the number of leftover pieces.

Example Output
How many people? 8
How many pizzas do you have? 2
How many slices per pizza? 8
8 people with 2 pizzas (16 slices)
Each person gets 2 pieces of pizza.
There are 0 leftover pieces.
Challenges
Revise the program to ensure that inputs are entered as numeric values. Don’t allow the user to proceed if the value entered is not numeric.
Alter the output so it handles pluralization properly, for example: "Each person gets 2 pieces of pizza." or "Each person gets 1 piece of pizza." Handle the output for leftover pieces appropriately as well.
Create a variant of the program that prompts for the number of people and the number of pieces each person wants, and calculate how many full pizzas you need to purchase.
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
        int num=0;
        do {
            try {
                num = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error, please enter a number");
                in.next();

            }
        }while(num < 1);
        return num;
    }

    private void displayPizzaInfo(int numPeople, int numPizza, int numSlices){
        int extraSlices = (numPizza * numSlices) % numPeople;
        int givenSlices = ((numPizza * numSlices) - extraSlices) / numPeople;
        System.out.printf("%d people with %d pizzas (%d slices)\nEach person gets %d pieces of pizza.\nThere are %d leftover pieces.",numPeople,numPizza,(numPizza * numSlices),givenSlices,extraSlices);
    }
}
