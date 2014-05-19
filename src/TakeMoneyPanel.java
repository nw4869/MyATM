import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TakeMoneyPanel extends BasePanel implements ActionListener {

	JLabel lblinfo;

	JTextField tfMoney;

	TakeMoneyPanel(ATM atm) {
		super(atm);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void centerInit() {
		// TODO Auto-generated method stub
		lblinfo = new JLabel("请输入要提取的金额:");

		tfMoney = new JTextField(10);

		centerLayout.add(Box.createRigidArea(new Dimension(0, 10)));
		centerLayout.add(lblinfo);
		centerLayout.add(Box.createRigidArea(new Dimension(0, 10)));
		centerLayout.add(tfMoney);
		centerLayout.add(Box.createRigidArea(new Dimension(0, 160)));

		tfMoney.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnBack) {
			OnBtnBack();
		} else if (e.getSource() == btnOK) {
			OnBtnOK();
		} else if (e.getSource() == tfMoney) {
			OnBtnOK();
		}

	}

	private void OnBtnOK() {
		try {
			double money = new Double(tfMoney.getText());
			if (!atm.OutMoney(money)) {
				JOptionPane.showMessageDialog(null, "您的余额不足!");
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "输入错误");
		}
	}

	private void OnBtnBack(){
		Refresh();
		atm.getScreen().ToMain();
	}

	public void Refresh() {
		// TODO Auto-generated method stub
		tfMoney.setText("");
		tfMoney.requestFocus();
	}

}
