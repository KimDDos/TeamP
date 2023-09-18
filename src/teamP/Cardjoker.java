package teamP;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

//도둑잡기
//처음 카드 나눠주고 중복 된 카드 버리기
//카드 하나 가져간 후 중복카드 버리기
//반복
//먼저 다 버리면 승리
public class Cardjoker {
	ArrayList<Card> c = new ArrayList<>();
	CardDeck cd = new CardDeck();
	private PlayerBanker com = new PlayerBanker(); //컴퓨터
	private PlayerBanker user = new PlayerBanker(); //유저
	
	
	public Cardjoker() {}
	public void Cardjokerstart(Scanner scan) {
		int menu=0;
		rule(scan);
		do {
			drow();
			delcardcom();
			delcarduser();
			showComDeck();
			showMyDeck();
			do {
				pick(scan);
				delcardcom();
				delcarduser();
				showComDeck();
				showMyDeck();
			} while(!isSize());
			System.out.println("게임을 종료하시려면 1, 계속하려면 0을 입력해주세요.");
			menu = scan.nextInt();
		} while(menu != 1);
		System.out.println("프로그램 종료");
	}
	
	
	public boolean isSize() {
		if(com.getCl().size()==0 || user.getCl().size()==0) {
			return true;
		}
		return false;
	}
	
	public void rule (Scanner scan) {
		int i = 0;
		do {
			System.out.println("--도둑잡기--");
			System.out.println("인원 수에 맞게 카드를 나누어 가진다.");
			System.out.println("각자 자신의 패에서 같은 숫자나 알파벳을 가진 카드를 한 쌍씩 버린다.(모양은 상관X)");
			System.out.println("더 이상 자신의 패에 같은 쌍의 카드가 남아 있지 않을 때까지 반복한다.");
			System.out.println("상대의 카드 한 장을 가져와서 쌍이 맞는 카드가 있으면 버린다.");
			System.out.println("먼저 카드를 다 내려놓은 사람은 승리! 마지막으로 조커카드를 가지고 있는 사람이 패배!");
			System.out.println();
			System.out.println("게임을 시작하려면 1을 눌러주세요.");
			i=scan.nextInt();
		} while (i !=1);	
			return;
	}

	
	public void drow() {
		for(int i = 1; i<=26; i++) {
			Card cc = cd.pick();
			com.addCard(cc);
		}
		
		for(int i = 1; i<=26; i++) {
			Card cc = cd.pick();
			user.addCard(cc);
		}
		int ran=(int)(Math.random()*2)+1;
		Card cc = new Card('J',0);
		if(ran==1) user.addCard(cc);
		if(ran==2) com.addCard(cc);
		
		cd.newC();
		
		Collections.sort(com.getCl());
		Collections.sort(user.getCl());
		
//		System.out.println("컴퓨터 카드"+"\n"+com.getCl());
//		System.out.println("유저 카드"+"\n"+user.getCl());
		System.out.println("제일 처음 받은 유저카드 : ");
		showMyDeck();
	
	

	}
	
	
	public void delcardcom() {
		int i =com.getCl().size()-1;	
		while(i>0) {
			if(com.getCl().get(i).getNum() == com.getCl().get(i-1).getNum()) {
				com.getCl().remove(i);
				com.getCl().remove(i-1);	
				i=i-2;
			}else {
				i--;
			}
		  }
		} 
		//System.out.println(com.getCl());
		
	public void delcarduser() {
		
		int j =user.getCl().size()-1;	
		while(j>0) {
			if(user.getCl().get(j).getNum() == user.getCl().get(j-1).getNum()) {
				user.getCl().remove(j);
				user.getCl().remove(j-1);	
				j=j-2;
			}else {
				j--;
			}
		} 
		//System.out.println("--중복 숫자 제거--"+"\n"+user.getCl());
	}
	
	public void pick(Scanner scan) {
		System.out.println("Com의 손패에서 가져올 카드번호 1~"+ com.getCl().size() +"를 입력해주세요!");
		int choice = scan.nextInt();
		while(0>choice || choice > com.getCl().size()) {
			System.out.println("잘못된 입력입니다.");
			choice = scan.nextInt();
			if(0<choice || choice < com.getCl().size()) break;
		}
		user.addCard(com.getCl().get(choice-1));
		com.getCl().remove(choice-1);
		int ran = (int)(Math.random()*(user.getCl().size()-2));
		com.addCard(user.getCl().get(ran));
		user.getCl().remove(ran);
		System.out.println("com이 내 덱에서 카드를 뽑아갔습니다.");
		Collections.sort(com.getCl());
		Collections.sort(user.getCl());
	}
	
	
	

	
	
	
	public void showMyDeck() {
		CardPrint cp = new CardPrint();
		if(user.getCl().size() == 0) {
			System.out.println("플레이어가 승리했습니다!!~!!! 축축축");
			return;
		}
		for (int i = 0; i < user.getCl().size(); i++) {
			cp.deckAdd(user.getCl().get(i).getShape(), user.getCl().get(i).getNum());
		}
		for (int i = 0; i < user.getCl().size(); i++) {
			if (i >= 10) {
				System.out.print("    [" + (i + 1) + "]     ");
			} else {
				System.out.print("     [" + (i + 1) + "]      ");
			}
		}
		System.out.println();
		cp.cardPrint(cp.printDeck());
	}
	
	public void showComDeck() {
		CardPrint cp = new CardPrint();
		if(com.getCl().size() == 0) {
			System.out.println("Com이 승리했습니다!!~!!! 축축축");
			return;
		}
		if(com.getCl().size() == 1) {
			cp.oneCardPrint();
			return;
		}
		for (int i = 0; i < com.getCl().size(); i++) {
			cp.deckAdd('B', 0);
		}
		for (int i = 0; i < com.getCl().size(); i++) {
			if (i >= 10) {
				System.out.print("    [" + (i + 1) + "]     ");
			} else {
				System.out.print("     [" + (i + 1) + "]      ");
			}
		}
		System.out.println();
		cp.cardPrint(cp.printDeck());
	}
	
}
