import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class LoginPanel extends BasePanel implements ActionListener{

//	private JButton btnOK;
//	
//	private JButton btnBack;
	
	private JLabel lbl1;
	private JPasswordField pfPwd;
	
	LoginPanel(ATM atm) {
		super(atm);
		// TODO Auto-generated constructor stub
		//centerLayout.requestFocus();
		centerLayout.grabFocus();
		pfPwd.grabFocus();
		pfPwd.requestFocus();
	}

	@Override
	protected void centerInit() {
		// TODO Auto-generated method stub
		//centerLayout.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		lbl1 = new JLabel("��������������:");
		pfPwd = new JPasswordField(10);

		centerLayout.add(Box.createRigidArea(new Dimension(0, 20)));
		centerLayout.add(lbl1);
		centerLayout.add(Box.createRigidArea(new Dimension(0, 20)));
		centerLayout.add(pfPwd);
		centerLayout.add(Box.createRigidArea(new Dimension(0, 130)));
		
//		pfPwd.requestFocus();
		pfPwd.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnBack){
			atm.Quit();
		}
		else if(e.getSource() == btnOK || e.getSource() == pfPwd){
			Login();
		}
	}
	
	private void Login(){

		String pwdInput = new String(pfPwd.getPassword());
		
		try{
			if(pwdInput.length() > 9)
				throw new NumberFormatException();
			int nPwd = Integer.parseInt(pwdInput);
		
			if(atm.CheckPasswod(nPwd)){
				atm.getScreen().initMain();
			}
			else{
				JOptionPane.showMessageDialog(null, "�����������������");
			}
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "�������");
		}
	}
	
	public void Refresh(){
		pfPwd.setText("");
		pfPwd.requestFocus();
	}

}
