import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmPromedio extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel lblPromedio;
    private JTextField txtPromedio;
    private JButton btnEliminar;
    private JButton btnProcesar;
    private JTextArea txtS;
    private JScrollPane scrollPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmPromedio frame = new FrmPromedio();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public FrmPromedio() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 183);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblPromedio = new JLabel("Promedio");
        lblPromedio.setBounds(10, 11, 61, 14);
        contentPane.add(lblPromedio);
        
        txtPromedio = new JTextField();
        txtPromedio.setBounds(81, 8, 86, 20);
        contentPane.add(txtPromedio);
        txtPromedio.setColumns(10);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(this);
        btnEliminar.setBounds(335, 7, 89, 23);
        contentPane.add(btnEliminar);
        
        btnProcesar = new JButton("Procesar");
        btnProcesar.addActionListener(this);
        btnProcesar.setBounds(236, 7, 89, 23);
        contentPane.add(btnProcesar);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 36, 414, 97);
        contentPane.add(scrollPane);
        
        txtS = new JTextArea();
        scrollPane.setViewportView(txtS);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEliminar) {
            actionPerformedBtnEliminar(e);
        }
        if (e.getSource() == btnProcesar) {
            actionPerformedBtnProcesar(e);
        }
    }
    protected void actionPerformedBtnProcesar(ActionEvent e) {
        int promedio;
        String categoria = "";
        
        promedio = Integer.parseInt(txtPromedio.getText());
        
        if(promedio < 0 || promedio > 20) {
            txtPromedio.setText("");
            
            txtS.setText("");
            JOptionPane.showMessageDialog(this, 
                "Valor fuera de rango", 
                "ERROR",
                JOptionPane.ERROR_MESSAGE
            );
            
            return;
        }
        
        if(promedio >= 17) categoria = "A";
        if(promedio >= 14 && promedio < 17) categoria = "B";
        if(promedio >= 12 && promedio < 14) categoria = "C";
        if(promedio < 12) categoria = "D";
        
        txtS.setText("Ud. pertenece a la categoría " + categoria);
        
    }
    protected void actionPerformedBtnEliminar(ActionEvent e) {
        txtPromedio.setText("");
        txtS.setText("");
        txtPromedio.requestFocus();
    }
}
