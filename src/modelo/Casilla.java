package modelo;

public class Casilla {
	
	private String atributo;
	
	private int posX;
	
	private int PosY;
	
	public Casilla() {
		// TODO Auto-generated constructor stub
	}

	public Casilla(String atributo, int posX, int posY) {
		super();
		this.atributo = atributo;
		this.posX = posX;
		PosY = posY;
	}

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return PosY;
	}

	public void setPosY(int posY) {
		PosY = posY;
	}
	
	public boolean buscarAtributo(String unAtributo){
		return atributo.equalsIgnoreCase(unAtributo);
	}
	
	
	
	
}
