import javax.swing.*;
import java.util.*;
public class MLabel extends JLabel
{
  int gi,gj,iptr,gri=-1,si=-1,gp;
  public MLabel(){}
  public MLabel(ImageIcon pa,int gi,int gj)
  {
	super(pa);
	this.gi=gi;
	this.gj=gj;
  }
}