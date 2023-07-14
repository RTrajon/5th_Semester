public class EmailTest{
    public static void main(String[] args){

        User newUser = new User();
        newUser.login("admin", "password");

        Emailservice objOne = new Emailservice();
        objOne.sentEmail("rajontalukder111@gmail.com", "hello", "this is the body of mail");
        

            
    }
}