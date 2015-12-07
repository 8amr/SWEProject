import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.Normalizer.Form;
import java.util.Scanner;
import java.io.Serializable;
import javax.swing.JFileChooser;

public class Main{

	public static void main(String[] args) throws Exception{
		System.gc();
		load();
		new Gui();
		
	}
	
	
	public static void openChoser() throws IOException{
		JFileChooser j = new JFileChooser();
		j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		j.showOpenDialog(null);
		File s = j.getSelectedFile();
		String[] v = s.list();
		Paper[] p = new Paper[v.length];
		for(int i = 0; i<v.length;i++){
			
			p[i] = new Paper(new File(s.getAbsolutePath()+"\\"+v[i]));
			p[i].setNewName();
			IndexCard card1 = new IndexCard("this is my card 1 ","stuff",p[i].getTitle()); //testing only
			IndexCard card2 = new IndexCard("shit shit  ","something",p[i].getTitle());
			TabbedPane.model.addRow(new Object[]{i,p[i].getTitle(),p[i].getDownloadDate(),"Publisher"});
		
		}
		
		//for(int i=0;i<IndexEngine.search_by_paper(p[0]).length;i++)testing 
			//System.out.println(IndexEngine.search_by_paper(p[0])[i]+"!!");	//// prints the card with paper atp[0] 
		save();
	}
	
	
	public static void save() throws IOException{
		FileOutputStream out = new FileOutputStream("db.swe");
		ObjectOutputStream ObjOut = new ObjectOutputStream(out);
		IndexCard[] cardsArray = IndexEngine.getCards();
		System.out.println(cardsArray);
		ObjOut.writeObject(cardsArray);
		ObjOut.close();

		
	}
	
	public static void load() throws Exception{
		// read object from file
		FileInputStream input = new FileInputStream("db.swe");
		ObjectInputStream ObjIn = new ObjectInputStream(input);
		IndexCard[] cardsArray = (IndexCard[]) ObjIn.readObject();
		ObjIn.close();
		IndexEngine.setCards(cardsArray);
		for(int i=0;i<cardsArray.length;i++)
			System.out.println(cardsArray[i]);

	}

	
}




