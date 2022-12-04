package UserP;

import java.util.Objects;
import java.util.Scanner;

public class FawryUserCtl {
	private All_Users  users;
	
	public FawryUserCtl() {
		users = new All_Users();
	}
	
	public boolean Login_user() {
		 while (true){
	            Scanner s = new Scanner(System.in);
	            System.out.print("Enter your Email: ");
	            String email = s.nextLine();
	            System.out.print("Enter your password: ");
	            String password = s.nextLine();

	            User NewUser = All_Users.Search_About_User(email);
	            if (NewUser==null){Sin_Up();System.out.print("Email not found, "); return false;}
	            else if (Objects.equals(NewUser.getPassword(), password)){
	                System.out.println("hello "+NewUser.getUserName());
	                return true;
	            }else {System.out.println("password incorrect--");return false;}


	        }
	}
	
	public void Sin_Up() {
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
              User NewUser = new User(Name,email,password);
              User check = users.Search_About_User(email);

              if (check==null){
                 users.Add_user(NewUser);
                  t = false;
              }
              else {
                  System.out.print("this email already signup, Login!!");
                  t=false;
              }

          }
	}

}
