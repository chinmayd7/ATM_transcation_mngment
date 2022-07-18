import java.io.*;
import java.text.*;
import java.util.*;

class Account
{

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'Rs'###,##0.00");
    private int CN;
    private int PN;
    private double currentBalance = 2000;
    private double savingBalance = 2000;
    
    
    public int setCustomerNumber(int CN)
    {
        this.CN = CN;
        return CN;
    }
    
    public int getCustomerNumber()
    {
        return CN;
    }
    
    public int setPinNumber(int PN)
    {
        this.PN = PN;
        return PN;
    }
    
    public int getPinNumber()
    {
        return PN;
    }
    
    public double getCurrentBalance()
    {
        return currentBalance;
    }
    
    public double getSavingBalance()
    {
        return savingBalance;
    }
    public double calcCurrentWithdraw(double amount)
    {
        currentBalance = (currentBalance - amount);
        return currentBalance;
    }
    
    public double calcSavingWithdraw(double amount)
    {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }
    
    public double calcCurrentDeposit(double amount)
    {
        currentBalance = (currentBalance + amount);
        return currentBalance;
    }
    
    public double calcSavingDeposit(double amount)
    {
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }
    
    public void getCurrentWithdrawInput()
    {

        System.out.println("Your Current Account Balance: " + moneyFormat.format(currentBalance));
        System.out.print("Amount you want to withdraw from your current Account: ");
        double amount = input.nextDouble();


        if ((currentBalance - amount) >= 0)
        {
            calcCurrentWithdraw(amount);
            System.out.println("Your New current Account Balance: " + moneyFormat.format(currentBalance));
        }
        else
        {
            System.out.println("Your Balance is insufficient for this Transaction" + "\n");
        }
    }
    
    public void getsavingWithdrawInput()
    {

        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to withdraw from saving Account: ");
        double amount = input.nextDouble();

        if ((savingBalance - amount) >= 0)
        {
            calcSavingWithdraw(amount);
            System.out.println("Your New Saving Account Balance: " + moneyFormat.format(savingBalance));
        }
        else
        {
            System.out.println("Your Balance is insufficient for this Transaction" + "\n");
        }
    }
    
    public void getCurrentDepositInput()
    {

        System.out.println("Checking Account Balance: " + moneyFormat.format(currentBalance));
        System.out.print("Amount you want to Deposit from your current Account: ");
        double amount = input.nextDouble();

        if ((currentBalance + amount) >= 0)    //-500  + 100 = -400
        {
            calcCurrentDeposit(amount);
            System.out.println("Your New Checking Account Balance: " + moneyFormat.format(currentBalance));
        }
        else
        {
            System.out.println("\n" + "Please Enter valid Amount" + "\n");
        }
    }
    
    public void getSavingDepositInput()
    {

        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to Deposit from saving Account: ");
        double amount = input.nextDouble();

        if ((savingBalance + amount) >= 0)
        {
            calcSavingDeposit(amount);
            System.out.println("Your New saving Account Balance: " + moneyFormat.format(savingBalance));
        }
        else
        {
            System.out.println("\n" + "Please Enter valid Amount" + "\n");
        }
    }
}


class OptionMenu extends Account
{
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'Rs'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException
    {
        int x = 1;

        do

        {
            try

            {
                data.put(11111,111);
                data.put(22222,111);
                data.put(33333,111);
                data.put(44444,111);
                data.put(55555,111);

                System.out.println("Welcome to the JSPM ATM......!");
                System.out.println("Enter your customer Number");

                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter your PIN Number: ");
                setPinNumber(menuInput.nextInt());

            }

            catch (Exception e)
            {
                System.out.println("Please Enter Only Numbers. Character & Sysmbols are not allowed.");
                x = 2;
            }


            int A = getCustomerNumber();
            int B = getPinNumber();


            if (data.containsKey(A)  && data.get(A) == B)
            {
                getAccountType();
            }
            else
            {
                System.out.println( "\n" + "Wrong Customer Number or Pin Number."  + "\n" + "Please try again with valid Account Number or PIN Number" + "\n");
            }

        }

        while (x == 1);

    }
    
    public void getAccountType()
    {

        System.out.println("Select the Account Type you Want to Access: ");
        System.out.println(" Type 1 - Current Account");
        System.out.println(" Type 2 - Saving Account");
        System.out.println(" Type 3 - Exit");

        int selection = menuInput.nextInt();

        switch (selection)
        {
            case 1  :  getCurrent();  break;
            case 2  :  getSaving();    break;
            case 3  :  System.out.println("Thank You for using this ATM, VISIT again." + "\n");   break;
            default :  System.out.println("Invalid Choice. please enter the valid choice");   getAccountType();
        }

    }
    
    public void getCurrent()
    {
        System.out.println("Current Account: ");
        System.out.println(" Type 1 - View Balance");
        System.out.println(" Type 2 - Withdraw Funds");
        System.out.println(" Type 3 - Deposit Funds");
        System.out.println(" Type 4 - Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection)
        {

            case 1:     System.out.println("Your Current Account Balance: "  + moneyFormat.format(getCurrentBalance()) + "\n");
                getAccountType();
                break;

            case 2:     getCurrentWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCurrentDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank You for using this ATM, Visit Again");
                break;

            default:

                System.out.println("\n" + "Invalid Choice." + "\n");
                getCurrent();

        }
    }
    
    
    public void getSaving()
    {
        System.out.println("Saving Account: ");
        System.out.println(" Type 1 - View Balance");
        System.out.println(" Type 2 - Withdraw Funds");
        System.out.println(" Type 3 - Deposit Funds");
        System.out.println(" Type 4 - Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection)
        {

            case 1:
                System.out.println("Your Saving Account Balance: "  + moneyFormat.format(getSavingBalance()) + "\n");
                getAccountType();
                break;

            case 2:
                getsavingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getSavingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank You for using this ATM, VISIT again." + "\n");
                break;

            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getSaving();
        }
    }
}



public class ATM extends OptionMenu
{
    public static void main(String[] args) throws IOException
    {
        OptionMenu optionMenu = new OptionMenu();
        optionMenu.getLogin();
    }
}