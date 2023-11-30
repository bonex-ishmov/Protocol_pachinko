package co.edu.unbosque.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import co.edu.unbosque.model.CasaDeApuestasDTO;
import co.edu.unbosque.model.persistence.ApostadorDAO;
import co.edu.unbosque.model.persistence.ApuestaChanceDAO;
import co.edu.unbosque.model.persistence.CasaDeApuestasDAO;
import co.edu.unbosque.model.persistence.JuegoCasaDeApuestasDAO;
import co.edu.unbosque.model.persistence.SedeCasaDeApuestasDAO;
import co.edu.unbosque.view.*;

public class Controller implements ActionListener {

	UserGuidedInterface gui;

	JFrame ventanaPrincipal, ventanaCrearCasa, ventanaRegistrarCliente, ventanaGestionSedes, ventanaJuegos,
			ventanaGestionJuego, ventanaGestionApuestas, ventanaApuestaSuperastro, ventanaApuestaLoteria,
			ventanaApuestaBaloto, ventanaApuestaChance, ventanaApuestaBetplay;
	JButton btnCancelarBetplay, btnApostarBetplay, btnActualizarBetplay, btnEliminarBetplay, btnActualizarBaloto,
			btnEliminarBaloto, btnActualizarSuperastro, btnEliminarSuperastro, btnEliminarLoteria, btnActualizarLoteria,
			btnActualizarChance, btnEliminarChance, btnCancelarChance, btnApostarChance, btnCrearCasaApuestas,
			btnRegistrarUsuario, btnSedes, btnJuegos, btnCrearCasa, btnCancelarCasa, btnGestionApuestas,
			btnCrearCliente, btnCancelarCliente, btnCrearSede, btnCancelarSede, btnActualizarCasa, btnEliminarCasa,
			btnActualizarSede, btnActualizarCliente, btnLeerCliente, btnEliminarCliente, btnBetplay, btnLoteria,
			btnSuperastro, btnChance, btnBaloto, btnCrearJuego, btnCancelarJuego, btnChanceApuesta, btnBalotoApuesta,
			btnSuperastroApuesta, btnLoteriaApuesta, btnBetplayApuesta, btnApostarApuesta, btnApostarSuperastro,
			btnCancelarSuperastro, btnCancelarLoteria, btnApostarLoteria, btnCancelarBaloto, btnApostarBaloto;
	JLabel textoUsuarioChance, textoLoteriasChance, textoNumerosChance, textoApuestaChance, textoDiaSemanaChance,
			textoCedulaChance, textoSedeChance, textoBienvenida, textoCrearCasa, textoNombreCasa, textoSedes,
			textoDireccion, textoDinero, textoNombres, textoApostadorTitulo, textoTelefono, textoCedula,
			textoDireccionJuego, textoGestionSedes, textoNombreSede, textoEmpleadosSede, textoListaClientes,
			textoListaCasa, textoNombreJuego, textoTipoJuego, textoUsuarioLoteria, textoPresupuestoJuego,
			textoTituloJuego, textoInformacionJuego, textoSedeSuperastro, textoCedulaSuperastro,
			textoDiaSemanaSuperastro, textoApuestaSuperastro, textoSignoSuperastro, textoUsuarioSuperastro,
			textoNumerosSuperastro, textoSignosZodiacales, textoSedeLoteria, textoCedulaLoteria, textoDiaSemanaLoteria,
			textoApuestaLoteria, textoNumerosLoteria, textoLoterias, textoSerial, textoSedeBaloto, textoCedulaBaloto,
			textoDiaSemanaBaloto, textoApuestaBaloto, textoNumerosBaloto, textoUsuarioBaloto, textoSedeBetplay,
			textoCedulaBetplay, textoDiaSemanaBetplay, textoApuestaBetplay, textoPartidosBetplay, textoUsuarioBetplay,
			textoResultadoBetplay;
	JTextField campoDiaBaloto, campoUsuarioBaloto, comboLoterias, campoDiaLoteria, campoUsuarioLoteria,
			comboSignosZodiacales, campoDiaSuperastro, campoUsuarioSuperastro, comboPartidosBetplay,
			comboResultadoBetplay, campoDiaBetplay, campoUsuarioBetplay, campoUsuarioChance, campoDiaChance,
			campoLoteriasChance, campoSedeBetplay, campoCedulaBetplay, campoValorBetplay, numero4Chance, numero3Chance,
			numero2Chance, numero1Chance, campoValorChance, campoCedulaChance, campoSedeChance, campoNumSedes,
			campoDinero, campoDireccion, campoNombres, campoCedula, campoCelular, campoEmpleados, campoNombreSede,
			campoNombreJuego, campoPresupuestoJuego, campoCedulaSuperastro, campoSedeSuperastro, campoValorSuperastro,
			numero1Superastro, numero2Superastro, numero3Superastro, numero4Superastro, numero1Loteria, numero2Loteria,
			numero3Loteria, numero4Loteria, campoSedeLoteria, campoCedulaLoteria, campoValorLoteria, campoSerial1,
			campoSerial2, campoSerial3, campoSedeBaloto, campoCedulaBaloto, campoValorBaloto, numero1Baloto,
			numero2Baloto, numero3Baloto, numero4Baloto, numero5Baloto, numero6Baloto;
	JRadioButton consentimiento;
	JList listadoSedes, listadoClientes, listaCasa, listaInformacion, listadoJuego;
	DefaultListModel modeloLista, modeloListaClientes, modeloListaCasa, modeloListaInformacion, modeloListaJuego;
	JComboBox comboLoteriasChance, tipoJuego, comboTipoJuego, comboSede, comboDireccionJuego, comboDireccionSede;
	boolean baloto, betplay, loteria, chance, superastro;

	CasaDeApuestasDAO casaApuestaDao;
	SedeCasaDeApuestasDAO sedeApuestaDao;
	ApostadorDAO apostadorDAO;
	JuegoCasaDeApuestasDAO juegoCasaApuestasDao;
	ApuestaChanceDAO chanceDao;
	Console con;

