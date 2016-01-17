import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.*;

public class TakeMoneyPanel extends BasePanel implements ActionListener {

	JLabel lblinfo;

	JTextField tfMoney;

	TakeMoneyPanel(ATM atm) {
		super(atm);
	}

	@Override
	protected void centerInit() {
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
		if (e.getSource() == btnBack) {
			OnBtnBack();
		} else if (e.getSource() == btnOK) {
			OnBtnOK();
		} else if (e.getSource() == tfMoney) {
			OnBtnOK();
		}

	}

	public static boolean isNumeric(String str){
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	private void OnBtnOK() {
            if (!TakeMoneyPanel.isNumeric(tfMoney.getText())) {
                JOptionPane.showMessageDialog(null, "输入错误");
            } else {
                double money = Double.parseDouble(tfMoney.getText());
                if (!((int)money % 100 == 0)) {
                    JOptionPane.showMessageDialog(null, "金额必须为整百");
                    return;
                }
                if (!atm.OutMoney(money)) {
                    JOptionPane.showMessageDialog(null, "您的余额不足!");
                }
            }
	}

	private void OnBtnBack(){
		Refresh();
		atm.getScreen().ToMain();
	}

	public void Refresh() {
		tfMoney.setText("");
		tfMoney.requestFocus();
	}

}
