package teamP;

import java.util.Scanner;

public class Gamemanager {
	private TexasHoldem th = new TexasHoldem();
	private President pres = new President();

	public void mainConsole(Scanner scan) {
		int menu = 0;
		do {
			System.out.println("----GAME----");
			System.out.println("1. 텍사스 홀덤");
			System.out.println("2. 이런거");
			System.out.println("3. 저런거");
			System.out.println("4. 추가");
			System.out.println("5. 대부호");
			System.out.println("6. 종료");
			System.out.print("> 번호입력 : ");
			menu = scan.nextInt();
			
			switch(menu){
			case 1 :
//				th();
				break;
			case 2 :
				
				break;
			case 3 :
				
				break;
			case 4 :
				
				break;
			case 5 : pres.presidentStart(scan);
				break;
			case 6 : 
				break;
				default :
					System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu != 6);
		System.out.println("프로그램 종료");
	}
	
	
	public void th() {
		th.start();
	}
	
}


/* 카드 7장을 num 숫자 기준으로 오름차순 정렬

매개변수로 카드형 리스트를 받음

for(i는 0부터 받은 리스트의 사이즈까지){

	int cnt(페어 확인 카운트)/(indexof(i).num -indexof(i+1).num == 0) - 현재 카드와 다음 카드의 숫자가 같음
	int check(투페어 체크)/(indexof(i).num != indexof(i+1).num) - 현재 카드와 다음 카드의 숫자가 다름
	int st(스트레이트 카운트)/(indexof(i).num - indexof(i+1).num == -1) - 다음 카드가 현재 카드보다 1만큼 큰 경우
	int sameSp(문양 확인)/(이중for문으로 문양 비교 ex)indexof(i).shape == indexof(j).shape) - 패 안에 같은 문양 갯수(sameSp>=4일때 유효)
	
	indexof(i)의 num와 indexof(i+1)의 num 우선 비교

	shape은 플러쉬 제외하고 나중에 판단

	cnt 1, st<5, sameSp<5
		원페어

	cnt 2 or 3, check==cnt-1, sameSp<5
		투페어

	cnt 2, check 0, 상동
		트리플

	(cnt 3, check 1),(cnt 4, check 2),(cnt 4, check 1)
		풀하우스

	cnt 3, check 0
		포카드

	st>=4
		해당하는 카드(문양) 저장
		저장된 카드 안에서 문양 비교
		
		
	
	.
	.
	.
	.
	.
}
 * */
// */