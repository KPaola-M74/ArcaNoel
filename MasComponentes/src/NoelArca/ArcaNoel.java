package NoelArca;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MasComponentes.TitulosAx;

// TODO: Auto-generated Javadoc
/*
 * Programacion Interativa
 * Autora: Karen Paola Moreno 
 * Caso: Mini Proyecto 2 (Arca de Noel)
 */


public class ArcaNoel extends JFrame {



	

	private JPanel zonaJuego,zonaResultados,zonaBotones;


	


	private JLabel  puntos,dificultad,parejas;



	private  JTextField  valorPuntos,valorDificultad,parejasEncontradas;

	


	private JLabel carta1,carta2,carta3,carta4,carta5,carta6,carta7,carta8,carta9,carta10,carta11,carta12;


	private JButton salir,instr,reiniciar;


	private  String imagen1,imagen2,imagen3,imagen4,imagen5,imagen6;
	
	private CartaAnimal animal1,animal2,animal3,animal4,animal5,animal6; 

	private   JLabel cartasTotales [] = new JLabel[12];

	
	
	private int punt,par,difici,clickado1,clickado2,numeroAuxili,numeroAletorio,numeroAuxili2,comparar1,comparar2;

	
	private int  numero1,numero2,numero3,numero4,numero5,numero6;

	
	private int contadorPuntos=0;

	
	private Escucha escucha;

	
	private JFrame miMisma = this;

	
	private Instrucciones ventanaAyuda = new Instrucciones(miMisma);

	
	private  TitulosAx titulo; 

	
	private int posicionesAletorias1[] = new int[6];

	private int posicionesAletorias2[] = new int[9];


	private int  posicionesAletoria3[] = new int[12];
	
	private Boolean resultadoPa,resultado2;



