//public class Account {
//	private String accountNum;
//	private String password;
//	
//	Account(){}
//	
//	Account(String acn, String pwd){
//		password = pwd;
//		accountNum = acn;
//	}
//	
//	public void setAccount
//}

import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

class Account {
//	private int accountNumber;
	private int password;
	//余额
	private double amount = 0;
	//ok表示是否开户
	private boolean ok;

	public Account() {
	}

	public Account(int Password) {
		password = Password;
		setOK(true);
	}
	
	public void setOK(boolean b){
		ok = b;
	}
	
	public boolean isOK(){
		return ok;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int Password) {
		password = Password;
	}

	public double getAmount() {
		return amount;
	}
	
	public void Save(double money){
		amount += money;
	}
	
	public double Out(double money){
		if (amount >= money){
			return amount = amount - money;
		}
		else{
			return -1;
		}
		
	}
	public boolean checkPassword(int pwdInput){
		return password == pwdInput;
	}

}
