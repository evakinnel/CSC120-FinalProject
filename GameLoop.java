import java.util.Scanner;
import java.util.*;
// import Player;
// import Collectibles;
// import Character;
// import Question;

public class GameLoop {

    //could be a constructor if we need

    public static void main(String[] args) {

        // ArrayList<String> c_g_q = new ArrayList<>(Arrays.asList("draught", "honey", "fire"));
        // Question crabbe_goyle = new Question("Which choice?", c_g_q, c_g_q.get(0), c_g_q.get(2));

        // Question write_words = new Question("Type this prescicely: CaN yoU tELL Me?", "CaN yoU tELL Me?");
        
        // System.out.println(crabbe_goyle.correct_answer);


        // This is a "flag" to let us know when the loop should end
        boolean stillPlaying = true;

        // We'll use this to get input from the user.
        Scanner userInput = new Scanner(System.in);

        // Storage for user's responses
        String userResponse = "";

        // This could be replaced with a more interesting opening
        System.out.println("******************");
        System.out.println("WELCOME TO HOGWARTS");
        System.out.println("******************");

        // Instructions are sometimes helpful
        System.out.println("Enter a, b, or c");

        // The do...while structure means we execute the body of the loop once before checking the stopping condition
        do {
            // ************************************************
            // The stuff that happens in your game will go here
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓
            System.out.println("You are still playing. Follow the instructions if you want to win/lose...");
            userResponse = userInput.nextLine().toUpperCase();
            

            /*
             * "question 1"
             * if answer to q1 is super right
             *   "next question ", spell/whatever goes into bag (list)- some questions add nothing to bag
             * else if ans is half right
             *    "next" but nothing added to bag
             * else (taken care of below) if ans is wrong lose a life
             * 
             */

            // ***********************************************************************
            // And as the player interacts, you'll check to see if the game should end
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓
            if (userResponse.equals("wrong")) { // when you have 0 lives. if answer maps to wrong, then you lose a life. (won't be .equals)
                stillPlaying = false;
            }
        } while (stillPlaying);

        // Tidy up
        userInput.close();

        // Once you exit the loop, you may need to deal with various possible stopping conditions
        if (userResponse.equals("WIN")) {
            System.out.println("Yay, you won!");
        } else { // userResponse.equals("LOSE")
            System.out.println("Better luck next time.");
        }

    }

}