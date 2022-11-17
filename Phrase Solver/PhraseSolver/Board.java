/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 * 
 * Authors: Isaac Johnson and Jason Leung
 */
import java.util.Scanner;
import java.io.File;

public class  Board
{
  /* attributes */
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue; 
  private boolean solved = false;

  /* your code here - constructor(s) */ 
  public Board() {
    solvedPhrase = "";
    phrase = loadPhrase();
    // System.out.println("Phrase: " + phrase); // temp test code
    setLetterValue();
  }

  /* your code here - accessor(s) */
  public String getPhrase() {
    return phrase;
  }

  public String getSolvedPhrase() {
    return solvedPhrase;
  }

  public int getLetterValue() {
    return currentLetterValue;
  }

  /* your code here - mutator(s)  */


  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    System.out.println(guess);
    if (phrase.replaceAll(" ", "").equals(guess.replaceAll(" ", "")) | solved)
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("PhraseSolver\\phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("PhraseSolver\\phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }  

  /** Method for taking in a guessed letter
   * 
   *  Preconditions: Must be a valid letter.
   *  Postconditions: Returns the found letter and sets solvedPhrase to the newSolvedPhrase
   * 
   * @param guess the guessed letter from input
   * @return foundLetter
   */
  public boolean guessLetter(String guess)  // a method header + signature
  {
    
    // variables declared + initialized
    boolean foundLetter = false;   // foundLetter is false at first
    String newSolvedPhrase = "";   // newSolvedPhrase is empty, gets concatenated with the letters in the solvedPhrase
    
    // loop to go through every letter in the String
    for (int i = 0; i < phrase.length(); i++) // runs a loop through the entire length of the String
    {
      // conditional - returns true if guessed letter is in phrase, returns false if it isn't
      if (phrase.substring(i, i + 1).equals(guess))  // if loop to check if guessed letter is in the phrase
      {
        newSolvedPhrase += guess + " "; // adds guessed letter and a space and sets foundLetter to true
        foundLetter = true; // sets foundLetter to true
      }
      else // executes when the letter in phrase is not the letter in guess
      {
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  // concatenates the letter and a space to newSolvedPhrase
      }
    }
    if (guess.equals(phrase)) {
      solved = true;
      newSolvedPhrase = guess;
      foundLetter = true;
    }
    solvedPhrase = newSolvedPhrase; // updates solvedPhrase to 
    return foundLetter; // returns the new String
  } // end of the loop
} // end of Board