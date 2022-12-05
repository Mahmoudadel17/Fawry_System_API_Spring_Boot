package AdminP;

import Discount.OverallDiscounts;
import Discount.SpecificDiscount;

import java.util.Scanner;

public class FawryAdminCtl {
    public static void AddRequestToList(Request request){
        Admin.AddRequest(request);
    }

    public void AddDiscount(){
        int choice;
        while (true) {
            try {
                Scanner homeScan = new Scanner(System.in);
                System.out.println(" _______________________________________________");
                System.out.println("|         1- Overall discounts.                 |");
                System.out.println("|         2- Specific discount                  |");
                System.out.println(" _______________________________________________");
                System.out.print("Choice:");
                String s = homeScan.nextLine();
                choice = Integer.parseInt(s);
                if ( choice<1 ||  choice>2) {
                    System.out.println("invalid input \n");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("invalid input " + e.getMessage() + "\n");
            }

        }
        int discount;
        if (choice==1){

            while (true) {
                try {
                    Scanner homeScan = new Scanner(System.in);
                    System.out.print("Enter Amount of Discount $%: ");
                    String s = homeScan.nextLine();
                    discount = Integer.parseInt(s);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("invalid input " + e.getMessage() + "\n");
                }

            }
            OverallDiscounts.setDiscount(discount);
        }
        else {
            int selectServices;
            while (true) {
                try {
                    Scanner homeScan = new Scanner(System.in);
                    System.out.println(" _______________________________________________");
                    System.out.println("|         1- Mobile recharge.                   |");
                    System.out.println("|         2- Internet Payment.                  |");
                    System.out.println("|         3- Landline.                          |");
                    System.out.println("|         4- Donations.                         |");
                    System.out.println(" _______________________________________________");
                    System.out.print("Choice:");
                    String s = homeScan.nextLine();
                    selectServices = Integer.parseInt(s);
                    if ( selectServices<1 ||  selectServices>4) {
                        System.out.println("invalid input \n");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("invalid input " + e.getMessage() + "\n");
                }

            }

            while (true) {
                try {
                    Scanner homeScan = new Scanner(System.in);
                    System.out.print("Enter Amount of Discount $%: ");
                    String s = homeScan.nextLine();
                    discount = Integer.parseInt(s);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("invalid input " + e.getMessage() + "\n");
                }

            }
            SpecificDiscount.setDiscount(discount);
            if (selectServices==1){
                SpecificDiscount.setServicesNameDiscount("mobile recharge");
            }else if (selectServices==2){
                SpecificDiscount.setServicesNameDiscount("internet payment");
            }else if (selectServices==3){
                SpecificDiscount.setServicesNameDiscount("landline");
            }else {
                SpecificDiscount.setServicesNameDiscount("donations");
            }

        }




    }

    public void listrefund(){
        boolean t=true;
        while (t){
            int choice;
            while (true) {
                try {
                    Scanner homeScan = new Scanner(System.in);

                    System.out.println(" _______________________________________________");
                    System.out.println("|         1- Choice Request                     |");
                    System.out.println("|         2- Exit                               |");
                    System.out.println(" _______________________________________________");
                    System.out.print("Choice:");
                    String s = homeScan.nextLine();
                    choice = Integer.parseInt(s);
                    if ( choice<1 ||  choice>2) {
                        System.out.println("invalid input \n");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("invalid input " + e.getMessage() + "\n");
                }

            }

            if (choice==2){
                t=false;
            }

            if (Admin.getAllRequest().size()==0){
                System.out.println("No Request founded");
                t=false;
            }else {
                for (int i = 0;i<Admin.getAllRequest().size();i++){
                    System.out.println(" _______________________________________________");
                    System.out.println("|      Request ID:   "+(i+1));
                    System.out.println("|      Service Name: "+Admin.getAllRequest().get(i).getService().getName());
                    System.out.println("|      Amount:       "+Admin.getAllRequest().get(i).getService().getAmount());
                    System.out.println("|      User name:    "+Admin.getAllRequest().get(i).getUser().getUserName());
                    System.out.println("|_______________________________________________|\n");
                }
                int id;
                while (true) {
                    try {
                        Scanner homeScan = new Scanner(System.in);

                        System.out.print("Request id:");
                        String s = homeScan.nextLine();
                        id = Integer.parseInt(s);
                        if ( id<1 ||  id>Admin.getAllRequest().size()) {
                            System.out.println("invalid input \n");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("invalid input " + e.getMessage() + "\n");
                    }

                }

                System.out.println(" _______________________________________________");
                System.out.println("|         1- Accepted                           |");
                System.out.println("|         2- Rejected                           |");
                System.out.println(" _______________________________________________");
                int stat;
                while (true) {
                    try {
                        Scanner h = new Scanner(System.in);
                        System.out.print("choice: ");
                        String s = h.nextLine();
                        stat = Integer.parseInt(s);
                        if ( stat<1 ||  stat>2) {
                            System.out.println("invalid input \n");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("invalid input " + e.getMessage() + "\n");
                    }

                }


                if (stat==1){
                    Admin.getAllRequest().get(id-1).setState_Accepted();
                    Request request = Admin.getRemovedRequest(id-1);
                    // remove service from user pay service
                    request.getUser().RemoveService(request.getServicesId());
                    // add amount to user wallet
                    request.getUser().getWallet().add_to_wallet(request.getService().getAmount());

                }
                else{
                    Admin.getAllRequest().get(id-1).setState_Rejected();
                    Admin.RemoveRequest(id-1);
                }

            }












        }

    }
}
