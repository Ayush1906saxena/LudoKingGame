import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class LudoPingWinner extends JFrame
{
  JLabel labg=new JLabel(new ImageIcon(getClass().getResource("pics/images/ludo.jpeg")));
  JLabel go=new JLabel(new ImageIcon(getClass().getResource("pics/images/go4.gif")));
  JPanel pa1=new JPanel();
  JPanel pa2=new JPanel();
  JButton [] bt=new JButton[2];
  public LudoPingWinner()
  {
	super("Ludo Ping Winner");
	setSize(600,600);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	add(labg);
	labg.setLayout(null);
	pa1.setBounds(50,40,500,40);
	labg.add(pa1);
	go.setBounds(50,115,500,371);
	labg.add(go);
	pa2.setBounds(50,500,500,40);
	labg.add(pa2);
	addList();
	setVisible(true);
  }
  void addList()
  {
	JLabel []la=new JLabel[4];
	pa1.setLayout(new FlowLayout(FlowLayout.CENTER,40,0));
	Font fo=new Font("Jokerman",0,20);
	String [] str={"First","Second","Third","Fourth"};
	for(int i=0;i<VA.totalp;i++)
	{
	    la[i]=new JLabel(str[i],new ImageIcon(getClass().getResource("pics/p"+(VA.winnerlist[i]+1)+".png")),0);
	    la[i].setFont(fo);
	    la[i].setBackground(Color.pink);
	    pa1.add(la[i]);
	}
	addButton();
  }
  void addButton()
  {
	pa2.setOpaque(false);
	pa2.setLayout(new FlowLayout(FlowLayout.CENTER,40,0));
	String []str={"exit1.png","replay.jpg"};
   	UserListener listener=new UserListener();
	for(int i=0;i<bt.length;i++)
 	{
	  ImageIcon icon=new ImageIcon(getClass().getResource("pics/images/"+str[i]));
	  bt[i]=new JButton(icon);
	  bt[i].addActionListener(listener);
	  bt[i].setPreferredSize(new Dimension(icon.getIconWidth(),icon.getIconHeight()));
	  pa2.add(bt[i]);
	}
  }
  class UserListener implements ActionListener
  {
    public void actionPerformed(ActionEvent evt)
    {
	if(evt.getSource()==bt[0])//Exit button
	{
	   System.exit(0);
	}
	if(evt.getSource()==bt[1])//Replay button
	{
	  ResetGame.reset();
	  new MainClass();
	}
    }
  } 
  public static void main(String args[])
  {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new LudoPingWinner();
  }	
}