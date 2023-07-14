import java.util.ArrayList;
import java.util.List;


public class Main 
{
    public static void main(String[] args) 
    {
        Teacher Maria = new Teacher(1,"Maria",500);
        Teacher Fahmida = new Teacher(2,"Fahmida",700);
        Teacher Shafat = new Teacher(3,"Shafat",600);

        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(Maria);
        teacherList.add(Fahmida);
        teacherList.add(Shafat);


        Student Ove = new Student(1,"Ove",4);
        Student Sadia = new Student(2,"Sadia",12);
        Student Momo = new Student(3,"Momo",5);
        List<Student> studentList = new ArrayList<>();

        studentList.add(Ove);
        studentList.add(Sadia);
        studentList.add(Momo);




        School mu = new School(teacherList,studentList);

        Teacher Nowrin = new Teacher(6,"Nowrin", 900);

        mu.addTeacher(Nowrin);


        Ove.payFees(5000);
        Sadia.payFees(6000);
        System.out.println("MU has earned $"+ mu.getTotalMoneyEarned());

        System.out.println("------Making SCHOOL PAY SALARY----");
        Maria.receiveSalary(Maria.getSalary());
        System.out.println("MU has spent for salary to " + Maria.getName()
        +" and now has $" + mu.getTotalMoneyEarned());

        Fahmida.receiveSalary(Fahmida.getSalary());
        System.out.println("MU has spent for salary to " + Fahmida.getName()
                +" and now has $" + mu.getTotalMoneyEarned());


        System.out.println(Momo);

        Fahmida.receiveSalary(Fahmida.getSalary());

        System.out.println(Fahmida);


    }
}