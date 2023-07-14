//sub class Dog & inharitance by using Extends keywords
public class Dog extends Animals{
    private String breed;

    //method with perameter
    public Dog(String name, String colour, String breed){
        super(name, colour); //super keyword for eccess the member of super class
        this.breed = breed;
    }
    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
}