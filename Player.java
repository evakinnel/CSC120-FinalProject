/*
 * The Adventures of Hogwarts
 * CSC 120 Final Project
 * Class - Player: houses the information and functionality pertaining to the user/player
 * Authors: Gracia Bareti, Abby Paharsingh, Eva Kinnel
 * Date: 21 December 2022
 */

 import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    
    public String username;
    public int lives;
    public static String catchphrase;
    public ArrayList<Collectibles> backpack;


    /**
     * Constructor for Player
     * @param username the username that the player will chose
     * @param catchprase the catchphrase a player will chose (to be printed when they succeed at things)
     */
    public Player(String username, String catchprase){
        this.username = username;
        this.lives = 3;
        this.catchphrase = catchprase;
        this.backpack = new ArrayList<>();
    }

    /**
     * adds a collectible to the backpack
     * @param collectible the collectible to be added
     */
     public void addBackpack(Collectibles collectible){
      this.backpack.add(collectible);
      collectible.addCollectible();
    }

    /**
     * removes a collectible from the backpack
     * @param collectible the collectible to be removed
     */
    public void removeBackpack(Collectibles collectible){
      this.backpack.remove(collectible);
    }
    
    /**
     * decreases number of lives by 1
     * @return number of lives left
     */
    public int loseLives(){
      this.lives -= 1;
      System.out.println("You have lost a life. You have " + this.lives + " lives left.");
      return this.lives;
    }

    /**
     * tells how many lives are left
     * @return number ot lives left
     */
    public int getLives(){
      // System.out.println("You have " + this.lives + " lives left.");
      return this.lives;
    }

    /**
     * (unused, if used should move to Hogwarts/Main class)
     * prints the things that might help the player if they call  this function
     */
    public static void getHelp(){
      System.out.println("Here are the things you can do:");
      
    }
    
    /**
     * main method for testing
     * @param args
     */
    public static void main(String[] args) {
      System.out.println("\n");

      // System.out.println("What would you like your username to be?");
      // Scanner inputUsername = new Scanner(System.in);
      // String username = inputUsername.nextLine();
      // System.out.println("What would you like your catchphrase to be?");
      // Scanner inputCatchphrase = new Scanner(System.in);
      // String catchphrase = inputCatchphrase.nextLine();
      // Player player1 = new Player(username.toString(), catchphrase.toString());
      // System.out.println("You are playing as " + player1.username + ". They say " + player1.catchphrase + ". You have " + player1.lives + " lives.");

      Player player1 = new Player("abby", "POW");

      Collectibles diary = new Collectibles("diary", "heloo", "arrr", 1, "bloop"); 

      player1.addBackpack(diary);

      System.out.println("\n");



      // inputUsername.close();
      // inputCatchphrase.close(); 
    }
    

}
