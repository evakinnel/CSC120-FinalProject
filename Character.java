// this class is unused, was created for possible future implementations
/*
 * The Adventures of Hogwarts
 * CSC 120 Final Project
 * Class - Character: houses the information and functionality pertaining to the NPCs
 * Authors: Eva Kinnel, Abby Paharsingh, Gracia Bareti
 * Date: 21 December 2022
 */

import java.util.Hashtable;

public class Character {

    private String name;
    private String description;
    private String role; //victim, villain, riddler
    private String power; //eventually hopefully they can have more than 1 power
    private String catchphrase;
    

    /**
     * 
     * @param name the name of the character
     * @param description a short description of the character
     * @param role what role the character has in the game
     * @param power what the character does
     * @param catchprase a phrase to be spoken by the character
     */
    public Character(String name, String description, String role, String power, String catchprase){
        this.name = name;
        this.description = description;
        this.role = role;
        this.power = power;
        this.catchphrase = catchprase; 
    }

    /**
     * main method for testing
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("\n");

        Character basilisk = new Character("Basilisk", "a bloody large focking snake", "villain", "deathly eye contact", "ssssssssss");
        
        // basilisk.describe();
        // basilisk.speak();

        System.out.println("\n");

    
    }
    
}
