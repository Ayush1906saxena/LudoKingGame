import javax.swing.*;
class ResetGame
{
  static void reset()
  {  	VA.yd=false;
	EX.exp();
	for(int i=0;i<4;i++)
	{
	  VA.countmiss[i]=0;
	  VA.winnerlist[i]=0;
	  VA.btturn[i]=false;
	  VA.diceturn[i]=false;
	  VA.playerturn[i]=true;
	  VA.startgoti[i].clear();
	  VA.fieldgoti[i].clear();
	  VA.homegoti[i].clear();
	  VA.dice[i]=null;
	  VA.arrow[i]=null;
	  for(int j=0;j<4;j++)
	  {
		VA.bt[i][j]=null;
	  }
	}
	for(int i=0;i<8;i++)
	{
	  VA.gotigroup[i].clear();
	  VA.stoplist[i].clear();
	}
	VA.ludo.goti=null;
	VA.ludo.rbt=null;	
	VA.ludo.arrow=null;
	VA.ludo.hd=null;
	VA.ludo.die=null;
	VA.ludo=null;
	VA.diceturn[0]=true;
	VA.yn=0;VA.dicei=0;VA.bti=0;VA.btj=0;VA.totalplayer=2;VA.totalp=0;VA.wi=-1;
	VA.yd=true;VA.dst=false;VA.moved=false;VA.rdice=false;VA.clicked=true;VA.turnm=false;
  }
}