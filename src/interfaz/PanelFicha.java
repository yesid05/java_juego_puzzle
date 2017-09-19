package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelFicha extends JPanel implements ActionListener {
	
	private String atributo = "";

	private int posX;

	private int posY;

	private PanelTablero panelTablero;

	private JButton btnAtributo;

	public PanelFicha(String unAtributo, int unaPosX, int unaPoosY) {
		atributo = unAtributo;
		posX = unaPosX;
		posY = unaPoosY;
		initComponentes();
	}

	public PanelFicha(int unaPosX, int unaPoosY, PanelTablero pt) {
		posX = unaPosX;
		posY = unaPoosY;
		panelTablero = pt;
		initComponentes();
	}

	public void initComponentes() {
		setLayout(new GridLayout(1, 1));
		setBorder(BorderFactory.createLineBorder(Color.red));
		btnAtributo = new JButton(atributo);
		btnAtributo.addActionListener(this);
		btnAtributo.setBackground(Color.white);
		add(btnAtributo);
	}

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
		btnAtributo.setText(atributo);

	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// JOptionPane.showMessageDialog(this, ""+posX+" "+posY);
		panelTablero.movimiento(atributo, posX, posY);
	}

}
