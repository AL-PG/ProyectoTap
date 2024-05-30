/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tap_proyecto1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;

import javax.swing.JOptionPane;
/**
 *
 * @author eveli
 */
public class pacienteFormulario1 extends javax.swing.JFrame {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/consultorio";
    private static final String USER = "postgres";
    private static final String PASS = "D277353527316d*";
    /**
     * Creates new form pacienteFormulario1
     */
    public pacienteFormulario1(verCitasAdmin parent, boolean modal) {
        initComponents();
       // nombre.setText("Nombres(s)");
        setLocationRelativeTo(null);

         guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreB = nombre.getText();
                String apellidosB = apellido.getText();
                String telefonoB = telefonoPaciente.getText();
                String estadoCivilB = null;
                if(soltero.isSelected()){
                    estadoCivilB = soltero.getText();
                } else if(casado.isSelected()){
                    estadoCivilB = casado.getText();
                } else if(viudo.isSelected()){
                    estadoCivilB = viudo.getText();
                }
                String correoB = correo.getText();
                String diaStr = (String) diaNacimiento.getSelectedItem();
                int diaInt = Integer.parseInt(diaStr);
                String mesStr = (String) mesNacimiento.getSelectedItem();
                int mesInt = Integer.parseInt(mesStr);
                int anioInt = Integer.parseInt(anioNacimiento.getText());

                LocalDate date = LocalDate.of(anioInt, mesInt, diaInt);
                Date fechaNacB = Date.valueOf(date);
                String motivoConsultaB = motivoVisita.getText();
                String antecedentesMedicB = antecentesMedicos.getText();
                String medicamentosActualesB = medicamentosMedicos.getText();
                String alergiasB = alergias.getText();
                String nombreSeguroB = nombreSeguro.getText();
                String numeroPolizaB = numeroPoliza.getText();
                String nombreTitularPoliaB = titularPoliza.getText();
                String contactoEmerNombreB = contactoEmergia.getText();
                String telefonoEmerB = telefonoEmergencia.getText();
                String relacionPacienteB = relacionPaciente.getText();
                String generoB = (String) sexx.getSelectedItem();


                insertPaciente(nombreB, apellidosB, telefonoB, estadoCivilB, correoB, fechaNacB, motivoConsultaB, antecedentesMedicB, medicamentosActualesB,
                alergiasB, nombreSeguroB, numeroPolizaB, nombreTitularPoliaB, contactoEmerNombreB, telefonoEmerB, relacionPacienteB, generoB);
            }

        });
       
    }
    public static void insertPaciente(String nombre, String apellidos, String telefono, String estadoCivil, 
                                     String correo, Date fechaNac, String motivoConsulta, String antecedentesMedic, 
                                     String medicamentosActuales, String alergias, String nombreSeguro, 
                                     String numeroPoliza, String nombreTitularPoliza, String contactoEmerNombre, 
                                     String telefonoEmer, String relacionPaciente, String genero) {
        String sql = "INSERT INTO public.paciente (nombre, apellidos, \"teléfono\", \"estadoCivil\", correo, " +
                     "\"fechaNac\", \"motivoConsulta\", \"antecedentesMedic\", \"medicamentosActuales\", alergias, " +
                     "\"nombreSeguro\", \"numeroPoliza\", \"nombreTitularPolia\", \"contactoEmerNombre\", " +
                     "\"telefonoEmer\", \"relacionPaciente\", genero) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, apellidos);
            pstmt.setString(3, telefono);
            pstmt.setString(4, estadoCivil);
            pstmt.setString(5, correo);
            pstmt.setDate(6, fechaNac);
            pstmt.setString(7, motivoConsulta);
            pstmt.setString(8, antecedentesMedic);
            pstmt.setString(9, medicamentosActuales);
            pstmt.setString(10, alergias);
            pstmt.setString(11, nombreSeguro);
            pstmt.setString(12, numeroPoliza);
            pstmt.setString(13, nombreTitularPoliza);
            pstmt.setString(14, contactoEmerNombre);
            pstmt.setString(15, telefonoEmer);
            pstmt.setString(16, relacionPaciente);
            pstmt.setString(17, genero);
    
            int row =  pstmt.executeUpdate();
    
            if (row > 0) {
                JOptionPane.showMessageDialog(null, "El paciente ha sido registrado exitosamente.");
            }
    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar el paciente: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        Titulo = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        apellido = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        sexx = new javax.swing.JComboBox<>();
        ocupacion = new javax.swing.JTextField();
        diaNacimiento = new javax.swing.JComboBox<>();
        mesNacimiento = new javax.swing.JComboBox<>();
        anioNacimiento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        telefonoPaciente = new javax.swing.JTextField();
        correo = new javax.swing.JTextField();
        informacionmedica = new javax.swing.JLabel();
        informacionSobreSeguro = new javax.swing.JLabel();
        antecentesMedicos = new javax.swing.JTextField();
        medicamentosMedicos = new javax.swing.JTextField();
        alergias = new javax.swing.JTextField();
        motivoVisita = new javax.swing.JTextField();
        nombreSeguro = new javax.swing.JTextField();
        numeroPoliza = new javax.swing.JTextField();
        titularPoliza = new javax.swing.JTextField();
        contactoEmergia = new javax.swing.JLabel();
        nombreCompleto = new javax.swing.JTextField();
        telefonoEmergencia = new javax.swing.JTextField();
        relacionPaciente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        consentimientoPaciente = new javax.swing.JLabel();
        nombreYFirma = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        acepto = new java.awt.Checkbox();
        guardar = new javax.swing.JButton();
        soltero = new javax.swing.JRadioButton();
        casado = new javax.swing.JRadioButton();
        viudo = new javax.swing.JRadioButton();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(92, 121, 144));

        Titulo.setBackground(new java.awt.Color(153, 153, 255));
        Titulo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        Titulo.setForeground(new java.awt.Color(51, 51, 255));
        Titulo.setText("DATOS PERSONALES");

        nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombreFocusLost(evt);
            }
        });
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });

        apellido.setText("Apellido(s)");
        apellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                apellidoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                apellidoFocusLost(evt);
            }
        });
        apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoActionPerformed(evt);
            }
        });

        direccion.setText("Dirección");
        direccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                direccionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                direccionFocusLost(evt);
            }
        });

        sexx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mujer", "Hombre" }));
        sexx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexxActionPerformed(evt);
            }
        });

        ocupacion.setText("Ocupación");
        ocupacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ocupacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ocupacionFocusLost(evt);
            }
        });
        ocupacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ocupacionActionPerformed(evt);
            }
        });

        diaNacimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        diaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diaNacimientoActionPerformed(evt);
            }
        });

        mesNacimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        mesNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesNacimientoActionPerformed(evt);
            }
        });

        anioNacimiento.setText("Año");
        anioNacimiento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                anioNacimientoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                anioNacimientoFocusLost(evt);
            }
        });
        anioNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anioNacimientoActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha de Nacimiento");

        telefonoPaciente.setText("Télefono");
        telefonoPaciente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                telefonoPacienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                telefonoPacienteFocusLost(evt);
            }
        });

        correo.setText("Correro Electronico");
        correo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                correoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                correoFocusLost(evt);
            }
        });

        informacionmedica.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        informacionmedica.setForeground(new java.awt.Color(51, 51, 255));
        informacionmedica.setText("INFORMACIÓN MEDICA");

        informacionSobreSeguro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        informacionSobreSeguro.setForeground(new java.awt.Color(51, 51, 255));
        informacionSobreSeguro.setText("INFORMACIÓN SOBRE SEGURO MÉDICO");

        antecentesMedicos.setText("Antecedentes Medicos");
        antecentesMedicos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                antecentesMedicosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                antecentesMedicosFocusLost(evt);
            }
        });
        antecentesMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                antecentesMedicosActionPerformed(evt);
            }
        });

        medicamentosMedicos.setText("Medicamentos Actuales");
        medicamentosMedicos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                medicamentosMedicosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                medicamentosMedicosFocusLost(evt);
            }
        });

        alergias.setText("Alergias");
        alergias.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                alergiasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                alergiasFocusLost(evt);
            }
        });

        motivoVisita.setText("Motivo de Consulta");
        motivoVisita.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                motivoVisitaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                motivoVisitaFocusLost(evt);
            }
        });

        nombreSeguro.setText("Nombre de Seguro");
        nombreSeguro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombreSeguroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombreSeguroFocusLost(evt);
            }
        });
        nombreSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreSeguroActionPerformed(evt);
            }
        });

        numeroPoliza.setText("Numero de Poliza");
        numeroPoliza.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                numeroPolizaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                numeroPolizaFocusLost(evt);
            }
        });

        titularPoliza.setText("Nombre de Titular de la Poliza");
        titularPoliza.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                titularPolizaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                titularPolizaFocusLost(evt);
            }
        });

        contactoEmergia.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        contactoEmergia.setForeground(new java.awt.Color(51, 51, 255));
        contactoEmergia.setText("CONTACTO DE EMERGENCIA");

        nombreCompleto.setText("Nombre Completo");
        nombreCompleto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombreCompletoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombreCompletoFocusLost(evt);
            }
        });
        nombreCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreCompletoActionPerformed(evt);
            }
        });

        telefonoEmergencia.setText("Teléfono");
        telefonoEmergencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                telefonoEmergenciaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                telefonoEmergenciaFocusLost(evt);
            }
        });
        telefonoEmergencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoEmergenciaActionPerformed(evt);
            }
        });

        relacionPaciente.setText("Relación con el Paciente");
        relacionPaciente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                relacionPacienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                relacionPacienteFocusLost(evt);
            }
        });
        relacionPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relacionPacienteActionPerformed(evt);
            }
        });

        consentimientoPaciente.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        consentimientoPaciente.setForeground(new java.awt.Color(51, 51, 255));
        consentimientoPaciente.setText("CONSENTIMIENTO DEL PACIENTE");

        nombreYFirma.setText("Nombre y firma paciente");

        fecha.setText("Fecha");

        acepto.setLabel("Acepto");

        guardar.setText("GUARDAR");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        buttonGroup1.add(soltero);
        soltero.setText("Soltero");

        buttonGroup1.add(casado);
        casado.setText("Casado");

        buttonGroup1.add(viudo);
        viudo.setText("Viudo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(motivoVisita)
                            .addComponent(alergias)
                            .addComponent(medicamentosMedicos)
                            .addComponent(antecentesMedicos)
                            .addComponent(telefonoPaciente)
                            .addComponent(nombre)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sexx, 0, 82, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ocupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(direccion)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(informacionmedica)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(diaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(casado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mesNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(anioNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(soltero, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(titularPoliza, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(numeroPoliza, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nombreSeguro, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(correo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(informacionSobreSeguro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(consentimientoPaciente))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(contactoEmergia))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(480, 480, 480)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(acepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(nombreYFirma, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(telefonoEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(relacionPaciente)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(Titulo)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(Titulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(direccion)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(diaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anioNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mesNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ocupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sexx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(soltero)
                            .addComponent(casado)
                            .addComponent(viudo))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(informacionSobreSeguro)
                    .addComponent(informacionmedica, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(motivoVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(antecentesMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroPoliza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(medicamentosMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titularPoliza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contactoEmergia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(relacionPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(consentimientoPaciente)
                .addGap(21, 21, 21)
                .addComponent(acepto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel6)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreYFirma)
                    .addComponent(fecha)
                    .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void diaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diaNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diaNacimientoActionPerformed

    private void mesNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesNacimientoActionPerformed

    private void ocupacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ocupacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ocupacionActionPerformed

    private void sexxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexxActionPerformed

    private void anioNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anioNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anioNacimientoActionPerformed

    private void antecentesMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_antecentesMedicosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_antecentesMedicosActionPerformed

    private void nombreSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreSeguroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreSeguroActionPerformed

    private void telefonoEmergenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoEmergenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoEmergenciaActionPerformed

    private void nombreCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreCompletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreCompletoActionPerformed

    private void relacionPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacionPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_relacionPacienteActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void nombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreFocusGained
     //  if(nombre.getText().equals("Nombre(s)")){
           nombre.setText("");
      // }
       
    }//GEN-LAST:event_nombreFocusGained

    private void nombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreFocusLost
        if (nombre.getText().isEmpty()){
            nombre.setText("Nombre(s)");
        }
    }//GEN-LAST:event_nombreFocusLost

    private void apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoActionPerformed

    private void apellidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_apellidoFocusGained
           apellido.setText("");
    }//GEN-LAST:event_apellidoFocusGained

    private void apellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_apellidoFocusLost
        if (apellido.getText().isEmpty()){
        apellido.setText("Apellido(s)");
        }
    }//GEN-LAST:event_apellidoFocusLost

    private void direccionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_direccionFocusGained
        direccion.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_direccionFocusGained

    private void direccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_direccionFocusLost
        if (direccion.getText().isEmpty()){
        direccion.setText("Direccion");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_direccionFocusLost

    private void ocupacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ocupacionFocusGained
        // TODO add your handling code here:
        ocupacion.setText("");
    }//GEN-LAST:event_ocupacionFocusGained

    private void ocupacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ocupacionFocusLost
        if (ocupacion.getText().isEmpty()){
        ocupacion.setText("Ocupacion");
        }        
// TODO add your handling code here:
    }//GEN-LAST:event_ocupacionFocusLost

    private void anioNacimientoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_anioNacimientoFocusGained
        // TODO add your handling code here:
        anioNacimiento.setText("");
    }//GEN-LAST:event_anioNacimientoFocusGained

    private void anioNacimientoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_anioNacimientoFocusLost
        // TODO add your handling code here:
        if (anioNacimiento.getText().isEmpty()){
        anioNacimiento.setText("año");
        }
    }//GEN-LAST:event_anioNacimientoFocusLost

    private void telefonoPacienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telefonoPacienteFocusGained
        // TODO add your handling code here:
        telefonoPaciente.setText("");
    }//GEN-LAST:event_telefonoPacienteFocusGained

    private void telefonoPacienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telefonoPacienteFocusLost
        // TODO add your handling code here:
        if (telefonoPaciente.getText().isEmpty()){
        telefonoPaciente.setText("Telefono");
        }
    }//GEN-LAST:event_telefonoPacienteFocusLost

    private void correoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_correoFocusGained
        // TODO add your handling code here:
        correo.setText("");
    }//GEN-LAST:event_correoFocusGained

    private void correoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_correoFocusLost
        // TODO add your handling code here:
        if (correo.getText().isEmpty()){
            correo.setText("Correo Electronico");
        }
    }//GEN-LAST:event_correoFocusLost

    private void motivoVisitaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_motivoVisitaFocusGained
        // TODO add your handling code here:
        motivoVisita.setText("");
    }//GEN-LAST:event_motivoVisitaFocusGained

    private void motivoVisitaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_motivoVisitaFocusLost
        // TODO add your handling code here:
        if (motivoVisita.getText().isEmpty()){
        motivoVisita.setText("Motivo de Consulta");
        }
    }//GEN-LAST:event_motivoVisitaFocusLost

    private void nombreSeguroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreSeguroFocusGained
        // TODO add your handling code here:
        nombreSeguro.setText("");
    }//GEN-LAST:event_nombreSeguroFocusGained

    private void nombreSeguroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreSeguroFocusLost
        // TODO add your handling code here:
        if (nombreSeguro.getText().isEmpty()){
        nombreSeguro.setText("Nombre de seguro");
        }
    }//GEN-LAST:event_nombreSeguroFocusLost

    private void antecentesMedicosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_antecentesMedicosFocusGained
        // TODO add your handling code here:
        antecentesMedicos.setText("");
    }//GEN-LAST:event_antecentesMedicosFocusGained

    private void antecentesMedicosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_antecentesMedicosFocusLost
        // TODO add your handling code here:
         if (antecentesMedicos.getText().isEmpty()){
        antecentesMedicos.setText("Antecedentes Medicos");
        }
    }//GEN-LAST:event_antecentesMedicosFocusLost

    private void numeroPolizaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numeroPolizaFocusGained
        // TODO add your handling code here:
        numeroPoliza.setText("");
    }//GEN-LAST:event_numeroPolizaFocusGained

    private void numeroPolizaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numeroPolizaFocusLost
        // TODO add your handling code here:
         if (numeroPoliza.getText().isEmpty()){
        numeroPoliza.setText("Numero de Poliza");
        }
    }//GEN-LAST:event_numeroPolizaFocusLost

    private void medicamentosMedicosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_medicamentosMedicosFocusGained
        // TODO add your handling code here:
        medicamentosMedicos.setText("");
    }//GEN-LAST:event_medicamentosMedicosFocusGained

    private void medicamentosMedicosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_medicamentosMedicosFocusLost
        // TODO add your handling code here:
         if (medicamentosMedicos.getText().isEmpty()){
        medicamentosMedicos.setText("Medicamentos Actuales");
        }
    }//GEN-LAST:event_medicamentosMedicosFocusLost

    private void titularPolizaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_titularPolizaFocusGained
        // TODO add your handling code here:
        titularPoliza.setText("");
    }//GEN-LAST:event_titularPolizaFocusGained

    private void titularPolizaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_titularPolizaFocusLost
        // TODO add your handling code here:
         if (titularPoliza.getText().isEmpty()){
        titularPoliza.setText("Nombre Titular de la Poliza");
        }
    }//GEN-LAST:event_titularPolizaFocusLost

    private void alergiasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_alergiasFocusGained
        // TODO add your handling code here:
        alergias.setText("");
    }//GEN-LAST:event_alergiasFocusGained

    private void alergiasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_alergiasFocusLost
        // TODO add your handling code here:
         if (alergias.getText().isEmpty()){
        alergias.setText("Alergias");
        }
    }//GEN-LAST:event_alergiasFocusLost

    private void nombreCompletoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreCompletoFocusGained
        // TODO add your handling code here:
        nombreCompleto.setText("");
        
    }//GEN-LAST:event_nombreCompletoFocusGained

    private void nombreCompletoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreCompletoFocusLost
        // TODO add your handling code here:
         if (nombreCompleto.getText().isEmpty()){
        nombreCompleto.setText("Nombre Completo");
        }
    }//GEN-LAST:event_nombreCompletoFocusLost

    private void telefonoEmergenciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telefonoEmergenciaFocusGained
        // TODO add your handling code here:
        telefonoEmergencia.setText("");
    }//GEN-LAST:event_telefonoEmergenciaFocusGained

    private void telefonoEmergenciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telefonoEmergenciaFocusLost
        // TODO add your handling code here:
         if (telefonoEmergencia.getText().isEmpty()){
        telefonoEmergencia.setText("Telefono");
        }
    }//GEN-LAST:event_telefonoEmergenciaFocusLost

    private void relacionPacienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_relacionPacienteFocusGained
        // TODO add your handling code here:
        relacionPaciente.setText("");
    }//GEN-LAST:event_relacionPacienteFocusGained

    private void relacionPacienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_relacionPacienteFocusLost
        // TODO add your handling code here:
         if (relacionPaciente.getText().isEmpty()){
        relacionPaciente.setText("Relacion con el Paciente");
        }
    }//GEN-LAST:event_relacionPacienteFocusLost

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guardarActionPerformed

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
            java.util.logging.Logger.getLogger(pacienteFormulario1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pacienteFormulario1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pacienteFormulario1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pacienteFormulario1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private java.awt.Checkbox acepto;
    private javax.swing.JTextField alergias;
    private javax.swing.JTextField anioNacimiento;
    private javax.swing.JTextField antecentesMedicos;
    private javax.swing.JTextField apellido;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton casado;
    private javax.swing.JLabel consentimientoPaciente;
    private javax.swing.JLabel contactoEmergia;
    private javax.swing.JTextField correo;
    private javax.swing.JComboBox<String> diaNacimiento;
    private javax.swing.JTextField direccion;
    private javax.swing.JLabel fecha;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel informacionSobreSeguro;
    private javax.swing.JLabel informacionmedica;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField medicamentosMedicos;
    private javax.swing.JComboBox<String> mesNacimiento;
    private javax.swing.JTextField motivoVisita;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField nombreCompleto;
    private javax.swing.JTextField nombreSeguro;
    private javax.swing.JLabel nombreYFirma;
    private javax.swing.JTextField numeroPoliza;
    private javax.swing.JTextField ocupacion;
    private javax.swing.JTextField relacionPaciente;
    private javax.swing.JComboBox<String> sexx;
    private javax.swing.JRadioButton soltero;
    private javax.swing.JTextField telefonoEmergencia;
    private javax.swing.JTextField telefonoPaciente;
    private javax.swing.JTextField titularPoliza;
    private javax.swing.JRadioButton viudo;
    // End of variables declaration//GEN-END:variables
}
