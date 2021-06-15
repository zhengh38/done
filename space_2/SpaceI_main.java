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

public class SpaceI_main extends JFrame implements Runnable,ActionListener,KeyListener{ 
  BufferedImage BG,Gi,p1,p2;
  MyDrawPanel draw1=new MyDrawPanel();
  int numAlien=45,count=0,turn=0,rx,ry,type=0,bomb=0,on=0,numbBomb=8,mid,doi,banana=0,weeboo;
  int numWall=40,wx,wn,stuff,add,gpane=0,select=0;
  int drpB[]= new int[45];
  int pos[]= new int[12];
  int bbn,Glive=0;
  int waved=0,ultra,score,speedV=500;
  gunner g1=new gunner();
  Ralien r1=new Ralien();
  boss bb1=new boss();
  ult u1=new ult();
  bullet b1=new bullet();
  dropBomb[] o1=new dropBomb[numbBomb];
  GreatWallOfTrump[] w1=new GreatWallOfTrump[numWall];
  alien[] a1=new alien[45];
  //alienDrifto aD=new alienDrifto();
  Thread th = new Thread (this); 
  int appx=1000;
  int appy=650;
  public static void main(String[ ] args) 
  {
    new SpaceI_main ();
  }  
  public SpaceI_main (){
    mid=9*55/2+90;
    for(int ab=0;ab<numbBomb;ab++){
      o1[ab]=new dropBomb();
    }
    repaint();
    th.start (); 
    move();
    for(int ab=0;ab<45;ab++){
      a1[ab]=new alien();
    }
    for(int ab=0;ab<numAlien;ab++){
      drpB[ab]=0;
    }
    for(int ab=0;ab<numWall;ab++){
      w1[ab]=new GreatWallOfTrump();
    }
    for(int ab=0;ab<12;ab++){
      pos[ab]=0;
    }
    for(int ab=0;ab<12;ab++){
      pos[ab]=(int )(Math.random() * 900 + 100);
    }
    addKeyListener(this);
    this.add(draw1);
    this.setSize(appx+15,appy+40);
    this.setVisible(true);
  }
  public void keyReleased (KeyEvent e){
    int key2=e.getKeyCode();
    if(key2==KeyEvent.VK_RIGHT){   
      g1.stop();
    }
    if(key2==KeyEvent.VK_LEFT){
      g1.stop();
    }
  }
  public void keyTyped (KeyEvent e){
  }
  public void keyPressed (KeyEvent e){
    int key1=e.getKeyCode();
    if(key1==KeyEvent.VK_RIGHT&&g1.die==0){   
      g1.right();
    }
    if(key1==KeyEvent.VK_LEFT&&g1.die==0){
      g1.left();
    }
    if(key1==KeyEvent.VK_R&&Glive>0){
      g1.die=0;
    }
    if(key1==KeyEvent.VK_SPACE&&b1.fire==0&&Glive>0&&g1.die==0){
      b1.fired(g1.Gx,g1.Gy);
    }
    if(key1==KeyEvent.VK_P){
      wave();
    }
    if(key1==KeyEvent.VK_UP){
      if(select==0){
        select=1;
      }
      else{
        select=0;
      }
    }
    if(key1==KeyEvent.VK_DOWN){
      if(select==0){
        select=1;
      }
      else{
        select=0;
      }
    }
    if(key1==KeyEvent.VK_ENTER){
      if(select==0&&Glive==0){
        gpane=1;
        for(int ab=0; ab<numWall;ab++){
          w1[ab].Tlive=4;
        }
        for(int ab=0; ab<numbBomb;ab++){
          o1[ab].olive=0;
        }
        for(int ab=0; ab<numAlien;ab++){
          a1[ab].As=10;
        }
        waved=4;
        banana=0;
        bb1.BBlive=400;
        Glive=3;
        g1.die=0;
        speedV=500;
        score=0;
        wave();
      }
      else if(select==1){
        gpane=2;
        
      }
      else if(select==3){
        gpane=0;
        select=0;
      }
    }
  }
  public void actionPerformed(ActionEvent e)
  {
  }
////////////////////////////////////////////////////////////////////////////////////////////  
  public void run (){
    while (true){
      g1.move(appx,appy);
      b1.move();
      checkU();
      u1.move();
      waveclear();
     
      r1.move();
//      if (o1[0].olive==1){
      if(waved==4&&bb1.BBlive>0){
        bossB();
      }
      for (int gg=0;gg<numbBomb;gg++){
        o1[gg].move();
      }
      for (int gg=0;gg<numAlien;gg++){
        a1[gg].explo();
      }
//      }
      for (int b=0; b<10; b++){
        if (mid<pos[b]+15&&mid>pos[b]-15&&waved!=4){
          bombD();
        }
      }
      repaint(); 
      
      
      try{
        Thread.sleep (20); 
      } 
      catch (InterruptedException ex){
      } 
    }
  }
  //////////////////////////////////////////////////////////////////////////////
  Thread AD = new Thread(){
    public void run(){
      System.out.println("Thread Running");
      while (true){
        if(r1.Arlive!=1){
          r1.random();
        }

        on=0;
        mid+=a1[0].As;
        if(waved==4&&bb1.BBlive>0){
          bb1.move();
          if(bb1.BBx+600>appx){
            bb1.BBs=-(bb1.BBs);
            bb1.BBx=400;
          }
          else if(bb1.BBx<0){
            bb1.BBs=-(bb1.BBs);
             bb1.BBx=0;
          }
        }
        for (int b=0; b<numAlien; b++){
          a1[b].row(rx,ry,appx);
        }
        
        for (int b=0; b<numAlien; b++){
          if (a1[b].Axx>appx-55){
            if(turn==0&&a1[b].Alive==0){
              turn=1;
              for (int c=0; c<numAlien; c++){ 
                a1[c].As= -(a1[c].As+=1);
                a1[c].Ay+=40;
                if(speedV>300){
                  speedV-=2;
                }
              }
            }
            for(int ab=0;ab<10;ab++){
              pos[ab]=(int )(Math.random() * 600 + 100);
            }
          }
          else if (a1[b].Axx<20){
            if(turn==1&&a1[b].Alive==0){
              turn=0;
              for (int c=0; c<numAlien; c++){ 
                a1[c].As= -(a1[c].As-=1);
                a1[c].Ay+=40;
                if(speedV>300){
                  speedV-=2;
                }
              }
            }
          }
          else if(a1[b].Ayy>650){
            if(a1[b].Alive==0){
              Glive=0;
            }
          }
          for(int ab=0;ab<12;ab++){
            pos[ab]=(int )(Math.random() * 600 + 100);
          }
        }
        try{
          AD.sleep (speedV); 
          on=0;
        } 
        catch (InterruptedException ex){
        } 
      }
    }
  };
  public void move(){
    AD.start();
  }
  public void collision(){
    for (int ab=0; ab<numbBomb; ab++){
      for (int ba=0; ba<numWall; ba++){
        if(o1[ab].olive==1&&o1[ab].Orect!=null&&g1.die==0){
          if((o1[ab].Orect).intersects(g1.Grect)){//&&g1.die==0){
            //System.out.println("Hitting Ship with missile " +ab );
            o1[ab].olive=0;
            Glive=Glive-1;
            g1.die=1;
            //o1[ab].oy=0;
          }
        }
        if(w1[ba].Wrect!=null&&o1[ab].Orect!=null){
          if ((o1[ab].Orect).intersects(w1[ba].Wrect)&&w1[ba].Tlive>0){
            w1[ba].Tlive-=1;
            o1[ab].olive=0;
          }
        }
      }
    }
    for (int ab=0; ab<numAlien; ab++){
      if(a1[ab].Arect!=null&&a1[ab].Alive==0&&b1.Brect!=null){
        if ((b1.Brect).intersects(a1[ab].Arect)){
          a1[ab].Alive=1;
          score+=100;
          b1.fire=0;
        }
      }
      if(a1[ab].Arect!=null&&g1.Grect!=null){
        if(g1.Grect.intersects(a1[ab].Arect)){
          Glive-=1;
           g1.die=1;
        }
      }
      for(int oop=0;oop<numWall;oop++){
        if(a1[ab].Arect!=null&&w1[oop].Wrect!=null){
          if ((w1[oop].Wrect).intersects(a1[ab].Arect)){
            w1[oop].Tlive-=1;
          }
        }
      }
    }
    for (int ab=0; ab<numWall; ab++){
//      for(int op=0;op<10;op++){
      if(u1.fire==1&&w1[ab].Tlive>0){
        if ((u1.Urect).intersects(w1[ab].Wrect)){
          w1[ab].Tlive-=1;
        }
      }
      if(w1[ab].Tlive>0&&b1.Brect!=null){
        if ((b1.Brect).intersects(w1[ab].Wrect)){
          b1.fire=0;
          w1[ab].Tlive-=1;
        }
        
      }
//      }
    }
    if(r1.Rrect!=null&&b1.Brect!=null){
      if ((b1.Brect).intersects(r1.Rrect)){
        b1.fire=0;
        r1.Arlive=0;
        score+=500;
      }
    }
    if(waved==4&&bb1.BBlive>0&&bb1.BOrect!=null){
      if(b1.Brect!=null){
        if ((b1.Brect).intersects(bb1.BOrect)){
          b1.fire=0;
          ultra+=1;
          bb1.BBlive-=1;
        }
      }
      if(u1.Urect!=null&&g1.Grect!=null){
        if((g1.Grect).intersects(u1.Urect)){
          g1.die=1;
          Glive=Glive-1;
        }
      }
    }
  }
////////////////////////////////////////////////////////////////////////////////
  public void dropit(){
    for (int ab=(numAlien/9)-1;ab>=0;ab--){
      for (int ba=0;ba<9;ba++){
        if (a1[ab*9+ba].Alive==0){
          bbn=ab*9+ba;
          drpB[bbn]=(int )(Math.random() * 2 + 1);
        }
      }
    }
  }
  public void bombD(){
    dropit();
    for (int ab=(numAlien/9)-1;ab>=0;ab--){
      for (int ba=0;ba<9;ba++){
        if(drpB[ab*9+ba]==1&&bomb<numbBomb){
          if(((numAlien/9)-1)>ab&&bomb<numbBomb){
            if(a1[ab*9+ba].Alive==0&&a1[ab*9+ba+9].Alive!=0&&o1[bomb].olive!=1){
              o1[bomb].drop(a1[ab*9+ba].Axx,a1[ab*9+ba].Ayy);
              bomb+=1;
            }
          }
          else if(a1[ab*9+ba].Alive==0&&o1[bomb].olive!=1&&bomb<numbBomb){
            o1[bomb].drop(a1[ab*9+ba].Axx,a1[ab*9+ba].Ayy);
            bomb+=1;
          }
        }
      }
    }
    bomb=0;
  }
  public void bossB(){
    for(int ab=0;ab<numbBomb-3;ab++){
      if(o1[ab].olive!=1){
        o1[ab].Bdrop(bb1.BBx);
      }
    }
  }
  public void wave(){
    if(waved<4){
      speedV=500;
      speedV-=waved*20;
      for(int ab=0;ab<numAlien;ab++){
        if(a1[ab].As>0){
          a1[ab].As=10;
        }
        else{
          a1[ab].As=(-10);
        }
        a1[ab].Alive=0;
        a1[ab].Ax=90;
        a1[ab].Ay=50+waved*50;
        mid=9*55/2+90;
        bb1.BBlive=50;
        repaint();
      }
    }
  }
  public void waveclear(){
    for(int ab=0;ab<numAlien;ab++){
      if(a1[ab].Alive!=0){
        weeboo+=1;
      }
    }
    if(weeboo==numAlien&&waved!=4){
      waved+=1;
      if(Glive<6){
        Glive+=1;
      }
      wave();
    }
    weeboo=0;
  }
  public void checkU(){
    if(ultra==5&&bb1.BBlive>0){
      ultra=0;
      u1.fired(bb1.BBx);
    }
  }
  class MyDrawPanel extends JPanel
  {
    public void paintComponent(Graphics g) {
      Graphics2D g2 = (Graphics2D)g;
      if(banana!=1){
        try {
          BG = ImageIO.read(new File("bg.png"));
          Gi = ImageIO.read(new File("gunL.png"));
          p1 = ImageIO.read(new File("menu.png"));
          p2 = ImageIO.read(new File("instru.png"));
        } catch (IOException e) {
          //e.printStackTrace();
        }
      }
      if (gpane==0){
        g.drawImage(p1,0,0,appx,appy,null);
        g2.setColor(Color.white);
        if(select==0){
          g2.fillOval(358,400,20,20);
        }
        else if(select==1){
          g2.fillOval(358,485,20,20);
        }
      }
      else if(gpane==2){
        select=3;
        g.drawImage(p2,0,0,appx,appy,null);
      }
      else if(gpane==1){
        g2.setColor(Color.black);
//      if(on==0)
        g.drawImage(BG,0,0,appx,appy,null);
        g.drawImage(Gi,5,627,30,18,null);
        
        
////      else
////        g2.fillRect(0,360,appx,appy);
        b1.Cbullet(g,g1.Gx,g1.Gy);
        u1.Cult(g);
        g1.Cgun(g,Glive,banana);
        g.fillOval(mid,10,10,10);
        g2.drawString("Score: "+score,10,10);
        g2.drawString("Press R to Respawn",0,615);
        g2.drawString("X "+Glive,10,627);
//      if (on==0){
//        on=1;
        for (int gg=0;gg<numbBomb;gg++){
          o1[gg].BOOM(g, gg);
        }
        if (waved==4){
          bb1.Cboss(g);
          if(bb1.BBlive==0){
            bb1.explo();
            if(bb1.time>15){
              waved=0;
              banana=0;
              score+=1000;
              for(int ab=0;ab<numAlien;ab++){
                a1[ab].Alive=0;
                a1[ab].Ax=90;
                a1[ab].Ay=50+waved*50;
                mid=9*55/2+90;
                bb1.BBlive=50;
                repaint();
              }
            }
          }
        }
        if(waved<4){
          r1.load(banana);
          r1.CRA(g);
          for (int a=0; a<numAlien; a++){
            if (count<9){
              rx=count*55;
              a1[a].CIA(g,rx,ry,type,banana);
            }
            count++;
            if (count==9){
              count=0;
              ry+=50;
              type+=1;
            } 
          }
        }
//      }
        for(int abc=0;abc<numWall;abc++){
          w1[abc].load(banana);
        }
        for(int abc=0;abc<numWall/10;abc++){
          for (int a=0; a<4; a++){
            if(a==0||a==3){
              for(int dd=0; dd<3;dd++){
                w1[wn].Ty+=(dd*20);
                w1[wn].Cwall(g,stuff,add);
                wn+=1;
              }
            }
            if(a==1||a==2){
              for(int dd=0; dd<2;dd++){
                w1[wn].Ty+=(dd*20);
                w1[wn].Cwall(g,stuff,add);
                wn+=1;
              }
            }
            stuff+=20;
          }
          add+=220;
          stuff=0;
        }
        for (int a=0; a<numWall; a++){
          w1[a].Ty=500;
        }
        bb1.load(banana);
        add=0;
        wn=0;
        stuff=0;
        collision();
        rx=0;
        ry=0;
        type=0;
        banana=1;
        if(Glive==0){
          g2.setColor(Color.black);
          g2.fillRect(424,299,148,48);
          g2.setColor(Color.white);
          g2.drawRect(425,300,150,50);
          g2.drawString("Game Over",470,320);
          g2.drawString("Your SCore: "+score,460,330);
          g2.drawString("Press ENTER to play again",425,340);
        }
      }
    }
  }
}
