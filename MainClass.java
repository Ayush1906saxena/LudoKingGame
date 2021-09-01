import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

class MainClass extends JFrame
{
  JRadioButton [] player=new JRadioButton[3];
  JPanel pa=new JPanel();
  JButton bt=new JButton("Play",new ImageIcon(Objects.requireNonNull(getClass().getResource("pics/images/play.png"))));
  ButtonGroup bg=new ButtonGroup();
  JLabel la=new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("pics/images/wp3.jpg"))));
  public MainClass()
  {
	super("Ludo Ping");
	setSize(600,600);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	add(la);
	la.setOpaque(true);
	la.setBackground(new Color(190,190,255));
	la.setLayout(null);
	setResizable(false);
	pa.setBounds(50,100,500,50);
	la.add(pa);
	Font fo=new Font("magneto",1,25);
	for(int i=0;i<player.length;i++)
	{
	  player[i]=new JRadioButton((i+2)+" players");
	  bg.add(player[i]);
	  player[i].setForeground(Color.pink);
	  player[i].setBackground(Color.blue);
	  player[i].setFont(fo);
	  pa.add(player[i]);
	}
	player[0].setSelected(true);	
	bt.setFont(fo);
	bt.setBounds(220,370,150,40);
	la.add(bt);
	bt.addActionListener(new PlayListener());
	changeIcon();
	setVisible(true);
  }	
  class PlayListener implements ActionListener
  {
    public void actionPerformed(ActionEvent evt)
    {
	for(int i=0;i<player.length;i++)
	{
	   if(player[i].isSelected())
	     VA.totalplayer=i+2;
	}
	VA.totalp=VA.totalplayer;
	VA.ludo= new Ludo();
	VA.ping.setVisible(false);
    }
  }
  void changeIcon()
  {
	ImageIcon icon=new ImageIcon(Objects.requireNonNull(getClass().getResource("pics/d1.jpg")));
	Image img=icon.getImage();
	setIconImage(img);
  }
  public static void main(String[] args)
  {
	JFrame.setDefaultLookAndFeelDecorated(true);
	VA.ping=new MainClass();
  }
}