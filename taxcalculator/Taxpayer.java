package taxcalculator;

//Taxpayer.java

/**
 * An instantiable class which defines a Taxpayer. This class consists of Getters, Setters
 * and static methods which aid in providing further data about the Taxpayer objects created
 * from this class
 * @author Kieran Duffy
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Taxpayer implements Serializable{
    private String name;
    private int age;
    private char status;
    private double income;
    private double taxLiability;
    private double USC;
    private double taxCredits;
    private double PRSI;
    private double netTax;
    private double totalDeductions;

    /**
     * Taxpayer 10-argument constructor. Calls the 10 mutators to initialise the attributes
     * of a Taxpayer object with values that are set by the user.
     * @param name the name of the Taxpayer
     * @param age the age of the Taxpayer
     * @param status the marital status of the Taxpayer
     * @param income the income of the Taxpayer
     * @param taxLiability the amount of tax liability the Taxpayers pays
     * @param USC the amount of USC the Taxpayers pays
     * @param taxCredits the amount of tax Credits the Taxpayers pays
     * @param PRSI the amount of PRSI the Taxpayers pays
     * @param netTax the total net tax the Taxpayers pays
     * @param totalDeductions the total deductions from the Taxpayers income
     */

    public Taxpayer(String name, int age, char status, double income, double taxLiability, double USC, double taxCredits,
                    double PRSI, double netTax, double totalDeductions) {
        setName(name);
        setAge(age);
        setStatus(status);
        setIncome(income);
        setTaxLiability(taxLiability);
        setUSC(USC);
        setTaxCredits(taxCredits);
        setPRSI(PRSI);
        setNetTax(netTax);
        setTotalDeductions(totalDeductions);
    }

    /**
     * Method to get the name of a Taxpayer object
     * @return a String value specifying the title of a Taxpayer object
     */

    public String getName() {
        return name;
    }

    /**
     * Method to set the name of a Taxpayer object
     * @param name the name of the Taxpayer
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get the age of a Taxpayer object
     * @return an integer value specifying the age of a Taxpayer object
     */

    public int getAge() {
        return age;
    }

    /**
     * Method to set the age of a Taxpayer object
     * @param age the age of the Taxpayer
     */

    public void setAge(int age) {
        this.age = age;}

    /**
     * Method to get the status of a Taxpayer object
     * @return a character value specifying the status of a Taxpayer object
     */

    public char getStatus() {
        return status;
    }

    /**
     * Method to set the status of a Taxpayer object
     * @param status the status of the Taxpayer
     */

    public void setStatus(char status) {
        this.status = status;
    }

    /**
     * Method to get the total income of a Taxpayer object
     * @return a double value specifying the total income of a Taxpayer object
     */

    public double getIncome() {
        return income;
    }

    /**
     * Method to set the total income of a Taxpayer object
     * @param income the total income of the Taxpayer
     */

    public void setIncome(double income) {
        this.income = income;
    }

    /**
     * Method to get the tax liability of a Taxpayer object
     * @return a double value specifying the tax liability of a Taxpayer object
     */

    public double getTaxLiability() {
        return taxLiability;
    }

    /**
     * Method to set the tax liability of a Taxpayer object
     * @param taxLiability the tax liability of the Taxpayer
     */

    public void setTaxLiability(double taxLiability) {
        this.taxLiability = taxLiability;
    }

    /**
     * Method to get the USC of a Taxpayer object
     * @return a double value specifying the USC of a Taxpayer object
     */

    public double getUSC() {
        return USC;
    }

    /**
     * Method to set the USC of a Taxpayer object
     * @param USC the USC of the Taxpayer
     */

    public void setUSC(double USC) {
        this.USC = USC;
    }

    /**
     * Method to get the USC of a Taxpayer object
     * @return a double value specifying the USC of a Taxpayer object
     */

    public double getTaxCredits() {
        return taxCredits;
    }

    /**
     * Method to set the Tax Credits of a Taxpayer object
     * @param taxCredits the Tax Credits of the Taxpayer
     */

    public void setTaxCredits(double taxCredits) {
        this.taxCredits = taxCredits;
    }

    /**
     * Method to get the PRSI of a Taxpayer object
     * @return a double value specifying the PRSI of a Taxpayer object
     */

    public double getPRSI() {
        return PRSI;
    }

    /**
     * Method to set the PRSI of a Taxpayer object
     * @param PRSI the PRSI of the Taxpayer
     */

    public void setPRSI(double PRSI) {
        this.PRSI = PRSI;
    }

    /**
     * Method to get the Total Deductions of a Taxpayer object
     * @return a double value specifying the Total Deductions of a Taxpayer object
     */

    public double getTotalDeductions() {
        return totalDeductions;
    }

    /**
     * Method to set the Total Deductions of a Taxpayer object
     * @param totalDeductions the Total Deductions of the Taxpayer
     */

    public void setTotalDeductions(double totalDeductions) {
        if(totalDeductions < 0)
            this.totalDeductions = 0;
        else
            this.totalDeductions = totalDeductions;
    }

    /**
     * Method to get the Net Tax of a Taxpayer object
     * @return a double value specifying the Net Tax of a Taxpayer object
     */

    public double getNetTax() {
        return netTax;
    }

    /**
     * Method to set the Net Tax of a Taxpayer object
     * @param netTax the Net Tax of the Taxpayer
     */

    public void setNetTax(double netTax) {
        this.netTax = netTax;
    }

    /**
     * Method to get the Average income of an array list of Taxpayer objects
     * @return a double value specifying the Average Income of the Taxpayer Array List
     */

    public static double getAverageIncome(ArrayList<Taxpayer> allTaxpayers) {
        double totalIncome = 0;


        if (allTaxpayers == null) {
            return 0;
        }
        else {
            for (Taxpayer t : allTaxpayers) {
                totalIncome += t.getIncome();
            }

            return totalIncome / allTaxpayers.size();

        }

    }

    /**
     * Method to get the Average age of an array list of Taxpayer objects
     * @return a double value specifying the Average age of the Taxpayer Array List
     */

    public static double getAverageAge(ArrayList<Taxpayer> allTaxpayers){
        double totalAge = 0;


        if (allTaxpayers == null) {
            return 0;
        }
        else {
            for (Taxpayer t : allTaxpayers) {
                totalAge += t.getAge();

            }

            return totalAge / allTaxpayers.size();

        }

    }

    /**
     * Method to get the Average Tax Liability of an array list of Taxpayer objects
     * @return a double value specifying the Tax Liability of the Taxpayer Array List
     */

    public static double getAverageTaxLiability(ArrayList<Taxpayer> allTaxpayers) {
        double totalTaxLiability = 0;


        if (allTaxpayers == null) {
            return 0;
        } else {
            for (Taxpayer t : allTaxpayers) {
                totalTaxLiability += t.getTaxLiability();
            }

            return totalTaxLiability / allTaxpayers.size();

        }
    }

    /**
     * Method to get the Total USC paid by an array list of Taxpayer objects
     * @return a double value specifying the Total USC of the Taxpayer Array List
     */

    public static double getTotalUSC(ArrayList<Taxpayer> allTaxpayers) {
        double totalUSC = 0;


        if (allTaxpayers == null) {
            return 0;
        } else {
            for (Taxpayer t : allTaxpayers) {
                totalUSC += t.getIncome();

            }

            return totalUSC;

        }
    }

    /**
     * Method to delete the entries of an array list of Taxpayer objects
     * @param allTaxpayers the Array list to be deleted
     */

    public static void deleteEntries(ArrayList<Taxpayer> allTaxpayers){
        Iterator<Taxpayer> iterator = allTaxpayers.iterator();

        while (iterator.hasNext()) {
            Taxpayer t = iterator.next();

            if (t != null)
                iterator.remove();
        }

    }

    /**
     * Method to get the state of a Taxpayer Object
     * @return a String value specifying the state of a Taxpayer object
     */

    @Override
    public String toString() {
        return
                "General Information:"+ "\n------------------------------------------------"+
                "\n  Name: " +getName()+
                "\n  Age: " +getAge()+
                "\n  Status: " +getStatus()+
                "\n\nTax Details:" + "\n------------------------------------------------"+
                "\n  Income: \u20ac" +String.format("%.2f",getIncome())+
                "\n  Tax Liability: \u20ac" +String.format("%.2f",getTaxLiability())+
                "\n  Tax Credits: \u20ac" +String.format("%.2f",getTaxCredits())+
                "\n  Net Tax: \u20ac" +String.format("%.2f",getNetTax())+
                "\n  PRSI: \u20ac" +String.format("%.2f",getPRSI())+
                "\n  USC: \u20ac" +String.format("%.2f",getUSC())+
                "\n\nResults:" + "\n------------------------------------------------"+
                "\n  Total Deductions: \u20ac" +String.format("%.2f",getTotalDeductions())+
                "\n  Annual Disposable Income: \u20ac" +String.format("%.2f", getIncome()-getTotalDeductions())+"\t\t\t"+
                "\n  Monthly Disposable Income: \u20ac" +String.format("%.2f", (getIncome()-getTotalDeductions())/12)+
                "\n  Weekly Disposable Income: \u20ac" +String.format("%.2f", (getIncome()-getTotalDeductions())/52);

    }
}
