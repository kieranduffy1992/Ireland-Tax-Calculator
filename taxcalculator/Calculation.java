package taxcalculator;

public class Calculation {

    public static double CalculateTaxLiability(double income1, char status, double income2){//needs to be redone
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

    public static double CalculateTaxCredits(int age, char status, char children, char blind, char dependant, double income1, double income2){
        final double ageSingleCredit=245;
        final double ageMarriedCredit=490;
        final double singleCredit=1650;
        final double payeCredit=1650;
        final double marriedCredit=3300;
        final double singlePersonChildCarer=1650;
        final double homeCarer=1600;
        final double dependantCredit=70;
        final double blindCredit=1650;
        double totalTaxCredits;

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

    public static double CalculatePRSI(double income1, double income2, int age, char status, char category){

        double totalPRSI, sixthOfEarnings,PRSI4PerCent, spouse1PRSI, spouse2PRSI;
        double weeklyIncome1=income1/52;
        double weeklyIncome2=income2/52;
        final double maxPRSICredit=12, fullRate=.04, reducedRate=0.009;



        if(age >= 66 || (weeklyIncome1 <= 352 && weeklyIncome2 <= 352)){
            totalPRSI=0;

        }
        else if(income2 > 0){
            if(category=='F'){
                if(weeklyIncome1<=352){
                    spouse1PRSI=0;
                }
                else if(weeklyIncome1 > 424){
                    spouse1PRSI=(weeklyIncome1*fullRate)*52;
                }
                else{
                    sixthOfEarnings=(weeklyIncome1-352.01)/6;
                    PRSI4PerCent=weeklyIncome1*fullRate;
                    spouse1PRSI = (PRSI4PerCent-(maxPRSICredit-sixthOfEarnings))*52;
                }
                if(weeklyIncome2<=352){
                    spouse2PRSI=0;
                }
                else if(weeklyIncome2 > 424){
                    spouse2PRSI=(weeklyIncome2*fullRate)*52;
                }
                else{
                    sixthOfEarnings=(weeklyIncome2-352.01)/6;
                    PRSI4PerCent=weeklyIncome2*fullRate;
                    spouse2PRSI = (PRSI4PerCent-(maxPRSICredit-sixthOfEarnings))*52;
                }
                totalPRSI=spouse1PRSI+spouse2PRSI;

            }
            else{
                if(weeklyIncome1<=352){
                    spouse1PRSI=0;
                }
                else if(weeklyIncome1 > 500){
                    if(weeklyIncome1<=1443)
                        spouse1PRSI=(weeklyIncome1*reducedRate)*52;
                    else
                        spouse1PRSI=((1443*reducedRate)+((weeklyIncome1-1443)*fullRate))*52;
                }
                else{
                    spouse1PRSI = (weeklyIncome1*reducedRate)*52;
                }
                if(weeklyIncome2<=352){
                    spouse2PRSI=0;
                }
                else if(weeklyIncome2 > 500){
                    if(weeklyIncome2<=1443)
                        spouse2PRSI=(weeklyIncome2*reducedRate)*52;
                    else
                        spouse2PRSI=((1443*reducedRate)+((weeklyIncome2-1443)*fullRate))*52;
                }
                else{
                    spouse2PRSI = (weeklyIncome2*reducedRate)*52;
                }

                totalPRSI=spouse1PRSI+spouse2PRSI;

            }

        }
        else{
            if(category=='F'){
                if(weeklyIncome1<=352){
                    totalPRSI=0;
                }
                else if(weeklyIncome1 > 424){
                    totalPRSI=(weeklyIncome1*fullRate)*52;
                }
                else{
                    sixthOfEarnings=(weeklyIncome1-352.01)/6;
                    PRSI4PerCent=weeklyIncome1*fullRate;
                    totalPRSI = (PRSI4PerCent-(maxPRSICredit-sixthOfEarnings))*52;
                }

            }
            else{
                if(weeklyIncome1<=352){
                    totalPRSI=0;
                }
                else if(weeklyIncome1 > 500){
                    if(weeklyIncome1<=1443)
                        totalPRSI=(weeklyIncome1*reducedRate)*52;
                    else
                        totalPRSI=((1443*reducedRate)+((weeklyIncome1-1443)*fullRate))*52;
                }
                else{
                    totalPRSI = (weeklyIncome1*reducedRate)*52;
                }


            }

        }
        if(totalPRSI<0)
            return 0;
        else
            return totalPRSI;
    }

    public static double CalculateUSC(double income1, double income2, char status, int age) {

        final double rate1 = 0.005, rate2 = 0.02, rate3 = 0.045, rate4 = 0.08;
        double totalUSC = 0, spouse1USC = 0, spouse2USC = 0;

        switch (status) {

            case 'S':
                if (age < 70 || (age >= 70 && income1 >= 60000)) {
                    if (income1 <= 13000)
                        totalUSC = 0;
                    else if (income1 > 70044)
                        totalUSC = (12012 * rate1) + (8472 * rate2) + (49560 * rate3) + ((income1 - 70044) * rate4);
                    else if (income1 <= 70044 && income1 >= 20484)
                        totalUSC = (12012 * rate1) + (8472 * rate2) + ((income1 - 20484) * rate3);
                    else if (income1 <= 20484 && income1 > 13000)
                        totalUSC = (12012 * rate1) + ((income1 - 12012) * rate2);
                } else {
                    if (income1 <= 13000)
                        totalUSC = 0;
                    else
                        totalUSC = (12012 * rate1) + ((income1 - 12012) * rate2);
                }

            case 'M':
                if (age < 70 || (age >= 70 && (income1 >= 60000 || income2 >= 60000))) { //problem with 2nd income and over 70
                    if (income1 <= 13000)
                        spouse1USC = 0;
                    else if (income1 > 70044)
                        spouse1USC = (12012 * rate1) + (8472 * rate2) + (49560 * rate3) + ((income1 - 70044) * rate4);
                    else if (income1 <= 70044 && income1 >= 20484)
                        spouse1USC = (12012 * rate1) + (8472 * rate2) + ((income1 - 20484) * rate3);
                    else if (income1 <= 20484 && income1 > 13000)
                        spouse1USC = (12012 * rate1) + ((income1 - 12012) * rate2);

                    if (income2 <= 13000)
                        spouse2USC = 0;
                    else if (income2 > 70044)
                        spouse2USC = (12012 * rate1) + (8472 * rate2) + (49560 * rate3) + ((income2 - 70044) * rate4);
                    else if (income2 <= 70044 && income2 >= 20484)
                        spouse2USC = (12012 * rate1) + (8472 * rate2) + ((income2 - 20484) * rate3);
                    else if (income2 <= 20484 && income2 > 13000)
                        spouse2USC = (12012 * rate1) + ((income2 - 12012) * rate2);

                    totalUSC = spouse1USC + spouse2USC;

                }
                else{
                    if(income1 <= 13000)
                        spouse1USC = 0;
                    else
                        spouse1USC = (12012 * rate1) + ((income1 - 12012) * rate2);

                    if(income2 <= 13000)
                        spouse2USC = 0;
                    else
                        spouse2USC = (12012 * rate1) + ((income2 - 12012) * rate2);

                    totalUSC = spouse1USC+spouse2USC;

                }
        }
        return totalUSC;
    }
}
