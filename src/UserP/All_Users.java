package UserP;



import java.util.LinkedList;
import java.util.Objects;

public class All_Users {
    private static final LinkedList<User> Alluser = new LinkedList<>();

    
    
    public static User Search_About_User(String email){
        for (User user : Alluser) {
            if (Objects.equals(email, user.getEmail())) {
                return user;
            }
        }
        return null;
    }
    
    public static void Add_user(User NewUser) {
    	 Alluser.add(NewUser);
         System.out.println("Sign Up  successful");
    }
    
 
   
}