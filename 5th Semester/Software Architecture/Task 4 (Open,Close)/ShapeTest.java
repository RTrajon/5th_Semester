public class ShapeTest {
    public static void main(String[] args){

        //objact
        Rectangle newRectangle = new Rectangle(10, 10);
        //method is called on class
        newRectangle.calculateArea(); //or Super.calculateArea();
        System.out.println("Area of Rectangle: "+ newRectangle.calculateArea());

        Circle newCircle = new Circle(10);
        double area = newCircle.calculateArea();
        System.out.println("Area of Circle: " + area);
    };
}