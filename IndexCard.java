import java.io.Serializable;

public class IndexCard extends IndexEngine implements Comparable{
	String text;
	String category;
	//Paper paper;
	//public transient Paper paper;
	public String PaperName ;
	int indexId;
	IndexCard(String text,String category,String paperName){
		this.text=text;
		this.PaperName = paperName;
		this.category = category;
		this.indexId = IndexEngine.getMaxIndexId();
		IndexEngine.maxIndexId++;
		IndexEngine.cards[indexId] =this;
	}
	
	
	public void edit_card(String newText){
		//// replace old text 
		this.text = newText;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPaper() {
		return PaperName;
	}

	public void setPaperName(String p) {
		this.PaperName = p;
	}

	public int getIndexId() {
		return indexId;
	}

	
	
	public String toString(){
		return PaperName+" :"+text+indexId;
	}


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		IndexCard c = (IndexCard)o;
		Integer obj1 = new Integer(this.indexId);
		Integer obj2 = new Integer(c.getIndexId());
		return obj1.compareTo(obj2);
	}
	
	
	
	
}

