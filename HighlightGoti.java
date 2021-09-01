import java.util.ArrayList;
import javax.swing.*;
class HighlightGoti
{ 
    JLabel [] lb=new JLabel[4];
    void addAr()
    {
       for(int i=0;i<4;i++)
       {	
         lb[i]=new JLabel(new ImageIcon(getClass().getResource("images/baa.jpg")));	
	 VA.labg.add(lb[i],JLabel.NORTH);
	 lb[i].setVisible(false); 
       }
    }
    void startBlink()
    {
	new BlinkThread().start();
    } 
    class BlinkThread extends Thread
    {
      int c=VA.dicei;
      int z=-1,j=-1;
      public void run()
      {
	VA.btturn[c]=true;
	VA.dst=true;
	if(VA.yn==6)
	{
	       resizeAll(VA.startgoti[c]);
	}
	resizeAll(VA.fieldgoti[c]);
	resizeHome();
	while(VA.dst)
	{
	  for(int k=1;k<=8;k++)
	  {
	    EX.exp20();
	    if(VA.yn==6)
	    {
	       blinkAll(VA.startgoti[c]);
	    }
	    blinkAll(VA.fieldgoti[c]);
	    blinkHome();
	  }
          z=0-z;
        }
        resetBt();
      }	
      void resetBt()
      {
	for(int i=0;i<4;i++)
	{
	  lb[i].setVisible(false);
	}
	resetAll(VA.fieldgoti[c]);
        resetAll(VA.homegoti[c]);
      } 
      boolean isMovable(MLabel la)
      {
	return ((56-la.iptr)>=VA.yn);
      }
      void blinkAll(ArrayList<MLabel> list)
      {
        for(int i=0;i<list.size();i++)
        {	
	  MLabel la=list.get(i);
	  if(!VA.homeeligible[c] && la.iptr<=50 && (la.iptr+VA.yn)>50)
	    continue;
 	  blink(la);
         }
      }
      void blinkHome()
      {
        for(int i=0;i<VA.homegoti[c].size();i++)
        {
	   MLabel la=VA.homegoti[c].get(i);	
	   if(!isMovable(la))
	     continue;
	   blink(la);
        }
      }
      void blink(MLabel la)
      {
	   lb[la.gj].setVisible(true);
	   VA.labg.add(lb[la.gj],JLabel.NORTH);
	   int y=la.getY()-20;int x=la.getX()-2;
	   if(y<=0)
	    y=y+10;
	   lb[la.gj].setBounds(x,y=y+z,30,30);
      }
      void resizeAll(ArrayList<MLabel> list)
      {
        for(int i=0;i<list.size();i++)
        {	
	  MLabel la=list.get(i);
 	  if(la.si!=-1)
	    resize(la,VA.stoplist[la.si]);
	  if(la.gri!=-1)
	    resize(la,VA.gotigroup[la.gri]);
         }
      }
      void resizeHome()
      {
        for(int i=0;i<VA.homegoti[c].size();i++)
        {
	   MLabel la=VA.homegoti[c].get(i);	
	   if(!isMovable(la))
	     continue;
	   if(la.gri!=-1)
	    resize(la,VA.gotigroup[la.gri]);
        }
      }
      void resetAll(ArrayList<MLabel> list)
      {
       for(int i=0;i<list.size();i++)
       {	
	  MLabel la=list.get(i);
	  if(la.si!=-1)
	    reverseSize(la,VA.stoplist[la.si]);
	  if(la.gri!=-1)
	    reverseSize(la,VA.gotigroup[la.gri]);
	}
      }
      void resize(MLabel la,ArrayList<MLabel> list)
      {
	if(list.size()>1)
	{
	  VA.labg.add(la,JLabel.NORTH);
	  la.setIcon(new ImageIcon(getClass().getResource("pics/p"+(la.gi+1)+".png")));
	  la.setSize(VA.r,VA.h);
	}
      }		
      void reverseSize(MLabel la,ArrayList<MLabel> list)
      {
	if(list.size()>1)
	{
	  la.setIcon(new ImageIcon(getClass().getResource("pics/sp"+(la.gi+1)+".png")));
	  la.setSize(VA.r1,VA.h1);
	}
      }
   } 
}