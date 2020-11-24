package taxcalculator;

public class Taxpayer {
    private String name;
    private int age;
    private char status;
    private double income;
    private double taxLiability;
    private double USC;
    private double taxCredits;
    private double PRSI;

    public Taxpayer(String name, int age, char status, double income, double taxLiability, double USC, double taxCredits, double PRSI) {
        setName(name);
        setAge(age);
        setStatus(status);
        setIncome(income);
        setTaxLiability(taxLiability);
        setUSC(USC);
        setTaxCredits(taxCredits);
        setPRSI(PRSI);
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

    @Override
    public String toString() {
        return  "Name: " +getName()+
                "\nAge: " +getAge()+
                "\nStatus: " +getStatus()+
                "\nIncome: " +String.format("%.2f",getIncome())+
                "\nTax Liability: " +String.format("%.2f",getTaxLiability())+
                "\nUSC:" +String.format("%.2f",getUSC())+
                "\nTax Credits: " +String.format("%.2f",getTaxCredits())+
                "\nPRSI: " +String.format("%.2f",getPRSI());
    }
}
