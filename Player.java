import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    
    public String username;
    public int lives;
    public static String catchphrase;
    public ArrayList<Collectibles> backpack;


    public Player(String username, String catchprase){
        this.username = username;
        this.lives = 3;
        this.catchphrase = catchprase;
        this.backpack = new ArrayList<>();
    }

    // method add to backpack
     public void addBackpack(Collectibles collectible){
      this.backpack.add(collectible);
      collectible.addCollectible();
    }
    public void removeBackpack(Collectibles collectible){
      this.backpack.remove(collectible);
    }
    
    public int loseLives(){

      this.lives -= 1;
      System.out.println("You have lost a life. You have " + this.lives + " lives left.");
      return this.lives;
  }
    public int getLives(){
      System.out.println("You have " + this.lives + " lives left.");
      return this.lives;
    }

    public static void getHelp(){
      System.out.println("Here are the things you can do:");
      
    }
    
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
