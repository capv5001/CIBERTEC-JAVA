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

public class Ejercicio1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblGolesA;
	private JLabel lblGolesB;
	private JTextField txtGolesA;
	private JTextField txtGolesB;
	private JButton btnProcesar;
	private JButton btnLimpiar;
	private JTextArea txtS;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio1 frame = new Ejercicio1();
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
	public Ejercicio1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblGolesA = new JLabel("Goles A");
		lblGolesA.setBounds(10, 11, 72, 14);
		contentPane.add(lblGolesA);
		
		lblGolesB = new JLabel("Goles B");
		lblGolesB.setBounds(10, 34, 45, 14);
		contentPane.add(lblGolesB);
		
		txtGolesA = new JTextField();
		txtGolesA.setBounds(60, 8, 119, 20);
		contentPane.add(txtGolesA);
		txtGolesA.setColumns(10);
		
		txtGolesB = new JTextField();
		txtGolesB.setColumns(10);
		txtGolesB.setBounds(60, 31, 119, 20);
		contentPane.add(txtGolesB);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(222, 7, 89, 23);
		contentPane.add(btnProcesar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(222, 30, 89, 23);
		contentPane.add(btnLimpiar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 299, 191);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnProcesar) {
            actionPerformedBtnProcesar(e);
        }
    }
    protected void actionPerformedBtnProcesar(ActionEvent e) {
        
        int golesA, golesB;
        String resultado = "";
        
        golesA = Integer.parseInt(txtGolesA.getText());
        golesB = Integer.parseInt(txtGolesB.getText());
        
        if(golesA < 0 || golesB < 0) {
            System.out.println(this);
            JOptionPane.showMessageDialog(this, "Error, ingresar valores de 0 en adelante.");
            txtGolesA.setText("");
            txtGolesB.setText("");
            txtS.setText("");
            txtGolesA.requestFocus();
            return;
        }
        
        if(golesA > golesB) resultado = "Ganó el equipo A";
        if(golesB > golesA) resultado = "Ganó el equipo B";
        if(golesA == golesB) resultado = "Ganó el equipo C";
        
        txtS.setText("Los resultados son: \n\n");
        txtS.append("Resultado: " + resultado);
    }
}
