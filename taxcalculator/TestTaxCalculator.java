package taxcalculator;

import java.util.Scanner;

public class TestTaxCalculator {
    public static void main(String[] args) {


        String name;
        int age;
        char category, status, dependant, children, blind;
        double grossIncome1,grossIncome2, pension;

        Scanner input = new Scanner(System.in);

        /*System.out.print("Please enter your name:");
        name = input.nextLine();
        System.out.print("Please enter your status:");
        name = input.nextLine();
        System.out.print("Please enter your PRSI Category(F=Full-Rate, R=Reduced-Rate):");
        category = input.next().charAt(0);
        System.out.print("Please enter your Pension Contributions(If none, enter 0):");
        pension = input.nextDouble();*/
        System.out.print("Please enter your Gross Income: ");
        grossIncome1 = input.nextDouble();
        System.out.print("Please enter your status(S=Single, M=Married): ");
        status = input.next().toUpperCase().charAt(0);
        System.out.print("If Married please enter your spouses income: ");
        grossIncome2 = input.nextDouble();
        System.out.print("Please enter your age:");
        age = input.nextInt();
        System.out.print("Do You have dependant children(Y=Yes, N=No): ");
        children = input.next().toUpperCase().charAt(0);
        System.out.print("Are you entitled to Blind person tax credit(Y=Yes, N=No): ");
        blind = input.next().toUpperCase().charAt(0);
        System.out.print("Are you entitled to Dependant Relative tax credit(Y=Yes, N=No): ");
        dependant = input.next().toUpperCase().charAt(0);


        System.out.print("\n\nTax Paid: " + String.format("%.2f",taxLiability(grossIncome1, status, grossIncome2)));
        System.out.print("\n\nTax Credits: " + String.format("%.2f",taxCredits(age, status, children, blind, dependant,
                                                            grossIncome1, grossIncome2)));












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

    public static double taxCredits(int age, char status, char children, char blind, char dependant, double income1, double income2){
        final double ageSingleCredit=245;
        final double ageMarriedCredit=490;
        final double singleCredit=1650;
        final double payeCredit=1650;
        final double marriedCredit=3300;
        final double singlePersonChildCarer=1650;
        final double homeCarer=1600;
        final double dependantCredit=70;
        final double blindCredit=1650;
        double totalTaxCredits = 0;

        if(age >= 65){
            if(status=='S'){
                totalTaxCredits=ageSingleCredit+payeCredit+singleCredit;
                if(children=='Y')
                    totalTaxCredits+=singlePersonChildCarer;
                if(blind=='Y')
                    totalTaxCredits+=blindCredit;
                if(dependant=='Y')
                    totalTaxCredits+=dependantCredit;
            }
            else{
                if(income2>0){
                    totalTaxCredits=marriedCredit+marriedCredit+ageMarriedCredit;
                    if(blind=='Y')
                        totalTaxCredits+=blindCredit;
                    if(dependant=='Y')
                        totalTaxCredits+=dependantCredit;

                }
                else{
                    totalTaxCredits=marriedCredit+payeCredit+ageMarriedCredit;
                    if(children=='Y')
                        totalTaxCredits+=homeCarer;
                    if(blind=='Y')
                        totalTaxCredits+=blindCredit;
                    if(dependant=='Y')
                        totalTaxCredits+=dependantCredit;
                }
            }

        }
        else{
            if(status=='S'){
                totalTaxCredits=payeCredit+singleCredit;
                if(children=='Y')
                    totalTaxCredits+=singlePersonChildCarer;
                if(blind=='Y')
                    totalTaxCredits+=blindCredit;
                if(dependant=='Y')
                    totalTaxCredits+=dependantCredit;
            }
            else{
                if(income2>0){
                    totalTaxCredits=marriedCredit+marriedCredit;
                    if(blind=='Y')
                        totalTaxCredits+=blindCredit;
                    if(dependant=='Y')
                        totalTaxCredits+=dependantCredit;

                }
                else{
                    totalTaxCredits=marriedCredit+payeCredit;
                    if(children=='Y')
                        totalTaxCredits+=homeCarer;
                    if(blind=='Y')
                        totalTaxCredits+=blindCredit;
                    if(dependant=='Y')
                        totalTaxCredits+=dependantCredit;
                }
            }


        }
        return totalTaxCredits;
    }

}
