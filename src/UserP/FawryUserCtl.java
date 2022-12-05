package UserP;

import AdminP.FawryAdminCtl;
import AdminP.Request;
import Discount.OverallDiscounts;
import Discount.SpecificDiscount;
import Services.Services;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class FawryUserCtl {

	public User Login_user() {
		 while (true){
	            Scanner s = new Scanner(System.in);
	            System.out.print("Enter your Email: ");
	            String email = s.nextLine();
	            System.out.print("Enter your password: ");
	            String password = s.nextLine();

	            User NewUser = All_Users.Search_About_User(email);
	            
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
             
              User check = All_Users.Search_About_User(email);

              if (check==null){
            	 User NewUser = new User(Name,email,password);
                 All_Users.Add_user(NewUser);
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
	
	public LinkedList<Services> Search_About_Service() {
		 Scanner s = new Scanner(System.in);
		 System.out.print("Enter your Name of Service: ");
         String NameService = s.nextLine();
         return SearchingList.Search(NameService);
	}

	public void getCredit_Card_Information(User user) {
		Scanner s = new Scanner(System.in);
		System.out.println("----- Credit Card Information-----");
		System.out.println("----------------------------------");
		System.out.print("Enter Cardholder_name: ");
        String Cardholder_name = s.nextLine();
        System.out.print("Enter Card Number: ");
        String Card_number = s.nextLine();
        System.out.print("Enter Card Expiration date  : ");
        String Expiration_date = s.nextLine();
        System.out.print("Enter Card CVV: ");
        String CVV = s.nextLine();
        
        Credit_Card card = new Credit_Card(Cardholder_name,Card_number,Expiration_date,CVV);
        user.setCreditCard(card);
	}
	
	public void Add_Funds_to_Wallet(User user) {
		if(user==null) {
			System.out.println("Please Login");
		}
		else {
			 Scanner s = new Scanner(System.in);
			 long amount;
				while (true) {
				    try {
				       
				        System.out.print("Enter Amount You Need To Add it into Wallet: ");
				        String am = s.nextLine();
				        amount = Long.parseLong(am);
				        break;
				    } catch (NumberFormatException e) {
				        System.out.println("invalid input " + e.getMessage() + "\n");
				    }
				}
				Credit_Card card = user.getCreditCard();
				if(card==null) {
					getCredit_Card_Information(user);
					card = user.getCreditCard();
				}
				
				if(card.getbalance()>=amount) {
					card.use_credit_money(amount);
					user.getWallet().add_to_wallet(amount);
					System.out.println(" Wallet money : "+user.getWallet().wallet_money());
					
				}
				else {
					System.out.println("Sorry this Amount Not available in your account, your balance is : "+card.getbalance());
				}
				
				
		}
		
			
		 
	
			
	}

	public void MakeRefund(User user){
		if(user.getAllServicesPay().size()!=0) {
			for (int i = 0;i<user.getAllServicesPay().size();i++){
				System.out.println(" _______________________________________________");
				System.out.println("|      Service ID:   "+(i+1));
				System.out.println("|      Service Name: "+user.getAllServicesPay().get(i).getName());
				System.out.println("|      Amount:       "+user.getAllServicesPay().get(i).getAmount());
				System.out.println("|_______________________________________________|\n");
			}
			
			int id;
			Scanner homeScan = new Scanner(System.in);
			while (true) {
				try {

					System.out.print("Enter Service id you want to refund: ");
					String s = homeScan.nextLine();
					id = Integer.parseInt(s);
					if ( id<1 ||  id>user.getAllServicesPay().size()) {
						System.out.println("invalid input \n");
						continue;
					}
					break;
				} catch (NumberFormatException e) {
					System.out.println("invalid input " + e.getMessage() + "\n");
				}

			}
			Request request = new Request(user.getAllServicesPay().get(id-1),user,id-1);
			FawryAdminCtl.AddRequestToList(request);
			user.AddRequest(request);
		}
		else {
			System.out.println("You have not used any service :)");
		}

	}

	public LinkedList<Request> getAllRefundRequsets(User user){
		return user.getAllRefundRequsets();
	}
	
	public void Pay(User user,Context context,Services service) {
		if (user == null) {
			System.out.println("Please Login");
		} else {
			Scanner homeScan = new Scanner(System.in);
			System.out.print("Enter Your Mobile Number: ");
			String MOBNumber = homeScan.nextLine();
			user.setMobileNumber(MOBNumber);
			System.out.print("Enter Amount of Money You Want to Pay: ");

			long amount;
			while (true) {
				try {
					String s = homeScan.nextLine();
					amount = Integer.parseInt(s);
					break;
				} catch (NumberFormatException e) {
					System.out.println("invalid input " + e.getMessage() + "\n");
				}
			}
			if (SpecificDiscount.CheckDiscount(service)){
				service = new SpecificDiscount(service);
			}
			if (OverallDiscounts.CheckDiscount(user)){
				service = new OverallDiscounts(service);
			}

			service.setAmount(amount);
			Credit_Card card = user.getCreditCard();
			if(card==null) {
				getCredit_Card_Information(user);
			}

			boolean payDone = context.pay(user, service);
			if (!(context.Current instanceof Cache_Payment ) && payDone){
				  user.AddService(service);
			}


		} 


	}

	public long[] CheckDiscount(){

		long[] arr={0,0,0,0};
		if (Objects.equals(SpecificDiscount.getServicesNameDiscount(), "mobile recharge")){
			arr[0]=SpecificDiscount.getDiscount();
		}else if (Objects.equals(SpecificDiscount.getServicesNameDiscount(), "internet payment")){
			arr[1]=SpecificDiscount.getDiscount();

		}else if (Objects.equals(SpecificDiscount.getServicesNameDiscount(), "landline")){
			arr[2]=SpecificDiscount.getDiscount();

		}else if (Objects.equals(SpecificDiscount.getServicesNameDiscount(), "donations")){
			arr[3]=SpecificDiscount.getDiscount();

		}
		return arr;
	}

}
