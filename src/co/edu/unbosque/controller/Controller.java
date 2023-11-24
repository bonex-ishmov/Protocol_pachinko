package co.edu.unbosque.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import co.edu.unbosque.view.*;

public class Controller implements ActionListener {

	UserGuidedInterface gui;

	JFrame ventanaPrincipal, ventanaCrearCasa, ventanaRegistrarCliente, ventanaGestionSedes;
	JButton btnCrearCasaApuestas, btnRegistrarUsuario, btnSedes, btnJuegos, btnCrearCasa, btnCancelarCasa,
			btnCrearCliente, btnCancelarCliente, btnCrearSede, btnCancelarSede;
	JLabel textoBienvenida, textoCrearCasa, textoNombreCasa, textoSedes, textoDireccion, textoDinero, textoNombres,
			textoTelefono, textoCedula, textoDireccionJuego, textoGestionSedes, textoDireccionSede, textoEmpleadosSede;
	JTextField campoNumSedes, campoDinero, campoDireccion, campoNombres, campoCedula, campoDireccionJuego, campoCelular,
			campoEmpleados, campoDireccionSede;
	JRadioButton consentimiento;
	JList listadoSedes;
	DefaultListModel modeloLista;

	public Controller() {
		gui = new UserGuidedInterface();

	}

//	public void agregarFondo(String rutaImagen) {
//		ImageIcon imagenFondo = new ImageIcon(rutaImagen);
//		JLabel fondo = new JLabel(imagenFondo);
//		fondo.setSize(ventanaPrincipal.getSize());
//		ventanaPrincipal.setContentPane(fondo);
//		ventanaPrincipal.setLayout(new BorderLayout());
//		ventanaPrincipal.revalidate();
//	}

	public Boolean comprobarNumero(String numero) {
		Boolean confirmacion;
		try {
			int conversion = Integer.parseInt(numero);
			return confirmacion = true;
		} catch (NumberFormatException ex) {
			return confirmacion = false;

		}

	}

		public void ventanaPrincipal() {
		ventanaPrincipal = gui.crearVentana(500, 400, "Gestion casa de juegos", true);
		btnCrearCasaApuestas = gui.crearBoton(20, 100, 160, 25, Color.cyan, "Gestion Casa", true);
		btnRegistrarUsuario = gui.crearBoton(20, 150, 160, 25, Color.yellow, "Gestion Cliente", true);
		btnSedes = gui.crearBoton(20, 250, 160, 25, Color.GRAY, "Gestion sedes", true);
		btnJuegos = gui.crearBoton(20, 200, 160, 25, Color.RED, "Gestion Apuestas", true);
		btnCrearCasaApuestas.addActionListener(this);
		btnSedes.addActionListener(this);
		btnJuegos.addActionListener(this);
		btnRegistrarUsuario.addActionListener(this);
		listaInformacion = new JList<Object>();
		modeloListaInformacion = new DefaultListModel();
		listaInformacion.setBounds(220, 100, 230, 200);
		listaInformacion.setModel(modeloListaInformacion);
		ventanaPrincipal.add(listaInformacion);
		textoBienvenida = gui.crearTexto(20, 50, 190, 30, "Gestion Casa de Juegos", true);
		ventanaPrincipal.add(btnCrearCasaApuestas);
		ventanaPrincipal.add(textoBienvenida);
		ventanaPrincipal.add(btnRegistrarUsuario);
		ventanaPrincipal.add(btnSedes);
		ventanaPrincipal.add(btnJuegos);
	}

