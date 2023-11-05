package co.edu.unbosque.view;

import java.awt.Color;
import javax.swing.*;

/**
 * Clase que proporciona métodos para crear elementos de la interfaz de usuario
 * Swing, como JTextField, JButton, JRadioButton, mostrar mensajes emergentes,
 * crear ventanas y etiquetas de texto.
 */
public class UserGuidedInterface {

	/**
	 * Crea un campo de texto (JTextField) en la ubicación y con las dimensiones
	 * especificadas.
	 *
	 * @param posicionX   La coordenada X de la ubicación del campo de texto.
	 * @param posicionY   La coordenada Y de la ubicación del campo de texto.
	 * @param ancho       El ancho del campo de texto.
	 * @param largo       El largo del campo de texto.
	 * @param visibilidad Indica si el campo de texto es visible o no.
	 * @return Un JTextField creado con las especificaciones dadas.
	 */
	public JTextField escribirCadena(int posicionX, int posicionY, int ancho, int largo, boolean visibilidad) {
		JTextField formulario = new JTextField();
		formulario.setBounds(posicionX, posicionY, ancho, largo);
		formulario.setVisible(visibilidad);
		return formulario;
	}

	/**
	 * Crea un botón (JButton) en la ubicación y con las dimensiones especificadas.
	 *
	 * @param posicionX   La coordenada X de la ubicación del botón.
	 * @param posicionY   La coordenada Y de la ubicación del botón.
	 * @param ancho       El ancho del botón.
	 * @param largo       El largo del botón.
	 * @param color       El color de fondo del botón.
	 * @param titulo      El texto que se mostrará en el botón.
	 * @param visibilidad Indica si el botón es visible o no.
	 * @return Un JButton creado con las especificaciones dadas.
	 */
	public JButton crearBoton(int posicionX, int posicionY, int ancho, int largo, Color color, String titulo,
			boolean visibilidad) {
		JButton botonNuevo = new JButton(titulo);
		botonNuevo.setBounds(posicionX, posicionY, ancho, largo);
		botonNuevo.setBackground(color);
		botonNuevo.setVisible(visibilidad);
		return botonNuevo;
	}

	/**
	 * Crea un botón de radio (JRadioButton) en la ubicación y con las dimensiones
	 * especificadas.
	 *
	 * @param posicionX   La coordenada X de la ubicación del botón de radio.
	 * @param posicionY   La coordenada Y de la ubicación del botón de radio.
	 * @param ancho       El ancho del botón de radio.
	 * @param largo       El largo del botón de radio.
	 * @param visibilidad Indica si el botón de radio es visible o no.
	 * @return Un JRadioButton creado con las especificaciones dadas.
	 */
	public JRadioButton crearCirculo(int posicionX, int posicionY, int ancho, int largo, boolean visibilidad) {
		JRadioButton circulo = new JRadioButton();
		circulo.setBounds(posicionX, posicionY, ancho, largo);
		circulo.setVisible(visibilidad);
		return circulo;
	}

	/**
	 * Muestra un mensaje emergente (popup) con el mensaje especificado.
	 *
	 * @param msg El mensaje que se mostrará en el mensaje emergente.
	 */
	public void mostrarMensajePopUp(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	/**
	 * Crea una ventana (JFrame) con el título especificado, ubicación y
	 * visibilidad.
	 *
	 * @param posicionX   El ancho de la ventana.
	 * @param posicionY   El largo de la ventana.
	 * @param titulo      El título de la ventana.
	 * @param visibilidad Indica si la ventana es visible o no.
	 * @return Un JFrame creado con las especificaciones dadas.
	 */
	public JFrame crearVentana(int posicionX, int posicionY, String titulo, boolean visibilidad) {
		JFrame nuevaVentana = new JFrame(titulo);
		nuevaVentana.setSize(posicionX, posicionY);
		nuevaVentana.setLayout(null);
		nuevaVentana.setVisible(visibilidad);
		return nuevaVentana;
	}

	/**
	 * Crea una etiqueta de texto (JLabel) con el título especificado, ubicación y
	 * visibilidad.
	 *
	 * @param posicionX   La coordenada X de la ubicación de la etiqueta de texto.
	 * @param posicionY   La coordenada Y de la ubicación de la etiqueta de texto.
	 * @param ancho       El ancho de la etiqueta de texto.
	 * @param largo       El largo de la etiqueta de texto.
	 * @param titulo      El texto que se mostrará en la etiqueta de texto.
	 * @param visibilidad Indica si la etiqueta de texto es visible o no.
	 * @return Un JLabel creado con las especificaciones dadas.
	 */
	public JLabel crearTexto(int posicionX, int posicionY, int ancho, int largo, String titulo, boolean visibilidad) {
		JLabel texto = new JLabel(titulo);
		texto.setBounds(posicionX, posicionY, ancho, largo);
		texto.setVisible(true);
		return texto;
	}
}