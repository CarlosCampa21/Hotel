import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Ventana extends JFrame {
	JPanel actual=null;
	JPanel anterior=null;
	JPanel bienvenida;
	JPanel login;
	JPanel miCuentaPanel;
	JPanel registro;
	JPanel perfil;
	JPanel consultar;
	JPanel accesoPermitido;
    JPanel listaUsuarios;
    
	String nombre, imagen="material-escolar(1).PNG";
	
	DefaultTableModel tableModel;
	
	JTable table;
	
	private String[] alumnosColumns  = {"Nombre", "Apellidos", "Fechad de nacimiento", "Correo", "Telefono", "Foto"};
	private String[] maestrosColumns = {"Nombre", "Apellidos", "Fechad de nacimiento", "Correo", "Telefono", "Grado de estudio", "Foto"};
	
	ArrayList<String[]> usersList;
	
	private int posicionUsuario;
	
    private JPanel filtroUsuarios;
    private boolean estudiante = true;
    private boolean docente = true;

	private DefaultTableModel modelo;

    private JLabel imageLabel;
	
	public Ventana() {
		this.setVisible(true);
		this.setSize(1000, 640);
		this.setLocationRelativeTo(null);
		this.setTitle("ZENT");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.decode("#101010"));
		
		getMaestros();
	
		Bienvenida();
		timer();
		repaint();
		revalidate();
		
		
	}
	
	
	public void timer() {//Funcion timer realizada
		
		Timer timer = new Timer();
		
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {
				Login();
			}
		};
		
		timer.schedule(tarea, 2000);
		
	}

	
	public void Bienvenida() {

		bienvenida = new JPanel();
		bienvenida.setSize(1000, 600);
		bienvenida.setLocation(0,0);
		bienvenida.setLayout(null);
        bienvenida.setBackground(Color.decode("#101010"));
		/*
		JLabel titleinicio = new JLabel("Inicio",JLabel.CENTER);
		titleinicio.setFont(new Font("Comic Sans", Font.BOLD,30));
		titleinicio.setSize(260, 40);
		titleinicio.setLocation(130, 200);
		titleinicio.setOpaque(false);
		titleinicio.setBackground(Color.decode("#101010"));
		bienvenida.add(titleinicio);*/
		
		JLabel fondo = new JLabel(new ImageIcon("logo.PNG"));
		fondo.setBounds(175, 150, 658, 269);//ANCHO X, Y,TAMAÑO EC0307 008299
		bienvenida.add(fondo);
	
		
		
		actual=bienvenida;
		
		add(actual);
		
		repaint();
		revalidate();
	}
	
		
	
	public void menuMiCuenta() {
		miCuentaPanel = new JPanel();
		miCuentaPanel.setSize(1000, 600);
		miCuentaPanel.setLocation(0,0);
		miCuentaPanel.setLayout(null);
	    miCuentaPanel.setBackground(Color.decode("#dce7ec"));
		
		JLabel editarPerfil = new JLabel();
		editarPerfil.setText("Bienvenido "+ nombre);
		editarPerfil.setFont(new Font("Comic Sans", Font.BOLD,20));
		editarPerfil.setBounds(100, 10, 300, 80);
		editarPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		editarPerfil.setForeground(Color.decode("#1f7690"));
		editarPerfil.setFont(new Font("cooper black",0,25));
		miCuentaPanel.add(editarPerfil);
		
		JLabel iconoLista = new JLabel(new ImageIcon("material-escolar (1).PNG"));
		iconoLista.setBounds(165, 80, 170, 170);
		miCuentaPanel.add(iconoLista);

	    JLabel nameLabel = new JLabel("Nombre:");
        nameLabel.setBounds(70, 270, 100, 20);
        JTextField nameField = new JTextField();
        nameField.setBounds(200, 270, 200, 20);

        JLabel apellidoLabel = new JLabel("Apellido:");
        apellidoLabel.setBounds(70, 300, 100, 20);
        JTextField apellidoField = new JTextField();
        apellidoField.setBounds(200, 300, 200, 20);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(70, 330, 100, 20);
        JTextField emailField = new JTextField();
        emailField.setBounds(200, 330, 200, 20);
        

        JLabel NumTelefono = new JLabel("Numero telefonico:");
        NumTelefono.setBounds(70, 360, 110, 20);
        JTextField NumeroTelefono = new JTextField();
        NumeroTelefono.setBounds(200, 360, 200, 20);
        NumeroTelefono.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char character = e.getKeyChar();
                if (!(Character.isDigit(character) ||
                      (character == KeyEvent.VK_BACK_SPACE) ||
                      (character == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
            }
        });
        
        

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(70, 390, 100, 20);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(200, 390, 200, 20);


        JLabel confirmPasswordLabel = new JLabel("Confirmar contraseña:");
        confirmPasswordLabel.setBounds(70, 420, 150, 20);
        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(200, 420, 150, 20);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setBounds(150, 450, 100, 30);

        JButton updateButton = new JButton("Actualizar datos");
        updateButton.setBounds(260, 450, 130, 30);

        miCuentaPanel.add(nameLabel);
        miCuentaPanel.add(nameField);
        miCuentaPanel.add(apellidoLabel);
        miCuentaPanel.add(apellidoField);
        miCuentaPanel.add(emailLabel);
        miCuentaPanel.add(emailField);
        miCuentaPanel.add(NumTelefono);
        miCuentaPanel.add(NumeroTelefono);
        miCuentaPanel.add(passwordLabel);
        miCuentaPanel.add(passwordField);
        miCuentaPanel.add(confirmPasswordLabel);
        miCuentaPanel.add(confirmPasswordField);
        miCuentaPanel.add(cancelButton);
        miCuentaPanel.add(updateButton);

		JLabel fondo = new JLabel(new ImageIcon("fondo2.PNG"));
		fondo.setBounds(-2, 1, 1000, 600);//ANCHO X, Y,TAMAÑO
		miCuentaPanel.add(fondo);
        
        cancelButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        
		       Perfil();
		    }
		});
        
        updateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				actualizarUsuario(nameField, apellidoField, emailField, NumeroTelefono, passwordField, confirmPasswordField, posicionUsuario);
			    }
        	
        });
        
        
        anterior = actual;
        actual = miCuentaPanel;
        
        remove(anterior);
        add(actual);
        
        revalidate();
        repaint();
	}
	
	
	public void Login () {
		login = new JPanel();
		login.setSize(1000, 600);
		login.setLocation(0,0);
		login.setLayout(null);
        login.setBackground(Color.decode("#dce7ec"));
		


		JButton iniciarSesion = new JButton();
		iniciarSesion.setText("Iniciar Sesión");
		iniciarSesion.setSize(115, 20);
		iniciarSesion.setLocation(394, 350);
		iniciarSesion.setOpaque(false);
		iniciarSesion.setForeground(Color.decode("#9F9E9D"));
		iniciarSesion.setBackground(Color.decode("#5C87C0"));
		login.add(iniciarSesion);
		
		JButton registro = new JButton();
		registro.setText("Registrarse");
		registro.setSize(115, 20);
		registro.setLocation(515, 350);//1C1E24	9F9E9D
		registro.setOpaque(false);
		registro.setForeground(Color.decode("#9F9E9D"));
		registro.setBackground(Color.decode("#5C87C0"));		
		login.add(registro);
		
		JTextField username = new JTextField("ZENT_01@alu.uabcs.mx");
		username.setSize(185, 34);
		username.setLocation(438, 216);
		username.setOpaque(true);
		username.setForeground(Color.decode("#828387"));
		username.setBackground(Color.decode("#1C1E24"));
		login.add(username);
		
		JPasswordField password = new JPasswordField("1");
		password.setSize(185, 34);
		password.setLocation(438, 280);
		password.setOpaque(true);
		password.setForeground(Color.decode("#828387"));
		password.setBackground(Color.decode("#1C1E24"));
		login.add(password);
		
		registro.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {

				remove(actual);
				//filtroUsuarios();	
				//Perfil();
				menuCrearUsuario();
				repaint();
				revalidate();
			}
			
		});
		
		iniciarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String user = username.getText();
				String pwd = new String (password.getPassword());
				
				BufferedReader reader;
				
				Boolean flag = false;
				
				try{
					
					FileReader file = new FileReader("users.txt");
					reader = new BufferedReader(file);
					
					String line = reader.readLine();
					
					int aux=0;
					
					if(estudiante==true)
					{
						if(user.contains("@alu.uabcs.mx") && !user.contains("@uabcs.mx") ) {//FILTROS PARA LOS CORREOS DE ESTUDIANTES O DOCENTES
							while(line != null) {  
								
									
								String data [] = line.split(",");
								
								for (int i = 0; i < data.length; i++) {

									System.out.println(data[i]); 
								}
								 
								if( user.equals(data[3]) ) {
									
									if( pwd.equals(data[5]) ) {
										posicionUsuario = aux;
										flag = true;
									}
								} 
								
								line = reader.readLine();
								aux++;
								
								
							}
						}else {
							JOptionPane.showMessageDialog(null, "Usuario incorrecto","ERROR",JOptionPane.ERROR_MESSAGE );
						}
						
					}//FIN DEL IF 
					else {
						if(docente==false) {
							if(!user.contains("@alu.uabcs.mx") && user.contains("@uabcs.mx")) {
								while(line != null) {
									
										
									String data [] = line.split(",");
									 
									if( user.equals(data[3]) ) {
										
										if( pwd.equals(data[5]) ) {
											posicionUsuario = aux;
											flag = true;
										}
									} 
									
									line = reader.readLine();
									aux++;
									
									
								}
							}else {
								JOptionPane.showMessageDialog(null, "Usuario incorrecto","ERROR",JOptionPane.ERROR_MESSAGE );
							}
						}
					}
					if(flag==true) {
						
						String[] datos = getDatosUsuario(posicionUsuario);
						
						nombre = datos[0];
						JOptionPane.showMessageDialog(null,"Bienvenido "+nombre,"Acceso Permitido", JOptionPane.CLOSED_OPTION );
						Perfil();
						
					}/*else {
						JOptionPane.showMessageDialog(null,"Error","Datos incorrectos, intentar denuevo.", JOptionPane.ERROR_MESSAGE );
					}*/
					
					
				} catch(IOException e1) {
					e1.printStackTrace();
				}
			}
			
		});

		
		JLabel iconoA = new JLabel(new ImageIcon("iconoA.PNG"));
		iconoA.setBounds(404, 216, 34, 34);
		login.add(iconoA); 

		JLabel iconoB = new JLabel(new ImageIcon("iconoB.PNG"));
		iconoB.setBounds(404, 280, 34, 34);
		login.add(iconoB);
		
		JLabel fondo = new JLabel(new ImageIcon("hotel1.PNG")); //FONDO
		fondo.setBounds(-2, 1, 1000, 600);
		login.add(fondo); 
		

		
		anterior=actual;
		actual=login;
		remove(anterior);
		add(actual);
		
		repaint();
		revalidate();
}	
	//*
	public void filtroUsuarios () {
		filtroUsuarios = new JPanel();
		filtroUsuarios.setSize(1000, 600);
		filtroUsuarios.setLocation(0,0);
		filtroUsuarios.setLayout(null);
		filtroUsuarios.setBackground(Color.decode("#008299"));
		
		JLabel titleinicio = new JLabel("Elija el tipo de Usuario",JLabel.CENTER);
		titleinicio.setFont(new Font("Comic Sans", Font.BOLD,20));
		titleinicio.setSize(280, 40);
		titleinicio.setLocation(125,100);
		titleinicio.setOpaque(false);
		titleinicio.setBackground(Color.decode("#4e7485"));
		filtroUsuarios.add(titleinicio);
		
		JButton estudi = new JButton();
		estudi.setText("Estudiante");
		estudi.setSize(100, 40);
		estudi.setLocation(100, 225);
		estudi.setOpaque(false);
		estudi.setBackground(Color.white);
		filtroUsuarios.add(estudi);
		
		JButton docent = new JButton();
		docent.setText("Docente");
		docent.setSize(100, 40);
		docent.setLocation(320, 225);
		docent.setOpaque(false);
		docent.setBackground(Color.white);
		filtroUsuarios.add(docent);
		docent.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				docente = true;
		        estudiante = false;
				Login();
			}
			
		});
		
		
		estudi.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				estudiante = true;
		        docente = false;
				Login();
			}
			
		});
	
		JLabel btn1 = new JLabel(new ImageIcon("boton.PNG"));
		btn1.setBounds(100, 225, 100, 40);
		filtroUsuarios.add(btn1);
		
		JLabel btn2 = new JLabel(new ImageIcon("boton.PNG"));
		btn2.setBounds(320, 225, 100, 40);
		filtroUsuarios.add(btn2);
		
		JLabel fondo = new JLabel(new ImageIcon("hotel.PNG"));
		fondo.setBounds(-2, 1, 525, 700);
		filtroUsuarios.add(fondo);
		
		anterior=actual;
		actual=filtroUsuarios;
		remove(anterior);
		add(actual);
		
		repaint();
		revalidate();
}//*/
	public String buscarImagen() {
		JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Archivos de imagen", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);
        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
        	
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath();
        }
        return null;
	}

