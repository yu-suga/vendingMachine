package beans;

import java.io.Serializable;

public class UserBeans implements Serializable{

	private int inputMoney;	//入力金額
	private int change;		//お釣り


	public UserBeans() {}

	public UserBeans(int inputMoney,int change) {
		this.inputMoney = inputMoney;
		this.change = change;

	}

	public int getInputMoney() {return inputMoney;}
	public void setInputMoney(int inputMoney) {this.inputMoney = inputMoney;}

	public int getChange() {return change;}
	public void setChange(int change) {this.change = change;}
}
