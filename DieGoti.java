import javax.swing.JLabel;
import java.util.ArrayList;
class DieGoti
{
  MLabel la;
  boolean createGroup()
  {
    int cx=VA.bc.getX(),cy=VA.bc.getY(); 
    if(VA.ludo.goti.getStIndex()!=-1)	
       return false; 	
    int n=VA.allfieldgoti.size();
    for(int i=0;i<n;i++)
    {
	la=VA.allfieldgoti.get(i);
	int ox=VA.mx[la.gi][la.iptr];int oy=VA.my[la.gi][la.iptr];
	if(VA.bc!=la && cx==ox && cy==oy)
	{
	    addIntoGroup();
	    return true;	
	}
    }
    return false;
  }
  int foundGroupIndex()
  {
    for(int i=0;i<VA.gotigroup.length;i++)
    {
	if(VA.gotigroup[i].size()==0)
	  return i;
    }
    return 0;			
  }
  void addIntoGroup()
  {
	int gptr=la.gri;
	if(gptr==-1 && la.gi!=VA.bc.gi)
	{
	    new MoveBegining().start();	
	    return;
	}
	if(la.gri==-1)
	{
	    gptr=foundGroupIndex();
	    VA.gotigroup[gptr].add(la);
	    VA.nog[gptr][la.gi]++;
	    la.gri=VA.bc.gri=gptr;
	}
	VA.bc.gri=gptr;	
	VA.nog[gptr][VA.bc.gi]++;
	VA.gotigroup[gptr].add(VA.bc);
	task(gptr);
  }
  boolean isAvailable()
  {
	return createGroup();
  }
  MLabel getLA(int i,int gptr)
  {
     MLabel lb=null;	
     int n=VA.gotigroup[gptr].size();
     System.out.println(n); 	
     for(int j=0;j<n;j++)
     {
	lb=VA.gotigroup[gptr].get(j);
	if(lb.gi==i)
	 break;
     } 
     return lb;		
  }
  void task(int gptr)
  {
	for(int i=0;i<4;i++)
	{
          System.out.println("nog:"+VA.nog[gptr][i]);
	  if(i!=VA.bc.gi && VA.nog[gptr][i]==1)
	  {
	    la=getLA(i,gptr);
	    VA.ludo.rbt.reverseSize(la);
	    removeFromGroup();
	    new MoveBegining().start();	
	    return;
	  }  
	}
	VA.ludo.rbt.resizeAllGoti(VA.gotigroup[gptr],0);
	if(VA.yn==6)
	   VA.ludo.arrow.moveArrow(VA.dicei);
  	else
 	   VA.ludo.arrow.moveArrow(VA.getDice());

  }
  void deleteFromGroup()
  {
	int i=VA.bc.gri;
	VA.gotigroup[i].remove(VA.bc);
	VA.nog[i][VA.bc.gi]--;
	VA.ludo.rbt.reverseGotiSize(VA.gotigroup[i]);
	if(VA.gotigroup[i].size()==1)
	{
	  MLabel lb=VA.gotigroup[i].get(0);
	  VA.gotigroup[i].remove(lb);
	  VA.nog[i][lb.gi]--;
	  lb.gri=-1;
	}
	VA.bc.gri=-1;
  }
  void removeFromGroup()
  {
	VA.gotigroup[la.gri].remove(la);
	VA.ludo.rbt.resizeAllGoti(VA.gotigroup[la.gri],0);
	VA.nog[la.gri][la.gi]--;
	la.gri=-1;
  }
  class MoveBegining extends Thread
  { 
     public void run()
     {
	int i=la.gi;
	int pv;
	EX.exp();
	do
	{
	  EX.exp2();
	  pv=--la.iptr;
	  la.setBounds(VA.mx[i][pv],VA.my[i][pv],VA.r,VA.h);
	}while(pv!=0);
	EX.exp2();
	la.setBounds(VA.btx[i][la.gj],VA.bty[i][la.gj],VA.r,VA.h);
	VA.fieldgoti[i].remove(la);
	VA.startgoti[i].add(la);
	VA.allfieldgoti.remove(la);
	la.gp=0;la.gri=-1;la.si=-1;
	VA.ludo.reset6();
	if(!VA.homeeligible[VA.dicei])
	{
	  VA.homeeligible[VA.dicei]=true;
	  VA.door[VA.dicei].setVisible(false);
	}
	VA.ludo.arrow.moveArrow(VA.bc.gi);
     }
  }
}