import java.util.Scanner;
import java.util.concurrent.Flow.Subscriber;
import java.util.*;

public class GameLoop {

    //constructor

    public static void main(String[] args) {

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

        System.out.println("What would you like your username to be?");
        // Scanner inputUsername = new Scanner(System.in);
        String username = userInput.nextLine();
        System.out.println("What would you like your catchphrase to be?");
        // Scanner inputCatchphrase = new Scanner(System.in);
        String catchphrase = userInput.nextLine();
        Player player1 = new Player(username.toString(), catchphrase.toString());
        System.out.println("You are playing as " + player1.username + ". They say " + player1.catchphrase + ". You have " + player1.lives + " lives.");
    

        // userInput.close();
        // inputCatchphrase.close(); 

        // Instructions are sometimes helpful
        System.out.println("Type answer when prompted. Push any key to start.");

        // The do...while structure means we execute the body of the loop once before checking the stopping condition
        do {
            // ************************************************
            // The stuff that happens in your game will go here
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓
            // System.out.println("You are still playing. Follow the instructions if you want to win/lose...");
            userResponse = userInput.nextLine().toUpperCase();

            if (userResponse.equals("HELP")){
                player1.getHelp();
            }

            if (userResponse.equals("LL")){
                player1.loseLives();
            }

            // player1.getLives();

            // want to figure out how to do this in Question class:
            ArrayList<String> c_g_q = new ArrayList<>(Arrays.asList("DRAUGHT", "HONEY", "FIRE"));
            Question crabbe_goyle = new Question("Which choice?", c_g_q, c_g_q.get(0), c_g_q.get(2));        
            crabbe_goyle.printQuestion(crabbe_goyle.question, c_g_q);
            // Scanner response = new Scanner(System.in);
            String response1 = userInput.nextLine().toUpperCase();
            if (crabbe_goyle.isCorrect(response1) == 0){
                player1.loseLives();
            }

            // this should only have to be in one place, but for now it's here too
            if (player1.lives == 0) { // when you have 0 lives. 
                stillPlaying = false;
            }

            // if user response = correct_answer, move on else if, else

            Question write_words = new Question("Type this precisely: CaN yoU tELL Me?", "CaN yoU tELL Me?");
            write_words.printQuestion(write_words.question);
            String response2 = userInput.nextLine();
            if (write_words.isCorrect(response2) == 0){
                player1.loseLives();
            }

            // this should only have to be in one place, but for now it's here too
            if (player1.lives == 0) { // when you have 0 lives. 
                stillPlaying = false;
            }

            Question typeThis = new Question("Type this: helloooo", "helloooo");
            typeThis.printQuestion(typeThis.question);
            String response3 = userInput.nextLine();
            if (typeThis.isCorrect(response3) == 0){
                player1.loseLives();
            }

            // this should only have to be in one place, but for now it's here too
            if (player1.lives == 0) { // when you have 0 lives. 
                stillPlaying = false;
            }

            ArrayList<String> omgArray = new ArrayList<>(Arrays.asList("O", "M", "G"));
            Question omgg = new Question("Which choice?", omgArray, omgArray.get(2), omgArray.get(0));        
            omgg.printQuestion(omgg.question, omgArray);
            // Scanner response = new Scanner(System.in);
            String response4 = userInput.nextLine().toUpperCase();
            if (omgg.isCorrect(response4) == 0){
                player1.loseLives();
            }
            

            // ***********************************************************************
            // And as the player interacts, you'll check to see if the game should end
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓
            if (player1.lives == 0) { // when you have 0 lives. The losing isn't working quite right atm, but it's ok
                stillPlaying = false;
            }
        } while (stillPlaying);

        // Tidy up
        userInput.close();

        // Once you exit the loop, you may need to deal with various possible stopping conditions
        if (player1.lives == 0) {
            System.out.println("you lose");
        } else { // userResponse.equals("LOSE")
            System.out.println("Better luck next time.");
        }

    }

}