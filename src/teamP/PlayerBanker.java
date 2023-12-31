package teamP;

import java.util.ArrayList;

public class PlayerBanker {
	private ArrayList<Card> cl = new ArrayList<Card>();
	
	public void addCard(Card c) {
		cl.add(c);
	}
	
	public ArrayList<Card> getCl() {
		return cl;
	}

	public void setCl(ArrayList<Card> cl) {
		this.cl = cl;
	}

	public PlayerBanker() {}

	public PlayerBanker(ArrayList<Card> cl, CardDeck cd) {
		this.cl = cl;
	}
	
	// 순번 정리 추가 필요
	private int orderNumber;
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
}
