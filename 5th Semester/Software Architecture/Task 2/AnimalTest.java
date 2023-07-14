public class AnimalTest{
    public static void main(String[] args){

        //object creation
        Dog Pet = new Dog("mosko", "brown", "german");
        
        //Pet.Dog("mosko", "brown", "german");
        //System.out.println(shepherd.getname());"Mosko", "Brown", "German"
        System.out.println(Pet.getName());
        System.out.println(Pet.getColour());
        System.out.println(Pet.getBreed());

    }
}