	public void ventanaGestionCasa() {
		textoListaCasa = gui.crearTexto(60, 240, 160, 20, "Informacion de la casa", true);
		ventanaCrearCasa = gui.crearVentana(300, 500, "Gestion casa", true);
		btnActualizarCasa = gui.crearBoton(20, 350, 120, 25, Color.blue, "Actualizar", false);
		btnEliminarCasa = gui.crearBoton(150, 350, 120, 25, Color.orange, "Eliminar", false);
		btnActualizarCasa.addActionListener(this);
		btnCrearCasa = gui.crearBoton(20, 400, 120, 25, Color.GREEN, "Crear casa", true);
		btnCrearCasa.addActionListener(this);
		btnCancelarCasa = gui.crearBoton(150, 400, 120, 25, Color.red, "Cancelar", true);
		btnCancelarCasa.addActionListener(this);
		textoCrearCasa = gui.crearTexto(20, 10, 170, 40, "Gestion casa de juegos", true);
		textoSedes = gui.crearTexto(15, 195, 120, 30, "Numero de sedes", true);
		textoDinero = gui.crearTexto(15, 115, 120, 30, "Cantidad Dinero", true);
		textoDireccion = gui.crearTexto(15, 150, 120, 30, "Nombre", true);
		campoNumSedes = gui.crearFormulario(120, 200, 40, 20, true);
		campoDinero = gui.crearFormulario(120, 120, 140, 20, true);
		campoDireccion = gui.crearFormulario(120, 160, 140, 20, true);
		listaCasa = new JList<Object>();
		modeloListaCasa = new DefaultListModel();
		listaCasa.setBounds(40, 270, 200, 30);
		listaCasa.setModel(modeloListaCasa);
		ventanaCrearCasa.add(listaCasa);
		ventanaCrearCasa.add(btnCancelarCasa);
		ventanaCrearCasa.add(btnCrearCasa);
		ventanaCrearCasa.add(textoCrearCasa);
		ventanaCrearCasa.add(campoDinero);
		ventanaCrearCasa.add(campoNumSedes);
		ventanaCrearCasa.add(campoDireccion);
		ventanaCrearCasa.add(textoSedes);
		ventanaCrearCasa.add(textoDinero);
		ventanaCrearCasa.add(textoDireccion);
		ventanaCrearCasa.add(btnActualizarCasa);
		ventanaCrearCasa.add(btnEliminarCasa);
		ventanaCrearCasa.add(textoListaCasa);
	}

	public void ventanaGestionCliente() {
		textoApostadorTitulo = gui.crearTexto(40, 20, 120, 20, "Gestion apostador", true);
		textoListaClientes = gui.crearTexto(340, 20, 120, 30, "Lista clientes", true);
		consentimiento = gui.crearCirculo(180, 210, 150, 20, true);
		consentimiento.addActionListener(this);
		consentimiento.setText("Soy mayor de edad");
		btnEliminarCliente = gui.crearBoton(100, 330, 120, 20, Color.blue, "Eliminar", false);
		btnEliminarCliente.addActionListener(this);
		btnLeerCliente = gui.crearBoton(180, 290, 140, 20, Color.orange, "Leer datos", false);
		btnLeerCliente.addActionListener(this);
		btnActualizarCliente = gui.crearBoton(180, 250, 140, 20, Color.orange, "Actualizar datos", false);
		btnActualizarCliente.addActionListener(this);
		btnCrearCliente = gui.crearBoton(20, 250, 140, 20, Color.green, "Gestion cliente", true);
		btnCrearCliente.setEnabled(false);
		btnCancelarCliente = gui.crearBoton(20, 290, 140, 20, Color.red, "Cancelar", true);
		btnCrearCliente.addActionListener(this);
		btnCancelarCliente.addActionListener(this);
		ventanaRegistrarCliente = gui.crearVentana(600, 420, "Registrar Cliente", true);
		campoNombres = gui.crearFormulario(170, 70, 140, 20, true);
		textoNombres = gui.crearTexto(20, 70, 140, 20, "Nombres completos", true);
		textoTelefono = gui.crearTexto(20, 110, 140, 20, "Telefono personal", true);
		campoCelular = gui.crearFormulario(170, 110, 140, 20, true);
		campoCedula = gui.crearFormulario(170, 150, 140, 20, true);
		campoDireccionJuego = gui.crearFormulario(170, 190, 140, 20, true);
		textoCedula = gui.crearTexto(20, 150, 140, 20, "Cedula mayor de edad", true);
		textoDireccionJuego = gui.crearTexto(20, 190, 140, 20, "Direccion juego", true);
		listadoClientes = new JList<Object>();
		modeloListaClientes = new DefaultListModel();
		listadoClientes.setBounds(340, 60, 200, 300);
		listadoClientes.setModel(modeloListaClientes);
		ventanaRegistrarCliente.add(listadoClientes);
		ventanaRegistrarCliente.add(campoNombres);
		ventanaRegistrarCliente.add(textoNombres);
		ventanaRegistrarCliente.add(campoCelular);
		ventanaRegistrarCliente.add(textoTelefono);
		ventanaRegistrarCliente.add(campoCedula);
		ventanaRegistrarCliente.add(textoCedula);
		ventanaRegistrarCliente.add(campoDireccionJuego);
		ventanaRegistrarCliente.add(campoDireccionJuego);
		ventanaRegistrarCliente.add(textoDireccionJuego);
		ventanaRegistrarCliente.add(btnCrearCliente);
		ventanaRegistrarCliente.add(btnCancelarCliente);
		ventanaRegistrarCliente.add(consentimiento);
		ventanaRegistrarCliente.add(btnActualizarCliente);
		ventanaRegistrarCliente.add(btnLeerCliente);
		ventanaRegistrarCliente.add(btnEliminarCliente);
		ventanaRegistrarCliente.add(listadoClientes);
		ventanaRegistrarCliente.add(textoListaClientes);
		ventanaRegistrarCliente.add(textoApostadorTitulo);
	}

