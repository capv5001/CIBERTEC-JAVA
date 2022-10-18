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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.UIManager;

public class FrmConsultarCocina extends JDialog implements ActionListener, ItemListener {

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
	
	private Tienda cocina = new Tienda();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } catch (Throwable e) {
	        e.printStackTrace();
	    }
		try {
			FrmConsultarCocina dialog = new FrmConsultarCocina();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmConsultarCocina() {
	    setType(Type.UTILITY);
	    setTitle("Consultar Cocina");
		setBounds(100, 100, 442, 300);
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
		txtPrecio.setEnabled(false);
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(96, 61, 177, 20);
		txtPrecio.setText("" + cocina.precio0);
		contentPanel.add(txtPrecio);
		
		txtAncho = new JTextField();
		txtAncho.setEnabled(false);
		txtAncho.setEditable(false);
		txtAncho.setColumns(10);
		txtAncho.setBounds(96, 100, 177, 20);
		txtAncho.setText("" + cocina.ancho0);
		contentPanel.add(txtAncho);
		
		txtAlto = new JTextField();
		txtAlto.setEnabled(false);
		txtAlto.setEditable(false);
		txtAlto.setColumns(10);
		txtAlto.setBounds(96, 139, 177, 20);
		txtAlto.setText("" + cocina.alto0);
		contentPanel.add(txtAlto);
		
		txtFondo = new JTextField();
		txtFondo.setEnabled(false);
		txtFondo.setEditable(false);
		txtFondo.setColumns(10);
		txtFondo.setBounds(96, 178, 177, 20);
		txtFondo.setText("" + cocina.fondo0);
		contentPanel.add(txtFondo);
		
		txtQuemadores = new JTextField();
		txtQuemadores.setEnabled(false);
		txtQuemadores.setEditable(false);
		txtQuemadores.setColumns(10);
		txtQuemadores.setBounds(96, 217, 177, 20);
		txtQuemadores.setText("" + cocina.quemadores0);
		contentPanel.add(txtQuemadores);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(315, 21, 98, 23);
		contentPanel.add(btnCerrar);
	}
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCerrar) {
            actionPerformedBtnCerrar(e);
        }
    }
    protected void actionPerformedBtnCerrar(ActionEvent e) {
        this.dispose();
    }
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == cboModelo) {
            itemStateChangedComboBox(e);
        }
    }
    protected void itemStateChangedComboBox(ItemEvent e) {
        
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
}
