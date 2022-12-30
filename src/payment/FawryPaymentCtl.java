package payment;

import Services.Service;
import user.User;
import user.Credit_Card;
import Discount.SpecificDiscount;
import Discount.OverallDiscounts;

import java.util.Scanner;
public class FawryPaymentCtl {
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



    public void Pay(User user, Context context, Service service) {
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
            SpecificDiscount specificDiscount = new SpecificDiscount(service);
            OverallDiscounts overallDiscounts = new OverallDiscounts(service);

            if (specificDiscount.CheckDiscount(service)){
                service = new SpecificDiscount(service);
            }
            if (overallDiscounts.CheckDiscount(user)){
                service = new OverallDiscounts(service);
            }

            service.setAmount(amount);
            Credit_Card card = user.getCreditCard();
            if(card==null && context.Current instanceof Credit_Card) {
                getCredit_Card_Information(user);
            }

           // boolean payDone = context.pay(user, service);
//            if (!(context.Current instanceof Cache_Payment ) && payDone){
//                user.AddService(service);
//            }


        }


    }





}

