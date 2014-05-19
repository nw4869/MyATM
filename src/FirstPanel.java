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
		btnInsertCard = new JButton("InsertCard");
		lblInfo = new JLabel("请插入信用卡：");
		add(lblInfo, 0);
		add(btnInsertCard);
		btnInsertCard.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		atm.InsertCard();
		if(!atm.ReadCard()){
			JOptionPane.showMessageDialog(null, "信用卡读取失败");
		}
		atm.getScreen().ToLogin();
	}
}
