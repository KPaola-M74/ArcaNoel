package NoelArca;
/*
 * Programacion Interativa
 * Autora: Karen Paola Moreno 
 * Caso: Mini Proyecto 2 (Arca de Noel)
 */

// TODO: Auto-generated Javadoc
/**
 * The Class CartaAnimal.
 */
public class CartaAnimal {





	/** The url. */
	private String url;

	/** The id image. */
	private int idImage; 


	/**
	 * Metodo que genera internamente un numero aleatorio del 1 al 30,donde cada numero es asociado con un url(que contiene la ruta de una imagen )
	 *
	 * @return the string(" la ruta de la imagen")
	 */
	public String asignarUrlImage()
	{
		url="src/Imagenes/";
		// cantidad maxima de imagenes que tengo disponibles.
		int limiteS = 30;
		//genera los numeros aleatorios del 1 al 30.
		idImage = (int) Math.floor(Math.random()*(limiteS-1+1)+1);
        //relaciona el numero aleaotorio anterior con su su url asignada.
		switch(idImage) 
		{
        
		case 1:
			url += "1.png";
			break;
		case 2:
			url += "2.png";
			break;
		case 3:
			url += "3.png";
			break;
		case 4:
			url += "4.png";
			break;
		case 5:
			url += "5.png";
			break;
		case 6:
			url += "6.png";
			break;
		case 7:
			url += "7.png";
			break;
		case 8:
			url += "8.png";
			break;
		case 9:
			url += "9.png";
			break;
		case 10:
			url += "10.png";
			break;

		case 11:
			url += "11.png";
			break;
		case 12:
			url += "12.png";
			break;

		case 13:
			url += "13.png";
			break;

		case 14:
			url += "14.png";
			break;

		case 15:
			url += "15.png";
			break;

		case 16:
			url += "16.png";
			break;

		case 17:
			url += "17.png";
			break;

		case 18:
			url += "18.png";
			break;

		case 19:
			url += "19.png";
			break;

		case 20:
			url += "20.png";
			break;


		case 21:
			url += "21.png";
			break;

		case 22:
			url += "22.png";
			break;

		case 23:
			url += "23.png";
			break;

		case 24:
			url += "24.png";
			break;

		case 25:
			url += "25.png";
			break;

		case 26:
			url += "26.png";
			break;

		case 27:
			url += "27.png";
			break;



		case 28:
			url += "28.png";
			break;

		case 29:
			url += "29.png";
			break;

		default:
			url += "30.png";	
			break;
		} 
		return url;

	}



	/**
	 * Gets the url.
	 * ( Metodo que da el url que sale de la funcion principal.)
	 *
	 * @return the url
	 */
	public String getUrl()
	{
		return url;
	}



	/**
	 * Gets the idmage.
	 *  Metodo que da el numero  que sale de la funcion principal.
	 *
	 * @return the idmage
	 */
	public int getIdmage()
	{
		return idImage;
	}










}



	


