package Discount;

import user.User;

import java.util.Objects;
import java.util.Scanner;

public class FawryDiscountCtl {
    public long[] CheckDiscount(User user){

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
        if ( user.getAllServicesPay().size() == 0){
            for (int i=0; i<4;i++){
                arr[i]+= OverallDiscounts.getDiscount();
            }
        }

        return arr;
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



}