public void menuCrearUsuario() {
		
		registro = new JPanel();
		registro.setSize(1000, 600);
		registro.setLocation(0,0);
		registro.setLayout(null);
		registro.setBackground(Color.decode("#dce7ec"));
		
		JLabel editarPerfil = new JLabel();
		editarPerfil.setText("Editar Perfil");
		editarPerfil.setBounds(100, 10, 300, 80);
		editarPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		editarPerfil.setForeground(Color.BLACK);
		editarPerfil.setFont(new Font("cooper black",0,25));
		
		perfil.add(editarPerfil);
		
		


		//Campo Para Escribir
		//Nombres
		JTextField username = new JTextField("Nombre");
		username.setSize(283, 34);
		username.setLocation(390, 214);
		username.setOpaque(false);
		username.setForeground(Color.decode("#9F9E9D"));
		username.setBackground(Color.decode("#5C87C0"));
		registro.add(username);
		JLabel iconoA = new JLabel(new ImageIcon("iconoA.PNG"));
		iconoA.setBounds(356, 214, 34, 34);
		registro.add(iconoA); 
		
		//Apellido
		JTextField apellidos = new JTextField("Apellido");
		apellidos.setSize(283, 34);
		apellidos.setLocation(390, 270);
		apellidos.setOpaque(false);
		apellidos.setForeground(Color.decode("#9F9E9D"));
		apellidos.setBackground(Color.decode("#5C87C0"));
		registro.add(apellidos);
		JLabel iconoA1 = new JLabel(new ImageIcon("iconoA.PNG"));
		iconoA1.setBounds(356, 270, 34, 34);
		registro.add(iconoA1); 
		
		//Fecha de nacimiento
		JTextField FechaN = new JTextField("Fecha de nacimiento");
		FechaN.setSize(283, 34);
		FechaN.setLocation(390, 326);
		FechaN.setOpaque(false);
		FechaN.setForeground(Color.decode("#9F9E9D"));
		FechaN.setBackground(Color.decode("#5C87C0"));
		registro.add(FechaN);
		JLabel iconoA2 = new JLabel(new ImageIcon("iconoA.PNG"));
		iconoA2.setBounds(356, 326, 34, 34);
		registro.add(iconoA2); 
		
		//Correo electronico
		JTextField Correo= new JTextField("Email");
		Correo.setSize(283, 34);
		Correo.setLocation(390, 382);
		Correo.setOpaque(false);
		Correo.setForeground(Color.decode("#9F9E9D"));
		Correo.setBackground(Color.decode("#5C87C0"));
		registro.add(Correo);
		JLabel iconoA3 = new JLabel(new ImageIcon("iconoA.PNG"));
		iconoA3.setBounds(356, 382, 34, 34);
		registro.add(iconoA3); 
		
		//Numero de telefono
		JTextField Num = new JTextField("Num.Celular");
		Num.setSize(283, 34);
		Num.setLocation(390, 438);
		Num.setOpaque(false);
		Num.setForeground(Color.decode("#9F9E9D"));
		Num.setBackground(Color.decode("#5C87C0"));
		registro.add(Num);
		JLabel iconoA4 = new JLabel(new ImageIcon("iconoA.PNG"));
		iconoA4.setBounds(356, 438, 34, 34);
		registro.add(iconoA4); 
		 Num.addKeyListener(new KeyAdapter() {
	            public void keyTyped(KeyEvent e) {
	                char character = e.getKeyChar();
	                if (!(Character.isDigit(character) ||
	                      (character == KeyEvent.VK_BACK_SPACE) ||
	                      (character == KeyEvent.VK_DELETE))) {
	                    e.consume();
	                }
	            }
	        });
		
		
		//contraseña
		JPasswordField password = new JPasswordField("Contraseña");
		password.setSize(283, 34);
		password.setLocation(390, 494);
		password.setOpaque(false);
		password.setForeground(Color.decode("#9F9E9D"));
		password.setBackground(Color.decode("#5C87C0"));
		registro.add(Num);
		registro.add(password);
		JLabel iconoA5 = new JLabel(new ImageIcon("iconoA.PNG"));
		iconoA5.setBounds(356, 494, 34, 34);
		registro.add(iconoA5);
		

		/*

		JRadioButton acepto = new JRadioButton("Acepto");
		acepto.setSize(100, 20);
		acepto.setLocation(75, 460);
		acepto.setOpaque(true);
		acepto.setBackground(Color.decode("#1f7690"));
		registro.add(acepto);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(acepto);
		*/
		JButton finalregistro = new JButton();
		finalregistro.setText("Registrarse");
		finalregistro.setSize(200, 20);
		finalregistro.setLocation(356, 530);
		finalregistro.setOpaque(false);
		finalregistro.setForeground(Color.decode("#9F9E9D"));
		finalregistro.setBackground(Color.decode("#5C87C0"));
		registro.add(finalregistro);

		JButton cancelar = new JButton();
		cancelar.setText("Cancelar");
		cancelar.setSize(90, 20);
		cancelar.setLocation(570, 530);
		cancelar.setOpaque(false);
		cancelar.setForeground(Color.decode("#9F9E9D"));
		cancelar.setBackground(Color.decode("#5C87C0"));
		registro.add(cancelar);
		//--------------------------------------------------------------------
		
		JButton colocarImagen = new JButton();
		colocarImagen.setText("Colocar Imagen");
		colocarImagen.setOpaque(true);
		colocarImagen.setBackground(Color.white);
		registro.add(colocarImagen);
		
		colocarImagen.addActionListener(new ActionListener() {

			@Override
		    public void actionPerformed(ActionEvent e) {
		        JFileChooser chooser = new JFileChooser();
		        FileNameExtensionFilter filter = new FileNameExtensionFilter(
		            "Archivos de imagen", "jpg", "png", "gif");
		        chooser.setFileFilter(filter);
		        int returnVal = chooser.showOpenDialog(null);
		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            System.out.println("Has seleccionado el archivo: " +
		                chooser.getSelectedFile().getName());
		            imagen = chooser.getSelectedFile().getAbsolutePath();
		            // Cargar la imagen y mostrarla en un componente Swing aquí


		        }
		    }
			
		});
	/*if(docente) {
		//PANEL
		registro.setSize(400,600);
		registro.setLocation(50,10);
		//BOTON CANCELAR
		cancelar.setSize(90, 20);
		cancelar.setLocation(300, 570);
		//BOTON ACEPTO
		acepto.setSize(100, 20);
		acepto.setLocation(75, 520);
		//TERMINOS Y CONDICIONES
		tyc.setSize(250, 40);
		tyc.setLocation(75, 470);
		//BOTON ACEPTAR
		finalregistro.setSize(100, 40);
		finalregistro.setLocation(50, 550);
		//BOTON AGREGAR IMAGEN
		colocarImagen.setSize(130, 40);
		colocarImagen.setLocation(160, 550);
		//ETIQUETA
		JLabel gradoDocente = new JLabel("Ingrese su grado de estudio",JLabel.CENTER);
		gradoDocente.setFont(new Font("Comic Sans", Font.BOLD,16));
		gradoDocente.setForeground(Color.decode("#ffffff"));
		gradoDocente.setSize(250, 20);
		gradoDocente.setLocation(75, 405);
		gradoDocente.setOpaque(true);
		gradoDocente.setBackground(Color.decode("#1f7690"));
		registro.add(gradoDocente);
		//GRADO DE ESTUDIO
		JTextField gradoEstudio = new JTextField();
		gradoEstudio.setSize(250, 30);
		gradoEstudio.setLocation(75, 425);
		registro.add(gradoEstudio);
			
			finalregistro.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					CrearUsuarioDocente(username, apellidos, FechaN, Correo, Num, password, gradoEstudio, imagen);
				}
				
			});
			}
		else {
			//PANEL
			registro.setSize(400,550);
			registro.setLocation(50,50);
			//BOTON CANCELAR
			cancelar.setSize(90, 20);
			cancelar.setLocation(300, 510);
			//BOTON ACEPTO
			acepto.setSize(100, 20);
			acepto.setLocation(75, 460);
			//BOTON AGREGAR IMAGEN
			colocarImagen.setSize(130, 40);
			colocarImagen.setLocation(160, 495);
			//TERMINOS Y CONDICIONES
			tyc.setSize(250, 40);
			tyc.setLocation(75, 410);
			//BOTON ACEPTAR
			finalregistro.setSize(100, 40);
			finalregistro.setLocation(50, 495);
			finalregistro.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					CrearUsuario(username, apellidos, FechaN, Correo, Num, password, imagen);
				}
				
			});
			
			}*/

		finalregistro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				CrearUsuario(username, apellidos, FechaN, Correo, Num, password, imagen);
			}
			
		});
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				remove(actual);
				Perfil();
				repaint();
				revalidate();
			}
			
		});
		

		
		//--------------------------------------------------------------------
		
		JLabel fondo = new JLabel(new ImageIcon("hotel2.PNG"));
		fondo.setBounds(-2, 1, 1000, 600);//ANCHO X, Y,TAMAÑO
		registro.add(fondo);

		anterior=actual;
		actual=registro;
		remove(anterior);
		add(actual);
		repaint();
		revalidate();
	}
	
	public void ListaUsuario() {
		
		listaUsuarios = new JPanel(new BorderLayout());
		listaUsuarios.setSize(525,700);
		listaUsuarios.setLocation(0,0);
		listaUsuarios.setLayout(null);
		listaUsuarios.setBackground(Color.decode("#dce7ec"));
		
		

		JLabel listausuario= new JLabel("Lista de usuarios");
		listausuario.setFont(new Font("Comic Sans", Font.BOLD,30));
		listausuario.setBounds(130, 10, 300, 50);
		listaUsuarios.add(listausuario);

		JLabel editarAlumnos = new JLabel("Consultar alumnos");
		editarAlumnos.setFont(new Font("Comic Sans", Font.BOLD,20));
		editarAlumnos.setBounds(10, 30, 200, 100);
		listaUsuarios.add(editarAlumnos);

		JLabel editarMaestros = new JLabel("Consultar maestros");
		editarMaestros.setFont(new Font("Comic Sans", Font.BOLD,20));
		editarMaestros.setBounds(300, 30, 200, 100);
		listaUsuarios.add(editarMaestros);
		
		JButton alumnosBtn = new JButton("A");
		alumnosBtn.setBounds(10, 130, 200, 100);
		listaUsuarios.add(alumnosBtn);
		
		JButton maestrosBtn = new JButton("M");
		maestrosBtn.setBounds(300, 130, 200, 100);
		listaUsuarios.add(maestrosBtn);
		

		alumnosBtn.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				docente = false;
		        estudiante = true;
				
		        ConsultarAlumnos();
			}
			
		});
		
		
		 maestrosBtn.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				docente = true;
		        estudiante = false;
		        ConsultarMaestros();
			}
			
		});
		 
			JLabel fondo = new JLabel(new ImageIcon("fondo.PNG"));
			fondo.setBounds(-2, 1, 525, 700);//ANCHO X, Y,TAMAÑO
			listaUsuarios.add(fondo);


		anterior=actual;
		actual=listaUsuarios;
		remove(anterior);
		add(actual);

		repaint();
		revalidate();
	        
	    }
	public void ConsultarMaestros() {

		consultar= new JPanel();
		consultar.setSize(525,700);
		consultar.setLocation(0,0);
		consultar.setLayout(null);
        consultar.setBackground(Color.decode("#dce7ec"));
        
        JLabel eliminarI= new JLabel("Consultar Informacion de Maestros");
        eliminarI.setFont(new Font("Comic Sans", Font.BOLD,30));
        eliminarI.setBounds(110, 10, 300, 50);
        consultar.add(eliminarI);
	
        JScrollPane scroll = new JScrollPane(new Tabla(getMaestros(), maestrosColumns));
        scroll.setBounds(0, 330, 510, 200);
        scroll.setVisible(true);
        consultar.add(scroll);
        
        anterior=actual;
		actual=consultar;
		remove(anterior);
		add(actual);

		repaint();
		revalidate();
	}
	
	public void ConsultarAlumnos() {

		consultar= new JPanel();
		consultar.setSize(525,700);
		consultar.setLocation(0,0);
		consultar.setLayout(null);
        consultar.setBackground(Color.decode("#dce7ec"));
        
        JLabel eliminarI= new JLabel("Consultar Informacion de Alumnos");
        eliminarI.setFont(new Font("Comic Sans", Font.BOLD,30));
        eliminarI.setBounds(110, 10, 300, 50);
        consultar.add(eliminarI);
	
        JScrollPane scroll = new JScrollPane(new Tabla(getAlumnos(), alumnosColumns));
        scroll.setBounds(0, 330, 510, 200);
        scroll.setVisible(true);
        consultar.add(scroll);
		
        anterior=actual;
		actual=consultar;
		remove(anterior);
		add(actual);

		repaint();
		revalidate();
	}
	
	public void Perfil() {
		perfil = new JPanel();
		perfil.setSize(1000,600);
		perfil.setLocation(0,0);
		perfil.setLayout(null);
		perfil.setBackground(Color.decode("#dce7ec"));
		
		JMenu cuentaMenu = new JMenu("Cuenta");
		JMenuItem miCuentaMenuItem = new JMenuItem("Editar");
		cuentaMenu.add(miCuentaMenuItem);
		JMenuItem cerrarSesionMenuItem = new JMenuItem("Cerrar sesion");
		cuentaMenu.add(cerrarSesionMenuItem);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(cuentaMenu);
		this.setJMenuBar(menuBar);
		
		

		JMenu usuariosMenu = new JMenu("Usuarios");
		JMenuItem ConsultaMenuItem = new JMenuItem("Consultar Cuenta");
		JMenuItem crearUsuarioMenuItem = new JMenuItem("Crear usuarios");
		JMenuItem downloadInfo= new JMenuItem("Descargar Info");
		usuariosMenu.add(ConsultaMenuItem);
		usuariosMenu.add(crearUsuarioMenuItem);
		menuBar.add(usuariosMenu);
		usuariosMenu.add(downloadInfo);

		
		/*
		JLabel bienvenidaPerfil = new JLabel();
		bienvenidaPerfil.setText("Bienvenido "+ nombre);
		bienvenidaPerfil.setBounds(100, 10, 300, 80);
		bienvenidaPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenidaPerfil.setForeground(Color.BLACK);
		bienvenidaPerfil.setFont(new Font("cooper black",0,25));
		perfil.add(bienvenidaPerfil);*/
		
		JLabel iconoLista = new JLabel(new ImageIcon("material-escolar(1).PNG"));
		iconoLista.setBounds(165, 80, 170, 170);
		perfil.add(iconoLista);
		
		
		miCuentaMenuItem.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        
		        menuMiCuenta();
		    }
		});
		
		crearUsuarioMenuItem.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        
		        menuCrearUsuario();
		    }
		});
		
		crearUsuarioMenuItem.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        
		        menuCrearUsuario();
		    }
		});
		
		cerrarSesionMenuItem.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        
		    	JOptionPane.showMessageDialog(null,"Adios "+nombre,"Bye bye", JOptionPane.CLOSED_OPTION );
		    	menuBar.remove(cuentaMenu);
		    	menuBar.remove(usuariosMenu);
		    	Login();
		    	//filtroUsuarios();
		    	
		    }
		});
		
		
		

		ConsultaMenuItem.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        
		        ListaUsuario();

		    }
		});
		
		downloadInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				descargar(posicionUsuario);
