package anonymous_class;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
class Account2
{
   private int id, balance;
   Account2(int id, int balance)
   {
      this.balance = balance;
      this.id = id;
   }
   void deposit(int amount)
   {
      balance += amount;
   }
   int getBalance()
   {
      return balance;
   }
   int getID()
   {
      return id;
   }
   void print()
   {
      System.out.printf("Account2: [%d], Balance: [%d]%n", id, balance);
   }
}
public class LambdaDemo2
{
   static List<Account2> accounts;
   public static void main(String[] args)
   {
      accounts = new ArrayList<>();
      accounts.add(new Account2(1000, 200));
      accounts.add(new Account2(2000, -500));
      accounts.add(new Account2(3000, 0));
      accounts.add(new Account2(4000, -80));
      accounts.add(new Account2(5000, 1000));
      // Deposit enough money in accounts with negative balances so that they
      // end up with zero balances (and are no longer overdrawn).
      adjustAccounts(Account2 -> Account2.getBalance() < 0,
                     Account2 -> Account2.deposit(-Account2.getBalance()));
   }
   static void adjustAccounts(Predicate<Account2> tester,
                              Consumer<Account2> adjuster)
   {
      for (Account2 Account2: accounts)
      {
         if (tester.test(Account2))
         {
            adjuster.accept(Account2);
            Account2.print();
         }
      }
   }
}