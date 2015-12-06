import java.util.Arrays;

public class IndexEngine {
	static IndexCard[]cards = new IndexCard[40];;
	static int maxIndexId=0;
	public IndexEngine(){
		
	}
	
	
	
	public static int getMaxIndexId() {
		return maxIndexId;
	}



	public static void setIndexId(int indexId) {
		maxIndexId = indexId;
	}



	public static int search_by_paper(Paper paper){
		int indexId=-1;
		for(int i=0;i<maxIndexId;i++){
			if(cards[i].getPaper().equals(paper)){
				indexId = i;
				break;
			}
		}
		return indexId;
		//Arrays.sort(cards);
		//return Arrays.binarySearch(cards,paper);
		
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
