import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class CreateFile extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private JButton addRowButton;
    private JButton deleteRowButton;
    private JButton saveButton;

    public CreateFile() {
        setTitle("Create File");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Preguntar el número de registros
        String input = JOptionPane.showInputDialog(this, "Ingrese el número de registros:");
        if (input != null && !input.isEmpty()) {
            try {
                int numRegistros = Integer.parseInt(input);
                int numColumnas = (3 + numRegistros) * 2 + 1;
                int numFilas = 5; // Número fijo de filas (puedes ajustarlo)
                String[] columnNames = new String[numColumnas];
                int medio = numColumnas / 2;
                columnNames[0] = "R";
                columnNames[1] = "t";
                columnNames[2] = "Entrada";
                columnNames[medio] = "-";
                columnNames[medio+1] = "R";
                columnNames[medio+2] = "t'";
                columnNames[medio+3] = "Salida";
                int a = (int) 'A';
                for (int i = 0; i < numRegistros; i++) {
                    columnNames[3+i] = String.valueOf((char) (a + i));
                    columnNames[medio+4+i] = String.valueOf((char) (a + i));
                }
                // Crear el modelo de tabla con datos por defecto
                tableModel = new DefaultTableModel(columnNames, numColumnas);
                for (int i = 0; i < numFilas; i++) {
                    for (int j = 0; j < numColumnas; j++) {
                        if (i == 0) { // Ejemplo: llenar la primera fila con valores por defecto
                            tableModel.setValueAt("Default " + (j + 1), i, j);
                        }
                    }
                }

                // Crear la tabla
                table = new JTable(tableModel);
                scrollPane = new JScrollPane(table);

                // Crear botones
                addRowButton = new JButton("Añadir Fila");
                deleteRowButton = new JButton("Eliminar Fila");
                saveButton = new JButton("Guardar Todo");

                // Panel para los botones
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new FlowLayout());
                buttonPanel.add(addRowButton);
                buttonPanel.add(deleteRowButton);
                buttonPanel.add(saveButton);

                // Funcionalidad para añadir filas
                addRowButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tableModel.addRow(new Object[numColumnas]); // Añadir fila vacía
                    }
                });

                // Funcionalidad para eliminar filas
                deleteRowButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int selectedRow = table.getSelectedRow();
                        if (selectedRow != -1) {
                            tableModel.removeRow(selectedRow); // Eliminar fila seleccionada
                        } else {
                            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar.");
                        }
                    }
                });

                // Agregar componentes al frame
                add(scrollPane, BorderLayout.CENTER);
                add(buttonPanel, BorderLayout.SOUTH);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se ingresó ningún número.");

        }

        setLocationRelativeTo(null);
    }
}