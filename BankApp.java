package Java.javaApp;
import java.util.Scanner;
public class BankApp {




    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
            System.out.println("---------Welcome to the Bank Of India ------------");
            float balance = 0;
            boolean x = true;
            final String id="Chule01";
            final String pass="Chule01";
            int attempt=1;

             while(attempt<=3){
                 System.out.println("enter User Id : ");
                 String userid=sc.next();
                 System.out.println("enter password : ");
                 String password=sc.next();
                 attempt++;
                 if(id.equals(userid) && pass.equals(password)){
                     Transaction(balance,x);
                     break;
                 }
                 else {
                     System.out.println("Wrong id and password");
                 }
                 System.out.println("You have only "+(3-attempt)+" attempt");
        }
    }
    static void Transaction(float balance,boolean x){
        do {
            Scanner sc=new Scanner(System.in);
            System.out.println("1.Deposit");
            System.out.println("2.Withdrawal");
            System.out.println("3.check");

            System.out.println("Choose one option");
            int option;
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("enter amount to be deposit : ");
                    float newmoney = sc.nextFloat();
                    balance += newmoney;
                    System.out.println("successfully deposited  " + newmoney + " rupees");
                    System.out.println("available balance = " + balance);
                    x = Menu();
                    break;
                case 2:
                    System.out.println("enter amount to Withdrawal");
                    float WithDrawalamount = sc.nextFloat();
                    if (balance>0 && balance >= WithDrawalamount) {
                        balance -= WithDrawalamount;
                        System.out.println(WithDrawalamount + " Successfully withdrawal ");
                        System.out.println("Available balance is = " + balance);
                        x = Menu();
                    } else {
                        System.out.println("Insufficient balance");
                        x = Menu();
                        break;
                    }
                case 3:
                    System.out.println("available balance is = " + balance);
                    x = Menu();
                    break;
                default:
                    System.out.println("Enter valid option");
                    x = Menu();
                    break;
            }

        }
        while(x);
    }
    static boolean Menu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("---- do you want to access menu (Y/N)--------");
        char ch= sc.next().charAt(0);
        if(ch=='Y'){
            return true;
        }
        else{
            return false;
        }
    }
}
