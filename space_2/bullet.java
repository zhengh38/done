import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*; 
import java.net.*;
import java.awt.Rectangle;

public class bullet{
  int Bx,By,Bh=10,Bw=7,Bs=0;
  int fire=0;
  Rectangle Brect;
  public void fired(int Gx,int Gy){
    Bx=Gx+22;
    By=Gy-5;
    fire=1;
  }
  public void move(){
    By+=Bs;
    if (fire==1){
      Bs=-15;
    }
    else{
      Bs=0;
    }
    if (By<-20){
      fire=0;
    }
  }
  public void Cbullet(Graphics g,int Gx,int Gy){
    g.setColor(Color.white);
    if (fire==0){
      Brect=null;
    }
    else if (fire==1){
      g.fillOval (Bx,By,Bw,Bh);
      //g.setColor(Color.red);
      //g.drawRect (Bx,By,Bw,Bh);
      Brect=new Rectangle(Bx,By,Bw,Bh);
    }
  }
}