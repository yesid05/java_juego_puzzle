package interfaz;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.Casilla;

public class PanelTablero extends JPanel {

	private PanelFicha[] panelFicha;

	private Main interfaz;

	public PanelTablero(Main unaInterfaz) {

		interfaz = unaInterfaz;

		panelFicha = new PanelFicha[9];
		setSize(300, 300);
		setLayout(new GridLayout(3, 3));
		/*
		 * for (int i = 0; i < panelFicha.length; i++) { add(panelFicha[i]); }
		 */

		/*
		 * for (int i = 0, x = 0, y = 0; i < panelFicha.length; i++, y++) { //
		 * ayuda a determinar el eje x y eje y de la casilla if (i == 3 || i ==
		 * 6) { x++; y = 0; }
		 * 
		 * }
		 */
	}

	public void llenarTablero() {

		// 1
		PanelFicha p1 = new PanelFicha(0, 0, this);
		panelFicha[0] = p1;
		// 2
		PanelFicha p2 = new PanelFicha(0, 1, this);
		panelFicha[1] = p2;
		// 3
		PanelFicha p3 = new PanelFicha(0, 2, this);
		panelFicha[2] = p3;
		// 4
		PanelFicha p4 = new PanelFicha(1, 0, this);
		panelFicha[3] = p4;
		// 5
		PanelFicha p5 = new PanelFicha(1, 1, this);
		panelFicha[4] = p5;
		// 6
		PanelFicha p6 = new PanelFicha(1, 2, this);
		panelFicha[5] = p6;
		// 7
		PanelFicha p7 = new PanelFicha(2, 0, this);
		panelFicha[6] = p7;
		// 8
		PanelFicha p8 = new PanelFicha(2, 1, this);
		panelFicha[7] = p8;
		// 9
		PanelFicha p9 = new PanelFicha(2, 2, this);
		panelFicha[8] = p9;

	}

	public void asignarAtributo(String unAtributo, int unaPoX, int unaPosY) {
		for (int i = 0; i < panelFicha.length; i++) {
			PanelFicha p = panelFicha[i];
			if (p.getPosX() == unaPoX && p.getPosY() == unaPosY) {
				if (unAtributo.equalsIgnoreCase("9")) {
					panelFicha[i].setAtributo("X");
				} else {
					panelFicha[i].setAtributo(unAtributo);
				}
			}
		}
	}

	public void actualizarFichas() {
		for (int i = 0; i < panelFicha.length; i++) {
			add(panelFicha[i]);
		}
	}

