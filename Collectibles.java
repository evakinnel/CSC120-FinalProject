import java.util.Hashtable;

public class Collectibles {

    private String name;
    private String description;
    private String power;
    private int uses;
    private String catchphrase;


    public Collectibles(String name, String description, String power, int uses, String catchprase){
        this.name = name;
        this.description = description;
        this.power = power;
        this.uses = uses;
        this.catchphrase = catchprase;
        
    }

    // collectible says its catchphrase

    public void addCollectible(){
        System.out.println("You have won the collectible: " + this.name + ". It is " + this.description + ". It has the power to " + this.power + ".");
        this.speak();
    }

    public void speak(){
        System.out.println(this.catchphrase);
    }

    public void describe(){
        System.out.print(this.description);
    }

    public void getName(){
        System.out.println(this.name);
    }

    public void getPower(){
        System.out.print(this.power);
    }

    public int use(int uses){
        this.speak();
        this.uses -= uses;
        System.out.println("You have used " + this.name + " to " + this.power + ".");
        System.out.println("You have " + this.uses + " uses left of " + this.name);
        return this.uses;
    }
    
    public static void main(String[] args) {
        System.out.println("\n");

        Collectibles riddlesDiary = new Collectibles("Tom Riddle's Diary", "An empty book", "see the past", 2, "I can't tell you, but I can show you");
        riddlesDiary.use(1);
        
        System.out.println("\n");

    }
    
}
