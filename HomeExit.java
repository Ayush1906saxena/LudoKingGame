import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class HomeExit
{
  JLabel home=new JLabel("<html><u>Back to Home</u></html>");	
  JLabel exit=new JLabel("<html><u>Exit</u></html>");	
  Font fo=new Font("mageneto",0,20);
  public HomeExit()
  {
	home.setBounds(220,10,160,30);
	VA.ludo.bg.add(home);
	modify(home);
	home.addMouseListener(new MouseAdapter()
	{
	  public void mouseClicked(MouseEvent evt)
	  {
		int op=JOptionPane.showConfirmDialog(VA.ludo,"Are you sure?");
	 	if(op==JOptionPane.YES_OPTION)
		{
		  VA.ludo.setVisible(false);
		  VA.ping.setVisible(true);
		  ResetGame.reset();
		}  
	  }
	});
	exit.setBounds(270,580,100,30);
	VA.ludo.bg.add(exit);
	modify(exit);
	exit.setForeground(Color.red);
	exit.addMouseListener(new MouseAdapter()
	{
	  public void mouseClicked(MouseEvent evt)
	  {
		int op=JOptionPane.showConfirmDialog(VA.ludo,"Are you sure?");
	 	if(op==JOptionPane.YES_OPTION)
		  System.exit(0);
	  }
	});
  }
  void modify(JLabel bc)
  {
	bc.setCursor(new Cursor(Cursor.HAND_CURSOR));
	bc.setFont(fo);
	bc.setForeground(Color.blue);
  }
}