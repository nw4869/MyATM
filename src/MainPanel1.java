import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MainPanel1 extends BasePanel implements ActionListener {

	JButton btnTakeMoney;
	JButton btnQuit;
	JButton btnBalance;

	JButton btnPwdChange;
	JButton btnSaveMoney;
	JButton btnTransfer;

	MainPanel1(ATM atm) {
		super(atm);

	}

	@Override
	protected void eastInit() {
		// take menoy
		btnTakeMoney = new JButton("取　　款");
		// Balance inquiries
		btnBalance = new JButton("查询余额");
		// tui card
		btnQuit = new JButton("退　　卡");

		eastLayout.add(Box.createRigidArea(new Dimension(0, 20)));
		eastLayout.add(btnTakeMoney);
		eastLayout.add(Box.createRigidArea(new Dimension(0, 20)));
		eastLayout.add(Box.createVerticalGlue());
		eastLayout.add(btnBalance);
		eastLayout.add(Box.createRigidArea(new Dimension(0, 20)));
		eastLayout.add(Box.createVerticalGlue());
		eastLayout.add(btnQuit);
		eastLayout.add(Box.createRigidArea(new Dimension(0, 20)));

		btnBalance.addActionListener(this);
		btnTakeMoney.addActionListener(this);
		btnQuit.addActionListener(this);
	}

	@Override
	protected void westInit() {

		// pwdchange
		btnPwdChange = new JButton("修改密码");
		btnSaveMoney = new JButton("存　　款");
		btnTransfer = new JButton("转　　账");

		westLayout.add(Box.createRigidArea(new Dimension(0, 20)));
		westLayout.add(btnPwdChange);
		westLayout.add(Box.createRigidArea(new Dimension(0, 20)));
		westLayout.add(Box.createVerticalGlue());
		westLayout.add(btnSaveMoney);
		westLayout.add(Box.createRigidArea(new Dimension(0, 20)));
		westLayout.add(Box.createVerticalGlue());		
		westLayout.add(btnTransfer);
		westLayout.add(Box.createRigidArea(new Dimension(0, 20)));

		btnPwdChange.addActionListener(this);
		btnSaveMoney.addActionListener(this);
		btnTransfer.addActionListener(this);

	}

	@Override
	protected void centerInit() {
		centerLayout.add(Box.createRigidArea(new Dimension(0, 10)));
		JLabel lblWelcome = new JLabel("  请选择服务项目");
//		lblWelcome.setHorizontalAlignment(JLabel.CENTER);
		centerLayout.add(lblWelcome);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnQuit){
			atm.Quit();
		}
		else if(e.getSource() == btnTakeMoney){
//			atm.Out();
			atm.getScreen().ToTakeMoney();
		}
		else if(e.getSource() == btnBalance){
//			atm.showBalance();
			double balance = atm.getBalance();
			atm.getScreen().showBalance(balance);
		}
		else if(e.getSource() == btnTransfer){
//			System.out.println("transfer");
			atm.getScreen().ToTransfer();
		}
		else if(e.getSource() == btnPwdChange){
			atm.getScreen().ToPwdChange();
		}
		else if(e.getSource() == btnSaveMoney){
			atm.getScreen().ToSaveMoney();
		}
	}

}
