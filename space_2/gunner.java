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

public class gunner{
  BufferedImage typeB;
  int Gx=370,Gy=590,Gh=30,Gw=50,Gs=0,die=0;
  Rectangle Grect;
  public void left(){
    Gs=-5;
  }
  public void right(){
    Gs=5;
  }
  public void stop(){
    Gs=0;
  }
  public void move(int appx, int appy){
    Gx+=Gs;
    if (appx<Gx+50){
      Gx=appx-50;
    }
    else if (Gx<0){
      Gx=0;
    }
  }
  public void Cgun(Graphics g,int Glive,int banana){
    if(banana==1){
      try {
        typeB = ImageIO.read(new File("gun.png"));
      } catch (IOException e) {
        //e.printStackTrace();
      }
    }
    g.setColor(Color.white);
    if (Glive>0&&die==0){
      Grect=new Rectangle(Gx,Gy,Gw,Gh);
      g.drawImage(typeB,Gx,Gy,Gw,Gh,null);
    }
    if (die!=0){
      Grect=null;
    }
  }
}