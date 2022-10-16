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

public class FrmTipoNumero extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel lblNumero;
    private JTextField txtNumero;
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
                    FrmTipoNumero frame = new FrmTipoNumero();
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
    public FrmTipoNumero() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 183);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblNumero = new JLabel("N\u00FAmero");
        lblNumero.setBounds(10, 11, 61, 14);
        contentPane.add(lblNumero);
        
        txtNumero = new JTextField();
        txtNumero.setBounds(81, 8, 86, 20);
        contentPane.add(txtNumero);
        txtNumero.setColumns(10);
        
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
        int numero;
        String valorNumero = "";
        
        numero = Integer.parseInt(txtNumero.getText());
        
        if(numero > 0) valorNumero = "positivo";
        if(numero < 0) valorNumero = "negativo";
        if(numero == 0) valorNumero = "neutro";
        
        txtS.setText("El número " + numero + " es " + valorNumero);
        
    }
    protected void actionPerformedBtnEliminar(ActionEvent e) {
        txtNumero.setText("");
        txtS.setText("");
        txtNumero.requestFocus();
    }
}
