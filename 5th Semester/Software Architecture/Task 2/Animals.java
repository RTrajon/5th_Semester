//Super class or perent class
public class Animals {
    private String name; //vriable deceleration with access modifier.
    private String colour; //vriable deceleration with access modifier.

    //method with perameter
    public Animals(String name, String colour){
        this.name = name;
        this.colour = colour;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
}