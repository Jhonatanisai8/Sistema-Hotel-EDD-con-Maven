package org.jhonatan.app.Presentacion;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jhonatan.app.Datos.Habitacion;
import org.jhonatan.app.Logica.FHabitacion;

/**
 *
 * @author JHONATAN
 */
public class frmHabitacion extends javax.swing.JInternalFrame {

    public frmHabitacion() {
        initComponents();
        this.setTitle("Registro de habitaciones");
//        FlatMaterialLighterIJTheme.setup();
        FlatMaterialLighterIJTheme.setup();
        mostrarDatos("");
        inHabilitar();
        ocultarColumnas();
    }
    private String accion = "guardar";

    //la columa a ocultar es la que contiene el Id habitacion
    void ocultarColumnas() {
        tblDatos.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDatos.getColumnModel().getColumn(0).setMinWidth(0);
        tblDatos.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    void inHabilitar() {
        txtId.setVisible(false);
        cbxPiso.setEnabled(false);
        txtNumeroHabi.setEnabled(false);
        txtDescripcion.setEnabled(false);
        txtCaracteristicas.setEnabled(false);
        txtPrecioUnitario.setEnabled(false);

        cbxEstado.setEnabled(false);
        cbxTipoHabitacion.setEnabled(false);

        //botones
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);

        //cajas de texto 
        txtId.setText("");
        txtPrecioUnitario.setText("");
        txtCaracteristicas.setText("");
        txtDescripcion.setText("");
        txtNumeroHabi.setText("");
        cbxPiso.setSelectedIndex(0);
    }

    void habilitar() {
        txtId.setVisible(false);

        cbxPiso.setEnabled(true);
        txtNumeroHabi.setEnabled(true);
        txtDescripcion.setEnabled(true);
        txtCaracteristicas.setEnabled(true);
        txtPrecioUnitario.setEnabled(true);
        cbxEstado.setEnabled(true);
        cbxTipoHabitacion.setEnabled(true);

        //botones
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(true);

        //cajas de texto 
        txtId.setText("");
        txtPrecioUnitario.setText("");
        txtCaracteristicas.setText("");
        txtDescripcion.setText("");
        txtNumeroHabi.setText("");
        cbxPiso.setSelectedIndex(0);
    }

    void mostrarDatos(String buscar) {
        try {
            DefaultTableModel modelo;
            FHabitacion func = new FHabitacion();

            //llamamos al funcion mostrar de la clase fhHABITACION
            modelo = func.mostrarDatosHabitacion(buscar);

            tblDatos.setModel(modelo);
            ocultarColumnas();

            lblTotalRegistros.setText("Total de registros: " + func.totalRegistros);
        } catch (Exception e) {
            System.out.println("Error al mostrar: " + e.toString());
        }
    }

    void nuevaHabitacion() {
        habilitar();
        btnGuardar.setText("Guardar");
        accion = "guardar";
    }

    private String validarCampos() {
        if (txtNumeroHabi.getText().trim().isEmpty() || (Integer.parseInt(txtNumeroHabi.getText()) < 0)) {
            txtNumeroHabi.requestFocus();
            return "Número";
        }

        if (txtDescripcion.getText().length() == 0) {
            txtDescripcion.requestFocus();
            return "Descripción";
        }

        if (txtCaracteristicas.getText().length() == 0) {
            txtCaracteristicas.requestFocus();
            return "Caracteristicas";
        }

        if (txtPrecioUnitario.getText().length() == 0 || (Double.parseDouble(txtPrecioUnitario.getText()) < 0)) {
            txtPrecioUnitario.requestFocus();
            return "Precio Unitario";
        }

        if (cbxPiso.getSelectedItem().toString().equalsIgnoreCase("=Seleccionar=")) {
            return "Piso de la habitación";
        }

        if (cbxEstado.getSelectedItem().toString().equalsIgnoreCase("=Seleccionar=")) {
            return "Estado de la habitación";
        }

        if (cbxTipoHabitacion.getSelectedItem().toString().equalsIgnoreCase("=Seleccionar=")) {
            return "Tipo de habitación";
        }
        //si aquellos campos estan vacios returnamos un texto vacio
        return "";
    }

