import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;


public class TransferPanel extends BasePanel implements ActionListener {
	
//	private JButton btnOK;
//	
//	private JButton btnBack;
	
	private JLabel lblInfo1, lblInfo2;
	
	private JTextField tfAccount, tfMoney;
		
	TransferPanel(ATM atm) {
		super(atm);
	}


	@Override
	protected void centerInit() {
		lblInfo1 = new JLabel("请输入收款人账号：");
		lblInfo2 = new JLabel("请输入转账金额:");
		tfAccount = new JTextField("");
		tfMoney = new JTextField("");


		centerLayout.add(Box.createRigidArea(new Dimension(0, 10)));
		centerLayout.add(lblInfo1);
		centerLayout.add(tfAccount);
		centerLayout.add(Box.createRigidArea(new Dimension(0, 15)));
		centerLayout.add(lblInfo2);
		centerLayout.add(tfMoney);
		centerLayout.add(Box.createRigidArea(new Dimension(0, 120)));
		
		tfMoney.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnBack){
			OnBtnBack();
		}
		else if(e.getSource() == btnOK){
			OnBtnOK();
		}
		else if(e.getSource() == tfMoney){
			OnBtnOK();
		}
		
	}
	
	private void OnBtnOK() {
		String strAccount = tfAccount.getText();
		String strMoney = tfMoney.getText();
		try{
			int nAccount = Integer.parseInt(strAccount);
			double dMoney = Double.parseDouble(strMoney);
			
			switch (atm.transfer(nAccount, dMoney))
			{
			case 0:
//				JOptionPane.showMessageDialog(null, "转账成功!");
				Refresh();
				if(JOptionPane.showConfirmDialog(null, "已成功将"+strMoney+"元转入账号:"+strAccount+ "!是否继续转账？", "转账成功",JOptionPane.YES_NO_OPTION) == 1){
					OnBtnBack();
				}
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "账号" + strAccount + "不存在！");
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "余额不足，转账失败!");
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "不能转账给自己，转账失败!");
				break;
				
			}
			
		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "输入有误！");
		}
	}

	private void OnBtnBack(){
		Refresh();
		atm.getScreen().ToMain();
	}
	

	public void Refresh() {
		tfAccount.setText("");
		tfMoney.setText("");
		tfAccount.requestFocus();
	}

}
