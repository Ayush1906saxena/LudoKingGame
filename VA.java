import javax.swing.*;
import java.util.*;
class VA
{
  static JProgressBar jb;   
  static Ludo ludo;
  static JLabel []door=new JLabel[4];
  static MainClass ping;
  static JButton dicebc;
  static JLabel labg;
  static MLabel bc;
  static JLabel lawinner;
  static JPanel []pa=new JPanel[4];
  static JPanel []hpa=new JPanel[4];
  static MLabel [][]bt=new MLabel[4][4];
  static JLabel [][] turnmeter=new JLabel[4][3];
  static JLabel [] arrow=new JLabel[4];
  static JButton []dice=new JButton[4];
  static int btx[][]={{48,98,48,98},{48,98,48,98},{275,325,275,325},{275,325,275,325}};
  static int bty[][]={{260,260,310,310},{32,32,82,82},{32,32,82,82},{260,260,310,310}};
  static int [][]mx={{160,160,160,160,160,135,110,85,60,35,10,10,10,35,60,85,110,135,160,160,160,160,160,160,185,210,210,210,210,210,210,235,260,285,310,335,360,360,360,335,310,285,260,235,210,210,210,210,210,210,185,185,185,185,185,185,185},{35,60,85,110,135,160,160,160,160,160,160,185,210,210,210,210,210,210,235,260,285,310,335,360,360,360,335,310,285,260,235,210,210,210,210,210,210,185,160,160,160,160,160,160,135,110,85,60,35,10,10,35,60,85,110,135,160},{210,210,210,210,210,235,260,285,310,335,360,360,360,335,310,285,260,235,210,210,210,210,210,210,185,160,160,160,160,160,160,135,110,85,60,35,10,10,10,35,60,85,110,135,160,160,160,160,160,160,185,185,185,185,185,185,185},{335,310,285,260,235,210,210,210,210,210,210,185,160,160,160,160,160,160,135,110,85,60,35,10,10,10,35,60,85,110,135,160,160,160,160,160,160,185,210,210,210,210,210,210,235,260,285,310,335,360,360,335,310,285,260,235,210}};
  static int [][]my={{325,300,275,250,225,200,200,200,200,200,200,175,150,150,150,150,150,150,125,100,75,50,25,0,0,0,25,50,75,100,125,150,150,150,150,150,150,175,200,200,200,200,200,200,225,250,275,300,325,350,350,325,300,275,250,225,200},{150,150,150,150,150,125,100,75,50,25,0,0,0,25,50,75,100,125,150,150,150,150,150,150,175,200,200,200,200,200,200,225,250,275,300,325,350,350,350,325,300,275,250,225,200,200,200,200,200,200,175,175,175,175,175,175,175},{25,50,75,100,125,150,150,150,150,150,150,175,200,200,200,200,200,200,225,250,275,300,325,350,350,350,325,300,275,250,225,200,200,200,200,200,200,175,150,150,150,150,150,150,125,100,75,50,25,0,0,25,50,75,100,125,160},{200,200,200,200,200,225,250,275,300,325,350,350,350,325,300,275,250,225,200,200,200,200,200,200,175,150,150,150,150,150,150,125,100,75,50,25,0,0,0,25,50,75,100,125,150,150,150,150,150,150,175,175,175,175,175,175,180}};
  static int []stopx={160,60,35,160,210,310,335,210};
  static int []stopy={325,200,150,50,25,150,200,300};
  static int [] arrowx={180,180,323,323}; 	
  static int [] arrowy={515,45,45,515};
  @SuppressWarnings("unchecked")
  static ArrayList<MLabel> []startgoti=new ArrayList[4];
  @SuppressWarnings("unchecked")
  static ArrayList<MLabel> []fieldgoti=new ArrayList[4];
  @SuppressWarnings("unchecked")
  static ArrayList<MLabel> []homegoti=new ArrayList[4];
  static ArrayList<MLabel> allfieldgoti=new ArrayList<MLabel>();
  @SuppressWarnings("unchecked")
  static ArrayList<MLabel> []gotigroup=new ArrayList[8];
  @SuppressWarnings("unchecked")
  static ArrayList<MLabel> []stoplist=new ArrayList[8];
  @SuppressWarnings("unchecked")
  static ArrayList<MLabel> []homelist=new ArrayList[4];
  static int yn,dicei=0,r=26,h=36,r1=18,h1=25,bti,btj,wi=-1;
  static boolean yd=true,dst=false,moved=false,rdice=false,clicked=true,turnm=false;
  static boolean []btturn=new boolean[4];
  static boolean []diceturn={true,false,false,false};
  static boolean []playerturn={true,true,true,true};
  static boolean []homeeligible={false,false,false,false};
  static int []ststop={0,2,4,6};
  static int [] countmiss=new int[4];  
  static int totalplayer=2,totalp;
  static int [] winnerlist=new int[4];
  static int [][]nog=new int[8][4];
  static int [][]resizex={{0},{-3,9},{-4,3,10},{-6,0,6,12},{-6,-1,3,7,12},{-6,-5,-2,1,4,7},{-9,-6,-3,0,3,6,9},{-9,-7,-5,-3,2,4,6,8}};
  static int pi=0;
  static int getDice()
  {
	int di=dicei==3?0:++dicei;
	while(!playerturn[di])
	{
	   di=di==3?0:++di;
	}
	return di;
  }
  static void favouritePlayer()
  {
	Random ra=new Random();
	pi=ra.nextInt(totalplayer);
	if(totalplayer==2 && pi==1)
	{
	  pi++; 
	}
  }
}