import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Signup3 implements ActionListener, WindowListener {
    LoginWindow signup3LoginWindow=new LoginWindow();
    Labels signup3Lables=new Labels();
    TextField signup3Radio=new TextField();
    CheckBox signup3CheckBox=new CheckBox();
    Buttons signup3Buttons=new Buttons();
    String signup3Form_no=Signup.formNumber;
    ButtonGroup buttonGroup=new ButtonGroup();
    String first4="";
    String first8="459115466871";

    Signup3(){
        signup3LoginWindow.loginWindow();
        signup3LoginWindow.window.setTitle("Form : 3");


        setSignup3Buttons();
        setSignup3CheckBox();
        setSignup3Radio();


        signup3Lables.jl1.setText("Page 3: Account Details");
        signup3Lables.jl2.setText("Account Type:");
        signup3Lables.jl3.setText("Card Number:");
        signup3Lables.jl4.setText("XXXX-XXXX-XXXX-4184");
        signup3Lables.jl5.setText("(Your 16-digit Card number)");
        signup3Lables.jl6.setText("It would appear on ATM Card/Cheque Book and Statements");
        signup3Lables.jl7.setText("PIN:");
        signup3Lables.jl8.setText("XXXX");
        signup3Lables.jl9.setText("(4-digit password)");
        signup3Lables.jl10.setText("Services Required:");

        signup3LoginWindow.window.add(signup3Lables.jl1);
        signup3LoginWindow.window.add(signup3Lables.jl2);
        signup3LoginWindow.window.add(signup3Lables.jl3);
        signup3LoginWindow.window.add(signup3Lables.jl4);
        signup3LoginWindow.window.add(signup3Lables.jl5);
        signup3LoginWindow.window.add(signup3Lables.jl6);
        signup3LoginWindow.window.add(signup3Lables.jl7);
        signup3LoginWindow.window.add(signup3Lables.jl8);
        signup3LoginWindow.window.add(signup3Lables.jl9);
        signup3LoginWindow.window.add(signup3Lables.jl10);
        setSignup3Lables();

        signup3Buttons.jb1.addActionListener(this);
        signup3Buttons.jb1.setActionCommand("Cancel");

        signup3Buttons.jb2.addActionListener(this);
        signup3Buttons.jb2.setActionCommand("Submit");

        signup3LoginWindow.window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
            }
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    Connector c1=new Connector();
                    String q="delete from signup where formno = '"+signup3Form_no+"'";
                    String q1="delete from signup2 where formno = '"+signup3Form_no+"'";
                    c1.s.executeUpdate(q);
                    c1.s.executeUpdate(q1);
                    c1.s.close();
                }catch (Exception e1){
                    System.out.println(e1.getMessage());
                }
            }
        });


    }

    public void setSignup3Lables(){
        signup3Lables.jl1.setBounds(280,50,400,40);
        signup3Lables.jl2.setBounds(100,100,200,30);
        signup3Lables.jl3.setBounds(100,260,200,30);
        signup3Lables.jl4.setBounds(330,260,250,30);
        signup3Lables.jl5.setBounds(100,290,200,20);
        signup3Lables.jl6.setBounds(330,290,500,20);
        signup3Lables.jl7.setBounds(100,330,200,30);
        signup3Lables.jl8.setBounds(330,330,200,30);
        signup3Lables.jl9.setBounds(100,360,200,20);
        signup3Lables.jl10.setBounds(100,410,200,30);



        signup3Lables.jl1.setFont(new Font("Raleway", Font.BOLD, 22));
        signup3Lables.jl2.setFont(new Font("Raleway", Font.BOLD, 18));
        signup3Lables.jl3.setFont(new Font("Raleway", Font.BOLD, 18));
        signup3Lables.jl4.setFont(new Font("Raleway", Font.BOLD, 18));
        signup3Lables.jl5.setFont(new Font("Raleway", Font.BOLD, 12));
        signup3Lables.jl6.setFont(new Font("Raleway", Font.BOLD, 12));
        signup3Lables.jl7.setFont(new Font("Raleway", Font.BOLD, 18));
        signup3Lables.jl8.setFont(new Font("Raleway", Font.BOLD, 18));
        signup3Lables.jl9.setFont(new Font("Raleway", Font.BOLD, 12));
        signup3Lables.jl10.setFont(new Font("Raleway", Font.BOLD, 18));

    }

    public void setSignup3Radio(){
        signup3Radio.jr4.setText("Recurring Deposit Account");
        signup3Radio.jr1.setText("Saving Account");
        signup3Radio.jr2.setText("Fixed Deposit Account");
        signup3Radio.jr3.setText("Current Account");

        signup3LoginWindow.window.add(signup3Radio.jr4);
        signup3LoginWindow.window.add(signup3Radio.jr1);
        signup3LoginWindow.window.add(signup3Radio.jr2);
        signup3LoginWindow.window.add(signup3Radio.jr3);


        signup3Radio.jr1.setBounds(100,140,145,30);
        signup3Radio.jr2.setBounds(350,140,200,30);
        signup3Radio.jr3.setBounds(100,180,155,30);
        signup3Radio.jr4.setBounds(350,180,235,30);


        signup3Radio.jr1.setFont(new Font("Raleway", Font.BOLD, 16));
        signup3Radio.jr1.setBackground(new Color(51, 255, 247));


        signup3Radio.jr2.setFont(new Font("Raleway", Font.BOLD, 16));
        signup3Radio.jr2.setBackground(new Color(51, 255, 247));


        signup3Radio.jr3.setFont(new Font("Raleway", Font.BOLD, 16));
        signup3Radio.jr3.setBackground(new Color(51, 255, 247));

        signup3Radio.jr4.setFont(new Font("Raleway", Font.BOLD, 16));
        signup3Radio.jr4.setBackground(new Color(51, 255, 247));

        buttonGroup.add(signup3Radio.jr1);
        buttonGroup.add(signup3Radio.jr2);
        buttonGroup.add(signup3Radio.jr3);
        buttonGroup.add(signup3Radio.jr4);

    }

    public void setSignup3CheckBox(){
        signup3CheckBox.cb1.setText("ATM CARD");
        signup3CheckBox.cb2.setText("Internet Banking");
        signup3CheckBox.cb3.setText("Mobile Banking");
        signup3CheckBox.cb4.setText("EMAIL Alerts");
        signup3CheckBox.cb5.setText("Cheque Book");
        signup3CheckBox.cb6.setText("E-Statement");
        signup3CheckBox.cb7.setText("I hereby declares that the above entered details correct to th best of my knowledge.");

        signup3LoginWindow.window.add(signup3CheckBox.cb1);
        signup3LoginWindow.window.add(signup3CheckBox.cb2);
        signup3LoginWindow.window.add(signup3CheckBox.cb3);
        signup3LoginWindow.window.add(signup3CheckBox.cb4);
        signup3LoginWindow.window.add(signup3CheckBox.cb5);
        signup3LoginWindow.window.add(signup3CheckBox.cb6);
        signup3LoginWindow.window.add(signup3CheckBox.cb7);


        signup3CheckBox.cb1.setBounds(100,460,200,30);
        signup3CheckBox.cb2.setBounds(350,460,200,30);
        signup3CheckBox.cb3.setBounds(100,510,200,30);
        signup3CheckBox.cb4.setBounds(350,510,200,30);
        signup3CheckBox.cb5.setBounds(100,560,200,30);
        signup3CheckBox.cb6.setBounds(350,560,200,30);
        signup3CheckBox.cb7.setBounds(100,610,600,20);


        signup3CheckBox.cb1.setBackground(new Color(51, 255, 247));
        signup3CheckBox.cb1.setFont(new Font("Raleway", Font.BOLD, 16));


        signup3CheckBox.cb2.setBackground(new Color(51, 255, 247));
        signup3CheckBox.cb2.setFont(new Font("Raleway", Font.BOLD, 16));


        signup3CheckBox.cb3.setBackground(new Color(51, 255, 247));
        signup3CheckBox.cb3.setFont(new Font("Raleway", Font.BOLD, 16));


        signup3CheckBox.cb4.setBackground(new Color(51, 255, 247));
        signup3CheckBox.cb4.setFont(new Font("Raleway", Font.BOLD, 16));


        signup3CheckBox.cb5.setBackground(new Color(51, 255, 247));
        signup3CheckBox.cb5.setFont(new Font("Raleway", Font.BOLD, 16));


        signup3CheckBox.cb6.setBackground(new Color(51, 255, 247));
        signup3CheckBox.cb6.setFont(new Font("Raleway", Font.BOLD, 16));

        signup3CheckBox.cb7.setBackground(new Color(51, 255, 247));
        signup3CheckBox.cb7.setFont(new Font("Raleway", Font.BOLD, 12));

    }

    public void setSignup3Buttons(){
        signup3Buttons.jb1.setText("Cancel");
        signup3Buttons.jb2.setText("Submit");

        signup3LoginWindow.window.add(signup3Buttons.jb1);
        signup3LoginWindow.window.add(signup3Buttons.jb2);

        signup3Buttons.jb1.setBounds(250,650,100,30);
        signup3Buttons.jb2.setBounds(400,650,100,30);

        signup3Buttons.jb1.setBackground(Color.BLACK);
        signup3Buttons.jb2.setBackground(Color.BLACK);

        signup3Buttons.jb1.setForeground(Color.WHITE);
        signup3Buttons.jb2.setForeground(Color.WHITE);

    }


    public static void main(String[] args){
        new Signup3();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        if(command.equals("Cancel")){
            try{
                Connector c1=new Connector();
                String q1="Delete From signup2 WHERE formno ="+signup3Form_no+"";
                String q2="Delete From signup WHERE formno ="+signup3Form_no+"";
                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.close();
            }catch (Exception e1){
                System.out.println(e1.getMessage());
            }
            System.exit(0);
        }else if(command.equals("Submit")){
            if(!signup3CheckBox.cb7.isSelected()){
                JOptionPane.showMessageDialog(null,"Select the last Check Box");
            }else if(!signup3Radio.jr1.isSelected() && !signup3Radio.jr2.isSelected() && !signup3Radio.jr3.isSelected() && !signup3Radio.jr4.isSelected()){
                JOptionPane.showMessageDialog(null,"Fill all the details correctly");
            } else {
                String accountType="";
                if(signup3Radio.jr1.isSelected()){
                    accountType="Saving Account";
                }else if(signup3Radio.jr2.isSelected()){
                    accountType="Fixed Deposit Type";
                }else if(signup3Radio.jr3.isSelected()){
                    accountType="Current account";
                }else if(signup3Radio.jr4.isSelected()){
                    accountType="Recurring Deposit Account";
                }

                try {
                    Connector c1=new Connector();
                    String q="Select formno from signup3";
                    ResultSet rs=c1.s.executeQuery(q);
                    int count4=4575;
                    while (rs.next()){
                        count4++;
                    }
                    long f=count4+755;
                    first4=first4+count4;
                    first8=first8+f;
                    c1.s.close();
                }catch (Exception e1){
                    System.out.println(e1.getMessage());
                }


                String servicesRequired="";
                if(signup3CheckBox.cb1.isSelected()){
                    servicesRequired = servicesRequired +" ATM Card";
                }
                if(signup3CheckBox.cb2.isSelected()){
                    servicesRequired = servicesRequired+" Internet Banking";
                }
                if(signup3CheckBox.cb3.isSelected()){
                    servicesRequired = servicesRequired+" Mobile Banking";
                }
                if(signup3CheckBox.cb4.isSelected()){
                    servicesRequired = servicesRequired+" EMAIL Alerts";
                }
                if(signup3CheckBox.cb5.isSelected()){
                    servicesRequired = servicesRequired+" Cheque Book";
                }
                if(signup3CheckBox.cb6.isSelected()){
                    servicesRequired = servicesRequired+" E-Statement";
                }

                try {
                    Connector c1=new Connector();
                    String q1 = "insert into signup3 values('"+signup3Form_no+"','"+accountType+"','"+first8+"','"+first4+"','"+servicesRequired+"')";
                    String q2 = "insert into login values('"+first8+"','"+first4+"')";
                    String q3= "insert into bank values('"+first8+"','"+first4+"','0','0','0')";
                    String q4= "insert into statement (account,pin,deposit,withdraw,balance) values('"+first8+"','"+first4+"','0','0','0')";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    c1.s.executeUpdate(q3);
                    c1.s.executeUpdate(q4);
                    JOptionPane.showMessageDialog(null,"Account no : "+first8+"\n Pin no : "+first4);
                    signup3LoginWindow.window.setVisible(false);
                    new Login();
                    c1.s.close();
                }catch (Exception e1){
                    System.out.println(e1.getMessage());
                }

            }

        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
