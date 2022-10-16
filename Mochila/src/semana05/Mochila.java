package semana05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

public class Mochila extends JFrame implements ActionListener {

	// Declaración de variables
	private static final long serialVersionUID = 9206324162700448001L;
	private JPanel contentPane;
	private JLabel lblModelo;
	private JLabel lblCantidad;
	private JComboBox<String> cboModelo;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtS;

	// Lanza la aplicación
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mochila frame = new Mochila();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Mochila() {
		setTitle("Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 11, 65, 14);
		contentPane.add(lblModelo);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 36, 65, 14);
		contentPane.add(lblCantidad);

		cboModelo = new JComboBox<String>();
		cboModelo.setModel(new DefaultComboBoxModel<String>(new String[] {"Sherman", "Faguo", "Aldo", "Suburban"}));
		cboModelo.setBounds(85, 8, 100, 20);
		contentPane.add(cboModelo);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(85, 33, 100, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 61, 414, 190);
		contentPane.add(scpScroll);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scpScroll.setViewportView(txtS);
	}

	// Direcciona eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}

	// Procesa la pulsación del botón Borrar
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtCantidad.setText("");
		txtS.setText("");
		cboModelo.setSelectedIndex(0);
		txtCantidad.requestFocus();
	}

	// Procesa la pulsación del botón Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		double precio = 0, importeDescuento = 0, importePagar, importeCompra;
		int modeloMochila, cantidadMochilas, cantidadChocolates = 0;
		
		cantidadMochilas = Integer.parseInt(txtCantidad.getText());
		modeloMochila = cboModelo.getSelectedIndex();
		
		if(cantidadMochilas <= 0) {
			
			JOptionPane.showMessageDialog(this, 
                "Valor fuera de rango", 
                "ERROR",
                JOptionPane.ERROR_MESSAGE
            );
			
			cboModelo.setSelectedIndex(0);
			txtCantidad.setText("");
			txtS.setText("");
			
			return;
		}
		
		if(modeloMochila == 0) {
			precio = 149.9;
		}
		if(modeloMochila == 1) {
			precio = 89.9;
		}
		if(modeloMochila == 2) {
			precio = 119.9;
		}
		if(modeloMochila == 3) {
			precio = 174.9;
		}
		
		importeCompra = cantidadMochilas * precio;
		
		if(importeCompra >= 20) {
			importeDescuento = importeCompra * 0.09;
		}
		if(importeCompra >= 10 && importeCompra < 20) {
			importeDescuento = importeCompra * 0.07;
		}
		if(importeCompra >= 5 && importeCompra < 10) {
			importeDescuento = importeCompra * 0.05;
		}
		if(importeCompra < 5) {
			importeDescuento = 0;
		}
		
		importePagar = importeCompra - importeDescuento;
		
		if(importePagar < 200) {
			cantidadChocolates = 0;
		}
		if(importePagar >= 200 && importePagar < 500) {
			cantidadChocolates = 1 * cantidadMochilas;
		}
		if(importePagar >= 500 && importePagar < 700) {
			cantidadChocolates = 2 * cantidadMochilas;
		}
		if(importePagar >= 700) {
			cantidadChocolates = 3 * cantidadMochilas;
		}
		
		txtS.setText("Importe Compra:		" + importeCompra + "\n");
		txtS.append("Importe Descuento:	" + importeDescuento + "\n");
		txtS.append("Importe a Pagar :	" + importePagar + "\n");
		txtS.append("Chocolates de Regalo:	" + cantidadChocolates + "\n");
	}
}