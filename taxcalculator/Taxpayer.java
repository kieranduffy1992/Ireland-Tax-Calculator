package taxcalculator;

import java.io.Serializable;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getTaxLiability() {
        return taxLiability;
    }

    public void setTaxLiability(double taxLiability) {
        this.taxLiability = taxLiability;
    }

    public double getUSC() {
        return USC;
    }

    public void setUSC(double USC) {
        this.USC = USC;
    }

    public double getTaxCredits() {
        return taxCredits;
    }

    public void setTaxCredits(double taxCredits) {
        this.taxCredits = taxCredits;
    }

    public double getPRSI() {
        return PRSI;
    }

    public void setPRSI(double PRSI) {
        this.PRSI = PRSI;
    }

    public double getTotalDeductions() {
        return totalDeductions;
    }

    public void setTotalDeductions(double totalDeductions) {
        if(totalDeductions < 0)
            this.totalDeductions = 0;
        else
            this.totalDeductions = totalDeductions;
    }

    public double getNetTax() {
        return netTax;
    }

    public void setNetTax(double netTax) {
        this.netTax = netTax;
    }


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
