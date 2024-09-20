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
        
        //Code for step #6 below; initialise luckyCard as 3 of Spades
        Card luckyCard = new Card();
        luckyCard.setValue(3);
        luckyCard.setSuit(Card.SUITS[2]);
        
        //Search magicHand here
        int isFound = 0;
        for (int i=0; i<magicHand.length; i++) 
        {
            Card c = magicHand[i];
            if (c.getValue() == luckyCard.getValue() && c.getSuit().equals(luckyCard.getSuit())) 
                isFound = 1;
        }
        
        //Then report the result here
        if (isFound == 0)
            System.out.println("Sorry, your card is not in the magic hand.");
        else
            System.out.println("Congratulations, your card is in the magic hand!");
    }
}
