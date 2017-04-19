/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.ArrayList;

/**
 *
 * @author michael
 */
public class Hangman {
    private String theWord;
    //private char[] theWordArray = new char[theWord.length()];
    //theWordArray = theWord.toCharArray();
    private int guesses;
    private int incorrectGuesses;
    private ArrayList<Character> guessedCharacters = new ArrayList();
    
    public Hangman(String theWord)
    {
        String uppercaseWord = theWord.toUpperCase();
        this.theWord = uppercaseWord;
    }
    
    public String getTheWord()
    {
        return theWord;
    }
    
    public int getGuesses()
    {
        return guesses;
    }
    
    public int getIncorrectGuesses()
    {
        return incorrectGuesses;
    }
    
    private boolean contains(char myChar)
    {
        String myCharString = String.valueOf(myChar);
        for (int i = 0; i < theWord.length(); i++)
        {
            if (theWord.substring(i,i+1).equals(myCharString))
                return true;
        }   
        return false;
    }
    
    public void guess(char character)
    {
        guesses++;
        if (contains(character))
        {
            guessedCharacters.add(character);
            //display();
            System.out.println(display());
            
        }
        else if (guessedCharacters.contains(character))
        {
            System.out.println("You have already guessed " + character +". Please try a different letter.");
        }
        else
        {
            incorrectGuesses++;
            guessedCharacters.add(character);
            System.out.println("There is no " + character + " in the word.");
            System.out.println("You have guessed incorrectly " + incorrectGuesses +" times.");
            System.out.println("You have " + (5 - incorrectGuesses) + " lives left.");
            //display();
            System.out.println(display());
        }
    }
    
    public String display()
    {
        String returnThis = "";
        for (Character ch : theWord.toCharArray())
        {
            if (guessedCharacters.contains(ch))
            {
                //System.out.print(ch);
                returnThis = returnThis + ch;
            }
            else{
                //System.out.print("_");
                returnThis = returnThis + "_";
            }
        }
        //System.out.println();
        return returnThis;
    }
    
}
