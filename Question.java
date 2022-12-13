import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Question{
    
    public String question;
    public ArrayList<String> answers; 
    public String correct_answer;
    public String partial_correct;

    public Question(String question, ArrayList<String> answers, String correct_answer, String partial_correct){ 
        this.question = question;
        this.answers = new ArrayList<String>(); 
        this.correct_answer = correct_answer;
        this.partial_correct = partial_correct;
       }


    // overloaded constructor
    public Question(String question, String correct_answer){
        this.question = question;
        this.correct_answer = correct_answer;
    }

    public int isCorrect(String user_ans){
        if (user_ans.equals(this.correct_answer)){
            System.out.println(user_ans + " is right. Well done!");
            return 2;
        } if (user_ans.equals(this.partial_correct)){
            System.out.println(user_ans + " is an okay answer.");
            return 1;
        }else{
            // loseLives();
            System.out.println(user_ans + " was wrong. You have lost a life");
            return 0;
        }
    }

    public void printQuestion(String question, ArrayList list) {

        System.out.println(this.question);
        System.out.println("a. " + list.get(0) + "\nb. " + list.get(1) + "\nc. " + list.get(2));
        
      }

      //overloaded printQuestion
    public void printQuestion(String question) {
        System.out.println(this.question);
        
    }

    // public void userInput(){
        

    // }



    public static void main(String[] args) {
        System.out.println("\n");

        ArrayList<String> c_g_q = new ArrayList<>(Arrays.asList("DRAUGHT", "HONEY", "FIRE"));
        Question crabbe_goyle = new Question("Which choice?", c_g_q, c_g_q.get(0), c_g_q.get(2));

        Question write_words = new Question("Type this prescicely: CaN yoU tELL Me?", "CaN yoU tELL Me?");

        crabbe_goyle.printQuestion(crabbe_goyle.question, c_g_q);
        crabbe_goyle.isCorrect("DRAUGHT");
        crabbe_goyle.isCorrect("FIRE");
        crabbe_goyle.isCorrect("HONEY");

        System.out.println("\n");
    }
}















/* 
public class Question{
    
    private Hashtable<String, Hashtable<String, String>> questions;
    private Hashtable<String, String> answers;
    // private Hashtable<String, String[]> answers; //here we are trying to nest a list into the hashtabel because we want a way to save which answers are wrong and right
    // String[] correctArray = new String[2];
    // private Hashtable<String, String> qaDatabase;

    public Question(){
        this.questions = new Hashtable<String, Hashtable<String, String>>();
        this.answers = new Hashtable<String, String>();
        // this.answers = new Hashtable<String, String[]>(); // to connect to the other declaration of Hashtable - answers
    }



    public void printQuestion() {

        Set<String> set_of_keys_questions = this.questions.keySet();
        Set<String> set_of_keys_answers = this.answers.keySet();
        for (String key : set_of_keys_questions) {

            System.out.println(key);

            for (String keyA : set_of_keys_answers){
            
                System.out.println(keyA + ". " + this.answers.get(keyA));

            }
        }
      }

    public static void main(String[] args) {
        Question chamber1 = new Question();
        chamber1.questions.put("Which Option?", chamber1.answers);
        chamber1.answers.put("a", "Honey");// results are printing out of order
        // chamber1.answers.put("a", ["Honey","wrong"]); // what we thought would work: having an Array as the value...the wrong would not be seen but would be associated with the answer so that it would quit the game loop for being wrong
        chamber1.answers.put("b", "Cream");
        chamber1.answers.put("c", "Draught");
        System.out.println("Question: ");
        chamber1.printQuestion();

        
        //array array
        // have an array of con


        
    }
}

*/