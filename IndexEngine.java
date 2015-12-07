import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.bcel.generic.InstructionTargeter;
import org.apache.commons.lang3.ArrayUtils;

public class IndexEngine implements Serializable{
	static IndexCard[]cards = new IndexCard[40];
	static int maxIndexId=0;
	public IndexEngine(){
		
	}
	
	
	
	public static int getMaxIndexId() {
		return maxIndexId;
	}



	public static void setIndexId(int indexId) {
		maxIndexId = indexId;
	}



	public static int[] search_by_paper(Paper paper){
		ArrayList<Integer> temp = new ArrayList<Integer>();

		for(int i=0;i<maxIndexId;i++){
			if(cards[i].getPaper().equals(paper)){
				temp.add(i);
			}
		}

		int[] rersult = ArrayUtils.toPrimitive(temp.toArray(new Integer[temp.size()]));
		return rersult;
		
	}
	
	public static int[] search_by_text(String text){
		ArrayList<Integer> temp = new ArrayList<Integer>();

		for(int i=0;i<maxIndexId;i++){
			if(cards[i].getText().equals(text)){
				temp.add(i);
			}
		}

		int[] rersult = ArrayUtils.toPrimitive(temp.toArray(new Integer[temp.size()]));
		return rersult;
		
	}
	
	public static int[] search_by_category(String  category){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i=0;i<maxIndexId;i++){
			if(cards[i].getCategory().equals(category)){
				temp.add(i);
			}
		}

		int[] rersult = ArrayUtils.toPrimitive(temp.toArray(new Integer[temp.size()]));
		return rersult;
		
	}
	
	public static IndexCard[] getCards() {
		return cards;
	}



	public static void setCards(IndexCard[] cards) {
		IndexEngine.cards = cards;
	}



	public static IndexCard getCard(int indexId){
		return cards[indexId];
	}

}
