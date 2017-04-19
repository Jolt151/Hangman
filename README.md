# Hangman
simple hangman for java

Difficulties: getting only character from scanner http://stackoverflow.com/questions/13942701/take-a-char-input-from-the-scanner

Only accepting character inputs:
```java
        do
        {
            System.out.print("Guess a letter: ");
            c = userInput.next().charAt(0);
        }
        while (!(c > 66 && c < 91) && !(c > 96 && c < 123)  );
```

Had to convert the character to uppercase to make it easier to deal with for the rest of the program. Could not use string in the first place because i needed to accept only a char from the user.
```java
        String cString = String.valueOf('c');
        cString = cString.toUpperCase();
        c = cString.charAt(0);
```

contains  method always returned false because a String will never equal a char. Solution: convert the char myChar to a String called myCharString
`String myCharString = String.valueOf(myChar);`


How do we determine if the player got all the letters? Originally this was the code in display: 
```java
    private void display()
    {
        for (Character ch : theWord.toCharArray())
        {
            if (guessedCharacters.contains(ch))
            {
                System.out.print(ch);
            }
            else{
                System.out.print("_");
            }
        }
        System.out.println();
    }
```

 One solution is to have display return a String, and then compare that string with the original after every while loop in the main function. ( and make display() public)


References: www.homeandlearn.co.uk/java/user_input.html
http://stackoverflow.com/questions/13942701/take-a-char-input-from-the-scanner
http://stackoverflow.com/questions/2597841/scanner-method-to-get-a-char
http://docs.oracle.com/javase/6/docs/api/java/util/Scanner.html#hasNextInt%28%29
http://www-ee.eng.hawaii.edu/~tep/EE160/Book/chap4/subsection2.1.1.1.html
http://stackoverflow.com/questions/8172420/how-to-convert-a-char-to-a-string
http://stackoverflow.com/questions/6952363/replace-a-character-at-a-specific-index-in-a-string
http://stackoverflow.com/questions/196830/what-is-the-easiest-best-most-correct-way-to-iterate-through-the-characters-of-a
https://randomwordgenerator.com/noun.php
https://www.tutorialspoint.com/java/lang/math_random.htm

