package modelo;

import javax.swing.JOptionPane;

public class Tablero implements Cloneable {

	private Casilla[] listaFichas;

	private Casilla[] listaFichasOrdenadas;


	public Tablero() {
		listaFichas = new Casilla[9];
		listaFichasOrdenadas = new Casilla[9];
		llenarListaOrdenada();
	}


	public void iniciarTablero() {
		
		Casilla c = null;

		// primeraa fila
		c = new Casilla("1", 0, 0);
		listaFichas[0] = c;
		c = new Casilla("2", 0, 1);
		listaFichas[1] = c;
		c = new Casilla("3", 0, 2);
		listaFichas[2] = c;

		// segunda fila
		c = new Casilla("4", 1, 0);
		listaFichas[3] = c;
		c = new Casilla("5", 1, 1);
		listaFichas[4] = c;
		c = new Casilla("6", 1, 2);
		listaFichas[5] = c;

		// tercera fila
		c = new Casilla("7", 2, 0);
		listaFichas[6] = c;
		c = new Casilla("9", 2, 1);
		listaFichas[7] = c;
		c = new Casilla("8", 2, 2);
		listaFichas[8] = c;
		
		
		/*
		for (int i = 0, x = 0, y = 0; i < listaFichas.length; i++, y++) {
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
			listaFichas[i] = casilla;
		}
		*/
	}

	public void llenarListaOrdenada() {
		Casilla c = null;

		// primeraa fila
		c = new Casilla("1", 0, 0);
		listaFichasOrdenadas[0] = c;
		c = new Casilla("2", 0, 1);
		listaFichasOrdenadas[1] = c;
		c = new Casilla("3", 0, 2);
		listaFichasOrdenadas[2] = c;

		// segunda fila
		c = new Casilla("4", 1, 0);
		listaFichasOrdenadas[3] = c;
		c = new Casilla("5", 1, 1);
		listaFichasOrdenadas[4] = c;
		c = new Casilla("6", 1, 2);
		listaFichasOrdenadas[5] = c;

		// tercera fila
		c = new Casilla("7", 2, 0);
		listaFichasOrdenadas[6] = c;
		c = new Casilla("8", 2, 1);
		listaFichasOrdenadas[7] = c;
		c = new Casilla("9", 2, 2);
		listaFichasOrdenadas[8] = c;
	}

	public Casilla[] darListaCasillaOrdenada() {
		return listaFichasOrdenadas;
	}

	/**
	 * Metodo que retorna las casillas del puzzle
	 * 
	 * @return <b>listaCasilla</b> de tipo <b>Casilla[]</b>
	 */
	public Casilla[] darListaFicha() {
		return listaFichas;
	}
	
