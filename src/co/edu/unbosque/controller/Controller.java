package co.edu.unbosque.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import co.edu.unbosque.model.persistence.CasaDeApuestasDAO;
import co.edu.unbosque.model.persistence.SedeCasaDeApuestasDAO;
import co.edu.unbosque.view.*;

public class Controller implements ActionListener {

	UserGuidedInterface gui;

	JFrame ventanaPrincipal, ventanaCrearCasa, ventanaRegistrarCliente, ventanaGestionSedes, ventanaJuegos,
			ventanaGestionJuego, ventanaGestionApuestas;
	JButton btnCrearCasaApuestas, btnRegistrarUsuario, btnSedes, btnJuegos, btnCrearCasa, btnCancelarCasa,
			btnGestionApuestas, btnCrearCliente, btnCancelarCliente, btnCrearSede, btnCancelarSede, btnActualizarCasa,
			btnEliminarCasa, btnActualizarSede, btnActualizarCliente, btnLeerCliente, btnEliminarCliente, btnBetplay,
			btnLoteria, btnSuperastro, btnChance, btnBaloto, btnApostar, btnCrearJuego, btnCancelarJuego,
			btnChanceApuesta, btnBalotoApuesta, btnSuperastroApuesta, btnLoteriaApuesta, btnBetplayApuesta,
			btnApostarApuesta;
	JLabel textoBienvenida, textoCrearCasa, textoNombreCasa, textoSedes, textoDireccion, textoDinero, textoNombres,
			textoApostadorTitulo, textoTelefono, textoCedula, textoDireccionJuego, textoGestionSedes, textoNombreSede,
			textoEmpleadosSede, textoListaClientes, textoListaCasa, textoNombreJuego, textoTipoJuego,
			textoPresupuestoJuego, textoTituloJuego, textoInformacionJuego;
	JTextField campoNumSedes, campoDinero, campoDireccion, campoNombres, campoCedula, campoCelular, campoEmpleados,
			campoNombreSede, campoNombreJuego, campoPresupuestoJuego;
	JRadioButton consentimiento;
	JList listadoSedes, listadoClientes, listaCasa, listaInformacion, listadoJuego;
	DefaultListModel modeloLista, modeloListaClientes, modeloListaCasa, modeloListaInformacion, modeloListaJuego;
	JComboBox diasSemana, tipoJuego, comboTipoJuego, comboSede, comboDireccionJuego, comboDireccionSede;
	boolean baloto, betplay, loteria, chance, superastro;

	CasaDeApuestasDAO casaApuestaDao;
	SedeCasaDeApuestasDAO sedeApuestaDao;
	ApostadorDAO apostadorDAO;
	JuegoCasaDeApuestasDAO juegoCasaApuestasDao;
	Console con;

	public Controller() {
		gui = new UserGuidedInterface();
		casaApuestaDao = new CasaDeApuestasDAO();
		sedeApuestaDao = new SedeCasaDeApuestasDAO();
		juegoCasaApuestasDao = new JuegoCasaDeApuestasDAO();
		apostadorDAO = new ApostadorDAO();
		con = new Console();
	}

	public boolean contieneSoloNumeros(String texto) {
		return texto.matches("[0-9]+");
	}


//	public void agregarFondo(String rutaImagen) {
//		ImageIcon imagenFondo = new ImageIcon(rutaImagen);
//		JLabel fondo = new JLabel(imagenFondo);
//		fondo.setSize(ventanaPrincipal.getSize());
//		ventanaPrincipal.setContentPane(fondo);
//		ventanaPrincipal.setLayout(new BorderLayout());
//		ventanaPrincipal.revalidate();
//	}

	public Boolean comprobarNumeroInt(String numero) {
		Boolean confirmacion;
		try {
			int conversion = Integer.parseInt(numero);
			return confirmacion = true;
		} catch (NumberFormatException ex) {
			return confirmacion = false;

		}

	}

	public Boolean comprobarNumeroLong(String numero) {
		Boolean confirmacion;
		try {
			long conversion = Long.parseLong(numero);
			return confirmacion = true;
		} catch (NumberFormatException ex) {
			return confirmacion = false;

		}

	}

