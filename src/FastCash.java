import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class FastCash implements ActionListener {

    LoginWindow fastcashLW=new LoginWindow();
    Buttons fastcashButtons=new Buttons();
    Labels fastcashLabel=new Labels();
    String f_accountno=Login.accountNumber;
    String f_pinno=Login.pinNumber;

    FastCash(){
        fastcashLW.loginWindow();
        fastcashLW.window.setTitle("FAST CASH");

        setfastcashButtons();

        fastcashLabel.jl1.setText("Select WithDrawal Amount");
        fastcashLW.window.add(fastcashLabel.jl1);
        fastcashLabel.jl1.setFont(new Font("System", Font.BOLD, 38));
        fastcashLabel.jl1.setBounds(120,100,700,40);



    }

    public void setfastcashButtons(){
        fastcashButtons.jb1.setText("Rs 100");
        fastcashButtons.jb2.setText("Rs 500");
        fastcashButtons.jb3.setText("Rs 1000");
        fastcashButtons.jb4.setText("Rs 2000");
        fastcashButtons.jb5.setText("Rs 5000");
        fastcashButtons.jb6.setText("Rs 10000");
        fastcashButtons.jb7.setText("EXIT");

        fastcashLW.window.add(fastcashButtons.jb1);
        fastcashLW.window.add(fastcashButtons.jb2);
        fastcashLW.window.add(fastcashButtons.jb3);
        fastcashLW.window.add(fastcashButtons.jb4);
        fastcashLW.window.add(fastcashButtons.jb5);
        fastcashLW.window.add(fastcashButtons.jb6);
        fastcashLW.window.add(fastcashButtons.jb7);

        fastcashButtons.jb1.addActionListener(this);
        fastcashButtons.jb2.addActionListener(this);
        fastcashButtons.jb3.addActionListener(this);
        fastcashButtons.jb4.addActionListener(this);
        fastcashButtons.jb5.addActionListener(this);
        fastcashButtons.jb6.addActionListener(this);
        fastcashButtons.jb7.addActionListener(this);

        fastcashButtons.jb1.setActionCommand("100");
        fastcashButtons.jb2.setActionCommand("500");
        fastcashButtons.jb3.setActionCommand("1000");
        fastcashButtons.jb4.setActionCommand("2000");
        fastcashButtons.jb5.setActionCommand("5000");
        fastcashButtons.jb6.setActionCommand("10000");
        fastcashButtons.jb7.setActionCommand("Exit");

        fastcashButtons.jb1.setFont(new Font("System", Font.BOLD, 18));
        fastcashButtons.jb1.setBackground(Color.BLACK);
        fastcashButtons.jb1.setForeground(Color.WHITE);

        fastcashButtons.jb2.setFont(new Font("System", Font.BOLD, 18));
        fastcashButtons.jb2.setBackground(Color.BLACK);
        fastcashButtons.jb2.setForeground(Color.WHITE);


        fastcashButtons.jb3.setFont(new Font("System", Font.BOLD, 18));
        fastcashButtons.jb3.setBackground(Color.BLACK);
        fastcashButtons.jb3.setForeground(Color.WHITE);

        fastcashButtons.jb4.setFont(new Font("System", Font.BOLD, 18));
        fastcashButtons.jb4.setBackground(Color.BLACK);
        fastcashButtons.jb4.setForeground(Color.WHITE);


        fastcashButtons.jb5.setFont(new Font("System", Font.BOLD, 18));
        fastcashButtons.jb5.setBackground(Color.BLACK);
        fastcashButtons.jb5.setForeground(Color.WHITE);


        fastcashButtons.jb6.setFont(new Font("System", Font.BOLD, 18));
        fastcashButtons.jb6.setBackground(Color.BLACK);
        fastcashButtons.jb6.setForeground(Color.WHITE);

        fastcashButtons.jb7.setFont(new Font("System", Font.BOLD, 18));
        fastcashButtons.jb7.setBackground(Color.BLACK);
        fastcashButtons.jb7.setForeground(Color.WHITE);


        fastcashButtons.jb1.setBounds(40,250,300,60);
        fastcashButtons.jb2.setBounds(440,250,300,60);
        fastcashButtons.jb3.setBounds(40,360,300,60);
        fastcashButtons.jb4.setBounds(440,360,300,60);
        fastcashButtons.jb5.setBounds(40,470,300,60);
        fastcashButtons.jb6.setBounds(440,470,300,60);
        fastcashButtons.jb7.setBounds(240,600,300,60);

    }
    public static void main(String[] args){
        new FastCash();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        Connector c1 = new Connector();
        try {
            switch (command) {
                case "Exit":
                    System.exit(0);
                    break;
                case "100":
                    try {
                        String pin = f_pinno;
                        String q1 = "select balance from bank where account = '" + f_accountno + "' AND pin ='" + pin + "'";
                        ResultSet rs = c1.s.executeQuery(q1);
                        if (rs.next()) {
                            double balance = Double.parseDouble(rs.getString("balance"));
                            double amount = 100;
                            balance = balance - amount;
                            if (balance <= 0) {
                                JOptionPane.showMessageDialog(null, "Balance cannot be Negative");
                            } else {
                                String q2 = "UPDATE bank SET withdraw =" + amount + ",balance = '" + balance + "' WHERE account ='" + f_accountno + "'";
                                String q3 = "insert into statement (account,pin,deposit,withdraw,balance) values(" + f_accountno + "," + pin + ",'0'," + amount + "," + balance + ")";
                                c1.s.executeUpdate(q3);
                                c1.s.executeUpdate(q2);
                                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Withdrawn Successfully");
                                fastcashLW.window.setVisible(false);
                                new Transaction();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect pin");
                        }
                    } catch (Exception e1) {
                        System.out.println(e1.getMessage());
                    }
                    break;
                case "500":
                    try {
                        String pin = f_pinno;
                        String q1 = "select balance from bank where account = '" + f_accountno + "' AND pin ='" + pin + "'";
                        ResultSet rs = c1.s.executeQuery(q1);
                        if (rs.next()) {
                            double balance = Double.parseDouble(rs.getString("balance"));
                            double amount = 500;
                            balance = balance - amount;
                            if (balance <= 0) {
                                JOptionPane.showMessageDialog(null, "Balance cannot be Negative");
                            } else {
                                String q2 = "UPDATE bank SET withdraw =" + amount + ",balance = '" + balance + "' WHERE account ='" + f_accountno + "'";
                                String q3 = "insert into statement (account,pin,deposit,withdraw,balance) values(" + f_accountno + "," + pin + ",'0'," + amount + "," + balance + ")";
                                c1.s.executeUpdate(q3);
                                c1.s.executeUpdate(q2);
                                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Withdrawn Successfully");
                                fastcashLW.window.setVisible(false);
                                new Transaction();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect pin");
                        }
                    } catch (Exception e1) {
                        System.out.println(e1.getMessage());
                    }
                    break;
                case "1000":
                    try {
                        String pin = f_pinno;
                        String q1 = "select balance from bank where account = '" + f_accountno + "' AND pin ='" + pin + "'";
                        ResultSet rs = c1.s.executeQuery(q1);
                        if (rs.next()) {
                            double balance = Double.parseDouble(rs.getString("balance"));
                            double amount = 1000;
                            balance = balance - amount;
                            if (balance <= 0) {
                                JOptionPane.showMessageDialog(null, "Balance cannot be Negative");
                            } else {
                                String q2 = "UPDATE bank SET withdraw =" + amount + ",balance = '" + balance + "' WHERE account ='" + f_accountno + "'";
                                String q3 = "insert into statement (account,pin,deposit,withdraw,balance) values(" + f_accountno + "," + pin + ",'0'," + amount + "," + balance + ")";
                                c1.s.executeUpdate(q3);
                                c1.s.executeUpdate(q2);
                                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Withdrawn Successfully");
                                fastcashLW.window.setVisible(false);
                                new Transaction();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect pin");
                        }
                    } catch (Exception e1) {
                        System.out.println(e1.getMessage());
                    }
                    break;
                case "2000":
                    try {
                        String pin = f_pinno;
                        String q1 = "select balance from bank where account = '" + f_accountno + "' AND pin ='" + pin + "'";
                        ResultSet rs = c1.s.executeQuery(q1);
                        if (rs.next()) {
                            double balance = Double.parseDouble(rs.getString("balance"));
                            double amount = 2000;
                            balance = balance - amount;
                            if (balance <= 0) {
                                JOptionPane.showMessageDialog(null, "Balance cannot be Negative");
                            } else {
                                String q2 = "UPDATE bank SET withdraw =" + amount + ",balance = '" + balance + "' WHERE account ='" + f_accountno + "'";
                                String q3 = "insert into statement (account,pin,deposit,withdraw,balance) values(" + f_accountno + "," + pin + ",'0'," + amount + "," + balance + ")";
                                c1.s.executeUpdate(q3);
                                c1.s.executeUpdate(q2);
                                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Withdrawn Successfully");
                                fastcashLW.window.setVisible(false);
                                new Transaction();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect pin");
                        }
                    } catch (Exception e1) {
                        System.out.println(e1.getMessage());
                    }
                    break;
                case "5000":
                    try {
                        String pin = f_pinno;
                        String q1 = "select balance from bank where account = '" + f_accountno + "' AND pin ='" + pin + "'";
                        ResultSet rs = c1.s.executeQuery(q1);
                        if (rs.next()) {
                            double balance = Double.parseDouble(rs.getString("balance"));
                            double amount = 5000;
                            balance = balance - amount;
                            if (balance <= 0) {
                                JOptionPane.showMessageDialog(null, "Balance cannot be Negative");
                            } else {
                                String q2 = "UPDATE bank SET withdraw =" + amount + ",balance = '" + balance + "' WHERE account ='" + f_accountno + "'";
                                String q3 = "insert into statement (account,pin,deposit,withdraw,balance) values(" + f_accountno + "," + pin + ",'0'," + amount + "," + balance + ")";
                                c1.s.executeUpdate(q3);
                                c1.s.executeUpdate(q2);
                                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Withdrawn Successfully");
                                fastcashLW.window.setVisible(false);
                                new Transaction();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect pin");
                        }
                    } catch (Exception e1) {
                        System.out.println(e1.getMessage());
                    }
                    break;
                case "10000":
                    try {
                        String pin = f_pinno;
                        String q1 = "select balance from bank where account = '" + f_accountno + "' AND pin ='" + pin + "'";
                        ResultSet rs = c1.s.executeQuery(q1);
                        if (rs.next()) {
                            double balance = Double.parseDouble(rs.getString("balance"));
                            double amount = 10000;
                            balance = balance - amount;
                            if (balance <= 0) {
                                JOptionPane.showMessageDialog(null, "Balance cannot be Negative");
                            } else {
                                String q2 = "UPDATE bank SET withdraw =" + amount + ",balance = '" + balance + "' WHERE account ='" + f_accountno + "'";
                                String q3 = "insert into statement (account,pin,deposit,withdraw,balance) values(" + f_accountno + "," + pin + ",'0'," + amount + "," + balance + ")";
                                c1.s.executeUpdate(q3);
                                c1.s.executeUpdate(q2);
                                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Withdrawn Successfully");
                                fastcashLW.window.setVisible(false);
                                new Transaction();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect pin");
                        }
                    } catch (Exception e1) {
                        System.out.println(e1.getMessage());
                    }
                    break;
            }
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
