package NoelArca;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import MasComponentes.TitulosAx;
/*
 * Programacion Interativa
 * Autora: Karen Paola Moreno 
 * Caso: Mini Proyecto 2 (Arca de Noel)
 */

public class Instrucciones extends JFrame {
	
	/** The original image. */
	private BufferedImage originalImage;
	
	/** The imagen. */
	private JLabel imagen;
	
	/** The adpt image. */
	private ImageIcon adptImage;
	
	/** The volver. */
	private JButton volver;
	
	/** The escucha. */
	private Escuchas escucha;
    
    /** The ventana P. */
    private JFrame ventanaP;
	
	/**
	 * Instantiates a new ventana instrucciones.
	 *
	 * @param ventanaP the ventana P
	 */
	public Instrucciones(JFrame ventanaP) {
		
		try {
			originalImage = ImageIO.read(new File("src/imagenes/Instruccion.png"));
			this.ventanaP= ventanaP;
			initGUI();
			this.setUndecorated(true);
			this.pack();
			 this.setResizable(false);
			 this.setLocationRelativeTo(null);
			 this.setVisible(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}

	/**
	 * Inits the GUI.
	 */
	private void initGUI() {
		// TODO Auto-generated method stub
		 TitulosAx titulo = new  TitulosAx("INTRUCCIONES",50,new Color(255, 87, 51) );
		add(titulo,BorderLayout.NORTH);
		escucha = new Escuchas();
		 BufferedImage subImagen = originalImage.getSubimage(0, 0, 400, 510);
		  adptImage = new ImageIcon(subImagen);
			imagen = new JLabel(adptImage);	  
			add(imagen,BorderLayout.CENTER);
			volver = new JButton("volver");
			volver .addActionListener(escucha);
			add(volver,BorderLayout.SOUTH);
	}
    
    /**
     * The Class Escuchas.
     */
    private class Escuchas implements ActionListener {

		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ventanaP.setEnabled(true);
			setVisible(false);
			
		}
    	
    
	

}
}
