package MaxMax;

public class TestIf {

	public static void main(String[] args) {
		long loop = 10000000;
		int n=10;//1000;
		long a=6, b=2, c=6, d=8;
		double tif=0, teq=0;
		for (int j = 0; j < n; j++) {
			long start = System.currentTimeMillis();
			for (long i=1; i<=loop; i++){
				if (a>b) a=b;
			}
			long end = System.currentTimeMillis();
			long time =  end - start;
			tif = tif + time;
			/////////
			start = System.currentTimeMillis();
			for (long i=1; i<=loop; i++){
				a=b;
				b=c;
				//a=d;
			}
			end = System.currentTimeMillis();
			time =  end - start;
			teq = teq + time;
			/////////
			/////////
		}
		System.out.println("time if: " + tif/n +" ms");
		System.out.println("time equal: " + teq/n +" ms");
	}

}
/**
 * 	time if: 4758
	time equal: 1996
	time plus-plus: 2013
	time plus 1: 2000
	//////////
	time if: 46.127 ms
	time equal: 20.149 ms
		
	time if: 44.01 ms
	time equal: 20.278 ms
	
	time if: 48.633 ms
	time equal: 20.229 ms

*/
