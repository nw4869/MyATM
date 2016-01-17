import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public abstract class BasePanel extends JPanel implements ActionListener{
	/**
	 * EastLayout WestLayout CenterLayout是BorderLayout的三个部分，显示东区，西区，中心区。
	 */
	ATM atm;
	protected EastLayout eastLayout;
	protected WestLayout westLayout;
	protected CenterLayout centerLayout;
	
	//默认的确定、返回按钮
	protected JButton btnOK;
	protected JButton btnBack;
	

	BasePanel(ATM atm) {
		this.atm = atm;
		
		setLayout(new BorderLayout());

		eastLayout = new EastLayout();
		westLayout = new WestLayout();
		centerLayout = new CenterLayout();

		add(eastLayout, BorderLayout.EAST);
		add(westLayout, BorderLayout.WEST);
		add(centerLayout, BorderLayout.CENTER);
		
		//三个留给子类实现多态性的东西。。。
		eastInit();
		westInit();
		centerInit();
	}

	protected void eastInit(){
		btnOK = new JButton("确　　认");
		eastLayout.add(Box.createVerticalGlue());
		eastLayout.add(btnOK);
		eastLayout.add(Box.createRigidArea(new Dimension(0, 20)));
		
		btnOK.addActionListener(this);

	}

	protected void westInit(){
		
		btnBack = new JButton("返　　回");
		westLayout.add(Box.createVerticalGlue());
		westLayout.add(btnBack);
		westLayout.add(Box.createRigidArea(new Dimension(0, 20)));
		
		btnBack.addActionListener(this);
		
	}

	abstract protected void centerInit();

	protected class EastLayout extends JPanel {

		EastLayout() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		}

	}

	protected class WestLayout extends JPanel {

		WestLayout() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		}

	}

	protected class CenterLayout extends JPanel {

		CenterLayout() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//			JLabel lblWelcome = new JLabel("Welcome");
//			add(lblWelcome);
		}
	}

}
