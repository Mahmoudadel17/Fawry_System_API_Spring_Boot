package UserP;

import CreatorServices.CreateService;
import CreatorServices.DialogServices;
import Services.Services;

import java.security.PublicKey;
import java.util.LinkedList;
import java.util.Scanner;

public class Screen {
	public static  FawryUserCtl FUCTL = new FawryUserCtl();

	
	 public static void UserHomeScreen(){
	        System.out.println("\n ________________ User Home Screen  _________________");
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
	        System.out.println("\n ________________ Admin Home Screen  _________________");
	        System.out.println("                                                ");
	        System.out.println(" _______________________________________________");
	        System.out.println("|                                               |");
	        System.out.println("|           1- Add discounts.                   |");
	        System.out.println("|           2- list all refund requests.        |");
	        System.out.println("|           3- Exit.                            |");
	        System.out.println("|_______________________________________________|\n");
	    }
	public static void ServicesScreen(){
		System.out.println("\n ________________ Services Screen  _________________");
		System.out.println("                                                ");
		System.out.println(" _______________________________________________");
		System.out.println("|                                               |");
		System.out.println("|           1- Mobile recharge services.        |");
		System.out.println("|           2- Internet Payment services.       |");
		System.out.println("|           3- Landline services.               |");
		System.out.println("|           4- Donations.                       |");
		System.out.println("|_______________________________________________|\n");
	}
	public static void MobileServicesScreen(){
		System.out.println("\n ________________ Mobile Services Screen  _________________");
		System.out.println("                                                ");
		System.out.println(" _______________________________________________");
		System.out.println("|                                               |");
		System.out.println("|           1- Vodafone.                        |");
		System.out.println("|           2- Etisalat.                        |");
		System.out.println("|           3- Orange.                          |");
		System.out.println("|           4- We.                              |");
		System.out.println("|_______________________________________________|\n");
	}
	public static void InternetServicesScreen(){
		System.out.println("\n ________________ Internet Services Screen  _________________");
		System.out.println("                                                ");
		System.out.println(" _______________________________________________");
		System.out.println("|                                               |");
		System.out.println("|           1- Vodafone.                        |");
		System.out.println("|           2- Etisalat.                        |");
		System.out.println("|           3- Orange.                          |");
		System.out.println("|           4- We.                              |");
		System.out.println("|_______________________________________________|\n");
	}
	public static void LandlineServicesScreen(){
		System.out.println("\n ________________ Landline Services Screen  _________________");
		System.out.println("                                                ");
		System.out.println(" _______________________________________________");
		System.out.println("|                                               |");
		System.out.println("|           1- Monthly receipt.                 |");
		System.out.println("|           2- Quarter receipt.                 |");
		System.out.println("|_______________________________________________|\n");
	}
	public static void DonationsServicesScreen(){
		System.out.println("\n ________________ Donations Services Screen  _________________");
		System.out.println("                                                ");
		System.out.println(" __________________________________________________");
		System.out.println("|                                                  |");
		System.out.println("|           1- Cancer Hospital.                    |");
		System.out.println("|           2- Schools.                            |");
		System.out.println("|           3- NGOs (Non profitable organizations).|");
		System.out.println("|__________________________________________________|\n");
	}



	public static void PaymentScreen(){
		System.out.println("\n ________________ Payment Screen  _________________");
		System.out.println("                                                ");
		System.out.println(" _______________________________________________");
		System.out.println("|                                               |");
		System.out.println("|           1- Default Payment.                 |");
		System.out.println("|           2- Wallet Payment.                  |");
		System.out.println("|_______________________________________________|\n");
	}
	public static void DeliveryPaymentScreen(){
		System.out.println("\n ________________ Payment Screen  _________________");
		System.out.println("                                                ");
		System.out.println(" _______________________________________________");
		System.out.println("|                                               |");
		System.out.println("|           1- Default Payment.                 |");
		System.out.println("|           2- Wallet Payment.                  |");
		System.out.println("|           3- Cache Payment.                  |");
		System.out.println("|_______________________________________________|\n");
	}
	public static void displayServicesScreen(LinkedList<Services> matchServices){
		System.out.println("\n ________________ display Services Screen  _________________");
		System.out.println("                                                ");
		System.out.println(" _______________________________________________");
		for (int i=0;i<matchServices.size();i++){
			System.out.println("|    "+(i+1)+"- "+matchServices.get(i).getName());
		}
		System.out.println(" _______________________________________________");
	}





	public static int cinput(int i,int j){
		int SER_Num;
		Scanner homeScan = new Scanner(System.in);
		while (true) {
			try {

				System.out.print("choice: ");
				String s = homeScan.nextLine();
				SER_Num = Integer.parseInt(s);
				if ( SER_Num<i ||  SER_Num>j) {
					System.out.println("invalid input \n");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("invalid input " + e.getMessage() + "\n");
			}

		}
		return SER_Num;
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
					int Choice = cinput(1,8);

					if( Choice==1) {
						user = FUCTL.Login_user();
					}else if( Choice==2) {
						user = FUCTL.Sign_Up();
					}
					else if( Choice==3) {
						// Search
						LinkedList<Services> matchServices;
						matchServices = FUCTL.Search_About_Service();
						displayServicesScreen(matchServices);

					}
					else if( Choice==4) {
						// pay
						ServicesScreen();
						// select Service
						int SER_Num = cinput(1,4);
						int SER_PRO_Num;
						// Select Service Provider
						if (SER_Num==1){
							MobileServicesScreen();
							SER_PRO_Num = cinput(1,4);
						}
						else if (SER_Num==2){
							InternetServicesScreen();
							SER_PRO_Num = cinput(1,4);
						}
						else if (SER_Num==3){
							LandlineServicesScreen();
							SER_PRO_Num = cinput(1,2);
						}
						else{
							DonationsServicesScreen();
							SER_PRO_Num = cinput(1,3);
						}
						DialogServices dialogService = CreateService.createservice(SER_Num,SER_PRO_Num);
						Services service = dialogService.CreateService();
						// Payment way
						int WayPay;
						if (service.checkDelivary()){
							DeliveryPaymentScreen();
							WayPay = cinput(1,3);
						}else {
							PaymentScreen();
							WayPay = cinput(1,2);
						}
						Context Payment_Way = new Context(null);

						if (WayPay== 1)
							Payment_Way = new Context(new Credit_Card_Payment());
						else if(WayPay==2)
							Payment_Way = new Context(new Wallet_Payment());
						else if (WayPay==3)
							Payment_Way = new Context(new Cache_Payment());
						FUCTL.Pay(user,Payment_Way,service);

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
						// add discount
					}else if( Choice1==2) {
						// list refunds
					}
					else if( Choice1==3) {
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

