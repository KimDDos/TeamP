package teamP;

import java.util.Collections;
import java.util.Scanner;

public class SevenFoker {
	// 멤버변수
	PlayerBanker player = new PlayerBanker();
	PlayerBanker playerOpen = new PlayerBanker();
	PlayerBanker com = new PlayerBanker();
	PlayerBanker comOpen = new PlayerBanker();
	PlayerBanker publicOpen = new PlayerBanker();
	private CardDeck cd = new CardDeck();
	Scanner scan = new Scanner(System.in);
	
	// 게임이 흘러가게 만드는 메서드
	public void sevenFokerStart(Scanner sc) {
		firstCardAdd();
		dropCard(sc);
		openCard(sc);
	}
	
	public void firstCardAdd() {
		int i=0;
		while(i<4) {
			player.addCard(cd.pick());
			com.addCard(cd.pick());
			i++;
		}
	}
	
	public void dropCard(Scanner sc) {
		showMyDeck();
		try {
			System.out.println("버리는 카드는 선택해주세요.");
			int select = sc.nextInt();
			player.getCl().remove(select-1);
			System.out.println("삭제완료~!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("숫자만 입력해주세요.");
		}
	}
	
	public void openCard(Scanner sc) {
		showMyDeck();
		System.out.println("오픈하는 카드는 선택해주세요.");
		int select = sc.nextInt();
		playerOpen.addCard(player.getCl().get(select - 1));
		player.getCl().remove(select-1);
		System.out.println(select+"번 카드를 오픈합니다.");
	}
	
	public void cardAdd() {
		playerOpen.addCard(cd.pick());
		comOpen.addCard(cd.pick());
	}
	
	public void showMyDeck() {
		CardPrint cp = new CardPrint();
		Collections.sort(player.getCl());
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
			System.out.print("   [Open]    ");
	}
		System.out.println();
		cp.cardPrint(cp.printDeck());
	}
	
	// 게임 방법
	// 52장을 섞은 후 플레이어는 4장의 카드를 받음
	// 4장 중 카드 하나를 버림 (버리는 카드는 오픈하지 않음)
	// 가지고 있는 카드 3장중 하나 오픈 -> 이때 가장 높은 패를 가진 사람이 선, 시계방향으로 오픈카드 하나씩
	// 오픈되어 있는 2장의 카드의 족보를 비교, 선부터 시계방향
	// 오픈카드 하나 받기 
	// 오픈되어 있는 3장의 카드의 족보를 비교, 선부터 시계방향
	// 오픈카드 하나 받기 
	// 오픈되어 있는 4장의 카드의 족보를 비교, 선부터 시계방향
	// 히든카드 하나 받기 
	// 카드 전체 오픈
	
	
	
	
	
}
