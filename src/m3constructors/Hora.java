package m3constructors;

import java.io.*;

public class Hora {
	private int hora;
	private int minut;
	private int segon;

	// public Hora (int hora, int minut, int segon);

	public Hora(int hora, int minut, int segon) {
		this.hora = hora;
		this.minut = minut;
		this.segon = segon;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		if (hora < 0) {
			System.out.println("Error! Dada incorrecte.");
		} else {
			this.hora = hora;
		}
	}

	public int getMinut() {
		return minut;
	}

	public void setMinut(int minut) {
		if (minut < 0 || minut > 59) {
			System.out.println("Error! Dada incorrecte.");
		} else {
			this.minut = minut;
		}
	}

	public int getSegon() {
		return segon;
	}

	public void setSegon(int segon) {
		if (segon < 0 || segon > 59) {
			System.out.println("Error! Dada incorrecte.");
		} else {
			this.segon = segon;
		}
	}

	public void incrementa() {
		if (segon < 59) {
			this.segon = this.segon + 1;
		} else {
			this.segon = 0;
			this.minut = this.minut + 1;
			if (minut > 59) {
				this.minut = 0;
				this.hora = this.hora + 1;
			}
		}
		System.out.println("Incrementa = " + hora + ":" + minut + ":" + segon);
	}

	public void seguent(int segon) throws IOException {
		System.out.println("En quants segons vols incrementar l'hora?");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String dada = reader.readLine();
		int seg = Integer.parseInt(dada);

		this.segon = this.segon + seg;

		if (this.segon > 59) {
			this.segon = this.segon % seg;
			int min = this.segon / 60;
			this.minut = this.minut + min;
			if (this.minut > 59) {
				this.minut = this.minut % min;
				int hor = this.minut / 60;
				this.hora = this.hora + hor;
			}
		}
	}

	public void decrementa() {
		this.segon = this.segon - 1;
		if (this.segon == 0) {
			this.segon = 59;
			this.minut = this.minut - 1;
			if (this.minut == 0) {
				this.minut = 59;
				this.hora = this.hora - 1;
			}
		}
	}

	public void decrementa(int segon) throws IOException {
		System.out.println("En quants segons vols decrementar l'hora?");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String valor = reader.readLine();
		int menys = Integer.parseInt(valor);

		this.segon = this.segon - menys;

		if (this.segon < 0) {
			this.segon = this.segon % menys;
			int min2 = this.segon / 60;
			this.minut = this.minut - min2;
			if (this.minut < 0) {
				this.minut = this.minut % min2;
				int hor2 = this.minut / 60;
				this.hora = this.hora - hor2;
			}
		}
	}

	public static void main(String[] args) {
		Hora hora1 = new Hora(5, 45, 28);
		hora1.incrementa();
		// hora1.seguent();
		hora1.decrementa();
	}
}
