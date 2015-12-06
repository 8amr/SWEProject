import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;

public class Main {

	public static void main(String[] args) throws IOException{
		JFileChooser j = new JFileChooser();
		j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		j.showOpenDialog(null);
		File s = j.getSelectedFile();
		String[] v = s.list();
		Paper[] p = new Paper[v.length];
		for(int i = 0; i<v.length;i++){
			p[i] = new Paper(new File(s.getAbsolutePath()+"\\"+v[i]));
			///System.out.println(p[i].getNewName());
			p[i].setNewName();
		}
		
		
	}
}
