package taxcalculator;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;


public class TaxpayerGUI extends JFrame implements ActionListener{
    /****************************
     * Title:Simplest way to set image as JPanel background
     * Author: Sage
     * Site Owner: stackoverflow.com
     * Date: 2013
     * Version: edited Oct 1st 2013
     * Availability: https://stackoverflow.com/questions/19125707/simplest-way-to-set-image-as-jpanel-background
     ****************************/
    Image background = Toolkit.getDefaultToolkit().createImage("taxcalculator\\Image1.jpg");
    ArrayList<Taxpayer> savedTaxpayers= new ArrayList<>();
    private final File file = new File("taxcalculator/taxpayers.data");
    private JTextField nameField;
    private JTextField ageField;
    private JTextField incomeField;
    private JTextField spouseIncomeField;
    JMenu fileMenu;
    JMenu statisticsMenu;
    JMenuItem item=null;
    private final Insets normalInsets = new Insets(10, 10, 0, 10);
    private final Insets topInsets = new Insets(30, 10, 0, 10);
    private final JRadioButton single = new JRadioButton("Single", true), married = new JRadioButton("Married"),
            full = new JRadioButton("Full Rate", true), reduced = new JRadioButton("Reduced Rate"),
            childrenYes = new JRadioButton("Yes"), childrenNo = new JRadioButton("No", true), blindYes = new JRadioButton("Yes"),
            blindNo = new JRadioButton("No", true), dependantYes = new JRadioButton("Yes"), dependantNo = new JRadioButton("No", true);

