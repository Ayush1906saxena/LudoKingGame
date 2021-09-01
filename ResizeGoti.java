import javax.swing.*;
import java.util.*;
class ResizeGoti
{
  public ResizeGoti()
  {
     for(int i=0;i<8;i++)
     {
	VA.stoplist[i]=new ArrayList<MLabel>();
     }		
  }
  void reduceStop(int si)
  {
	VA.stoplist[si].remove(VA.bc);
	reverseGotiSize(VA.stoplist[si]);
  }
  void addStop(int si)
  {
	VA.bc.si=si;
	VA.stoplist[si].add(VA.bc);
        resizeAllGoti(VA.stoplist[si],0);
  }
  void reverseGotiSize(ArrayList<MLabel> list)
  {
	reverseSize(VA.bc);
        resizeAllGoti(list,1);
	
  }
  void reverseSize(MLabel la)
  {
	la.setIcon(new ImageIcon(getClass().getResource("pics/p"+(la.gi+1)+".png")));
	la.setBounds(VA.mx[la.gi][la.iptr],VA.my[la.gi][la.iptr],VA.r,VA.h);
  }
  int getStopIndex()
  {
    for(int i=0;i<8;i++)
    {
	if(VA.stoplist[i].contains(VA.bc))
	  return i;
    }
    return -1;	
  }
  void resizeAllGoti(ArrayList<MLabel> list,int m)
  {
    int n=list.size();	
    if(n==0 || n==1 && m==0)
     return;
    if(n==1)
    {
	reverseSize(list.get(0));
	return;
    }
    int j=0;
    for(int i=0;i<n;i++)
    {
	MLabel la=(MLabel)list.get(i);
	int x=VA.mx[la.gi][la.iptr];int y=VA.my[la.gi][la.iptr];
	la.setIcon(new ImageIcon(getClass().getResource("pics/sp"+(la.gi+1)+".png")));
	System.out.println(x+":"+(x+VA.resizex[n-1][j]));
	la.setBounds(x+VA.resizex[n-1][j++],y+5,VA.r1,VA.h1);
    }
  }
}