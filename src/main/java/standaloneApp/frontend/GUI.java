package standaloneApp.frontend;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    int choice;
    JFrame f = new JFrame();
    JButton login,b1,b2,b3,b4,b5,b6,display;
    JButton back = new JButton("HOME PAGE");
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JTextField loginField;
    JPasswordField passwordField;
    JButton addb = new JButton("Add Data");
    JLabel j1,j2,j3,j4,j5,j6,j7;
    JComboBox jc;
    JTable table;
    String name;
    int rollno,age,maths,science,english,computer;

    void loginPage()
    {
        /*b1 = new JButton("Insert Data");
        b1.setBounds(50,100,400,30);
        f.add(b1);
        b1.addActionListener(this);
        b2 = new JButton("Display Marks of a subject");
        b2.setBounds(50,200, 400, 30);
        f.add(b2);
        b2.addActionListener(this);
        b3 = new JButton("Display Marks of all Students");
        b3.setBounds(50,300, 400, 30);
        f.add(b3);
        b3.addActionListener(this);
        b4 = new JButton("Display Marks of a Student");
        b4.setBounds(50,400, 400, 30);
        f.add(b4);
        b4.addActionListener(this);*/
        f.setLayout(null);
        loginField = new JTextField();
        loginField.setBounds(700,300,500,30);

        passwordField = new JPasswordField();
        passwordField.setBounds(700,400,500,30);
        login = new JButton("Login");
        login.setBounds(800,500,250,30);
        login.addActionListener(this);
        f.add(passwordField);
        f.add(loginField);
        f.add(login);
        f.setVisible(true);
    }


    public void actionPerformed(ActionEvent e)
    {

        f.getContentPane().removeAll();
        f.revalidate();
        f.repaint();

        if(e.getSource() == b1)
        {
            choice = 1;
            Insertpage();
        }
        if(e.getSource() == b2)
        {
            SubjectPage();
        }
        if(e.getSource() == addb)
        {
            name = t1.getText();
            age = Integer.parseInt(t2.getText());
            rollno = Integer.parseInt(t3.getText());
            maths = Integer.parseInt(t4.getText());
            science = Integer.parseInt(t5.getText());
            english = Integer.parseInt(t6.getText());
            computer = Integer.parseInt(t7.getText());

            //c.Insert(name, age, rollno, maths, science, english, computer);
            loginPage();
        }
        if(e.getSource() == b3)
        {

            String[] sub = {"RollNo","Name","Age","Maths","English","Science","Computer", "Total Marks"};
            /*JTable table1 = new JTable(c.DisplayAll(),sub);
            JScrollPane j = new JScrollPane(table1);
            j.setBounds(0, 0, 1024, 800);
            f.add(j);
            back.setBounds(1050, 500,300,50);
            f.add(back);*/
            back.addActionListener(this);


        }
        if(e.getSource() == b4)
        {
            /*jc = new JComboBox<String>(c.RetrieveRoll());
            jc.setBounds(50, 50, 300, 50);
            f.add(jc);
            b5 = new JButton("Get Details");
            b5.setBounds(400, 50, 200, 50);
            f.add(b5);*/
            b5.addActionListener(this);
        }
        if(e.getSource() == b5)
        {
            String roll1 = (String)(jc.getItemAt(jc.getSelectedIndex()));
            int roll = Integer.parseInt(roll1);

            String[] sub = {"RollNo","Name","Age","Maths","English","Science","Computer", "Total Marks"};
            /*JTable table2 = new JTable(c.DisplayParticular(roll),sub);
            JScrollPane j = new JScrollPane(table2);
            j.setBounds(0, 0, 1024, 800);
            f.add(j);
            back.setBounds(1050, 500,200,50);
            f.add(back);*/
            back.addActionListener(this);

        }
        if(e.getSource() == display)
        {
            String subject = (String)(jc.getItemAt(jc.getSelectedIndex()));
            String[] sub = {"RollNo","Name",subject};
            /*table = new JTable(c.DisplaySubject(subject),sub);
            JScrollPane j = new JScrollPane(table);
            j.setBounds(0, 0, 1024, 800);
            f.add(j);
            back.setBounds(1050, 500,200,50);
            f.add(back);*/
            back.addActionListener(this);
            //table.setBounds(100, 100, 300, 500);
            //f.add(table);
        }
        if(e.getSource() == back)
        {
            loginPage();
        }

    }

    void Insertpage()
    {

        t1 = new JTextField();
        t1.setBounds(800,100, 300, 30);
        t2 = new JTextField();
        t2.setBounds(800,150, 300, 30);
        t3 = new JTextField();
        t3.setBounds(800,200, 300, 30);
        t4 = new JTextField();
        t4.setBounds(800,250, 300, 30);
        t5 = new JTextField();
        t5.setBounds(800,300, 300, 30);
        t6 = new JTextField();
        t6.setBounds(800,350, 300, 30);
        t7 = new JTextField();
        t7.setBounds(800,400, 300, 30);

        j1 = new JLabel("Name");
        j1.setBounds(570,100, 180, 30);
        j2 = new JLabel("Age");
        j2.setBounds(570,150, 180, 30);
        j3 = new JLabel("Roll No");
        j3.setBounds(570,200, 180, 30);
        j4 = new JLabel("Maths score out of 100");
        j4.setBounds(570,250, 180, 30);
        j5 = new JLabel("Science score out of 100");
        j5.setBounds(570,300, 180, 30);
        j6 = new JLabel("English score out of 100");
        j6.setBounds(570,350, 180, 30);
        j7 = new JLabel("Computer score out of 100");
        j7.setBounds(570,400, 180, 30);

        addb.setBounds(800, 500, 300, 30);
        addb.addActionListener(this);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(t4);
        f.add(t5);
        f.add(t6);
        f.add(t7);

        f.add(j1);
        f.add(j2);
        f.add(j3);
        f.add(j4);
        f.add(j5);
        f.add(j6);
        f.add(j7);

        f.add(addb);
        f.setLayout(null);

    }
    void SubjectPage()
    {
        String Subjects[] = {"Maths","Science","English","Computers"};
        jc = new JComboBox<String>(Subjects);
        jc.setBounds(50, 50, 300, 50);
        f.add(jc);
        display = new JButton("Display Marks");
        display.setBounds(50, 150, 300, 50);
        f.add(display);
        display.addActionListener(this);

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

        }

    }
}
