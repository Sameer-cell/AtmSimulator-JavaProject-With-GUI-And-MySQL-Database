import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 implements ActionListener {
    LoginWindow signup2LW=new LoginWindow();
    Labels signup2Labels=new Labels();
    TextField signup2TextField=new TextField();
    ComboBox signup2ComboBox=new ComboBox();
    Buttons signup2Buttons=new Buttons();
    String fno=Signup.formNumber;

    public Signup2(){
        signup2LW.loginWindow();
        signup2LW.window.setTitle("SignUp Form Page : 2 ");


        setRadioButtons();
        setButtons();

        String [] Religion={"Hindu","Muslim","Jewish","Christian","Other"};
        signup2ComboBox.c1=new JComboBox(Religion);
        signup2ComboBox.c1.setBackground(new Color(51, 255, 247));
        signup2LW.window.add(signup2ComboBox.c1);

        String [] Category={"General","OC","BC","SC","ST","Other"};
        signup2ComboBox.c2=new JComboBox(Category);
        signup2ComboBox.c2.setBackground(new Color(51, 255, 247));
        signup2LW.window.add(signup2ComboBox.c2);

        String [] Income={"Null","<100000","<500000","<1000000","<200000","<300000"};
        signup2ComboBox.c3=new JComboBox(Income);
        signup2ComboBox.c3.setBackground(new Color(51, 255, 247));
        signup2LW.window.add(signup2ComboBox.c3);

        String [] education={"Graduate","12th","10th","Post Graduate","PHD","Other"};
        signup2ComboBox.c4=new JComboBox(education);
        signup2ComboBox.c4.setBackground(new Color(51, 255, 247));
        signup2LW.window.add(signup2ComboBox.c4);

        String [] occupation={"Employed","Business","Self Employed","Retired","Other"};
        signup2ComboBox.c5=new JComboBox(occupation);
        signup2ComboBox.c5.setBackground(new Color(51, 255, 247));
        signup2LW.window.add(signup2ComboBox.c5);


        signup2ComboBox.c1.setBounds(300,120,400,30);
        signup2ComboBox.c2.setBounds(300,173,400,30);
        signup2ComboBox.c3.setBounds(300,220,400,30);
        signup2ComboBox.c4.setBounds(300,280,400,30);
        signup2ComboBox.c5.setBounds(300,340,400,30);

        signup2LW.window.add(signup2ComboBox.c1);
        signup2LW.window.add(signup2ComboBox.c2);
        signup2LW.window.add(signup2ComboBox.c3);
        signup2LW.window.add(signup2ComboBox.c4);
        signup2LW.window.add(signup2ComboBox.c5);


        signup2Labels.jl1.setText("Page 2: Personal Details:");
        signup2Labels.jl2.setText("Religion:");
        signup2Labels.jl3.setText("Category:");
        signup2Labels.jl4.setText("Income:");
        signup2Labels.jl5.setText("Educational");
        signup2Labels.jl6.setText("Occupation:");
        signup2Labels.jl7.setText("PAN Number:");
        signup2Labels.jl8.setText("Aadhaar Number:");
        signup2Labels.jl9.setText("Senior Citizen:");
        signup2Labels.jl10.setText("Existing Account:");
        signup2Labels.jl11.setText("Qualification:");
        signup2Labels.jl12.setText("Form no:");

        signup2LW.window.add(signup2Labels.jl1);
        signup2LW.window.add(signup2Labels.jl2);
        signup2LW.window.add(signup2Labels.jl3);
        signup2LW.window.add(signup2Labels.jl4);
        signup2LW.window.add(signup2Labels.jl5);
        signup2LW.window.add(signup2Labels.jl6);
        signup2LW.window.add(signup2Labels.jl7);
        signup2LW.window.add(signup2Labels.jl8);
        signup2LW.window.add(signup2Labels.jl9);
        signup2LW.window.add(signup2Labels.jl10);
        signup2LW.window.add(signup2Labels.jl11);
        signup2LW.window.add(signup2Labels.jl12);
        setSignup2Labels();

        signup2TextField.jt1.setColumns(15);
        signup2TextField.jt2.setColumns(16);
        signup2TextField.jt3.setColumns(17);

        signup2LW.window.add(signup2TextField.jt1);
        signup2LW.window.add(signup2TextField.jt2);
        signup2LW.window.add(signup2TextField.jt3);
        setSignup2TextField();

        signup2Buttons.jb1.addActionListener(this);
        signup2Buttons.jb1.setActionCommand("Next");

    }

    public void setButtons(){
        signup2Buttons.jb1.setText("Next");
        signup2Buttons.jb1.setBounds(620,660,80,30);
        signup2LW.window.add(signup2Buttons.jb1);
        signup2Buttons.jb1.setBackground(Color.BLACK);
        signup2Buttons.jb1.setForeground(Color.WHITE);

    }

    public void setSignup2Labels(){
        signup2Labels.jl12.setBounds(600,10,100,28);
        signup2Labels.jl1.setBounds(230,45,600,40);
        signup2Labels.jl2.setBounds(100,120,100,28);
        signup2Labels.jl3.setBounds(100,170,100,28);
        signup2Labels.jl4.setBounds(100,220,100,28);
        signup2Labels.jl5.setBounds(100,270,150,28);
        signup2Labels.jl11.setBounds(100,290,150,28);
        signup2Labels.jl6.setBounds(100,340,150,28);
        signup2Labels.jl7.setBounds(100,390,150,28);
        signup2Labels.jl8.setBounds(100,440,180,28);
        signup2Labels.jl9.setBounds(100,490,150,28);
        signup2Labels.jl10.setBounds(100,540,180,28);


        signup2Labels.jl1.setFont(new Font("Arial", Font.BOLD, 30));
        signup2Labels.jl2.setFont(new Font("Arial", Font.BOLD, 22));
        signup2Labels.jl3.setFont(new Font("Arial", Font.BOLD, 20));
        signup2Labels.jl4.setFont(new Font("Arial", Font.BOLD, 20));
        signup2Labels.jl5.setFont(new Font("Arial", Font.BOLD, 20));
        signup2Labels.jl6.setFont(new Font("Arial", Font.BOLD, 20));
        signup2Labels.jl7.setFont(new Font("Arial", Font.BOLD, 20));
        signup2Labels.jl8.setFont(new Font("Arial", Font.BOLD, 20));
        signup2Labels.jl9.setFont(new Font("Arial", Font.BOLD, 20));
        signup2Labels.jl10.setFont(new Font("Arial", Font.BOLD, 20));
        signup2Labels.jl11.setFont(new Font("Arial", Font.BOLD, 20));
        signup2Labels.jl12.setFont(new Font("Arial", Font.BOLD, 18));

    }

    public void setSignup2TextField(){
        signup2TextField.jt2.setBounds(300,393,400,30);
        signup2TextField.jt1.setBounds(300,440,400,30);
        signup2TextField.jt3.setBounds(680,10,100,30);
        signup2TextField.jt1.setFont(new Font("Arial", Font.BOLD, 14));
        signup2TextField.jt2.setFont(new Font("Arial", Font.BOLD, 14));
        signup2TextField.jt3.setFont(new Font("Arial", Font.BOLD, 14));

    }

    public void setRadioButtons(){
        signup2TextField.jr1.setText("Yes");
        signup2TextField.jr2.setText("No");
        signup2TextField.jr3.setText("Yes");
        signup2TextField.jr4.setText("No");

        signup2TextField.jr1.setFont(new Font("Railway", Font.BOLD, 14));
        signup2TextField.jr1.setBackground(new Color(51, 255, 247));

        signup2TextField.jr2.setFont(new Font("Railway", Font.BOLD, 14));
        signup2TextField.jr2.setBackground(new Color(51, 255, 247));

        signup2TextField.jr3.setFont(new Font("Railway", Font.BOLD, 14));
        signup2TextField.jr3.setBackground(new Color(51, 255, 247));

        signup2TextField.jr4.setFont(new Font("Railway", Font.BOLD, 14));
        signup2TextField.jr4.setBackground(new Color(51, 255, 247));

        signup2TextField.jr1.setBounds(350,492,100,30);
        signup2TextField.jr2.setBounds(460,492,100,30);
        signup2TextField.jr3.setBounds(350,542,100,30);
        signup2TextField.jr4.setBounds(460,542,100,30);

        signup2LW.window.add(signup2TextField.jr1);
        signup2LW.window.add(signup2TextField.jr2);
        signup2LW.window.add(signup2TextField.jr3);
        signup2LW.window.add(signup2TextField.jr4);

    }
    public static void main(String[] args){
        new Signup2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        if(command == "Next"){
            if(signup2TextField.jt1.getText().equals("") ||
                    signup2TextField.jt2.getText().equals("") || signup2TextField.jt3.getText().equals("") ||
                    (signup2TextField.jr1.isSelected() && signup2TextField.jr2.isSelected()) ||
                    (signup2TextField.jr3.isSelected() && signup2TextField.jr4.isSelected())){
                JOptionPane.showMessageDialog(null,"Fill all the details correctly");
            }else if(signup2TextField.jt3.getText().length()>=5 || signup2TextField.jt1.getText().length()>=13 || signup2TextField.jt1.getText().length()<12 ){
                JOptionPane.showMessageDialog(null,"Fill the form no and aadhar no correctly");
            }else if(!signup2TextField.jt3.getText().equals(String.valueOf(fno))){
                System.out.println(fno);
                JOptionPane.showMessageDialog(null,"Fill the form no correctly");
            } else {
                String religion=(String)signup2ComboBox.c1.getSelectedItem();
                String category=(String)signup2ComboBox.c2.getSelectedItem();
                String income=(String)signup2ComboBox.c3.getSelectedItem();
                String education=(String)signup2ComboBox.c4.getSelectedItem();
                String occupation=(String)signup2ComboBox.c5.getSelectedItem();
                String pan=signup2TextField.jt2.getText();
                String adhar=signup2TextField.jt1.getText();
                String seniorCitizen;
                if(signup2TextField.jr1.isSelected()){
                    seniorCitizen="Yes";
                }else {
                    seniorCitizen="No";
                }
                String existingAccount;
                if(signup2TextField.jr3.isSelected()){
                    existingAccount="Yes";
                }else {
                    existingAccount="No";
                }
                String form=signup2TextField.jt3.getText();
                try{
                    Connector c1=new Connector();
                    String q="insert into signup2 values('"+form+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+
                            occupation+"','"+pan+"','"+adhar+"','"+seniorCitizen+"','"+existingAccount+"')";
                    c1.s.executeUpdate(q);
                    signup2LW.window.setVisible(false);
                    new Signup3();
                }catch (Exception e1){
                    System.out.println(e1.getMessage());
                }

            }
        }
    }
}
