import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Templates {
	private ArrayList<Template> templates;
	
	public Templates(String filename){
		templates = new ArrayList<Template>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String s;
			while((s=br.readLine())!=null){
				templates.add(new Template(s));
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("テンプレートファイルを開けない");
		} catch (IOException e) {
			System.err.println("テンプレートファイルを読み出せない");
		}
	}
	
	public Templates(Template[] tem){
		templates = new ArrayList<Template>();
		for (Template template : tem) {
			templates.add(template);
		}
	}
	
	
	public Template index(int index){
		return templates.get(index);
	}
	
	public int getLength(){
		return templates.size();
	}
	
}
