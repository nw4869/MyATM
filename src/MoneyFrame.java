import java.awt.event.*;  
import javax.swing.*;

public class MoneyFrame extends JFrame {  
      
//    public static void main(String[] args) {  
//        MoneyFrame moneyframe = new MoneyFrame();  
//        moneyframe.setVisible(true);  
//    }  
      
    //用于处理拖动事件，表示鼠标按下时的坐标，相对于JFrame  
    int xOld = 0;  
    int yOld = 0;  
      
    public MoneyFrame() {  
        this.setLayout(null);  
  
        //处理事件  
        this.addMouseListener(new MouseAdapter() {  
            @Override  
            public void mousePressed(MouseEvent e) {  
                xOld = e.getX();  
                yOld = e.getY();  
            }  
            @Override
            public void mouseClicked(MouseEvent e){
            	setVisible(false);
            }
        });  
        this.addMouseMotionListener(new MouseMotionAdapter() {  
            @Override  
            public void mouseDragged(MouseEvent e) {  
                int xOnScreen = e.getXOnScreen();  
                int yOnScreen = e.getYOnScreen();  
                int xx = xOnScreen - xOld;  
                int yy = yOnScreen - yOld;  
                MoneyFrame.this.setLocation(xx, yy);  
            }  
        });  
        
        //背景图片，添加到背景Panel里面  
        JLabel bgLabel = new JLabel(new ImageIcon("img/money.gif"));  
          
        //背景Panel  
        JPanel bgPanel = new JPanel();  
        bgPanel.setBounds(0, 0, 450, 218);  
        
        bgPanel.add(bgLabel);  
        
        this.add(bgPanel);
        
		this.setSize(450, 218);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);  
    }  
}  