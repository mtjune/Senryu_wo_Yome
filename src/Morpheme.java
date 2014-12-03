
public class Morpheme {
	private String phrase;
	private String Pos;
	private int length;
	private double weight;
	
	public Morpheme(String phr, String pos, int len, double wei){
		phrase = phr;
		Pos = pos;
		length = len;
		weight = wei;
	}
	
	public String getPhrase(){
		return phrase;
	}
	
	public String getPos(){
		return Pos;
	}
	
	public int getLength(){
		return length;
	}
	
	public double getWeight(){
		return weight;
	}
}
