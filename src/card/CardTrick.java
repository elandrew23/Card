/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 * @author Andrew Elliott - 991540453
 * @date 20-09-24
 */
import java.util.Random;
import java.util.Scanner;

public class CardTrick {

    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        
        //Have to create a new Random object to generate random numbers with this method
        Random random = new Random();
        
        for (int i=0; i<magicHand.length; i++)
        {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1);
            c.setSuit(Card.SUITS[random.nextInt(4)]);
            magicHand[i] = c;
            System.out.println(c.getSuit() + " " + c.getValue());
        }
        
        //Code for step #4 below, with added integrity checks to ensure valid inputs
        Card checkedCard = new Card();
        Scanner k = new Scanner(System.in);
        
        boolean validAnswer = false;
        do {
            System.out.print("Enter a card value (1-13): ");
            int userVal = k.nextInt();
            validAnswer = valueRangeComparison(userVal, 1, 13, validAnswer);
            if (validAnswer) {
                checkedCard.setValue(userVal);
            }
        } while (!validAnswer);
        
        validAnswer = false;
        do {
            System.out.print("Enter a suit (0-3 where 0=Hearts, 1=Diamonds, 2=Spades, 3=Clubs): ");
            int userVal = k.nextInt();
            validAnswer = valueRangeComparison(userVal, 0, 3, validAnswer);
            if (validAnswer) {
                checkedCard.setSuit(Card.SUITS[userVal]);
            }
        } while (!validAnswer);
        k.close();
        
        //Search magicHand here
        int isFound = 0;
        for (int i=0; i<magicHand.length; i++) 
        {
            Card c = magicHand[i];
            if (c.getValue() == checkedCard.getValue() && c.getSuit().equals(checkedCard.getSuit())) 
                isFound = 1;
        }
        
        //Then report the result here
        if (isFound == 0)
            System.out.println("Sorry, your card is not in the magic hand.");
        else
            System.out.println("Congratulations, your card is in the magic hand!");
    }
    
    //This method minimises repetition between the do...while statements; just want to demonstrate knowledge
    public static boolean valueRangeComparison(int userVal, int min, int max, boolean validAnswer)
    {
        if (userVal >= min && userVal <= max) {              
            validAnswer = true;
        }
        else
            System.out.println("Invalid value entered, try again.");
        return validAnswer;
    }
        // add one luckcard hard code 2,clubs
}