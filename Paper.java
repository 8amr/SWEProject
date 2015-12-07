
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.JFileChooser;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;



public class Paper  implements Serializable{
	
	private File paper;
	private BasicFileAttributes bfa;
	private Date downloadDate;
	private String oldName;
	private String newName;
	private String title;	
	private String refrences;
	private String publishingYear;
	private int paperNumber;
	
	
	
	
	public Paper(File p) throws IOException{
		this.paper = new File(p.getAbsolutePath());
        Path h = Paths.get(paper.getAbsolutePath());
        this.bfa = Files.readAttributes(h, BasicFileAttributes.class);
        this.downloadDate = new Date( bfa.creationTime().to(TimeUnit.MILLISECONDS));
		this.oldName = paper.getName().substring(0, paper.getName().lastIndexOf("."));
		ArrayList<Paper> g = new ArrayList<Paper>();
		
		
		
		
		
		PDFTextStripper pdfStripper = null;
        PDDocument pdDoc = null;
        COSDocument cosDoc = null;
        
        try {
            PDFParser parser = new PDFParser(new FileInputStream(paper));
            parser.parse();
            cosDoc = parser.getDocument();
            pdfStripper = new PDFTextStripper();
            pdDoc = new PDDocument(cosDoc);
            pdfStripper.setStartPage(1);
           //// pdfStripper.setEndPage(pdfStripper.getEndPage());
            pdfStripper.setEndPage(1); //// use this instead 
            String parsedText = pdfStripper.getText(pdDoc).trim();
            Scanner textReader = new Scanner(parsedText);
            this.title = textReader.nextLine();
            pdDoc.close();
            cosDoc.close();
            
            //this.refrences = parsedText.substring(parsedText.lastIndexOf("References"));
            
            
            //int k = parsedText.lastIndexOf("References");
            //System.out.println(k);
            //System.out.println(title);
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        this.newName = downloadDate.toString()+" "+title;

		
		
		
		
		
	}
	//
	
	
	/*
	
	public static void main(String[] args) throws IOException{
		JFileChooser j = new JFileChooser();
		j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		j.showOpenDialog(null);
		File s = j.getSelectedFile();
		String[] v = s.list();
		Paper[] p = new Paper[v.length];
		for(int i = 0; i<v.length;i++){
			p[i] = new Paper(new File(s.getAbsolutePath()+"\\"+v[i]));
			System.out.println(p[i].getNewName());
		}
		
		
		}
	*/
		
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public String getRefrences() {
		return refrences;
	}

	public void setRefrences(String refrences) {
		this.refrences = refrences;
	}




	public Date getDownloadDate() {
		return downloadDate;
	}

	public void setDownloadDate(Date downloadDate) {
		this.downloadDate = downloadDate;
	}

	public File getPaper() {
		return paper;
	}

	public void setPaper(File paper) {
		this.paper = paper;
	}

	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BasicFileAttributes getBfa() {
		return bfa;
	}

	public void setBfa(BasicFileAttributes bfa) {
		this.bfa = bfa;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName() {
		this.newName = newName;
		this.newName =newName.replaceAll("[^\\p{L}\\p{Z}]","");//// regex to remove all special chars
		String path = paper.getPath().substring(0,paper.getPath().lastIndexOf('\\'));
		path = path+'\\'+newName+".pdf"; 
	    File newPaper = new File(path);
	    if(paper.renameTo(newPaper)) {
	    	System.out.println("renamed To:"+newName);
	      } 
	    else {
	         System.out.println("Error name:"+path);
	      }
	}
	





	

}



/*Paper ff = new Paper(new File("C:/Users/enssaf/Desktop/paper189.pdf"));
//System.out.println(ff.getRefrences());
System.out.println(ff.getDownloadDate().toString());
System.out.println(ff.getOldName());
System.out.println(ff.getTitle());
System.out.println(ff);
//System.out.println(ff.get);
//JFileChooser fc = new JFileChooser();
//fc.showOpenDialog(null) ;*/


//HtmlSubmitInput button = form.getInputByName("btnG");
//HtmlTextInput textField = form.getInputByName("q");
//textField.setValueAttribute("Change Impact Analysis for AspectJ Programs");
//HtmlPage page2 = button.click();
// String page = page1.asText();
//System.out.println(page);

//webClient.closeAllWindows();

//WebClient webClient = new WebClient(BrowserVersion.CHROME);

// Get the first page
//HtmlPage page1 = webClient.getPage("https://scholar.google.com/scholar?hl=en&q=Change+Impact+Analysis+for+AspectJ+Programs&btnG=&as_sdt=1%2C5&as_sdtp=");

// Get the form that we are dealing with and within that form, 
// find the submit button and the field that we want to change.

//HtmlForm form = page1.getFormByName("gs_nph");
//"C:/Users/enssaf/Desktop/paper189.pdf"	
		//this.newName = "";
		//System.out.println(oldName);



//Scanner s = new Scanner();
//j.addActionListener(new Paper(new File("C:/Users/enssaf/Desktop/paper189.pdf")));


//if (returnVal == JFileChooser.APPROVE_OPTION){
	
// }


//v[i].getPath()
		//Put The path for a .txt file
		/*PrintWriter p = new PrintWriter(new FileOutputStream("C:/Users/enssaf/Desktop/PapersDirectory.txt"));
		
		
		int returnVal = 
		p.println(s.getAbsolutePath());
		p.close();
		String[] v = s.list();
		for(int i = 0; i<v.length;i++){
			System.out.println(s.getPath()+"\\"+v[i]);
			
		
	    String page = page1.asText();*/


// System.out.println(page);

 //webClient.closeAllWindows();*/
	//WebClient webClient = new WebClient();
 //HtmlPage page = webClient.getPage("http://ieeexplore.ieee.org/xpl/articleDetails.jsp?arnumber=4658057&newsearch=true&queryText=Change%20Impact%20Analysis%20for%20AspectJ%20Programs");
 
 //HtmlForm citation = page.getFormByName("download_citations_form");
 //HtmlRadioButtonInput radioButton = (HtmlRadioButtonInput) page.getElementById("download-bibtex");
 //radioButton.setChecked(true);
// HtmlSubmitInput googleSearchSubmitButton = (HtmlSubmitInput) page.getElementById("submit-download-citations");
 //page=googleSearchSubmitButton.click();
// HtmlPage pp = googleSearchSubmitButton.click();
 //System.out.println( page.asText()+"\n");
 		//HtmlInput searchBox = page.getElementByName("q");
 //searchBox.setValueAttribute("htmlunit");

 // sometimes it's "btnK"
// page=googleSearchSubmitButton.click();

// HtmlDivision resultStatsDiv =
                         //page.getFirstByXPath("//div[@id='gs_ccl']");
// HtmlPage v = resultStatsDiv.getHtmlPageOrNull();
 

// System.out.println(page.asText()+"\n"); // About 309,000 results
 //webClient.closeAllWindows();

		
		//