	/**
	 * Instantiates a new arca noel.
	 */
	public ArcaNoel () {


		initGUI();
		//configuaracion inicial de la ventana 
		this.setUndecorated(true);
		this.setBackground(new Color(255,255,255,100));
		
		this.pack();

		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Metodo que tiene los elemntos que se pintaran en  la ventana (Botones,Jlabel , etc)
	 */
	private void initGUI() {
		// set up container-layout
		
		this.getContentPane().setLayout(new  GridBagLayout());
		GridBagConstraints contraints =  new GridBagConstraints();

		escucha = new Escucha();
		//Zona del titulo del  juego 
		titulo =  new  TitulosAx( "Arca de Noel ",50, new Color(255, 87, 51) );
		contraints.gridx=1;
		contraints.gridy=0;
		contraints.gridwidth=1;
		contraints.gridheight=1;
		contraints.fill = GridBagConstraints.HORIZONTAL;
		add(titulo,contraints);
		//Zona donde ese encuentra  la informacion de como va el jugador en el juego("cuantos puntos lleva, cuantas parejas  ha encontrado y en que  dificultad se encuentra")
		zonaResultados = new JPanel ();
		zonaResultados.setLayout(new GridLayout(1,3));
		
		puntos= new JLabel("Puntos");
		dificultad = new JLabel("Dificultad");
		parejas= new JLabel("Parejas");

		valorPuntos = new JTextField(2);
		valorPuntos.setEditable(false);
		valorDificultad = new JTextField(2);
		valorDificultad.setEditable(false);
		parejasEncontradas = new JTextField(2);
		parejasEncontradas.setEditable(false);
		
		zonaResultados.add(puntos);
		zonaResultados.add(valorPuntos);
		zonaResultados.add(dificultad);
		zonaResultados.add(valorDificultad);
		zonaResultados.add(parejas);
		zonaResultados.add(parejasEncontradas);

		contraints.gridx = 1;
		contraints.gridy = 1;
		contraints.gridheight =1;
		contraints.gridwidth = 1;
		contraints.fill = GridBagConstraints.NONE;
		contraints.anchor = GridBagConstraints.SOUTH;
		contraints.insets.left=2;
		add(zonaResultados,contraints);
		// zona donde estan las imagenes  que se destaparan
		zonaJuego = new JPanel ();
		zonaJuego.setLayout(new GridLayout(4,3,30, 5 ));
		carta1  = new JLabel( );
		carta2  = new JLabel( );
		carta3  = new JLabel( );
		carta4  = new JLabel( );
		carta5  = new JLabel( );
		carta6  = new JLabel( );
		carta7  = new JLabel( );
		carta8  = new JLabel( );
		carta9  = new JLabel( );
		carta10 = new JLabel( );
		carta11 = new JLabel( );
		carta12 = new JLabel( );

		cartasTotales [0]=carta1;
		cartasTotales [1]=carta2;
		cartasTotales [2]=carta3;
		cartasTotales [3]=carta4;
		cartasTotales [4]=carta5;
		cartasTotales [5]=carta6;
		cartasTotales [6]=carta7;
		cartasTotales [7]=carta8;
		cartasTotales [8]=carta9;
		cartasTotales [9]=carta10;
		cartasTotales [10]=carta11;
		cartasTotales [11]=carta12;


		//Agrega cada carata a la zona juego y tambien le pone a cada Jlabel su esccucha
		for(int l=0; l <12; l++) {
			zonaJuego.add(cartasTotales[l]);
			cartasTotales[l].addMouseListener(escucha);
		}


		contraints.gridx = 1;
		contraints.gridy = 2;
		contraints.gridwidth =1;
		contraints.gridheight = 1;
		contraints.fill = GridBagConstraints.NONE;
		add(zonaJuego,contraints);

		zonaBotones= new JPanel();
		zonaBotones.setLayout(new GridLayout(1,3,30, 10 ));
		salir = new  JButton("Salir");
		reiniciar = new JButton("Reiniciar");
		instr = new JButton("Instrucciones");
		
		//salir.setBackground(new Color(255, 87, 51));
		//instr.setBackground(new Color(255, 87, 51));
		
		zonaBotones.add(reiniciar);
		zonaBotones.add(instr);
		zonaBotones.add(salir);

		instr.addActionListener(escucha);
		salir.addActionListener(escucha);
		reiniciar.addActionListener(escucha); 

		contraints.gridx = 1;
		contraints.gridy = 3;
		contraints.gridheight =1;
		contraints.gridwidth = 1;
		contraints.fill = GridBagConstraints.NONE;
		contraints.anchor = GridBagConstraints.LAST_LINE_END;

		add(zonaBotones,contraints);
		
	

		//ajustes iniciales  a la zonaResultado(puntuaje inicial(0), dificultad inicial(1) y numeros de parejas encontrados(0) );

		InicializarComponentes();




	}  

	/**Inicializar componentes.
	 * le da  da a los tributos principales valor inicial.
	 */
	public void InicializarComponentes() {
		//numero inicial de Ide no encontrada
		numeroAletorio=0;
		//llamada al metodo que contiene las imagenes (informacion relacionada de los atributos tipo CartaAnimal como urls i Ides)
		imagenes(); 
		//valor del punto inicial
		punt=0;
		//valor de la pareja que se tiene inicialmente
		par=0;
		//valor de la dificultad del juego inicialmente 
		difici=1;
		// Muentra en la ZonaResulta la informacion de la dificultad
		valorDificultad.setText(String.valueOf(difici));
		// Muentra en la ZonaResulta la informacion de los puntos 
		valorPuntos.setText(String.valueOf(punt));
		// Muentra en la ZonaResulta la informacion de las parejas encontradas
		parejasEncontradas.setText(String.valueOf(par));
		//numero de clic en la primera carta 
		clickado1= 0;
		//numero de clic en la segunda carta 
		clickado2= 0;
		//variable auxiliar que servira como contador para que no se de clic 2 veces en la misma carta que ya se descubierto
		numeroAuxili=0;
		//variable auxiliar que servira como contador para saber si es la primera vez que se compara  2 pares de cartas 
		contadorPuntos=0;
		//muestra en pantalla las cartas iniciales dado el la dificultad inicial
		dificultadP(cartasTotales ,difici);
		//contiene las imagenes ya distribuida aleatoriamente 
		dificultadImagenes();


	}

	/** Dificultad imagenes.
	 *Le da a cada dificulad ya sea 1,2,3,4 o 5  un arrglo con sus respectivo numeros aletorios que hacen referncia a las ubicaciones 
	 */
	private void  dificultadImagenes() {
		if(difici== 1 || difici==2) {
			NumerosAletorios(difici,posicionesAletorias1); 

		}else if(difici==3) {

			NumerosAletorios(difici,posicionesAletorias2); 
		}else {

			NumerosAletorios(difici,posicionesAletoria3);
		}

	}

	/**Imagenes.
	 * El metodo saca  la infirmacion de cada  atributo de la Clase CartaAnimal(el url que se genero aleatoriamente y el Ide relacionado con el)
	 */
	private void imagenes() {
		animal1  = new CartaAnimal();
		animal2  = new CartaAnimal();
		animal3  = new CartaAnimal();
		animal4  = new CartaAnimal();
		animal5  = new CartaAnimal();
		animal6  = new CartaAnimal();
		imagen1= animal1.asignarUrlImage();
		imagen2= animal2.asignarUrlImage();
		imagen3=animal3.asignarUrlImage();
		imagen4=animal4.asignarUrlImage();
		imagen5=animal5.asignarUrlImage();
		imagen6=animal6.asignarUrlImage();

		numero1= animal1.getIdmage();
		numero2= animal2.getIdmage();
		numero3=animal3.getIdmage();
		numero4=animal4.getIdmage();
		numero5=animal5.getIdmage();
		numero6=animal6.getIdmage();


	}

	/**Pasar nivel.
	 * 
	 * El metodo verifica si el jugador  cunplio con las condiciones para pasar de nivel ("completar el numero de parejas  que se requiren") y basado en eso  aumenta la dificultad  y cambia la informacion de la informacion y genera las nueva Informacion de los atributos de Clase CartaAnimal 
	 */
	private void  PasarNivel() {
		// difici es la dificultad en que se encuentra el jugador y par es el numero de pareja que tiene 
		if(difici==1 && par==2) {
			difici++;
			valorDificultad.setText(String.valueOf(difici));
			par=0;
			parejasEncontradas.setText(String.valueOf(par));
			imagenes(); 
			numeroAletorio=0;
			dificultadP(cartasTotales ,difici);
			dificultadImagenes();
			//le da valor  para que el pasar de nivel no se quiten la imagen basada en la ultima posicion que se formo  en el nivel anterior 
			numeroAuxili=12;
			numeroAuxili2=12;

		}else if(difici==2 && par==3) {
			difici++;
			valorDificultad.setText(String.valueOf(difici));
			par=0;
			parejasEncontradas.setText(String.valueOf(par));
			imagenes() ;

			numeroAletorio=0;
			dificultadP(cartasTotales ,difici);
			dificultadImagenes();
			numeroAuxili=12;
			numeroAuxili2=12;
		}else if(difici==3 && par==4) {
			difici++;
			valorDificultad.setText(String.valueOf(difici));
			par=0;
			parejasEncontradas.setText(String.valueOf(par));
			imagenes(); 



			dificultadP(cartasTotales ,difici);
			dificultadImagenes();
			numeroAuxili=12;
			numeroAuxili2=12;


		}else if(difici==4 && par==5) {
			difici++;
			par=0;
			valorDificultad.setText(String.valueOf(difici));
			parejasEncontradas.setText(String.valueOf(par)); 				
			dificultadP(cartasTotales ,difici);

			dificultadImagenes();
			numeroAuxili=12;
			numeroAuxili2=12;
		}else if(difici==5 && par==6) {
			par=0;
			valorDificultad.setText(String.valueOf(difici));
			parejasEncontradas.setText(String.valueOf(par));
			imagenes(); 


			dificultadP(cartasTotales ,difici);

			dificultadImagenes();
			numeroAuxili=12;
			numeroAuxili2=12;

			// si ya se comparo dos parejas y su puntuajes es menor  a 0 reinicia completamente el juegp 
		}else if(1<=contadorPuntos&& punt==-1) {
			InicializarComponentes();

		}

	}


	/**
	 * 	Metodo que visualiza en pantalla (pone visible el JlLabel ) el numero de carta que se necesita en base en la dificulatad en que se se encuentra 
	 * 	Dificulatad  1: 4 Cartas posicion 0,2,3,4    			visible en la zonaJuego.
		Dificulatad  2: 6 cartas  posicion 0,1,2,3,4,5    		visible en la zonaJuego.
		Dificulatad  3: 8 cartas  posicion 0,1,2,3,5,6,7,8  	visible en la zonaJuego.
		Dificulatad  4: 10 cartas posicion 0,1,2,3,4,5,6,7,8,10 visible en la zonaJuego.
		Dificulatad  5: 12 cartas  0,1,2,3,4,5,6,7,8,9,10,11    visible en la zonaJuego.
	 *  Tiene como parametro   un array de Jlabel donde se encuentran el conjuntos de Jlabel creados anteriormente , y tambien toma un numero que es la difcultad en que se encuentra para en base de el mostrar en pantalla  lo conrrepondiente.
	 * @param JLabel   array
	 * @param int  
	 * 
	 * 
	 */

	private  void  dificultadP(JLabel array [],int nivel) {
		//Este Bucle rrecore el array que se ingresa y le asigna la imagen inicial(La imagen no se han dado vuelta)
		for (int i = 0; i 	< array.length; i++) {
			array[i].setIcon(new ImageIcon("src/Imagenes/0.png"));      
		}


		if(nivel==1)
		{   //aqui se rrecore el array de Jlabel  y si esta en la dificultad 1 , 4 Jlabel son visibles  y las demas no.
			for (int i = 0; i < array.length; i++) {
				if(i<=11 && i!=0 && i!=2 && i!=3 && i!=5) {

					array[i].setVisible(false);

				}else {
					array[i].setVisible(true);
				}
			}



		}else {
			//aqui se rrecore el array de Jlabel  y si esta en la dificultad 2 , 6 Jlabel son visibles  y las demas no.
			if(nivel==2) {

				for (int i = 0; i < array.length; i++) {
					if(i<=5 ) {
						array[i].setVisible(true); 
					}
					else {
						array[i].setVisible(false);


					}

				}	


			}else {
				//aqui se rrecore el array de Jlabel  y si esta en la dificultad 3 , 8 Jlabel son visibles  y las demas no.
				if(nivel==3) {



					for (int i = 0; i < array.length; i++) {
						if(i<=8 && i!=4) {
							array[i].setVisible(true); 
						}
						else {
							array[i].setVisible(false);


						}

					}	

				}
				else {
					if(nivel==4) 
					{
						//aqui se rrecore el array de Jlabel  y si esta en la dificultad 4 , 10 Jlabel son visibles  y las demas no.	
						for (int i = 0; i < array.length; i++) {
							if(i<=8) {
								array[i].setVisible(true); 
							}
							else if(i==10) {
								array[i].setVisible(true);
							}
							else {
								array[i].setVisible(false);


							}

						}	



					}else {
						//aqui se rrecore el array de Jlabel  y si esta en la dificultad 5 ,todos estan visibles.
						if (nivel>=5) {

							for (int i = 0; i < array.length; i++) {


								array[i].setVisible(true);   
							}	

						}
					}
				}
			}
		}
	}


	/**Reiniciar.
	 * Metodo que llama a la funcion InicializarComponentes() y reinicia por completo el juego.
	 * 
	 */
	private void reiniciar() {

		InicializarComponentes();




	}

	/**Descubrir.
	 * Este metodo tiene como entrada 2 numero uno  especifica en  que dificultad se encuentra el  jugador y el otro es que  posicion del array que continelos JLabel se  ha dado el clic.
	 *  el metodo utiliza los  arreglo de numeros enteros  que  fueron llenados de forma  aleorias, basados en esos numeros  se rrecorre el aray y  cada elemento es comparado con el numero  de la pocion en que se dio click y se le asigna  la informacion de la CartaAnimal conrrepodiente (tambien este metodo me distribuye las imagenes de forma uniforme para garantizar que cada imagen tenga una imagen igual)
	 *
	 * @param int 
	 * @param int 
	 * @return ide
	 */
	private int  Descubrir(int nivelito ,int posic) {

		//si la dificultad es 1 ,osea 4 cartas  en pantalla 
		if(nivelito==1) 
		{
			//variable que me  garantiza que  tenga su pareja 
			int j=0;

			for(int i=0; i <posicionesAletorias1.length   ; i++) {
				//se garantiza que en el   numero que no esta visible en pantalla no se tome
				if(posicionesAletorias1[i]!=1 && posicionesAletorias1[i]!=4&& j<2) {
					// verifica si el numero que esta en el arrayAletorio es igual a la posicon en donde se esta dado clic
					if(posicionesAletorias1[i]==posic) {
						// muestra en  pantalla  la  imagen que le toco("la imagen esta basada en url que genero aleatoriamente la CarataAnimal)
						cartasTotales[posicionesAletorias1[i]].setIcon(new ImageIcon(imagen1));
						// le da  valor del ide conrrepondiente a la imagen 
						numeroAletorio=numero1;
					}
					j++; 
				}else {
					//verifica si el numero que esta en el arrayAletorio es igual a la posicon en donde se esta dado clic
					if(posicionesAletorias1[i]==posic) {
						cartasTotales[posicionesAletorias1[i]].setIcon(new ImageIcon(imagen2));
						// le da  valor del ide conrrepondiente a la imagen 
						numeroAletorio=numero2;
					}


				}



			}

			//si la dificultad es 2 ,osea 6 cartas  en pantalla 

		}else if(nivelito==2 )
		{    //variable que me  garantiza que  tenga su pareja 
			int contador=0;

			for(int i=0; i <6   ; i++) {
				//verifica que la imagen  asignada tenga su pareja 
				if(i<=1 && contador<2) {
					// verifica si el numero que esta en el arrayAletorio es igual a la posicon en donde se esta dado clic
					if(posicionesAletorias1[i]==posic) {
						// muestra en  pantalla  la  imagen que le toco("la imagen esta basada en url que genero aleatoriamente la CarataAnimal)

						cartasTotales[posicionesAletorias1[i]].setIcon(new ImageIcon(imagen1));
						// le da  valor del ide conrrepondiente a la imagen 
						numeroAletorio=numero1;
					}contador++;

				}  else if(i!=1  && i!=0 && i<=3  ){
					// verifica si el numero que esta en el arrayAletorio es igual a la posicon en donde se esta dado clic
					if(posicionesAletorias1[i]==posic) {
						// muestra en  pantalla  la  imagen que le toco("la imagen esta basada en url que genero aleatoriamente la CarataAnimal)

						cartasTotales[posicionesAletorias1[i]].setIcon(new ImageIcon(imagen2));
						// le da  valor del ide conrrepondiente a la imagen 
						numeroAletorio=numero2;
					}
				}
				else {
					if(posicionesAletorias1[i]==posic) {
						// muestra en  pantalla  la  imagen que le toco("la imagen esta basada en url que genero aleatoriamente la CarataAnimal)

						cartasTotales[posicionesAletorias1[i]].setIcon(new ImageIcon(imagen3));
						// le da  valor del ide conrrepondiente a la imagen 
						numeroAletorio=numero3;

					}

				}


			}

			//si la dificultad es 3 ,osea 8 cartas  en pantalla 

		} else if(nivelito ==3 ) {
			//variables que me  garantiza que  tenga su pareja 
			int j=0;
			int contador2= 0;
			int contador3= 0;

			for(int i=0; i <posicionesAletorias2.length   ; i++) {
				//se garantiza que en el   numero que no esta visible en pantalla no se tome
				if( posicionesAletorias2[i]!= 4&& j<2) {

					// verifica si el numero que esta en el arrayAletorio es igual a la posicon en donde se esta dado clic
					if(posicionesAletorias2[i]==posic) {
						// muestra en  pantalla  la  imagen que le toco("la imagen esta basada en url que genero aleatoriamente la CarataAnimal)

						cartasTotales[posicionesAletorias2[i]].setIcon(new ImageIcon(imagen1));
						// le da  valor del ide conrrepondiente a la imagen 
						numeroAletorio=numero1;
					}
					j++; 
				}else if( posicionesAletorias2[i]!= 4 && contador2<2){
					// verifica si el numero que esta en el arrayAletorio es igual a la posicon en donde se esta dado clic
					if(posicionesAletorias2[i]==posic) {
						// muestra en  pantalla  la  imagen que le toco("la imagen esta basada en url que genero aleatoriamente la CarataAnimal)

						cartasTotales[posicionesAletorias2[i]].setIcon(new ImageIcon(imagen2));
						// le da  valor del ide conrrepondiente a la imagen 
						numeroAletorio=numero2;
					}
					contador2++; 
					// verifica si el numero que esta en el arrayAletorio es igual a la posicon en donde se esta dado clic
				}else if (posicionesAletorias2[i]!= 4 && contador3<2){
					if(posicionesAletorias2[i]==posic) {
						// muestra en  pantalla  la  imagen que le toco("la imagen esta basada en url que genero aleatoriamente la CarataAnimal)

						cartasTotales[posicionesAletorias2[i]].setIcon(new ImageIcon(imagen3));
						// le da  valor del ide conrrepondiente a la imagen 
						numeroAletorio=numero3;
					}
					contador3++;




				}else {
					// verifica si el numero que esta en el arrayAletorio es igual a la posicon en donde se esta dado clic
					if(posicionesAletorias2[i]==posic) {
						cartasTotales[posicionesAletorias2[i]].setIcon(new ImageIcon(imagen4));
						// le da  valor del ide conrrepondiente a la imagen 
						numeroAletorio=numero4;
					}
				}






			} 


		}//si la dificultad es 2 ,osea 10 cartas  en pantalla 
		else if(nivelito==4) {
			//variables que me  garantiza que  tenga su pareja 
			int contadorA1=0;
			int contadorB2= 0;
			int contadorC3= 0;
			int contadorD4=0;
			for(int i=0; i <12   ; i++) {

				if( posicionesAletoria3[i]!= 9 && posicionesAletoria3[i]!= 11  && contadorA1<2) {


					if(posicionesAletoria3[i]==posic) {
						// muestra en  pantalla  la  imagen que le toco("la imagen esta basada en url que genero aleatoriamente la CarataAnimal)

						cartasTotales[posicionesAletoria3[i]].setIcon(new ImageIcon(imagen1));
						// le da  valor del ide conrrepondiente a la imagen 
						numeroAletorio=numero1 ;

					}contadorA1++;

				}else if( posicionesAletoria3[i]!= 9 && posicionesAletoria3[i]!= 11 && contadorB2<2){
					if(posicionesAletoria3[i]==posic) {
						// muestra en  pantalla  la  imagen que le toco("la imagen esta basada en url que genero aleatoriamente la CarataAnimal)

						cartasTotales[posicionesAletoria3[i]].setIcon(new ImageIcon(imagen2));
						// le da  valor del ide conrrepondiente a la imagen 
						numeroAletorio=numero2 ;



					}
					contadorB2++; 

				}else if (posicionesAletoria3[i]!= 9 && posicionesAletoria3[i]!= 11 && contadorC3<2){
					if(posicionesAletoria3[i]==posic) {
						// muestra en  pantalla  la  imagen que le toco("la imagen esta basada en url que genero aleatoriamente la CarataAnimal)

						cartasTotales[posicionesAletoria3[i]].setIcon(new ImageIcon(imagen3));
						// le da  valor del ide conrrepondiente a la imagen 
						numeroAletorio=numero3;
					}
					contadorC3++;




				}else if (posicionesAletoria3[i]!= 9 && posicionesAletoria3[i]!= 11 && contadorD4<2){

					if(posicionesAletoria3[i]==posic) {
						// muestra en  pantalla  la  imagen que le toco("la imagen esta basada en url que genero aleatoriamente la CarataAnimal)

						cartasTotales[posicionesAletoria3[i]].setIcon(new ImageIcon(imagen4));
						// le da  valor del ide conrrepondiente a la imagen 
						numeroAletorio=numero4;
					}
					contadorD4++;
				}
				else if(posicionesAletoria3[i]  != 9 && posicionesAletoria3[i]!= 11) {

					if(posicionesAletoria3[i]==posic) {
						// muestra en  pantalla  la  imagen que le toco("la imagen esta basada en url que genero aleatoriamente la CarataAnimal)

						cartasTotales[posicionesAletoria3[i]].setIcon(new ImageIcon(imagen5));
						// le da  valor del ide conrrepondiente a la imagen 
						numeroAletorio=numero5;
					}
				}

			} 


		}//si la dificultad es 2 ,osea 8 cartas  en pantalla 
		else if (5==nivelito) {

			//variables que me  garantiza que  tenga su pareja 

			int contador1=0;
			int contador2= 0;
			int contador3= 0;
			int contador4=0;
			int contador5=0;
			for(int i=0; i <posicionesAletoria3.length   ; i++) {

				if( i<2&& contador1<2) {


					if(posicionesAletoria3[i]==posic) {
						// muestra en  pantalla  la  imagen que le toco("la imagen esta basada en url que genero aleatoriamente la CarataAnimal)

						cartasTotales[posicionesAletoria3[i]].setIcon(new ImageIcon(imagen1));
						// le da  valor del ide conrrepondiente a la imagen

						numeroAletorio=numero1;
						contador1++; 

					}

				}else if(i!=0 && i!=1  &&i <4 && contador2<2){
					if(posicionesAletoria3[i]==posic) {
						// muestra en  pantalla  la  imagen que le toco("la imagen esta basada en url que genero aleatoriamente la CarataAnimal)

						cartasTotales[posicionesAletoria3[i]].setIcon(new ImageIcon(imagen2));
						// le da  valor del ide conrrepondiente a la imagen
						numeroAletorio=numero2;
						contador2++; 
					}


				}else if ( i!=0 && i!=1  &&i !=2 && i!=3&& i<6 && contador3<2){
					if(posicionesAletoria3[i]==posic) {
						// muestra en  pantalla  la  imagen que le toco("la imagen esta basada en url que genero aleatoriamente la CarataAnimal)

						cartasTotales[posicionesAletoria3[i]].setIcon(new ImageIcon(imagen3));
						// le da  valor del ide conrrepondiente a la imagen
						numeroAletorio=numero3; 
						contador3++;
					}





				}else if (i!=0 && i!=1  &&i !=2 && i!=3&& i!=4 && i!=5 && i <8 && contador4<2){
					if(posicionesAletoria3[i]==posic) {
						// muestra en  pantalla  la  imagen que le toco("la imagen esta basada en url que genero aleatoriamente la CarataAnimal)

						cartasTotales[posicionesAletoria3[i]].setIcon(new ImageIcon(imagen4));
						// le da  valor del ide conrrepondiente a la imagen
						numeroAletorio=numero4;
						contador4++;
					}

				}else if (i!=0 && i!=1  &&i !=2 && i!=3&& i!=4 && i!=5 && i!=6 && i!=7&& i<10 &&contador5<2){
					if(posicionesAletoria3[i]==posic) {
						// muestra en  pantalla  la  imagen que le toco("la imagen esta basada en url que genero aleatoriamente la CarataAnimal)

						cartasTotales[posicionesAletoria3[i]].setIcon(new ImageIcon(imagen5));
						// le da  valor del ide conrrepondiente a la imagen
						numeroAletorio=numero5;
						contador5++;
					}


				}
				else if(i==10|| i==11){

					if(posicionesAletoria3[i]==posic) {
						// muestra en  pantalla  la  imagen que le toco("la imagen esta basada en url que genero aleatoriamente la CarataAnimal)

						cartasTotales[posicionesAletoria3[i]].setIcon(new ImageIcon(imagen6));
						// le da  valor del ide conrrepondiente a la imagen
						numeroAletorio=numero6;
					}
				}


			}
		}


		// retorna el ide conrrepondiente  al cada caso

		return numeroAletorio;				



	} 





	/**
	 * Son pareja.
	 * Este método  me compara los Ide(numero asociado a una imagen  especifica que es generada por el atributo  de la casa CartaAnima),si ya se dio clic a 2 imágenes  me dicen si las 2 son iguales o no y me cuenta internamente cuantas veces se han descubierto las cartas sin importar si son iguales o no .
	 *
	 * @return the boolean
	 */

	private Boolean SonPareja() {

		if(comparar1 == comparar2&& clickado2==2 && clickado1==1) {

			System.out.print("Carta 1 :"+comparar1+" ,  Carta 2: "+comparar2+"  Son pareja"+"\n");

			contadorPuntos++;

			resultadoPa= true;


		}
		else if(clickado2==2 && clickado1==1) {
			//contador que ayuda a saber cuantas veces se ha comparados dos cartas.
			contadorPuntos++;
			System.out.print("Carta 1 :"+comparar1+" ,  Carta 2: "+comparar2 +"No  Son pareja"+"\n");
			resultadoPa=false;



		}


		return resultadoPa;

	}





	/**Timer.
	 * Este metodo en base  en la funcion SonPareja() que devuelve un  booleano checa  si   es true  quita(la vuelve invisible) la imagen del panel y de lo contrario  la tapa con la imagen inicial  todo esto en tiempo estalecido 
	 * 
	 */
	public void timer() {

		Timer tiempo = new Timer();
		TimerTask accion = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				if(numeroAuxili2==12 && numeroAuxili==12) {

					tiempo.cancel();
				}
				else if(SonPareja()== true) {
					//Quita la carta del  juego
					//numeroAuxili numeroAuxili2 se refiere  a la posicion que se ha dado click del panel.
					cartasTotales[numeroAuxili].setVisible(false);
					cartasTotales[numeroAuxili2].setVisible(false);


					tiempo.cancel();


				}

				else if(SonPareja()== false) {

					//Voltea la cartas 
					cartasTotales[numeroAuxili2].setIcon(new ImageIcon("src/Imagenes/0.png"));
					cartasTotales[numeroAuxili].setIcon(new ImageIcon("src/Imagenes/0.png"));




					tiempo.cancel();
				} 

			}

		};tiempo.schedule(accion, 180);

	} 

	/**Paso nivel.
	 * este metodo llama a la funcion PasarNivel();	 y la ejecuta cada cierto tiempo para que lograr apreciar cuando se pasa de nivel 
	 */
	public void  pasoNivel() {


		Timer tiempo = new Timer();
		TimerTask accion = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub


				PasarNivel();	




			}

		};tiempo.schedule(accion, 200);

	}

	/**Tablero puntos.
	 Este método me suma o resta puntos, pareja, dificultad y me lo muestra en la zona resultado en base si se encontró dos imágenes iguales o no,y me habilita el dar clic en una imagen.

	 @param
	 @param


	 * */

	private  void TableroPuntos(){
		if(SonPareja()== true) {

			punt++;
			par++;
			valorPuntos.setText(String.valueOf(punt));
			parejasEncontradas.setText(String.valueOf(par));
			clickado1=0;
			clickado2=0;


		}else if(contadorPuntos!=1) {


			punt--;
			valorPuntos.setText(String.valueOf(punt));
			clickado1=0;
			clickado2=0;


		}else {
			clickado1=0;
			clickado2=0;
		}

	}



	/** Números aleatorios.
	 *Este método me llena un array de números  enteros  de manera Aleatoria   sin  que se  repitan por  ejemplo del 1 al 12 se lo pude llenar de la forma [11,9,6,3,4,2,1,0,5,7,8,10]
	 *Según en el nivel en que  se encuentre a si mismo es la cantidad de números que genera  por ejemplo  si la dificultad es de 1  o 2 me genera 6 números  aleatorios del 0 al 5

	 * @param int 
	 * @param  int []
	 */
	private void NumerosAletorios(int nivel, int array []) {

		if(nivel==1 || nivel==2) {

			array[0]=(int) Math.floor(Math.random()*6); 
			//llena el array de numero aleatorio 
			for (int i = 1; i <6; i++) {


				array[i]=  (int) Math.floor(Math.random()*6);

				for(int j = 0; j < i; j++) {
					// Verifica que ningún numero se repita y si en tal caso se repite el numero,   disminuye   la variable  i para que vuelva y  me genere otro numero  diferente  y sucesivamente hasta que cada posición este llena y todos los numero sean diferentes 
					if(array[i]== array[j]) {

						i--; 


					}
				}


			}	
		}else if(nivel==3) {
			array[0]=(int) Math.floor(Math.random()*7); 
			//llena el array de numero aleatorio.
			for (int i = 1; i <9; i++) {
				// Verifica que ningún numero se repita y si en tal caso se repite el numero,   disminuye   la i para que vuelva y  me genere otro numero  diferente  y sucesivamente hasta que cada posición este llena y todos los numero sean diferentes 


				array[i]=  (int) Math.floor(Math.random()*9);

				for(int j = 0; j < i; j++) {

					if(array[i]== array[j]) {

						i--; 


					}
				}



			}



		}
		else if(nivel==4 ||  nivel== 5) {
			array[0]=(int) Math.floor(Math.random()*12); 
			//llena el array de numero aleatorio.			
			for (int i = 1; i <12; i++) {


				array[i]=  (int) Math.floor(Math.random()*12);

				for(int j = 0; j < i; j++) {
					// Verifica que ningún numero se repita y si en tal caso se repite el numero,   disminuye   la i para que vuelva y  me genere otro numero  diferente  y sucesivamente hasta que cada posición este llena y todos los numero sean diferentes 

					if(array[i]== array[j]) {

						i--; 


					}
				}



			}



		}


	}


	/**
	 * The Class Escucha.
	 * Este metodo incorpora los eventos del Mouses 
	 */
	private class Escucha   extends MouseAdapter  implements  ActionListener {


		/**
		 * Mouse clicked.
		 *
		 * @param e the e
		 */
		@Override
		public void mouseClicked(MouseEvent e) {

			//rrecore el  array donde encuentra las  cartas tipo Jlabel para saber en cual se estado click.
			for (int i = 0; i < cartasTotales.length; i++) {
				if(e.getSource()==cartasTotales[i] && clickado1==0 && clickado2==0 ) {


					clickado1=1;
					clickado2=1;
					//esta es una variable que ayuda a que no se este dandp clic 2 veces en la misma imagen
					numeroAuxili=i;
					//muestra  la imagen que toco en esa posicion en donde se dio clic y a la varuable le asigna el ide que devuelve el metodo
					comparar1= Descubrir(difici,i);



				}

				else  if(e.getSource()== cartasTotales[i] && clickado2==1 && clickado1==1 && numeroAuxili!=i ) {

					numeroAuxili2=i;
					clickado2++;
					//muestra  la imagen que toco en esa posicion en donde se dio clic y a la varuable le asigna el ide que devuelve el metodo
					comparar2= Descubrir(difici,i);
					//ya que se  verica que esta destapada las 2 imagenes se llama al metodo timer para que quite o voltee las imagenes 

					timer();
					//muestra en el la zonaResultados la informacion nueva que se  ha generado
					TableroPuntos();
					// llama al metodo para ver si  se cumple las condicciones para pasar el nivel en un tiempo dado
					pasoNivel();			
				} 
			}  

		}


		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		@Override
		public void actionPerformed(ActionEvent e) {

			// TODO Auto-generated method stub
			// si se toca el boton de las instrucciones abre la ventana de esta 
			if(e.getSource()== instr) {
				ventanaAyuda.setVisible(true);
				miMisma.setEnabled(false);
			}else {
				// si se toca el boton salir  cierra el programa 
				if(e.getSource()== salir) {
					System.exit(0);
				}
				else {
					// si te toca el boton reiniciar   reinicia el juego
					if(e.getSource()== reiniciar) {
						reiniciar();
					}
				}
			}

		}
	}




}
