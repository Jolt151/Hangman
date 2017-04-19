
package hangman;

import java.util.Scanner;
//import java.lang.*;

public class HangmanMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        Scanner userInput = new Scanner(System.in);
        String[] nouns = {"imagination","restaurant","enthusiasm","length","collection","version","housing","injury","equipment","reading",
            "efficiency","insect","bread","inspection","world","disease","assignment","awareness","context","foundation","reflection","charity",
            "ladder","effort","tradition","police","quantity","association","volume","income","month","competition","night","replacement","queen","recommendation",
            "complaint","basket","moment","signature","database","problem","newspaper","establishment","emphasis","appointment","impression","cabinet","independence",
"suggestion" };
        boolean gameOver = false;
        boolean gameWon = false;
        
        Hangman game = new Hangman(nouns[(int) (Math.random() * 51)]);
        System.out.println("The word is " + game.getTheWord().length() + " characters long.");
        char c;
        while (!gameOver){
            
            do 
            {
                System.out.print("Guess a letter: ");
                c = userInput.next().charAt(0);
            }
            while (!(c > 66 && c < 91) && !(c > 96 && c < 123)  );

            String cString = String.valueOf(c);
            cString = cString.toUpperCase();
            c = cString.charAt(0);

            game.guess(c);
            
            if (game.getIncorrectGuesses() == 5)
            {
                gameOver = true;
                gameWon = false;
            }
            if (game.display().equals(game.getTheWord()))
            {
                gameOver = true;
                gameWon = true;
            }
        }
        if (gameWon)
        {
            System.out.println("Congratulations! You won!");
        }
        else 
        {
            System.out.println("Sorry, you lost. The word was " + game.getTheWord() +".");
        }
        
    }
    
}
