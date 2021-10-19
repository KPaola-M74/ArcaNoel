package MasComponentes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
// TODO: Auto-generated Javadoc

/**
 * The Class TitulosAx.
 */
/*
 * Programacion Interativa
 * Autora: Karen Paola Moreno -1940254
 * Caso: Mini Proyecto 2 (Arca de Noel)
 */
public class TitulosAx extends JLabel {

	
	/**
	 * Instantiates a new titulos ax.
	 *
	 * @param texto the texto
	 * @param tamano the tamano
	 * @param colorFondo the color fondo
	 */
	public TitulosAx(String texto,int tamano , Color colorFondo) {
		 this.setText(texto);
		 Font font= new Font(Font.SERIF,Font.BOLD+Font.ITALIC,tamano);
		 setFont(font);
		 this.setForeground(Color.WHITE);
		 this.setBackground(colorFondo);
		 this.setOpaque(true);
		 this.setHorizontalAlignment(JLabel.CENTER);
		}

	
	
}



