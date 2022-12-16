import java.util.Scanner;
import java.util.concurrent.Flow.Subscriber;
import java.util.*;

public class GameLoop {

    //constructor
    public static void printIntro(){
        // Replace with a better opening
        System.out.println("*******************");
        System.out.println("WELCOME TO HOGWARTS");
        System.out.println("*******************");
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
        
        // CREATE COLLECTIBLES:
        Collectibles aragog_hint = new Collectibles("Aragog", "spider", "wisdom", 1, "I am not the creature you're looking for. The creature lies in the Chamber of Secrets.");
        Collectibles gryffindor_sword = new Collectibles("The Sword of Gryffindor", "weapon", "slay the Basilisk", 5, "Let's slay some Bas!");
        Collectibles riddles_diary = new Collectibles("Tom Riddle's Diary", "a magic book", "see Tom Riddle's life", 10, "I cannot tell you, but I can show you...");
        Collectibles phrase = new Collectibles("Great Job", "a pat on the back", "boost your confidence", 10000, "You got this, buddy!");
        Collectibles fang = new Collectibles("Basilisk Fang", "a fang pulled from the Basilisk's carcas", "destroy horcruxes", 100000, "DIE!");
        Collectibles phoenix_tears = new Collectibles("Phoenix Tears", "tears of Dumbledore's Phoenix, Fawkes", "heal wounds", 100, "boohoo whaaaa whaaaa");

        // CREATING AND ADDING QUESTIONS TO ARRAY LIST
        ArrayList<Question> chamberQuestions = new ArrayList<>();
        ArrayList<String> answersOneList = new ArrayList<>(Arrays.asList("Moaning Myrtes Toilet; Rubeus Hagrid", "Moaning Martha's Toilet; Tom Riddle", "Moaning Myrtle's Toilet; Tom Riddle"));
        Question  questionOne = new Question("The ground is flooded \nAnd you are confronted \nThrough the top of her head \nA book has been thrown \nBut whom did it was unknown \nShe tells you as she moans \nNow whered you find the book we seek \nand who's the owner who wishes to keep \n", 
            answersOneList, "c", "b", phrase); 
        chamberQuestions.add(questionOne); 
        
        Question questionTwo = new Question("June 13th 50 years ago\nHogwarts wanted to know\nCuriosity about the chamber \nMay bring you danger\nNow write in the book\nAnd talk to a stranger\nIn order to speak with Tom, type this precisely into the console: CaN yoU tELL Me?", 
            "CaN yoU tELL Me?",riddles_diary);
        chamberQuestions.add(questionTwo);

        ArrayList<String> answersThreeList = new ArrayList<>(Arrays.asList("Fluffy", "Aragog", "A Thestral"));
        Question  questionThree = new Question("Hagrid is framed \nWhat a shame \nBut his old friend \nWill help as you ascend \nAn eight legged creature \nAnd also leader \nNot a monster \nBut an eater", 
            answersThreeList, "b", "a",aragog_hint); 
        chamberQuestions.add(questionThree);
    
        ArrayList<String> answersFourList = new ArrayList<>(Arrays.asList("Fawkes", "Hedwig", "Grawp"));
        Question  questionFour = new Question("Pull up to the spot\nAnd see Ginny has fallen\nBut make sure you take caution\n Riddle, did the deed\n And indeed is a thieve\nTom by day Voldemort by night\nAlas goes Dumbeldore sends over help\nNo need to welp\n", 
            answersFourList, "a", "b", phoenix_tears); 
        chamberQuestions.add(questionFour); 

        ArrayList<String> answersFiveList = new ArrayList<>(Arrays.asList("Your Wand", "Gryffindor Sword", "The Cloak of Invisibility"));
        Question  questionFive = new Question("The basilisk seems unstoppable but luckily there is an item that could help. \nChoose an item that will be most beneficial in slaying the basilisk?", 
            answersFiveList, "b", "c", gryffindor_sword); 
        chamberQuestions.add(questionFive); 

        Question questionSix = new Question("You need to kill the Basilisk. Which item from your backpack do you want? Type the answer exactly.", player1.backpack, "The Sword of Gryffindor", phrase);
        chamberQuestions.add(questionSix);

        Question questionSeven = new Question("June 13th 50 years ago\nHogwarts wanted to know\nCuriosity about the chamber \nMay bring you danger\nNow write in the book\nAnd talk to a stranger\nUnscramble this sentence to complete the final task: EAT AT HYBRIDS\n (Type in ALL CAPS)", 
            "STAB THE DIARY", fang);
        chamberQuestions.add(questionSeven);

        Question questionEight = new Question("You need to stab the diary. Which item from your backpack? Type the answer exactly.", player1.backpack, "Basilisk Fang", phrase);
        chamberQuestions.add(questionEight);

        Question questionNine = new Question("Harry is wounded. Which item from your backpack? Type the answer exactly.", player1.backpack, "Phoenix Tears",phrase);
        chamberQuestions.add(questionNine);



        // INITIALIZE COUNTER
        int counter = 0;


        // Instructions
        System.out.println("Type a, b, or c");

        do {
            
            System.out.println("\n");

            if (userResponse.equals("HELP")){
                // getHelp();
            }

            // print(chamberquestion(i), answers(i));
            chamberQuestions.get(counter).printQuestion();
            
            // take user input answer
            
            userResponse = userInput.nextLine();
            // check if there should be a runtime exception

            // IF INCORRECT
            if (chamberQuestions.get(counter).isCorrect(userResponse) == 0){ 
                System.out.println(userResponse + " was wrong."); 
                player1.loseLives(); // LOSE A LIFE
            // PARTIALLY CORRECT
            } else if (chamberQuestions.get(counter).isCorrect(userResponse) == 1){ 
                System.out.println(userResponse + " is partially correct."); 
                player1.loseLives(); // LOSE A LIFE
                player1.addBackpack(chamberQuestions.get(counter).collectible); // GAIN COLLECTIBLE
            // CORRECT
            } else if (chamberQuestions.get(counter).isCorrect(userResponse) == 2){ //
                System.out.println(userResponse + " is right. Well done! " + Player.catchphrase); // SAY CATCHPHRASE
                player1.addBackpack(chamberQuestions.get(counter).collectible); // GAIN COLLECTIBLE
            } 

            // CHECK IF THEY SHOULD LOSE
            player1.getLives();

            if (player1.lives == 0) { 
                stillPlaying = false;
            }

            counter ++;
            
        } while (counter < chamberQuestions.size() && player1.lives != 0); //are there still questions, are there still lives?

        // Tidy up
        userInput.close();

        // Once you exit the loop, you may need to deal with various possible stopping conditions
        if (player1.lives == 0) {
            System.out.println("You lose.");
            
        } else {
            System.out.println("Congratulations!");
        }

    }

}