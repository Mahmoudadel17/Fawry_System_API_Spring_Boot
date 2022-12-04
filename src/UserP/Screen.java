package UserP;

import java.util.Scanner;

public class Screen {
	public static  FawryUserCtl FUCTL = new FawryUserCtl();

	
	 public static void UserHomeScreen(){
	        System.out.println("\n ________________ User Home screen  _________________");
	        System.out.println("                                                ");
	        System.out.println(" welcome to, Fawry System Services              ");
	        System.out.println(" _______________________________________________");
	        System.out.println("|                                               |");
	        System.out.println("|           1- Login.                           |");
	        System.out.println("|           2- Sign Up.                         |");
	        System.out.println("|           3- Search for Service.              |");
	        System.out.println("|           4- Pay.                             |");
	        System.out.println("|           5- Ask for a Refund.                |");
	        System.out.println("|           6- Add Funds to Wallet.             |");
	        System.out.println("|           7- check any discount.              |");
	        System.out.println("|           8- Exit.                            |");
	        System.out.println("|_______________________________________________|\n");
	    }
	 public static void AdminHomeScreen(){
	        System.out.println("\n ________________ Admin Home screen  _________________");
	        System.out.println("                                                ");
	        System.out.println(" _______________________________________________");
	        System.out.println("|                                               |");
	        System.out.println("|           1- Add Service.                     |");
	        System.out.println("|           2- Add discounts.                   |");
	        System.out.println("|           3- list all refund requests.        |");
	        System.out.println("|           4- Exit.                            |");
	        System.out.println("|_______________________________________________|\n");
	    }
	 
	
	
	
	
	
	public static void main(String arg[]) {
		
		 Scanner homeScan = new Scanner(System.in);
		 boolean c=true;
		 
		while(c) {
			 // 
			 int Select_user_or_admin;
			while (true) {
			    try {
			        System.out.println("1- User.");
			        System.out.println("2- Admin.");
			        System.out.println("3- Exit.");
			        System.out.print("choice: ");
			        String s = homeScan.nextLine();
			        Select_user_or_admin = Integer.parseInt(s);
			        if (Select_user_or_admin != 1 && Select_user_or_admin != 2 && Select_user_or_admin != 3) {
			            System.out.println("invalid input \n");
			            continue;
			        }
			        break;
			    } catch (NumberFormatException e) {
			        System.out.println("invalid input " + e.getMessage() + "\n");
			    }

			}
			
			if(Select_user_or_admin==1) {
				boolean c1=true;User user=null;
				while(c1) {
					UserHomeScreen();
					int Choice;
					while (true) {
					    try {
					       
					        System.out.print("choice: ");
					        String s = homeScan.nextLine();
					        Choice = Integer.parseInt(s);
					        if ( Choice<1 ||  Choice>8) {
					            System.out.println("invalid input \n");
					            continue;
					        }
					        break;
					    } catch (NumberFormatException e) {
					        System.out.println("invalid input " + e.getMessage() + "\n");
					    }

					}
					if( Choice==1) {
						user = FUCTL.Login_user();
					}else if( Choice==2) {
						user = FUCTL.Sin_Up();
					}
					else if( Choice==3) {
						// Search 
					}
					else if( Choice==4) {
						// pay 
					}
					else if( Choice==5) {
						// ask refund
					}
					else if( Choice==6) {
							FUCTL.Add_Funds_to_Wallet(user);
					}
					else if( Choice==7) {
						// discount
					}else if( Choice==8) {
						System.out.println("Thanks-_-");
						c1=false;
					}
					
					
					
				}
				
				
				
				
			}
			else if(Select_user_or_admin == 2 ) {
				
				boolean c2=true;
				while(c2) {
					AdminHomeScreen();
					int Choice1;
					while (true) {
					    try {
					       
					        System.out.print("choice: ");
					        String s = homeScan.nextLine();
					        Choice1 = Integer.parseInt(s);
					        if ( Choice1<1 ||  Choice1>4) {
					            System.out.println("invalid input \n");
					            continue;
					        }
					        break;
					    } catch (NumberFormatException e) {
					        System.out.println("invalid input " + e.getMessage() + "\n");
					    }

					}
					if( Choice1==1) {
						// add Service
					}else if( Choice1==2) {
						// add discount
					}
					else if( Choice1==3) {
						//  list refund 
					}
					else if( Choice1==4) {
						System.out.println("Thanks-_-");
						c2=false;
					}
						
					}
				
			}
			else {
				System.out.println("Good by -_-");
				c=false;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

