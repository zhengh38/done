import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*; 
import java.net.*;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.*;
import java.io.*;
import java.awt.image.BufferedImage;

public class ult{
  int Ux,Uy=210,Uh=20,Uw=240,Us=0,fire=0;;
  
  Rectangle Urect;
  public void fired(int BBx){
    Ux=(int )(Math.random() * 360 + BBx);
    fire=1;
  }
  public void move(){
    Uy+=Us;
    if (fire==1){
      Us=8;
    }
    else{
      Us=0;
    }
    if (Uy>650){
      fire=0;
      Uy=210;
    }
  }
  public void Cult(Graphics g){
    g.setColor(Color.white);
    if (fire==0){
      Urect=null;
    }
    else if (fire==1){
       Urect=new Rectangle(Ux,Uy,Uw,Uh);
      g.fillOval (Ux,Uy,Uw,Uh);
      //g.setColor(Color.red);
      //g.drawRect (Bx,By,Bw,Bh);
     
    }
  }
}