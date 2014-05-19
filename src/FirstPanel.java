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
		lblInfo = new JLabel("��������ÿ���");
		add(lblInfo, 0);
		add(btnInsertCard);
		btnInsertCard.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		atm.InsertCard();
		if(!atm.ReadCard()){
			JOptionPane.showMessageDialog(null, "���ÿ���ȡʧ��");
		}
		atm.getScreen().ToLogin();
	}
}
