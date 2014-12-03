import java.util.ArrayList;


public class MDictionary {
	private Morpheme[] Mdic;
	private boolean[] exMorpheme;
	
	public MDictionary(Morpheme[] idic){
		Mdic = idic;
		exMorpheme = new boolean[Mdic.length];
		for (int i = 0; i < exMorpheme.length; i++) {
			exMorpheme[i] = false;
		}
	}
	
	public Templates sieveTemplates(Templates temps){
		
		ArrayList<Template> tempcand = new ArrayList<Template>();
		for (int i = 0; i < temps.getLength(); i++) {
			
			Template temp = temps.index(i);
			boolean flag1 = true;
			
			for (int j = 0; j < temp.getElementLength(); j++) {
				Element el = temp.getElement(j);
				if(el.isPos()){
					String elpos = el.getPos();
					int ellength = el.getLength();
					boolean flag2 = false;
					for (int k = 0; k < Mdic.length; k++) {
						if(exMorpheme[k]){
							continue;
						}
//						System.out.println(Mdic[k].getPos() + ":" + elpos);
//						System.out.println(String.valueOf(Mdic[k].getLength()) + ":" + String.valueOf(ellength));
						if(Mdic[k].getPos().equals(elpos) && Mdic[k].getLength() == ellength){
							flag2 = true;
							maskMorpheme(k);
//							System.out.println("ここオッケー");
							break;
						}
					}
					
					if(!flag2){
						flag1 = false;
						break;
					}
					
				}
			}
			
			resetMask();
			
			if(flag1){
				tempcand.add(temp);
			}
			
		}
		
		Template[] rettemps = new Template[tempcand.size()];
		
		for (int i = 0; i < rettemps.length; i++) {
			rettemps[i] = tempcand.get(i);
		}
		
		return new Templates(rettemps);
		
		
	}
	
	public void maskMorpheme(int index){
		exMorpheme[index] = true;
	}
	
	public void resetMask(){
		for (int i = 0; i < exMorpheme.length; i++) {
			exMorpheme[i] = false;
		}
	}
	
	public int getLength(){
		return Mdic.length;
	}
	
	public Morpheme getMorpheme(int index){
		if(!exMorpheme[index]){
			return Mdic[index];
		} else {
			return new Morpheme("", "", 0, 0);
		}
	}
	
	
	
}
