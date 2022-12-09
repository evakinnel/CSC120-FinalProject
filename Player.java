import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    
    public String username;
    private int lives;
    public String catchphrase;
    private ArrayList<String> backpack;


    public Player(String username, String catchprase){
        this.username = username;
        this.lives = 3;
        this.catchphrase = catchprase;
        this.backpack = new ArrayList<String>();
    }

    // method add to backpack
     public void addBackpack(String collectible){
      this.backpack.add(collectible);
    }
    public void removeBackpack(String collectible){
      this.backpack.remove(collectible);
    }
    //intro method


    public static void main(String[] args) {
        System.out.println("What would you like your username to be?");
        Scanner inputUsername = new Scanner(System.in);
        String username = inputUsername.nextLine();
        System.out.println("What would you like your catchphrase to be?");
        Scanner inputCatchphrase = new Scanner(System.in);
        String catchphrase = inputCatchphrase.nextLine();
        Player player1 = new Player(username.toString(), catchphrase.toString());
        System.out.println("You are playing as " + player1.username + ". They say " + player1.catchphrase + ". You have " + player1.lives + " lives.");




        inputUsername.close();
        inputCatchphrase.close(); 
    }
    

}
