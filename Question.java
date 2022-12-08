import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

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

        Set<String> setOfKeysQuestions = this.questions.keySet();
        Set<String> setOfKeysAnswers = this.answers.keySet();
        for (String key : setOfKeysQuestions) {

            System.out.println(key);

            for (String keyA : setOfKeysAnswers){
            
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


        
    }
}