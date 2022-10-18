package cibertec;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class FrmModificarCocina extends JDialog implements ActionListener, ItemListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblModelo;
	private JComboBox cboModelo;
	private JLabel lblPrecio;
	private JLabel lblAncho;
	private JLabel lblAlto;
	private JLabel lblFondo;
	private JLabel lblQuemadores;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JTextField txtFondo;
	private JTextField txtQuemadores;
	private JButton btnCerrar;
    Tienda cocina = new Tienda();
    private JButton btnGrabar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmModificarCocina dialog = new FrmModificarCocina();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmModificarCocina() {
	    setTitle("Consultar Cocina");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 25, 76, 14);
		contentPanel.add(lblModelo);
		
		cboModelo = new JComboBox();
		cboModelo.addItemListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {cocina.modelo0, cocina.modelo1, cocina.modelo2, cocina.modelo3, cocina.modelo4}));
		cboModelo.setBounds(96, 23, 177, 18);
		contentPanel.add(cboModelo);
		
		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setBounds(10, 64, 76, 14);
		contentPanel.add(lblPrecio);
		
		lblAncho = new JLabel("Ancho (cm)");
		lblAncho.setBounds(10, 103, 76, 14);
		contentPanel.add(lblAncho);
		
		lblAlto = new JLabel("Alto (cm)");
		lblAlto.setBounds(10, 142, 76, 14);
		contentPanel.add(lblAlto);
		
		lblFondo = new JLabel("Fondo (cm)");
		lblFondo.setBounds(10, 181, 76, 14);
		contentPanel.add(lblFondo);
		
		lblQuemadores = new JLabel("Quemadores");
		lblQuemadores.setBounds(10, 220, 76, 14);
		contentPanel.add(lblQuemadores);
		
		txtPrecio = new JTextField();
		txtPrecio.setText("" + cocina.precio0);
		txtPrecio.setBounds(96, 61, 177, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtAncho = new JTextField();
		txtAncho.setText("" + cocina.ancho0);
		txtAncho.setColumns(10);
		txtAncho.setBounds(96, 100, 177, 20);
		contentPanel.add(txtAncho);
		
		txtAlto = new JTextField();
		txtAlto.setText("" + cocina.alto0);
		txtAlto.setColumns(10);
		txtAlto.setBounds(96, 139, 177, 20);
		contentPanel.add(txtAlto);
		
		txtFondo = new JTextField();
		txtFondo.setText("" + cocina.fondo0);
		txtFondo.setColumns(10);
		txtFondo.setBounds(96, 178, 177, 20);
		contentPanel.add(txtFondo);
		
		txtQuemadores = new JTextField();
		txtQuemadores.setText("" + cocina.quemadores0);
		txtQuemadores.setColumns(10);
		txtQuemadores.setBounds(96, 217, 177, 20);
		contentPanel.add(txtQuemadores);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(315, 21, 98, 23);
		contentPanel.add(btnCerrar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(315, 55, 98, 23);
		contentPanel.add(btnGrabar);
	}
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGrabar) {
            actionPerformedBtnGrabar(e);
        }
        if (e.getSource() == btnCerrar) {
            actionPerformedBtnCerrar(e);
        }
    }
    protected void actionPerformedBtnCerrar(ActionEvent e) {
        this.dispose();
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
            txtAncho.setText("" + cocina.ancho0);
            txtAlto.setText("" + cocina.alto0);
            txtFondo.setText("" + cocina.fondo0);
            txtQuemadores.setText("" + cocina.quemadores0);
            
        }else if(idxModelo == 1) {
            
            txtPrecio.setText("" + cocina.precio1);
            txtAncho.setText("" + cocina.ancho1);
            txtAlto.setText("" + cocina.alto1);
            txtFondo.setText("" + cocina.fondo1);
            txtQuemadores.setText("" + cocina.quemadores1);
            
        }else if(idxModelo == 2) {
            
            txtPrecio.setText("" + cocina.precio2);
            txtAncho.setText("" + cocina.ancho2);
            txtAlto.setText("" + cocina.alto2);
            txtFondo.setText("" + cocina.fondo2);
            txtQuemadores.setText("" + cocina.quemadores2);
            
        }else if(idxModelo == 3) {
            
            txtPrecio.setText("" + cocina.precio3);
            txtAncho.setText("" + cocina.ancho3);
            txtAlto.setText("" + cocina.alto3);
            txtFondo.setText("" + cocina.fondo3);
            txtQuemadores.setText("" + cocina.quemadores3);
            
        }

    }
    protected void actionPerformedBtnGrabar(ActionEvent e) {
        int 
            cantidadQuemadores,
            idxModelo = cboModelo.getSelectedIndex();
            
        String
            nameModelo = (String) cboModelo.getSelectedItem();
        
        double
            precio,
            ancho,
            alto,
            fondo;
        
        try {
            precio = Double.parseDouble(txtPrecio.getText());
            ancho = Double.parseDouble(txtAncho.getText());
            alto = Double.parseDouble(txtAlto.getText());
            fondo = Double.parseDouble(txtFondo.getText());
            cantidadQuemadores = Integer.parseInt(txtQuemadores.getText());
            if(precio <= 0 || ancho <= 0 || alto <= 0 || fondo <= 0) {
                JOptionPane.showMessageDialog(this, "Ingresar valores mayores a 0", "Error!!!", 0);
                
                cboModelo.setSelectedIndex(0);
                txtPrecio.setText("" + cocina.precio0);
                txtAncho.setText("" + cocina.ancho0);
                txtAlto.setText("" + cocina.alto0);
                txtFondo.setText("" + cocina.fondo0);
                txtQuemadores.setText("" + cocina.quemadores0);
                txtPrecio.requestFocus();
                
                return;
            }
        } catch (NumberFormatException e1) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(this, "Debe ingresar valores numéricos", "Error!!!", 0);
            
            cboModelo.setSelectedIndex(0);
            txtPrecio.setText("" + cocina.precio0);
            txtAncho.setText("" + cocina.ancho0);
            txtAlto.setText("" + cocina.alto0);
            txtFondo.setText("" + cocina.fondo0);
            txtQuemadores.setText("" + cocina.quemadores0);
            txtPrecio.requestFocus();
            return;
        }
        
        if(idxModelo == 0) {
            
            cocina.precio0 = precio;
            cocina.ancho0 = ancho;
            cocina.alto0 = alto;
            cocina.fondo0 = fondo;
            cocina.quemadores0 = cantidadQuemadores;
            
        }else if(idxModelo == 1) {
            
            cocina.precio1 = precio;
            cocina.ancho1 = ancho;
            cocina.alto1 = alto;
            cocina.fondo1 = fondo;
            cocina.quemadores1 = cantidadQuemadores;
            
        }else if(idxModelo == 2) {
            
            cocina.precio2 = precio;
            cocina.ancho2 = ancho;
            cocina.alto2 = alto;
            cocina.fondo2 = fondo;
            cocina.quemadores2 = cantidadQuemadores;
            
        }else if(idxModelo == 3) {
            
            cocina.precio3 = precio;
            cocina.ancho3 = ancho;
            cocina.alto3 = alto;
            cocina.fondo3 = fondo;
            cocina.quemadores3 = cantidadQuemadores;
            
        }
        
        JOptionPane.showMessageDialog(this, "Se ha modificado con éxito los valores para: " + nameModelo, "Modificado", 1);
        this.dispose();
        
    }
}
