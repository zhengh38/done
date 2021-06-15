import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.Rectangle;

public class dropBomb{
  int ox,oy,oh=20,ow=7,os=0,olive=0,oxx,oyy;
  Rectangle Orect;
  public void move(){
    oy+=os;
    if (olive==1){
      os=11;//(int )(Math.random() * 20 + 5);
    }
    else{
      os=0;
    }
    if (oy>650){
      olive=0;
    }
  }
  public void drop(int Axx,int Ayy){
    ox=Axx+17;
    oy=Ayy+10;
    olive=1;
  }
  public void Bdrop(int BBx){
    ox=(int )(Math.random() * 600 + BBx);
    oy=250;
    olive=1;
  }
  public void BOOM(Graphics g, int gg){
    if (olive==1){
      Orect=new Rectangle(ox,oy,ow,oh);
      g.setColor(Color.white);
      if (Orect!=null){
        g.fillRect (ox,oy,ow,oh);
        //g.setColor(Color.blue);
        //g.drawRect (ox,oy,ow,oh);
        //g.drawString(""+gg,ox, oy);
      }
    }
    else if(olive==0)
    {
      Orect=null;
    }
      
        

  }
}