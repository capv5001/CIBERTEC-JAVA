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

public class FrmGenerarReporte extends JDialog {

    private final JPanel contentPanel = new JPanel();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            FrmGenerarReporte dialog = new FrmGenerarReporte();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public FrmGenerarReporte() {
        setTitle("Generar Reportes");
        setBounds(100, 100, 673, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            JButton btnCerrar = new JButton("Cerrar");
            btnCerrar.setBounds(537, 11, 110, 23);
            contentPanel.add(btnCerrar);
            btnCerrar.setActionCommand("OK");
            getRootPane().setDefaultButton(btnCerrar);
        }
        {
            JLabel lblNewLabel = new JLabel("Tipo de Reporte");
            lblNewLabel.setBounds(10, 15, 98, 14);
            contentPanel.add(lblNewLabel);
        }
        {
            JComboBox cboTipoReporte = new JComboBox();
            cboTipoReporte.setModel(new DefaultComboBoxModel(new String[] {"Ventas por modelo", "Ventas en relación a la venta óptima", "Precios en relación al precio promedio", "Promedios, menores y mayores"}));
            cboTipoReporte.setBounds(102, 11, 297, 23);
            contentPanel.add(cboTipoReporte);
        }
        {
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setBounds(10, 40, 637, 210);
            contentPanel.add(scrollPane);
            {
                JTextArea txtS = new JTextArea();
                scrollPane.setViewportView(txtS);
            }
        }
    }

}
