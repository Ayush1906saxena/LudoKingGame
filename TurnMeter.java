import javax.swing.*;   
import javax.swing.border.Border;  
import java.awt.*;
import java.util.Objects;

public class TurnMeter
{    
  Border br=BorderFactory.createLineBorder(Color.red,5,true);    
  public TurnMeter()
  {    
	Border bg=BorderFactory.createLineBorder(Color.green,5,true);
	for(int i=0;i<4;i++)
	{
	  VA.pa[i]=new JPanel();
	  VA.ludo.add(VA.pa[i]);
	  for(int j=0;j<3;j++)
	  {
	    VA.turnmeter[i][j]=new JLabel();
	    VA.turnmeter[i][j].setBorder(bg);
	    VA.pa[i].add(VA.turnmeter[i][j]);
	  }
	} 
	VA.pa[0].setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
	VA.pa[0].setBounds(170,540,25,70); 
	VA.pa[1].setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
	VA.pa[1].setBounds(20,214,70,25); 
	VA.pa[2].setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
	VA.pa[2].setBounds(405,5,25,70);  
	VA.pa[3].setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
	VA.pa[3].setBounds(510,390,70,20);     
  }   
  public void checkTurnStatus()
  {
    int n=VA.countmiss[VA.dicei];
    for(int i=0;i<VA.countmiss[VA.dicei];i++)
    {
	VA.turnmeter[VA.dicei][i].setBorder(br);
    }
    if(n==3)
      kickOut();
  } 
  public void kickOut()
  {
      EX.exp();
      int i=VA.dicei;
      for(int j=0;j<4;j++)
      {
        VA.bt[i][j].setBounds(VA.btx[i][j],VA.bty[i][j],VA.r,VA.h);
        VA.bt[i][j].setEnabled(false);
      }
      VA.dice[i].setEnabled(false);
      VA.arrow[i].setEnabled(false);
      VA.diceturn[i]=false;
      VA.playerturn[i]=false;
      VA.btturn[i]=false;
      VA.dice[i].setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("pics/images/timeout.jfif"))));
      VA.totalplayer--;
      VA.totalp--; 	
      if(VA.totalplayer==1)
      {
	int dicei=VA.getDice();
	VA.winnerlist[++VA.wi]=dicei;
	VA.arrow[dicei].setEnabled(false);
	new LudoPingWinner();
	VA.ludo.setVisible(false);
      }
  }
}    