	public Controller() {
		gui = new UserGuidedInterface();
		casaApuestaDao = new CasaDeApuestasDAO();
		sedeApuestaDao = new SedeCasaDeApuestasDAO();
		juegoCasaApuestasDao = new JuegoCasaDeApuestasDAO();
		apostadorDAO = new ApostadorDAO();
		chanceDao = new ApuestaChanceDAO();
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

	public String[] obtenerApostadores() {

		if (apostadorDAO.getListOfGamblers() == null || apostadorDAO.getListOfGamblers().isEmpty()) {
			return new String[0];
		}

		String[] apostadores = new String[apostadorDAO.getListOfGamblers().size()];

		for (int i = 0; i < apostadorDAO.getListOfGamblers().size(); i++) {
			apostadores[i] = apostadorDAO.getListOfGamblers().get(i).getCompleteName();
		}

		return apostadores;
	}

	public String[] obtenerNombreLoteria(String game) {

		if (juegoCasaApuestasDao.getListOfGames() == null || juegoCasaApuestasDao.getListOfGames().isEmpty()) {
			return new String[0];
		}

		String[] loterias = new String[juegoCasaApuestasDao.getListOfGames().size()];

		for (int i = 0; i < juegoCasaApuestasDao.getListOfGames().size(); i++) {
			if (juegoCasaApuestasDao.getListOfGames().get(i).getGameName().equalsIgnoreCase(game)) {
				loterias[i] = juegoCasaApuestasDao.getListOfGames().get(i).getTypeOfGame();
			}
		}

		return loterias;
	}

	public double sumarPresupuestos() {
		double suma = 0;

		for (int i = 0; i < juegoCasaApuestasDao.getListOfGames().size(); i++) {
			suma += juegoCasaApuestasDao.getListOfGames().get(i).getBudgetAllocated();
		}

		return suma;
	}

	public void ventanaPrincipal() {
		ventanaPrincipal = gui.crearVentana(500, 400, "Gestion casa de juegos", true);
		btnCrearCasaApuestas = gui.crearBoton(20, 100, 160, 25, Color.cyan, "Gestion Casa", true,
				"ESTE BOTON ES PARA IR AL MENÚ DE CASA DE APUESTAS");
		btnRegistrarUsuario = gui.crearBoton(20, 150, 160, 25, Color.yellow, "Gestion Cliente", true,
				"ESTE BOTON ES PARA IR AL MENÚ DE CLIENTES");
		btnSedes = gui.crearBoton(20, 250, 160, 25, Color.GRAY, "Gestion sedes", true,
				"ESTE BOTON ES PARA IR AL MENÚ DE SEDES");
		btnJuegos = gui.crearBoton(20, 200, 160, 25, Color.RED, "Gestion Juegos", true,
				"ESTE BOTON ES PARA IR AL MENÚ DE JUEGOS");
		btnGestionApuestas = gui.crearBoton(20, 300, 160, 25, Color.CYAN, "Gestion apuestas", true,
				"ESTE BOTON ES PARA IR AL MENÚ DE GESTION DE APUESTAS");
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

	public void ventanaChance() {
		ventanaApuestaChance = gui.crearVentana(350, 400, "Apostar chance", true);
		campoSedeChance = gui.crearFormulario(140, 40, 120, 20, true);
		textoSedeChance = gui.crearTexto(20, 40, 120, 20, "Sede en donde jugo", true);
		campoCedulaChance = gui.crearFormulario(140, 80, 120, 20, true);
		textoCedulaChance = gui.crearTexto(60, 80, 120, 20, "Cedula", true);
		textoDiaSemanaChance = gui.crearTexto(50, 120, 120, 20, "Dia semana", true);
		campoValorChance = gui.crearFormulario(140, 160, 120, 20, true);
		textoApuestaChance = gui.crearTexto(40, 160, 120, 20, "Valor a apostar", true);
		numero1Chance = gui.crearFormulario(140, 240, 20, 20, true);
		numero2Chance = gui.crearFormulario(170, 240, 20, 20, true);
		numero3Chance = gui.crearFormulario(200, 240, 20, 20, true);
		numero4Chance = gui.crearFormulario(230, 240, 20, 20, true);
		btnCancelarChance = gui.crearBoton(60, 340, 100, 20, Color.red, "Cancelar", true, "");
		btnApostarChance = gui.crearBoton(180, 340, 100, 20, Color.green, "Apostar", true, "");
		btnActualizarChance = gui.crearBoton(60, 310, 100, 20, Color.ORANGE, "Actualizar", true, "");
		btnEliminarChance = gui.crearBoton(180, 310, 100, 20, Color.red, "Eliminar", true, "");
		btnActualizarChance.addActionListener(this);
		btnEliminarChance.addActionListener(this);
		btnCancelarChance.addActionListener(this);
		btnApostarChance.addActionListener(this);
		textoNumerosChance = gui.crearTexto(50, 235, 120, 20, "Numeros", true);
		textoLoteriasChance = gui.crearTexto(50, 280, 120, 20, "Elija una loteria", true);
		campoLoteriasChance = gui.crearFormulario(140, 280, 120, 20, true);
		campoDiaChance = gui.crearFormulario(140, 120, 120, 20, true);
		campoUsuarioChance = gui.crearFormulario(140, 200, 120, 20, true);
		textoUsuarioChance = gui.crearTexto(50, 200, 120, 20, "Apostador", true);
		ventanaApuestaChance.add(textoCedulaChance);
		ventanaApuestaChance.add(campoSedeChance);
		ventanaApuestaChance.add(textoSedeChance);
		ventanaApuestaChance.add(campoCedulaChance);
		ventanaApuestaChance.add(campoDiaChance);
		ventanaApuestaChance.add(textoDiaSemanaChance);
		ventanaApuestaChance.add(campoValorChance);
		ventanaApuestaChance.add(textoApuestaChance);
		ventanaApuestaChance.add(campoUsuarioChance);
		ventanaApuestaChance.add(textoUsuarioChance);
		ventanaApuestaChance.add(numero1Chance);
		ventanaApuestaChance.add(numero2Chance);
		ventanaApuestaChance.add(numero3Chance);
		ventanaApuestaChance.add(numero4Chance);
		ventanaApuestaChance.add(textoNumerosChance);
		ventanaApuestaChance.add(textoLoteriasChance);
		ventanaApuestaChance.add(campoLoteriasChance);
		ventanaApuestaChance.add(btnCancelarChance);
		ventanaApuestaChance.add(btnApostarChance);
		ventanaApuestaChance.add(btnActualizarChance);
		ventanaApuestaChance.add(btnEliminarChance);
	}

	public void ventanaBetplay() {
		ventanaApuestaBetplay = gui.crearVentana(350, 400, "Apostar chance", true);
		campoSedeBetplay = gui.crearFormulario(140, 40, 120, 20, true);
		textoSedeBetplay = gui.crearTexto(20, 40, 120, 20, "Sede en donde jugo", true);
		campoCedulaBetplay = gui.crearFormulario(140, 80, 120, 20, true);
		textoCedulaBetplay = gui.crearTexto(60, 80, 120, 20, "Cedula", true);
		textoDiaSemanaBetplay = gui.crearTexto(50, 120, 120, 20, "Dia semana", true);
		campoValorBetplay = gui.crearFormulario(140, 160, 120, 20, true);
		textoApuestaBetplay = gui.crearTexto(40, 160, 120, 20, "Valor a apostar", true);
		btnCancelarBetplay = gui.crearBoton(60, 340, 100, 20, Color.red, "Cancelar", true, "");
		btnApostarBetplay = gui.crearBoton(180, 340, 100, 20, Color.green, "Apostar", true, "");
		btnActualizarBetplay = gui.crearBoton(60, 310, 100, 20, Color.ORANGE, "Actualizar", true, "");
		btnEliminarBetplay = gui.crearBoton(180, 310, 100, 20, Color.red, "Eliminar", true, "");
		btnActualizarBetplay.addActionListener(this);
		btnEliminarBetplay.addActionListener(this);
		btnCancelarBetplay.addActionListener(this);
		btnApostarBetplay.addActionListener(this);
		textoPartidosBetplay = gui.crearTexto(50, 240, 120, 20, "Elija un partido", true);
		comboPartidosBetplay = gui.crearFormulario(140, 240, 150, 20, true);
		comboResultadoBetplay = gui.crearFormulario(140, 280, 120, 20, true);
		textoResultadoBetplay = gui.crearTexto(50, 280, 120, 20, "Ganador", true);
		campoDiaBetplay = gui.crearFormulario(140, 120, 120, 20, true);
		campoUsuarioBetplay = gui.crearFormulario(140, 200, 120, 20, true);
		textoUsuarioBetplay = gui.crearTexto(50, 200, 120, 20, "Apostador", true);
		ventanaApuestaBetplay.add(textoCedulaBetplay);
		ventanaApuestaBetplay.add(campoSedeBetplay);
		ventanaApuestaBetplay.add(textoSedeBetplay);
		ventanaApuestaBetplay.add(campoCedulaBetplay);
		ventanaApuestaBetplay.add(campoDiaBetplay);
		ventanaApuestaBetplay.add(textoDiaSemanaBetplay);
		ventanaApuestaBetplay.add(campoValorBetplay);
		ventanaApuestaBetplay.add(textoApuestaBetplay);
		ventanaApuestaBetplay.add(campoUsuarioBetplay);
		ventanaApuestaBetplay.add(textoUsuarioBetplay);
		ventanaApuestaBetplay.add(textoPartidosBetplay);
		ventanaApuestaBetplay.add(comboPartidosBetplay);
		ventanaApuestaBetplay.add(btnCancelarBetplay);
		ventanaApuestaBetplay.add(btnApostarBetplay);
		ventanaApuestaBetplay.add(btnActualizarBetplay);
		ventanaApuestaBetplay.add(btnEliminarBetplay);
		ventanaApuestaBetplay.add(comboResultadoBetplay);
		ventanaApuestaBetplay.add(textoResultadoBetplay);

	}

	public void ventanaSuperastro() {
		ventanaApuestaSuperastro = gui.crearVentana(350, 400, "Apostar superastro", true);
		campoSedeSuperastro = gui.crearFormulario(140, 40, 120, 20, true);
		textoSedeSuperastro = gui.crearTexto(20, 40, 120, 20, "Sede en donde jugo", true);
		campoCedulaSuperastro = gui.crearFormulario(140, 80, 120, 20, true);
		textoCedulaSuperastro = gui.crearTexto(60, 80, 120, 20, "Cedula", true);
		textoDiaSemanaSuperastro = gui.crearTexto(50, 120, 120, 20, "Dia semana", true);
		campoValorSuperastro = gui.crearFormulario(140, 160, 120, 20, true);
		textoApuestaSuperastro = gui.crearTexto(40, 160, 120, 20, "Valor a apostar", true);
		numero1Superastro = gui.crearFormulario(140, 240, 20, 20, true);
		numero2Superastro = gui.crearFormulario(170, 240, 20, 20, true);
		numero3Superastro = gui.crearFormulario(200, 240, 20, 20, true);
		numero4Superastro = gui.crearFormulario(230, 240, 20, 20, true);
		btnCancelarSuperastro = gui.crearBoton(60, 340, 100, 20, Color.red, "Cancelar", true, "");
		btnApostarSuperastro = gui.crearBoton(180, 340, 100, 20, Color.green, "Apostar", true, "");
		btnCancelarSuperastro.addActionListener(this);
		btnApostarSuperastro.addActionListener(this);
		textoNumerosSuperastro = gui.crearTexto(50, 235, 120, 20, "Numeros", true);
		textoSignosZodiacales = gui.crearTexto(50, 280, 120, 20, "Elija un signo", true);
		comboSignosZodiacales = gui.crearFormulario(140, 280, 120, 20, true);
		campoDiaSuperastro = gui.crearFormulario(140, 120, 120, 20, true);
		campoUsuarioSuperastro = gui.crearFormulario(140, 200, 120, 20, true);
		textoUsuarioSuperastro = gui.crearTexto(50, 200, 120, 20, "Apostador", true);
		campoSedeSuperastro.setEditable(false);
		campoCedulaSuperastro.setEditable(false);
		btnActualizarSuperastro = gui.crearBoton(60, 310, 100, 20, Color.ORANGE, "Actualizar", true, "");
		btnEliminarSuperastro = gui.crearBoton(180, 310, 100, 20, Color.red, "Eliminar", true, "");
		btnActualizarSuperastro.addActionListener(this);
		btnEliminarSuperastro.addActionListener(this);
		ventanaApuestaSuperastro.add(textoCedulaSuperastro);
		ventanaApuestaSuperastro.add(campoSedeSuperastro);
		ventanaApuestaSuperastro.add(textoSedeSuperastro);
		ventanaApuestaSuperastro.add(campoCedulaSuperastro);
		ventanaApuestaSuperastro.add(campoDiaSuperastro);
		ventanaApuestaSuperastro.add(textoDiaSemanaSuperastro);
		ventanaApuestaSuperastro.add(campoValorSuperastro);
		ventanaApuestaSuperastro.add(textoApuestaSuperastro);
		ventanaApuestaSuperastro.add(campoUsuarioSuperastro);
		ventanaApuestaSuperastro.add(textoUsuarioSuperastro);
		ventanaApuestaSuperastro.add(numero1Superastro);
		ventanaApuestaSuperastro.add(numero2Superastro);
		ventanaApuestaSuperastro.add(numero3Superastro);
		ventanaApuestaSuperastro.add(numero4Superastro);
		ventanaApuestaSuperastro.add(textoNumerosSuperastro);
		ventanaApuestaSuperastro.add(textoSignosZodiacales);
		ventanaApuestaSuperastro.add(comboSignosZodiacales);
		ventanaApuestaSuperastro.add(btnCancelarSuperastro);
		ventanaApuestaSuperastro.add(btnApostarSuperastro);
		ventanaApuestaSuperastro.add(btnActualizarSuperastro);
		ventanaApuestaSuperastro.add(btnEliminarSuperastro);

	}

	public void ventanaLoteria() {
		textoSerial = gui.crearTexto(65, 310, 120, 20, "Serie", true);
		campoSerial1 = gui.crearFormulario(140, 310, 20, 20, true);
		campoSerial2 = gui.crearFormulario(180, 310, 20, 20, true);
		campoSerial3 = gui.crearFormulario(220, 310, 20, 20, true);
		ventanaApuestaLoteria = gui.crearVentana(350, 480, "Apostar loteria", true);
		campoSedeLoteria = gui.crearFormulario(140, 40, 120, 20, true);
		textoSedeLoteria = gui.crearTexto(20, 40, 120, 20, "Sede en donde jugo", true);
		campoCedulaLoteria = gui.crearFormulario(140, 80, 120, 20, true);
		textoCedulaLoteria = gui.crearTexto(60, 80, 120, 20, "Cedula", true);
		textoDiaSemanaLoteria = gui.crearTexto(50, 120, 120, 20, "Dia semana", true);
		campoValorLoteria = gui.crearFormulario(140, 160, 120, 20, true);
		textoApuestaLoteria = gui.crearTexto(40, 160, 120, 20, "Valor a apostar", true);
		numero1Loteria = gui.crearFormulario(140, 240, 20, 20, true);
		numero2Loteria = gui.crearFormulario(170, 240, 20, 20, true);
		numero3Loteria = gui.crearFormulario(200, 240, 20, 20, true);
		numero4Loteria = gui.crearFormulario(230, 240, 20, 20, true);
		btnCancelarLoteria = gui.crearBoton(60, 390, 100, 20, Color.red, "Cancelar", true, "");
		btnApostarLoteria = gui.crearBoton(180, 390, 100, 20, Color.green, "Apostar", true, "");
		btnCancelarLoteria.addActionListener(this);
		btnApostarLoteria.addActionListener(this);
		textoNumerosLoteria = gui.crearTexto(50, 235, 120, 20, "Numeros", true);
		comboLoterias = gui.crearFormulario(140, 280, 120, 20, true);
		campoDiaLoteria = gui.crearFormulario(140, 120, 120, 20, true);
		campoUsuarioLoteria = gui.crearFormulario(140, 200, 120, 20, true);
		textoUsuarioLoteria = gui.crearTexto(50, 200, 120, 20, "Apostador", true);
		textoLoterias = gui.crearTexto(55, 280, 120, 20, "Loteria", true);
		campoSedeLoteria.setEditable(false);
		campoCedulaLoteria.setEditable(false);
		btnActualizarLoteria = gui.crearBoton(60, 350, 100, 20, Color.ORANGE, "Actualizar", true, "");
		btnEliminarLoteria = gui.crearBoton(180, 350, 100, 20, Color.red, "Eliminar", true, "");
		btnActualizarLoteria.addActionListener(this);
		btnEliminarLoteria.addActionListener(this);
		ventanaApuestaLoteria.add(campoSedeLoteria);
		ventanaApuestaLoteria.add(textoSedeLoteria);
		ventanaApuestaLoteria.add(campoCedulaLoteria);
		ventanaApuestaLoteria.add(textoCedulaLoteria);
		ventanaApuestaLoteria.add(textoDiaSemanaLoteria);
		ventanaApuestaLoteria.add(campoValorLoteria);
		ventanaApuestaLoteria.add(textoApuestaLoteria);
		ventanaApuestaLoteria.add(numero1Loteria);
		ventanaApuestaLoteria.add(numero2Loteria);
		ventanaApuestaLoteria.add(numero3Loteria);
		ventanaApuestaLoteria.add(numero4Loteria);
		ventanaApuestaLoteria.add(textoNumerosLoteria);
		ventanaApuestaLoteria.add(btnApostarLoteria);
		ventanaApuestaLoteria.add(btnCancelarLoteria);
		ventanaApuestaLoteria.add(comboLoterias);
		ventanaApuestaLoteria.add(campoDiaLoteria);
		ventanaApuestaLoteria.add(campoUsuarioLoteria);
		ventanaApuestaLoteria.add(textoUsuarioLoteria);
		ventanaApuestaLoteria.add(textoDiaSemanaLoteria);
		ventanaApuestaLoteria.add(textoLoterias);
		ventanaApuestaLoteria.add(campoSerial1);
		ventanaApuestaLoteria.add(campoSerial2);
		ventanaApuestaLoteria.add(campoSerial3);
		ventanaApuestaLoteria.add(textoSerial);
		ventanaApuestaLoteria.add(btnActualizarLoteria);
		ventanaApuestaLoteria.add(btnEliminarLoteria);

	}

	public void ventanaBaloto() {
		ventanaApuestaBaloto = gui.crearVentana(350, 480, "Apostar Baloto", true);
		campoSedeBaloto = gui.crearFormulario(140, 40, 120, 20, true);
		textoSedeBaloto = gui.crearTexto(20, 40, 120, 20, "Sede en donde jugo", true);
		campoCedulaBaloto = gui.crearFormulario(140, 80, 120, 20, true);
		textoCedulaBaloto = gui.crearTexto(60, 80, 120, 20, "Cedula", true);
		textoDiaSemanaBaloto = gui.crearTexto(50, 120, 120, 20, "Dia semana", true);
		campoValorBaloto = gui.crearFormulario(140, 160, 120, 20, true);
		textoApuestaBaloto = gui.crearTexto(40, 160, 120, 20, "Valor a apostar", true);
		numero1Baloto = gui.crearFormulario(140, 240, 20, 20, true);
		numero2Baloto = gui.crearFormulario(170, 240, 20, 20, true);
		numero3Baloto = gui.crearFormulario(200, 240, 20, 20, true);
		numero4Baloto = gui.crearFormulario(230, 240, 20, 20, true);
		numero5Baloto = gui.crearFormulario(260, 240, 20, 20, true);
		numero6Baloto = gui.crearFormulario(290, 240, 20, 20, true);
		btnCancelarBaloto = gui.crearBoton(60, 390, 100, 20, Color.red, "Cancelar", true, "");
		btnApostarBaloto = gui.crearBoton(180, 390, 100, 20, Color.green, "Apostar", true, "");
		btnCancelarBaloto.addActionListener(this);
		btnApostarBaloto.addActionListener(this);
		textoNumerosBaloto = gui.crearTexto(50, 235, 120, 20, "Numeros", true);
		campoDiaBaloto = gui.crearFormulario(140, 120, 120, 20, true);
		campoUsuarioBaloto = gui.crearFormulario(140, 200, 120, 20, true);
		textoUsuarioBaloto = gui.crearTexto(50, 200, 120, 20, "Apostador", true);
		campoSedeBaloto.setEditable(false);
		campoCedulaBaloto.setEditable(false);
		btnActualizarBaloto = gui.crearBoton(60, 310, 100, 20, Color.ORANGE, "Actualizar", true, "");
		btnEliminarBaloto = gui.crearBoton(180, 310, 100, 20, Color.red, "Eliminar", true, "");
		btnActualizarBaloto.addActionListener(this);
		btnEliminarBaloto.addActionListener(this);
		ventanaApuestaBaloto.add(btnActualizarBaloto);
		ventanaApuestaBaloto.add(btnEliminarBaloto);
		ventanaApuestaBaloto.add(campoSedeBaloto);
		ventanaApuestaBaloto.add(textoSedeBaloto);
		ventanaApuestaBaloto.add(campoCedulaBaloto);
		ventanaApuestaBaloto.add(textoCedulaBaloto);
		ventanaApuestaBaloto.add(textoDiaSemanaBaloto);
		ventanaApuestaBaloto.add(campoValorBaloto);
		ventanaApuestaBaloto.add(textoApuestaBaloto);
		ventanaApuestaBaloto.add(numero1Baloto);
		ventanaApuestaBaloto.add(numero2Baloto);
		ventanaApuestaBaloto.add(numero3Baloto);
		ventanaApuestaBaloto.add(numero4Baloto);
		ventanaApuestaBaloto.add(numero5Baloto);
		ventanaApuestaBaloto.add(numero6Baloto);
		ventanaApuestaBaloto.add(textoNumerosBaloto);
		ventanaApuestaBaloto.add(btnApostarBaloto);
		ventanaApuestaBaloto.add(btnCancelarBaloto);
		ventanaApuestaBaloto.add(campoDiaBaloto);
		ventanaApuestaBaloto.add(campoUsuarioBaloto);
		ventanaApuestaBaloto.add(textoUsuarioBaloto);
		ventanaApuestaBaloto.add(textoDiaSemanaBaloto);

	}

	public void ventanaGestionCasa() {
		textoListaCasa = gui.crearTexto(60, 240, 160, 20, "Informacion de la casa", true);
		ventanaCrearCasa = gui.crearVentana(300, 500, "Gestion casa", true);
		btnActualizarCasa = gui.crearBoton(20, 350, 120, 25, Color.blue, "Actualizar", true,
				"ESTE BOTON ES PARA ACTUALIZAR LOS DATOS DE UNA CASA DE APUESTAS");
		btnEliminarCasa = gui.crearBoton(150, 350, 120, 25, Color.orange, "Eliminar", true,
				"ESTE BOTON ES PARA ELIMINAR UNA CASA DE APUESTAS");
		btnActualizarCasa.addActionListener(this);
		btnEliminarCasa.addActionListener(this);
		btnCrearCasa = gui.crearBoton(20, 400, 120, 25, Color.GREEN, "Crear casa", true,
				"ESTE BOTON ES PARA CREAR UNA CASA DE APUESTAS");
		btnCrearCasa.addActionListener(this);
		btnCancelarCasa = gui.crearBoton(150, 400, 120, 25, Color.red, "Cancelar", true,
				"ESTE BOTON ES PARA VOLVER AL MENÚ ANTERIOR");
		btnCancelarCasa.addActionListener(this);
		textoCrearCasa = gui.crearTexto(20, 10, 170, 40, "Gestion casa de juegos", true);
		textoSedes = gui.crearTexto(15, 195, 120, 30, "Numero de sedes", true);
		textoDinero = gui.crearTexto(15, 115, 120, 30, "Cantidad Dinero", true);
		textoDireccion = gui.crearTexto(15, 150, 120, 30, "Nombre", true);
		campoNumSedes = gui.crearFormulario(120, 200, 40, 20, true);
		campoDinero = gui.crearFormulario(120, 120, 140, 20, true);
		campoDireccion = gui.crearFormulario(120, 160, 140, 20, true);
		listaCasa = new JList<>();
		modeloListaCasa = new DefaultListModel();
		for (int i = 0; i < casaApuestaDao.getListOfHouses().size(); i++) {
			modeloListaCasa.addElement(casaApuestaDao.getListOfHouses().get(i).getBookMarkerName());
			modeloListaCasa.addElement(casaApuestaDao.getListOfHouses().get(i).getNumberOfLocations());
			modeloListaCasa.addElement(casaApuestaDao.getListOfHouses().get(i).getTotalBudgetAvailable());
		}
		listaCasa.setBounds(40, 270, 200, 30);
		listaCasa.setModel(modeloListaCasa);
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
		ventanaCrearCasa.add(listaCasa);
	}

	public void ventanaGestionCliente() {
		textoApostadorTitulo = gui.crearTexto(40, 20, 120, 20, "Gestion apostador", true);
		textoListaClientes = gui.crearTexto(340, 20, 120, 30, "Lista clientes", true);
		consentimiento = gui.crearCirculo(180, 210, 150, 20, true);
		consentimiento.addActionListener(this);
		consentimiento.setText("Soy mayor de edad");
		btnEliminarCliente = gui.crearBoton(100, 330, 120, 20, Color.blue, "Eliminar", true,
				"ESTE BOTON ES PARA ELIMINAR CLIENTE");
		btnEliminarCliente.addActionListener(this);
		btnActualizarCliente = gui.crearBoton(180, 250, 140, 20, Color.orange, "Actualizar datos", true,
				"ESTE BOTON ES PARA ACTUALIZAR LOS DATOS DE UN CLIENTE");
		btnActualizarCliente.addActionListener(this);
		btnCrearCliente = gui.crearBoton(20, 250, 140, 20, Color.green, "Gestion cliente", true,
				"ESTE BOTON ES PARA CREAR UN CLIENTE");
		btnCrearCliente.setEnabled(false);
		btnCancelarCliente = gui.crearBoton(20, 290, 140, 20, Color.red, "Cancelar", true,
				"ESTE BOTON PARA VOLVER AL MENÚ ANTERIOR");
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
		for (int i = 0; i < apostadorDAO.getListOfGamblers().size(); i++) {

			modeloListaClientes.addElement(apostadorDAO.getListOfGamblers().get(i).getCompleteName());

		}
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
		ventanaRegistrarCliente.add(btnEliminarCliente);
		ventanaRegistrarCliente.add(listadoClientes);
		ventanaRegistrarCliente.add(textoListaClientes);
		ventanaRegistrarCliente.add(textoApostadorTitulo);
		ventanaRegistrarCliente.add(listadoClientes);
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
		btnCrearJuego = gui.crearBoton(40, 200, 100, 20, Color.green, "Gestionar", true, "BOTON CREAR JUEGO");
		btnCrearJuego.addActionListener(this);
		btnCancelarJuego = gui.crearBoton(180, 200, 100, 20, Color.red, "Cancelar", true,
				"DEVOLVERSE AL MENÚ ANTERIOR");
		btnCancelarJuego.addActionListener(this);
		comboTipoJuego = gui.createComboBox(sede, 150, 160, 120, 20);
		listadoJuego = new JList<Object>();
		modeloListaJuego = new DefaultListModel();

		for (int i = 0; i < juegoCasaApuestasDao.getListOfGames().size(); i++) {

			modeloListaJuego.addElement(juegoCasaApuestasDao.getListOfGames().get(i).getTypeOfGame());

		}
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
		ventanaGestionJuego.add(listadoJuego);
	}

	public void ventanaGestionJuegos() {
		ventanaJuegos = gui.crearVentana(600, 400, "Apuestas y juegos", true);
		btnChance = gui.crearBoton(60, 60, 80, 80, Color.red, "Chance", true,
				"ESTE BOTON ES PARA CREAR UNA APUESTA EN CHANCE");
		btnBaloto = gui.crearBoton(180, 60, 80, 80, Color.green, "Baloto", true,
				"ESTE BOTON ES PARA CREAR UNA APUESTA EN BALOTO");
		btnSuperastro = gui.crearBoton(300, 60, 80, 80, Color.green, "Superastro", true,
				"ESTE BOTON ES PARA CREAR UNA APUESTA EN SUPER ASTRO");
		btnLoteria = gui.crearBoton(120, 180, 80, 80, Color.blue, "Loteria", true,
				"ESTE BOTON ES PARA CREAR UNA APUESTA EN LOTERIA");
		btnBetplay = gui.crearBoton(240, 180, 80, 80, Color.blue, "Betplay", true,
				"ESTE BOTON ES PARA CREAR UNA APUESTA EN BETPLAY");
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
	}

	public void ventanaGestionApuestas() {
		ventanaGestionApuestas = gui.crearVentana(600, 400, "Apuestas ", true);
		ventanaGestionApuestas = gui.crearVentana(600, 400, "Apuestas ", true);
		btnChanceApuesta = gui.crearBoton(60, 60, 80, 80, Color.red, "Chance", true,
				"ESTE BOTON ES PARA CREAR EL JUEGO CHANCE EN ESTA SEDE");
		btnBalotoApuesta = gui.crearBoton(180, 60, 80, 80, Color.green, "Baloto", true,
				"ESTE BOTON ES PARA CREAR EL JUEGO BALOTO EN ESTA SEDE");
		btnSuperastroApuesta = gui.crearBoton(300, 60, 80, 80, Color.green, "Superastro", true,
				"EESTE BOTON ES PARA CREAR EL JUEGO SUPER ASTRO EN ESTA SEDE");
		btnLoteriaApuesta = gui.crearBoton(120, 180, 80, 80, Color.blue, "Loteria", true,
				"ESTE BOTON ES PARA CREAR EL JUEGO LOTERIA EN ESTA SEDE");
		btnBetplayApuesta = gui.crearBoton(240, 180, 80, 80, Color.blue, "Betplay", true,
				"ESTE BOTON ES PARA CREAR EL JUEGO BETPLAY EN ESTA SEDE");
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
		btnCrearSede = gui.crearBoton(40, 115, 90, 20, Color.GREEN, "crear", true, "ESTE BOTON ES PARA CREAR UNA SEDE");
		btnCrearSede.addActionListener(this);
		btnActualizarSede = gui.crearBoton(320, 115, 90, 20, Color.blue, "Actualizar", true,
				"ESTE BOTON ES PARA ACTUALIZAR LA SEDE, para esto debe llenar todos los datos");
		btnActualizarSede.addActionListener(this);
		btnCancelarSede = gui.crearBoton(180, 115, 90, 20, Color.RED, "cancelar", true,
				"ESTE BOTON ES PARA REGRESAR A LA VENTANA ANTERIOR");
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

		for (int i = 0; i < sedeApuestaDao.getListOfLocations().size(); i++) {
			modeloLista.addElement(sedeApuestaDao.getListOfLocations().get(i).getAddress());
			modeloLista.addElement(sedeApuestaDao.getListOfLocations().get(i).getNumberOfEmployees());

		}
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
		ventanaGestionSedes.add(listadoSedes);
		ventanaGestionSedes.add(comboDireccionSede);

	}

	public void execute() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnApostarSuperastro) {
			String informacionSemana = campoDiaSuperastro.getText();
			String informacionSigno = comboSignosZodiacales.getText();
			String informacionNum1 = numero1Superastro.getText();
			String informacionNum2 = numero2Superastro.getText();
			String informacionNum3 = numero3Superastro.getText();
			String informacionNum4 = numero4Superastro.getText();
			String informacionApuesta = campoValorSuperastro.getText();
			Boolean comprobarNumeros = comprobarNumeroInt(informacionNum1) && comprobarNumeroInt(informacionNum2)
					&& comprobarNumeroInt(informacionNum3) && comprobarNumeroInt(informacionNum4)
					&& comprobarNumeroInt(informacionApuesta);

			if (informacionSemana.isEmpty() || informacionSigno.isEmpty() || informacionApuesta.isEmpty()
					|| informacionNum1.isEmpty() || informacionNum2.isEmpty() || informacionNum3.isEmpty()
					|| informacionNum4.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos estimado usuario");
			} else if (comprobarNumeros == false) {
				JOptionPane.showMessageDialog(null,
						"Los campos numeros de apuestas y el valor a apostar solo acepta numeros estimado usuario");

			} else {

			}

		}

		if (e.getSource() == btnApostarChance) {
			// Obtener los valores de los campos
			String informacionSemana = campoDiaChance.getText();
			String informacionLoteria = "";
			String informacionUsuario = campoUsuarioLoteria.getText();
			String informacionSede = campoSedeChance.getText();
			String informacionNum1 = numero1Chance.getText();
			String informacionNum2 = numero2Chance.getText();
			String informacionNum3 = numero3Chance.getText();
			String informacionNum4 = numero4Chance.getText();
			String informacionApuesta = campoValorChance.getText();

			Boolean comprobarNumeros = comprobarNumeroInt(informacionNum1) && comprobarNumeroInt(informacionNum2)
					&& comprobarNumeroInt(informacionNum3) && comprobarNumeroInt(informacionNum4)
					&& comprobarNumeroInt(informacionApuesta);

			if (informacionSemana.isEmpty() || informacionLoteria.isEmpty() || informacionUsuario.isEmpty()
					|| informacionSede.isEmpty() || informacionNum1.isEmpty() || informacionNum2.isEmpty()
					|| informacionNum3.isEmpty() || informacionNum4.isEmpty() || informacionApuesta.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos estimado usuario");
			} else if (comprobarNumeros == false) {
				JOptionPane.showMessageDialog(null,
						"Los campos numeros de apuestas y el valor a apostar solo acepta numeros estimado usuario");
			} else {

				for (int i = 0; i < apostadorDAO.getListOfGamblers().size(); i++) {

					if (apostadorDAO.getListOfGamblers().get(i).getCompleteName()
							.equalsIgnoreCase(informacionUsuario)) {
						String casa = apostadorDAO.getListOfGamblers().get(i).getBookmakerHeadquarters();
						String id = apostadorDAO.getListOfGamblers().get(i).getIdentification();

						chanceDao.create(casa, id, informacionSemana, informacionApuesta, informacionLoteria,
								informacionNum1 + " " + informacionNum2 + " " + informacionNum3 + " "
										+ informacionNum4);
						break;
					}

				}

			}
		}

		if (e.getSource() == btnCancelarBaloto) {
			if (ventanaApuestaBaloto != null) {
				ventanaApuestaBaloto.dispose();
			}
		}

		if (e.getSource() == btnApostarBaloto) {
			String informacionSemana = (String) campoDiaBaloto.getText();
			String informacionApostador = (String) campoUsuarioBaloto.getText();
			String informacionNum1 = numero1Baloto.getText();
			String informacionNum2 = numero2Baloto.getText();
			String informacionNum3 = numero3Baloto.getText();
			String informacionNum4 = numero4Baloto.getText();
			String informacionNum5 = numero4Baloto.getText();
			String informacionNum6 = numero5Baloto.getText();
			String informacionApuesta = campoValorBaloto.getText();
			int numero1 = 0;
			int numero2 = 0;
			int numero3 = 0;
			int numero4 = 0;
			int numero5 = 0;
			int numero6 = 0;
			try {
				numero1 = Integer.parseInt(informacionNum1);
				numero2 = Integer.parseInt(informacionNum2);
				numero3 = Integer.parseInt(informacionNum3);
				numero4 = Integer.parseInt(informacionNum4);
				numero5 = Integer.parseInt(informacionNum5);
				numero6 = Integer.parseInt(informacionNum6);
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "Error: Los campos numeros solo aceptan numeros enteros");

				Boolean comprobarNumeros = comprobarNumeroInt(informacionNum1) && comprobarNumeroInt(informacionNum2)
						&& comprobarNumeroInt(informacionNum3) && comprobarNumeroInt(informacionNum4)
						&& comprobarNumeroInt(informacionApuesta) && comprobarNumeroInt(informacionNum5)
						&& comprobarNumeroInt(informacionNum6) && comprobarNumeroInt(informacionApuesta);

				if (informacionSemana.trim().isEmpty() || informacionNum1.isEmpty() || informacionNum2.isEmpty()
						|| informacionNum3.isEmpty() || informacionNum4.isEmpty() || informacionNum5.isEmpty()
						|| informacionNum6.isEmpty() || informacionApostador.trim().isEmpty()
						|| informacionNum1.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos estimado usuario");
				} else if (comprobarNumeros == false) {
					JOptionPane.showMessageDialog(null,
							"Los campos numeros de apuestas y el valor a apostar solo acepta numeros estimado usuario");

				} else if (numero1 < 1 || numero1 > 45 || numero2 < 1 || numero2 > 45 || numero3 < 1 || numero3 > 45
						|| numero4 < 1 || numero4 > 45 || numero5 < 1 || numero5 > 45 || numero6 < 1 || numero6 > 45) {
					JOptionPane.showMessageDialog(null,
							"Los rangos de los numeros deben ser entre 1 y 45 estimado usuario");
				} else {
					JOptionPane.showMessageDialog(null, "fdfdfd");
				}
			}
		}
		if (e.getSource() == btnApostarLoteria) {
			String informacionSemana = campoDiaLoteria.getText();
			String informacionLoterias = comboLoterias.getText();
			String informacionNum1 = numero1Loteria.getText();
			String informacionNum2 = numero2Loteria.getText();
			String informacionNum3 = numero3Loteria.getText();
			String informacionNum4 = numero4Loteria.getText();
			String informacionSerial1 = campoSerial3.getText();
			String informacionSerial2 = campoSerial2.getText();
			String informacionSerial3 = campoSerial1.getText();
			String informacionApuesta = campoValorLoteria.getText();
			Boolean comprobarNumeros = comprobarNumeroInt(informacionNum1) && comprobarNumeroInt(informacionNum2)
					&& comprobarNumeroInt(informacionNum3) && comprobarNumeroInt(informacionNum4)
					&& comprobarNumeroInt(informacionApuesta) && comprobarNumeroInt(informacionSerial1)
					&& comprobarNumeroInt(informacionSerial2) && comprobarNumeroInt(informacionSerial3);

			if (informacionSemana.isEmpty() || informacionLoterias.isEmpty() || informacionApuesta.isEmpty()
					|| informacionNum1.isEmpty() || informacionNum2.isEmpty() || informacionNum3.isEmpty()
					|| informacionNum4.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos estimado usuario");
			} else if (comprobarNumeros == false) {
				JOptionPane.showMessageDialog(null,
						"Los campos numeros de apuestas y el valor a apostar solo acepta numeros estimado usuario");

			} else {

			}
			// INSTALA ACA EL MODELO MI CARNITA
			// Y LOS PAPELES MANI?
			// CUIDAO CON ESTE

		}

