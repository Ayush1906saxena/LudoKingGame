import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
class HandlingGoti
{
  HandlingHomeGoti homegotiobj=new HandlingHomeGoti();
  void addGoti()
  {
    AllGotiListener listener=new AllGotiListener();	
    for(int i=0;i<VA.bt.length;i++)
    {
	for(int j=0;j<VA.bt[i].length;j++)
	{
	  VA.bt[i][j]=new MLabel(new ImageIcon(getClass().getResource("pics/p"+(i+1)+".png")),i,j);
	  VA.bt[i][j].addMouseListener(listener);
	  VA.bt[i][j].setBounds(VA.btx[i][j],VA.bty[i][j],VA.r,VA.h);
	  VA.labg.add(VA.bt[i][j]);
	}
    }
  }
  void moveGoti()
  {
        new GotiMoveThread().start();
  }
  boolean inHome()
  {
	if(VA.bc.iptr>50 && VA.bc.iptr<56)
	  return true;
	return false;
  }
  boolean isMovable(MLabel la)
  {
	return ((56-la.iptr)>=VA.yn);
  }
  class AllGotiListener extends MouseAdapter
  {
    public void mouseClicked(MouseEvent evt)  
    {
	if(evt.getClickCount()>1)
	  return;
	VA.bc=(MLabel)evt.getSource();
	int i=VA.bc.gi;
	if(!VA.btturn[i])
	  return;
	if(!VA.homeeligible[i] && VA.bc.iptr<=50 && (VA.bc.iptr+VA.yn)>50)
	  return;
	if(inHome())
	{
	  if(!isMovable(VA.bc))
	    return;
	}
	if(VA.yn!=6 && VA.bc.gp==0)
	  return;
	if(VA.bc.gp==3)
	  return;
	VA.dst=false;
	if(VA.yn==6)
        {  
	  if(VA.bc.gp==0)
	  {
	    VA.clicked=true;
	    EX.exp();
	    openGoti();
	    return;
	  }
        }
	//VA.clicked=true;
	EX.exp();
        moveGoti();
    }
  }
  int getStIndex()
  {
      int i=VA.bc.gi,j=VA.bc.iptr; 
      for(int c=0;c<8;c++)	
      { 
	if(VA.mx[i][j]==VA.stopx[c] && VA.my[i][j]==VA.stopy[c])
	  return c;
      }
      return -1; 	  
  }
  void openGoti()
  {
	//VA.ludo.sound.open.play();
	int i=VA.dicei;
	VA.bc.setBounds(VA.mx[i][0],VA.my[i][0],VA.r,VA.h);
	VA.startgoti[i].remove(VA.bc);
	VA.fieldgoti[i].add(VA.bc);
	VA.ludo.arrow.moveArrow(i);VA.btturn[i]=false;
	VA.ludo.rbt.addStop(VA.ststop[i]);
	VA.bc.gp=1;
	VA.allfieldgoti.add(VA.bc);
  }
  class GotiMoveThread extends Thread
  {
    boolean moved=false;
    public void run()
    {
        VA.clicked=true;
	int i=VA.bc.gi;
	if(!VA.homeeligible[i] && VA.bc.iptr<=50 && (VA.bc.iptr+VA.yn)>50)
	{
	  VA.ludo.arrow.moveArrow(VA.getDice());
	  return;
	}
	if(VA.bc.gri!=-1)
	{
	  VA.ludo.die.deleteFromGroup();
	}
	if(VA.bc.si!=-1)
	  VA.ludo.rbt.reduceStop(VA.bc.si);
	if(VA.bc.gp==2)
	{
	   if(isMovable(VA.bc))
	     shiftGoti();
	}
	else
	  shiftGoti();
	int si=getStIndex();
	if(si!=-1)
	  VA.ludo.rbt.addStop(si);
	if(homegotiobj.homeFound())
	  return;
	VA.yd=true;
	VA.btturn[i]=false;
	if(inHome())
	{
	  VA.bc.gp=2;
	  if(!VA.homegoti[i].contains(VA.bc))
	  {
	    VA.homegoti[i].add(VA.bc);	
	    VA.fieldgoti[i].remove(VA.bc);
	  }
	}
	if(moved)
	{
	  if(VA.ludo.die.isAvailable())
	    return;     
	}
	if(VA.yn==6)
	 VA.ludo.arrow.moveArrow(i);
	else
        {
	  VA.ludo.reset6();
	  VA.ludo.arrow.moveArrow(VA.getDice());
        }
    }
    void shiftGoti()
    {
	int i=VA.bc.gi;
	VA.bc.si=-1;
	VA.labg.add(VA.bc,JLabel.NORTH);
	for(int c=1;c<=VA.yn;c++)
	{
	  EX.expN(100);
	  int pv=++VA.bc.iptr;
	  VA.bc.setBounds(VA.mx[i][pv],VA.my[i][pv],VA.r,VA.h);
	  moved=true;
	  //VA.ludo.sound.step.play();
	}
    }
  }
}