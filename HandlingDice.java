import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class HandlingDice
{
  void addDice()
  {
	Color [] color={Color.blue,Color.red,Color.green,Color.yellow};
	DiceListener listener=new DiceListener();
	for(int i=0;i<VA.dice.length;i++)
	{
	  VA.dice[i]=new JButton(new ImageIcon(getClass().getResource("images/dice1.jfif")));
 	  VA.dice[i].setBorder(BorderFactory.createLineBorder(color[i],5));
	  VA.dice[i].addActionListener(listener);
	  VA.dice[i].setOpaque(true);
	  VA.dice[i].setBackground(color[i]);
	  VA.ludo.bg.add(VA.dice[i]);
	}
	VA.dice[0].setBounds(110,510,70,70);
	VA.dice[1].setBounds(110,40,70,70);
	VA.dice[2].setBounds(420,40,70,70);
	VA.dice[3].setBounds(420,510,70,70);
  }
  class DiceListener implements ActionListener
  {
   public void actionPerformed(ActionEvent evt)
   {
	VA.dicebc=(JButton)evt.getSource();
 	int di=0;
	for(;VA.dicebc!=VA.dice[di];di++);
	if(!VA.diceturn[di])
	  return;
	VA.clicked=true;
	VA.yd=false;VA.dicei=di;VA.diceturn[di]=false;
	new RotateDice().start();	
   } 	
  }
  class RotateDice extends Thread
  {
    public void run()
    {
	for(int i=0;i<4;i++)
	{
	  VA.dicebc.setIcon(new ImageIcon(getClass().getResource("images/dice"+i+".jfif")));
	  try{
	   sleep(200);
	  }catch(Exception ex){}
	}
	VA.ludo.startMove();
    }
  }
}