    void guardarRegistro() {
        String campo;
        campo = validarCampos();
        Habitacion habitacion = new Habitacion();
        FHabitacion fHabitacion = new FHabitacion();
        if (campo.equals("")) {
            habitacion.setNumero(txtNumeroHabi.getText());

            int seleccion = cbxPiso.getSelectedIndex();
            habitacion.setPiso(cbxPiso.getItemAt(seleccion));

            habitacion.setDescripcion(txtDescripcion.getText());
            habitacion.setCaracteristicas(txtCaracteristicas.getText());
            habitacion.setPrecioDiario(Double.parseDouble(txtPrecioUnitario.getText()));

            seleccion = cbxEstado.getSelectedIndex();
            habitacion.setEstado(cbxEstado.getItemAt(seleccion));

            seleccion = cbxTipoHabitacion.getSelectedIndex();
            habitacion.setTipoHabitacion(cbxTipoHabitacion.getItemAt(seleccion));

            if (accion.equalsIgnoreCase("Guardar")) {
                //llamamos al metodo de la clase fHabitacion
                if (fHabitacion.insertarHabitacion(habitacion)) {
                    JOptionPane.showMessageDialog(rootPane, "LA HABITACIÓN FUE REGISTRADA CON EXÍTO", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
                    //llamos al procecimiento mostrar
                    mostrarDatos("");
                    inHabilitar();
                }
            } else if (accion.equalsIgnoreCase("EDITAR")) {
                habitacion.setIdHabitacion(Integer.parseInt(txtId.getText()));
                if (fHabitacion.modificarHabitacion(habitacion)) {
                    JOptionPane.showMessageDialog(rootPane, "LA HABITACIÓN FUE EDITADA EXITOSAMENTE", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
                    mostrarDatos("");
                    inHabilitar();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Verifique los  datos en el campo: " + campo, "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNumeroHabi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbxPiso = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCaracteristicas = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txtPrecioUnitario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbxTipoHabitacion = new javax.swing.JComboBox<>();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        txtBuscar = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        lblTotalRegistros = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Habitaciones:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        jLabel2.setText("Nº de Habitacion:");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtNumeroHabi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroHabiActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        jLabel3.setText("Piso:");

        cbxPiso.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxPiso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=Seleccionar=", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cbxPiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPisoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        jLabel4.setText("Descripcion:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel5.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        jLabel5.setText("Caracteristicas:");

        txtCaracteristicas.setColumns(20);
        txtCaracteristicas.setRows(5);
        jScrollPane2.setViewportView(txtCaracteristicas);

        jLabel6.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        jLabel6.setText("Precio Diario");

        txtPrecioUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioUnitarioActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        jLabel7.setText("Estado:");

        cbxEstado.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=Seleccionar=", "Disponible", "Ocupado", "Mantenimiento" }));
        cbxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        jLabel8.setText("Tipo de Habitacion:");

        cbxTipoHabitacion.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        cbxTipoHabitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=Seleccionar=", "Individual", "Familiar", "Matrimonial", "Presidencial" }));
        cbxTipoHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoHabitacionActionPerformed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/register (1).png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar (1).png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelled.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecioUnitario)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(50, 50, 50)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxPiso, 0, 0, Short.MAX_VALUE)
                                .addGap(60, 60, 60))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumeroHabi)
                                    .addComponent(txtId))
                                .addGap(36, 36, 36)))))
                .addGap(39, 39, 39))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxEstado, 0, 0, Short.MAX_VALUE)
                    .addComponent(cbxTipoHabitacion, 0, 145, Short.MAX_VALUE))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNumeroHabi, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(cbxPiso)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                        .addGap(58, 58, 58))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                        .addGap(46, 46, 46))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jLabel1.setText("Registrar");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de Habitaciones:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 12))); // NOI18N

        tblDatos.setFont(new java.awt.Font("SimHei", 0, 15)); // NOI18N
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nº Habitacion", "Piso", "Descripcion", "Caracteristicas", "Precio Diario", "Estado", "Tipo de Habitacion"
            }
        ));
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDatos);

        txtBuscar.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir (2).png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel10.setText("Buscar:");

        lblTotalRegistros.setFont(new java.awt.Font("Segoe UI Symbol", 0, 15)); // NOI18N
        lblTotalRegistros.setText("Registros");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addGap(4, 4, 4)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(378, 378, 378))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(lblTotalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        int salir;

        salir = JOptionPane.showConfirmDialog(rootPane, "¿Desea Salir?");

        if (salir == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    public void elimarHabitacion() {
        if (!txtId.getText().trim().isEmpty()) {
            int confirmar;
            confirmar = JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de eliminar dicha habitacion?", "CONFIRMA", JOptionPane.WARNING_MESSAGE);

            //si la confirmacion es si eliminamos
            if (confirmar == 0) {

                FHabitacion fHabitacion = new FHabitacion();
                Habitacion habitacion = new Habitacion();

                habitacion.setIdHabitacion(Integer.parseInt(txtId.getText()));
                fHabitacion.eliminarHabitacion(habitacion);
                mostrarDatos("");
                inHabilitar();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Por favor ingrese el Id de la habitación a Eliminar", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevaHabitacion();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarRegistro();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        elimarHabitacion();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtBuscar.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Por favor ingresa la habitacion a buscar", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
        } else {
            mostrarDatos(txtBuscar.getText());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtNumeroHabiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroHabiActionPerformed
        /*este metodo nos sirve para que cada ves que presiones la tecla enter nos lleve a otro formulario*/
        txtNumeroHabi.transferFocus();
    }//GEN-LAST:event_txtNumeroHabiActionPerformed

    private void cbxPisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPisoActionPerformed
        cbxPiso.transferFocus();
    }//GEN-LAST:event_cbxPisoActionPerformed

    private void txtPrecioUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioUnitarioActionPerformed
        txtPrecioUnitario.transferFocus();
    }//GEN-LAST:event_txtPrecioUnitarioActionPerformed

    private void cbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoActionPerformed
        cbxEstado.transferFocus();
    }//GEN-LAST:event_cbxEstadoActionPerformed

    private void cbxTipoHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoHabitacionActionPerformed
        cbxTipoHabitacion.transferFocus();
    }//GEN-LAST:event_cbxTipoHabitacionActionPerformed

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
        btnGuardar.setText("Editar");
        habilitar();
        btnEliminar.setEnabled(true);
        accion = "Editar";

        //obtenemos la fila selecionada
        int fila = tblDatos.rowAtPoint(evt.getPoint());
        txtId.setText(tblDatos.getValueAt(fila, 0).toString());
        txtNumeroHabi.setText(tblDatos.getValueAt(fila, 1).toString());
        cbxPiso.setSelectedItem(tblDatos.getValueAt(fila, 2).toString());
        txtDescripcion.setText(tblDatos.getValueAt(fila, 3).toString());
        txtCaracteristicas.setText(tblDatos.getValueAt(fila, 4).toString());
        txtPrecioUnitario.setText(tblDatos.getValueAt(fila, 5).toString());
        cbxEstado.setSelectedItem(tblDatos.getValueAt(fila, 6).toString());
        cbxTipoHabitacion.setSelectedItem(tblDatos.getValueAt(fila, 7).toString());
    }//GEN-LAST:event_tblDatosMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(frmHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmHabitacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxPiso;
    private javax.swing.JComboBox<String> cbxTipoHabitacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextArea txtCaracteristicas;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNumeroHabi;
    private javax.swing.JTextField txtPrecioUnitario;
    // End of variables declaration//GEN-END:variables
}
