import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class FrmSupermercado2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblCantidad;
	private JComboBox cboCodigo;
	private JTextField txtCantidad;
	private JTextArea txtS;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scrollPane;
	DecimalFormat df = new DecimalFormat("#,##");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSupermercado2 frame = new FrmSupermercado2();
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
	public FrmSupermercado2() {
		setTitle("Supermercado");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 11, 71, 14);
		contentPane.add(lblCodigo);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 36, 71, 14);
		contentPane.add(lblCantidad);
		
		cboCodigo = new JComboBox();
		cboCodigo.setModel(new DefaultComboBoxModel(new String[] {"Laive", "Gloria", "Pura Vida", "Milkito"}));
		cboCodigo.setBounds(69, 8, 86, 20);
		contentPane.add(cboCodigo);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(69, 33, 86, 20);
		contentPane.add(txtCantidad);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 61, 414, 189);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		int 
			codigo = 0,
			cantidad = 0;
		
		double 
			importeCompra = 0, 
			importeDescuento = 0, 
			importePago = 0;
		
		codigo = cboCodigo.getSelectedIndex();
		
		try {
			cantidad = Integer.parseInt(txtCantidad.getText());
			if(cantidad <= 0) {
				JOptionPane.showMessageDialog(this, "Ingresar valores mayores a 0", "Error!!!", 0);
				
				txtCantidad.setText("");
				txtS.setText("");
				cboCodigo.setSelectedIndex(0);
				txtCantidad.requestFocus();
				return;
			}
		} catch (NumberFormatException error) {
			// TODO Auto-generated catch block
			System.out.println(error);
			JOptionPane.showMessageDialog(this, "Debe ingresar valores numéricos", "Error!!!", 0);
			
			txtCantidad.setText("");
			txtS.setText("");
			cboCodigo.setSelectedIndex(0);
			txtCantidad.requestFocus();
			return;
		}
		
		if(codigo == 0) {
			importeCompra = cantidad * 3.90;
		}else if(codigo == 1) {
			importeCompra = cantidad * 3.80;
		}else if(codigo == 2) {
			importeCompra = cantidad * 4.20;
		}else if(codigo == 3) {
			importeCompra = cantidad * 3.60;
		}
		
		if(cantidad < 15) {
			importeDescuento = importeCompra * 0.04;
		}else if(cantidad >= 15 && cantidad < 30) {
			importeDescuento = importeCompra * 0.065;
		}else if(cantidad >= 30 && cantidad < 45 ) {
			importeDescuento = importeCompra * 0.09;
		}else if(cantidad >= 45  ) {
			importeDescuento = importeCompra * 0.115;
		}

		importePago = importeCompra - importeDescuento;
		
		txtS.setText("Importe Compra	: S/. " + df.format(importeCompra) + "\n");
		txtS.append("Importe Descuento	: S/. " + df.format(importeDescuento) + "\n");
		txtS.append("Importe a Pagar	: S/. " + df.format(importePago));
		
	}
	protected void actionPerformedBtnBorrar(ActionEvent e) {
		txtCantidad.setText("");
		txtS.setText("");
		cboCodigo.setSelectedIndex(0);
		txtCantidad.requestFocus();
	}
}
