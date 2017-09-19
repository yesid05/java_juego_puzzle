package modelo;

public class Tablero {

	private Casilla[] listaCasillas;

	private Casilla[] listaCasillaOrdenada;

	private String nombre;

	public Tablero() {
		listaCasillas = new Casilla[9];
		listaCasillaOrdenada = new Casilla[9];
		llenarListaOrdenada();
	}

	public void iniciarTablero() {

		for (int i = 0, x = 0, y = 0; i < listaCasillas.length; i++, y++) {
			// ayuda a determinar el eje x y eje y de la casilla
			if (i == 3 || i == 6) {
				x++;
				y = 0;
			}
			// construye la casilla
			Casilla casilla = new Casilla();
			// agrega la posicion en x y y
			casilla.setPosX(x);
			casilla.setPosY(y);

			boolean atributoAsignado = false;
			// pregunta si la casilla ya tiene un atributo si no la tiene le
			// asigna una
			while (!atributoAsignado) {
				// genera un atributa al azar
				int atributo = generarRandom();
				// si el atributo no esta asignado se lo asigna
				if (!buscarAtributo(String.valueOf(atributo))) {
					casilla.setAtributo(String.valueOf(atributo));
					atributoAsignado = true;
				}
			}
			// agrega la casilla a la lista
			listaCasillas[i] = casilla;
		}
	}

	public void llenarListaOrdenada() {
		Casilla c = null;

		// primeraa fila
		c = new Casilla("1", 0, 0);
		listaCasillaOrdenada[0] = c;
		c = new Casilla("2", 0, 1);
		listaCasillaOrdenada[1] = c;
		c = new Casilla("3", 0, 2);
		listaCasillaOrdenada[2] = c;
		
		//segunda fila 
		c = new Casilla("4",1,0);
		listaCasillaOrdenada[3] = c;
		c = new Casilla("5",1,1);
		listaCasillaOrdenada[4] = c;
		c = new Casilla("6",1, 2);
		listaCasillaOrdenada[5] = c;
		
		//tercera fila 
		c = new Casilla("7",2,0);
		listaCasillaOrdenada[6] = c;
		c = new Casilla("8", 2, 1);
		listaCasillaOrdenada[7] = c;
		c = new Casilla("9", 2, 2);
		listaCasillaOrdenada[8] = c;
	}
	
	public Casilla[] darListaCasillaOrdenada(){
		return listaCasillaOrdenada;
	}

	/**
	 * Metodo que retorna las casillas del puzzle
	 * 
	 * @return <b>listaCasilla</b> de tipo <b>Casilla[]</b>
	 */
	public Casilla[] darListaFicha() {
		return listaCasillas;
	}

	/**
	 * Metodo que genera un atributo de forma aleatoria
	 * 
	 * @return un entero
	 */
	public int generarRandom() {
		// genera un numero de 1 a 9
		return (int) (Math.random() * 9) + 1;
	}

	/**
	 * Metodo para buscar si un atributo ya esta asignado
	 * 
	 * @param unAtributo
	 *            atributo a buscar de tipo cadena
	 * @return <b>true</b> si el atributo ya esta asignado <b>false</b> sino
	 *         esta asignado.
	 */
	public boolean buscarAtributo(String unAtributo) {
		// por defecto la casilla no tiene un atributo
		boolean encontrado = false;
		int contador = 0;
		// recoore toda la lista de casillas
		while (contador < listaCasillas.length && !encontrado) {
			// obtiene la casilla en la posicion actual
			Casilla c = listaCasillas[contador];
			// si la casilla actual esta en la lista
			if (c != null) {
				// busca el atributo y el resultado lo asigna a la variable
				// encontrado
				encontrado = c.buscarAtributo(unAtributo);
			}
			// si la casilla actual no esta en la lista
			else {
				// la casilla actual no tiene atributo retorna false
				encontrado = false;
			}
			contador++;
		}

		// retorna encontrado
		return encontrado;
	}

	public Casilla darHueco() {
		Casilla c = null;
		for (int i = 0; i < listaCasillas.length; i++) {
			c = listaCasillas[i];
			if (c.buscarAtributo("9")) {
				return c;
			}
		}

		return c;
	}

	/**
	 * mover ficha resive una ficha la busca y actualiza la posicion en x y y se
	 * busca por atributo se actualiza x y y no se busca por x y y
	 */
	public void moverFicha(Casilla unaCasilla) {
		String atributo = unaCasilla.getAtributo();
		boolean encontrado = false;
		for (int i = 0; i < listaCasillas.length && !encontrado; i++) {
			Casilla c = listaCasillas[i];
			if (c.getAtributo().equalsIgnoreCase(atributo)) {
				c.setPosX(unaCasilla.getPosX());
				c.setPosY(unaCasilla.getPosY());

				listaCasillas[i] = c;
				encontrado = true;
			}
		}
	}

}
