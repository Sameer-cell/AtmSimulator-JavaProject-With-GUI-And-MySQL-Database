import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login implements ActionListener {
    LoginWindow lw=new LoginWindow();
    Labels labels=new Labels();
    TextField textField=new TextField();
    Buttons buttons=new Buttons();
    public static String accountNumber;
    static public String pinNumber;

    public Login(){
        lw.loginWindow();
        lw.window.setTitle("AUTOMATED TELLER MACHINE");

        labels.jl1.setText("WELCOME TO THE ATM");
        labels.jl2.setText("Card No :");
        labels.jl3.setText("Pin No :");
        lw.window.add(labels.jl1);
        lw.window.add(labels.jl2);
        lw.window.add(labels.jl3);
        setLabels();

        textField.jt1.setColumns(15);
        textField.jp1.setColumns(15);
        lw.window.add(textField.jt1);
        lw.window.add(textField.jp1);
        setTextField();

        buttons.jb1.setText("SignIn");
        buttons.jb2.setText("Clear");
        buttons.jb3.setText("SignUp");
        lw.window.add(buttons.jb1);
        lw.window.add(buttons.jb2);
        lw.window.add(buttons.jb3);
        setButtons();

        buttons.jb1.addActionListener(this);
        buttons.jb1.setActionCommand("SignIn");

        buttons.jb2.addActionListener(this);
        buttons.jb2.setActionCommand("Clear");

        buttons.jb3.addActionListener(this);
        buttons.jb3.setActionCommand("SignUp");

    }

    public void setLabels(){

        labels.jl1.setBounds(175,50,450,200);
        labels.jl2.setBounds(125,150,375,200);
        labels.jl3.setBounds(125,225,375,200);

        labels.jl1.setFont(new Font("Arial", Font.BOLD, 38));
        labels.jl2.setFont(new Font("Arial", Font.BOLD, 28));
        labels.jl3.setFont(new Font("Arial", Font.BOLD, 28));
    }

    public void setTextField(){
        textField.jt1.setBounds(300,235,230,30);
        textField.jt1.setFont(new Font("Arial", Font.BOLD, 18));

        textField.jp1.setFont(new Font("Arial", Font.BOLD, 18));
        textField.jp1.setBounds(300,310,230,30);

    }

    public void setButtons(){
        buttons.jb1.setFont(new Font("Arial", Font.BOLD, 18));
        buttons.jb2.setFont(new Font("Arial", Font.BOLD, 18));
        buttons.jb3.setFont(new Font("Arial", Font.BOLD, 18));

        buttons.jb1.setBounds(300,400,100,35);
        buttons.jb2.setBounds(430,400,100,35);
        buttons.jb3.setBounds(300,470,230,50);

        buttons.jb1.setBackground(Color.BLACK);
        buttons.jb2.setBackground(Color.BLACK);
        buttons.jb3.setBackground(Color.BLACK);

        buttons.jb1.setForeground(Color.WHITE);
        buttons.jb2.setForeground(Color.WHITE);
        buttons.jb3.setForeground(Color.WHITE);
    }



    public static void main(String[] args){
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        switch (command){
            case "Clear":
                textField.jt1.setText("");
                textField.jp1.setText("");
                break;

            case "SignIn":
                Connector c1 = new Connector();
                    try {
                        String account_no = textField.jt1.getText();
                        accountNumber=account_no;
                        char[] c= textField.jp1.getPassword();
                        String pin = toString((c));
                        pinNumber=pin;
                        String q = "select * from login where cardno = '" + account_no + "' and pin = '" + pin + "'";
                        ResultSet rs = c1.s.executeQuery(q);

                        if (rs.next()) {
                            lw.window.setVisible(false);
                            new Transaction();
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect Card Number or Password");
                        }
                    }catch (Exception e1){
                        System.out.println(e1.getMessage());
                    }
                    finally {
                        try{
                            c1.c.close();
                            c1.s.close();
                        }catch (Exception e5){
                            System.out.println(e5.getMessage());
                        }
                    }
                break;
            case "SignUp":
                lw.window.setVisible(false);
                new Signup();
                break;

        }
    }

    private String toString(char[] c) {
        return new String(c);
    }
}
