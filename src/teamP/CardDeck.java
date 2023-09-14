package teamP;

import java.util.ArrayList;

public class CardDeck {

	private ArrayList<Card> cd = new ArrayList<Card>();
	private int cnt = 0;  //pack 배열의 index 체크용
	
	//생성자 : 52장의 카드를 모두 생성
	public CardDeck() {
		newC();
	}

	public void newC() {
		char shape='♥';
		for(int i=1; i<=4; i++) {
			switch(i) {
			case 1: shape='♥'; break;
			case 2: shape='♣'; break;
			case 3: shape='♠'; break;
			case 4: shape='◆'; break;
			}
			for(int j=1; j<=13; j++) {  //숫자
				cd.add(new Card(shape, j));
			}
		}
	}
	
	
	//메서드
	/* - 카드를 섞는 기능
	 * - 카드를 한장 빼내는 기능
	 * - 카드 초기화 메서드
	 * - 카드 출력 => Card 클래스의 print 메서드 사용 
	 * */
	
	public ArrayList<Card> getCd() {
		return cd;
	}



	public void setCd(ArrayList<Card> cd) {
		this.cd = cd;
	}



	//카드 섞는 기능 shuffle
	public void shuffle() {
		for(int i=0; i<cd.size();i++) {
			int index = (int)(Math.random()*52)+0;
			Card tmp = cd.get(i); 
			cd.set(i, cd.get(index));
			cd.set(index, tmp);
		}
	}
	
	//한장 빼내는 기능 pick
	//리턴타입 Card (카드1장)
	public Card pick() {
		Card c = cd.get(cd.size()-1);
		cd.remove(cd.size()-1);
		return c; //52
	}
	
	//초기화 기능 : cnt만 마지막으로 다시 보내기
	public void init() {
		cd.clear();
		newC();
	}

}