public class Shape {
    //method with 3 perameters
    public double calculateArea(String shapeType, double a, double b){
        double area = 0.0;

        //equalsIgnoreCase used for ignore case So,shapeType & circle consider as equal
        if(shapeType.equalsIgnoreCase("circle")){
            double radius = a;
            area = 3.14 * radius * radius; //circle formula
        }
        
        else if(shapeType.equalsIgnoreCase("rectangle")){
            double width = a;
            double height = b;
            area = width * height;
        }
        return area;
    }
}
