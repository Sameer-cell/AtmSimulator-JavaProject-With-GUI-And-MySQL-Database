import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class WithDraw implements ActionListener {
    LoginWindow withdrawLW = new LoginWindow();
    Buttons withdrawButtons = new Buttons();
    Labels withdrawLabel = new Labels();
    TextField withdrawPin = new TextField();
    String w_accountno = Login.accountNumber;
    String w_pinno = Login.pinNumber;

    WithDraw() {
        withdrawLW.loginWindow();
        withdrawLW.window.setTitle("WITHDRAW");

        withdrawLabel.jl1.setText("ENTER AMOUNT YOU WANT");
        withdrawLW.window.add(withdrawLabel.jl1);
        withdrawLabel.jl1.setFont(new Font("System", Font.BOLD, 38));
        withdrawLabel.jl1.setBounds(130, 100, 700, 40);

        withdrawLabel.jl3.setText("TO WITHDRAW");
        withdrawLW.window.add(withdrawLabel.jl3);
        withdrawLabel.jl3.setFont(new Font("System", Font.BOLD, 38));
        withdrawLabel.jl3.setBounds(280, 200, 400, 40);

        setwithdrawButtons();
        setAmount();

    }

    public void setAmount() {
        withdrawPin.jt1.setColumns(30);
        withdrawLW.window.add(withdrawPin.jt1);
        withdrawPin.jt1.setBounds(240, 300, 350, 40);
        withdrawPin.jt1.setFont(new Font("System", Font.BOLD, 22));

    }

    public void setwithdrawButtons() {
        withdrawButtons.jb1.setText("WITHDRAW");
        withdrawButtons.jb2.setText("BACK");
        withdrawButtons.jb3.setText("EXIT");

        withdrawLW.window.add(withdrawButtons.jb1);
        withdrawLW.window.add(withdrawButtons.jb2);
        withdrawLW.window.add(withdrawButtons.jb3);

        withdrawButtons.jb1.addActionListener(this);
        withdrawButtons.jb2.addActionListener(this);
        withdrawButtons.jb3.addActionListener(this);

        withdrawButtons.jb1.setActionCommand("Withdraw");
        withdrawButtons.jb2.setActionCommand("Back");
        withdrawButtons.jb3.setActionCommand("Exit");


        withdrawButtons.jb1.setFont(new Font("System", Font.BOLD, 18));
        withdrawButtons.jb1.setBackground(Color.BLACK);
        withdrawButtons.jb1.setForeground(Color.WHITE);

        withdrawButtons.jb2.setFont(new Font("System", Font.BOLD, 18));
        withdrawButtons.jb2.setBackground(Color.BLACK);
        withdrawButtons.jb2.setForeground(Color.WHITE);

        withdrawButtons.jb3.setFont(new Font("System", Font.BOLD, 18));
        withdrawButtons.jb3.setBackground(Color.BLACK);
        withdrawButtons.jb3.setForeground(Color.WHITE);

        withdrawButtons.jb1.setBounds(240, 380, 140, 50);
        withdrawButtons.jb2.setBounds(415, 380, 125, 50);
        withdrawButtons.jb3.setBounds(300, 460, 200, 50);


    }


    public static void main(String[] args) {
        new WithDraw();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Exit":
                System.exit(0);
                break;
            case "Back":
                withdrawLW.window.setVisible(false);
                new Transaction();
                break;
            case "Withdraw":
                String pin = w_pinno;
                String amount = withdrawPin.jt1.getText();
                Connector c1 = new Connector();
                try {
                    String q1 = "select balance from bank where account = '" + w_accountno + "' AND pin ='" + pin + "'";
                    ResultSet rs = c1.s.executeQuery(q1);
                    if (rs.next()) {
                        double balance = Double.parseDouble(rs.getString("balance"));
                        double d = Double.parseDouble(amount);
                        balance = balance - d;
                        if (balance <= 0) {
                            JOptionPane.showMessageDialog(null, "Balance can not be Negative");
                        } else {
                            String q2 = "UPDATE bank SET withdraw ='" + amount + "',balance = '" + balance + "' WHERE account ='" + w_accountno + "'";
                            String q3 = "insert into statement (account,pin,deposit,withdraw,balance) values(" + w_accountno + "," + pin + ",'0'," + amount + "," + balance + ")";
                            c1.s.executeUpdate(q2);
                            c1.s.executeUpdate(q3);
                            JOptionPane.showMessageDialog(null, "Rs. " + amount + " Withdraw Successful");
                            withdrawLW.window.setVisible(false);
                            new Transaction();
                        }
                    }
                } catch (Exception e1) {
                    System.out.println(e1.getMessage());
                }finally {
                    try{
                        c1.c.close();
                        c1.s.close();
                    }catch (Exception e5){
                        System.out.println(e5.getMessage());
                    }
                }
        }
    }
}
