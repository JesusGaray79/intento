
package vista;
//libreria 
import modelo.mascota;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class formMascota extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(formMascota.class.getName());
// coleccion 
    ArrayList<mascota> listmascota = new ArrayList<> ();
//modelo de tabla 
    DefaultTableModel modTabla;
//constructor 
    
    public formMascota() {
        initComponents();
        String[] titulo ={"Nombre","tipo" ,"edad", "edad humana"};
// crear modelo de la tabla 
    modTabla = new DefaultTableModel(null,titulo); 
//asignamos el modelo jtable
    tblmostrar.setModel(modTabla);
    cargarCombo();
    }
    void cargarCombo(){
        tipotxtcombo.addItem("perro");
        tipotxtcombo.addItem("gato");
        tipotxtcombo.addItem("perico");
        tipotxtcombo.addItem("conejo");

    }
    void limEntradas(){
        nombretxt.setText("");
        edadtxt.setText("");
        tipotxtcombo.setSelectedIndex(0);
        nombretxt.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nombretxt = new javax.swing.JTextField();
        tipotxtcombo = new javax.swing.JComboBox<>();
        edadtxt = new javax.swing.JTextField();
        registrarbtn = new javax.swing.JButton();
        eliminarbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmostrar = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de mascotas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MV Boli", 0, 14), new java.awt.Color(0, 51, 51))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombretxt.setBorder(javax.swing.BorderFactory.createTitledBorder("nombre de la mascota"));
        jPanel1.add(nombretxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 160, 50));

        tipotxtcombo.setBorder(javax.swing.BorderFactory.createTitledBorder("tipo de mascota"));
        jPanel1.add(tipotxtcombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 160, 50));

        edadtxt.setBorder(javax.swing.BorderFactory.createTitledBorder("edad de la mascota"));
        jPanel1.add(edadtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 160, 50));

        registrarbtn.setText("Registrar");
        registrarbtn.addActionListener(this::registrarbtnActionPerformed);
        jPanel1.add(registrarbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        eliminarbtn.setText("Eliminar");
        eliminarbtn.addActionListener(this::eliminarbtnActionPerformed);
        jPanel1.add(eliminarbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        jLabel1.setFont(new java.awt.Font("RomanD", 0, 12)); // NOI18N
        jLabel1.setText("Cantidad de Registro:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 190, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 510, 270));

        tblmostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblmostrar);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 510, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarbtnActionPerformed
        // TODO add your handling code here:
        try {
            //crear objeto
            mascota mas = new mascota();
            //asignar datos
            mas.setNombre(nombretxt.getText());
            mas.setTipo(tipotxtcombo.getSelectedItem().toString());
            mas.setEdad(Integer.parseInt(edadtxt.getText()));
            // guardar objeto en el arreglo 
            listmascota.add(mas);
            // mostrar el objeto en jtbale
            modTabla.addRow(mas.RegistrarDato());
            //mostrar la cantidad dentro del label
            jLabel1.setText("mascostas registradas " + listmascota.size());
            
            JOptionPane.showMessageDialog(null," Mascostas registradas correctamente");
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "no se pudo registrar la mascota"+ex);
        }
    }//GEN-LAST:event_registrarbtnActionPerformed

    private void eliminarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarbtnActionPerformed
        int fila;
        //obtener la ila seleccionada 
        fila = tblmostrar.getSelectedRow();
        if(fila>=0){
            int res;
            res = JOptionPane.showConfirmDialog
                    (null,"Desea elminar la mascota",
                    "eliminar",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            if (res == JOptionPane.YES_OPTION){
                //elminar objeto de arreglo
                listmascota.remove(fila);
                
                //eliminar fila jtable
                modTabla.removeRow(fila);
                
                //actualizar el label
                jLabel1.setText("Mascota registrada"+listmascota.size());
                
            }
        }else{
            JOptionPane.showMessageDialog(null,"seleccione una mascota de la tabla");
        }
    }//GEN-LAST:event_eliminarbtnActionPerformed

//    public static void main(String args[]) {
//       
//        java.awt.EventQueue.invokeLater(() -> new formMascota().setVisible(true));
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField edadtxt;
    private javax.swing.JButton eliminarbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombretxt;
    private javax.swing.JButton registrarbtn;
    private javax.swing.JTable tblmostrar;
    private javax.swing.JComboBox<String> tipotxtcombo;
    // End of variables declaration//GEN-END:variables
}
