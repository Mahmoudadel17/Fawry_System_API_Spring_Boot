package user;

import java.util.Objects;
import java.util.Scanner;

public class FawryLoginCtl {
    All_Users allUsers = new All_Users();
    public User Login_user() {
        while (true){
            Scanner s = new Scanner(System.in);
            System.out.print("Enter your Email: ");
            String email = s.nextLine();
            System.out.print("Enter your password: ");
            String password = s.nextLine();

            User NewUser = allUsers.Search_About_User(email);

            if (NewUser==null)
            {
                System.out.println("Email not found, ");
                return null;

            }
            else if (Objects.equals(NewUser.getPassword(), password)){
                System.out.println("hello "+NewUser.getUserName());
                return NewUser;
            }
            else {
                System.out.println("password incorrect--");

            }


        }

    }

    public User Sign_Up() {
        boolean t = true;
        while (t){
            System.out.println("Please Sign up");
            System.out.println("----------------------");
            Scanner s = new Scanner(System.in);
            System.out.print("Enter your Name: ");
            String Name = s.nextLine();
            System.out.print("Enter your Email: ");
            String email = s.nextLine();
            System.out.print("Enter your password: ");
            String password = s.nextLine();

            User check = allUsers.Search_About_User(email);

            if (check==null){
                User NewUser = new User(Name,email,password);
                allUsers.Add_user(NewUser);
                return NewUser;
            }
            else {
                System.out.print("this email already signup, Login!!");
                t=false;
            }

        }
        System.out.println("error");
        return null;
    }


}
