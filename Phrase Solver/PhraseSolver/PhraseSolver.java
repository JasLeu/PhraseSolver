/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1;
  private Player player2;
  private Board game;
  private boolean solved;

  /* your code here - constructor(s) */ 
  public PhraseSolver() {
    player1 = new Player();
    player2 = new Player();
    game = new Board();
    solved = false;
  }

  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */

  public void play()
  {
    boolean solved = false;
    int currentPlayer = 1;

    Scanner input = new Scanner(System.in);
    System.out.println(game.getSolvedPhrase());
    
    while (!solved) 
    {
      
      /* your code here - game logic */
      System.out.println("\nThe next letter value is " + game.getLetterValue());
      

      if(currentPlayer == 1) {
        System.out.print(player1.getName() + "'s guess: ");
        if (game.guessLetter(input.nextLine())) {
          player1.addToPoints(game.getLetterValue());
        }
        currentPlayer = 2;

      } else {
        System.out.print(player2.getName() + "'s guess: ");
        if (game.guessLetter(input.nextLine())) {
          player2.addToPoints(game.getLetterValue());
        }
        currentPlayer = 1;

      }

      game.setLetterValue();
      
      
      /* your code here - determine how game ends */
      if (game.isSolved(game.getSolvedPhrase())) {
        solved = true;
      }
    } 
    
    input.close();

    System.out.print("\nGame ended! Winner: ");
    if (player1.getPoints() > player2.getPoints()) {
      System.out.println(player1.getName() + " with " + player1.getPoints() + " points!");
    } else {
      System.out.println(player2.getName() + " with " + player2.getPoints() + " points!");
    }
   
  }
  
}