		if (e.getSource() == btnCancelarChance) {
			if (ventanaApuestaChance != null) {
				ventanaApuestaChance.dispose();
			}
		}

		if (e.getSource() == btnBalotoApuesta) {
			ventanaBaloto();
		}

		if (e.getSource() == btnChanceApuesta) {
			ventanaChance();
		}

		if (e.getSource() == btnLoteriaApuesta) {
			ventanaLoteria();
		}

		if (e.getSource() == btnSuperastroApuesta) {
			ventanaSuperastro();
		}

		if (e.getSource() == btnCancelarBaloto) {
			if (ventanaApuestaBaloto != null) {
				ventanaApuestaBaloto.dispose();
			}
		}

		if (e.getSource() == btnCancelarLoteria) {
			if (ventanaApuestaLoteria != null) {
				ventanaApuestaLoteria.dispose();
			}
		}

		if (e.getSource() == btnCancelarSuperastro) {
			if (ventanaApuestaSuperastro != null) {
				if (ventanaApuestaSuperastro != null) {
					ventanaApuestaSuperastro.dispose();
				}
			}
		}

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

					if (sumarPresupuestos() > sedeApuestaDao.getListOfLocations().get(i).getTotalBudgetAvailable()) {
						JOptionPane.showMessageDialog(null, "el presupuesto asignado se exede del presupuesto dado");
						break;
					}

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

