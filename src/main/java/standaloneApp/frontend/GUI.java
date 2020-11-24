package standaloneApp.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import standaloneApp.backend.entity.Inventory;
import standaloneApp.backend.entity.UserInfo;
import standaloneApp.backend.service.LibrarianService;
import standaloneApp.backend.service.LoginService;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

@Component
public class GUI implements ActionListener {
    JFrame f = new JFrame();
    JFrame librarian, searchResults;
    JButton login, loginSelect, searchButton, issueBook, returnBook, addBook, addMultipleBook, addUser, addMultipleUser, showUserDetails, issuedBook, returnedBook, addedBook, addedUser, logout;
    JTextField loginField, searchBox, regId, bookId, bookName, authorName, numberOfCopies, userName;
    JPasswordField passwordField;
    JComboBox searchMenu, accessLevel;
    String[] access = {"Admin", "Teacher", "Student"};
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
        int x = f.getWidth()/3;
        issueBook.setSize(300, 30);
        issueBook.setLocation(x-150, 350);
        issueBook.addActionListener(this);

        returnBook = new JButton("Return Book");
        returnBook.setSize(300,30);
        returnBook.setLocation((x*2)-150, 350);
        returnBook.addActionListener(this);

        addBook = new JButton("Add Book");
        addBook.setSize(300,30);
        addBook.setLocation(x-150, 550);
        addBook.addActionListener(this);

        addMultipleBook = new JButton("Add Multiple Books");
        addMultipleBook.setSize(300,30);
        addMultipleBook.setLocation((x*2)-150, 550);
        addMultipleBook.addActionListener(this);

        addUser = new JButton("Add User");
        x = f.getWidth()/4;
        addUser.setSize(300,30);
        addUser.setLocation(x-150, 750);
        addUser.addActionListener(this);

        addMultipleUser = new JButton("Add Multiple Users");
        addMultipleUser.setSize(300,30);
        addMultipleUser.setLocation((x*2)-150, 750);
        addMultipleUser.addActionListener(this);

        showUserDetails = new JButton("Show User Details");
        showUserDetails.setSize(300,30);
        showUserDetails.setLocation((x*3)-150, 750);
        showUserDetails.addActionListener(this);

        logout = new JButton("Logout");
        logout.setSize(200,30);
        logout.setLocation(f.getWidth()-300, 60);
        logout.addActionListener(this);