	public void movimiento(String atributo, int unaPosX, int unaPosY) {
		Casilla c = null;
		switch (unaPosX) {
			case 0:
				switch (unaPosY) {
					case 0:
						// selecciona la posicion 00
						// posibles movimientos 01 10
						c = interfaz.darHueco();
						// JOptionPane.showMessageDialog(this, "" + c.getPosX()
						// + " " + c.getPosY());
						if ((c.getPosX() == 0 && c.getPosY() == 1) || (c.getPosX() == 1 && c.getPosY() == 0)) {
							JOptionPane.showMessageDialog(this,
							        "Casilla A " + atributo + " " + c.getPosX() + " " + c.getPosY());
							JOptionPane.showMessageDialog(this, "Casilla B X " + unaPosX + " " + unaPosY);
							/**
							 * Contruir casilla A contruir casilla B casilla A
							 * ficha normal casilla B hueco
							 */
							Casilla casillaA = new Casilla(atributo, c.getPosX(), c.getPosY());
							Casilla casillaB = new Casilla("9", unaPosX, unaPosY);
							
							interfaz.moverFicha(casillaA, casillaB);
							interfaz.asignarAtributo();
							
						}
						break;
					case 1:
						// selecciona la opción 01
						// posibles movimientos 00 02 11
						c = interfaz.darHueco();
						// JOptionPane.showMessageDialog(this, "" + c.getPosX()
						// + " " + c.getPosY());
						if ((c.getPosX() == 0 && c.getPosY() == 0) || (c.getPosX() == 0 && c.getPosY() == 2)
						        || (c.getPosX() == 1 && c.getPosY() == 1)) {

							JOptionPane.showMessageDialog(this,
							        "Casilla A " + atributo + " " + c.getPosX() + " " + c.getPosY());
							JOptionPane.showMessageDialog(this, "Casilla B X " + unaPosX + " " + unaPosY);
							
							Casilla casillaA = new Casilla(atributo, c.getPosX(), c.getPosY());
							Casilla casillaB = new Casilla("9", unaPosX, unaPosY);
							
							interfaz.moverFicha(casillaA, casillaB);
							interfaz.asignarAtributo();

						}
						break;

					case 2:
						// selecciona la opcion 02
						// posibles movimientos 01 12
						c = interfaz.darHueco();
						// JOptionPane.showMessageDialog(this, "" + c.getPosX()
						// + " " + c.getPosY());
						if ((c.getPosX() == 0 && c.getPosY() == 1) || (c.getPosX() == 1 && c.getPosY() == 2)) {

							JOptionPane.showMessageDialog(this,
							        "Casilla A " + atributo + " " + c.getPosX() + " " + c.getPosY());
							JOptionPane.showMessageDialog(this, "Casilla B X " + unaPosX + " " + unaPosY);
							
							Casilla casillaA = new Casilla(atributo, c.getPosX(), c.getPosY());
							Casilla casillaB = new Casilla("9", unaPosX, unaPosY);
							
							interfaz.moverFicha(casillaA, casillaB);
							interfaz.asignarAtributo();

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
						c = interfaz.darHueco();
						// JOptionPane.showMessageDialog(this, "" + c.getPosX()
						// + " " + c.getPosY());
						if ((c.getPosX() == 0 && c.getPosY() == 0) || (c.getPosX() == 1 && c.getPosY() == 1)
						        || (c.getPosX() == 2 && c.getPosY() == 0)) {

							JOptionPane.showMessageDialog(this,
							        "Casilla A " + atributo + " " + c.getPosX() + " " + c.getPosY());
							JOptionPane.showMessageDialog(this, "Casilla B X " + unaPosX + " " + unaPosY);
							
							Casilla casillaA = new Casilla(atributo, c.getPosX(), c.getPosY());
							Casilla casillaB = new Casilla("9", unaPosX, unaPosY);
							
							interfaz.moverFicha(casillaA, casillaB);
							interfaz.asignarAtributo();

						}
						break;
					case 1:
						// selecciona la opcion 11
						// posibles movimientos 01 10 12 21
						c = interfaz.darHueco();
						// JOptionPane.showMessageDialog(this, "" + c.getPosX()
						// + " " + c.getPosY());
						if ((c.getPosX() == 0 && c.getPosY() == 1) || (c.getPosX() == 1 && c.getPosY() == 0)
						        || (c.getPosX() == 1 && c.getPosY() == 2) || (c.getPosX() == 2 && c.getPosY() == 1)) {

							JOptionPane.showMessageDialog(this,
							        "Casilla A " + atributo + " " + c.getPosX() + " " + c.getPosY());
							JOptionPane.showMessageDialog(this, "Casilla B X " + unaPosX + " " + unaPosY);
							
							Casilla casillaA = new Casilla(atributo, c.getPosX(), c.getPosY());
							Casilla casillaB = new Casilla("9", unaPosX, unaPosY);
							
							interfaz.moverFicha(casillaA, casillaB);
							interfaz.asignarAtributo();

						}
						break;
					case 2:
						// selecciona la opcion 12
						// posibles movimientos 02 11 22
						c = interfaz.darHueco();
						// JOptionPane.showMessageDialog(this, "" + c.getPosX()
						// + " " + c.getPosY());

						if ((c.getPosX() == 0 && c.getPosY() == 2) || (c.getPosX() == 1 && c.getPosY() == 1)
						        || (c.getPosX() == 2 && c.getPosY() == 2)) {

							JOptionPane.showMessageDialog(this,
							        "Casilla A " + atributo + " " + c.getPosX() + " " + c.getPosY());
							JOptionPane.showMessageDialog(this, "Casilla B X " + unaPosX + " " + unaPosY);
							
							Casilla casillaA = new Casilla(atributo, c.getPosX(), c.getPosY());
							Casilla casillaB = new Casilla("9", unaPosX, unaPosY);
							
							interfaz.moverFicha(casillaA, casillaB);
							interfaz.asignarAtributo();

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
						c = interfaz.darHueco();
						JOptionPane.showMessageDialog(this, "" + c.getPosX() + " " + c.getPosY());

						if ((c.getPosX() == 1 && c.getPosY() == 0) || (c.getPosX() == 2 && c.getPosY() == 1)) {
							JOptionPane.showMessageDialog(this,
							        "Casilla A " + atributo + " " + c.getPosX() + " " + c.getPosY());
							JOptionPane.showMessageDialog(this, "Casilla B X " + unaPosX + " " + unaPosY);
							
							Casilla casillaA = new Casilla(atributo, c.getPosX(), c.getPosY());
							Casilla casillaB = new Casilla("9", unaPosX, unaPosY);
							
							interfaz.moverFicha(casillaA, casillaB);
							interfaz.asignarAtributo();
						}
						break;

					case 1:
						// selecciona la opcion 21
						// posibles movimientos 11 20 22
						c = interfaz.darHueco();
						// JOptionPane.showMessageDialog(this, "" + c.getPosX()
						// + " " + c.getPosY());

						if ((c.getPosX() == 1 && c.getPosY() == 1) || (c.getPosX() == 2 && c.getPosY() == 0)
						        || (c.getPosX() == 2 && c.getPosY() == 2)) {
							JOptionPane.showMessageDialog(this,
							        "Casilla A " + atributo + " " + c.getPosX() + " " + c.getPosY());
							JOptionPane.showMessageDialog(this, "Casilla B X " + unaPosX + " " + unaPosY);
							
							Casilla casillaA = new Casilla(atributo, c.getPosX(), c.getPosY());
							Casilla casillaB = new Casilla("9", unaPosX, unaPosY);
							
							interfaz.moverFicha(casillaA, casillaB);
							interfaz.asignarAtributo();
						}
						break;
						
					case 2:
						// selecciona la opcion 22
						//posibles movimientos 12 21
						
						c = interfaz.darHueco();
						if((c.getPosX() == 1 && c.getPosY()==2) || (c.getPosX() == 2 && c.getPosY() == 1) ){
							
							Casilla casillaA = new Casilla(atributo, c.getPosX(), c.getPosY());
							Casilla casillaB = new Casilla("9", unaPosX, unaPosY);
							
							interfaz.moverFicha(casillaA, casillaB);
							interfaz.asignarAtributo();
						}
						
						break;

					default:
						break;
				}
				break;
			default:
				break;
		}
	}

}
