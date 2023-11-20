package co.edu.unbosque.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import co.edu.unbosque.view.*;

public class Controller implements ActionListener {

	UserGuidedInterface gui = new UserGuidedInterface();
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

	public Boolean comprobarNumero(String numero) {
		Boolean confirmacion;
		try {
			int conversion = Integer.parseInt(numero);
			return confirmacion = true;
		} catch (NumberFormatException ex) {
			return confirmacion = false;

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == consentimiento) {
			btnCrearCliente.setEnabled(true);
		}

		if (e.getSource() == btnRegistrarUsuario) {
			RegistrarCliente();
		}

		if (e.getSource() == btnSedes) {
			GestionSedes();
		}

		if (e.getSource() == btnCrearCasaApuestas) {
			VentanaGestionCasa();
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

			} else
				JOptionPane.showMessageDialog(null, "¡Bienvenido a la casa de juegos! " + informacionNombre);

			// INSTALA ACA EL MODELO MI CARNITA
			// Y LOS PAPELES MANI?
			// CUIDAO CON ESTE

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

			} else
				JOptionPane.showMessageDialog(null, "Casa de juegos creada exitosamente ");

			// INSTALA ACA EL MODELO MI CARNITA
			// ACA DIEGO NO ESTA, APROVECHA

		}

		if (e.getSource() == btnCrearSede) {
			String informacionDireccion = campoDireccionSede.getText();
			String informacionEmpleados = campoEmpleados.getText();
			Boolean comprobarEmpleados = comprobarNumero(informacionEmpleados);

			if (informacionDireccion.isEmpty() || informacionEmpleados.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos estimado usuario");
			} else if (comprobarEmpleados == false) {
				JOptionPane.showMessageDialog(null, "El campo empleados acepta numeros  estimado usuario");

			} else
				JOptionPane.showMessageDialog(null, "Sede creada exitosamente ");

			// INSTALA ACA EL MODELO MI CARNITA
			// INVOCA A HOYOS PARA ATACAR A DIEGO

		}

		// https://www.youtube.com/watch?v=SMmf3os4EGw Ya valio scooby xd

		// https://www.instagram.com/reel/CzTZfeII3xm/?igshid=MTc4MmM1YmI2Ng==
	}

	public void VentanaPrincipal() {
		ventanaPrincipal = gui.crearVentana(500, 400, "Gestion casa de juegos", true);
		btnCrearCasaApuestas = gui.crearBoton(20, 100, 160, 25, Color.cyan, "Crear Casa", true);
		btnRegistrarUsuario = gui.crearBoton(20, 150, 160, 25, Color.yellow, "Registrar Cliente", true);
		btnSedes = gui.crearBoton(20, 250, 160, 25, Color.GRAY, "Gestion sedes", true);
		btnJuegos = gui.crearBoton(20, 200, 160, 25, Color.RED, "Juegos", true);
		btnCrearCasaApuestas.addActionListener(this);
		btnSedes.addActionListener(this);
		btnJuegos.addActionListener(this);
		btnRegistrarUsuario.addActionListener(this);
		textoBienvenida = gui.crearTexto(20, 50, 190, 30, "Gestion Casa de Juegos", true);
		ventanaPrincipal.add(btnCrearCasaApuestas);
		ventanaPrincipal.add(textoBienvenida);
		ventanaPrincipal.add(btnRegistrarUsuario);
		ventanaPrincipal.add(btnSedes);
		ventanaPrincipal.add(btnJuegos);
	}

	public void VentanaGestionCasa() {
		ventanaCrearCasa = gui.crearVentana(300, 500, "Crear Casa de juegos", true);
		btnCrearCasa = gui.crearBoton(20, 400, 120, 25, Color.GREEN, "Crear casa", true);
		btnCrearCasa.addActionListener(this);
		btnCancelarCasa = gui.crearBoton(150, 400, 120, 25, Color.red, "Cancelar", true);
		btnCancelarCasa.addActionListener(this);
		textoCrearCasa = gui.crearTexto(20, 10, 170, 40, "Crear casa de juegos", true);
		textoSedes = gui.crearTexto(15, 195, 120, 30, "Numero de sedes", true);
		textoDinero = gui.crearTexto(15, 115, 120, 30, "Cantidad Dinero", true);
		textoDireccion = gui.crearTexto(15, 150, 120, 30, "Direccion", true);
		campoNumSedes = gui.crearFormulario(120, 200, 40, 20, true);
		campoDinero = gui.crearFormulario(120, 120, 140, 20, true);
		campoDireccion = gui.crearFormulario(120, 160, 140, 20, true);
		ventanaCrearCasa.add(btnCancelarCasa);
		ventanaCrearCasa.add(btnCrearCasa);
		ventanaCrearCasa.add(textoCrearCasa);
		ventanaCrearCasa.add(campoDinero);
		ventanaCrearCasa.add(campoNumSedes);
		ventanaCrearCasa.add(campoDireccion);
		ventanaCrearCasa.add(textoSedes);
		ventanaCrearCasa.add(textoDinero);
		ventanaCrearCasa.add(textoDireccion);
	}

	public void RegistrarCliente() {
		consentimiento = gui.crearCirculo(180, 220, 200, 40, true);
		consentimiento.addActionListener(this);
		consentimiento.setText("Soy mayor de edad");
		btnCrearCliente = gui.crearBoton(20, 250, 140, 20, Color.green, "Crear cliente", true);
		btnCrearCliente.setEnabled(false);
		btnCancelarCliente = gui.crearBoton(20, 290, 140, 20, Color.red, "Cancelar", true);
		btnCrearCliente.addActionListener(this);
		btnCancelarCliente.addActionListener(this);
		ventanaRegistrarCliente = gui.crearVentana(330, 420, "Registrar Cliente", true);
		campoNombres = gui.crearFormulario(170, 70, 140, 20, true);
		textoNombres = gui.crearTexto(20, 70, 140, 20, "Nombres completos", true);
		textoTelefono = gui.crearTexto(20, 110, 140, 20, "Telefono personal", true);
		campoCelular = gui.crearFormulario(170, 110, 140, 20, true);
		campoCedula = gui.crearFormulario(170, 150, 140, 20, true);
		campoDireccionJuego = gui.crearFormulario(170, 190, 140, 20, true);
		textoCedula = gui.crearTexto(20, 150, 140, 20, "Cedula mayor de edad", true);
		textoDireccionJuego = gui.crearTexto(20, 190, 140, 20, "Direccion juego", true);
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
	}

	public void GestionSedes() {
		ventanaGestionSedes = gui.crearVentana(500, 400, "Gestionar sedes", true);
		btnCrearSede = gui.crearBoton(70, 115, 120, 20, Color.GREEN, "crear", true);
		btnCancelarSede = gui.crearBoton(220, 115, 120, 20, Color.RED, "cancelar", true);
		btnCancelarSede.addActionListener(this);
		textoGestionSedes = gui.crearTexto(10, 0, 140, 30, "Gestionar sedes", true);
		textoDireccionSede = gui.crearTexto(20, 20, 150, 140, "Direccion", true);
		textoEmpleadosSede = gui.crearTexto(20, 40, 140, 30, "Numero de empleados", true);
		campoEmpleados = gui.crearFormulario(170, 45, 140, 20, true);
		campoDireccionSede = gui.crearFormulario(170, 80, 140, 20, true);
		listadoSedes = new JList();
		modeloLista = new DefaultListModel();
		listadoSedes.setBounds(20, 150, 400, 150);
		listadoSedes.setModel(modeloLista);
		ventanaGestionSedes.add(listadoSedes);
		ventanaGestionSedes.add(textoGestionSedes);
		ventanaGestionSedes.add(textoDireccionSede);
		ventanaGestionSedes.add(textoEmpleadosSede);
		ventanaGestionSedes.add(campoEmpleados);
		ventanaGestionSedes.add(campoDireccionSede);
		ventanaGestionSedes.add(btnCrearSede);
		ventanaGestionSedes.add(btnCancelarSede);
	}

}