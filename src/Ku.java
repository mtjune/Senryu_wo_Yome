import java.util.Random;



public class Ku {

	private String KU;
	private Templates templates;
	private Template template;
	private MDictionary mdictionary;
	
	
	public Ku(Morpheme[] dic, String filename_template){

		mdictionary = new MDictionary(dic);
		templates = new Templates(filename_template);
		
		// デバッグ
//		
//		for(int i = 0; i < templates.getLength(); i++){
//			Template template = templates.index(i);
//			String str = "";
//			
//			for(int j = 0; j < template.getElementLength(); j++){
//				Element element = template.getElement(j);
//				if(element.isPos()){
//					str += element.getPos();
//					str += String.valueOf(element.getLength());
//				}else{
//					str += element.getLetter();
//				}
//			}
//			System.out.println(str);
//			
//		}
//		
			// デバッグ
		
		
	}
	
	
	public void selectTemplate(){
		Templates sieved_templates = mdictionary.sieveTemplates(templates);
//		System.out.println(sieved_templates.getLength());
		
		if(sieved_templates.getLength() == 0){
			System.err.println("合致するテンプレートがない");
		}
		
		Random random = new Random();
		int ind = random.nextInt(sieved_templates.getLength());
		template = sieved_templates.index(ind);
	}
	
	public void createKU(){
		
		KU = "";
		
		for(int i = 0; i < template.getElementLength(); i++){
			Element element = template.getElement(i);
			if(element.isPos()){
				Morpheme mostDic = new Morpheme("", "", 0, 0.0);
				int maskindex = -1;
				for(int j = 0; j < mdictionary.getLength(); j++){
					Morpheme morpheme = mdictionary.getMorpheme(j);
					boolean flag1 = element.getPos().equalsIgnoreCase(morpheme.getPos()) && element.getLength() == morpheme.getLength();
					boolean flag2 = mostDic.getWeight() < morpheme.getWeight();
					if(flag1 && flag2){
						mostDic = morpheme;
						maskindex = j;
					}
				}
				if(maskindex >= 0){
					mdictionary.maskMorpheme(maskindex);
				}
				
				KU += mostDic.getPhrase();
				
			}else{
				KU += element.getLetter();
			}
		}
		
		
	}
	
	public String getKU(){
		return KU;
	}
	
}
