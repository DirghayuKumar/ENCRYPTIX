import java.util.*;

class UserAccount {

  public double balance;

  UserAccount(double balance) {
    this.balance = balance;
  }

  // Function that displays the User's Account Balance
  public void displayAmt() {
    System.out.println(
      "Your current balance in the account is = Rs." + balance
    );
  }

  // Function that deposits the amount into user's account
  public void Deposit(double deposit_amt) {
    balance += deposit_amt;
    System.out.println("Ammount deposited Succesfully");
    displayAmt();
  }

  // Function that withdraws the amount into user's account
  public void Withdraw(double withdraw_amt) {
    if (withdraw_amt > balance) {
      System.out.println(
        "Withdraw Failed ! \nWithdraw Amount is greater than the current balance"
      );
    } else if (withdraw_amt < 0) { // If the amount is less than 0
      System.out.println(
        "Withdarw Failed ! \nWithdraw Amount cannot be negative"
      );
    } else {
      balance -= withdraw_amt;
      System.out.println("Withdraw of Rs. " + withdraw_amt + " Successful !!");
      displayAmt();
    }
  }
}

public class ATMInterface {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // Accepting User's current account balance
    System.out.println("Enter your Account Balance:");
    UserAccount ob = new UserAccount(sc.nextDouble());
    boolean user = true;

    // Displaying ATM Interface to the User
    while (user) {
      System.out.println("Press:");
      System.out.println("1 - Check Account Balance");
      System.out.println("2 - Deposit Ammount into Account");
      System.out.println("3 - Withdraw Amount from the Account");
      int ch = sc.nextInt();
      switch (ch) {
        case 1:
          ob.displayAmt();
          break;
        case 2:
          System.out.println("Enter the ammount to be Deposited:");
          double deposit_amt = sc.nextDouble();
          ob.Deposit(deposit_amt);
          break;
        case 3:
          System.out.println("Enter the ammount to be Withdrawn:");
          double withdraw_amt = sc.nextDouble();
          ob.Withdraw(withdraw_amt);
          break;
        default:
          System.out.println("Invalid Input");
          break;
      }
      // Asking the User if he/she wants to use ATM again?
      System.out.println("Do you want to exit? (yes/no)");
      sc.nextLine();
      String s = sc.nextLine();
      if (s.equalsIgnoreCase("yes")) {
        user = false;
      }
    }
    System.out.println("Thank you for using the ATM");
    sc.close();
  }
}