	public void ventanaRegistroBetplay() {
		textoTituloBetplay = gui.crearTexto(20, 20, 120, 20, "Gestion Betplay", true);
		ventanaBetplay = gui.crearVentana(300, 300, "Gestion Betplay", true);
		textoNombreBetplay = gui.crearTexto(20, 80, 120, 20, "Nombre del juego", true);
		campoNombreBetplay = gui.crearFormulario(150, 80, 120, 20, true);
		textoPresupuestoBetplay = gui.crearTexto(20, 120, 120, 20, "Presupuesto", true);
		textoTipoBetplay = gui.crearTexto(20, 160, 120, 20, "Tipo de juego", true);
		campoPresupuestoBetplay = gui.crearFormulario(150, 120, 120, 20, true);
		String[] tipoJuego = {"Deportivo", "Loteria", "Chance"};
		btnCrearBetplay = gui.crearBoton(40, 200, 100, 20, Color.green,"Gestionar" , true);
		btnCancelarBetplay = gui.crearBoton(180, 200, 100, 20, Color.red,"Cancelar" , true);
		tipoBetplay = gui.createComboBox(tipoJuego, 150, 160, 120, 20);
		ventanaBetplay.add(campoNombreBetplay);
		ventanaBetplay.add(textoNombreBetplay);
		ventanaBetplay.add(campoPresupuestoBetplay);
		ventanaBetplay.add(textoPresupuestoBetplay);
		ventanaBetplay.add(tipoBetplay);
		ventanaBetplay.add(textoTipoBetplay);
		ventanaBetplay.add(textoTituloBetplay);
		ventanaBetplay.add(btnCrearBetplay);
		ventanaBetplay.add(btnCancelarBetplay);
	}
	
	public void ventanaApostar() {
		ventanaJuegos = gui.crearVentana(600, 400, "Apuestas y juegos", true);
		btnChance = gui.crearBoton(60, 60, 80, 80, Color.red, "Chance", true);
		btnBaloto = gui.crearBoton(180, 60, 80, 80, Color.green, "Baloto", true);
		btnSuperastro = gui.crearBoton(300, 60, 80, 80, Color.green, "Superastro", true);
		btnLoteria = gui.crearBoton(120, 180, 80, 80, Color.blue, "Loteria", true);
		btnBetplay = gui.crearBoton(240, 180, 80, 80, Color.blue, "Betplay", true);
		btnApostar = gui.crearBoton(450, 300, 100, 20, Color.orange, "Apostar", true);
		btnApostar.addActionListener(this);
		btnSuperastro.addActionListener(this);
		btnBaloto.addActionListener(this);
		btnChance.addActionListener(this);
		btnLoteria.addActionListener(this);
		btnBetplay.addActionListener(this);
		ventanaJuegos.add(btnBaloto);
		ventanaJuegos.add(btnChance);
		ventanaJuegos.add(btnSuperastro);
		ventanaJuegos.add(btnLoteria);
		ventanaJuegos.add(btnBetplay);
		ventanaJuegos.add(btnApostar);
	}

	public void gestionSedes() {
		ventanaGestionSedes = gui.crearVentana(500, 400, "Gestionar sedes", true);
		btnCrearSede = gui.crearBoton(40, 115, 90, 20, Color.GREEN, "crear", true);
		btnCrearSede.addActionListener(this);
		btnActualizarSede = gui.crearBoton(320, 115, 90, 20, Color.blue, "Actualizar", false);
		btnActualizarSede.addActionListener(this);
		btnCancelarSede = gui.crearBoton(180, 115, 90, 20, Color.RED, "cancelar", true);
		btnCancelarSede.addActionListener(this);
		textoGestionSedes = gui.crearTexto(10, 0, 140, 30, "Gestionar sedes", true);
		textoNombreSede = gui.crearTexto(20, 20, 150, 140, "Nombre", true);
		textoEmpleadosSede = gui.crearTexto(20, 40, 140, 30, "Numero de empleados", true);
		campoEmpleados = gui.crearFormulario(170, 45, 140, 20, true);
		campoNombreSede = gui.crearFormulario(170, 80, 140, 20, true);
		listadoSedes = new JList<Object>();
		modeloLista = new DefaultListModel();
		listadoSedes.setBounds(20, 150, 400, 150);
		listadoSedes.setModel(modeloLista);
		ventanaGestionSedes.add(listadoSedes);
		ventanaGestionSedes.add(textoGestionSedes);
		ventanaGestionSedes.add(textoNombreSede);
		ventanaGestionSedes.add(textoEmpleadosSede);
		ventanaGestionSedes.add(campoEmpleados);
		ventanaGestionSedes.add(campoNombreSede);
		ventanaGestionSedes.add(btnCrearSede);
		ventanaGestionSedes.add(btnCancelarSede);
		ventanaGestionSedes.add(btnActualizarSede);
	}

