/*
 * The Adventures of Hogwarts
 * CSC 120 Final Project
 * Class - Hogwarts (where all the *magic* happens): houses the game loop, and sythesizes all funciton
 * Authors: Abby Paharsingh, Eva Kinnel, Gracia Bareti
 * Date: 21 December 2022
 */

import java.util.Scanner;
// import java.util.concurrent.Flow.Subscriber;
import java.util.*;

public class Hogwarts {

    /**
     * prints the intro statement
     */
    public static void printIntro(){
        System.out.println("\n");        
        System.out.println("  ^                       ^                        ^");
        System.out.println(" / \\                     / \\                      / \\");
        System.out.println("/   \\                   /   \\                    /   \\");
        System.out.println("[][][][][][][][][][][][][][][][][][][][][][][][][][][]");
        System.out.println("|    *           WELCOME TO HOGWARTS        *        |");
        System.out.println("|   *         Danger and magic awaits you...       * |");
        System.out.println("|         *       Wand at the ready!              *  |");
        System.out.println("[][][][][][][][][][][][][][][][][][][][][][][][][][][]");
        System.out.println("\n");        
    }

    /**
     * creates instances of Player, Question, and Collectibles
     * Contains the game's do/while loop, and the user interaction via scanner
     * @param args
     */
    public static void main(String[] args) {

        printIntro();

        // This is a "flag" to let us know when the loop should end
        boolean stillPlaying = true;

        // Get input from the user.
        Scanner userInput = new Scanner(System.in);

        // Storage for user's responses
        String userResponse = "";

        // CREATE PLAYER
        System.out.println("What would you like your username to be?");
        // Scanner inputUsername = new Scanner(System.in);
        String username = userInput.nextLine();
        System.out.println("What would you like your catchphrase to be?");
        // Scanner inputCatchphrase = new Scanner(System.in);
        String catchphrase = userInput.nextLine();
        Player player1 = new Player(username.toString(), catchphrase.toString());

        System.out.println("You are playing as " + player1.username + ". They say " + player1.catchphrase + ". You have " + player1.lives + " lives.");
        
        // CREATE COLLECTIBLES:
        Collectibles aragog_hint = new Collectibles("Aragog", "a spider", "impart wisdom", 1, "I am not the creature you're looking for. The creature lies in the Chamber of Secrets.");
        Collectibles gryffindor_sword = new Collectibles("The Sword of Gryffindor", "weapon", "slay the Basilisk", 5, "Let's slay some Bas!");
        Collectibles riddles_diary = new Collectibles("Tom Riddle's Diary", "a magic book", "see Tom Riddle's life", 10, "I cannot tell you, but I can show you...");
        Collectibles phrase = new Collectibles("Great Job", "a pat on the back", "boost your confidence", 10000, "You got this, buddy!");
        Collectibles fang = new Collectibles("Basilisk Fang", "a fang pulled from the Basilisk's carcas", "destroy horcruxes", 100000, "DIE!");
        Collectibles phoenix_tears = new Collectibles("Phoenix Tears", "tears of Dumbledore's Phoenix, Fawkes", "heal wounds", 100, "boohoo whaaaa whaaaa");

        // CREATING AND ADDING QUESTIONS TO ARRAY LIST
        ArrayList<Question> chamberQuestions = new ArrayList<>();
        ArrayList<String> answersOneList = new ArrayList<>(Arrays.asList("Moaning Myrtes Toilet; Rubeus Hagrid", "Moaning Martha's Toilet; Tom Riddle", "Moaning Myrtle's Toilet; Tom Riddle"));
        Question  questionOne = new Question("Strange things are happening at Hogwarts. \nThere are rumors that Slytherin's heir has returned and is plotting to unleash a dangerous creature. \nYou wander into the toilets. \n\nThe ground is flooded \nAnd you are confronted \nThrough the top of her head \nA book has been thrown \nBut who did it was unknown \nShe tells you as she moans \nNow whered you find the book we seek \nand who's the owner who wishes to keep \n", 
            answersOneList, "c", "b", phrase); 
        chamberQuestions.add(questionOne); 
        
        Question questionTwo = new Question("Now that you have found Tom Riddle's diary, you desire to uncover its secrets.\n\nJune 13th 50 years ago\nHogwarts wanted to know\nCuriosity about the chamber \nMay bring you danger\nNow write in the book\nAnd talk to a stranger\nIn order to speak with Tom, type this precisely into the console: CaN yoU tELL Me?", 
            "CaN yoU tELL Me?",riddles_diary);
        chamberQuestions.add(questionTwo);

        ArrayList<String> answersThreeList = new ArrayList<>(Arrays.asList("Fluffy", "Aragog", "A Thestral"));
        Question  questionThree = new Question("The diary shows you a memory implicating Hagrid as the one who may unleash the creature.\nYou go to Hagrid's to discover the truth.\n\nHagrid is framed \nWhat a shame \nBut his old friend \nWill help as you ascend \nAn eight legged creature \nAnd also leader \nNot a monster \nBut an eater\n", 
            answersThreeList, "b", "a",aragog_hint); 
        chamberQuestions.add(questionThree);
    
        ArrayList<String> answersFourList = new ArrayList<>(Arrays.asList("Fawkes", "Hedwig", "Dobby"));
        Question  questionFour = new Question("With the spiders knowing words, you enter the Chamber of Secrets to confront the beast. \nIn the chamber you discover a massive snake-like creature (a basilisk) and an unconcious Ginny.\n\nPull up to the spot\nAnd see Ginny has fallen\nBut make sure you take caution \nRiddle, did the deed \nAnd indeed is a thieve \nTom by day Voldemort by night \nAlas goes Dumbeldore sends over help \nNo need to welp\n\nWhich creature can help you defeat the basilisk and save Ginny?", 
            answersFourList, "a", "b", phoenix_tears); 
        chamberQuestions.add(questionFour); 

        ArrayList<String> answersFiveList = new ArrayList<>(Arrays.asList("The Cloak of Invisibility", "The Sword of Gryffindor", "A freshly harvested mandrake"));
        Question  questionFive = new Question("Just when the basilisk seems unstoppable, \nFawkes delivers the sorting hat to you, and within it you find something instrumental.\n\nChoose an item that will be most beneficial in slaying the basilisk:", 
            answersFiveList, "b", "c", gryffindor_sword); 
        chamberQuestions.add(questionFive); 

        Question questionSix = new Question("Now it's time to kill the basilisk. Which collectible will you use to do so? Type the answer exactly.", player1.backpack, "The Sword of Gryffindor", phrase);
        chamberQuestions.add(questionSix);

        Question questionSeven = new Question("The basilisk has been defeated.\nYou have a moment of relief until Tom Riddle reappears, furious that you have slayed the basilisk.\n\nJune 13th 50 years ago\nHogwarts wanted to know\nCuriosity about the chamber \nMay bring you danger\nTime to confrot\nThis evil stranger\nUnscramble this sentence to uncover how to defeat Tom: EAT AT HYBRIDS\n(Type in ALL CAPS)", 
            "STAB THE DIARY", fang);
        chamberQuestions.add(questionSeven);

        Question questionEight = new Question("Which collectible will you use to defeat Tom Riddle? Type the answer exactly.", player1.backpack, "Basilisk Fang", phrase);
        chamberQuestions.add(questionEight);

        Question questionNine = new Question("Tom is vanishing.\nBlood begins flooding out of the diary and back into Ginny's body.\nYou rush to her as she regains life.\nShe wakes up and notices a wound you incurred from the basislisk.\n\nWhich collectible will you use to heal? Type the answer exactly.", player1.backpack, "Phoenix Tears",phrase);
        chamberQuestions.add(questionNine);

        // INITIALIZE COUNTER
        int counter = 0;


        // Instructions
        System.out.println("Type a, b, or c");

        do {
            
            System.out.println("\n");

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
            System.out.println("EPIC FAIL! Voldemort rose to power and conquered the Wizarding World.");
            
        } else {
            System.out.println("Wicked! You were healed by Fawkes's tears. You saved Ginny's life, defeated the Basilisk, and won the House Cup!");
        }

    }

}