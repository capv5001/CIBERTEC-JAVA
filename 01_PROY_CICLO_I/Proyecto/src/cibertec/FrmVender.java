package cibertec;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class FrmVender extends JDialog implements ActionListener, ItemListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JButton btnVender;
	private JComboBox cboModelo;
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblCantidad;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	DecimalFormat df = new DecimalFormat();
    Tienda cocina = new Tienda();
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmVender dialog = new FrmVender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmVender() {
	    setTitle("Vender");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(326, 34, 98, 23);
		contentPanel.add(btnCerrar);
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(326, 9, 98, 23);
		contentPanel.add(btnVender);

		cboModelo = new JComboBox();
		cboModelo.addItemListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {cocina.modelo0, cocina.modelo1, cocina.modelo2, cocina.modelo3, cocina.modelo4}));
		cboModelo.setBounds(96, 11, 177, 18);
		contentPanel.add(cboModelo);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 13, 76, 14);
		contentPanel.add(lblModelo);
		
		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setBounds(10, 38, 76, 14);
		contentPanel.add(lblPrecio);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 63, 76, 14);
		contentPanel.add(lblCantidad);
		
		txtPrecio = new JTextField();
		txtPrecio.setText("" + cocina.precio0);
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(96, 35, 177, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(96, 60, 177, 20);
		contentPanel.add(txtCantidad);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 86, 414, 164);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVender) {
            actionPerformedBtnVender(e);
        }
        if (e.getSource() == btnCerrar) {
            actionPerformedBtnCerrar(e);
        }
    }
    protected void actionPerformedBtnVender(ActionEvent e) {
        txtS.setText("BOLETA DE VENTA\n\n");
        
        // Model
        txtS.append("Modelo\t\t: " + cocina.modelo0 + "\n");
        txtS.append("Precio\t\t: S/." + cocina.df.format(cocina.precio0) + "\n");
        txtS.append("Cantidad\t\t: " + cocina.df.format(cocina.fondo0) + " cm\n");
        txtS.append("Importe compra\t\t: " + cocina.df.format(cocina.ancho0) + " cm\n");
        txtS.append("Importe descuento\t: " + cocina.df.format(cocina.alto0) + " cm\n");
        txtS.append("Importe pagar\t\t: " + cocina.df.format(cocina.alto0) + " cm\n");
        txtS.append("Obsequio\t\t: " + cocina.quemadores0 + "\n\n");

    }
    
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == cboModelo) {
            itemStateChangedCboModelo(e);
        }
    }
    protected void itemStateChangedCboModelo(ItemEvent e) {
        
        int idxModelo = cboModelo.getSelectedIndex();
        
        if(idxModelo == 0) {
            txtPrecio.setText("" + cocina.precio0);
        }else if(idxModelo == 1) {
            txtPrecio.setText("" + cocina.precio1);
        }else if(idxModelo == 2) {
            txtPrecio.setText("" + cocina.precio2);
        }else if(idxModelo == 3) {
            txtPrecio.setText("" + cocina.precio3);
        }
       
        txtCantidad.setText("");
        txtS.setText("");
    }
    protected void actionPerformedBtnCerrar(ActionEvent e) {
        this.dispose();
    }

}
