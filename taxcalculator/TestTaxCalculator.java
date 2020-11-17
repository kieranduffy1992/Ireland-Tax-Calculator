package taxcalculator;

import java.util.Scanner;

public class TestTaxCalculator {
    public static void main(String[] args) {


        String name,status;
        int age;
        char category;
        double grossIncome, pension;

        Scanner input = new Scanner(System.in);

        /*System.out.print("Please enter your name:");
        name = input.nextLine();
        System.out.print("Please enter your status:");
        name = input.nextLine();
        System.out.print("Please enter your age:");
        age = input.nextInt();
        System.out.print("Please enter your PRSI Category(F=Full-Rate, R=Reduced-Rate):");
        category = input.next().charAt(0);
        System.out.print("Please enter your Pension Contributions(If none, enter 0):");
        pension = input.nextDouble();*/
        System.out.print("Please enter your Gross Income:");
        grossIncome = input.nextDouble();

        System.out.print("\n\nTax Paid: " + String.format("%.2f",taxLiability(grossIncome)));








    }

    public static double taxLiability(double income1, char status, double income2){
        final double cutOff = 35300;
        final double standardRate = 0.20;
        final double higherRate = 0.40;
        double taxPaid=0;
        final double married1Income = 44300;
        double married2Income;

        if(income2 < 26300 && income2 > 0){
            married2Income = married1Income+income2;
        }
        else
            married2Income = married1Income+26300;



        switch(status) {
            case 'S':
                     if (income1 <= cutOff) {
                         taxPaid = income1 * standardRate;
                     }
                     else if (income1 > cutOff) {
                         taxPaid = (cutOff * standardRate) + ((income1 - cutOff) * higherRate);
                     }
                     break;

            case 'M':
                     if(income2 == 0){
                         if(income1 <= married1Income){
                             taxPaid = income1 * standardRate;
                         }
                         else if(income1 > married1Income){
                             taxPaid = (married1Income * standardRate) + ((income1 - married1Income) * higherRate);
                         }
                     }
                     else
                         taxPaid = (married2Income*standardRate)+((income1+income2-married2Income)*higherRate);







        }

        return taxPaid;
    }

}
