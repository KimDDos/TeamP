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
	
	
}
