package teamP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BlackJack{
   private Scanner scan = new Scanner(System.in);
    public BlackJack() {}
   
   public void blackJackStart() {
      System.out.println("블랙잭 실행중...");

      try {Thread.sleep(1000);} catch (Exception e) {}
      System.out.println(
        "⠀         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
      + "⠀         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
      + "⠀⠀         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣾⠿⠿⣷⣦⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
      + "⠀⠀         ⠀⠀⠀⠀⠀⠀⠀⢀⣴⣾⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⣿⣿⠏⠀⠀⠀⢀⠉⠙⠛⠿⣿⣷⣦⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
      + "         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⡟⠁⠀⠀⠀⣤⠄⠀⠀⠀⠀⢠⣿⡟⠀⠀⣀⣴⢿⠀⠀⠀⠀⠀⠉⠙⠛⠻⠿⣶⣦⣄⡀⠀⠀⠀⠀⠀⠀⠀\r\n"
      + "         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⢀⣀⠀⣿⠀⠀⠀⠀⠀⣼⡿⠀⢀⣠⠟⠙⢻⡶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⢿⣧⠀⠀⠀⠀⠀⠀\r\n"
      + "         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⠈⡏⠀⣿⠀⠀⠀⠀⣸⣿⠁⠀⠉⠛⠃⠀⣼⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⡇⠀⠀⠀⠀⠀\r\n"
      + "         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠈⠉⠉⠀⠀⠀⢰⣿⠃⠀⠀⠀⠀⠀⠀⠀⠈⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⠃⠀⠀⠀⠀⠀\r\n"
      + "         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⣠⣴⣶⣶⣤⣿⡟⠀⠀⠀⠀⠀⠀⠀⣀⣴⣾⣿⡅⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⡟⠀⠀⠀⠀⠀⠀\r\n"
      + "         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⢰⣿⣿⣿⣿⣿⡿⠁⠀⠀⠀⢀⣠⣶⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⣾⡿⠁⠀⠀⠀⠀⠀⠀\r\n"
      + "         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⢸⣿⣿⣿⣿⣿⠃⠀⠀⢠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⣸⣿⠁⠀⠀⠀⠀⠀⠀⠀\r\n"
      + "         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⠹⣿⣿⣿⠃⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀⠀⠀⠀⢠⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
      + "         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⠀⢹⣿⡏⠀⠀⠀⠀⠈⠻⢿⣿⡿⢿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⢠⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
      + "         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⠀⣾⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣿⠃⠻⣿⣿⣿⣿⠏⠀⠀⠀⣾⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
      + "         ⠀⠀⠀⠀⠀⠀⠀⣀⣀⣿⣇⣀⡀⢀⣀⣿⣿⣀⠀⠀⠀⠀⢀⣀⣀⡾⣿⣿⣀⣀⣈⣉⣉⣀⣀⣀⣀⣼⣿⣃⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
      + "         ⠀⠀⠀⠀⠀⢰⣿⠿⠿⠿⠿⠿⠿⡿⠿⠿⠿⠿⣿⣦⡀⣰⣿⠿⠿⢿⣷⣿⠿⠿⠿⠿⠿⢿⠿⠿⠿⠿⠿⠿⠿⣿⣷⠀⠀⠀⠀⠀⠀⠀\r\n"
      + "         ⠀⠀⠀⠀⠀⢸⣿⠀⢲⡶⠶⠶⢦⠀⠀⢲⠖⠀⣿⣿⣿⣿⠁⣰⣆⠘⣿⠃⣠⠶⠶⠶⢶⡄⠀⢰⡖⠀⣶⠖⠀⣿⣿⠀⠀⠀⠀⠀⠀⠀\r\n"
      + "         ⠀⠀⠀⠀⠀⢸⣿⡇⢸⡷⠶⠶⢿⡄⠀⢸⠀⠀⠛⠛⠛⠃⢰⣏⣸⣆⠀⠀⣿⠀⠀⠀⠀⠀⠀⢸⡷⠾⣅⠐⢿⣿⣯⠀⠀⠀⠀⠀⠀⠀\r\n"
      + "         ⠀⠀⠀⠀⠀⢸⣿⠀⠼⠷⠶⠶⠖⠃⠠⠾⠦⠤⠤⠿⠀⠴⠿⠄⠠⠿⠤⠀⠙⠶⠶⠶⠞⠁⠀⠸⠧⠀⠿⠷⠀⣿⣿⠀⠀⠀⠀⠀⠀⠀\r\n"
      + "         ⠀⠀⠀⠀⠀⠸⣿⣶⣶⣶⣶⣶⣶⡇⠐⣶⠖⠀⠒⠀⣶⣆⠰⡶⠀⣴⠟⠛⠛⢶⡀⠀⣶⠂⣘⡿⠃⢰⣶⣶⣶⣿⡟⠀⠀⠀⠀⠀⠀⠀\r\n"
      + "         ⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⡇⠠⣤⠀⠀⣿⠀⠀⠀⣼⣁⣹⣄⠀⠀⣿⠀⠒⠀⢀⠀⠀⣿⠾⣧⡀⠺⢿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
      + "         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣷⣄⠛⠛⠛⠛⠀⠀⠚⠛⠀⠐⠛⠂⠀⠛⠒⠒⠒⠛⠁⠀⠛⠂⠘⠓⠂⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
      + "         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠿⣷⣶⣶⣶⣿⣶⣶⣶⣶⣶⣶⣶⣾⣷⣶⣶⣶⣶⣿⣶⣶⣶⣶⣶⣶⣾⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
      + "         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
      + "         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
      try {Thread.sleep(1000);} catch (Exception e) {}
      
      System.out.println("                            블 랙 잭         ");
      
      try {Thread.sleep(500);} catch (Exception e) {}
      
      System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("블랙잭의 목표는 카드 합계가 21에 가깝게 만들면서, 21을 초과하지 않는 범위 내에서 딜러를 이기는 것입니다.");
        System.out.println("카드 값: 카드의 값은 다음과 같이 계산됩니다.");
        System.out.println("숫자 카드(2~10): 해당 숫자만큼의 점수를 가집니다.");
        System.out.println("얼굴 카드(Jack, Queen, King): 각각 10점을 가집니다.");
        System.out.println("에이스(Ace): 1점 또는 11점 중 플레이어가 선택할 수 있습니다.");
        System.out.println("딜러나 플레이어의 합계가 21을 초과하지 않게 하기 위해 유연하게 사용됩니다.");
        
        try {Thread.sleep(1000);} catch (Exception e) {}
        
        System.out.println("1.게임 진행");
        System.out.println("  딜러와 플레이어 각각에게 초기 카드 2장이 나눠집니다.");
        System.out.println("  히트: 추가 카드를 요청하여 합계를 높입니다.");
        System.out.println("  스탠드: 현재 카드로 게임을 진행합니다.");
        System.out.println("  딜러는 일정한 규칙에 따라 카드를 뽑습니다. 일반적으로 딜러는 카드 합계가 16 이하인 경우에는 반드시 히트하고");
        System.out.println("  17 이상인 경우에는 스탠드합니다.");
        System.out.println("  플레이어와 딜러의 카드 합계를 비교하여 승자를 결정합니다.");
       
        try {Thread.sleep(1000);} catch (Exception e) {}
       
        System.out.println("2.게임 결과");
        System.out.println("  플레이어의 카드 합계가 21에 가까우면서 딜러보다 크면 플레이어 승리합니다.");
        System.out.println("  플레이어의 카드 합계가 21을 초과하면 버스트(Bust)로 패배합니다.");
        System.out.println("  딜러의 카드 합계가 21을 초과하면 딜러 패배합니다.");
        System.out.println("  두 플레이어 모두 21을 초과하면 무승부(Draw)가 될 수 있습니다.");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        try {Thread.sleep(1000);} catch (Exception e) {}
       
        System.out.println("블랙잭 게임을 시작합니다!");
        
        
        while (true) {
   
           try {Thread.sleep(300);} catch (Exception e) {}
           System.out.println("카드를 섞는 중 입니다!");
           try {Thread.sleep(300);} catch (Exception e) {}
      
           CardPrint cdPrint = new CardPrint();
           // 각 카드들 초기화
           CardDeck deck = new CardDeck();
           Player player = new Player();
           Player dealer = new Player();
           
           deck.shuffle();
           System.out.println("카드 분배중...");
           try {Thread.sleep(300);} catch (Exception e) {}
           System.out.println("카드 분배중..");
           try {Thread.sleep(200);} catch (Exception e) {}
           System.out.println("카드 분배중.");
           try {Thread.sleep(100);} catch (Exception e) {}
     
           // 플레이어와 딜러에게 초기 카드 나눠주기
            player.addCard(deck.pick());
            dealer.addCard(deck.pick());
            player.addCard(deck.pick());
            dealer.addCard(deck.pick());
            
            
            //딜러의 첫번째 카드만 공개
         // 한장만 보이게 다시 구현할것. //   //B , 0
            dealer.dealerCard();
            System.out.println("딜러 카드: " + "["+dealer.getCards().get(0) + ", ?]"); 
            // 플레이어의 차례
            playerPlay(player,deck,scan);
            
            try {Thread.sleep(300);} catch (Exception e) {}
            
            if(player.calScore()>21) { // 딜러의 차례일때 플레이가 21점을 넘었을 경우

               System.out.println("결과 확인중1.....");
               try {Thread.sleep(300);} catch (Exception e) {}
               Winner(player,dealer);
            }else {
               // 결과 확인 및 출력
       
               System.out.println("결과 확인중2.....");
               try {Thread.sleep(300);} catch (Exception e) {}
       // try {Thread.sleep(300);} catch (Exception e) {}
    
               dealerPlay(dealer,deck);
               Winner(player,dealer);
            }
          

            // 게임 종료 여부 확인
            System.out.print("게임을 계속하시겠습니까? (Y/N): ");
            String input = scan.nextLine();
            if (!input.equalsIgnoreCase("Y")) { //대소문자 상관없음
               System.out.println("게임을 종료합니다");
               System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
               try {Thread.sleep(1000);} catch (Exception e) {}
               break;
            }
        }
   }
   
   
   
   public void playerPlay(Player player, CardDeck deck, Scanner scanner) {
      
      while (true) {
         
         player.showMyDeck();
         System.out.println("플레이어 카드: " + player.getCards());
         System.out.println();
         System.out.println("플레이어 점수: " + player.calScore());
            
            if (player.calScore() > 21) {
                return;
                }
            System.out.print("HIT :: STAY? (H/S): ");
            String str = scanner.nextLine();
            if (str.equalsIgnoreCase("h")) {
               player.addCard(deck.pick());
                } else {
                break;
                }
            
            }
       }

   public void dealerPlay(Player dealer, CardDeck deck) {
        while (dealer.calScore() < 17) {
           System.out.println("딜러 HIT중....");
           dealer.addCard(deck.pick());
           dealer.showMyDeck();
           System.out.println("딜러 카드: " + dealer.getCards());
           
        }
        if (dealer.calScore() > 21) {

           return;
        }
    }

    public void Winner(Player player, Player dealer) {
       int playerScore = player.calScore();
        int dealerScore = dealer.calScore();
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("            결과               ");
        dealer.showMyDeck();
        System.out.println("딜러카드: "+dealer.getCards());
        System.out.println();
        player.showMyDeck();
        System.out.println("플레이어 카드: "+player.getCards());
        if (playerScore > 21) {
           System.out.println("플레이어 점수: " + playerScore);
            System.out.println("딜러 점수: " + dealerScore);
            System.out.println("플레이어 버스트! 딜러 승리!");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        } else if (dealerScore > 21) {
 //          System.out.println("딜러카드: "+dealer.getCards());
 //          System.out.println("플레이어 카드: "+player.getCards());
           System.out.println("플레이어 점수: " + playerScore);
            System.out.println("딜러 점수: " + dealerScore);
            System.out.println("딜러 버스트! 플레이어 승리!");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        }
          else if (playerScore < dealerScore) {
  //           System.out.println("딜러카드: "+dealer.getCards());
  //             System.out.println("플레이어 카드: "+player.getCards());
             System.out.println("플레이어 점수: " + playerScore);
              System.out.println("딜러 점수: " + dealerScore);
              System.out.println("딜러 승리!");
              System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        }
        else if (playerScore > dealerScore) {
   //        System.out.println("딜러카드: "+dealer.getCards());
   //        System.out.println("플레이어 카드: "+player.getCards());
           System.out.println("플레이어 점수: " + playerScore);
            System.out.println("딜러 점수: " + dealerScore);
            System.out.println("플레이어 승리!");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        }
         else if (playerScore == dealerScore){
     //       System.out.println("딜러카드: "+dealer.getCards());
     //       System.out.println("플레이어 카드: "+player.getCards());
            System.out.println("플레이어 점수: " + playerScore);
             System.out.println("딜러 점수: " + dealerScore);
             System.out.println("무승부!");
             System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        }else {
       //    System.out.println("딜러카드: "+dealer.getCards());
       //    System.out.println("플레이어 카드: "+player.getCards());
           System.out.println("플레이어 점수: " + playerScore);
           System.out.println("딜러 점수: " + dealerScore);
           System.out.println("무승부!");
           System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        }
    }
}


class Player {
    private ArrayList<Card> cards = new ArrayList<>();
    
    public void addCard(Card card) {
        cards.add(card);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

   public int calScore() {
        int score = 0;
        int numAces = 0;

        for (Card card : cards) {
            int cardValue = card.getNum();
            if (cardValue == 1) {
                numAces++;
                cardValue = 11; // Ace를 11로 계산
            } else if (cardValue > 10) {
                cardValue = 10; // Jack, Queen, King를 10으로 계산
            }
            score += cardValue;
        }

        // Ace를 11로 계산할 때 버스트를 피하기 위해 Ace 중에서 최대 1개를 1로 계산
        if(score > 21 && numAces > 0) {
           numAces=1;
            score -= 10;
        }
      return score;
    }
   
   public void showMyDeck() {
//      Collections.sort(cards);
      CardPrint cdPrint = new CardPrint(); 
      for(int i=0; i<cards.size(); i++) {
         cdPrint.deckAdd(cards.get(i).getShape(), cards.get(i).getNum());
      }
      for(int i=0; i<cards.size(); i++) {
         if(i>=10) {
            System.out.print("    ["+(i+1)+"]     ");
         } else {
            System.out.print("     ["+(i+1)+"]      ");
         }
      }
      try {Thread.sleep(1000);} catch (Exception e) {}
      System.out.println();
      cdPrint.cardPrint(cdPrint.printDeck());
      return;
   }
   
   public void dealerCard() {
      CardPrint cdPrint=new CardPrint();
      cdPrint.deckAdd(cards.get(0).getShape(),cards.get(0).getNum());
      cdPrint.deckAdd('B', 0);
      cdPrint.cardPrint(cdPrint.printDeck());
      return;
   }
}
