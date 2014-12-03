import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Element {
	private boolean isPos;
	private String letter = null;
	private String Pos = null;
	private int length = 0;
	
	public Element(String s){
//		isPos = s.matches("n");
		Pattern p = Pattern.compile("n|pron|v|adj|adv|pre|conj|int");
		Matcher m = p.matcher(s);
		isPos = m.find();
		
		if(isPos){
			String[] a = s.split("\\(");
			Pos = a[0];
			length = Integer.parseInt(a[1].replaceAll("\\)", ""));
		} else {
			letter = s;
		}
	}
	
	public boolean isPos(){
		return isPos;
	}
	
	public String getLetter(){
		if(isPos){
			return null;
		}else{
			return letter;
		}
	}
	
	public String getPos(){
		if(isPos){
			return Pos;
		}else{
			return null;
		}
	}
	
	public int getLength(){
		if(isPos){
			return length;
		}else{
			return 0;
		}
	}

}
