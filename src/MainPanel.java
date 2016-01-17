//import java.awt.*;
//import java.awt.event.*;
//
//import javax.swing.*;
//
//public class MainPanel extends JPanel{
//	ATM atm;
//	
//	JButton btnTakeMoney;
//	JButton btnQuit;
//	JButton btnBalance;
//	
//	JButton btnPwdChange;
//	JButton btnTransfer;
//	
//	MainPanel(ATM atm){
//		this.atm = atm;
//
//		setLayout(new BorderLayout());
//		
//		EastLayout eastLayout = new EastLayout();
//		WestLayout westLayout = new WestLayout();
//		CenterLayout centerLayout = new CenterLayout();
//		
//		add(eastLayout, BorderLayout.EAST);
//		add(westLayout, BorderLayout.WEST);
//		add(centerLayout, BorderLayout.CENTER);
//	}
//
//	
//	private class EastLayout extends JPanel implements ActionListener{
//
//		EastLayout(){
//			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//
//			//take menoy
//			btnTakeMoney = new JButton("取　　款");
//			//Balance inquiries
//			btnBalance = new JButton("查询余额");
//			//tui card
//			btnQuit = new JButton("退　　卡");
//
//			add(Box.createRigidArea(new Dimension(0, 20)));
//			add(btnTakeMoney);
//			add(Box.createRigidArea(new Dimension(0, 20)));
//			add(Box.createVerticalGlue());
//			add(btnBalance);
//			add(Box.createRigidArea(new Dimension(0, 20)));
//			add(Box.createVerticalGlue());
//			add(btnQuit);
//			add(Box.createRigidArea(new Dimension(0, 20)));
//			
//			btnBalance.addActionListener(this);
//			btnTakeMoney.addActionListener(this);
//			btnQuit.addActionListener(this);
//			
//		}
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			if(e.getSource() == btnQuit){
//				atm.Quit();
//			}
//			else if(e.getSource() == btnTakeMoney){
////				atm.Out();
//				atm.getScreen().OutMoney();
//			}
//			else if(e.getSource() == btnBalance){
//				atm.showBalance();
//			}
//			else{
//				
//			}
//				
//		}
//		
//	}
//	private class WestLayout extends JPanel implements ActionListener{
//		
//		WestLayout(){
//			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//			
//			//pwdchange
//			btnPwdChange = new JButton("修改密码");
//			btnTransfer = new JButton("转　　账");
//
//			add(Box.createRigidArea(new Dimension(0, 20)));
//			add(btnPwdChange);
//			add(Box.createRigidArea(new Dimension(0, 20)));
//			add(Box.createVerticalGlue());
//			add(btnTransfer);
//			add(Box.createRigidArea(new Dimension(0, 20)));
//			
//			btnPwdChange.addActionListener(this);
//			btnTakeMoney.addActionListener(this);
//			
//			
//		}
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			if(e.getSource() == btnTransfer){
////				atm.getScreen().getPanel()
//			}
//		}
//	}
//	
//	private class CenterLayout extends JPanel implements ActionListener{
//		
//		CenterLayout(){
//			JLabel lblWelcome = new JLabel("Welcome");
//			
//			add(lblWelcome);
//		}
//		
//		
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//	}
//	
//}
