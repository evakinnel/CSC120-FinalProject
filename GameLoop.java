import java.util.Scanner;
import java.util.concurrent.Flow.Subscriber;
import java.util.*;

public class GameLoop {

    //constructor
    public static void printIntro(){
        // This could be replaced with a more interesting opening
        System.out.println("******************");
        System.out.println("WELCOME TO HOGWARTS");
        System.out.println("******************");
    }
    public static void main(String[] args) {

        printIntro();

        // This is a "flag" to let us know when the loop should end
        boolean stillPlaying = true;

        // array list question = new array list
        // add each question to this as created

        // We'll use this to get input from the user.
        Scanner userInput = new Scanner(System.in);

        // Storage for user's responses
        String userResponse = "";

        

        System.out.println("What would you like your username to be?");
        // Scanner inputUsername = new Scanner(System.in);
        String username = userInput.nextLine();
        System.out.println("What would you like your catchphrase to be?");
        // Scanner inputCatchphrase = new Scanner(System.in);
        String catchphrase = userInput.nextLine();
        Player player1 = new Player(username.toString(), catchphrase.toString());
        System.out.println("You are playing as " + player1.username + ". They say " + player1.catchphrase + ". You have " + player1.lives + " lives.");
        
        // adding questions to arraylist
        ArrayList<Question> chamberQuestions = new ArrayList<>();
        ArrayList<String> answersOneList = new ArrayList<>(Arrays.asList("Draught", "Honey", "Fire"));
        Question  questionOne = new Question("Which choice?", answersOneList, "a", "c"); 
        chamberQuestions.add(questionOne); // how to add something deeper than an Array to this?
        
        
        

        Question write_words = new Question("Type this precisely: CaN yoU tELL Me?", "CaN yoU tELL Me?");
        chamberQuestions.add(write_words);

        




        int counter = 0;

        // userInput.close();
        // inputCatchphrase.close(); 

        // Instructions are sometimes helpful
        System.out.println("Type answer when prompted. Push any key to start.");

        // The do...while structure means we execute the body of the loop once before checking the stopping condition
        do {
            

            if (userResponse.equals("HELP")){
                // getHelp();
            }


            // print(chamberquestion(i), answers(i));
            chamberQuestions.get(counter).printQuestion();
            
            // take user input answerg
            
            userResponse = userInput.nextLine();
            // check if answer is correct (corresponds to question(i))
            if (chamberQuestions.get(counter).isCorrect(userResponse) == 0){
                player1.loseLives();
            }
            // check if lives == 0


            counter ++;
            if (player1.lives == 0) { // when you have 0 lives. The losing isn't working quite right atm, but it's ok
                stillPlaying = false;
            }
        } while (counter < chamberQuestions.size()); //take out stillPlaying - are there still questions, are there still lives?

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