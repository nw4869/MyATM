import javax.swing.*;

public class Screen extends JFrame {
	ATM atm;
	
	/**
	 * 各中板面(PANEL)都是继承BasePanel类的，注释见BASEPANEL.JAVA
	 */
	FirstPanel firstPanel;
	MainPanel1 mainPanel;
	LoginPanel loginPanel;
	PwdChangePanel pwdChangePanel;
	TransferPanel transferPanel;
	TakeMoneyPanel takeMoneyPanel;
	SaveMoneyPanel saveMoneyPanel;
	
	Screen(ATM atm){
		super("MyATM");
		this.atm = atm;
		firstPanel = new FirstPanel(atm);
		mainPanel = new MainPanel1(atm);
		loginPanel = new LoginPanel(atm);
		pwdChangePanel = new PwdChangePanel(atm);
		transferPanel = new TransferPanel(atm);
		takeMoneyPanel = new TakeMoneyPanel(atm);
		saveMoneyPanel = new SaveMoneyPanel(atm);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 250);
		getContentPane().add(firstPanel);
		this.setResizable(false);// 窗口不可变
        this.setLocationRelativeTo(null);// 窗口居中显示
        this.setVisible(true);// 显示窗体
	}

	//切换到主界面同下
	public void initMain() {
		// TODO Auto-generated method stub
		//切换到mainPanel板面
		getContentPane().removeAll();
		getContentPane().add(mainPanel);
		getContentPane().validate();

		getContentPane().repaint();
	}
	
	public boolean OutMoney(){
		String money = JOptionPane.showInputDialog("请输入您的要提取的金额.", "");
		double nMoney = 0;
		try{
			nMoney = Double.parseDouble(money);
			if (!atm.OutMoney(nMoney)){
				JOptionPane.showMessageDialog(null, "您的余额不足!");
				return false;
			}
			return true;
		}catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(null, "您的输入出错!");
			return false;
		}
	}
	
	public void Quit(){
		JOptionPane.showMessageDialog(null, "退卡成功!");
//		ToFirst();
		System.exit(0);
	}

	private void ToFirst() {
		// TODO Auto-generated method stub
		getContentPane().removeAll();
		getContentPane().add(firstPanel);
		getContentPane().validate();
		getContentPane().repaint();
	}

	public void showBalance(double balance) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "您的余额为："+balance+"元。");
	}

	public void ToTransfer() {
		// TODO Auto-generated method stub
		getContentPane().removeAll();
		getContentPane().add(transferPanel);
		getContentPane().validate();
		getContentPane().repaint();
		transferPanel.Refresh();
	}

	public void ToLogin() {
		// TODO Auto-generated method stub
		getContentPane().removeAll();
		getContentPane().add(loginPanel);
		getContentPane().validate();
		getContentPane().repaint();
//		loginPanel.pfPwd.requestFocus();
		loginPanel.Refresh();
	}

	public void ToPwdChange() {
		// TODO Auto-generated method stub
		getContentPane().removeAll();
		getContentPane().add(pwdChangePanel);
		getContentPane().validate();
		getContentPane().repaint();
		pwdChangePanel.Refresh();
	}

	public void ToMain() {
		// TODO Auto-generated method stub
		initMain();
	}
	
	public void ToTakeMoney(){

		getContentPane().removeAll();
		getContentPane().add(takeMoneyPanel);
		getContentPane().validate();
		getContentPane().repaint();
		takeMoneyPanel.Refresh();
	}
	

	public void ToSaveMoney(){

		getContentPane().removeAll();
		getContentPane().add(saveMoneyPanel);
		getContentPane().validate();
		getContentPane().repaint();
		saveMoneyPanel.Refresh();
	}
	
	
}
