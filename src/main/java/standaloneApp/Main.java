package standaloneApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import standaloneApp.frontend.GUI;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
    private standaloneApp.backend.service.StudentService studentService;

    public Main(){
        initUI();
    }
    private void initUI() {

        /*JButton quitButton = new JButton("Quit");

        quitButton.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        createLayout(quitButton);

        setTitle("Quit button");
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);*/
        new GUI();
    }

    /*private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );
    }*/
    public static void main(String[] args) {
        // write your code here
        //SpringApplication app = new SpringApplication(Main.class);
        //app.setBannerMode(Banner.Mode.OFF);

        //app.run(args);

        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Main.class)
                .headless(false).run(args);

        EventQueue.invokeLater(() -> {

            Main ex = ctx.getBean(Main.class);
            //ex.setVisible(true);
        });

    }

    @Override
    public void run(String... args) throws Exception{
        //System.out.println(studentService.getAllowedNumberOfBooks());
        //System.exit(0);

    }
}
