package test;

import java.util.Random;

public class CardShuffle {
	public enum CardType{
		Club(1),Diamond(2),Spade(3),Heart(4);
		private int i;
		private CardType(int i){
			this.i = i;
		}
		public int getCardTypeId(){
			return i;
		}
		public CardType getCardType(int i){
			for(CardType c:CardType.values()){
				if(c.getCardTypeId()==i){
					return c;
				}
			}
			return null;
		}
		
	}
	
	private int cardsNumbers[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	
	public String[] prepareCardDeck(){
		String[] cards = new String[52];
		int counter = 0;
		for(CardType c:CardType.values()){
			for(int no : cardsNumbers){
				cards[counter]=no + c.name();
				counter ++;
			}
		}
		return cards;
	}
	
	public String[] shuffle(String[] cards){
		Random random = new Random(52);
		for(int i = 1 ; i <=52 ; i ++){
			int first = random.nextInt(52);
			int second = random.nextInt(52);
			String temp = cards[first];
			cards[first] =  cards[second];
			cards[second] = temp;
		}
		return cards;
	}
	
	public static void main(String[] args){
		CardShuffle cardShuffle = new CardShuffle();
		String[] cards = cardShuffle.prepareCardDeck();
		String[] shuffledCards = cardShuffle.shuffle(cards);
		for(int i = 0 ; i <52 ; i++){
			System.out.println(shuffledCards[i]);
		}
		
	}
}
