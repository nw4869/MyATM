import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PwdChangePanel extends BasePanel implements ActionListener {

//	private JButton btnOK;
//	private JButton btnBack;
	
	private JLabel lblOld, lblNew1, lblNew2;
	
	private JPasswordField pfOld, pfNew1, pfNew2;
		
	PwdChangePanel(ATM atm) {
		super(atm);
	}


	@Override
	protected void centerInit() {
		lblOld =  new JLabel("请输入旧密码：");
		lblNew1 = new JLabel("请输入新密码：");
		lblNew2 = new JLabel("确认密码：");
				
		pfOld = new JPasswordField(10);
		pfNew1 = new JPasswordField(10);
		pfNew2 = new JPasswordField(10);

		centerLayout.add(Box.createRigidArea(new Dimension(0, 10)));
		centerLayout.add(lblOld);
		centerLayout.add(pfOld);
		centerLayout.add(Box.createRigidArea(new Dimension(0, 15)));
		centerLayout.add(lblNew1);
		centerLayout.add(pfNew1);
		centerLayout.add(Box.createRigidArea(new Dimension(0, 15)));
		centerLayout.add(lblNew2);
		centerLayout.add(pfNew2);
		centerLayout.add(Box.createRigidArea(new Dimension(0, 60)));
		
		pfOld.addActionListener(this);
		pfNew1.addActionListener(this);
		pfNew2.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnOK){
			OnOK();
		}
		else if(e.getSource() == btnBack){
			OnBack();
		}
		else if(e.getSource() == pfOld || e.getSource() == pfNew1 || e.getSource() == pfNew2){
			OnOK();
		}
	}
	
	private void OnBack(){
		atm.getScreen().ToMain();
	}
	
//	@SuppressWarnings("deprecation")
	private void OnOK(){
//		System.out.println("ok");
//		if(pfOld.getText() == "" || pfNew1.getText() == "" || pfNew2.getText() == ""){
//			JOptionPane.showMessageDialog(null, "请不要留空");
//		}
		
		String Old = new String(pfOld.getPassword());
		String New1 = new String(pfNew1.getPassword());
		String New2 = new String(pfNew2.getPassword());
		try{
			
			int nOld, nNew;
			nOld= Integer.parseInt(Old);
			nNew = Integer.parseInt(New1);
			
			if(!New1.equals(New2)){
				JOptionPane.showMessageDialog(null, "请输入两次同样的密码");
			}
			else if(!atm.CheckPasswod(nOld)){
				JOptionPane.showMessageDialog(null, "旧密码错误，请重试");
			}
			else{
				atm.pwdChange(nNew);
				JOptionPane.showMessageDialog(null, "密码修改成功!");
				Refresh();
				OnBack();
			}
		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "输入错误，请检查输入");
		}
	
	}
	
	public void Refresh(){
		pfOld.setText("");
		pfNew1.setText("");
		pfNew2.setText("");
		pfOld.requestFocus();
	}

}
