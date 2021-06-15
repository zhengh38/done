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


public class GreatWallOfTrump{
  Rectangle Wrect;
  int Tx=150,Ty=500,Th=20,Tw=20,Txx;
  int row,col,cc,Tlive=4;
  BufferedImage typeA,typeB,typeC,typeD;
//  int Tlive[]= new int[10];
  public void load(int banana){
    if(banana==0){
      try {
        typeA = ImageIO.read(new File("W1.png"));
        typeB = ImageIO.read(new File("W2.png"));
        typeC = ImageIO.read(new File("W3.png"));
        typeD = ImageIO.read(new File("W4.png"));
      } catch (IOException e) {
        //e.printStackTrace();
      }
    }
  }
  public void Cwall(Graphics g,int stuff,int add){
    if (Tlive>0){
      Wrect=new Rectangle(Tx+stuff+add,Ty,Th,Th);
      if(Tlive==4){
        g.drawImage(typeA,Tx+stuff+add,Ty,Th,Th,null);
      }
      else if(Tlive==3){
        g.drawImage(typeB,Tx+stuff+add,Ty,Th,Th,null);
      }
      else if(Tlive==2){
        g.drawImage(typeC,Tx+stuff+add,Ty,Th,Th,null);
      }
      else{
        g.drawImage(typeD,Tx+stuff+add,Ty,Th,Th,null);
      }
    }
    else if (Tlive==0){
      Wrect=null;
    }
//    Rectangle Wrect[]=new Rectangle[10];
//    for(int ab=0;ab<10;ab++){
//      Tlive[ab]=3;
//    }
//    g.setColor(Color.white);
//    for(int ab=0;ab<4;ab++){
//      if(ab==0||ab==3){
//        for(int op=0;op<3;op++){
//          if(Tlive[cc]>0){
//            Wrect[cc]=new Rectangle(Tx+(ab*22),Ty+(op*22),Th,Th);
//            g.fillRect(Tx+(ab*22),Ty+(op*22),Th,Th);
//            cc+=1;
//          }
//        }
//      }
//      else if(ab==2||ab==1){
//        for(int op=0;op<2;op++){
//          if(Tlive[cc]>0){
//            Wrect[cc]=new Rectangle(Tx+(ab*22),Ty+(op*22),Th,Th);
//            g.fillRect(Tx+(ab*22),Ty+(op*22),Th,Th);
//            cc+=1;
//          }
//        }
//      }
//    }
//    cc=0;
  }
}
