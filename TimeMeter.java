import javax.swing.*;    
import java.awt.*;
public class TimeMeter
{      
  public void addBar()
  {    
	VA.jb=new JProgressBar(0,100);            
	VA.jb.setValue(0);    
	VA.jb.setFont(new Font("arial",1,15));
	VA.jb.setForeground(Color.blue);
	VA.jb.setStringPainted(true); 
	//VA.jb.setVisible(false); 
	VA.ludo.add(VA.jb);       
  }    
  public void iterate()
  {    
        VA.clicked=false;
	VA.jb.setForeground(Color.blue);
	VA.jb.setBackground(Color.green);
	if(VA.dicei==0)
	  VA.jb.setBounds(100,515,70,20); 
	if(VA.dicei==2)
	  VA.jb.setBounds(430,85,70,20);  
	if(VA.dicei==1)
	  VA.jb.setBounds(20,112,70,20); 
	if(VA.dicei==3)
	  VA.jb.setBounds(510,490,70,20); 
	VA.jb.setVisible(true); 
	new BarThread().start();
  }  
  class BarThread extends Thread
  {
    public void run()
    {
        int i=0;
	while(i<=100)
	{    
	  if(VA.clicked)
	  {
	   VA.jb.setVisible(false); 
	   return;
	  }
  	  VA.jb.setValue(++i);     
	  if(i>75)
	   VA.jb.setForeground(Color.red);
  	  try{Thread.sleep(60);}catch(Exception e){}    
        }
	if(!VA.clicked)
	  nextPlayer();    
    }
  }
  void nextPlayer()
  {
	 VA.yd=false;
	 VA.dst=false;
	 VA.countmiss[VA.dicei]++;
	 VA.ludo.tm.checkTurnStatus();
	 if(VA.totalplayer>1)
	 { 
	   VA.jb.setBackground(Color.green);
	   VA.jb.setVisible(false); 
	   VA.btturn[VA.dicei]=false;
	   VA.ludo.arrow.moveArrow(VA.dicei=VA.getDice());
	   System.out.println(VA.dicei);
	 }
  }
}    