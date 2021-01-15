package bankSystem;

public class AccountInfo {
    
    private String firstName;
    private String lastName;
    private String accountNumber;
    private double balance;
    
    
    
    public AccountInfo() {
     }
    
    
    
    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getfirstName() {
        return firstName;
    }
    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    @Override
    public String toString() {
        return "AccountInfo [firstName=" + firstName + ", lastName=" + lastName + ", accountNumber=" + accountNumber
                + ", balance=" + balance + "]";
    }
    
    

}
