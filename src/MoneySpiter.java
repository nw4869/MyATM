import javax.swing.JOptionPane;


public class MoneySpiter {
	
	MoneySpiter(){
		
	}

	public boolean spit(double money) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "已吐出"+money+"元，请查收。");
		
        MoneyFrame moneyframe = new MoneyFrame();  
        moneyframe.setVisible(true);  
		
		return true;
	}

}