//				try {
//					eliminarUsuario(posicionUsuario);
//				} catch (IOException e1) {
//					e1.printStackTrace();
//				}
			}
			
		});
		
		JLabel fondo = new JLabel(new ImageIcon("FondoInicio1.PNG"));
		fondo.setBounds(-2, 1, 1000, 600);//ANCHO X, Y,TAMAÑO
		perfil.add(fondo);

		anterior=actual;
		actual=perfil;
		remove(anterior);
		add(actual);
		
		repaint();
		revalidate();
		
		

	}
	
	
	
	public void descargar(int numUsuarioDescargar) {
		  
		  String infoUsuario = "";
		  
		  try {
				BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
				String line = reader.readLine();

				for (int i = 0; i < numUsuarioDescargar; i++) {
					line = reader.readLine();				
				}

				infoUsuario = line;
				
				reader.close();

			} catch (IOException e1) {
				e1.printStackTrace();
			} 
		  
		  //crea cuadro de seleccion de direccion
		  JFileChooser fileChooser = new JFileChooser();
		  fileChooser.setDialogTitle("Seleccionar destino de descarga");

		  // muestra el cuadro y espera a que seleccione una direccion
		  int userSelection = fileChooser.showSaveDialog(this);
		  if (userSelection == JFileChooser.APPROVE_OPTION) {
			  // guarda la direccion seleccionada
			  String filePath = fileChooser.getSelectedFile().getAbsolutePath();

			  try {
				  //crea el archivo de texto
				  File file = new File(filePath+".txt");
				  BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				  writer.write(infoUsuario);
				  writer.close();
			  } catch (IOException e1) {
				  e1.printStackTrace();
			  }

		  }
	  }

	public void eliminarUsuario(int numUsuarioEliminar) throws IOException {
		
	File archivo = new File("users.txt");
	Scanner entrada = new Scanner(archivo);
	List<String> lineas = new ArrayList<String>();

	while (entrada.hasNextLine()) {
		lineas.add(entrada.nextLine());
	}
	entrada.close();

	int numeroLineaAEliminar = numUsuarioEliminar;
	lineas.remove(numeroLineaAEliminar);

	
	BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
	for (String linea : lineas) {
		writer.write(linea + "\n");
	}
	
	writer.close();
	
	}

	public void CrearUsuarioDocente(JTextField nombreText, JTextField apellidosText,
			JTextField FechaN, JTextField correo, JTextField numT, JPasswordField contraseñaText ,JTextField  gradoEstudio, String imagen) {

//		CrearUsuario(username, apellidos, FechaN, Correo, Num, password);


		//String password = new String(contraseñaText.getPassword());
		String password = new String(contraseñaText.getPassword());
		String datosUsuario = "";

		boolean match = false;

		if(password.length() != 0
				&& nombreText.getText().length() != 0
				&& apellidosText.getText().length() != 0
				&& FechaN.getText().length() != 0
				&& correo.getText().length() != 0
				&& gradoEstudio.getText().length() != 0
				) {

			try {
				FileWriter writer = new FileWriter("users.txt", true);

				BufferedWriter buffWriter = new BufferedWriter(writer);

				datosUsuario = nombreText.getText()+","
						+apellidosText.getText()+","
						+FechaN.getText()+","
						+correo.getText()+","
						+numT.getText()+","
						+password+","
						+gradoEstudio.getText()+","
						+imagen;

				BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
				String line = reader.readLine();

				String[] lineArray = null;

				while (line != null) {
					lineArray = line.split(",");

					if(correo.getText().equals(lineArray[3])) {
						match = true;
					}

					line = reader.readLine();
				}
				reader.close();

				if(!match) {
					buffWriter.write(datosUsuario);
					buffWriter.newLine();
					buffWriter.close();
					JOptionPane.showMessageDialog(this, "Cuenta creada con exito", "Listo!", JOptionPane.INFORMATION_MESSAGE);


				}
				else {
					JOptionPane.showMessageDialog(this, "Error al registrar", "Error", JOptionPane.ERROR_MESSAGE);
				}

			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		}
		else {

			JOptionPane.showMessageDialog(this, "Error al registrar", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public void CrearUsuario(JTextField nombreText, JTextField apellidosText, 
			JTextField FechaN, JTextField correo, JTextField numT, JPasswordField contraseñaText, String imagen) {

//		CrearUsuario(username, apellidos, FechaN, Correo, Num, password);


		//String password = new String(contraseñaText.getPassword());
		String password = new String(contraseñaText.getPassword());
		String datosUsuario = "";

		boolean match = false;

		if(password.length() != 0
				&& nombreText.getText().length() != 0
				&& apellidosText.getText().length() != 0
				&& FechaN.getText().length() != 0
				&& correo.getText().length() != 0) {

			try {
				FileWriter writer = new FileWriter("users.txt", true);

				BufferedWriter buffWriter = new BufferedWriter(writer);

				datosUsuario = nombreText.getText()+","
						+apellidosText.getText()+","
						+correo.getText()+","
						+FechaN.getText()+","
						+numT.getText()+","
						+password+","
						+imagen;

				BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
				String line = reader.readLine();

				String[] lineArray = null;

				while (line != null) {
					lineArray = line.split(",");

					if(correo.getText().equals(lineArray[3])) {
						match = true;
					}

					line = reader.readLine();
				}
				reader.close();

				if(!match) {
					buffWriter.write(datosUsuario);
					buffWriter.newLine();
					buffWriter.close();
					JOptionPane.showMessageDialog(this, "Cuenta creada con exito", "Listo!", JOptionPane.INFORMATION_MESSAGE);


				}
				else {
					JOptionPane.showMessageDialog(this, "Error al registrar", "Error", JOptionPane.ERROR_MESSAGE);
				}

			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}
		else {

			JOptionPane.showMessageDialog(this, "Error al registrar", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public void actualizarUsuario(JTextField nombreText, JTextField apellidosText, 
			JTextField correo, JTextField telefono, JPasswordField contraseñaText, JPasswordField contraseñaText2, int numUsuario) {

//		CrearUsuario(username, apellidos, FechaN, Correo, Num, password);


		//String password = new String(contraseñaText.getPassword());
		String password = new String(contraseñaText.getPassword());
		String password2 = new String(contraseñaText2.getPassword());
		String datosUsuario = "";

		boolean match = false;

		if(password.equals(password2) && password.length() != 0
				&& nombreText.getText().length() != 0
				&& apellidosText.getText().length() != 0
				&& correo.getText().length() != 0) {

			try {
				
				BufferedReader readerCounter = new BufferedReader(new FileReader("users.txt"));
				String newLine = readerCounter.readLine();

				for (int i = 0; i < numUsuario; i++) {
					newLine = readerCounter.readLine();
				}
				
				String data[] = newLine.split(",");

				datosUsuario = nombreText.getText()+","
						+apellidosText.getText()+","
						+data[2]+","
						+correo.getText()+","
						+data[4]+","
						+password
						+data[6];

				BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
				String line = reader.readLine();

				String[] lineArray = null;

				while (line != null) {
					lineArray = line.split(",");

					if(correo.getText().equals(lineArray[3])) {
						match = true;
					}

					line = reader.readLine();
				}
				reader.close();

				if(!match) {
					
					eliminarUsuario(numUsuario);
					
					FileWriter writer = new FileWriter("users.txt", true);
					BufferedWriter buffWriter = new BufferedWriter(writer);
					
					buffWriter.write(datosUsuario);
					buffWriter.newLine();
					buffWriter.close();
					JOptionPane.showMessageDialog(this, "Cuenta creada con exito", "Listo!", JOptionPane.INFORMATION_MESSAGE);

					/*
					 * logica de el cambio de ventanas
					 */


				}
				else {
					JOptionPane.showMessageDialog(this, "Error al registrar1", "Error", JOptionPane.ERROR_MESSAGE);
				}

			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		}
		else {

			JOptionPane.showMessageDialog(this, "Error al registrar", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
	public String[] getDatosUsuario(int numUsuario) {
		
		String[] datos = null;

		try {
			BufferedReader readerCounter = new BufferedReader(new FileReader("users.txt"));
			String line = readerCounter.readLine();
			
			datos = line.split(",");
			
			for (int i = 0; i < numUsuario; i++) {
				
				line = readerCounter.readLine();
				datos = line.split(",");
			}

			readerCounter.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		
		return datos;
	}
	
	public Object[][] getMaestros() {
		
//		String[] columns = {"Nombre", "Apellidos", "Fechad de nacimiento", "Correo", "Telefono", "Grado de estudio"};
		Object[][] data = new Object[getNumeroDeMaestros()][maestrosColumns.length];
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
			String line = reader.readLine();
			
			String[] lineArray = line.split(",");;

			int aux = 0;
			
			boolean addDato = false;

			//añade los datos de la base de datos a la matriz data
			while (line != null) {
				lineArray = line.split(",");
				
				
				for (int i = 0; i < lineArray.length-1; i++) {

					if(lineArray[3].contains("@uabcs.mx"))
					{

						if(i == lineArray.length-3) {
							data[aux][i] = lineArray[i+1];
							addDato = true;
						}else if(i == lineArray.length-2) {
							data[aux][i] = new JLabel(new ImageIcon(lineArray[i+1]));
							addDato = true;
						}else {
						data[aux][i] = lineArray[i];
						addDato = true;
						}
					}

				}
				line = reader.readLine();
				if(addDato) {
				aux++;
				addDato = false;
				}
			}

			reader.close();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		
		return data;
	}
	
	public int getNumeroDeMaestros() {

		int numLines = 0;

		try {
			BufferedReader readerCounter = new BufferedReader(new FileReader("users.txt"));
			String lineCounter = readerCounter.readLine();

			String[] data = lineCounter.split(",");
			
			while(lineCounter!=null) {
				if(data[3].contains("@uabcs.mx")) {
				numLines++;
				}
				lineCounter = readerCounter.readLine();
				
				if(lineCounter!=null) {
				data = lineCounter.split(",");
				}
			}

			readerCounter.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		} 

		return numLines;

	}
	
	public Object[][] getAlumnos() {
		
//		String[] columns = {"Nombre", "Apellidos", "Fechad de nacimiento", "Correo", "Telefono", "Grado de estudio"};
		Object[][] data = new Object[getNumeroDeAlumnos()][alumnosColumns.length];
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
			String line = reader.readLine();
			
			String[] lineArray = line.split(",");;

			int aux = 0;
			
			boolean addDato = false;

			//añade los datos de la base de datos a la matriz data
			while (line != null) {
				lineArray = line.split(",");
				
				
				for (int i = 0; i < lineArray.length-1; i++) {

					if(lineArray[3].contains("@alu.uabcs.mx"))
					{

						if(i == lineArray.length-2) {
							data[aux][i] = new JLabel(new ImageIcon(lineArray[i+1]));
							addDato = true;
						}else {
						data[aux][i] = lineArray[i];
						addDato = true;
						}
					}

				}
				line = reader.readLine();
				if(addDato) {
				aux++;
				addDato = false;
				}
			}

			reader.close();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		
		return data;
	}
	
	public int getNumeroDeAlumnos() {

		int numLines = 0;

		try {
			BufferedReader readerCounter = new BufferedReader(new FileReader("users.txt"));
			String lineCounter = readerCounter.readLine();

			String[] data = lineCounter.split(",");
			
			while(lineCounter!=null) {
				if(data[3].contains("@alu.uabcs.mx")) {
				numLines++;
				}
				lineCounter = readerCounter.readLine();
				
				if(lineCounter!=null) {
					data = lineCounter.split(",");
				}
			}

			readerCounter.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		} 

		return numLines;

	}
}
