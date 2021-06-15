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

public class Ralien{
  Rectangle Rrect;
  BufferedImage typeA;
  int Arx,Ary=2,Arh=13,Arw=40,Ars,Arlive=0,time=0,tt=1,stuff,stuff2;
  public void load(int banana){
     if(banana==0){
      try {
        typeA = ImageIO.read(new File("boi.png"));
      } catch (IOException e) {
        //e.printStackTrace();
      }
    }
  }
  public void CRA(Graphics g){
    if(Arlive==1){
      Rrect=new Rectangle(Arx,Ary,Arw,Arh);
      g.drawImage(typeA,Arx,Ary,Arw,Arh,null);
    }
    else{
      Rrect=null;
    }
  }
  public void move(){
    Arx+=Ars;
    if(Arlive==1&&Arx<-40&&Ars<0){
      Arlive=0;
    }
    if(Arlive==1&&Arx>1000&&Ars>0){
      Arlive=0;
    }
  }
  public void random(){
    Ars=0;
    stuff=(int )(Math.random() * 10 +1);
    if(stuff==5){
      Arlive=1;
      stuff2=(int )(Math.random() * 2 +1);
      if(stuff2==1){
        Arx=-40;
        Ars=5;
      }
      else{
        Arx=1000;
        Ars=-5;
      }
    }
  }
}