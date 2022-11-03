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
    
    boolean correct = true; 
    while (!solved) 
    {
      
      /* your code here - game logic */
      if(currentPlayer == 1) {
        System.out.println(player1.getName() + "'s guess: ");

      } else {
        System.out.println(player2.getName() + "'s guess: ");

      }

      
      System.out.println("The next letter value is " + game.getLetterValue());

      game.getSolvedPhrase();
      /* your code here - determine how game ends */
      //if (game.getSolvedPhrase().equals(game.getPhrase())) {
        solved = true; 
      //}
      
    } 
   
  }
  
}