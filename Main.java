import java.io.File;
import java.io.IOException;
import java.text.Normalizer.Form;

import javax.swing.JFileChooser;

public class Main {

	public static void main(String[] args) throws IOException{
		System.gc();
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
			//IndexCard card1 = new IndexCard("this is my card 1 ","stuff",p[i]); testing only
			//IndexCard card2 = new IndexCard("shit shit  ","stuff",p[i]);
			TabbedPane.model.addRow(new Object[]{i,p[i].getTitle(),p[i].getDownloadDate(),"Publisher"});
		
		}
		
		//for(int i=0;i<IndexEngine.search_by_paper(p[0]).length;i++)testing 
			//System.out.println(IndexEngine.search_by_paper(p[0])[i]+"!!");	//// prints the card with paper atp[0] 
	}

	
}