    public TaxpayerGUI(){

        super("Ireland Tax Calculator");

        createFileMenu();
        createStatisticsMenu();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(statisticsMenu);

        setSize(400,400 );

        JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                GradientPaint gradientPaint = new GradientPaint(220,180,Color.WHITE,80,180,Color.decode("#66B2FF"));
                Graphics2D g2 = (Graphics2D) g;
                g2.setPaint(gradientPaint);
                g2.fillRect(0,0,getWidth(), getHeight());
            }

        };

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.add(Box.createVerticalStrut(15));
        panel.add(titlePanel());
        panel.add(detailsPanel());
        panel.add(Box.createVerticalStrut(10));
        panel.add(createSubmitPanel());
        panel.add(Box.createVerticalStrut(10));

        add(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,650);
        setResizable(false);
        setVisible(true);

    }

    public static void main(String[] args){
        new TaxpayerGUI();
    }

    private void createFileMenu(){

        fileMenu = new JMenu("File");

        String[] itemNames = {"New","Save","Quit"};

        for(int i=0;i<itemNames.length;i++){
            item = new JMenuItem(itemNames[i]);
            item.addActionListener(this);

            fileMenu.add(item);
        }
    }


    private void createStatisticsMenu(){

        statisticsMenu = new JMenu("Statistics");

        String[] itemNames = {"User Stats","Clear History"};

        for(int i=0;i<itemNames.length;i++){
            item = new JMenuItem(itemNames[i]);
            item.addActionListener(this);

            statisticsMenu.add(item);
        }

    }


    private JPanel titlePanel(){

        JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                GradientPaint gradientPaint = new GradientPaint(220,180,Color.WHITE,80,180,Color.decode("#66B2FF"));
                Graphics2D g2 = (Graphics2D) g;
                g2.setPaint(gradientPaint);
                g2.fillRect(0,0,getWidth(), getHeight());
            }

        };

        panel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("Taxpayer Details");
        titleLabel.setFont(new Font("Courier",Font.BOLD,28));

        panel.add(titleLabel);

        return panel;
    }

    private JPanel detailsPanel(){

        /****************************
         * Title:Simplest way to set image as JPanel background
         * Author: Sage
         * Site Owner: stackoverflow.com
         * Date: 2013
         * Version: edited Oct 1st 2013
         * Availability: https://stackoverflow.com/questions/19125707/simplest-way-to-set-image-as-jpanel-background
         ****************************/

        JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(),this);
            }
        };


        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.WHITE,Color.WHITE));

        int gridy = 0;

        JLabel nameLabel = new JLabel("Name:");
        addComponent(panel, nameLabel, 0, gridy, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        nameField = new JTextField(25);
        addComponent(panel, nameField, 1, gridy++, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel ageLabel = new JLabel("Age:");
        addComponent(panel, ageLabel, 0, gridy, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        ageField = new JTextField(25);
        addComponent(panel, ageField, 1, gridy++, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel incomeLabel = new JLabel("Gross Income:");
        addComponent(panel, incomeLabel, 0, gridy, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        incomeField = new JTextField(25);
        addComponent(panel, incomeField, 1, gridy++, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel spouseIncomeLabel = new JLabel("Spouse Income (If Applicable):");
        addComponent(panel, spouseIncomeLabel, 0, gridy, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        spouseIncomeField = new JTextField(25);
        spouseIncomeField.setText("0");
        addComponent(panel, spouseIncomeField, 1, gridy++, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel statusLabel = new JLabel("Select your Marital Status:");
        addComponent(panel,statusLabel, 0, gridy, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        Box statusBox = Box.createHorizontalBox();
        ButtonGroup statusGroup = new ButtonGroup();
        single.setBackground(Color.WHITE);
        married.setBackground(Color.WHITE);

        statusGroup.add(single);
        statusGroup.add(married);
        statusBox.add(single);
        statusBox.add(married);

        statusBox.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.WHITE,Color.WHITE));

        addComponent(panel, statusBox, 1, gridy++, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel prsiLabel = new JLabel("Select your PRSI Category:");
        addComponent(panel,prsiLabel, 0, gridy, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        Box prsiBox = Box.createHorizontalBox();
        ButtonGroup prsiGroup = new ButtonGroup();
        full.setBackground(Color.WHITE);
        reduced.setBackground(Color.WHITE);

        prsiGroup.add(full);
        prsiGroup.add(reduced);
        prsiBox.add(full);
        prsiBox.add(reduced);

        prsiBox.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.WHITE,Color.WHITE));

        addComponent(panel, prsiBox, 1, gridy++, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel childrenLabel = new JLabel("Do You have dependant children:");
        addComponent(panel,childrenLabel, 0, gridy, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        Box childrenBox = Box.createHorizontalBox();
        ButtonGroup childrenGroup = new ButtonGroup();
        childrenYes.setBackground(Color.WHITE);
        childrenNo.setBackground(Color.WHITE);

        childrenGroup.add(childrenYes);
        childrenGroup.add(childrenNo);
        childrenBox.add(childrenYes);
        childrenBox.add(childrenNo);

        childrenBox.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.WHITE,Color.WHITE));

        addComponent(panel, childrenBox, 1, gridy++, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel blindLabel = new JLabel("Are you entitled to Blind Person Tax Credit:");
        addComponent(panel,blindLabel, 0, gridy, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        Box blindBox = Box.createHorizontalBox();
        ButtonGroup blindGroup = new ButtonGroup();
        blindYes.setBackground(Color.WHITE);
        blindNo.setBackground(Color.WHITE);

        blindGroup.add(blindYes);
        blindGroup.add(blindNo);
        blindBox.add(blindYes);
        blindBox.add(blindNo);

        blindBox.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.WHITE,Color.WHITE));

        addComponent(panel, blindBox, 1, gridy++, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel dependantLabel = new JLabel("Are you entitled to Dependant Relative Tax Credit:");
        addComponent(panel,dependantLabel, 0, gridy, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        Box dependantBox = Box.createHorizontalBox();
        ButtonGroup dependantGroup = new ButtonGroup();
        dependantYes.setBackground(Color.WHITE);
        dependantNo.setBackground(Color.WHITE);

        dependantGroup.add(dependantYes);
        dependantGroup.add(dependantNo);
        dependantBox.add(dependantYes);
        dependantBox.add(dependantNo);

        dependantBox.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.WHITE,Color.WHITE));

        addComponent(panel, dependantBox, 1, gridy++, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        return panel;

    }

    private JPanel createSubmitPanel() {

        JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                GradientPaint gradientPaint = new GradientPaint(220,180,Color.WHITE,80,180,Color.decode("#66B2FF"));
                Graphics2D g2 = (Graphics2D) g;
                g2.setPaint(gradientPaint);
                g2.fillRect(0,0,getWidth(), getHeight());
            }

        };

        JButton submitButton = new JButton("Calculate Tax");
        submitButton.setBackground(Color.decode("#ECECEC"));
        submitButton.setForeground(Color.BLACK);
        /****************************
         * Title:BorderLayout showing border lines
         * Author: Sam Lee
         * Site Owner: stackoverflow.com
         * Date: 2015
         * Version: edited May 6th 2015
         * Availability: https://stackoverflow.com/questions/30078618/borderlayout-showing-border-lines/30558915
         ****************************/
        Border raisedBorder = BorderFactory.createRaisedBevelBorder(); //stackoverflow
        submitButton.setBorder(raisedBorder);
        submitButton.setPreferredSize(new Dimension(140,50));
        submitButton.addActionListener(this);
        panel.add(submitButton);

        return panel;
    }

    private void addComponent(Container container, Component component,
                              int gridx, int gridy, Insets insets,
                              int anchor, int fill) {

        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                1, 1, 0.0, 0.0, anchor, fill, insets, 5, 5);

        container.add(component, gbc);
    }

    public void actionPerformed(ActionEvent e) {

        int choice;

        if(e.getActionCommand().equals("Quit")) {
            choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit the Tax Calculator?"+
                    " Unsaved data will be lost!", "Exiting Application", JOptionPane.YES_NO_CANCEL_OPTION);

            if(choice==JOptionPane.YES_OPTION)
                System.exit(0);
        }
        else if(e.getActionCommand().equals("Clear History")) {

            ObjectInputStream objectInputStream=null;

            try {
                FileInputStream fileInputStream = new FileInputStream(file);


                if(file.length()!= 0){
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    JOptionPane.showMessageDialog(null, "Opening the file that stores Taxpayer details",
                            "Opened File", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null, "Can't read file as it is empty!",
                            "Empty File", JOptionPane.ERROR_MESSAGE);
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
                JOptionPane.showMessageDialog(null, "File could not be opened!",
                        "Problem Opening the File!", JOptionPane.ERROR_MESSAGE);
            }

            if(objectInputStream==null)
                return;

            try{
                savedTaxpayers = (ArrayList<Taxpayer>) objectInputStream.readObject();

                Taxpayer.deleteEntries(savedTaxpayers);

                objectInputStream.close();

                try{
                    FileOutputStream outStream = new FileOutputStream(file);
                    ObjectOutputStream objectOutStream = new ObjectOutputStream(outStream);
                    objectOutStream.writeObject(savedTaxpayers);
                    outStream.close();
                    JOptionPane.showMessageDialog(null, "The amount of taxpayers on the file is now "+savedTaxpayers.size(),
                            "History Cleared", JOptionPane.PLAIN_MESSAGE);


                }
                catch(FileNotFoundException fnfe){
                    JOptionPane.showMessageDialog(null,"File could not be found!",
                            "Problem Finding File!",JOptionPane.ERROR_MESSAGE);
                }
                catch(IOException ioe){
                    JOptionPane.showMessageDialog(null,"File could not be written!",
                            "Problem Writing to File!",JOptionPane.ERROR_MESSAGE);
                }

            }
            catch (IOException ioe) {
                ioe.printStackTrace();
                JOptionPane.showMessageDialog(null, "File could not be read!",
                        "Problem Reading From File!", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
                JOptionPane.showMessageDialog(null, "Could not find the appropriate class!",
                        "Problem Finding the Class!", JOptionPane.ERROR_MESSAGE);
            }
            catch (ArithmeticException a) {
                a.printStackTrace();
                JOptionPane.showMessageDialog(null, "File could not be opened (Arithmetic Exception)!",
                        "Problem Opening the File!", JOptionPane.ERROR_MESSAGE); //Cannot do calculations
            }

        }
        else if(e.getActionCommand().equals("New")){
            nameField.setText("");
            ageField.setText("");
            spouseIncomeField.setText("0");
            incomeField.setText("");
            blindNo.setSelected(true);
            dependantNo.setSelected(true);
            childrenNo.setSelected(true);
            single.setSelected(true);
            full.setSelected(true);

        }

        else if(e.getActionCommand().equals("Calculate Tax")){
            Taxpayer taxpayer;
            char status, ratePRSI, childrenTaxCredit, blindTaxCredit, dependantRealativeTaxCredit;
            double income, spouseIncome, totalTaxLiability, totalUSC, totalTaxCredits, totalPRSI;
            double netTax, totalDeductions, totalIncome;
            String name = "";
            int age, i;

            try{
                income = Float.parseFloat(incomeField.getText());
                spouseIncome = Float.parseFloat(spouseIncomeField.getText());

                age = Integer.parseInt(ageField.getText());
                if(age>100 || age <17){
                    JOptionPane.showMessageDialog(null,"Age must be Greater than 16 and less than 100",
                            "Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }

                for(i=0; i<nameField.getText().length();i++){
                    if(Character.isDigit(nameField.getText().charAt(i)))
                        break;
                }
                if(i==nameField.getText().length())
                    name = nameField.getText();
                else{
                    JOptionPane.showMessageDialog(null,"Name field must be made up of Characters only(A-Z)",
                            "Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }


                if(full.isSelected())
                    ratePRSI = 'F';
                else
                    ratePRSI = 'R';
                if(single.isSelected())
                    status = 'S';
                else
                    status = 'M';
                if(childrenNo.isSelected())    //Can also do does using the boolean result of the selected radio buttons
                    childrenTaxCredit = 'N';
                else
                    childrenTaxCredit = 'Y';
                if(blindNo.isSelected())
                    blindTaxCredit = 'N';
                else
                    blindTaxCredit = 'Y';
                if(dependantNo.isSelected())
                    dependantRealativeTaxCredit = 'N';
                else
                    dependantRealativeTaxCredit = 'Y';

                totalTaxLiability = Calculation.CalculateTaxLiability(income, status, spouseIncome);
                totalPRSI = Calculation.CalculatePRSI(income, spouseIncome, age, status, ratePRSI);
                totalTaxCredits = Calculation.CalculateTaxCredits(age, status, childrenTaxCredit, blindTaxCredit,
                        dependantRealativeTaxCredit, income, spouseIncome);
                totalUSC = Calculation.CalculateUSC(income, spouseIncome, status, age);
                netTax = totalTaxLiability-totalTaxCredits;
                totalDeductions = netTax+totalPRSI+totalUSC;
                totalIncome = income+spouseIncome;
                taxpayer = new Taxpayer(name, age, status, totalIncome, totalTaxLiability, totalUSC, totalTaxCredits,
                        totalPRSI, netTax, totalDeductions);

                JTextArea textArea = new JTextArea();

                Font font = new Font("SansSerif", Font.PLAIN,15);
                textArea.setFont(font);
                textArea.setBackground(Color.decode("#6FF6FF"));
                textArea.setForeground(Color.BLACK);
                textArea.append(taxpayer.toString());


                JOptionPane.showMessageDialog(null,textArea,"",JOptionPane.PLAIN_MESSAGE);

                savedTaxpayers.add(taxpayer);

            }
            catch (Exception e1){
                JOptionPane.showMessageDialog(null, "Error !! The rules of the Tax Calculator are as follows "+
                                "\n\n-Name Field must be made up of characters(A-Z) only\n-Income fields must be a numeric value\n-All fields must "+
                                "be entered", "Details Error",JOptionPane.ERROR_MESSAGE);

            }
        }
        else if(e.getActionCommand().equals("Save")){

            try {
                    FileOutputStream outStream = new FileOutputStream(file);
                    ObjectOutputStream objectOutStream = new ObjectOutputStream(outStream);
                    objectOutStream.writeObject(savedTaxpayers);
                    outStream.close();
                    JOptionPane.showMessageDialog(null,"Taxpayer Details saved Successfully. The amount " +
                            "of Taxpayers on file is now "+savedTaxpayers.size(),"Success", JOptionPane.INFORMATION_MESSAGE);

            }
            catch(FileNotFoundException fnfe){
                JOptionPane.showMessageDialog(null,"File could not be found!",
                        "Problem Finding File!",JOptionPane.ERROR_MESSAGE);
            }
            catch(IOException ioe){
                JOptionPane.showMessageDialog(null,"File could not be written!",
                        "Problem Writing to File!",JOptionPane.ERROR_MESSAGE);
            }

        }

        else if(e.getActionCommand().equals("User Stats")) {
            ObjectInputStream objectInputStream=null;

            try {
                FileInputStream fileInputStream = new FileInputStream(file);


                if(file.length()!= 0){
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    JOptionPane.showMessageDialog(null, "Opening the file that stores Taxpayer details",
                            "Opened File", JOptionPane.PLAIN_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null, "Can't read file as it is empty!",
                            "Empty File", JOptionPane.ERROR_MESSAGE);
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
                JOptionPane.showMessageDialog(null, "File could not be opened!",
                        "Problem Opening the File!", JOptionPane.ERROR_MESSAGE);
            }

            if(objectInputStream==null)
                return;

            try{
                double averageIncome, totalLiability, totalUSC;
                double averageAge;

                savedTaxpayers = (ArrayList<Taxpayer>) objectInputStream.readObject();

                averageIncome=Taxpayer.getAverageIncome(savedTaxpayers);
                averageAge=Taxpayer.getAverageAge(savedTaxpayers);
                totalLiability=Taxpayer.getAverageTaxLiability(savedTaxpayers);
                totalUSC=Taxpayer.getTotalUSC(savedTaxpayers);

                objectInputStream.close();

                JOptionPane.showMessageDialog(null, "Average Income of Taxpayers read from file is: \u20ac" +
                                String.format("%.2f",averageIncome)+ "\nAverage age of the Taxpayers who have used the application is: " +
                                String.format("%.2f",averageAge)+ "\nAverage Tax Liability of the Taxpayers who have used the application is: \u20ac" +
                                String.format("%.2f",totalLiability ) + "\nTotal USC of the Taxpayers who have used the application is: \u20ac" +
                                String.format("%.2f",totalUSC), "Saved User Stats", JOptionPane.INFORMATION_MESSAGE);

            }
            catch (IOException ioe) {
                ioe.printStackTrace();
                JOptionPane.showMessageDialog(null, "File could not be read!",
                        "Problem Reading From File!", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
                JOptionPane.showMessageDialog(null, "Could not find the appropriate class!",
                        "Problem Finding the Class!", JOptionPane.ERROR_MESSAGE);
            }
            catch (ArithmeticException a) {
                a.printStackTrace();
                JOptionPane.showMessageDialog(null, "File could not be opened (Arithmetic Exception)!",
                        "Problem Opening the File!", JOptionPane.ERROR_MESSAGE); //Cannot do calculations
            }

        }

    }

}
