package standaloneApp.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import standaloneApp.backend.service.LoginService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class GUI implements ActionListener {
    JFrame f = new JFrame();
    JButton login;
    JTextField loginField;
    JPasswordField passwordField;

    @Autowired
    private LoginService loginService;

    void loginPage()
    {
        f.setLayout(null);
        JLabel title = new JLabel("Library Management");
        title.setSize(1000, 200);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, Math.min(30, title.getHeight())));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setLocation((f.getWidth()-title.getWidth())/2, 50);
        JLabel loginLabel = new JLabel("Login ID", SwingConstants.CENTER);
        loginLabel.setSize(100, 30);
        JLabel passwordLabel = new JLabel("Password", SwingConstants.CENTER);
        passwordLabel.setSize(100, 30);
        loginField = new JTextField();
        loginField.setSize(300, 30);
        int x = (f.getWidth()-loginField.getWidth())/2;
        loginField.setLocation(x, 300);
        loginLabel.setLocation((x-100), 300);
        passwordField = new JPasswordField();
        passwordField.setSize(300, 30);
        x = (f.getWidth()-passwordField.getWidth())/2;
        passwordField.setLocation(x,400);
        passwordLabel.setLocation((x-100), 400);
        login = new JButton("Login");
        login.setSize(250,30);
        login.setLocation((f.getWidth()-login.getWidth())/2, 500);
        login.addActionListener(this);
        f.add(title);
        f.add(loginLabel);
        f.add(loginField);
        f.add(passwordLabel);
        f.add(passwordField);
        f.add(login);
        f.setVisible(true);
    }


    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == login){
            if(loginService.checkCredentials(loginField.getText(), new String(passwordField.getPassword()))){
                f.getContentPane().removeAll();
                f.revalidate();
                f.repaint();
                mainPage();
            }
            else{
                JOptionPane.showMessageDialog(f, "Invalid Username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private void mainPage(){
        JLabel title = new JLabel("Main Page");
        title.setSize(1000, 200);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, Math.min(30, title.getHeight())));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setLocation((f.getWidth()-title.getWidth())/2, 50);
        f.add(title);
        f.setVisible(true);
    }

    public GUI()
    {
        try
        {
            f.setSize(1920,1080);
            f.setResizable(true);
            f.setExtendedState(JFrame.MAXIMIZED_BOTH);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginPage();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
