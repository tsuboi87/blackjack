package cc.shinbi.exercise.blackjack;

public class Dealer extends Attender {  
	private boolean opened;
	
	public Dealer() {
		super("Computer");
	}
	
	@Override
	public void start(Stock stock) {
		super.start(stock);
		this.opened = false;
	}
	
	@Override
	public void play(Stock stock) {
		int strength = this.calculateStrength();
		while(strength < 17 && strength > 0) {
			this.hit(stock);
			strength = this.calculateStrength();
		}
		this.opened = true;
	}
	
	@Override	public String toString() {
		String string = "";
		if(this.opened) {
			string = super.toString();
		}
		else {
			string = this.name + ":";
			for(int i = 0; i < this.cards.size(); i++) {
				Card card = this.cards.get(i);
				if(i == 0) {
					string = string + card.toString();
				}
				else { //①elseの後の括弧を閉じて}いた。開くよう指示され解決。構文ｴﾗｰとの表示。
			           //②【return string;】直下の括弧のｴﾗｰ(※括弧を開くよう）が解決した
					string = string + "[#####]";
				}
			}  //挿入部分開始
		}
		
	//@Test
	//void test() {
		//Stock stock = new Stock();
		//Dealer dealer = new Dealer();
		
		//dealer.start(stock);
		//dealer.display();
		
		//dealer.play(stock);
		//dealer.display();
		//System.out.println(
				//"Strength: "dealer.calculateStrength()
				//);
	//}
		return string;
		}
	}


