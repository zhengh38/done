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

public class boss{
  Rectangle BOrect;
  BufferedImage typeA,typeB,typeC;
  int BBx=200,BBy=30,BBh=200,Bw=600,BBlive=50,BBs=10,on=0,time,tt=1;
  public void load(int banana){
    if(banana==0){
      try {
        typeA = ImageIO.read(new File("boss.png"));
        typeB = ImageIO.read(new File("bossB.png"));
        typeC = ImageIO.read(new File("bexp.png"));
      } catch (IOException e) {
        //e.printStackTrace();
      }
    }
  }
  public void Cboss(Graphics g){
    if(BBlive>0){
      g.drawRect(398,0,202,20);
      g.setColor(Color.red);
      g.fillRect(400,2,BBlive*4,16);
      BOrect=new Rectangle(BBx,BBy,Bw,BBh);
      //g.fillRect(BBx,BBy,Bw,BBh);
      if(on==0){
        g.drawImage(typeA,BBx,BBy,Bw,BBh,null);
      }
      else if(on==1){
        g.drawImage(typeB,BBx,BBy,Bw,BBh,null);
      }
    }
    else{
      if(time<15){
         g.drawImage(typeC,BBx,BBy,Bw,BBh,null);
      }
      BOrect=null;
    }
  }
  public void move(){
    if(on==0){
      on=1;
    }
    else{
      on=0;
    }
    BBx+=BBs;
  }
  public void explo(){
    time+=tt;
    if(time>15){
      tt=0;      
    }
  }
}