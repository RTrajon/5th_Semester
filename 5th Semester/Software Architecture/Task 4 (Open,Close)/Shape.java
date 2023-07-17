//abstract for incomplete implimentation
abstract class Shape{
    //method
    public abstract double calculateArea();
}
//extends for accessing the elements of shape class
class Circle extends Shape{
    private double radius;

    //method with perameter
    public Circle(double radius){
        this.radius = radius;
    }
    
    //@override for override a Superclass method
    //reduse time, complexity etc.
    @Override
    public double calculateArea(){
        return 3.14 * radius * radius;
    }
}
