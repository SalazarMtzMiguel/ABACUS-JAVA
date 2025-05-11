import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

        public class Interfaz extends JFrame {
            private JPanel panel;
            private JButton createFileButton;
            private JButton readFileButton;
            private JButton editFileButton;
            private JButton executeButton;
            private SearchFile searchFile;

            public Interfaz() {
                setTitle("INICIO ABACUS");
                setSize(300, 400);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                panel = new JPanel();
                panel.setLayout(new GridLayout(4, 1, 10, 10)); // Configuración para botones en línea vertical

                searchFile = new SearchFile();

                executeButton = new JButton("Execute File");
                createFileButton = new JButton("New File");
                readFileButton = new JButton("Read File");
                editFileButton = new JButton("Edit File");

                // Agregar ActionListeners para cada botón
                executeButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        searchFile.openFileChooser();
                        String filePath = searchFile.getSelectedFilePath();
                        if (filePath != null) {
                            JOptionPane.showMessageDialog(null, "Ejecutar archivo: " + filePath);
                        }
                    }
                });

                readFileButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        searchFile.openFileChooser();
                        String filePath = searchFile.getSelectedFilePath();
                        if (filePath != null) {
                            JOptionPane.showMessageDialog(null, "Leer archivo: " + filePath);
                        }
                    }
                });

                editFileButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        searchFile.openFileChooser();
                        String filePath = searchFile.getSelectedFilePath();
                        if (filePath != null) {
                            JOptionPane.showMessageDialog(null, "Editar archivo: " + filePath);
                        }
                    }
                });

                createFileButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CreateFile createFile = new CreateFile();
                        createFile.setVisible(true);
                    }
                });

                panel.add(executeButton);
                panel.add(createFileButton);
                panel.add(readFileButton);
                panel.add(editFileButton);

                add(panel);
                setLocationRelativeTo(null);
            }
        }