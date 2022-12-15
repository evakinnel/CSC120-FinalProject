import java.util.Scanner;
import java.util.concurrent.Flow.Subscriber;
import java.util.*;

public class GameLoop {

    //constructor

    public static void main(String[] args) {

        // This is a "flag" to let us know when the loop should end
        boolean stillPlaying = true;

        // array list question = new array list
        // add each question to this as created

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
        
        // adding questions to arraylist
        ArrayList<ArrayList<String>> chamberQuestions = new ArrayList<ArrayList<String>>();
        ArrayList<String> answersOneList = new ArrayList<>(Arrays.asList("a. Draught", "b. Honey", "c. Fire"));
        Question  questionOne = new Question("Which choice?", answersOneList, answersOneList.get(0), answersOneList.get(2)); 
        chamberQuestions.add(answersOneList); // how to add something deeper than an Array to this?
        //crabbe_goyle.printQuestion(crabbe_goyle.question, c_g_q);

        Question write_words = new Question("Type this precisely: CaN yoU tELL Me?", "CaN yoU tELL Me?");
        // chamberQuestions.add(write_words);




        // Scanner response = new Scanner(System.in);
        String response1 = userInput.nextLine().toUpperCase();
        if (questionOne.isCorrect(response1) == 0){
            player1.loseLives();
        }

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
                // getHelp();
            }



            // print(chamberquestion(i), answers(i));
            // take user input answer
            // check if answer is correct (corresponds to question(i))
            // check if lives == 0





            // // player1.getLives();

            

            // // this should only have to be in one place, but for now it's here too
            // if (player1.lives == 0) { // when you have 0 lives. 
            //     stillPlaying = false;
            // }

            // // if user response = correct_answer, move on else if, else

            // write_words.printQuestion(write_words.question);
            // String response2 = userInput.nextLine();
            // if (write_words.isCorrect(response2) == 0){
            //     player1.loseLives();
            // }
            

            // ***********************************************************************
            // And as the player interacts, you'll check to see if the game should end
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓
            if (player1.lives == 0) { // when you have 0 lives. The losing isn't working quite right atm, but it's ok
                stillPlaying = false;
            }
        } while (stillPlaying); //take out stillPlaying - are there still questions, are there still lives?

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