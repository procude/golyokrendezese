package kereso.allapot;

public class Allapot {

	public char[] rekesz;

	public Allapot() {
		rekesz = " PFPFPFÜÜÜÜÜÜÜÜÜÜ".toCharArray();
	}

	public boolean cel() {
		String rekeszString = new String(rekesz);
		return rekeszString.contains("PPPFFF");
	}

	@Override
	public String toString() {
		return "("+rekesz[1]+","+rekesz[2]+","+rekesz[3]+","+rekesz[4]
				+","+rekesz[5]+","+rekesz[6]+","+rekesz[7]+","+rekesz[8]
				+","+rekesz[9]+","+rekesz[10]+","+rekesz[11]+","+rekesz[12]
				+","+rekesz[13]+","+rekesz[14]+","+rekesz[15]+","+rekesz[16]+")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		for(int i=1;i<17;i++){
			result = prime * result + rekesz[i];
		}

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return hashCode() == obj.hashCode();
	}

}