					if (sumarPresupuestos() > sedeApuestaDao.getListOfLocations().get(i).getTotalBudgetAvailable()) {
						JOptionPane.showMessageDialog(null, "el presupuesto asignado se exede del presupuesto dado");
						break;
					}
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

					if (sumarPresupuestos() > sedeApuestaDao.getListOfLocations().get(i).getTotalBudgetAvailable()) {
						JOptionPane.showMessageDialog(null, "el presupuesto asignado se exede del presupuesto dado");
						break;
					}
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

					if (sumarPresupuestos() > sedeApuestaDao.getListOfLocations().get(i).getTotalBudgetAvailable()) {
						JOptionPane.showMessageDialog(null, "el presupuesto asignado se exede del presupuesto dado");
						break;
					}
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

					if (sumarPresupuestos() > sedeApuestaDao.getListOfLocations().get(i).getTotalBudgetAvailable()) {
						JOptionPane.showMessageDialog(null, "el presupuesto asignado se exede del presupuesto dado");
						break;
					}
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

				String tipoDeJuego = "";

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

				for (int i = 0; i < apostadorDAO.getListOfGamblers().size(); i++) {
					if (informacionCliente
							.equalsIgnoreCase(apostadorDAO.getListOfGamblers().get(i).getCompleteName())) {
						apostadorDAO.delete(i);
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

					if (sedeApuestaDao.getListOfLocations().size() > casaApuestaDao.getListOfHouses().get(i)
							.getNumberOfLocations()) {
						JOptionPane.showMessageDialog(null,
								"la cantidad de sedes, excede el numero sedes especificado en la casa");
						break;
					}

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