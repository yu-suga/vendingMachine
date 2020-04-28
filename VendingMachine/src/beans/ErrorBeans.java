package beans;

public class ErrorBeans {

	private int id;
	private int money;

	public ErrorBeans(int inputId,int clientMoney) {
		if(clientMoney < 0) {

		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
