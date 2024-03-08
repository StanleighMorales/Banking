
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Bank {
    static ArrayList<Accounts> accList = new ArrayList<>();
    static Scanner c = new Scanner(System.in);
    static Random ranNum = new Random();

    static int min = 100000;
    static int max = 999999;
    public static void main(String[] args) {

        menu();
        
    }

    static void menu(){
        
        
        boolean isDone = true;
        //
        do{
            try{
                System.out.println("=============================");
                System.out.println("Welcome to Stan's Bank");
                System.out.print(" 1. Create Account \n 2. Use Existing Account \n 3. Account List \n 4. Exit \n Choice: ");
                int userChoice = c.nextInt();
                c.nextLine();
                switch (userChoice) {
                    case 1:
                        CreateAccount();
                        break;
                    case 2:
                        UseExistingAccount(accList);
                        break;
                    case 3:   
                        AccountList();
                        break;
                    case 4:
                        System.exit(0);
                    default:

                        break;
                }


            }catch(InputMismatchException e){
                System.out.println("Invalid Input");
                c.nextLine();
            }
            
        }while(isDone);
    }

    static void CreateAccount(){
       
        System.out.print("Name: ");
        String Name = c.nextLine();
        
        System.out.print("Address: ");
        String Add = c.nextLine();
        System.out.print("Gender: ");
        String Gen = c.nextLine();
        
        
        //random number for Pin
        int Pin = ranNum.nextInt(max - min + 1 ) + min;
        double Balance = 0;
        // create a new Account object
        Accounts a1 = new Accounts(Name, Add, Gen, Pin, Balance);
        //adding user input to the object
        accList.add(a1);
        System.out.println("=============================");
        System.out.println("Account Created Successfully!");
        System.out.println("=============================");
        
        
        System.out.println(" Name: "+a1.getName() +"\n Address: "+ a1.address +"\n Gender: "+ a1.gender +"\n PIN: "+ a1.pin);
        System.out.println("=============================");
        
        
    }
    static void UseExistingAccount(ArrayList<Accounts> UEA){
        if( checkList()){
            return;
        }
        System.out.println("=============================");
        System.out.println("Log in");
        System.out.print("Enter PIN: ");

        int uPin = c.nextInt();
        for(Accounts al : UEA){
            if(uPin == al.pin){
                boolean isdone = true;
                do{
                    System.out.println("Welcome "+ al.getName() + "!");
                    System.out.print(" 1. Deposit \n 2. Withdraw \n 3. Back \n 4. Exit \n Choice:");
                    int choice = c.nextInt();
                    switch (choice) {
                        case 1:
    
                            depositMoney(al);

                            break;
                        case 2:

                            withdrawMoney(al);
                            break;
                        case 3:

                            break; 
                        case 4:
                            isdone = false;
                            break;
                        case 5:
                            System.exit(0);
                            break;
                        default:
                            break;
                    }
                }while(isdone);
            }
        }


    }
    

    static void AccountList(){
        
        if( checkList()){
            return;
        }
        int i = 0;
        for(Accounts a : accList){
            System.out.println("===================================");
            System.out.println("Account List No. ("+i+")");
            System.out.println("===================================");
            System.out.println(" Name: "+a.getName() +"\n Address: "+ a.address +"\n Gender: "+ a.gender +"\n PIN: "+ a.pin +
                                "\n Balance: "+ a.balance);
            System.out.println("=========================");
            i++;
        }
    }

    static void depositMoney(Accounts temp){
        System.out.print("Enter Amount: ");
        double newBal = c.nextDouble();
        temp.deposit(newBal);
        
        System.out.println("New Balance "+ temp.balance);



    }
    static void withdrawMoney(Accounts wTemp){
        System.out.print("Enter Amount: ");
        double newBal = c.nextDouble();
        wTemp.withdraw(newBal);

        System.out.println("Current Balance "+ wTemp.balance);
    }

    static void updateInfo(){
        System.out.println("Update name:");
    }

    static boolean checkList (){
        
        if(accList.isEmpty()){
            System.out.println("Account List is empty!");
            return true;
        }
        return false;
    }

    

}