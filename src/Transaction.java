import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Transaction implements ActionListener {
    LoginWindow transctionLW=new LoginWindow();
    Buttons transcationButtons=new Buttons();
    Labels transactionLabel=new Labels();
    String account_no=Login.accountNumber;
    String pin_no=Login.pinNumber;

    Transaction(){
        transctionLW.loginWindow();
        transctionLW.window.setTitle("TRANSACTION");

        setTranscationButtons();

        transactionLabel.jl1.setText("Please Select Your Transaction");
        transctionLW.window.add(transactionLabel.jl1);
        transactionLabel.jl1.setFont(new Font("System", Font.BOLD, 38));
        transactionLabel.jl1.setBounds(100,100,700,40);



    }

    public void setTranscationButtons(){
        transcationButtons.jb1.setText("DEPOSIT");
        transcationButtons.jb2.setText("CASH WITHDRAWL");
        transcationButtons.jb3.setText("FAST CASH");
        transcationButtons.jb4.setText("MINI STATEMENT");
        transcationButtons.jb5.setText("PIN CHANGE");
        transcationButtons.jb6.setText("BALANCE ENQUIRY");
        transcationButtons.jb7.setText("EXIT");

        transctionLW.window.add(transcationButtons.jb1);
        transctionLW.window.add(transcationButtons.jb2);
        transctionLW.window.add(transcationButtons.jb3);
        transctionLW.window.add(transcationButtons.jb4);
        transctionLW.window.add(transcationButtons.jb5);
        transctionLW.window.add(transcationButtons.jb6);
        transctionLW.window.add(transcationButtons.jb7);

        transcationButtons.jb1.addActionListener(this);
        transcationButtons.jb2.addActionListener(this);
        transcationButtons.jb3.addActionListener(this);
        transcationButtons.jb4.addActionListener(this);
        transcationButtons.jb5.addActionListener(this);
        transcationButtons.jb6.addActionListener(this);
        transcationButtons.jb7.addActionListener(this);

        transcationButtons.jb1.setActionCommand("DEPOSIT");
        transcationButtons.jb2.setActionCommand("CASH WITHDRAWL");
        transcationButtons.jb3.setActionCommand("FAST CASH");
        transcationButtons.jb4.setActionCommand("MINI STATEMENT");
        transcationButtons.jb5.setActionCommand("PIN CHANGE");
        transcationButtons.jb6.setActionCommand("BALANCE ENQUIRY");
        transcationButtons.jb7.setActionCommand("EXIT");

        transcationButtons.jb1.setFont(new Font("System", Font.BOLD, 18));
        transcationButtons.jb1.setBackground(Color.BLACK);
        transcationButtons.jb1.setForeground(Color.WHITE);

        transcationButtons.jb2.setFont(new Font("System", Font.BOLD, 18));
        transcationButtons.jb2.setBackground(Color.BLACK);
        transcationButtons.jb2.setForeground(Color.WHITE);


        transcationButtons.jb3.setFont(new Font("System", Font.BOLD, 18));
        transcationButtons.jb3.setBackground(Color.BLACK);
        transcationButtons.jb3.setForeground(Color.WHITE);

        transcationButtons.jb4.setFont(new Font("System", Font.BOLD, 18));
        transcationButtons.jb4.setBackground(Color.BLACK);
        transcationButtons.jb4.setForeground(Color.WHITE);


        transcationButtons.jb5.setFont(new Font("System", Font.BOLD, 18));
        transcationButtons.jb5.setBackground(Color.BLACK);
        transcationButtons.jb5.setForeground(Color.WHITE);


        transcationButtons.jb6.setFont(new Font("System", Font.BOLD, 18));
        transcationButtons.jb6.setBackground(Color.BLACK);
        transcationButtons.jb6.setForeground(Color.WHITE);

        transcationButtons.jb7.setFont(new Font("System", Font.BOLD, 18));
        transcationButtons.jb7.setBackground(Color.BLACK);
        transcationButtons.jb7.setForeground(Color.WHITE);


        transcationButtons.jb1.setBounds(40,250,300,60);
        transcationButtons.jb2.setBounds(440,250,300,60);
        transcationButtons.jb3.setBounds(40,360,300,60);
        transcationButtons.jb4.setBounds(440,360,300,60);
        transcationButtons.jb5.setBounds(40,470,300,60);
        transcationButtons.jb6.setBounds(440,470,300,60);
        transcationButtons.jb7.setBounds(240,600,300,60);

    }

    public static void main(String[] args){
        new Transaction();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        switch (command){
            case "DEPOSIT":
                new Deposit();
                transctionLW.window.setVisible(false);
                break;
            case "CASH WITHDRAWL":
                new WithDraw();
                transctionLW.window.setVisible(false);
                break;
            case "FAST CASH":
                new FastCash();
                transctionLW.window.setVisible(false);
                break;
            case "MINI STATEMENT":
                new MiniStatement();
                transctionLW.window.setVisible(false);
                break;
            case "PIN CHANGE":
                new PinChange();
                transctionLW.window.setVisible(false);
                break;
            case "BALANCE ENQUIRY":
                try {
                    Connector c1=new Connector();
                    String q="Select balance from bank Where account ='"+account_no+"' AND pin ='"+pin_no+"'";
                    ResultSet rs=c1.s.executeQuery(q);
                    if(rs.next()){
                        String balance=rs.getString("balance");
                        JOptionPane.showMessageDialog(null,"The Balance is : "+balance);
                    }else {
                        System.out.println("Some error");
                    }
                    c1.s.close();
                }catch (Exception e1){
                    System.out.println(e1.getMessage());
                }
                break;
            case "EXIT":
                System.exit(0);
        }
    }
}
