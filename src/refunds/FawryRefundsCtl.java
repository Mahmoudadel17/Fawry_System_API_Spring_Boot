package refunds;

import transactions.All_Transactions;
import transactions.Refund_transaction;
import user.User;

import java.util.LinkedList;
import java.util.Scanner;
public class FawryRefundsCtl {
    All_Refunds allRefunds = new All_Refunds();

    // user
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
            AddRequestToList(request);
            user.AddRequest(request);
            // transaction
            Refund_transaction refundTransaction = new Refund_transaction(user,request);
            All_Transactions allTransactions = new All_Transactions();
            allTransactions.Add_refund_transactions(refundTransaction);
        }
        else {
            System.out.println("You have not used any service :)");
        }

    }



    public LinkedList<Request> getAllRefundRequsets(User user){
        return user.getAllRefundRequsets();
    }



    // admin

    public void AddRequestToList(Request request){
        allRefunds.AddRequest(request);
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
                break;
            }

            if (allRefunds.getAllRequest().size()==0){
                System.out.println("No Request founded");
                t=false;
            }else {
                for (int i = 0;i<allRefunds.getAllRequest().size();i++){
                    System.out.println(" _______________________________________________");
                    System.out.println("|      Request ID:   "+(i+1));
                    System.out.println("|      Service Name: "+allRefunds.getAllRequest().get(i).getService().getName());
                    System.out.println("|      Amount:       "+allRefunds.getAllRequest().get(i).getService().getAmount());
                    System.out.println("|      User name:    "+allRefunds.getAllRequest().get(i).getUser().getUserName());
                    System.out.println("|_______________________________________________|\n");
                }
                int id;
                while (true) {
                    try {
                        Scanner homeScan = new Scanner(System.in);

                        System.out.print("Request id:");
                        String s = homeScan.nextLine();
                        id = Integer.parseInt(s);
                        if ( id<1 ||  id>allRefunds.getAllRequest().size()) {
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
                    allRefunds.getAllRequest().get(id-1).setState_Accepted();
                    Request request = allRefunds.getRemovedRequest(id-1);
                    // remove service from user pay service
                    request.getUser().RemoveService(request.getServicesId());
                    // add amount to user wallet
                    request.getUser().getWallet().add_to_wallet(request.getService().getAmount());

                }
                else{
                    allRefunds.getAllRequest().get(id-1).setState_Rejected();
                    allRefunds.RemoveRequest(id-1);
                }

            }












        }

    }









}
