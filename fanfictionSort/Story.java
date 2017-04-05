package fanfictionSort;


public class Story implements Comparable<Story> {
	Double ratioHK;
	Integer hits;
	Integer kudos;
	String summary;
	String author;
	String title;
	String url;
	
	
	public Story(String t, String a, Integer h, Integer k, String u) {
		title = t;
		author = a;
		//summary = s;
		hits = h;
		kudos = k;
		if (h <= 0 || k <= 0) {
			ratioHK = -1.0;
		}else {
		ratioHK = (double) k/h*1.0;
		}
		url = u;
		
	}
	public double getratioHK () {
		return this.ratioHK;
		
	}
	public int compareTo(Story compareStory) {
		double compareRatio = (compareStory).getratioHK()*10000;
		// ascending order: return (int) (this.ratioHK*100 - compareRatio);
		return (int) (compareRatio - (this.ratioHK*10000));
		
	}

}