	public String[] obtenerDirreciones() {

		if (sedeApuestaDao.getListOfLocations() == null || sedeApuestaDao.getListOfLocations().isEmpty()) {
			return new String[0];
		}

		String[] direcciones = new String[sedeApuestaDao.getListOfLocations().size()];

		for (int i = 0; i < sedeApuestaDao.getListOfLocations().size(); i++) {
			direcciones[i] = sedeApuestaDao.getListOfLocations().get(i).getAddress();
		}

		return direcciones;
	}

	public String[] obtenerNombreCasas() {

		if (casaApuestaDao.getListOfHouses() == null || casaApuestaDao.getListOfHouses().isEmpty()) {
			return new String[0];
		}

		String[] casas = new String[casaApuestaDao.getListOfHouses().size()];

		for (int i = 0; i < casaApuestaDao.getListOfHouses().size(); i++) {
			casas[i] = casaApuestaDao.getListOfHouses().get(i).getBookMarkerName();
		}

		return casas;
	}

	public void ventanaPrincipal() {
		ventanaPrincipal = gui.crearVentana(500, 400, "Gestion casa de juegos", true);
		btnCrearCasaApuestas = gui.crearBoton(20, 100, 160, 25, Color.cyan, "Gestion Casa", true);
		btnRegistrarUsuario = gui.crearBoton(20, 150, 160, 25, Color.yellow, "Gestion Cliente", true);
		btnSedes = gui.crearBoton(20, 250, 160, 25, Color.GRAY, "Gestion sedes", true);
		btnJuegos = gui.crearBoton(20, 200, 160, 25, Color.RED, "Gestion Juegos", true);
		btnGestionApuestas = gui.crearBoton(20, 300, 160, 25, Color.CYAN, "Gestion apuestas", true);
		btnGestionApuestas.addActionListener(this);
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
		ventanaPrincipal.add(btnGestionApuestas);
		ventanaPrincipal.add(btnJuegos);
		baloto = false;
		betplay = false;
		loteria = false;
		chance = false;
		superastro = false;
	}

