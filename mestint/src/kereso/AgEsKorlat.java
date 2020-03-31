package kereso;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import kereso.allapot.Allapot;
import kereso.allapot.Operator;
import kereso.allapot.Problema;

public class AgEsKorlat {

	static class Csucs {
		Allapot allapot;
		Csucs szulo;
		Operator eloallito;
		List<Operator> nemProbalt = new ArrayList<Operator>();

		public Csucs(Allapot allapot, Csucs szulo, Operator eloallito, Problema p) {
			this.allapot = allapot;
			this.szulo = szulo;
			this.eloallito = eloallito;
			for (Operator o: p.operatorok())
				if (o.alkalmazhato(allapot))
					this.nemProbalt.add(o);
		}
	}

	public List<Operator> megoldas(Csucs terminalis) {
		LinkedList<Operator> megoldas = new LinkedList<Operator>();
		for (Csucs cs=terminalis; cs.szulo != null; cs=cs.szulo)
			megoldas.addFirst(cs.eloallito);
		return megoldas;
	}


	public List<Operator> keres(Problema p, Integer korlat) {
		Csucs aktualis;
		int uthossz;
		List<Operator> legjobb = null;
		// 1.
		aktualis = new Csucs(p.kezdo(), null, null, p);
		uthossz = 1;

		// 2.
		if ( aktualis.allapot.cel() ) {
			return megoldas(aktualis);
		}
		while (true) {
			// 3.
			if ( (korlat==null || uthossz<korlat) && ! aktualis.nemProbalt.isEmpty() ) {
				Operator o = aktualis.nemProbalt.remove(0);
				Allapot uj = o.alkalmaz(aktualis.allapot);
				System.out.println();
				boolean voltMar = false;
				for (Csucs cs=aktualis; cs!=null; cs=cs.szulo)
					if ( cs.allapot.equals(uj) ) {
						voltMar = true;
						break;
					}

				if ( !voltMar ) {
					aktualis = new Csucs(uj, aktualis, o, p);
					uthossz++;
					// 2.
					if ( aktualis.allapot.cel() ) {
						legjobb = megoldas(aktualis);
						korlat = uthossz-1;
					}
				}
			} else {
				// 4.
				if ( aktualis.szulo != null ) {
					aktualis = aktualis.szulo;
					uthossz--;
				} else {
					return legjobb;
				}
			}
		}

	}

	public static void main(String[] args) {
		Problema p = new Problema();
		List<Operator> m = new AgEsKorlat().keres(p,5);
		if ( m!= null ) {
			Allapot a = p.kezdo();
			for (Operator o:m) {
				System.out.println(a);
				System.out.println(o);
				a = o.alkalmaz(a);
			}
			System.out.println(a);
		}
		else {
			System.out.println("Sikertelen keresés");
		}
	}


}