public class User{
    public void login(String username, String password)
    {
        if(username == "admin" && password == "password"){
            System.out.println("login success");
        }
        else{
            System.out.println("Invalid username or password");
        }
    }
}