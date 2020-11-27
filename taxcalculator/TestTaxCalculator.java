package taxcalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class TestTaxCalculator {
    public static void main(String[] args) {


        String name = "";
        int age;
        char category, status, dependant, children, blind, prsiCategory;
        double grossIncome1,grossIncome2, pension;

        Scanner input = new Scanner(System.in);


        System.out.print("Please enter your name:");
        name = input.nextLine();
        System.out.print("Please enter your age:");
        age = input.nextInt();
        System.out.print("Please enter your status(S=Single, M=Married): ");
        status = input.next().toUpperCase().charAt(0);
        System.out.print("Please enter your Gross Income: ");
        grossIncome1 = input.nextDouble();
        System.out.print("If Married please enter your spouses income: ");
        grossIncome2 = input.nextDouble();
        System.out.print("What is your PRSI Category(F=Full, R=Reduced): ");
        prsiCategory = input.next().toUpperCase().charAt(0);
        System.out.print("Do You have dependant children(Y=Yes, N=No): ");
        children = input.next().toUpperCase().charAt(0);
        System.out.print("Are you entitled to Blind person tax credit(Y=Yes, N=No): ");
        blind = input.next().toUpperCase().charAt(0);
        System.out.print("Are you entitled to Dependant Relative tax credit(Y=Yes, N=No): ");
        dependant = input.next().toUpperCase().charAt(0);



        double taxLiability = Calculation.CalculateTaxLiability(grossIncome1, status, grossIncome2);
        double taxCredits = Calculation.CalculateTaxCredits(age, status, children, blind, dependant,
                                                            grossIncome1, grossIncome2);
        double PRSI = Calculation.CalculatePRSI(grossIncome1, grossIncome2, age, status, prsiCategory);
        double USC = Calculation.CalculateUSC(grossIncome1, grossIncome2, status, age);
        double netTax = taxLiability-taxCredits;
        double totalDeductions = netTax+PRSI+USC;
        double totalincome = grossIncome1+grossIncome2;


        Taxpayer tp1 = new Taxpayer(name, age, status, totalincome, taxLiability, USC, taxCredits, PRSI, netTax, totalDeductions);

        System.out.println(tp1);

        /*JButton submitButton = new JButton("Calculate Tax");
        submitButton.setPreferredSize(new Dimension(20,15));
        addComponent(panel, submitButton, 2, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //DateChooser dateChooser = new DateChooser(EmployeeDetailsGUI.this);
                //dateChosen = dateChooser.getDateChosen();

                while(nameField.getText().equals("") || ageField.getText().equals("") || incomeField.getText().equals("") ||
                        spouseIncomeField.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Error !! All fields must be entered, Please try again",
                            "Details Error",JOptionPane.ERROR_MESSAGE);
                }


                if(dateChosen!=null) {
                    System.out.println(dateChosen.get(Calendar.DATE) + "-" +
                            dateChosen.get(Calendar.MONTH) + "-" +
                            dateChosen.get(Calendar.YEAR));

                    String dayString="", monthString="";

                    if(dateChosen.get(Calendar.DATE)<10)
                        dayString = "0" + dateChosen.get(Calendar.DATE);
                    else
                        dayString = "" + dateChosen.get(Calendar.DATE);

                    if(dateChosen.get(Calendar.MONTH)<10)
                        monthString = "0" + dateChosen.get(Calendar.MONTH);
                    else
                        monthString = "" + dateChosen.get(Calendar.MONTH);

                    dateOfBirthField.setText(dayString + "-" + monthString + "-" + dateChosen.get(Calendar.YEAR));
                }
            }
            })*/


    }

}
