import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FirstPanel extends JPanel implements ActionListener{
	JButton btnInsertCard;
	JLabel lblInfo;
	
	ATM atm;

	FirstPanel(ATM atm) {
		this.atm = atm;
		setLayout(new GridBagLayout());
		btnInsertCard = new JButton("插卡");
		lblInfo = new JLabel("请插入银行卡：");
		add(lblInfo, 0);
		add(btnInsertCard);
		btnInsertCard.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		atm.InsertCard();
		if(!atm.ReadCard()){
			JOptionPane.showMessageDialog(null, "银行卡读取失败");
		}
		atm.getScreen().ToLogin();
	}
}
