package interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import modelo.Casilla;
import modelo.Tablero;

public class Main extends JFrame{
	
	private PanelTablero panelTablero;
	
	private Tablero tablero;
	
	public Main() {
		
		tablero = new Tablero();
		tablero.iniciarTablero();
		
		panelTablero = new PanelTablero(this);
		panelTablero.llenarTablero();
		
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		add(panelTablero,BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		
		Main m = new Main();
		m.asignarAtributo();
		m.setVisible(true);
		m.imprimirBckTablero();
		m.imprimirOrdenada();
		
		
		
	}
	
	public void asignarAtributo(){
		Casilla[] lista = tablero.darListaFicha();
		for (int i = 0; i < lista.length; i++) {
			Casilla c = lista[i];
			panelTablero.asignarAtributo(c.getAtributo(), c.getPosX(), c.getPosY());
		}
		panelTablero.actualizarFichas();
	}
	
	public void imprimirBckTablero(){
		Casilla[] lista = tablero.darListaFicha();
		for (int i = 0; i < lista.length; i++) {
			Casilla c = lista[i];
			
			System.out.println(i+" Atributo "+c.getAtributo()+" posx "+c.getPosX()+" posy "+c.getPosY());
		}
	}
	
	public void imprimirOrdenada(){
		Casilla[] lista = tablero.darListaCasillaOrdenada();
		for (int i = 0; i < lista.length; i++) {
			Casilla c = lista[i];
			
			System.err.println(i+" Atributo "+c.getAtributo()+" posx "+c.getPosX()+" posy "+c.getPosY());
		}
	}
	
	public Casilla darHueco(){
		return tablero.darHueco();
	}
	
	/**
	 * metodo mover rsiva casilla A casilla B
	 * en el tablero se llama el metodo mover ficha
	 * se invoca para casilla a y casilla b
	 */
	public void moverFicha(Casilla casillaA, Casilla casillaB){
		tablero.moverFicha(casillaA);
		tablero.moverFicha(casillaB);
		System.out.println("================================");
		this.imprimirBckTablero();
	}

}
