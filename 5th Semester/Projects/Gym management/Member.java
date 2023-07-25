public class Member {
    private int id;
    private String name;
    private int age;
    private String memberType;
    private String balance;

    // initializing the instance variables
    public void Member(int id, String name, int age, String memberType, String balance){
        this.id = id;
        this.name = name;
        this.age = age;
        this.memberType = memberType;
        this.balance = balance;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getMemberType(){
        return memberType;
    }
    public String getbalance(){
        return balance;
    }
    public void addPayment(double amount){
        balance += amount;
    }
    public void displayBalance(){
        System.out.println("Name:" +name + " balance:" +balance);
    }
}
