package taxcalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaxpayerGUI extends JFrame{
    private JTextField nameField;
    private JTextField ageField;
    JRadioButton single = new JRadioButton("Single"), married = new JRadioButton("Married"),
            full = new JRadioButton("Full Rate"), reduced = new JRadioButton("Reduced Rate");
    ;
    private JRadioButton singlerb;
    private JRadioButton Marriedrb;
    //statusfield
    private JTextField incomeField;
    private JTextField spouseIncomeField;
    //prsi category field
    //dependant children
    //blind
    //dependantrelative
    private Insets normalInsets = new Insets(10, 10, 0, 10);
    private Insets topInsets = new Insets(30, 10, 0, 10);

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
        addComponent(panel, spouseIncomeField, 1, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        Box statusBox = Box.createHorizontalBox();
        ButtonGroup statusGroup = new ButtonGroup();

        statusGroup.add(single);
        statusGroup.add(married);
        statusBox.add(single);
        statusBox.add(married);

        statusBox.setBorder(BorderFactory.createTitledBorder("Status"));

        addComponent(panel, statusBox, 1, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        Box prsiBox = Box.createHorizontalBox();
        ButtonGroup prsiGroup = new ButtonGroup();

        prsiGroup.add(full);
        prsiGroup.add(reduced);
        prsiBox.add(full);
        prsiBox.add(reduced);

        prsiBox.setBorder(BorderFactory.createTitledBorder("Select Your PRSI Category"));

        addComponent(panel, prsiBox, 1, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);



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
