import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
class BlinkBox
{
  JLabel lb;
  Border b=BorderFactory.createLineBorder(Color.red,22);
  void addBox()
  {
	lb=new JLabel();
	lb.setBorder(b);
	lb.setBounds(15,15,22,146);
	VA.labg.add(lb,"NORTH");
    	new BlinkBoxThread().start();
  }
  class BlinkBoxThread extends Thread
  {
    public void run()
    {
	boolean blink=false;
	while(true)
	{
	  lb.setVisible(blink=!blink);
	  try{  
	   Thread.sleep(20);
	  }catch(Exception ex){}
	  //EX.exp();
	}
    }
  }
}