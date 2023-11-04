package co.edu.unbosque.view;

import java.awt.Color;
import javax.swing.*;

public class UserGuidedInterface {

	public JTextField escribirCadena(int posicionX, int posicionY, int ancho, int largo, boolean visiblidad) {
		JTextField formulario;
		formulario = new JTextField();
		formulario.setBounds(posicionX, posicionY, ancho, largo);
		formulario.setVisible(visiblidad);
		return formulario;

	}

	public JButton crearBoton(int posicionX, int posicionY, int ancho, int largo, Color color, String titulo, boolean visiblidad) {
		JButton botonNuevo;
		botonNuevo = new JButton(titulo);
		botonNuevo.setBounds(posicionX, posicionY, ancho, largo);
		botonNuevo.setBackground(color);
		botonNuevo.setVisible(visiblidad);
		return botonNuevo;
	}

	public JRadioButton crearCirculo(int posicionX, int posicionY, int ancho, int largo, boolean visiblidad) {
		JRadioButton circulo;
		circulo = new JRadioButton();
		circulo.setBounds(posicionX, posicionY, ancho, largo);
		circulo.setVisible(visiblidad);
		return circulo;
	}

	public void mostrarMensajePopUp(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	public JFrame crearVentana(int posicionX, int posicionY, String titulo, boolean visibilidad) {
		JFrame nuevaVentana;
		nuevaVentana = new JFrame(titulo);
		nuevaVentana.setSize(posicionX, posicionY);
		nuevaVentana.setLayout(null);
		nuevaVentana.setVisible(visibilidad);
		return nuevaVentana;
	}

	public JLabel crearTexto(int posicionX, int posicionY, int ancho, int largo, String titulo, boolean visibilidad) {
		JLabel texto;
		texto = new JLabel(titulo);
		texto.setBounds(posicionX, posicionY, ancho, largo);
		texto.setVisible(true);
		return texto;
	}

}
