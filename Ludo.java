import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Ludo extends JFrame
{
  ResizeGoti rbt;HandlingDice hd; HandlingGoti goti;
  HandlingArrow arrow; DieGoti die;TurnMeter tm;
  MLabel la;JLabel bg;HighlightGoti hgoti;
  SoundEffect sound;BlinkBox box;
  int [] no6=new int[3];int []dice6={-1,-1,-1};
  int i6=-1;
  public Ludo()
  {
	super("Ludo");setSize(600,650);setLocationRelativeTo(null);
	setResizable(false);
	VA.ludo=this;
	setLayout(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bg=new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/pics/wp4.jpg"))));
	bg.setBounds(0,0,600,650);
	add(bg);
  	bg.setLayout(null);
        VA.labg=new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/ludoking.png"))));
	VA.labg.setBounds(100,110,400,400);
	bg.add(VA.labg);VA.labg.setLayout(null);
	callingMethod();
	VA.favouritePlayer();
	hgoti.addAr();
	addStars();
	getContentPane().setBackground(new Color(240,240,255));
	setVisible(true);
  }
  void callingMethod()
  {
	arrow=new HandlingArrow();
        hd=new HandlingDice();
        die=new DieGoti();
  	goti=new HandlingGoti();
	hgoti=new HighlightGoti();
	hd.addDice();
	arrow.addArrow();
	arrow.moveArrow(0);
	goti.addGoti();
	new HomeExit();
	sound=new SoundEffect();
	sound.loadSound();
	box=new BlinkBox();
	//box.addBox();
	lp();
   	rbt=new ResizeGoti();
	setPlayer();
	setWinner();
	addDoor();
	changeIcon();
  }
  void addDoor()
  {
    for(int i=0;i<4;i++)
    {
	VA.door[i]=new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/door.png"))));
	VA.labg.add(VA.door[i]);
    }	
    VA.door[0].setBounds(190,340,20,20);
    VA.door[1].setBounds(40,190,20,20);
    VA.door[2].setBounds(190,40,20,20);
    VA.door[3].setBounds(340,190,20,20);
  }
  void addStars()
  {
	JLabel ly=null;
	for(int i=0;i<8;i++)
	{
          if(i%2==1)
	    ly=new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/pics/sb.png"))));
	  else
	    ly=new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/pics/sm.png"))));
          ly.setBounds(VA.stopx[i]+2,VA.stopy[i]+13,25,25);
	  VA.labg.add(ly);
	}
  }
  void setWinner()
  {
	 VA.lawinner=new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("pics/images/winner.jpg"))));
	 VA.lawinner.setBounds(70,90,250,202);
	 VA.labg.add(VA.lawinner,JLabel.NORTH);
	 VA.lawinner.setVisible(false);
  }
  void lp()
  {
	for(int i=0;i<8;i++)
	{	
	  VA.gotigroup[i]=new ArrayList<MLabel>();
	  VA.stoplist[i]=new ArrayList<MLabel>();
	}
	for(int i=0;i<4;i++)
	{
	  VA.startgoti[i]=new ArrayList<MLabel>();
	  VA.fieldgoti[i]=new ArrayList<MLabel>();
	  VA.homegoti[i]=new ArrayList<MLabel>();
	  for(int j=0;j<4;j++)
	  {
	    VA.startgoti[i].add(VA.bt[i][j]);
	  }
	}
  }
  void changeIcon()
  {
	ImageIcon icon=new ImageIcon(Objects.requireNonNull(getClass().getResource("pics/d1.jpg")));
	Image img=icon.getImage();
	setIconImage(img);
  }
  void setPlayer()
  {
	if(VA.totalplayer==2)
	{
	  VA.playerturn[1]=false;VA.playerturn[3]=false;
	}
	else if(VA.totalplayer==3)
	{
	  VA.playerturn[3]=false;
	}
	for(int i=0;i<4;i++)
	{
	  if(!VA.playerturn[i])
	  {
		VA.dice[i].setVisible(false);
		VA.arrow[i].setVisible(false);
		for(int j=0;j<4;j++)
		{
		  VA.bt[i][j].setVisible(false);
		}
	  }
	}
  }
  void reset6()
  {
    VA.ludo.i6=-1;
    for(int c=0;c<3;c++)
    {
	VA.ludo.no6[c]=0;VA.ludo.dice6[c]=-1;
    }
  }
  void count6(Random ra)
  {
    int t=0;
    i6=-1;	
    for(int i=0;i<3;i++)
    {
	if(no6[i]==6 && dice6[i]==VA.dicei)
	  t++; 
	no6[i]=0;dice6[i]=-1;
    }
    if(t==3)
	VA.yn=ra.nextInt(5)+1;		
  }
  void startMove()
  {
	int di=VA.dicei;
	Random ra=new Random();
	VA.yn=ra.nextInt(6)+1;
	if(VA.yn!=6)
	{
	  int n=ra.nextInt(3);
	  if(n==2)
	   VA.yn=6;
	}
	/*String str=JOptionPane.showInputDialog(this,"Enter any number");
	if(str==null || str.equals(""))
	  str="6";
	VA.yn=Integer.parseInt(str);*/
	if(VA.yn==6)
	{
	  no6[++i6]=VA.yn;
          dice6[i6]=VA.dicei;
	  if(i6==2)
	    count6(ra);
	}
	EX.exp20();
	VA.dicebc.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("pics/images/" + VA.yn + ".jpg"))));
	int sgs=VA.startgoti[di].size();
	if(VA.yn!=6 && sgs+VA.homelist[di].size()==4)
	{
 	   arrow.moveArrow(VA.getDice());
	   return;
	}
	int fgs=VA.fieldgoti[di].size();
	if(VA.yn==6 && fgs==0 && sgs==0)
	{
 	   arrow.moveArrow(VA.getDice());
	   return;
	}
	int chm=countHomeMovable();
	if(VA.yn!=6 && fgs+chm==0)
	{
 	   arrow.moveArrow(VA.getDice());
	   return;
	}  
	if((VA.yn!=6 && fgs==1 && chm==0) ||(VA.yn==6 && fgs==1 && chm==0 && sgs==0))
	{
	  VA.bc=VA.fieldgoti[di].get(0);
	  goti.moveGoti();
	  return; 
	}  
	if(VA.yn!=6 && fgs==0 && chm==1)
	{
	  VA.bc=la;
	  goti.moveGoti();
	  return; 
	}
	hgoti.startBlink(); 
	
  }
  int countHomeMovable()
  {
	int tot=0;
	int n=VA.homegoti[VA.dicei].size();
	for(int i=0;i<n;i++)
	{
	  MLabel lb=VA.homegoti[VA.dicei].get(i);
	  if(goti.isMovable(lb))
	  {
	    la=lb;
	    tot++;	
	  }
	}
	return tot;
  }
  void diceImage(int i)
  {
	VA.dice[i].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/dice1.jfif"))));
  }
  public static void main(String args[])
  {
	JFrame.setDefaultLookAndFeelDecorated(true);
	new Ludo();
  }
}