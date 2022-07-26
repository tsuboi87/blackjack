package cc.shinbi.exercise.blackjack;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Attender {
	protected ArrayList<Card> cards;
	protected String name;
	//private int ii;
	
public Attender(String name) {
	this.name = name;
	initialize();
}

public void initialize() {
	this.cards = new ArrayList<Card>();
}

public void start(Stock stock) {
	this.cards.clear();
	for(int i = 0; i < 2; i++) {
		Card card = stock.pickCard();
		this.cards.add(card);
	}
}

public String getName() {
	return name;
}

public void hit(Stock stock) {
	Card card = stock.pickCard();
	this.cards.add(card);
} 

public int calculateStrength() {
		int strength = 0;  
		int aceCnt = 0;					//ここから実装指示部分
	
	for(Card card : this.cards) {		
		int num = card.getNumber();		
		if(num > 10) {       //10より大きい場合は数値を10とする（絵札）
			num = 10;					
		}								
		if(num == 1) {					
			aceCnt++;					
		}								
		strength += num;
	}
	if(aceCnt > 0);
	{
		if(strength + 10 <= 21) {  //21より大きかったら10として扱う
			strength += 10;        
		}
	}
	if(strength > 21) {
	   strength = 0;
	}									//ここまで実装指示部分
	return strength;
	}

public String toString() { 
	String string = name + ": ";
	for(int i = 0; i < this.cards.size(); i++) {
		Card card = this.cards.get(i);
		string = string + card.toString(); 
		}
		return string; //赤下線が消えず　『toStrong』を選択みたいなものを選択しろとのこと
	}					//滝田先生に助けて頂く。『String()』とﾐｽ入力をしていた事に気付かず。
						//『string型の変数を返すのです』と言われ、①Sを小文字に②string後ろの括弧
public void display() {      //を外したことで、エラーが解除された。
		System.out.println(this.toString()); 
	}

public abstract void play(Stock stock) throws IOException;
}		//abstract__playは抽象的なプレイヤーということ
		//今回のようにpleyerとdealerにほぼ同じ動きを持たせながら、違う動きを持たせることに使う。