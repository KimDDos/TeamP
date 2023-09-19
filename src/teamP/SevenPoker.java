package teamP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SevenPoker {
	// 멤버변수
	PlayerBanker player = new PlayerBanker();
	PlayerBanker playerOpen = new PlayerBanker();
	PlayerBanker comSecrect = new PlayerBanker();
	PlayerBanker comOpen = new PlayerBanker();
	private CardDeck cd = new CardDeck();
	Scanner scan = new Scanner(System.in);
	TexasHoldem th = new TexasHoldem();
	int menu;
	
	public void clear() {
		player.getCl().clear();
		playerOpen.getCl().clear();
		comSecrect.getCl().clear();
		comOpen.getCl().clear();
	}
	
	// 게임이 흘러가게 만드는 메서드
	public void sevenPokerStart(Scanner sc) {
		ArrayList<Integer> bl = new ArrayList<Integer>();
		ArrayList<Integer> pl = new ArrayList<Integer>();
		clear();
		menu=-1;
		do {
			
			rulePrint(sc);
			if(menu!=0) {
				firstCardAdd();
				dropCard(sc);
				openCard(sc);
				cardView();
			}
			if(menu!=0) {
				openCardAdd();
				cardView();
			}
			userDeal(sc);
			if(menu!=0) {
				openCardAdd();
				cardView();
			}
			userDeal(sc);
			if(menu!=0) {
				openCardAdd();
				cardView();
			}
			userDeal(sc);
			if(menu!=0) { 
				secretCardAdd();
				endCardView();
			}
			System.out.println("<<Com>>");
			bl = combine(comSecrect.getCl(),comOpen.getCl());
			System.out.println("<<Player>>");
			pl = combine(player.getCl(),playerOpen.getCl());
			match2(pl,bl);
			System.out.println("SevenPoker를 끝내려면 0, 계속하려면 1을 입력해주세요.");
			menu = sc.nextInt();
		} while(menu!=0);
		System.out.println("게임을 종료합니다.");
	}
	
	public ArrayList<Integer> combine(ArrayList<Card> pb, ArrayList<Card> comm) {
		ArrayList<Card> total = new ArrayList<Card>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i<pb.size(); i++) {
			total.add(pb.get(i));
		}
		for(int j = 0; j<comm.size(); j++) {
			total.add(comm.get(j));
		}
		list = match(total);
		return list;
	}
	
	public void rulePrint(Scanner sc) {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("                            ========Seven Poker Game rule========");      
        System.out.println("     1. 플레이어들은 각각 4장의 카드를 받습니다. (한 번 사용된 카드는 버려집니다.)");      
        System.out.println("     2. 모든 플레이어들은 받은 4장의 카드중에 한장의 카드는 버리고, 한장의 카드는 다른 플레이어에게 오픈합니다.");
        System.out.println("     3. 카드 오픈후 오픈 카드들 중 제일 상위의 카드를 오픈한 플레이어가 선이며, 시계방향순으로 추가 오픈카드를 받습니다.");
        System.out.println("     4. 플레이어들은 오픈카드 수령할 때마다 Deal과 Fold 여부를 정합니다. (Deal : 오픈 카드 한장 받기 | Fold : 더이상 아무 행동도 할 수 없습니다.)");
        System.out.println("     5. 새로운 오픈 카드를 수령할 때마다 그 라운드의 선은 매번 바뀝니다.");
        System.out.println("     6. 각 플레이어가 7번째로 받는 마지막 카드는 오픈되지 않고 분배됩니다. ");
        System.out.println("     7. 모든 카드 수령후 전 플레이어의 카드는 오픈되며, 오픈된 손패들중 제일 높은 등급의 카드 배분을 보유한 플레이어가 승리합니다.");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println("게임을 진행하려면 1, 종료하려면 0을 입력해주세요.");
        this.menu = sc.nextInt();
	}
	
	public void ComDropCard() {
		int ran=(int)(Math.random()*comSecrect.getCl().size());
		comSecrect.getCl().remove(ran);
	}
	
	public void ComOpenCard() {
		int ran=(int)(Math.random()*comSecrect.getCl().size());
		comOpen.addCard(comSecrect.getCl().get(ran));
		comSecrect.getCl().remove(ran);
	}
	
	
	public void openCardAdd() {
		if(playerOpen.getCl().get(playerOpen.getCl().size()-1).getNum()==1) {
			if(comOpen.getCl().get(comOpen.getCl().size()-1).getNum()==1) {
				playerOpen.addCard(cd.pick());
				comOpen.addCard(cd.pick());
				return;
			}
			playerOpen.addCard(cd.pick());
			comOpen.addCard(cd.pick());
			return;
		}
		if(playerOpen.getCl().get(playerOpen.getCl().size()-1).getNum() > comOpen.getCl().get(comOpen.getCl().size()-1).getNum()) {
			playerOpen.addCard(cd.pick());
			comOpen.addCard(cd.pick());
		} else {
			playerOpen.addCard(cd.pick());
			comOpen.addCard(cd.pick());
		}
	}
	
	public void secretCardAdd() {
		if(playerOpen.getCl().get(playerOpen.getCl().size()-1).getNum()==1) {
			if(comOpen.getCl().get(comOpen.getCl().size()-1).getNum()==1) {
				player.addCard(cd.pick());
				comSecrect.addCard(cd.pick());
				return;
			}
			player.addCard(cd.pick());
			comSecrect.addCard(cd.pick());
			return;
		}
		if(playerOpen.getCl().get(playerOpen.getCl().size()-1).getNum() > comOpen.getCl().get(comOpen.getCl().size()-1).getNum()) {
			player.addCard(cd.pick());
			comSecrect.addCard(cd.pick());
		} else {
			player.addCard(cd.pick());
			comSecrect.addCard(cd.pick());
		}
	}
	
	public void firstCardAdd() {
		int i=0;
		while(i<4) {
			player.addCard(cd.pick());
			comSecrect.addCard(cd.pick());
			i++;
		}
	}
	
	public void dropCard(Scanner sc) {
		showMyDeck();
		ComDropCard();
		int select = 0;
		try {
			System.out.println("버리는 카드는 선택해주세요.");
			select = sc.nextInt();
			player.getCl().remove(select - 1);
			System.out.println("삭제완료~!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("숫자만 입력해주세요.");
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	
	
	
	public void openCard(Scanner sc) {
		showMyDeck();
		ComOpenCard();
		int select = 0;
		try {
			System.out.println("오픈하는 카드는 선택해주세요.");
			select = sc.nextInt();
			playerOpen.addCard(player.getCl().get(select - 1));
			player.getCl().remove(select - 1);
			System.out.println(select + "번 카드를 오픈합니다.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("숫자만 입력해주세요.");
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	
	public int userDeal(Scanner sc) {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		int menu=-1;
		try {
			System.out.println("Deal 하려면 1, Fold 하려면 0");
			menu=sc.nextInt();
			while(0>menu||menu>2) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				System.out.println("Deal 하려면 1, Fold 하려면 0");
				menu=sc.nextInt();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		return this.menu = menu;
	}
	
	public void cardView() {
		showComDeck();
		showMyDeck();
	}
	
	public void endCardView() {
		showComDeckEnd();
		showMyDeck();
	}
	
	public void showMyDeck() {
		CardPrint cp = new CardPrint();
		Collections.sort(player.getCl());
		System.out.println("User님의 손패 :");
		for(int i=0; i<player.getCl().size(); i++) {
			cp.deckAdd(player.getCl().get(i).getShape(), player.getCl().get(i).getNum());
		}
		for(int i=0; i<playerOpen.getCl().size(); i++) {
			cp.deckAdd(playerOpen.getCl().get(i).getShape(), playerOpen.getCl().get(i).getNum());
		}
		for(int i=0; i<player.getCl().size(); i++) {
				System.out.print("     ["+(i+1)+"]      ");
		}
		for(int i=0; i<playerOpen.getCl().size(); i++) {
			System.out.print("    [Open]    ");
	}
		System.out.println();
		cp.cardPrint(cp.printDeck());
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	
	public void showComDeck() {
		CardPrint cp = new CardPrint();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("com1님의 손패 :");
		cp.deckAdd('B', 0);
		cp.deckAdd('B', 0);
		for(int i=0; i<comOpen.getCl().size(); i++) {
			cp.deckAdd(comOpen.getCl().get(i).getShape(), comOpen.getCl().get(i).getNum());
		}
		System.out.println();
		cp.cardPrint(cp.printDeck());
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	
	public void showComDeckEnd() {
		CardPrint cp = new CardPrint();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("com1님의 손패 :");
		for(int i=0; i<comSecrect.getCl().size(); i++) {
			cp.deckAdd(comSecrect.getCl().get(i).getShape(), comSecrect.getCl().get(i).getNum());
		}
		for(int i=0; i<comOpen.getCl().size(); i++) {
			cp.deckAdd(comOpen.getCl().get(i).getShape(), comOpen.getCl().get(i).getNum());
		}
		System.out.println();
		cp.cardPrint(cp.printDeck());
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	
	public ArrayList<Integer> match(ArrayList<Card> total) {
		ArrayList<Card> five = new ArrayList<Card>();
		ArrayList<Card> flushD = new ArrayList<Card>();
		ArrayList<Card> stD = new ArrayList<Card>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		Collections.sort(total);
		int pair = 0;
		int stfc = 0;
		boolean fullhouse = false;
		boolean fourcard = false;
		boolean straight = false;
		boolean triple = false;
		boolean flush = false;
		boolean stf = false;
		for(int i = 0; i<total.size()-1; i++) {
			int sameSp = 0;
			if(total.get(i).getNum()-total.get(i+1).getNum()==0) {
				pair++;
				if(five.size()>0&&five.get(five.size()-1)==total.get(i)) {
					five.remove(five.size()-1);
				}
				five.add(total.get(i));
				five.add(total.get(i+1));
				if(i<5 && total.get(i+1).getNum()-total.get(i+2).getNum()==0) {
					triple = true;
					if(i<4 && total.get(i+2).getNum()-total.get(i+3).getNum()==0) {
						fourcard = true;
						triple = false;
					}
				}
			}
			if(triple && pair>=3) {
				fullhouse = true;
			}
			if(total.get(i).getNum()-total.get(i+1).getNum()==-1) {
				if(stD.size()>0&&stD.get(stD.size()-1)==total.get(i)) {
					stD.remove(stD.size()-1);
				}
				stD.add(total.get(i));
				stD.add(total.get(i+1));
			}else if(stD.size()<5&&total.get(i).getNum()-total.get(i+1).getNum()!=-1){
				stD.clear();
			}
			if(stD.size()>=5) {
				straight=true;
			}
			for(int j = 0; j<total.size(); j++) {
				if(i!=j&&total.get(i).getShape()==total.get(j).getShape()) {
					sameSp++;
					if(flushD.size()>0&&flushD.get(0)==total.get(i)) {
						flushD.remove(flushD.size()-1);
					}
					flushD.add(total.get(i));
					flushD.add(total.get(j));
				}
			}
			if(sameSp>=5) {
				flush=true;
			}else {
				flushD.clear();
			}
		}
		if(flushD.size()>=5) {
			for(int k = 0; k<flushD.size()-2; k++) {
				if(flushD.get(k).getNum()-flushD.get(k+1).getNum()==-1) {
					stfc++;
				}
				if(stfc>=5) {
					stf=true;
				}
			}
		}
		if(stf) {
			if(flushD.get(0).getNum()==1&&flushD.get(4).getNum()==5) {
				System.out.println("백 스트레이트 플러시 !");
				list.add(9);
				list.add(flushD.get(4).getNum());
				switch(flushD.get(4).getShape()) {
				case '♠' :
					list.add(4);
					break;
				case '◆' :
					list.add(3);
					break;
				case '♥' :
					list.add(2);
					break;
				case '♣' :
					list.add(1);
					break;
					default :
						list.add(0);
				}
				return list;
			}else{
				System.out.println("스트레이트 플러시!");
				list.add(8);
				list.add(flushD.get(flushD.size()-1).getNum());
				switch(flushD.get(4).getShape()) {
				case '♠' :
					list.add(4);
					break;
				case '◆' :
					list.add(3);
					break;
				case '♥' :
					list.add(2);
					break;
				case '♣' :
					list.add(1);
					break;
					default :
						list.add(0);
				}
				return list;
			}
		}else if(fourcard) {
			for(int i = 0; i<five.size()-3; i++) {
				if(five.get(i).getNum()==five.get(i+1).getNum()
						&&five.get(i+1).getNum()==five.get(i+2).getNum()
						&&five.get(i+2).getNum()==five.get(i+3).getNum()) {
					System.out.println(five.get(i).numPrint()+" 포카드");
					list.add(8);
					list.add(five.get(i).getNum());
					return list;
				}
			}
		}else if(fullhouse) {
			list.add(6);
			for(int i = 0; i<five.size()-3; i++) {
				if(five.get(i).getNum()==five.get(i+1).getNum()
						&&five.get(i+1).getNum()==five.get(i+2).getNum()) {
					System.out.print(five.get(i).numPrint()+" ");
					list.add(five.get(i).getNum());
					five.remove(i);
					five.remove(i+1);
					five.remove(i+2);
					System.out.println(five.get(five.size()-1).numPrint()+" ");
					list.add(five.get(five.size()-1).getNum());
					
				}
			}
			System.out.println("풀하우스");
			return list;
		}else if(flush) {
			System.out.println(flushD.get(flushD.size()-1)+" 플러시");
			list.add(5);
			list.add(flushD.get(flushD.size()-1).getNum());
			switch(flushD.get(flushD.size()-1).getShape()) {
			case '♠' :
				list.add(4);
				break;
			case '◆' :
				list.add(3);
				break;
			case '♥' :
				list.add(2);
				break;
			case '♣' :
				list.add(1);
				break;
				default :
					list.add(0);
			}
			return list;
		}else if(straight) {
				System.out.println(stD.get(stD.size()-1).numPrint()+" 스트레이트");
				list.add(4);
				list.add(stD.get(stD.size()-1).getNum());
				list.add(stD.get(stD.size()-2).getNum());
				list.add(stD.get(stD.size()-3).getNum());
				return list;
		}else if(triple) {
			list.add(3);
			for(int i = 0; i<five.size()-2; i++) {
				if(five.get(i).getNum()==five.get(i+1).getNum()
						&&five.get(i+1).getNum()==five.get(i+2).getNum()) {
					System.out.println(five.get(i).numPrint()+" 트리플");
					list.add(five.get(i).getNum());
					list.add(five.get(i+1).getNum());
					list.add(five.get(i+2).getNum());
					return list;
				}
			}
		}else if(pair>=2){
			System.out.println(""+five.get(five.size()-1).numPrint()+" "+five.get(five.size()-3).numPrint()+" 투페어");
			list.add(2);
			list.add(five.get(five.size()-1).getNum());
			list.add(five.get(five.size()-3).getNum());
			return list;
		}else if(pair==1) {
			System.out.println(five.get(five.size()-1).numPrint()+" 원페어");
			if(five.get(0).getNum()==1) {
				list.add(1);
			}else {
				list.add(0);
			}
			list.add(five.get(five.size()-1).getNum());
			return list;
		}else {
			if(total.get(0).getNum()==1) {
				System.out.println("A 탑");
				list.add(-1);
				return list;
			}else {
				System.out.println(total.get(total.size()-1).numPrint()+" 탑");
				list.add(-2);
				list.add(total.get(total.size()-1).getNum());
				return list;
			}
		}
		return list;
	}
	
	public void match2(ArrayList<Integer> pl, ArrayList<Integer> bl) {
		if(pl.get(0)>bl.get(0)) {
			System.out.println("Player 승");
		}else if(pl.get(0)<bl.get(0)) {
			System.out.println("com 승");
		}else if(pl.get(0)<0&&pl.get(0)==bl.get(0)) {
			System.out.println("무승부");
		}else {
			if(pl.get(1)>bl.get(1)) {
				System.out.println("Player 승");
			}else if(pl.get(1)<bl.get(1)) {
				System.out.println("com 승");
			}else if(pl.get(0)==0&&pl.get(1)==bl.get(1)){
				System.out.println("무승부");
			}else {
				if(pl.get(2)>bl.get(2)) {
					System.out.println("Player 승");
				}else if(pl.get(2)<bl.get(2)) {
					System.out.println("com 승");
				}else if((pl.get(0)==2||pl.get(0)==6)&&pl.get(2)==bl.get(2)){
					System.out.println("무승부");
				}else {
					if(pl.get(3)>bl.get(3)) {
						System.out.println("Player 승");
					}else if(pl.get(3)<bl.get(3)) {
						System.out.println("com 승");
					}else {
						System.out.println("무승부");
					}
				}	
			}	
		}
	}
}
