import java.util.Hashtable;

public class Character {

    private String name;
    private String description;
    private String role; //victim, villain, riddler
    private String power; //eventually hopefully they can have more than 1 power
    private String catchphrase;


    public Character(String name, String description, String role, String power, String catchprase){
        this.name = name;
        this.description = description;
        this.role = role;
        this.power = power;
        this.catchphrase = catchprase;
        
    }


    public static void main(String[] args) {
        Character basilisk = new Character("Basilisk", "A bloody large focking snake", "villain", "deathly eye contact", "ssssssssss");
    }
    
}
