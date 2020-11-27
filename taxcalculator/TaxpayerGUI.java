package taxcalculator;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class TaxpayerGUI extends JFrame{
    private JTextField nameField;
    private JTextField ageField;
    private JTextField incomeField;
    private JTextField spouseIncomeField;
    private Insets normalInsets = new Insets(10, 10, 0, 10);
    private Insets topInsets = new Insets(30, 10, 0, 10);
    private Insets bottomInsets = new Insets(60, 10, 0, 50);
    private JRadioButton single = new JRadioButton("Single", true), married = new JRadioButton("Married"),
            full = new JRadioButton("Full Rate", true), reduced = new JRadioButton("Reduced Rate"),
            childrenYes = new JRadioButton("Yes"), childrenNo = new JRadioButton("No", true), blindYes = new JRadioButton("Yes"),
            blindNo = new JRadioButton("No", true), dependantYes = new JRadioButton("Yes"), dependantNo = new JRadioButton("No", true);

    public TaxpayerGUI(){

        super("Ireland Tax Calculator");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        panel.add(Box.createVerticalStrut(40));
        panel.add(titlePanel());
        panel.add(detailsPanel());
        panel.add(Box.createVerticalStrut(40));
        //panel.add(submitButtonPanel());
        panel.add(Box.createVerticalStrut(20));

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,650);
        setVisible(true);
        setResizable(false);



    }

    public static void main(String args[]){
        new TaxpayerGUI();
    }

    private JPanel titlePanel(){

        JPanel panel = new JPanel();

        JLabel titleLabel = new JLabel("Taxpayer Details");
        titleLabel.setFont(new Font("serif",Font.PLAIN,20));

        panel.add(titleLabel);

        return panel;
    }

    private JPanel detailsPanel(){

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        int gridy = 0;

        JLabel nameLabel = new JLabel("Name:");
        addComponent(panel, nameLabel, 0, gridy, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        nameField = new JTextField(25);
        addComponent(panel, nameField, 1, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel ageLabel = new JLabel("Age:");
        addComponent(panel, ageLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        ageField = new JTextField(25);
        addComponent(panel, ageField, 1, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);


        JLabel incomeLabel = new JLabel("Gross Income:");
        addComponent(panel, incomeLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        incomeField = new JTextField(25);
        addComponent(panel, incomeField, 1, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel spouseIncomeLabel = new JLabel("Spouse Income (If Applicable):");
        addComponent(panel, spouseIncomeLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        spouseIncomeField = new JTextField(25);
        spouseIncomeField.setText("0");
        addComponent(panel, spouseIncomeField, 1, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel statusLabel = new JLabel("Select your Marital Status:");
        addComponent(panel,statusLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        Box statusBox = Box.createHorizontalBox();
        ButtonGroup statusGroup = new ButtonGroup();

        statusGroup.add(single);
        statusGroup.add(married);
        statusBox.add(single);
        statusBox.add(married);

        statusBox.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.ORANGE,Color.ORANGE));

        addComponent(panel, statusBox, 1, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel prsiLabel = new JLabel("Select your PRSI Category:");
        addComponent(panel,prsiLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        Box prsiBox = Box.createHorizontalBox();
        ButtonGroup prsiGroup = new ButtonGroup();

        prsiGroup.add(full);
        prsiGroup.add(reduced);
        prsiBox.add(full);
        prsiBox.add(reduced);

        prsiBox.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.ORANGE,Color.ORANGE));

        addComponent(panel, prsiBox, 1, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel childrenLabel = new JLabel("Do You have dependant children:");
        addComponent(panel,childrenLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        Box childrenBox = Box.createHorizontalBox();
        ButtonGroup childrenGroup = new ButtonGroup();

        childrenGroup.add(childrenYes);
        childrenGroup.add(childrenNo);
        childrenBox.add(childrenYes);
        childrenBox.add(childrenNo);

        childrenBox.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.ORANGE,Color.ORANGE));

        addComponent(panel, childrenBox, 1, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel blindLabel = new JLabel("Are you entitled to Blind Person Tax Credit:");
        addComponent(panel,blindLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        Box blindBox = Box.createHorizontalBox();
        ButtonGroup blindGroup = new ButtonGroup();

        blindGroup.add(blindYes);
        blindGroup.add(blindNo);
        blindBox.add(blindYes);
        blindBox.add(blindNo);

        blindBox.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.ORANGE,Color.ORANGE));

        addComponent(panel, blindBox, 1, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel dependantLabel = new JLabel("Are you entitled to Dependant Relative Tax Credit:");
        addComponent(panel,dependantLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        Box dependantBox = Box.createHorizontalBox();
        ButtonGroup dependantGroup = new ButtonGroup();

        dependantGroup.add(dependantYes);
        dependantGroup.add(dependantNo);
        dependantBox.add(dependantYes);
        dependantBox.add(dependantNo);

        dependantBox.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.ORANGE,Color.ORANGE));

        addComponent(panel, dependantBox, 1, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JButton submitButton = new JButton("Calculate Tax");
        submitButton.setBackground(Color.ORANGE);
        submitButton.setForeground(Color.WHITE);

        addComponent(panel, submitButton, 1, gridy++, 1, 1, bottomInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        submitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(nameField.getText().equals("") || ageField.getText().equals("") || incomeField.getText().equals("") ||
                        spouseIncomeField.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Error !! All fields must be entered, Please try again",
                            "Details Error",JOptionPane.ERROR_MESSAGE);
                }

                try{
                    float income1 = Float.parseFloat(incomeField.getText());
                    float spouseIncome = Float.parseFloat(spouseIncomeField.getText());
                    int age = Integer.parseInt(ageField.getText()), i=0;
                    String name;
                    for(i=0; i<nameField.getText().length();i++){
                        if(Character.isDigit(nameField.getText().charAt(i)))
                            break;

                    }
                    if(i==nameField.getText().length())
                         name = nameField.getText();

                }
                catch (Exception e1){
                    JOptionPane.showMessageDialog(null, "Error !! The rules of the Tax Calculator are as follows "+
                            "\n\n-Name Field must be made up of characters(A-Z) only\n-Income fields must be a numeric value\n-All fields must "+
                            "be entered",
                            "Details Error",JOptionPane.ERROR_MESSAGE);

                }
            }

        });


        return panel;

    }

    private void addComponent(Container container, Component component,
                              int gridx, int gridy, int gridwidth, int gridheight, Insets insets,
                              int anchor, int fill) {

        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 0.0, 0.0, anchor, fill, insets, 5, 5);

        container.add(component, gbc);
    }


}
