import javax.swing.JOptionPane;


public class MoneySpiter {
	
	MoneySpiter(){
		
	}

	public boolean spit(double money) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "���³�"+money+"Ԫ������ա�");
		
        MoneyFrame moneyframe = new MoneyFrame();  
        moneyframe.setVisible(true);  
		
		return true;
	}

}