	public void execute() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == consentimiento) {
			btnCrearCliente.setEnabled(true);
		}
		
		if (e.getSource() == btnBetplay) {
			ventanaRegistroBetplay();
		}
		
		if (e.getSource() == btnLoteria) {

		}
		
		if (e.getSource() == btnBaloto) {
		
		}
		
		if (e.getSource() == btnSuperastro) {
			
		}
		
		if (e.getSource() == btnChance) {
		
		}

		if (e.getSource() == btnRegistrarUsuario) {
			ventanaGestionCliente();
		}

		if (e.getSource() == btnSedes) {
			gestionSedes();
		}

		if (e.getSource() == btnCrearCasaApuestas) {
			ventanaGestionCasa();
		}

		if (e.getSource() == btnJuegos) {
			ventanaApostar();
		}

		if (e.getSource() == btnCancelarCasa) {
			if (ventanaCrearCasa != null) {
				ventanaCrearCasa.dispose();
			}
		}
		if (e.getSource() == btnCancelarCliente) {
			if (ventanaGestionSedes != null) {
				ventanaRegistrarCliente.dispose();
			}
		}
		if (e.getSource() == btnCancelarSede) {
			if (ventanaGestionSedes != null) {
				ventanaGestionSedes.dispose();
			}
		}

		if (e.getSource() == btnCrearCliente) {
			String informacionNombre = campoNombres.getText();
			String informacionTelefono = campoCelular.getText();
			String informacionCedula = campoCedula.getText();
			String informacionDireccionJuego = campoDireccionJuego.getText();
			Boolean comprobarNumeros = comprobarNumero(informacionCedula) && comprobarNumero(informacionTelefono);

			if (informacionNombre.isEmpty() || informacionCedula.isEmpty() || informacionTelefono.isEmpty()
					|| informacionDireccionJuego.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos estimado usuario");
			} else if (comprobarNumeros == false) {
				JOptionPane.showMessageDialog(null,
						"Los campos cedula y telefono solo acepta numeros estimado usuario");

			} else {
				JOptionPane.showMessageDialog(null, "¡Bienvenido a la casa de juegos! " + informacionNombre);
				btnActualizarCliente.setVisible(true);
				btnLeerCliente.setVisible(true);
				btnEliminarCliente.setVisible(true);
			}
			// INSTALA ACA EL MODELO MI CARNITA
			// Y LOS PAPELES MANI?
			// CUIDAO CON ESTE

		}

		if (e.getSource() == btnActualizarCliente) {
			String informacionNombre = campoNombres.getText();
			String informacionTelefono = campoCelular.getText();
			String informacionCedula = campoCedula.getText();
			String informacionDireccionJuego = campoDireccionJuego.getText();
			Boolean comprobarNumeros = comprobarNumero(informacionCedula) && comprobarNumero(informacionTelefono);

			if (informacionNombre.isEmpty() || informacionCedula.isEmpty() || informacionTelefono.isEmpty()
					|| informacionDireccionJuego.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos estimado usuario");
			} else if (comprobarNumeros == false) {
				JOptionPane.showMessageDialog(null,
						"Los campos cedula y telefono solo acepta numeros estimado usuario");

			} else {
				JOptionPane.showMessageDialog(null, "¡Bienvenido a la casa de juegos! " + informacionNombre);
				btnActualizarCliente.setVisible(true);
				btnLeerCliente.setVisible(true);
				btnEliminarCliente.setVisible(true);
			}
			// INSTALA ACA EL MODELO MI CARNITA
			// Y LOS PAPELES MANI?
			// CUIDAO CON ESTE

		}

		if (e.getSource() == btnEliminarCliente) {

		}

		if (e.getSource() == btnCrearCasa) {
			String informacionDireccionCasa = campoDireccion.getText();
			String informacionDinero = campoDinero.getText();
			String informacionSedes = campoNumSedes.getText();
			Boolean comprobarCamposNumericos = comprobarNumero(informacionDinero) && comprobarNumero(informacionSedes);

			if (informacionDireccionCasa.isEmpty() || informacionDinero.isEmpty() || informacionSedes.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos estimado usuario");
			} else if (comprobarCamposNumericos == false) {
				JOptionPane.showMessageDialog(null,
						"Los campos cantidad de dinero y numero de sedes solo acepta numeros  estimado usuario");

			} else {
				JOptionPane.showMessageDialog(null, "Casa de juegos creada exitosamente ");
				btnActualizarCasa.setVisible(true);
				btnEliminarCasa.setVisible(true);
				// INSTALA ACA EL MODELO MI CARNITA
			} // ACA DIEGO NO ESTA, APROVECHA

		}

		if (e.getSource() == btnEliminarCasa) {
			String informacionDireccionCasa = campoDireccion.getText();
			String informacionDinero = campoDinero.getText();
			String informacionSedes = campoNumSedes.getText();
			Boolean comprobarCamposNumericos = comprobarNumero(informacionDinero) && comprobarNumero(informacionSedes);

			if (informacionDireccionCasa.isEmpty() || informacionDinero.isEmpty() || informacionSedes.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos estimado usuario");
			} else if (comprobarCamposNumericos == false) {
				JOptionPane.showMessageDialog(null,
						"Los campos cantidad de dinero y numero de sedes solo acepta numeros  estimado usuario");

			} else {
				JOptionPane.showMessageDialog(null, "Casa de juegos creada exitosamente ");

				// INSTALA ACA EL MODELO MI CARNITA
			} // ACA DIEGO NO ESTA, APROVECHA

		}

		if (e.getSource() == btnActualizarCasa) {
			String informacionDireccionCasa = campoDireccion.getText();
			String informacionDinero = campoDinero.getText();
			String informacionSedes = campoNumSedes.getText();
			Boolean comprobarCamposNumericos = comprobarNumero(informacionDinero) && comprobarNumero(informacionSedes);

			if (informacionDireccionCasa.isEmpty() || informacionDinero.isEmpty() || informacionSedes.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos estimado usuario");
			} else if (comprobarCamposNumericos == false) {
				JOptionPane.showMessageDialog(null,
						"Los campos cantidad de dinero y numero de sedes solo acepta numeros  estimado usuario");

			} else {
				JOptionPane.showMessageDialog(null, "Casa de juegos creada exitosamente ");

				// INSTALA ACA EL MODELO MI CARNITA
			} // ACA DIEGO NO ESTA, APROVECHA

		}

		if (e.getSource() == btnCrearSede) {
			String informacionDireccion = campoNombreSede.getText();
			String informacionEmpleados = campoEmpleados.getText();
			Boolean comprobarEmpleados = comprobarNumero(informacionEmpleados);

			if (informacionDireccion.isEmpty() || informacionEmpleados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos estimado usuario");
			} else if (comprobarEmpleados == false) {
				JOptionPane.showMessageDialog(null, "El campo empleados acepta numeros  estimado usuario");

			} else {
				JOptionPane.showMessageDialog(null, "Sede creada exitosamente ");
				btnActualizarSede.setVisible(true);
			}
			// INSTALA ACA EL MODELO MI CARNITA
			// INVOCA A HOYOS PARA ATACAR A DIEGO

		}

		if (e.getSource() == btnActualizarSede) {
			String informacionDireccion = campoNombreSede.getText();
			String informacionEmpleados = campoEmpleados.getText();
			Boolean comprobarEmpleados = comprobarNumero(informacionEmpleados);

			if (informacionDireccion.isEmpty() || informacionEmpleados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos estimado usuario");
			} else if (comprobarEmpleados == false) {
				JOptionPane.showMessageDialog(null, "El campo empleados acepta numeros  estimado usuario");

			} else {
				JOptionPane.showMessageDialog(null, "Sede creada exitosamente ");
				btnActualizarSede.setVisible(true);
			}
			// INSTALA ACA EL MODELO MI CARNITA
			// INVOCA A HOYOS PARA ATACAR A DIEGO

		}

		// https://www.youtube.com/watch?v=SMmf3os4EGw Ya valio scooby xd

		// https://www.instagram.com/reel/CzTZfeII3xm/?igshid=MTc4MmM1YmI2Ng==
	}

}
