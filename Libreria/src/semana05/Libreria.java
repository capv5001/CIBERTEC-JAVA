package semana05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;
import java.awt.HeadlessException;

public class Libreria extends JFrame implements ActionListener {

	// Declaración de variables
	private static final long serialVersionUID = 9206324162700448001L;
	private JPanel contentPane;
	private JLabel lblMarca;
	private JLabel lblCantidad;
	private JComboBox<String> cboMarca;
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
					Libreria frame = new Libreria();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Libreria() {
		setTitle("Librer\u00EDa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 233);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 11, 47, 14);
		contentPane.add(lblMarca);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 36, 47, 14);
		contentPane.add(lblCantidad);

		cboMarca = new JComboBox<String>();
		cboMarca.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Standford", "Alpha", "Justus", "Loro" }));
		cboMarca.setBounds(67, 8, 100, 20);
		contentPane.add(cboMarca);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(67, 33, 100, 20);
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
		scpScroll.setBounds(10, 61, 414, 123);
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
		cboMarca.setSelectedIndex(0);
		txtCantidad.requestFocus();
	}

	// Procesa la pulsación del botón Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		
		double 
			precio = 0, 
			importeDescuento = 0, 
			importePagar, 
			importeCompra;
					
		int 
			marcaCuaderno = 0, 
			cantidadCuadernos = 0;

		
		try {
			cantidadCuadernos = Integer.parseInt(txtCantidad.getText());
			marcaCuaderno = cboMarca.getSelectedIndex();
			
			if(cantidadCuadernos <= 0) {
				
				JOptionPane.showMessageDialog(this, 
			        "Valor fuera de rango", 
			        "ERROR",
			        JOptionPane.ERROR_MESSAGE
			    );
				
				cboMarca.setSelectedIndex(0);
				txtCantidad.setText("");
				txtS.setText("");
				txtCantidad.requestFocus();
				
				return;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(marcaCuaderno == 0) {
			precio = 4.85;
		}
		if(marcaCuaderno == 1) {
			precio = 4.35;		}
		if(marcaCuaderno == 2) {
			precio = 3.50;
		}
		if(marcaCuaderno == 3) {
			precio = 4.55;
		}
		
		importeCompra = cantidadCuadernos * precio;
		
		if(cantidadCuadernos >= 36) {
			importeDescuento = importeCompra * 0.135;
		}else if(cantidadCuadernos >= 24 || cantidadCuadernos < 36) {
			importeDescuento = importeCompra * 0.115;
		}else if(cantidadCuadernos >= 12 || cantidadCuadernos < 24) {
			importeDescuento = importeCompra * 0.095;
		}else if(cantidadCuadernos < 12) {
			importeDescuento = importeCompra * 0.075;
		}
		
		importePagar = importeCompra - importeDescuento;
		
		
		txtS.setText("Importe Compra:	" + importeCompra + "\n");
		txtS.append("Importe Descuento:	" + importeDescuento + "\n");
		txtS.append("Importe a Pagar :	" + importePagar + "\n");

		
	}
}




