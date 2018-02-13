import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;


public class SwingApp extends JFrame{
    private JButton button = new JButton("Check yourself");
    private JLabel lblUser = new JLabel("User:");
    private JLabel lblPassword = new JLabel("Password:");
    private JTextField txtUser = new JTextField();
    private JPasswordField txtPassword = new JPasswordField();




    public SwingApp() {
        super("Try to crack me :D");
        this.setSize(480, 120);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        char[] correctPassword = { '1', '4', '1', '5', '9', '2'};
        Container container = this.getContentPane();

        GroupLayout layout = new GroupLayout(container);
        container.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblUser)
                        .addComponent(lblPassword))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(txtUser)
                        .addComponent(txtPassword))
                .addComponent(button)
        );


        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblUser)
                        .addComponent(txtUser)
                        .addComponent(button))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblPassword)
                        .addComponent(txtPassword))
        );
        layout.linkSize(SwingConstants.VERTICAL, txtUser, txtPassword);

        txtUser.setToolTipText("Name of the creator of the first PC");
        txtPassword.setToolTipText("First 6 digits of the number pi after the decimal point");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] checkPassword = txtPassword.getPassword();
                if (txtUser.getText().toString().equals("John") && Arrays.equals(checkPassword, correctPassword)) {
                    txtUser.setBackground(Color.green);
                    txtPassword.setBackground(Color.green);
                    JOptionPane.showMessageDialog(container, "Congrats! It was simple for u.");
                    System.exit(0);

                } else {
                    JOptionPane.showMessageDialog(container, "Sorry, try again!");
                }
            }
        });
    }
}
