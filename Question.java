/*
 * The Adventures of Hogwarts
 * CSC 120 Final Project
 * Class - Question: houses the information and functionality pertaining to the questions and their answers
 * Authors: Eva Kinnel, Gracia Bareti, Abby Paharsingh
 * Date: 21 December 2022
 */

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.Scanner;

public class Question{
    
    public String question;
    public ArrayList<String> answers; 
    public ArrayList<Collectibles> in_backpack;
    public String correct_answer; 
    public String partial_correct; 
    public Collectibles collectible;

    /**
     * Constructor for Question class
     * @param question stores the question and any info surrounding it
     * @param answers stores the multiple choice answers
     * @param correct_answer what the user must input to get full credit
     * @param partial_correct what the user must input to get parrial credit
     * @param collectible the reward for not getting a question wrong
     */
    public Question(String question, ArrayList<String> answers, String correct_answer, String partial_correct, Collectibles collectible){ 
        this.question = question;
        this.answers = answers; 
        this.collectible = collectible;
        this.correct_answer = correct_answer;
        this.partial_correct = partial_correct;
       }

    /**
     * Overloaded constructor for non-multiple choice quesitons
     * @param question see constructor above
     * @param correct_answer see constructor above
     * @param collectible see constructor above
     */
    public Question(String question, String correct_answer, Collectibles collectible){
        this.question = question;
        this.correct_answer = correct_answer;
        this.collectible = collectible;
    }

    /**
     * Overloaded constructor for questions with backpack tasks
     * @param question see constructor above
     * @param in_backpack stores the collectibles that have been gained
     * @param correct_answer see constructor above
     * @param collectible see constructor above
     */
    public Question(String question, ArrayList<Collectibles> in_backpack, String correct_answer, Collectibles collectible){
        this.question = question;
        this.in_backpack = in_backpack;
        this.correct_answer = correct_answer;
        this.collectible = collectible;
    }


    /**
     * Reveals the correctness of an answer
     * @param user_ans the answer that the user inputs
     * @return the correspondance to whether a question is correct, partial correct, or incorrect
     */
    public int isCorrect(String user_ans){
        if (user_ans.equals(this.correct_answer)){
            // addBackpack(this.collectible);
            return 2;
        } if (user_ans.equals(this.partial_correct)){
            // addBackpack(this.collectible);
            return 1;
        }else{
            // loseLives();
            return 0;
        }
    }

    /**
     * Prints the question with the answers if multiple choice, or prints the question with backpack items, if necessary
     */
    public void printQuestion() {
        System.out.println(this.question);
        if (this.in_backpack != null && ! this.in_backpack.isEmpty()){
            for (int i = 0; i < in_backpack.size(); i++) {
                in_backpack.get(i).getName();
              }
        }
        if (this.answers != null && ! this.answers.isEmpty()){
            System.out.println("a. " + this.answers.get(0) + "\nb. " + this.answers.get(1) + "\nc. " + this.answers.get(2));
        }
      }

    /**
     * main method for testing
     * @param args
     */
    public static void main(String[] args) {
        // System.out.println("\n");

        // ArrayList<String> c_g_q = new ArrayList<>(Arrays.asList("DRAUGHT", "HONEY", "FIRE"));
        // Question crabbe_goyle = new Question("Which choice?", c_g_q, c_g_q.get(0), c_g_q.get(2));

        // Question write_words = new Question("Type this prescicely: CaN yoU tELL Me?", "CaN yoU tELL Me?");

        // crabbe_goyle.printQuestion();
        // crabbe_goyle.isCorrect("DRAUGHT");
        // crabbe_goyle.isCorrect("FIRE");
        // crabbe_goyle.isCorrect("HONEY");

        // write_words.printQuestion();

        // System.out.println("\n");
    }
}
