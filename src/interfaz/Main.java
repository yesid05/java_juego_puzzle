package interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import modelo.Casilla;
import modelo.Tablero;

public class Main extends JFrame {

	private PanelTablero panelTablero;

	private Tablero tablero;

	public Main() {

		tablero = new Tablero();
		tablero.iniciarTablero();

		panelTablero = new PanelTablero(this);
		panelTablero.llenarTablero();

		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		add(panelTablero, BorderLayout.CENTER);
	}

	public static void main(String[] args) {

		Main m = new Main();
		m.asignarAtributo();
		m.setVisible(true);
		// m.imprimirBckTablero();
		// m.imprimirOrdenada();
		m.movimientosMecanicos();

	}

	public void asignarAtributo() {
		Casilla[] lista = tablero.darListaFicha();
		for (int i = 0; i < lista.length; i++) {
			Casilla c = lista[i];
			panelTablero.asignarAtributo(c.getAtributo(), c.getPosX(), c.getPosY());
		}
		panelTablero.actualizarFichas();
	}

	public void imprimirBckTablero() {
		Casilla[] lista = tablero.darListaFicha();
		for (int i = 0; i < lista.length; i++) {
			Casilla c = lista[i];

			System.out.println(i + " Atributo " + c.getAtributo() + " posx " + c.getPosX() + " posy " + c.getPosY());
		}
	}

	public void imprimirOrdenada() {
		Casilla[] lista = tablero.darListaCasillaOrdenada();
		for (int i = 0; i < lista.length; i++) {
			Casilla c = lista[i];

			System.err.println(i + " Atributo " + c.getAtributo() + " posx " + c.getPosX() + " posy " + c.getPosY());
		}
	}

	public Casilla darHueco() {
		return tablero.darHueco();
	}

	/**
	 * metodo mover rsiva casilla A casilla B en el tablero se llama el metodo
	 * mover ficha se invoca para casilla a y casilla b
	 */
	public void moverFicha(Casilla casillaA, Casilla casillaB) {
		tablero.moverFicha(casillaA);
		tablero.moverFicha(casillaB);
		System.out.println("================================");
		this.imprimirBckTablero();
	}

	public void movimientosMecanicos() {
		/*
		System.out.println("=====================");
		tablero.imprimir();
		
		Tablero unTablero = null;
		Casilla[] unasFichas = null;
		try {
			unTablero =  (Tablero)tablero.clone();
			unTablero.cambiarListaFicha(tablero.darCopiaFichas());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Casilla[] aux = unTablero.darListaFicha();
		aux[0].setAtributo("9");
		aux[1].setAtributo("8");
		System.out.println("======================");
		unTablero.imprimir();
		System.out.println("======================");
		tablero.imprimir();
		System.out.println("======================");
		*/
		
		Casilla[] listaFicha = tablero.darListaFicha();
		int contador = 0;
		while (contador < listaFicha.length) {
			Casilla a = listaFicha[contador];
			if (tablero.existeMovimiento(a.getAtributo(), a.getPosX(), a.getPosY())) {
				
				Tablero unTablero = darCopiaTablero();
				
				try {
					unTablero.cambiarListaFicha(tablero.darCopiaFichas());
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("=============");
				System.out.println("Atributo: " + a.getAtributo());

				Casilla b = tablero.darHueco();
				
				String aa = a.getAtributo();
				int ax = a.getPosX();
				int ay = a.getPosY();
				
				String ab = b.getAtributo();
				int bx = b.getPosX();
				int by = b.getPosY();
				
				Casilla[] listaCasilla = unTablero.darListaFicha();
				//modificar casilla a
				for (Casilla casilla : listaCasilla) {
					if(casilla.getPosX() == bx && casilla.getPosY() == by){
						casilla.setAtributo(aa);
					}
				}
				//modificar casilla b
				for (Casilla casilla : listaCasilla) {
					if(casilla.getPosX() == ax && casilla.getPosY() == ay){
						casilla.setAtributo(ab);
					}
				}

				unTablero.imprimir();
				System.out.println("============\ntablero original");
				tablero.imprimir();
				System.out.println("============");
				
			}
			contador++;
		}
	}

	public Tablero darCopiaTablero() {
		Tablero unTablero = null;
		try {
			unTablero = (Tablero) tablero.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return unTablero;
	}

}