        f.add(issueBook);
        f.add(returnBook);
        f.add(addBook);
        f.add(addMultipleBook);
        f.add(addUser);
        f.add(addMultipleUser);
        f.add(showUserDetails);
        f.add(logout);
        f.setVisible(true);
    }

    public void issueBookPage(){

        librarian = new JFrame();
        librarian.setSize(800,600);
        librarian.setLayout(null);

        JLabel regIdLabel = new JLabel("Reg. ID", SwingConstants.CENTER);
        JLabel bookIdLabel = new JLabel("Book ID", SwingConstants.CENTER);

        regId = new JTextField();
        regId.setSize(300, 30);
        int x = (librarian.getWidth()-regId.getWidth())/2;
        regId.setLocation(x, 100);
        regIdLabel.setSize(100,30);
        regIdLabel.setLocation((x-100), 100);

        bookId = new JTextField();
        bookId.setSize(300, 30);
        x = (librarian.getWidth()-bookId.getWidth())/2;
        bookId.setLocation(x,200);
        bookIdLabel.setSize(100,30);
        bookIdLabel.setLocation((x-100), 200);

        issuedBook = new JButton("Issue Book");
        issuedBook.setSize(250,30);
        issuedBook.setLocation((librarian.getWidth()-issuedBook.getWidth())/2, 300);
        issuedBook.addActionListener(this);

        librarian.add(regId);
        librarian.add(bookId);
        librarian.add(issuedBook);
        librarian.add(regIdLabel);
        librarian.add(bookIdLabel);
        librarian.setVisible(true);

    }

    public void returnBookPage(){
        librarian = new JFrame();
        librarian.setSize(800,600);
        librarian.setLayout(null);

        JLabel regIdLabel = new JLabel("Reg. ID", SwingConstants.CENTER);
        JLabel bookIdLabel = new JLabel("Book ID", SwingConstants.CENTER);

        regId = new JTextField();
        regId.setSize(300, 30);
        int x = (librarian.getWidth()-regId.getWidth())/2;
        regId.setLocation(x, 100);
        regIdLabel.setSize(100,30);
        regIdLabel.setLocation((x-100), 100);

        bookId = new JTextField();
        bookId.setSize(300, 30);
        x = (librarian.getWidth()-bookId.getWidth())/2;
        bookId.setLocation(x,200);
        bookIdLabel.setSize(100,30);
        bookIdLabel.setLocation((x-100), 200);

        returnedBook = new JButton("Return Book");
        returnedBook.setSize(250,30);
        returnedBook.setLocation((librarian.getWidth()-returnedBook.getWidth())/2, 300);
        returnedBook.addActionListener(this);

        librarian.add(regId);
        librarian.add(bookId);
        librarian.add(returnedBook);
        librarian.add(regIdLabel);
        librarian.add(bookIdLabel);
        librarian.setVisible(true);

    }

    public void addBookPage(){
        System.out.println("Add Book");
        librarian = new JFrame();
        librarian.setSize(800,600);
        librarian.setLayout(null);

        JLabel bookNameLabel = new JLabel("Book Name", SwingConstants.CENTER);
        JLabel bookIdLabel = new JLabel("Book ID", SwingConstants.CENTER);
        JLabel authorNameLabel = new JLabel("Author Name", SwingConstants.CENTER);
        JLabel numberOfCopiesLabel = new JLabel("No of Copies", SwingConstants.CENTER);

        bookId = new JTextField();
        bookId.setSize(300, 30);
        int x = (librarian.getWidth()-bookId.getWidth())/2;
        bookId.setLocation(x,100);
        bookIdLabel.setSize(100,30);
        bookIdLabel.setLocation((x-100), 100);

        bookName = new JTextField();
        bookName.setSize(300, 30);
        x = (librarian.getWidth()-bookName.getWidth())/2;
        bookName.setLocation(x, 200);
        bookNameLabel.setSize(100,30);
        bookNameLabel.setLocation((x-100), 200);

        authorName = new JTextField();
        authorName.setSize(300, 30);
        x = (librarian.getWidth()-authorName.getWidth())/2;
        authorName.setLocation(x, 300);
        authorNameLabel.setSize(100,30);
        authorNameLabel.setLocation((x-100), 300);

        numberOfCopies = new JTextField();
        numberOfCopies.setSize(300, 30);
        x = (librarian.getWidth()-numberOfCopies.getWidth())/2;
        numberOfCopies.setLocation(x, 400);
        numberOfCopiesLabel.setSize(100,30);
        numberOfCopiesLabel.setLocation((x-100), 400);

        addedBook = new JButton("Add Book");
        addedBook.setSize(250,30);
        addedBook.setLocation((librarian.getWidth()-addedBook.getWidth())/2, 500);
        addedBook.addActionListener(this);

        librarian.add(bookId);
        librarian.add(bookIdLabel);
        librarian.add(bookName);
        librarian.add(bookNameLabel);
        librarian.add(authorName);
        librarian.add(authorNameLabel);
        librarian.add(numberOfCopies);
        librarian.add(numberOfCopiesLabel);
        librarian.add(addedBook);
        librarian.setVisible(true);

    }

    public void addMultipleBookPage(){
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView());

        j.showSaveDialog(null);
        String message = librarianService.addBooksFromFile(j.getSelectedFile().getAbsolutePath());
        JOptionPane.showMessageDialog(f, message, "Result", JOptionPane.INFORMATION_MESSAGE);
    }

    public void addUserPage(){
        librarian = new JFrame();
        librarian.setSize(800,600);
        librarian.setLayout(null);

        JLabel regIdLabel = new JLabel("Reg. ID", SwingConstants.CENTER);
        JLabel userNameLabel = new JLabel("Name", SwingConstants.CENTER);
        JLabel accessLevelLabel = new JLabel("Access Level", SwingConstants.CENTER);

        regId = new JTextField();
        regId.setSize(300, 30);
        int x = (librarian.getWidth()-regId.getWidth())/2;
        regId.setLocation(x, 100);
        regIdLabel.setSize(100,30);
        regIdLabel.setLocation((x-100), 100);

        userName = new JTextField();
        userName.setSize(300, 30);
        x = (librarian.getWidth()-userName.getWidth())/2;
        userName.setLocation(x, 200);
        userNameLabel.setSize(100,30);
        userNameLabel.setLocation((x-100), 200);


        accessLevel = new JComboBox(access);
        accessLevel.setSize(300, 30);
        x = (librarian.getWidth()-accessLevel.getWidth())/2;
        accessLevel.setLocation(x, 300);
        accessLevelLabel.setSize(100,30);
        accessLevelLabel.setLocation((x-100), 300);

        addedUser = new JButton("Add User");
        addedUser.setSize(250,30);
        addedUser.setLocation((librarian.getWidth()-addedUser.getWidth())/2, 400);
        addedUser.addActionListener(this);

        librarian.add(regId);
        librarian.add(regIdLabel);
        librarian.add(userName);
        librarian.add(userNameLabel);
        librarian.add(accessLevel);
        librarian.add(accessLevelLabel);
        librarian.add(addedUser);
        librarian.setVisible(true);
    }

    public void addMultipleUserPage(){
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView());

        j.showSaveDialog(null);
        String msg = librarianService.addMultipleUserFromFile(j.getSelectedFile().getAbsolutePath());
        JOptionPane.showMessageDialog(f, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showUserDetailsPage(){
        String regId = JOptionPane.showInputDialog(f,"Enter Reg. ID", "Registration ID", JOptionPane.QUESTION_MESSAGE);
        UserInfo userInfo = librarianService.showUserDetails(regId);
        String info = "Reg. ID : " + userInfo.getRegId() + "\nName : " + userInfo.getName() + "\nAccess Level : " + access[userInfo.getAccessLevel()-1];
        JOptionPane.showMessageDialog(f, info, "User Details", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showSearchResults(List<Inventory> ret){
        if(ret.size() == 0){
            JOptionPane.showMessageDialog(f, "No Books found", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            String[][] data = new String[ret.size()+1][4];
            data[0][0] = "ID";
            data[0][1] = "Book Name";
            data[0][2] = "Author Name";
            data[0][3] = "Available Number of Copies";
            for(int i=1; i<=ret.size(); i++){
                Inventory d = ret.get(i);
                data[i][0] = d.getBookId();
                data[i][1] = d.getBookName();
                data[i][2] = d.getAuthorName();
                data[i][3] = Integer.toString(d.getAvailableCopies());
            }
            String[] columns = {"Book ID", "Book Name", "Author Name", "Available Copies"};

            searchResults = new JFrame();
            searchResults.setSize(800,600);
            searchResults.setLayout(null);

            JTable table = new JTable(data, columns);
            table.setBounds(20, 20, 760, 560);
            table.getColumnModel().getColumn(0).setPreferredWidth(40);
            table.getColumnModel().getColumn(1).setPreferredWidth(350);
            table.getColumnModel().getColumn(2).setPreferredWidth(350);
            table.getColumnModel().getColumn(3).setPreferredWidth(20);

            JScrollPane sp=new JScrollPane(table);
            searchResults.add(sp);
            searchResults.add(table);
            searchResults.setVisible(true);
        }
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
                List<Inventory> ret = new ArrayList<>();
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
                showSearchResults(ret);
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
        if(e.getSource() == issueBook){
            issueBookPage();
        }
        if(e.getSource() == returnBook){
            returnBookPage();
        }
        if(e.getSource() == addBook){
            addBookPage();
        }
        if(e.getSource() == addMultipleBook){
            addMultipleBookPage();
        }
        if(e.getSource() == addUser){
            addUserPage();
        }
        if(e.getSource() == addMultipleUser){
            addMultipleUserPage();
        }
        if(e.getSource() == showUserDetails){
            showUserDetailsPage();
        }
        if(e.getSource() == issuedBook) {

            String msg = librarianService.issueBook(regId.getText(),bookId.getText(),new java.util.Date().toString());
            JOptionPane.showMessageDialog(f, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
            librarian.dispose();
        }
        if(e.getSource() == returnedBook) {
            String msg = librarianService.returnBook(regId.getText(),bookId.getText(),new java.util.Date().toString());
            JOptionPane.showMessageDialog(f, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
            librarian.dispose();
        }
        if(e.getSource() == addedBook) {
            String msg = librarianService.addBook(bookId.getText(),bookName.getText(),authorName.getText(),Integer.valueOf(numberOfCopies.getText()));
            JOptionPane.showMessageDialog(f, msg, "Book Added", JOptionPane.INFORMATION_MESSAGE);
            librarian.dispose();
        }
        if(e.getSource() == addedUser) {
            String msg = librarianService.addUser(regId.getText(),userName.getText(),accessLevel.getSelectedIndex()+1);
            JOptionPane.showMessageDialog(f, msg, "User Added", JOptionPane.INFORMATION_MESSAGE);
            librarian.dispose();
        }
        if(e.getSource() == logout) {
            f.getContentPane().removeAll();
            f.revalidate();
            f.repaint();
            mainPage();
        }
    }

    public GUI(){
        try{
            f.setSize(1920,1080);
            f.setResizable(true);
            f.setExtendedState(JFrame.MAXIMIZED_BOTH);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainPage();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
