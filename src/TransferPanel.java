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
		// TODO Auto-generated constructor stub
	}


	@Override
	protected void centerInit() {
		// TODO Auto-generated method stub
		lblInfo1 = new JLabel("�������տ����˺ţ�");
		lblInfo2 = new JLabel("������ת�˽��:");
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		String strAccount = tfAccount.getText();
		String strMoney = tfMoney.getText();
		try{
			int nAccount = Integer.parseInt(strAccount);
			double dMoney = Double.parseDouble(strMoney);
			
			switch (atm.transfer(nAccount, dMoney))
			{
			case 0:
//				JOptionPane.showMessageDialog(null, "ת�˳ɹ�!");
				Refresh();
				if(JOptionPane.showConfirmDialog(null, "�ѳɹ���"+strMoney+"Ԫת���˺�:"+strAccount+ "!�Ƿ����ת�ˣ�", "ת�˳ɹ�",JOptionPane.YES_NO_OPTION) == 1){
					OnBtnBack();
				}
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "�˺�" + strAccount + "�����ڣ�");
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "���㣬ת��ʧ��!");
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "����ת�˸��Լ���ת��ʧ��!");
				break;
				
			}
			
		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "��������");
		}
	}

	private void OnBtnBack(){
		Refresh();
		atm.getScreen().ToMain();
	}
	

	public void Refresh() {
		// TODO Auto-generated method stub
		tfAccount.setText("");
		tfMoney.setText("");
		tfAccount.requestFocus();
	}

}
