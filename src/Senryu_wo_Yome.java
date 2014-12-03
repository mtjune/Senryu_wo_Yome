import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Senryu_wo_Yome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Morpheme[] mor;
		//川柳を作成する日付を渡してMorpheme配列を作成
		mor = setMorpheme("2012/07/20");
		//Morpheme出力結果
		
		for(int i=0; i<mor.length; i++){
			System.out.println("---Morphemeデータ----");
			System.out.println(mor[i].getPhrase());
			System.out.println(mor[i].getPos());
			System.out.println("長さ:" + String.valueOf(mor[i].getLength()));
			System.out.println("重み:" + String.valueOf(mor[i].getWeight()));
			System.out.println("------------\n");
		}
		
		Ku ku = new Ku(mor, "\\\\fs01\\s1413137\\Documents\\Senryu_wo_Yome\\template_sample_u.csv");
		
		ku.selectTemplate();
		ku.createKU();
		String senryu = ku.getKU();
		
		System.out.println(senryu);
		
	}
	public static Morpheme[] setMorpheme(String date){
		date = dateToname(date);
		String dir = System.getProperty("user.dir");
		ArrayList<String> array = new ArrayList<String>();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(dir + "/Data/" + date + ".txt");
			br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				array.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Morpheme[] mor = new Morpheme[array.size()];
		for(int i=0; i<array.size(); i++){
			String getWord = array.get(i);
			String phr = getWord.split(",")[0];
			String po = getWord.split(",")[1];
			Double wei = Double.valueOf(getWord.split(",")[3]);
			Integer len = Integer.valueOf(getWord.split(",")[2]);			
			mor[i] = new Morpheme(phr,po,len,wei);
		}
		return mor;
	}
	//ファイル名に対応した日付に変更
	public static String dateToname(String date){
		date = date.replace("年", "-");
		date = date.replace("月", "-");
		date = date.replace("日", "-");
		date = date.replace("年", "-");
		date = date.replace("/", "-");
		date = date.replace("/", "-");
		date = date.replace("/", "-");
		date = date.replace("/", "-");
		return date;
	}

}
