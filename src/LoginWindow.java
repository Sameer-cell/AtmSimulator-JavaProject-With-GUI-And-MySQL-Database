import javax.swing.*;
import java.awt.*;

public class LoginWindow {
    JFrame window;

    public void loginWindow(){
        window=new JFrame();
        window.setSize(800,750);
        window.setLayout(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocation(400,20);
        window.getContentPane().setBackground(new Color(51, 255, 247));
        window.setVisible(true);
    }

}
