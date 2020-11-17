import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    JTable table;
    JScrollPane sp;
    DefaultTableModel model=new DefaultTableModel();
    String []heading={"Account no","Pin no","Deposit","Withdraw","Balance"};
//    String[][]data=new String[20][5];
//    int i=0,j=0;
    String number=Login.accountNumber;

    MiniStatement(){
        super("Mini Statement");
        setSize(700,300);
        setLocation(350,150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        model.setColumnIdentifiers(heading);
        table=new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        sp=new JScrollPane(table);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(sp);
        String account="";
        String pin="";
        String deposit="";
        String withdraw="";
        String balance="";
        try{
            Connector c1=new Connector();
          String q="select * from statement Where account ='"+number+"'";
            ResultSet rs=c1.s.executeQuery(q);
            while (rs.next()){
                account=rs.getString("account");
                pin=rs.getString("pin");
                deposit=rs.getString("deposit");
                withdraw=rs.getString("withdraw");
                balance=rs.getString("balance");
                model.addRow(new Object[]{account,pin,deposit,withdraw,balance});

//                data[i][j++]=rs.getString("account");
//                data[i][j++]=rs.getString("pin");
//                data[i][j++]=rs.getString("deposit");
//                data[i][j++]=rs.getString("withdraw");
//                data[i][j]=rs.getString("balance");
//                i++;
//                j=0;

            }
            setVisible(true);
//            table=new JTable(data,heading);
//            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//
//            sp=new JScrollPane(table);
//            sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//            sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//            add(sp);
//            setVisible(true);
        }catch (Exception e1){
            System.out.println(e1.getMessage());
            e1.printStackTrace();
        }
    }

    public static void main(String[] args){
        new MiniStatement();
    }
}
