package cc.shinbi.exercise.blackjack;

import java.io.BufferedReader;
import java.io.IOException;

public class Player extends Attender {      //playerはAttenderのSubclassの意
	
	public static final int ACTION_HIT = 1;         //ここの1と2を入れ替えても柔軟に対応するプログラム
	public static final int ACTION_STAND = 2;
	
	private BufferedReader reader;
	
	public Player(BufferedReader reader) {
		super("You");     //Attenderの引数を呼び出している
		this.reader = reader;
	}

	
	@Override
	public int calculateStrength() {       //何故わざわざ上書きしているか？自分の負けの時にお互いZeroであったら引分の判定となる。
		int strength = super.calculateStrength();   //この為バーストした時にZeroより値を小さくするコードを書いている。
		if(strength == 0) {
			strength = -1;
		}
		return strength;
	}
	
	
	@Override
	public void play(Stock stock)throws IOException {
		boolean standing = false;        //勝負しているかどうかの判定。falseはまた継続中となる
		while(!standing) {                //状態同じ
			this.display();			       //自分の手札を開示している
			int action = selectAction();
			if(action == ACTION_HIT) {
				this.hit(stock);
				int strength = this.calculateStrength();
				if(strength <= 0) {       //バーストしたら⇓
					standing = true;	  //勝負する！という状態
				}
			}
			else {
				standing = true;         //別の値を入れたとしても勝負するという状態
			}
		}
	}
	
	
	private int selectAction() throws IOException {
		String selectMessege = "[" + ACTION_HIT + "] HIT (カードを引く) " + " [" + ACTION_STAND + "] Stand(勝負する)";
		System.out.println(selectMessege);
		int action = 0;
		while(action != ACTION_HIT  && action != ACTION_STAND) {      //Userが１か２を入力するまで…のためwhileを使う。
			String input = this.reader.readLine();  
			action = Integer.parseInt(input);			//数字に転換。本来は数字以外を入力するとｴﾗｰとなる。
		}												//以下の様に加えてｴﾗｰを防ぐ。
		//catch(Exception e)	 {
			//System.out.println("数字を入力してください。");
				
		return action;
	}
}