package cc.shinbi.exercise.blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlackJack {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in)
		);
		start(reader);      //BufferedReaderを書いてstartを呼び出す
		reader.close();
	}

	public static void start(BufferedReader reader) throws IOException {
			//実装してみよう。との課題が挟まれている
	 Player player = new Player(reader);
	 Dealer dealer = new Dealer();
	 Stock stock = new Stock();
	 
	 player.start(stock);
	 dealer.start(stock);
	 
	 dealer.display();
	 
	 player.play(stock);
	 dealer.play(stock);
	 
	 showResult(player, dealer); 
	 
	 //public void start(Stock stock) {
		 //Card.cards = stock.pickCard();
		// this.cards.add(card);
				
		//return total_cards;
		//}
	//}
}
public static void showResult(Attender player, Attender dealer) {
		//実装してみよう。との課題が挟まれている
	 dealer.display();
	 player.display();
	 
	 int dealerStrength = dealer.calculateStrength();
	 int playerStrength = player.calculateStrength();
	 
	 if(playerStrength > dealerStrength) {
		 System.out.println("あなたの勝ちです。");
	 }
	 if(playerStrength < dealerStrength) {
		 System.out.println("あなたの負けです。");
	 }
	 else {
		 System.out.println("引き分けです。");
	 }
	 
	 //int dealerP = dealer.calculateStrength();
	 //int playerP = player.calculateStrength();
	 //if(playerP < 0) {
		// player.display();
		//System.out.println("あなたの負けです。");
	 //}
	 //else {
		 //dealer.display();
		 //if(playerP < dealerP) {
			 //System.out.println("あなたの負けです。");
		 //}
		 //else if(playerP > dealerP) {
			 //System.out.println("あなたの勝ちです!!!");
		 //}
	
		}
	}
	