	public void cambiarListaFicha(Casilla[] unaLista){
		listaFichas = unaLista;
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
		while (contador < listaFichas.length && !encontrado) {
			// obtiene la casilla en la posicion actual
			Casilla c = listaFichas[contador];
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

	/**
	 * Metodo que retorno el lugar donde se puede jugar
	 * @return c de tipo <b>Casilla</b>
	 */
	public Casilla darHueco() {
		Casilla c = null;
		for (int i = 0; i < listaFichas.length; i++) {
			c = listaFichas[i];
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
		for (int i = 0; i < listaFichas.length && !encontrado; i++) {
			Casilla c = listaFichas[i];
			if (c.getAtributo().equalsIgnoreCase(atributo)) {
				c.setPosX(unaCasilla.getPosX());
				c.setPosY(unaCasilla.getPosY());

				listaFichas[i] = c;
				encontrado = true;
			}
		}
	}

	/**
	 * Crear uun metodo que me recorra de 0 a 9 si existe un movimiento si
	 * existe un movimiento
	 * 
	 */
	public boolean existeMovimiento(String atributo, int unaPosX, int unaPosY) {
		Casilla c = null;
		boolean movimiento = false;
		switch (unaPosX) {
			case 0:
				switch (unaPosY) {
					case 0:
						// selecciona la posicion 00
						// posibles movimientos 01 10
						c = darHueco();
						// JOptionPane.showMessageDialog(this, "" + c.getPosX()
						// + " " + c.getPosY());
						if ((c.getPosX() == 0 && c.getPosY() == 1) || (c.getPosX() == 1 && c.getPosY() == 0)) {

							movimiento = true;

						}
						break;
					case 1:
						// selecciona la opción 01
						// posibles movimientos 00 02 11
						c = darHueco();
						// JOptionPane.showMessageDialog(this, "" + c.getPosX()
						// + " " + c.getPosY());
						if ((c.getPosX() == 0 && c.getPosY() == 0) || (c.getPosX() == 0 && c.getPosY() == 2)
						        || (c.getPosX() == 1 && c.getPosY() == 1)) {

							movimiento = true;

						}
						break;

					case 2:
						// selecciona la opcion 02
						// posibles movimientos 01 12
						c = darHueco();
						// JOptionPane.showMessageDialog(this, "" + c.getPosX()
						// + " " + c.getPosY());
						if ((c.getPosX() == 0 && c.getPosY() == 1) || (c.getPosX() == 1 && c.getPosY() == 2)) {

							movimiento = true;

						}
						break;

					default:
						break;
				}
				break;
			case 1:
				switch (unaPosY) {
					case 0:
						// selecciona la opcion 10
						// posibles movimientos 00 11 20
						c = darHueco();
						// JOptionPane.showMessageDialog(this, "" + c.getPosX()
						// + " " + c.getPosY());
						if ((c.getPosX() == 0 && c.getPosY() == 0) || (c.getPosX() == 1 && c.getPosY() == 1)
						        || (c.getPosX() == 2 && c.getPosY() == 0)) {

							movimiento = true;

						}
						break;
					case 1:
						// selecciona la opcion 11
						// posibles movimientos 01 10 12 21
						c = darHueco();
						if ((c.getPosX() == 0 && c.getPosY() == 1) || (c.getPosX() == 1 && c.getPosY() == 0)
						        || (c.getPosX() == 1 && c.getPosY() == 2) || (c.getPosX() == 2 && c.getPosY() == 1)) {

							movimiento = true;

						}
						break;
					case 2:
						// selecciona la opcion 12
						// posibles movimientos 02 11 22
						c = darHueco();

						if ((c.getPosX() == 0 && c.getPosY() == 2) || (c.getPosX() == 1 && c.getPosY() == 1)
						        || (c.getPosX() == 2 && c.getPosY() == 2)) {

							movimiento = true;

						}
						break;

					default:
						break;
				}
				break;

			case 2:
				switch (unaPosY) {
					case 0:
						// selecciona la opción 20
						// posibles movimientos 10 21
						c = darHueco();

						if ((c.getPosX() == 1 && c.getPosY() == 0) || (c.getPosX() == 2 && c.getPosY() == 1)) {

							movimiento = true;

						}
						break;

					case 1:
						// selecciona la opcion 21
						// posibles movimientos 11 20 22
						c = darHueco();

						if ((c.getPosX() == 1 && c.getPosY() == 1) || (c.getPosX() == 2 && c.getPosY() == 0)
						        || (c.getPosX() == 2 && c.getPosY() == 2)) {

							movimiento = true;

						}
						break;

					case 2:
						// selecciona la opcion 22
						// posibles movimientos 12 21

						c = darHueco();
						if ((c.getPosX() == 1 && c.getPosY() == 2) || (c.getPosX() == 2 && c.getPosY() == 1)) {

							movimiento = true;

						}

						break;

					default:
						break;
				}
				break;
			default:
				break;
		}

		return movimiento;
	}

	/**
	 * 
	 * @param unaLista
	 * @return
	 */
	public int contarFichasDesorden(Casilla[] unaLista) {
		int numeroDesorden = 0;
		for (int i = 0; i < listaFichasOrdenadas.length; i++) {
			Casilla fo = listaFichasOrdenadas[i];
			int contador = 0;
			while (contador < unaLista.length) {
				Casilla fd = unaLista[contador];
				if (fo.getAtributo().equalsIgnoreCase(fd.getAtributo())) {
					if (!(fo.getPosX() == fd.getPosX() && fo.getPosY() == fd.getPosY())) {
						numeroDesorden = numeroDesorden + 1;
					}
				}
				contador++;

			}
		}
		return numeroDesorden;
	}
	
	public void imprimir(){
		//System.out.println("nombre: "+nombre);
		
		for (Casilla casilla : listaFichas) {
			
			System.out.println("Atributo: "+casilla.getAtributo()+" x: "+casilla.getPosX()+" y: "+casilla.getPosY());
		}
		
	}

	/**
	 * Metodo para generar una copia de esta clase
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		Tablero unTablero = null;
		unTablero = (Tablero) super.clone();
		unTablero.listaFichas = (Casilla[]) unTablero.listaFichas.clone();
		return unTablero;
	}
	
	/**
	 * Metodo que genera una copia de todas las fichas del tablero 
	 * @return unasFichas de tipo <b>Casilla[]</b>
	 * @throws CloneNotSupportedException Si no se puede generar una copia 
	 */
	public Casilla[] darCopiaFichas() throws CloneNotSupportedException{
		Casilla[] unasFichas = new Casilla[listaFichas.length];
		for (int i = 0; i < listaFichas.length; i++) {
			unasFichas[i] = (Casilla) listaFichas[i].clone();
		}
		
		return unasFichas;
	}


	
	
}
