import javax.swing.*;
import java.awt.*;

class HandlingArrow
{
  void addArrow()
  {
	for(int i=0;i<VA.arrow.length;i++)
	{
	  VA.arrow[i]=new JLabel(new ImageIcon(getClass().getResource("images/pics/a"+i+".png")));
	  VA.arrow[i].setBounds(VA.arrowx[i],VA.arrowy[i],100,60);
	  VA.ludo.bg.add(VA.arrow[i],JLabel.NORTH);
	}
  }
  void moveArrow(int i)
  {
	int [] idx={-2,-2,2,2};
	int [] idy={0,0,0,0};
	for(int j=0;j<4;j++)
	  VA.diceturn[j]=false;
	VA.diceturn[i]=true;
	EX.exp();
	new StartArrow(VA.arrowx[i],VA.arrowy[i],idx[i],idy[i],i).start();
	//VA.ludo.bar.iterate();
  } 
  class StartArrow extends Thread
  {
    int x,y,xi,yi,i,x1,y1;
    public StartArrow(int x,int y,int xi,int yi,int i)
    {
	this.x=x;this.y=y;this.xi=xi;this.yi=yi;this.i=i;x1=x;y1=y;
    }	
    public void run()
    {
	VA.dice[i].setIcon(new ImageIcon(getClass().getResource("images/dice1.jfif")));
        VA.yd=true;
	while(VA.yd)
	{
	  for(int c=1;c<=12;c++)
	  {
	   try{ 
	       Thread.sleep(20);
	   }catch(Exception ex){}
	   VA.arrow[i].setBounds(x=x+xi,y=y+yi,100,60);
	  }   
	  xi=0-xi;
	  yi=0-yi;
       }
       VA.arrow[i].setBounds(x1,y1,100,60);
    }	
  }
}