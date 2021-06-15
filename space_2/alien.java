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

public class alien{
  Rectangle Arect;
  int Ax=90,Ay=50,Ah=40,As=10,Alive=0,Axx,Ayy,on=0,time=0,tt=1;
  //BufferedImage type1,type2,type3;
  BufferedImage typeA,typeB,typeC;
  public void CIA(Graphics g,int rx, int ry,int type,int banana){
    if(banana==0){
      try {
        typeC = ImageIO.read(new File("exp.png"));
        if(type==3||type==4){
          typeA = ImageIO.read(new File("type1.png"));
          typeB = ImageIO.read(new File("type1B.png"));}
        else if(type==1||type==2){
          typeA = ImageIO.read(new File("type2.png"));
          typeB = ImageIO.read(new File("type2B.png"));}
        else if(type==0){
          typeA = ImageIO.read(new File("type3.png"));
          typeB = ImageIO.read(new File("type3B.png"));}
      } catch (IOException e) {
        //e.printStackTrace();
      }
    }
    if (Alive==0){
      time=0;
      tt=1;
      Arect=new Rectangle(Ax+rx,Ay+ry,Ah,Ah);
      //if(type==0){
      if(on==0){
        g.drawImage(typeA,Ax+rx,Ay+ry,Ah,Ah,null);
      }
      else if(on==1){
        g.drawImage(typeB,Ax+rx,Ay+ry,Ah,Ah,null);
      }
//      }
//      if(type==1||type==2){
//        g.drawImage(type2,Ax+rx,Ay+ry,Ah,Ah,null);
//      }
//      if(type==3||type==4){
//        g.drawImage(type1,Ax+rx,Ay+ry,Ah,Ah,null);
//      }
      //g.fillRect (Ax+rx,Ay+ry,Ah,Ah);
     // g.setColor(Color.red);
      //g.drawRect(Ax+rx,Ay+ry,Ah,Ah);
      Axx=Ax+rx;//-10;
      Ayy=Ay+ry;
    }
    else if(Alive!=0){
      if(time<15){
         g.drawImage(typeC,Ax+rx,Ay+ry,Ah,Ah,null);
      }
      Arect=null;
    }
  }
  public void explo(){
    time+=tt;
    if(time>15){
      tt=0;
    }
  }
  public void row(int rx, int ry,int appx){
    Ax+=As;
    if(on==0){
      on=1;
    }
    else{
      on=0;
    }
  }
}
