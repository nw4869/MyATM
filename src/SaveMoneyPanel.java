import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SaveMoneyPanel extends BasePanel {
	JLabel lblinfo;

	JTextField tfMoney;

	SaveMoneyPanel(ATM atm) {
		super(atm);
		// TODO Auto-generated constructor stub
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

	@Override
	protected void centerInit() {
		// TODO Auto-generated method stub
		lblinfo = new JLabel("请输入要存款的金额:");

		tfMoney = new JTextField(10);

		centerLayout.add(Box.createRigidArea(new Dimension(0, 10)));
		centerLayout.add(lblinfo);
		centerLayout.add(Box.createRigidArea(new Dimension(0, 10)));
		centerLayout.add(tfMoney);
		centerLayout.add(Box.createRigidArea(new Dimension(0, 160)));

		tfMoney.addActionListener(this);

	}
	
	private void OnBtnBack(){
		Refresh();
		atm.getScreen().ToMain();
	}

	private void OnBtnOK() {
		try {
			double money = new Double(tfMoney.getText());
			if (!atm.SaveMoney(money)) {
				JOptionPane.showMessageDialog(null, "存款失败!");
			}
			else{
				if(JOptionPane.showConfirmDialog(null, "已成功存进"+money+"元，是否继续存款", "存款成功",JOptionPane.YES_NO_OPTION) == 1){
					OnBtnBack();
				}
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "输入错误");
		}
	}

	public void Refresh() {
		// TODO Auto-generated method stub
		tfMoney.setText("");
		tfMoney.requestFocus();
	}

}
