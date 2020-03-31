package kereso.allapot;

public class Operator {

	public int i, j;

	public Operator(int i, int j) {
		this.i = i;
		this.j = j;
	}


	public boolean alkalmazhato(Allapot allapot) {
		char rekesz[] = allapot.rekesz;
		return i!=j && rekesz[i] != 'Ü' && rekesz[i+1] != 'Ü' && rekesz[j] == 'Ü' && rekesz[j+1] == 'Ü';
	}

	public Allapot alkalmaz(Allapot allapot) {
		Allapot uj = new Allapot();
		char a[] = allapot.rekesz;
		char b[] = uj.rekesz;

		for (int k = 1; k<17; k++) {
			if ( k==j )
				b[k] = a[i];
			else if ( k==j+1 )
				b[k] = a[i+1];
			else if ( k==i || k==i+1)
				b[k] = 'Ü';
			else
					b[k] = a[k];
		}
		return uj;
	}

	@Override
	public String toString() {
		return i+" --> "+j;
	}

}