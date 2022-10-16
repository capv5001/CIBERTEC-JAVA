import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class FrmSupermercado extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCantidad;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JLabel lblPrecio;
	private JTextField txtPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSupermercado frame = new FrmSupermercado();
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
	public FrmSupermercado() {
		setResizable(false);
		setTitle("Christian Palacios - Supermecado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 358, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 35, 67, 14);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(87, 32, 146, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(243, 7, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(243, 331, 89, 23);
		contentPane.add(btnBorrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 60, 322, 260);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 11, 67, 14);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(87, 8, 146, 20);
		contentPane.add(txtPrecio);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	// Decimal Format
	DecimalFormat formato = new DecimalFormat("0.00");
	
	// Actions to process button
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		// Declaration variable
		int
			cantidadAdquirida,
			regaloCaramelo;
		double
			precioBotella,
			importeCompra,
			primerDescuento,
			segundoDescuento,
			importeDescuentoTotal,
			importePago;
		
		
		//Parsing values
		try {
			precioBotella = Double.parseDouble(txtPrecio.getText());
			cantidadAdquirida = Integer.parseInt(txtCantidad.getText());
			
			if(precioBotella <= 0 || cantidadAdquirida <= 0) {
				JOptionPane.showMessageDialog(this, "Ingresar valores mayores a 0", "Error!!!", 0);
				
				txtPrecio.setText("");
				txtCantidad.setText("");
				txtS.setText("");
				txtPrecio.requestFocus();
				return;
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this, "Ingresar sólo valores numéricos", "Error!!!", 0);
			
			txtPrecio.setText("");
			txtCantidad.setText("");
			txtS.setText("");
			txtPrecio.requestFocus();
			return;
		} 
		
		//Process
		importeCompra = precioBotella * cantidadAdquirida;
		primerDescuento = 0.06 * importeCompra;
		segundoDescuento = 0.08 * (importeCompra - primerDescuento);
		importeDescuentoTotal = primerDescuento + segundoDescuento;
		importePago = importeCompra - importeDescuentoTotal;
		regaloCaramelo = 3 * (cantidadAdquirida / 6);
		
		//Output
		txtS.setText("Importe Compra	: S/. " + formato.format(importeCompra) + "\n");
		txtS.append("Descuento 1		: S/. " + formato.format(primerDescuento) + "\n");
		txtS.append("Descuento 2		: S/. " + formato.format(segundoDescuento) + "\n");
		txtS.append("Descuento Total	: S/. " + formato.format(importeDescuentoTotal) + "\n");
		txtS.append("Importe a pagar		: S/. " + formato.format(importePago) + "\n");
		txtS.append("Caramelos de Regalo	: " + regaloCaramelo + "\n");
	}
	
	//Actions to Erase button
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtPrecio.setText("");
		txtCantidad.setText("");
		txtS.setText("");
		txtPrecio.requestFocus();	
	}
}
