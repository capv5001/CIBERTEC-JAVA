import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class FrmTienda extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblPrecio;
	private JLabel lblCantidad;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnEliminar;
	private JTextArea txtS;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTienda frame = new FrmTienda();
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
	public FrmTienda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 332, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 11, 65, 14);
		contentPane.add(lblPrecio);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 34, 65, 14);
		contentPane.add(lblCantidad);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(85, 8, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(85, 31, 86, 20);
		contentPane.add(txtCantidad);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(217, 7, 89, 23);
		contentPane.add(btnProcesar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(217, 30, 89, 23);
		contentPane.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 296, 189);
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
		int cantidadAdquirida;
		double precio, importeCompra, importeDescuento, importePagar;
		String obsequio = "";
		
		cantidadAdquirida = Integer.parseInt(txtCantidad.getText());
		precio = Double.parseDouble(txtPrecio.getText());
		
		importeCompra = cantidadAdquirida * precio;
		
		if(cantidadAdquirida > 10) {
			importeDescuento = importeCompra * 0.15;
		}else {
			importeDescuento = importeCompra * 0.05;
		}
		
		importePagar = importeCompra - importeDescuento;
		
		if(importePagar > 200) {
			obsequio = "Agenda";
		}else{
			obsequio = "Cuaderno";
		}
		
		txtS.setText("Importe de Compra		: S./ " + importeCompra + "\n");
		txtS.append("Importe Descuento		: S./ " + importeDescuento + "\n");
		txtS.append("Importe a Pagar		: S./ " + importePagar + "\n");
		txtS.append("Obsequio				: S./ " + obsequio);
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		txtCantidad.setText("");
		txtPrecio.setText("");
		txtS.setText("");
		txtCantidad.requestFocus();
	}
}
