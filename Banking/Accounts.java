public class Accounts {

    private String name;
    String address, gender;
    int pin;
    double balance;

    Accounts(String name, String address, String gender, int pin, double balance){
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.pin = pin;
        this.balance = balance;


    }
    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }






    //deposit method
    public void deposit (double bal){
        if(bal > 1000){
            System.out.println("Can't deposit beyond 1000");
            return;
        }else if(bal < 0){
            System.out.println("Can't deposit lesser than 0 ");
            return;
        }
        balance += bal;
    }
   
    //withdraw method
    public void withdraw (double bal){
        
        if(bal > balance){
            System.out.println("Insufficient balance");
            return;  
        }else if(bal < 0){
            System.out.println("Can't withdraw lesser than 0 ");
            return;
        }
        
        balance -= bal;
    }

}
