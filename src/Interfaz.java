import javax.swing.*;
public class Interfaz extends JFrame{
    private JPanel panel;
    private JLabel label;
    private JTextField textField;
    private JButton button;

    public Interfaz() {
        setTitle("INICIO ABACUS");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        label = new JLabel("Ingrese su nombre:");
        textField = new JTextField(15);
        button = new JButton("Enviar");

        panel.add(label);
        panel.add(textField);
        panel.add(button);

        add(panel);
        setLocationRelativeTo(null);
    }

}
