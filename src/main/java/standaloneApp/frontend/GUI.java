package standaloneApp.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import standaloneApp.backend.entity.Inventory;
import standaloneApp.backend.service.LibrarianService;
import standaloneApp.backend.service.LoginService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@Component
public class GUI implements ActionListener {
    JFrame f = new JFrame();
    JButton login, loginSelect, searchButton, issueBook, returnBook, addBook, addMultipleBook, addUser, addMultipleUser, showUserDetails;
    JTextField loginField, searchBox;
    JPasswordField passwordField;
    JComboBox searchMenu;

    @Autowired
    private LoginService loginService;

    @Autowired
    private LibrarianService librarianService;

    void loginPage(){
        f.setLayout(null);
        JLabel title = new JLabel("Librarian Login");
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

    private void mainPage(){
        f.setLayout(null);

        JLabel title = new JLabel("Library Management");
        title.setSize(1000, 200);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, Math.min(30, title.getHeight())));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setLocation((f.getWidth()-title.getWidth())/2, 50);

        searchBox = new JTextField();
        searchBox.setSize(800, 30);
        int x = (f.getWidth()-searchBox.getWidth())/2;
        searchBox.setLocation(x-50, 250);
        searchButton = new JButton("Search");
        searchButton.setSize(250, 30);
        searchButton.setLocation(x+850, 250);
        searchButton.addActionListener(this);

        String menu[] = {"Search By Book ID", "Search By Title", "Search By Author"};
        searchMenu = new JComboBox(menu);
        searchMenu.setSize(170, 30);
        searchMenu.setLocation(x-250, 250);

        loginSelect = new JButton("Login");
        loginSelect.setSize(250, 30);
        loginSelect.setLocation(x+850, 100);
        loginSelect.addActionListener(this);

        f.add(title);
        f.add(loginSelect);
        f.add(searchMenu);
        f.add(searchBox);
        f.add(searchButton);
        f.setVisible(true);
    }

    private void librarianPage(){
        f.setLayout(null);
        issueBook = new JButton("Issue Book");
        int x = (f.getWidth()-250)*3/4;
        issueBook.setSize(250, 30);
        issueBook.setLocation(x, 150);

        returnBook = new JButton("Return Book");
        returnBook.setSize(250,30);
        returnBook.setLocation(x, 250);

        addBook = new JButton("Return Book");
        addBook.setSize(250,30);
        addBook.setLocation(x, 350);

        addMultipleBook = new JButton("Return Book");
        addMultipleBook.setSize(250,30);
        addMultipleBook.setLocation(x, 450);

        addUser = new JButton("Return Book");
        addUser.setSize(250,30);
        addUser.setLocation(x, 550);

        addMultipleUser = new JButton("Return Book");
        addMultipleUser.setSize(250,30);
        addMultipleUser.setLocation(x, 650);

        showUserDetails = new JButton("Show User Details");
        showUserDetails.setSize(250,30);
        showUserDetails.setLocation(x, 750);

        f.add(issueBook);
        f.add(returnBook);
        f.add(addBook);
        f.add(addMultipleBook);
        f.add(addUser);
        f.add(addMultipleUser);
        f.add(showUserDetails);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == searchButton){
            String searchParam = searchBox.getText();
            System.out.println(searchParam);
            if(searchParam.equals("")){
                JOptionPane.showMessageDialog(f, "Enter Valid Details", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                int searchCriteria = searchMenu.getSelectedIndex();
                List<Inventory> ret;
                switch (searchCriteria){
                    case 0:
                        ret = librarianService.searchByBookId(searchParam);
                        break;
                    case 1:
                        ret = librarianService.searchByTitle(searchParam);
                        break;
                    case 2:
                        ret = librarianService.searchByAuthor(searchParam);
                        break;
                }
            }
        }
        if(e.getSource() == login){
            if(loginService.checkCredentials(loginField.getText(), new String(passwordField.getPassword()))){
                f.getContentPane().removeAll();
                f.revalidate();
                f.repaint();
                librarianPage();
            }
            else{
                JOptionPane.showMessageDialog(f, "Invalid Username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource() == loginSelect){
            f.getContentPane().removeAll();
            f.revalidate();
            f.repaint();
            loginPage();
        }
    }

    public GUI(){
        try{
            f.setSize(1920,1080);
            f.setResizable(true);
            f.setExtendedState(JFrame.MAXIMIZED_BOTH);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            librarianPage();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
