package kereso.allapot;

import java.util.ArrayList;
import java.util.List;

public class Problema {

	public Allapot kezdo() {
		return new Allapot();
	}

	static List<Operator> OPERATOROK = new ArrayList<Operator>();
	static {
		for (int i=1; i<15; i++)
			for (int j=1; j<15; j++)
				if (i!=j)
					OPERATOROK.add( new Operator(i, j));
	}


	public List<Operator> operatorok() {
		return OPERATOROK;
	}

}