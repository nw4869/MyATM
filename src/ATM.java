import javax.swing.JFrame;

public class ATM {

	//����˺���
	private final int MAX_ACN = 1000;
	//�����˻�����
	private Account[] account;
	//��ǰ�˺�
	private Account accountNow;
	//��������
	private CardReader cardReader;
	//��Ǯ��
	private MoneySpiter moneySpiter;
	//��ʾ����ͼ�δ���
	private Screen screen;

	ATM() {
		account = new Account[MAX_ACN];
		for(int i = 0; i < MAX_ACN; i++)
			account[i] = new Account();
		
		//-----------TEST---------------
		account[100].setOK(true);
		account[100].setPassword(123);
		account[100].Save(1<<20);
		
		account[101].setOK(true);
		account[101].setPassword(123);
		account[101].Save(100);
		//------------------------------
		
		cardReader = new CardReader();
		moneySpiter = new MoneySpiter();
		screen = new Screen(this);
	}
	
	/**
	 * ���¶���һЩ��ATM��صĲ��������ӿ�
	 * �ṩ���������
	 * main���������
	 * 
	 */
	
	public boolean InsertCard(){
		return true;
	}
	
	public boolean ReadCard(){
		int accountId = cardReader.read();
		if(accountId >= MAX_ACN || !account[accountId].isOK())
			return false;
		accountNow = account[accountId];
		return true;
	}
	
	public void ScreenInit(){
		screen.initMain();
	}
	
	public boolean CheckPasswod(int pwdInput){
		return accountNow.checkPassword(pwdInput);
	}
	
	public boolean OutMoney(double amount){
		if (accountNow.Out(amount) < 0)
			return false;
		if (!moneySpiter.spit(amount))
			return false;
		return true;
	}
	
	public void Quit(){
		screen.Quit();
	}

	public double getBalance() {
		// TODO Auto-generated method stub
		return accountNow.getAmount();
	}
	
	public Screen getScreen(){
		return screen;
	}
	
	public void pwdChange(int pwd){
		accountNow.setPassword(pwd);
	}
	
	public Account findAccount(int accountId){
		return account[accountId];
	}
	
	public int transfer(int accountId, double money){
		if (accountId >= MAX_ACN || !account[accountId].isOK()){
			return 1;
		}
		else if(account[accountId].equals(accountNow)){
			return 3;
		}
		else if (accountNow.Out(money) < 0){
			return 2;
		}
		return 0;
	}

	public boolean SaveMoney(double money) {
		// TODO Auto-generated method stub
		accountNow.Save(money);
		return true;
	}
	


	public static void main(String argvs[]) {
		new ATM();
	}


}
