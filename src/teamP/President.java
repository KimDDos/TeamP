package teamP;

import java.util.Scanner;

public class President {  // 대부호 게임
	private PlayerBanker player = new PlayerBanker();
	private PlayerBanker comm = new PlayerBanker();
	private PlayerBanker comm2 = new PlayerBanker();
	private PlayerBanker comm3 = new PlayerBanker();
	private PlayerBanker comm4 = new PlayerBanker();
	private PlayerBanker comm5 = new PlayerBanker();
	private PlayerBanker comm6 = new PlayerBanker();
	private CardDeck cd = new CardDeck();
	private int members;
	private int count;
	private int rank;
	
	public President() {}
	
	public void presidentStart(Scanner scan) {
		gameSetting(scan);
		presidentRulePrint(scan);
		givingHandouts(this.members);
	}
	
	public void gameSetting(Scanner scan) {
		int menu = 0;
		do {
		System.out.println("게임 인원수를 지정해주세요. (2~7인)");
		menu = scan.nextInt();
		switch(menu) {
		case 2: 
			System.out.println(menu+"인이서 게임을 진행합니다.");
			break;
		case 3: 
			System.out.println(menu+"인이서 게임을 진행합니다.");
			break;
		case 4: 
			System.out.println(menu+"인이서 게임을 진행합니다.");
			break;
		case 5: 
			System.out.println(menu+"인이서 게임을 진행합니다.");
			break;
		case 6: 
			System.out.println(menu+"인이서 게임을 진행합니다.");
			break;
		case 7: 
			System.out.println(menu+"인이서 게임을 진행합니다.");
			break;
		default : System.out.println("2~7 범위에 해당하는 인원수를 입력해주세요!");
		}
		} while(!(1<menu || menu <8)); {
			System.out.println("인원수는 "+menu+"명으로 시작합니다.");
			this.members=menu;
		}
	}
	
	public void presidentRulePrint(Scanner scan) {
		int menu = 0;
		do {
		System.out.println("첫번째 게임 룰 설명");
		System.out.println("1. 게임은 다이아 3을 가진 플레이어부터 Strat ");
		System.out.println("2. Start를 제외한 다른 플레이어들은 내놓은 카드보다 강한 카드를 무조건 내야하고,");
		System.out.println("   선이 같은 숫자의 카드를 여러 장 냈을 때는 장수를 맞추어 그보다 강한 카드를 내야한다. ");
		System.out.println("   선이 2장을 냈다고 해서 3장 이상을 내는 것이 아니고 장수는 똑같이 낸다. ");
		System.out.println("3. 카드를 낼 수 없거나 내기 싫으면 패스할 수 있다. (패스의 횟수는 제한 없음)");
		System.out.println("4. 다른 플레이어 전원이 패스해서 다시 바닥에 있는 카드를 낸 플레이어까지 차례가 돌아오면 그 플레이어는 선 플레이어가 된다. 바닥에 내려놓은 카드는 치우고 선 플레이어는 가진 패에서 원하는 카드를 낼 수 있다.");
		System.out.println("5. 손패를 전부 털어낸 사람이 다음 게임의 대부호가 된다. 나머지 플레이어들은 가지고 있는 손패가 적을수록 더 높은 계급을 부여받는 것으로 계급이 확정된다.");
		System.out.println("6. 대부호, 부호, 평민, 빈민, 대빈민 계급 순으로 앉는다. 인원수에 따라 계급의 종류는 달라진다.");
		// 등등 룰 더 넣기
		System.out.println("게임을 시작하려면 아무숫자나 입력해주세요!");
		try {
			menu = scan.nextInt();
			if(menu ==1 || menu != 1) {
				menu = 1;
				break;
			}
		} catch (Exception e) {
			System.out.println("숫자만 입력해주세요.");
			continue;
		}
		} while(menu!=1);
	}
	
	public void gameMain(Scanner scan) {
	}
	
	public void givingHandouts(int members) {
		switch (members) {
		case 2: 
			for(int i=0; i<cd.getCd().size(); i++) {
				if(i%2 == 1) {
					player.addCard(cd.pick());
				} else {
					comm.addCard(cd.pick());
				}
			}
			break;
		case 3: 
			for(int i=0; i<cd.getCd().size(); i++) {
				if(i%3==1) {
					player.addCard(cd.pick());
				} else if(i%3==2) {
					comm.addCard(cd.pick());
				} else {
					comm2.addCard(cd.pick());
				}
			}
			break;
		case 4: 
			for(int i=0; i<cd.getCd().size(); i++) {
				if(i%4==1) {
					player.addCard(cd.pick());
				} else if(i%4==2) {
					comm.addCard(cd.pick());
				} else if(i%4==3) {
					comm2.addCard(cd.pick());
				} else {
					comm3.addCard(cd.pick());
				}
			}
			break;
		case 5: 
			for(int i=0; i<cd.getCd().size(); i++) {
				if(i%5==1) {
					player.addCard(cd.pick());
				} else if(i%5==2) {
					comm.addCard(cd.pick());
				} else if(i%5==3) {
					comm2.addCard(cd.pick());
				} else if(i%5==4) {
					comm3.addCard(cd.pick());
				} else {
					comm4.addCard(cd.pick());
				}
			}
			break;
		case 6: 
			for(int i=0; i<cd.getCd().size(); i++) {
				if(i%6==1) {
					player.addCard(cd.pick());
				} else if(i%6==2) {
					comm.addCard(cd.pick());
				} else if(i%6==3) {
					comm2.addCard(cd.pick());
				} else if(i%6==4) {
					comm3.addCard(cd.pick());
				} else if(i%6==5) {
					comm4.addCard(cd.pick());
				} else {
					comm5.addCard(cd.pick());
				}
			}
			break;
		case 7: 
			for(int i=0; i<cd.getCd().size(); i++) {
				if(i%7==1) {
					player.addCard(cd.pick());
				} else if(i%7==2) {
					comm.addCard(cd.pick());
				} else if(i%7==3) {
					comm2.addCard(cd.pick());
				} else if(i%7==4) {
					comm3.addCard(cd.pick());
				} else if(i%7==5) {
					comm4.addCard(cd.pick());
				} else if(i%7==6) {
					comm5.addCard(cd.pick());
				} else {
					comm6.addCard(cd.pick());
				}
			}
			break;
		}
	}
	
	public void rank(int rank) {
		String ranked = null;
		switch (rank) {
		case 1:  
			ranked = "대부호";
			break;
		
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + rank);
		}
		
	}
	
	public int getCount() {
		return count;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public PlayerBanker getPlayer() {
		return player;
	}

	public PlayerBanker getComm() {
		return comm;
	}

	public PlayerBanker getComm2() {
		return comm2;
	}

	public PlayerBanker getComm3() {
		return comm3;
	}

	public PlayerBanker getComm4() {
		return comm4;
	}

	public PlayerBanker getComm5() {
		return comm5;
	}

	public PlayerBanker getComm6() {
		return comm6;
	}

	@Override
	public String toString() {
		return "cd=" + cd;
	}
	
	
	
}
