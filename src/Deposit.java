import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Deposit implements ActionListener {
    LoginWindow depositLW=new LoginWindow();
    Buttons depositButtons=new Buttons();
    Labels depositLabel=new Labels();
    TextField depositPin=new TextField();
    String daccount_no=Login.accountNumber;
    String dpin_no=Login.pinNumber;

    Deposit(){
        depositLW.loginWindow();
        depositLW.window.setTitle("DEPOSIT");

        depositLabel.jl1.setText("ENTER AMOUNT YOU WANT");
        depositLW.window.add(depositLabel.jl1);
        depositLabel.jl1.setFont(new Font("System", Font.BOLD, 38));
        depositLabel.jl1.setBounds(130,100,700,40);

        depositLabel.jl3.setText("TO DEPOSIT");
        depositLW.window.add(depositLabel.jl3);
        depositLabel.jl3.setFont(new Font("System", Font.BOLD, 38));
        depositLabel.jl3.setBounds(280,200,400,40);


        setDepositButtons();
        setAmount();

    }

    public void setAmount(){
        depositPin.jt1.setColumns(30);
        depositLW.window.add(depositPin.jt1);
        depositPin.jt1.setBounds(240,300,350,40);
        depositPin.jt1.setFont(new Font("System", Font.BOLD, 18));

    }
    
    public void setDepositButtons(){
        depositButtons.jb1.setText("DEPOSIT");
        depositButtons.jb2.setText("BACK");
        depositButtons.jb3.setText("EXIT");

        depositLW.window.add(depositButtons.jb1);
        depositLW.window.add(depositButtons.jb2);
        depositLW.window.add(depositButtons.jb3);

        depositButtons.jb1.addActionListener(this);
        depositButtons.jb2.addActionListener(this);
        depositButtons.jb3.addActionListener(this);

        depositButtons.jb1.setActionCommand("Deposit");
        depositButtons.jb2.setActionCommand("Back");
        depositButtons.jb3.setActionCommand("Exit");


        depositButtons.jb1.setFont(new Font("System", Font.BOLD, 18));
        depositButtons.jb1.setBackground(Color.BLACK);
        depositButtons.jb1.setForeground(Color.WHITE);

        depositButtons.jb2.setFont(new Font("System", Font.BOLD, 18));
        depositButtons.jb2.setBackground(Color.BLACK);
        depositButtons.jb2.setForeground(Color.WHITE);

        depositButtons.jb3.setFont(new Font("System", Font.BOLD, 18));
        depositButtons.jb3.setBackground(Color.BLACK);
        depositButtons.jb3.setForeground(Color.WHITE);

        depositButtons.jb1.setBounds(260,380,125,50);
        depositButtons.jb2.setBounds(415,380,125,50);
        depositButtons.jb3.setBounds(300,550,200,50);


    }
    
    public static void main(String[] args){
        new Deposit();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Exit":
                System.exit(0);
                break;
            case "Back":
                depositLW.window.setVisible(false);
                new Transaction();
                break;
            case "Deposit":
                String pin = dpin_no;
                String amount = depositPin.jt1.getText();
                try {
                    Connector c1 = new Connector();
                    String q1 = "select balance from bank where account = '" + daccount_no + "' AND pin ='" + pin + "'";
                    ResultSet rs = c1.s.executeQuery(q1);
                    double balance = 0;
                    if (rs.next()) {
                        String balance1 = rs.getString("balance");
                        double d = Double.parseDouble(amount);
                        if (d <= 0) {
                            JOptionPane.showMessageDialog(null, "Please Enter correct Amount");
                        } else {
                            balance = d + Double.parseDouble(balance1);
                            String q2 = "UPDATE bank SET deposit ='" + amount + "',balance = '" + balance + "' WHERE account ='" + daccount_no + "'";
                            String q3 = "insert into statement (account,pin,deposit,withdraw,balance) values(" + daccount_no + "," + pin + "," + amount + ",'0'," + balance + ")";
                            c1.s.executeUpdate(q2);
                            c1.s.executeUpdate(q3);
                            JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully");
                            depositLW.window.setVisible(false);
                            new Transaction();
                            c1.s.close();
                        }
                    }
                } catch (Exception e1) {
                    System.out.println(e1.getMessage());
                }
        }
    }
}
