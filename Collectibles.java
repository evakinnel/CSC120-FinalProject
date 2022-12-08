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

    public int use(int uses){
        System.out.println(this.catchphrase);
        this.uses -= uses;
        System.out.println("You have used " + this.name + " to " + this.power + ".");
        System.out.println("You have " + this.uses + " uses left of " + this.name);
        return this.uses;
    }
    
    public static void main(String[] args) {
        Collectibles riddlesDiary = new Collectibles("Tom Riddle's Diary", "An empty book", "see the past", 2, "I can't tell you, but I can show you");
        riddlesDiary.use(1);
    }
    
}
