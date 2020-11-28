import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PinChange implements ActionListener {
    LoginWindow pinChangeLW=new LoginWindow();
    Labels pinChangeLabels=new Labels();
    TextField pinChangeTextField=new TextField();
    Buttons pinChangeButtons=new Buttons();
    String p_accountno=Login.accountNumber;

    PinChange(){
        pinChangeLW.loginWindow();
        pinChangeLW.window.setTitle("PIN CHANGE");
        
        setPinChangeLabels();
        setPin();
        setPinChangeButtons();

        pinChangeButtons.jb1.addActionListener(this);
        pinChangeButtons.jb2.addActionListener(this);

        pinChangeButtons.jb1.setActionCommand("Save");
        pinChangeButtons.jb2.setActionCommand("Back");

    }

    public void setPinChangeButtons(){
        pinChangeButtons.jb1.setText("SAVE");
        pinChangeButtons.jb2.setText("BACK");

        pinChangeLW.window.add(pinChangeButtons.jb1);
        pinChangeLW.window.add(pinChangeButtons.jb2);

        pinChangeButtons.jb1.setFont(new Font("System", Font.BOLD, 18));
        pinChangeButtons.jb1.setBackground(Color.BLACK);
        pinChangeButtons.jb1.setForeground(Color.WHITE);

        pinChangeButtons.jb2.setFont(new Font("System", Font.BOLD, 18));
        pinChangeButtons.jb2.setBackground(Color.BLACK);
        pinChangeButtons.jb2.setForeground(Color.WHITE);

        pinChangeButtons.jb1.setBounds(220,460,160,50);
        pinChangeButtons.jb2.setBounds(400,460,160,50);

    }

    public void setPin(){
        pinChangeTextField.jp1.setColumns(20);
        pinChangeTextField.jp2.setColumns(20);
        pinChangeTextField.jp3.setColumns(20);

        pinChangeLW.window.add(pinChangeTextField.jp1);
        pinChangeLW.window.add(pinChangeTextField.jp2);
        pinChangeLW.window.add(pinChangeTextField.jp3);

        pinChangeTextField.jp1.setFont(new Font("Times New Roman", Font.BOLD, 22));
        pinChangeTextField.jp2.setFont(new Font("Times New Roman", Font.BOLD, 22));
        pinChangeTextField.jp3.setFont(new Font("Times New Roman", Font.BOLD, 22));

        pinChangeTextField.jp1.setBounds(310,240,360,40);
        pinChangeTextField.jp2.setBounds(310,300,360,40);
        pinChangeTextField.jp3.setBounds(310,360,360,40);


    }

    public void setPinChangeLabels(){
        pinChangeLabels.jl1.setText("CHANGE YOUR PIN");
        pinChangeLabels.jl2.setText("Current PIN:");
        pinChangeLabels.jl3.setText("New PIN:");
        pinChangeLabels.jl4.setText("Re-Enter New PIN:");

        pinChangeLabels.jl1.setFont(new Font("System", Font.BOLD, 35));
        pinChangeLabels.jl2.setFont(new Font("System", Font.BOLD, 22));
        pinChangeLabels.jl3.setFont(new Font("System", Font.BOLD, 22));
        pinChangeLabels.jl4.setFont(new Font("System", Font.BOLD, 22));

        pinChangeLabels.jl1.setBounds(220,130,800,60);
        pinChangeLabels.jl2.setBounds(100,240,150,40);
        pinChangeLabels.jl3.setBounds(100,300,150,40);
        pinChangeLabels.jl4.setBounds(100,360,200,40);

        pinChangeLW.window.add(pinChangeLabels.jl1);
        pinChangeLW.window.add(pinChangeLabels.jl2);
        pinChangeLW.window.add(pinChangeLabels.jl3);
        pinChangeLW.window.add(pinChangeLabels.jl4);

    }
    

    public static void main(String[] args){
        new PinChange();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        switch (command){
            case "Back":
                pinChangeLW.window.setVisible(false);
                new Transaction();
                break;
            case "Save":
                char []c=pinChangeTextField.jp1.getPassword();
                char []cc1=pinChangeTextField.jp2.getPassword();
                char []cc2=pinChangeTextField.jp3.getPassword();
                String currentPin=toString(c);
                String newPin=toString(cc1);
                String reEnternewPin=toString(cc2);
                if(!newPin.equals(reEnternewPin)){
                    JOptionPane.showMessageDialog(null,"ReEnter the new pin correctly");
                }else{
                    try {
                        Connector c1=new Connector();
                        String q="Select pin from Login Where cardno ='"+p_accountno+"'AND pin ='"+currentPin+"'";
                        ResultSet rs=c1.s.executeQuery(q);
                        if(!rs.next()){
                            JOptionPane.showMessageDialog(null,"Enter the correct pin number");
                        }else {
                            String q1="Update Login SET pin='"+newPin+"' where cardno ='"+p_accountno+"'AND pin ='"+currentPin+"'";
                            String q2="Update bank SET pin='"+newPin+"' where account ='"+p_accountno+"'AND pin ='"+currentPin+"'";
                            String q3="Update signup3 SET pin='"+newPin+"' where cardno ='"+p_accountno+"'AND pin ='"+currentPin+"'";
                            String q4="Update statement SET pin='"+newPin+"' where account ='"+p_accountno+"'AND pin ='"+currentPin+"'";
                            c1.s.executeUpdate(q1);
                            c1.s.executeUpdate(q2);
                            c1.s.executeUpdate(q3);
                            c1.s.executeUpdate(q4);
                            JOptionPane.showMessageDialog(null,"Pin Changed Successfully");
                            pinChangeLW.window.setVisible(false);
                            new Transaction();
                            c1.s.close();
                        }
                    }catch (Exception e1){
                        System.out.println(e1.getMessage());
                    }

                }

        }

    }

    private String toString(char[] c) {
        return new String(c);
    }
}
