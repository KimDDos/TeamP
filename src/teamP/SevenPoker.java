package teamP;

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
	int menu;
	
	// 게임이 흘러가게 만드는 메서드
	public void sevenPokerStart(Scanner sc) {
		menu=-1;
		do {
			firstCardAdd();
			dropCard(sc);
			openCard(sc);
			cardView();
			if(menu!=0) {
				openCardAdd();
				cardView();
			}
			userDeal(sc);
			if(menu!=0) {
				openCardAdd();
				cardView();
			}
			if(menu!=0) {
				openCardAdd();
				cardView();
			}
			if(menu!=0) { 
				secretCardAdd();
				cardView();
			}
			System.out.println("SevenPoker를 끝내려면 0, 계속하려면 1을 입력해주세요.");
			menu = sc.nextInt();
		} while(menu!=0);
		System.out.println("게임을 종료합니다.");
	}
	
	public void rulePrint() {
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
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
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
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	
	public int userDeal(Scanner sc) {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
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
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		return this.menu = menu;
	}
	
	public void cardView() {
		showComDeck();
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
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	
	public void showComDeck() {
		CardPrint cp = new CardPrint();
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("com1님의 손패 :");
		cp.deckAdd('B', 0);
		cp.deckAdd('B', 0);
		for(int i=0; i<comOpen.getCl().size(); i++) {
			cp.deckAdd(comOpen.getCl().get(i).getShape(), comOpen.getCl().get(i).getNum());
		}
		System.out.println();
		cp.cardPrint(cp.printDeck());
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
	
	// 스페이드 > 다이아 > 하트 > 클로버
	public boolean isShape(PlayerBanker name1,PlayerBanker name2) {
		char ch = name1.getCl().get(name1.getCl().size()-1).getShape();
		switch (ch) {
		case '♠': 
			
		case '◆':
		case '♥':
		case '♣':
		default:
			throw new IllegalArgumentException("Unexpected value: " + ch);
		}
	}
	
	
	
	
}
