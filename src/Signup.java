import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Signup implements ActionListener {

    LoginWindow signupLoginWindow=new LoginWindow();
    Labels signupLabels=new Labels();
    TextField signupTextField=new TextField();
    ComboBox signupComboBox=new ComboBox();
    Buttons signupButton=new Buttons();
    ButtonGroup buttonGroup=new ButtonGroup();
    ButtonGroup buttonGroup2=new ButtonGroup();

    String x="";
    public static String formNumber;



    public Signup(){
        Connector c1=new Connector();
        try{
            String q="Select count(*) from signup";
            ResultSet rs=c1.s.executeQuery(q);
            int count=1;
            if(rs.next()){
                count=count+Integer.parseInt(rs.getString("count(*)"));
            }
            x=x+count;
            c1.s.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try{
                c1.c.close();
                c1.s.close();
            }catch (Exception e5){
                System.out.println(e5.getMessage());
            }
        }

        signupLoginWindow.loginWindow();
        signupLoginWindow.window.setTitle("SignUp Form");

        setSignupButton();

        String []date = {"1","2","3","4","5","6","7","8","9","10","11","12",
                "13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        signupComboBox.c1 = new JComboBox(date);
        signupComboBox.c1.setBackground(new Color(51, 255, 247));
        signupLoginWindow.window.add(signupComboBox.c1);

        String []month = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        signupComboBox.c2 = new JComboBox(month);
        signupComboBox.c2.setBackground(new Color(51, 255, 247));
        signupLoginWindow.window.add(signupComboBox.c2);

        String []year = {"1981","1982","1983","1984","1985","1986","1987","1988","1989",
                "1990","1991","1992","1993","1994","1995","1996",
                "1997","1998","1999","2000","2001","2002"};
        signupComboBox.c3 = new JComboBox(year);
        signupComboBox.c3.setBackground(new Color(51, 255, 247));
        signupLoginWindow.window.add(signupComboBox.c3);
        signupComboBox.c1.setBounds(340,240,60,30);
        signupComboBox.c2.setBounds(460,240,100,30);
        signupComboBox.c3.setBounds(610,240,90,30);


        signupLabels.jl1.setText("APPLICATION FORM NO."+x);
        signupLabels.jl2.setText("Page 1: Personal Details:");
        signupLabels.jl3.setText("Name:");
        signupLabels.jl4.setText("Father`s Name:");
        signupLabels.jl5.setText("Date Of Birth:");
        signupLabels.jl6.setText("Gender:");
        signupLabels.jl7.setText("Email Address:");
        signupLabels.jl8.setText("Marital Status:");
        signupLabels.jl9.setText("Address:");
        signupLabels.jl10.setText("City:");
        signupLabels.jl11.setText("Pin Code:");
        signupLabels.jl12.setText("State:");
        signupLabels.jl13.setText("Date:");
        signupLabels.jl14.setText("Month:");
        signupLabels.jl15.setText("Year:");

        signupLoginWindow.window.add(signupLabels.jl1);
        signupLoginWindow.window.add(signupLabels.jl2);
        signupLoginWindow.window.add(signupLabels.jl3);
        signupLoginWindow.window.add(signupLabels.jl4);
        signupLoginWindow.window.add(signupLabels.jl5);
        signupLoginWindow.window.add(signupLabels.jl6);
        signupLoginWindow.window.add(signupLabels.jl7);
        signupLoginWindow.window.add(signupLabels.jl8);
        signupLoginWindow.window.add(signupLabels.jl9);
        signupLoginWindow.window.add(signupLabels.jl10);
        signupLoginWindow.window.add(signupLabels.jl11);
        signupLoginWindow.window.add(signupLabels.jl12);
        signupLoginWindow.window.add(signupLabels.jl13);
        signupLoginWindow.window.add(signupLabels.jl14);
        signupLoginWindow.window.add(signupLabels.jl15);
        setSignupLabels();

        signupLoginWindow.window.add(signupTextField.jt1);
        signupLoginWindow.window.add(signupTextField.jt2);
        signupLoginWindow.window.add(signupTextField.jt3);
        signupLoginWindow.window.add(signupTextField.jt4);
        signupLoginWindow.window.add(signupTextField.jt5);
        signupLoginWindow.window.add(signupTextField.jt6);
        signupLoginWindow.window.add(signupTextField.jt7);
        setSignupTextField();

        signupTextField.jr1.setText("Male");
        signupTextField.jr2.setText("Female");
        signupTextField.jr3.setText("Married");
        signupTextField.jr4.setText("Unmarried");

        signupLoginWindow.window.add(signupTextField.jr1);
        signupLoginWindow.window.add(signupTextField.jr2);
        signupLoginWindow.window.add(signupTextField.jr3);
        signupLoginWindow.window.add(signupTextField.jr4);
        signupLoginWindow.window.add(signupTextField.jr5);
        setRadioButtons();

        signupButton.jb1.addActionListener(this);
        signupButton.jb1.setActionCommand("Next");
    }

    public void setSignupButton(){
        signupButton.jb1.setText("Next");
        signupButton.jb1.setBounds(620,660,80,30);
        signupLoginWindow.window.add(signupButton.jb1);
        signupButton.jb1.setBackground(Color.BLACK);
        signupButton.jb1.setForeground(Color.WHITE);
        signupButton.jb1.setFont(new Font("Arial", Font.BOLD, 18));

    }

    public void setSignupLabels(){

        signupLabels.jl1.setBounds(140,20,600,40);
        signupLabels.jl2.setBounds(290,70,600,30);
        signupLabels.jl3.setBounds(100,140,100,30);
        signupLabels.jl4.setBounds(100,190,200,30);
        signupLabels.jl5.setBounds(100,240,200,30);
        signupLabels.jl13.setBounds(300,240,40,30);
        signupLabels.jl14.setBounds(410,240,50,30);
        signupLabels.jl15.setBounds(570,240,40,30);
        signupLabels.jl6.setBounds(100,290,200,30);
        signupLabels.jl7.setBounds(100,340,200,30);
        signupLabels.jl8.setBounds(100,390,200,30);
        signupLabels.jl9.setBounds(100,440,200,30);
        signupLabels.jl10.setBounds(100,490,200,30);
        signupLabels.jl11.setBounds(100,540,200,30);
        signupLabels.jl12.setBounds(100,590,200,30);

        signupLabels.jl1.setFont(new Font("Arial", Font.BOLD, 38));
        signupLabels.jl2.setFont(new Font("Arial", Font.BOLD, 22));
        signupLabels.jl3.setFont(new Font("Arial", Font.BOLD, 20));
        signupLabels.jl4.setFont(new Font("Arial", Font.BOLD, 20));
        signupLabels.jl5.setFont(new Font("Arial", Font.BOLD, 20));
        signupLabels.jl6.setFont(new Font("Arial", Font.BOLD, 20));
        signupLabels.jl7.setFont(new Font("Arial", Font.BOLD, 20));
        signupLabels.jl8.setFont(new Font("Arial", Font.BOLD, 20));
        signupLabels.jl9.setFont(new Font("Arial", Font.BOLD, 20));
        signupLabels.jl10.setFont(new Font("Arial", Font.BOLD, 20));
        signupLabels.jl11.setFont(new Font("Arial", Font.BOLD, 20));
        signupLabels.jl12.setFont(new Font("Arial", Font.BOLD, 20));
        signupLabels.jl13.setFont(new Font("Arial", Font.BOLD, 14));
        signupLabels.jl14.setFont(new Font("Arial", Font.BOLD, 14));
        signupLabels.jl15.setFont(new Font("Arial", Font.BOLD, 14));

    }

    public void setSignupTextField(){
        signupTextField.jt1.setFont(new Font("Arial", Font.BOLD, 14));
        signupTextField.jt2.setFont(new Font("Arial", Font.BOLD, 14));
        signupTextField.jt3.setFont(new Font("Arial", Font.BOLD, 14));
        signupTextField.jt4.setFont(new Font("Arial", Font.BOLD, 14));
        signupTextField.jt5.setFont(new Font("Arial", Font.BOLD, 14));
        signupTextField.jt6.setFont(new Font("Arial", Font.BOLD, 14));
        signupTextField.jt7.setFont(new Font("Arial", Font.BOLD, 14));

        signupTextField.jt1.setBounds(300,140,400,30);
        signupTextField.jt2.setBounds(300,190,400,30);
        signupTextField.jt3.setBounds(300,340,400,30);
        signupTextField.jt4.setBounds(300,440,400,30);
        signupTextField.jt5.setBounds(300,490,400,30);
        signupTextField.jt6.setBounds(300,540,400,30);
        signupTextField.jt7.setBounds(300,590,400,30);

    }

    public void setRadioButtons(){

        signupTextField.jr1.setFont(new Font("Railway", Font.BOLD, 14));
        signupTextField.jr1.setBackground(new Color(51, 255, 247));

        signupTextField.jr2.setFont(new Font("Railway", Font.BOLD, 14));
        signupTextField.jr2.setBackground(new Color(51, 255, 247));

        signupTextField.jr3.setFont(new Font("Railway", Font.BOLD, 14));
        signupTextField.jr3.setBackground(new Color(51, 255, 247));

        signupTextField.jr4.setFont(new Font("Railway", Font.BOLD, 14));
        signupTextField.jr4.setBackground(new Color(51, 255, 247));


        signupTextField.jr1.setBounds(300,290,60,30);
        signupTextField.jr2.setBounds(450,290,90,30);
        signupTextField.jr3.setBounds(300,390,100,30);
        signupTextField.jr4.setBounds(450,390,100,30);


        buttonGroup.add(signupTextField.jr1);
        buttonGroup.add(signupTextField.jr2);

        buttonGroup2.add(signupTextField.jr3);
        buttonGroup2.add(signupTextField.jr4);

    }

    public static void main(String[] args){
        new Signup();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String  command=e.getActionCommand();
        if(command.equals("Next")){
            formNumber=x;
                String name=signupTextField.jt1.getText();
                String fathersName=signupTextField.jt2.getText();
                String date=(String) signupComboBox.c1.getSelectedItem();
                String month=(String) signupComboBox.c2.getSelectedItem();
                String year=(String) signupComboBox.c3.getSelectedItem();
                String gender;
                if(signupTextField.jr1.isSelected()){
                    gender="Male";
                }else {
                    gender="Female";
                }
                String email=signupTextField.jt3.getText();
                String maritalStatus;
                if(signupTextField.jr3.isSelected()){
                    maritalStatus="Married";
                }else{
                    maritalStatus="UnMarried";
                }
                String address=signupTextField.jt4.getText();
                String city=signupTextField.jt5.getText();
                String pin_code=signupTextField.jt6.getText();
                String state=signupTextField.jt7.getText();
            Connector c1=new Connector();
                try{
                    if(signupTextField.jt1.getText().equals("") || signupTextField.jt2.getText().equals("") ||
                            signupTextField.jt3.getText().equals("") || signupTextField.jt4.getText().equals("") ||
                            signupTextField.jt5.getText().equals("") || signupTextField.jt6.getText().equals("") ||
                            signupTextField.jt7.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Fill all the details correctly");
                    }else if(!signupTextField.jr1.isSelected() && !signupTextField.jr2.isSelected()){
                        JOptionPane.showMessageDialog(null,"Fill all the details correctly");
                    }else if(!signupTextField.jr3.isSelected() && !signupTextField.jr4.isSelected()){
                        JOptionPane.showMessageDialog(null,"Fill all the details correctly");
                    } else{
                        String q="insert into signup (name,fname,date,month,year,gender,email, marital,address,city,pincode,state,formno) values ('"
                                +name+"','"
                                +fathersName+"','"+date+"','"+month+"','"+year+"','"
                                +gender+"','"+email+"','"+maritalStatus+"','"
                                +address+"','"+city+"','"+pin_code+"','"+state+"','"+x+"')";
                        c1.s.executeUpdate(q);
                        signupLoginWindow.window.setVisible(false);
                        new Signup2();
                    }
                }catch (Exception e1){
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
