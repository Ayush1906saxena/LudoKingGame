import java.util.ArrayList;
import javax.swing.*;
public class HandlingHomeGoti
{
  int [][] npx={{-9,9},{-12,0,12},{-15,-5,5,15}};
  int [][] npy={{0,10},{0,7,14},{0,6,12,18}};
  int ctr=0;
  public HandlingHomeGoti()
  {
     for(int i=0;i<VA.homelist.length;i++)
     {
	VA.homelist[i]=new ArrayList<MLabel>();
     }	
  }
  public boolean homeFound()
  {
	int i=VA.bc.gi;
	if(VA.bc.iptr==56)
	{
	  EX.exp();
	  VA.bc.gp=3;
	  VA.homelist[i].add(VA.bc);
	  int n=VA.homelist[i].size();
	  if(!VA.homegoti[i].contains(VA.bc))
	    VA.fieldgoti[i].remove(VA.bc);
	  else
	    VA.homegoti[i].remove(VA.bc);
	  VA.allfieldgoti.remove(VA.bc);
	  if(n>1)
	    resize();
	  if(n==4)
	    finishTurn();
	  else
	    VA.ludo.arrow.moveArrow(i);
	  return true;
	}
	return false;
  }
  private void resize()
  {
     int gi=VA.bc.gi,j=0; 	
     int n=VA.homelist[gi].size();  	
     for(int i=0;i<n;i++)
     {
	  MLabel la=VA.homelist[gi].get(i);
	  int x=VA.mx[la.gi][la.iptr];int y=VA.my[la.gi][la.iptr];
	  if(gi==0 || gi==2)  
	    la.setBounds(x+npx[n-2][j++],y,VA.r,VA.h);
	  else if(gi==1)
	    la.setBounds(x=x+npy[n-2][j++],y,VA.r,VA.h);
	  else
	    la.setBounds(x=x-npy[n-2][j++],y,VA.r,VA.h);
     } 	
  }
  private void finishTurn()
  {
	int gi=VA.bc.gi;
	VA.playerturn[gi]=false;
	VA.diceturn[gi]=false;
	VA.arrow[gi].setEnabled(false);
	VA.totalplayer--;
	ctr++;
	setWinnerPhoto();
	if(VA.totalplayer==1)
	{
	  int dicei=VA.getDice();
	  VA.winnerlist[++VA.wi]=dicei;
	  VA.yd=false;
	  VA.arrow[dicei].setEnabled(false);
	  new LudoPingWinner();
	  VA.ludo.setVisible(false);
	  return;
	}
	if(ctr>1)
	  VA.ludo.arrow.moveArrow(VA.getDice());
  } 
  void setWinnerPhoto()
  {
	System.out.println("winner");
	if(ctr==1)
	{
	  VA.labg.add(VA.lawinner,JLabel.NORTH);
	  VA.lawinner.setVisible(true);
	  EX.exp3();
	  VA.ludo.arrow.moveArrow(VA.getDice());
	  VA.lawinner.setVisible(false);	  
	}
	VA.winnerlist[++VA.wi]=VA.bc.gi;
	VA.dice[VA.bc.gi].setIcon(new ImageIcon(getClass().getResource("pics/images/winner"+ctr+".jpg")));	
  }
}