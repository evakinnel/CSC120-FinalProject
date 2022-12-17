/*
 * The Adventures of Hogwarts
 * CSC 120 Final Project
 * Class - Collectibles: houses the information and functionality pertaining to the collectibles
 * Authors: Abby Paharsingh, Eva Kinnel, Gracia Bareti
 * Date: 21 December 2022
 */

public class Collectibles {

    private String name;
    private String description;
    private String power;
    private int uses;
    private String catchphrase;


    /**
     * Constructor for collectibles
     * @param name the name of the collectible
     * @param description a short description of the collectible
     * @param power why the collectible is useful
     * @param uses the amount of times the object can be used by the user
     * @param catchprase a phrase that goes with the collectible, fun and/or informative
     */
    public Collectibles(String name, String description, String power, int uses, String catchprase){
        this.name = name;
        this.description = description;
        this.power = power;
        this.uses = uses;
        this.catchphrase = catchprase;
        
    }
    
    /**
     * prints information about the collectible 
     */
    public void addCollectible(){
        System.out.println("You have won the collectible: " + this.name + ". It is " + this.description + ". It has the power to " + this.power + ".");
        this.speak();
    }

    /**
     * print collectible catchphrase
     */
    public void speak(){
        System.out.println(this.catchphrase);
    }

    /**
     * print the name of the collectible
     */
    public void getName(){
        System.out.println(this.name);
    }

    /**
     * Explain what the collectible is being used for, and reduce the number of uses left
     * (unused)
     * @param uses how many times for the item to be used
     * @return the number of uses left
     */
    public int use(int uses){
        this.speak();
        this.uses -= uses;
        System.out.println("You have used " + this.name + " to " + this.power + ".");
        System.out.println("You have " + this.uses + " uses left of " + this.name);
        return this.uses;
    }
    
    /**
     * main method for testing
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("\n");

        Collectibles riddlesDiary = new Collectibles("Tom Riddle's Diary", "An empty book", "see the past", 2, "I can't tell you, but I can show you");
        riddlesDiary.use(1);
        
        System.out.println("\n");

    }
    
}
