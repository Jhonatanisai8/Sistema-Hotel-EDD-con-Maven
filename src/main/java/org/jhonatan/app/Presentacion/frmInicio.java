package org.jhonatan.app.Presentacion;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhonatan
 */
public class frmInicio extends javax.swing.JFrame {

    public frmInicio() {
        initComponents();
        FlatMaterialLighterIJTheme.setup();
        this.setExtendedState(frmInicio.MAXIMIZED_BOTH);
        this.setTitle("BIENNVENIDO AL SISTEMA");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        lblNombre = new javax.swing.JLabel();
        lblIdPersona = new javax.swing.JLabel();
        lblAMaterno = new javax.swing.JLabel();
        lblAPATERNO = new javax.swing.JLabel();
        lblAcceso = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        munArchivo = new javax.swing.JMenu();
        munHabitaciones = new javax.swing.JMenuItem();
        munProductos = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        munReservasConsumos = new javax.swing.JMenuItem();
        munClientes = new javax.swing.JMenuItem();
        munPagos = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        munConfid = new javax.swing.JMenu();
        munUsuariosAccesos = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        munSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblNombre.setText("jLabel1");
        escritorio.add(lblNombre);
        lblNombre.setBounds(20, 70, 130, 40);

        lblIdPersona.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblIdPersona.setText("jLabel1");
        escritorio.add(lblIdPersona);
        lblIdPersona.setBounds(20, 30, 130, 40);

        lblAMaterno.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblAMaterno.setText("jLabel1");
        escritorio.add(lblAMaterno);
        lblAMaterno.setBounds(20, 150, 130, 40);

        lblAPATERNO.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblAPATERNO.setText("jLabel1");
        escritorio.add(lblAPATERNO);
        lblAPATERNO.setBounds(20, 110, 130, 40);

        lblAcceso.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblAcceso.setText("jLabel1");
        escritorio.add(lblAcceso);
        lblAcceso.setBounds(20, 190, 130, 40);

        fileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/casa (5).png"))); // NOI18N
        fileMenu.setMnemonic('f');
        fileMenu.setText("Sis.Reserva");
        fileMenu.setFont(new java.awt.Font("SimHei", 0, 15)); // NOI18N
        menuBar.add(fileMenu);

        munArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/carpeta.png"))); // NOI18N
        munArchivo.setMnemonic('e');
        munArchivo.setText("Archivo");
        munArchivo.setFont(new java.awt.Font("SimHei", 0, 15)); // NOI18N

        munHabitaciones.setFont(new java.awt.Font("Segoe UI Black", 0, 15)); // NOI18N
        munHabitaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/silencio.png"))); // NOI18N
        munHabitaciones.setMnemonic('p');
        munHabitaciones.setText("Habitaciones");
        munHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                munHabitacionesActionPerformed(evt);
            }
        });
        munArchivo.add(munHabitaciones);

        munProductos.setFont(new java.awt.Font("Segoe UI Black", 0, 15)); // NOI18N
        munProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/comida.png"))); // NOI18N
        munProductos.setMnemonic('d');
        munProductos.setText("Productos");
        munProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                munProductosActionPerformed(evt);
            }
        });
        munArchivo.add(munProductos);

        menuBar.add(munArchivo);

        helpMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reserva.png"))); // NOI18N
        helpMenu.setMnemonic('h');
        helpMenu.setText("Reservas");
        helpMenu.setFont(new java.awt.Font("SimHei", 0, 15)); // NOI18N

        munReservasConsumos.setFont(new java.awt.Font("Segoe UI Black", 0, 15)); // NOI18N
        munReservasConsumos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas.png"))); // NOI18N
        munReservasConsumos.setMnemonic('c');
        munReservasConsumos.setText("Reservas y consumos");
        munReservasConsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                munReservasConsumosActionPerformed(evt);
            }
        });
        helpMenu.add(munReservasConsumos);

        munClientes.setFont(new java.awt.Font("Segoe UI Black", 0, 15)); // NOI18N
        munClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario (2).png"))); // NOI18N
        munClientes.setMnemonic('a');
        munClientes.setText("Clientes");
        munClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                munClientesActionPerformed(evt);
            }
        });
        helpMenu.add(munClientes);

        munPagos.setFont(new java.awt.Font("Segoe UI Black", 0, 15)); // NOI18N
        munPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/metodo-de-pago.png"))); // NOI18N
        munPagos.setText("Pagos");
        helpMenu.add(munPagos);

        menuBar.add(helpMenu);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/consulta.png"))); // NOI18N
        jMenu1.setText("Consultas");
        jMenu1.setFont(new java.awt.Font("SimHei", 0, 15)); // NOI18N
        menuBar.add(jMenu1);

        munConfid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/configuraciones.png"))); // NOI18N
        munConfid.setText("Configuraciones");
        munConfid.setFont(new java.awt.Font("SimHei", 0, 15)); // NOI18N

        munUsuariosAccesos.setFont(new java.awt.Font("Segoe UI Black", 0, 15)); // NOI18N
        munUsuariosAccesos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario (2).png"))); // NOI18N
        munUsuariosAccesos.setText("Usuarios y Accesos");
        munUsuariosAccesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                munUsuariosAccesosActionPerformed(evt);
            }
        });
        munConfid.add(munUsuariosAccesos);

        menuBar.add(munConfid);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/computadora.png"))); // NOI18N
        jMenu3.setText("Herramientas");
        jMenu3.setFont(new java.awt.Font("SimHei", 0, 15)); // NOI18N
        menuBar.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ayuda.png"))); // NOI18N
        jMenu4.setText("Ayuda");
        jMenu4.setFont(new java.awt.Font("SimHei", 0, 15)); // NOI18N

        jMenuItem3.setFont(new java.awt.Font("Segoe UI Black", 0, 15)); // NOI18N
        jMenuItem3.setText("Acerca de ...");
        jMenu4.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Segoe UI Black", 0, 15)); // NOI18N
        jMenuItem4.setText("Ayuda");
        jMenu4.add(jMenuItem4);

        menuBar.add(jMenu4);

        munSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar-sesion.png"))); // NOI18N
        munSalir.setText("Salir");
        munSalir.setFont(new java.awt.Font("SimHei", 0, 15)); // NOI18N
        munSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                munSalirMouseClicked(evt);
            }
        });
        menuBar.add(munSalir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 1253, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void munReservasConsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_munReservasConsumosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_munReservasConsumosActionPerformed

    private void munProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_munProductosActionPerformed
        frmProductos d = new frmProductos();
        this.escritorio.add(d);
        d.toFront();
        d.setVisible(true);
    }//GEN-LAST:event_munProductosActionPerformed

    private void munHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_munHabitacionesActionPerformed
        frmHabitacion d = new frmHabitacion();
        this.escritorio.add(d);
        d.toFront();
        d.setVisible(true);
    }//GEN-LAST:event_munHabitacionesActionPerformed

    private void munClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_munClientesActionPerformed
        frmClientes d = new frmClientes();
        this.escritorio.add(d);
        d.toFront();
        d.setVisible(true);
    }//GEN-LAST:event_munClientesActionPerformed

    private void munUsuariosAccesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_munUsuariosAccesosActionPerformed
        frmTrabajador d = new frmTrabajador();
        this.escritorio.add(d);
        d.toFront();
        d.setVisible(true);
    }//GEN-LAST:event_munUsuariosAccesosActionPerformed

    private void munSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_munSalirMouseClicked
        int salir;
        salir = JOptionPane.showConfirmDialog(rootPane, "¿Desea Salir?", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
        if (salir == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_munSalirMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    public static javax.swing.JLabel lblAMaterno;
    public static javax.swing.JLabel lblAPATERNO;
    public static javax.swing.JLabel lblAcceso;
    public static javax.swing.JLabel lblIdPersona;
    public static javax.swing.JLabel lblNombre;
    private javax.swing.JMenuBar menuBar;
    public static javax.swing.JMenu munArchivo;
    private javax.swing.JMenuItem munClientes;
    public static javax.swing.JMenu munConfid;
    private javax.swing.JMenuItem munHabitaciones;
    private javax.swing.JMenuItem munPagos;
    private javax.swing.JMenuItem munProductos;
    private javax.swing.JMenuItem munReservasConsumos;
    private javax.swing.JMenu munSalir;
    private javax.swing.JMenuItem munUsuariosAccesos;
    // End of variables declaration//GEN-END:variables

}