	public void ventanaGestionCasa() {
		textoListaCasa = gui.crearTexto(60, 240, 160, 20, "Informacion de la casa", true);
		ventanaCrearCasa = gui.crearVentana(300, 500, "Gestion casa", true);
		btnActualizarCasa = gui.crearBoton(20, 350, 120, 25, Color.blue, "Actualizar", true);
		btnEliminarCasa = gui.crearBoton(150, 350, 120, 25, Color.orange, "Eliminar", true);
		btnActualizarCasa.addActionListener(this);
		btnEliminarCasa.addActionListener(this);
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
		btnCrearCliente = gui.crearBoton(20, 250, 140, 20, Color.green, "Crear cliente", true);
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
		String[] sede = obtenerDirreciones();
		comboDireccionJuego = gui.createComboBox(sede, 170, 190, 140, 20);
		textoCedula = gui.crearTexto(20, 150, 140, 20, "Cedula mayor de edad", true);
		textoDireccionJuego = gui.crearTexto(20, 190, 140, 20, "Sede en la que juega", true);
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
		ventanaRegistrarCliente.add(comboDireccionJuego);
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

	public void ventanaRegistroJuego() {
		textoInformacionJuego = gui.crearTexto(330, 10, 120, 30, "Informacion", true);
		textoTituloJuego = gui.crearTexto(20, 20, 120, 20, "Gestion del juego", true);
		ventanaGestionJuego = gui.crearVentana(500, 300, "Gestion del juego", true);
		textoNombreJuego = gui.crearTexto(20, 80, 120, 20, "Nombre del juego", true);
		campoNombreJuego = gui.crearFormulario(150, 80, 120, 20, true);
		textoPresupuestoJuego = gui.crearTexto(20, 120, 120, 20, "Presupuesto", true);
		textoTipoJuego = gui.crearTexto(20, 160, 120, 20, "Sede donde se juega", true);
		campoPresupuestoJuego = gui.crearFormulario(150, 120, 120, 20, true);
		String[] sede = obtenerDirreciones();
		btnCrearJuego = gui.crearBoton(40, 200, 100, 20, Color.green, "Gestionar", true);
		btnCrearJuego.addActionListener(this);
		btnCancelarJuego = gui.crearBoton(180, 200, 100, 20, Color.red, "Cancelar", true);
		btnCancelarJuego.addActionListener(this);
		comboTipoJuego = gui.createComboBox(sede, 150, 160, 120, 20);
		listadoJuego = new JList<Object>();
		modeloListaJuego = new DefaultListModel();
		listadoJuego.setBounds(300, 40, 150, 200);
		listadoJuego.setModel(modeloListaJuego);
		ventanaGestionJuego.add(listadoJuego);
		ventanaGestionJuego.add(campoNombreJuego);
		ventanaGestionJuego.add(textoNombreJuego);
		ventanaGestionJuego.add(campoPresupuestoJuego);
		ventanaGestionJuego.add(textoPresupuestoJuego);
		ventanaGestionJuego.add(comboTipoJuego);
		ventanaGestionJuego.add(textoTipoJuego);
		ventanaGestionJuego.add(textoTituloJuego);
		ventanaGestionJuego.add(btnCrearJuego);
		ventanaGestionJuego.add(btnCancelarJuego);
		ventanaGestionJuego.add(textoInformacionJuego);
	}

	public void ventanaGestionJuegos() {
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

	public void ventanaGestionApuestas() {
		ventanaGestionApuestas = gui.crearVentana(600, 400, "Apuestas ", true);
		btnChanceApuesta = gui.crearBoton(60, 60, 80, 80, Color.red, "Chance", true);
		btnBalotoApuesta = gui.crearBoton(180, 60, 80, 80, Color.green, "Baloto", true);
		btnSuperastroApuesta = gui.crearBoton(300, 60, 80, 80, Color.green, "Superastro", true);
		btnLoteriaApuesta = gui.crearBoton(120, 180, 80, 80, Color.blue, "Loteria", true);
		btnBetplayApuesta = gui.crearBoton(240, 180, 80, 80, Color.blue, "Betplay", true);
		btnSuperastroApuesta.addActionListener(this);
		btnBalotoApuesta.addActionListener(this);
		btnChanceApuesta.addActionListener(this);
		btnLoteriaApuesta.addActionListener(this);
		btnBetplayApuesta.addActionListener(this);

		ventanaGestionApuestas.add(btnBalotoApuesta);
		ventanaGestionApuestas.add(btnChanceApuesta);
		ventanaGestionApuestas.add(btnSuperastroApuesta);
		ventanaGestionApuestas.add(btnLoteriaApuesta);
		ventanaGestionApuestas.add(btnBetplayApuesta);
	}

	public void gestionSedes() {
		ventanaGestionSedes = gui.crearVentana(500, 400, "Gestionar sedes", true);
		btnCrearSede = gui.crearBoton(40, 115, 90, 20, Color.GREEN, "crear", true);
		btnCrearSede.addActionListener(this);
		btnActualizarSede = gui.crearBoton(320, 115, 90, 20, Color.blue, "Actualizar", true);
		btnActualizarSede.addActionListener(this);
		btnCancelarSede = gui.crearBoton(180, 115, 90, 20, Color.RED, "cancelar", true);
		btnCancelarSede.addActionListener(this);
		textoGestionSedes = gui.crearTexto(10, 0, 140, 30, "Gestionar sedes", true);
		textoNombreSede = gui.crearTexto(20, 20, 150, 140, "Direccion", true);
		textoEmpleadosSede = gui.crearTexto(20, 40, 140, 30, "Numero de empleados", true);
		campoEmpleados = gui.crearFormulario(170, 45, 140, 20, true);
		campoNombreSede = gui.crearFormulario(170, 80, 140, 20, true);
		textoTipoJuego = gui.crearTexto(340, 30, 140, 40, "casa al la que pertenece", true);
		String[] sede = obtenerNombreCasas();
		comboDireccionSede = gui.createComboBox(sede, 340, 70, 140, 20);
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
		ventanaGestionSedes.add(comboDireccionSede);
		ventanaGestionSedes.add(textoTipoJuego);
	}

	public void execute() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnCrearJuego && betplay == true) {
			String informacionNombreJuego = campoNombreJuego.getText();
			String informacionPresupuestoJuego = campoPresupuestoJuego.getText();
			String informacionSedeJuego = (String) comboTipoJuego.getSelectedItem();
			String informacionBetPlay = "";
			String informacionCasa = "";
			String numSedes = "";
			String presupuestoJuego = "";
			String numEmpleado = "";
			String tipoDeJuego = "BetPlay";
			Boolean comprobarNumeros = comprobarNumeroLong(informacionPresupuestoJuego);

			if (informacionNombreJuego.isEmpty() || informacionPresupuestoJuego.isEmpty()
					|| informacionSedeJuego.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos estimado usuario");
			} else if (comprobarNumeros == false) {
				JOptionPane.showMessageDialog(null, "El campo de presupuesto solo acepta numeros estimado usuario");

			} else {

				boolean betPlay = false;

				for (int i = 0; i < sedeApuestaDao.getListOfLocations().size(); i++) {
					if (sedeApuestaDao.getListOfLocations().get(i).getAddress()
							.equalsIgnoreCase(informacionSedeJuego)) {

						informacionCasa = sedeApuestaDao.getListOfLocations().get(i).getBookMarkerName();
						numSedes = sedeApuestaDao.getListOfLocations().get(i).getNumberOfLocations() + "";
						presupuestoJuego = sedeApuestaDao.getListOfLocations().get(i).getTotalBudgetAvailable() + "";
						numEmpleado = sedeApuestaDao.getListOfLocations().get(i).getNumberOfEmployees() + "";

						juegoCasaApuestasDao.create(informacionCasa, numSedes, presupuestoJuego, informacionSedeJuego,
								numEmpleado, tipoDeJuego, informacionNombreJuego, informacionPresupuestoJuego);
						betPlay = true;
						JOptionPane.showMessageDialog(null, "Juego  registrado exitosamente");
						break;
					}
				}

				if (!betPlay) {
					JOptionPane.showMessageDialog(null, " juego no encontrada");
				}
			}

		}

		if (e.getSource() == btnCrearJuego && baloto == true) {
			String informacionNombreJuego = campoNombreJuego.getText();
			String informacionPresupuestoJuego = campoPresupuestoJuego.getText();
			String informacionSedeJuego = (String) comboTipoJuego.getSelectedItem();
			String informacionBaloto = "";
			String informacionCasa = "";
			String numSedes = "";
			String presupuestoJuego = "";
			String numEmpleado = "";
			String tipoDeJuego = "Baloto";
			Boolean comprobarNumeros = comprobarNumeroLong(informacionPresupuestoJuego);

			if (informacionNombreJuego.isEmpty() || informacionPresupuestoJuego.isEmpty()
					|| informacionSedeJuego.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos estimado usuario");
			} else if (comprobarNumeros == false) {
				JOptionPane.showMessageDialog(null, "El campo de presupuesto solo acepta numeros estimado usuario");

			} else {

				boolean baloto = false;

				for (int i = 0; i < sedeApuestaDao.getListOfLocations().size(); i++) {
					if (sedeApuestaDao.getListOfLocations().get(i).getAddress()
							.equalsIgnoreCase(informacionSedeJuego)) {

						informacionCasa = sedeApuestaDao.getListOfLocations().get(i).getBookMarkerName();
						numSedes = sedeApuestaDao.getListOfLocations().get(i).getNumberOfLocations() + "";
						presupuestoJuego = sedeApuestaDao.getListOfLocations().get(i).getTotalBudgetAvailable() + "";
						numEmpleado = sedeApuestaDao.getListOfLocations().get(i).getNumberOfEmployees() + "";

						juegoCasaApuestasDao.create(informacionCasa, numSedes, presupuestoJuego, informacionSedeJuego,
								numEmpleado, tipoDeJuego, informacionNombreJuego, informacionPresupuestoJuego);
						baloto = true;
						JOptionPane.showMessageDialog(null, "Juego  registrado exitosamente");
						break;
					}
				}

				if (!baloto) {
					JOptionPane.showMessageDialog(null, " juego no encontrada");
				}
			}

		}

		if (e.getSource() == btnCrearJuego && loteria == true) {
			String informacionNombreJuego = campoNombreJuego.getText();
			String informacionPresupuestoJuego = campoPresupuestoJuego.getText();
			String informacionSedeJuego = (String) comboTipoJuego.getSelectedItem();
			String informacionLoteria = "";
			String informacionCasa = "";
			String numSedes = "";
			String presupuestoJuego = "";
			String numEmpleado = "";
			String tipoDeJuego = "Loteria";
			Boolean comprobarNumeros = comprobarNumeroLong(informacionPresupuestoJuego);

			if (informacionNombreJuego.isEmpty() || informacionPresupuestoJuego.isEmpty()
					|| informacionSedeJuego.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos estimado usuario");
			} else if (comprobarNumeros == false) {
				JOptionPane.showMessageDialog(null, "El campo de presupuesto solo acepta numeros estimado usuario");

			} else {

				boolean loteria = false;

				for (int i = 0; i < sedeApuestaDao.getListOfLocations().size(); i++) {
					if (sedeApuestaDao.getListOfLocations().get(i).getAddress()
							.equalsIgnoreCase(informacionSedeJuego)) {

						informacionCasa = sedeApuestaDao.getListOfLocations().get(i).getBookMarkerName();
						numSedes = sedeApuestaDao.getListOfLocations().get(i).getNumberOfLocations() + "";
						presupuestoJuego = sedeApuestaDao.getListOfLocations().get(i).getTotalBudgetAvailable() + "";
						numEmpleado = sedeApuestaDao.getListOfLocations().get(i).getNumberOfEmployees() + "";

						juegoCasaApuestasDao.create(informacionCasa, numSedes, presupuestoJuego, informacionSedeJuego,
								numEmpleado, tipoDeJuego, informacionNombreJuego, informacionPresupuestoJuego);
						loteria = true;
						JOptionPane.showMessageDialog(null, "Juego  registrado exitosamente");
						break;
					}
				}

				if (!loteria) {
					JOptionPane.showMessageDialog(null, " juego no encontrada");
				}
			}

		}

		if (e.getSource() == btnCrearJuego && superastro == true) {
String informacionNombreJuego = campoNombreJuego.getText();
			String informacionPresupuestoJuego = campoPresupuestoJuego.getText();
			String informacionSedeJuego = (String) comboTipoJuego.getSelectedItem();
			String informacionSuperAstro = "";
			String informacionCasa = "";
			String numSedes = "";
			String presupuestoJuego = "";
			String numEmpleado = "";
			String tipoDeJuego = "Super Astro";
			Boolean comprobarNumeros = comprobarNumeroLong(informacionPresupuestoJuego);

			if (informacionNombreJuego.isEmpty() || informacionPresupuestoJuego.isEmpty()
					|| informacionSedeJuego.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos estimado usuario");
			} else if (comprobarNumeros == false) {
				JOptionPane.showMessageDialog(null, "El campo de presupuesto solo acepta numeros estimado usuario");

			} else {

				boolean superAstro = false;

				for (int i = 0; i < sedeApuestaDao.getListOfLocations().size(); i++) {
					if (sedeApuestaDao.getListOfLocations().get(i).getAddress()
							.equalsIgnoreCase(informacionSedeJuego)) {

						informacionCasa = sedeApuestaDao.getListOfLocations().get(i).getBookMarkerName();
						numSedes = sedeApuestaDao.getListOfLocations().get(i).getNumberOfLocations() + "";
						presupuestoJuego = sedeApuestaDao.getListOfLocations().get(i).getTotalBudgetAvailable() + "";
						numEmpleado = sedeApuestaDao.getListOfLocations().get(i).getNumberOfEmployees() + "";

						juegoCasaApuestasDao.create(informacionCasa, numSedes, presupuestoJuego, informacionSedeJuego,
								numEmpleado, tipoDeJuego, informacionNombreJuego, informacionPresupuestoJuego);
						superAstro = true;
						JOptionPane.showMessageDialog(null, "Juego  registrado exitosamente");
						break;
					}
				}

				if (!superAstro) {
					JOptionPane.showMessageDialog(null, " juego no encontrada");
				}
			}

		}

		if (e.getSource() == btnCrearJuego && chance == true) {
			String informacionNombreJuego = campoNombreJuego.getText();
			String informacionPresupuestoJuego = campoPresupuestoJuego.getText();
			String informacionSedeJuego = (String) comboTipoJuego.getSelectedItem();
			String informacionSuperAstro = "";
			String informacionCasa = "";
			String numSedes = "";
			String presupuestoJuego = "";
			String numEmpleado = "";
			String tipoDeJuego = "Chance";
			Boolean comprobarNumeros = comprobarNumeroLong(informacionPresupuestoJuego);

			if (informacionNombreJuego.isEmpty() || informacionPresupuestoJuego.isEmpty()
					|| informacionSedeJuego.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos estimado usuario");
			} else if (comprobarNumeros == false) {
				JOptionPane.showMessageDialog(null, "El campo de presupuesto solo acepta numeros estimado usuario");

			} else {

				boolean superAstro = false;

				for (int i = 0; i < sedeApuestaDao.getListOfLocations().size(); i++) {
					if (sedeApuestaDao.getListOfLocations().get(i).getAddress()
							.equalsIgnoreCase(informacionSedeJuego)) {

						informacionCasa = sedeApuestaDao.getListOfLocations().get(i).getBookMarkerName();
						numSedes = sedeApuestaDao.getListOfLocations().get(i).getNumberOfLocations() + "";
						presupuestoJuego = sedeApuestaDao.getListOfLocations().get(i).getTotalBudgetAvailable() + "";
						numEmpleado = sedeApuestaDao.getListOfLocations().get(i).getNumberOfEmployees() + "";

						juegoCasaApuestasDao.create(informacionCasa, numSedes, presupuestoJuego, informacionSedeJuego,
								numEmpleado, tipoDeJuego, informacionNombreJuego, informacionPresupuestoJuego);
						superAstro = true;
						JOptionPane.showMessageDialog(null, "Juego  registrado exitosamente");
						break;
					}
				}

				if (!superAstro) {
					JOptionPane.showMessageDialog(null, " juego no encontrada");
				}
			}

		}

		if (e.getSource() == consentimiento) {
			btnCrearCliente.setEnabled(true);
		}

		if (e.getSource() == btnBetplay) {
			betplay = true;
			ventanaRegistroJuego();
		}

		if (e.getSource() == btnLoteria) {
			loteria = true;
			ventanaRegistroJuego();
		}

		if (e.getSource() == btnBaloto) {
			baloto = true;
			ventanaRegistroJuego();

		}

		if (e.getSource() == btnSuperastro) {
			superastro = true;
			ventanaRegistroJuego();

		}

		if (e.getSource() == btnChance) {
			chance = true;
			ventanaRegistroJuego();

		}

		if (e.getSource() == btnCancelarJuego) {
			if (ventanaGestionJuego != null) {
				ventanaGestionJuego.dispose();
				baloto = false;
				betplay = false;
				loteria = false;
				chance = false;
				superastro = false;

			}
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
			ventanaGestionJuegos();
		}

		if (e.getSource() == btnGestionApuestas) {
			ventanaGestionApuestas();
		}

		if (e.getSource() == btnCancelarCasa) {
			if (ventanaCrearCasa != null) {
				ventanaCrearCasa.dispose();
			}
		}
		if (e.getSource() == btnCancelarCliente) {
			if (ventanaRegistrarCliente != null) {
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
			String informacionCedula = campoCedula.getText();
			String informacionFecha = "";
			String informacionCasa = "";
			String informacionDireccionJuego = (String) comboDireccionJuego.getSelectedItem();
			String informacionTelefono = campoCelular.getText();

			Boolean comprobarNumeros = contieneSoloNumeros(informacionCedula)
					&& contieneSoloNumeros(informacionTelefono);

			if (informacionNombre.isEmpty() || informacionCedula.isEmpty() || informacionTelefono.isEmpty()
					|| informacionDireccionJuego.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos estimado usuario");
			} else if (comprobarNumeros == false) {
				JOptionPane.showMessageDialog(null,
						"Los campos cedula y telefono solo acepta numeros estimado usuario");

			} else {

				boolean sedeEncontrada = false;

				for (int i = 0; i < sedeApuestaDao.getListOfLocations().size(); i++) {
					if (sedeApuestaDao.getListOfLocations().get(i).getAddress()
							.equalsIgnoreCase(informacionDireccionJuego)) {

						informacionCasa = sedeApuestaDao.getListOfLocations().get(i).getBookMarkerName();

						apostadorDAO.create(informacionNombre, informacionCedula, informacionFecha, informacionCasa,
								informacionDireccionJuego, informacionTelefono);
						sedeEncontrada = true;
						JOptionPane.showMessageDialog(null, "cliente registrado exitosamente");
						break;
					}
				}

				if (!sedeEncontrada) {
					JOptionPane.showMessageDialog(null, "Sede de juegos no encontrada");
				}
			}

		}

		if (e.getSource() == btnActualizarCliente) {
			String informacionNombre = campoNombres.getText();
			String informacionCedula = campoCedula.getText();
			String informacionFecha = "";
			String informacionCasa = "";
			String informacionDireccionJuego = (String) comboDireccionJuego.getSelectedItem();
			String informacionTelefono = campoCelular.getText();
			Boolean comprobarNumeros = contieneSoloNumeros(informacionCedula)
					&& contieneSoloNumeros(informacionTelefono);

			if (informacionNombre.isEmpty() || informacionCedula.isEmpty() || informacionTelefono.isEmpty()
					|| informacionDireccionJuego.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos estimado usuario");
			} else if (comprobarNumeros == false) {
				JOptionPane.showMessageDialog(null,
						"Los campos cedula y telefono solo acepta numeros estimado usuario");

			} else {

				boolean sedeEncontrada = false;

				for (int i = 0; i < apostadorDAO.getListOfGamblers().size(); i++) {
					if (apostadorDAO.getListOfGamblers().get(i).getCompleteName().equalsIgnoreCase(informacionNombre)) {

						informacionCasa = sedeApuestaDao.getListOfLocations().get(i).getBookMarkerName();

						apostadorDAO.update(i, informacionNombre, informacionCedula, informacionFecha, informacionCasa,
								informacionDireccionJuego, informacionTelefono);
						sedeEncontrada = true;
						JOptionPane.showMessageDialog(null, "cliente actualizado exitosamente");
						break;
					}
				}

				if (!sedeEncontrada) {
					JOptionPane.showMessageDialog(null, "Cliente no encontrado");
				}
			}
		}

		if (e.getSource() == btnEliminarCliente) {
			
			String informacionCliente = campoNombres.getText();
			if (informacionCliente.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar el nombre del cliente, estimado usuario");
			} else {
				boolean clienteEncontrado = false;

				for (int i = 0; i < ApostadorDao.getListOfGamblers().size(); i++) {
					if (informacionCliente
							.equalsIgnoreCase(ApostadorDao.getListOfGamblers().get(i).getCompleteName())) {
						ApostadorDao.delete(i);
						JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente");
						clienteEncontrado = true;
						break;
					}
				}

				if (!clienteEncontrado) {
					JOptionPane.showMessageDialog(null, "Cliente no encontrado no encontrada");
					casaApuestaDao.delete(0);
				}
			}

		}

		if (e.getSource() == btnCrearCasa) {
			String informacionDireccionCasa = campoDireccion.getText();
			String informacionDinero = campoDinero.getText();
			String informacionSedes = campoNumSedes.getText();
			Boolean comprobarCamposNumericos = comprobarNumeroLong(informacionDinero)
					&& comprobarNumeroInt(informacionSedes);

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

		if (e.getSource() == btnEliminarCasa) {
			String informacionNombreCasaApuesta = campoDireccion.getText();

			if (informacionNombreCasaApuesta.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar el nombre de la casa, estimado usuario");
			} else {
				boolean casaEncontrada = false;

				for (int i = 0; i < casaApuestaDao.getListOfHouses().size(); i++) {
					if (informacionNombreCasaApuesta
							.equalsIgnoreCase(casaApuestaDao.getListOfHouses().get(i).getBookMarkerName())) {
						casaApuestaDao.delete(i);
						JOptionPane.showMessageDialog(null, "Casa de juegos eliminada exitosamente");
						casaEncontrada = true;
						break;
					}
				}

				if (!casaEncontrada) {
					JOptionPane.showMessageDialog(null, "Casa de juegos no encontrada");
					casaApuestaDao.delete(0);
				}
			}

		}

		if (e.getSource() == btnActualizarCasa) {
			String informacionNombreCasaApuesta = campoDireccion.getText();
			String informacionDinero = campoDinero.getText();
			String informacionSedes = campoNumSedes.getText();
			Boolean comprobarCamposNumericos = comprobarNumeroLong(informacionDinero)
					&& comprobarNumeroInt(informacionSedes);

			if (informacionNombreCasaApuesta.isEmpty() || informacionDinero.isEmpty() || informacionSedes.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos estimado usuario");
			} else if (comprobarCamposNumericos == false) {
				JOptionPane.showMessageDialog(null,
						"Los campos cantidad de dinero y numero de sedes solo acepta numeros  estimado usuario");

			} else {
				boolean casaEncontrada = false;

				for (int i = 0; i < casaApuestaDao.getListOfHouses().size(); i++) {
					if (casaApuestaDao.getListOfHouses().get(i).getBookMarkerName()
							.equalsIgnoreCase(informacionNombreCasaApuesta)) {
						casaApuestaDao.update(i, informacionNombreCasaApuesta, informacionSedes, informacionDinero);
						casaEncontrada = true;
						JOptionPane.showMessageDialog(null, "Casa de juegos actualizada exitosamente");
						break;
					}
				}

				if (!casaEncontrada) {
					JOptionPane.showMessageDialog(null, "No se ha encontrado la casa de juegos especificada");
				}
			}
		}

		if (e.getSource() == btnCrearSede) {
			String informacionCasa = (String) comboDireccionSede.getSelectedItem();
			String informacionNumeroLocaciones = "";
			String informacionPresupuesto = "";
			String informacionDireccion = campoNombreSede.getText();
			String informacionEmpleados = campoEmpleados.getText();
			Boolean comprobarEmpleados = comprobarNumeroInt(informacionEmpleados);

			if (informacionDireccion.isEmpty() || informacionEmpleados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos estimado usuario");
			} else if (comprobarEmpleados == false) {
				JOptionPane.showMessageDialog(null, "El campo empleados acepta numeros  estimado usuario");

			} else {
				boolean casaEncontrada = false;

				for (int i = 0; i < casaApuestaDao.getListOfHouses().size(); i++) {
					if (casaApuestaDao.getListOfHouses().get(i).getBookMarkerName().equalsIgnoreCase(informacionCasa)) {
						informacionNumeroLocaciones = casaApuestaDao.getListOfHouses().get(i).getNumberOfLocations()
								+ "";
						informacionPresupuesto = casaApuestaDao.getListOfHouses().get(i).getTotalBudgetAvailable() + "";
						sedeApuestaDao.create(informacionCasa, informacionNumeroLocaciones, informacionPresupuesto,
								informacionDireccion, informacionEmpleados);
						casaEncontrada = true;
						JOptionPane.showMessageDialog(null, "sede de juegos creada exitosamente");
						break;
					}
				}

				if (!casaEncontrada) {
					JOptionPane.showMessageDialog(null, "No se ha encontrado la casa de juegos especificada");
				}
			}

		}

		if (e.getSource() == btnActualizarSede) {
			String informacionCasa = (String) comboDireccionSede.getSelectedItem();
			String informacionNumeroLocaciones = "";
			String informacionPresupuesto = "";
			String informacionDireccion = campoNombreSede.getText();
			String informacionEmpleados = campoEmpleados.getText();
			Boolean comprobarEmpleados = comprobarNumeroInt(informacionEmpleados);

			if (informacionDireccion.isEmpty() || informacionEmpleados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos estimado usuario");
			} else if (comprobarEmpleados == false) {
				JOptionPane.showMessageDialog(null, "El campo empleados acepta numeros  estimado usuario");

			} else {

				boolean casaEncontrada = false;

				for (int i = 0; i < casaApuestaDao.getListOfHouses().size(); i++) {
					if (sedeApuestaDao.getListOfLocations().get(i).getAddress()
							.equalsIgnoreCase(informacionDireccion)) {
						informacionNumeroLocaciones = casaApuestaDao.getListOfHouses().get(i).getNumberOfLocations()
								+ "";
						informacionPresupuesto = casaApuestaDao.getListOfHouses().get(i).getTotalBudgetAvailable() + "";
						sedeApuestaDao.update(i, informacionCasa, informacionNumeroLocaciones, informacionPresupuesto,
								informacionDireccion, informacionEmpleados);
						casaEncontrada = true;
						JOptionPane.showMessageDialog(null, "sede de juegos creada exitosamente");
						break;
					}
				}

				if (!casaEncontrada) {
					JOptionPane.showMessageDialog(null, "No se ha encontrado la casa de juegos especificada");
				}
			}

		}

	}

}
