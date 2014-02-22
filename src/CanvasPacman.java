import java.io.InputStream;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
public class CanvasPacman extends GameCanvas implements Runnable
{
    public Image x1;
    public Image x3;
    public Image x4;
    public int tx1,ty1;
    public int tx3,ty3;
    public int tx4,ty4;
    public int score;
    public boolean level1;
    public boolean x3goleft,x4goleft;
    public boolean levelGameOver;
    public int totalFruit;
    public Image x2[];
    public int tx2[],ty2[];
    public boolean x2eat[];
    public boolean level2;
    public int totalFruit2;
    public Image x5[];
    public int tx5[],ty5[];
    public boolean x5eat[];
    public Image x7;
    public int tx7,ty7;
    public Image x8;
    public int tx8,ty8;
    public Image x9;
    public int tx9,ty9;
    public Image x10;
    public int tx10,ty10;
    public Image x11;
    public int tx11,ty11;
    public Image x12;
    public int tx12,ty12;
    public Image x6;
    public int tx6,ty6;
    public Image x13;
    public int tx13,ty13;
    public Player p1;
    public CanvasPacman()
    {
        super(true);
        try
        {
            x1=Image.createImage("pacman.png");
            x3=Image.createImage("ghost.png");
            x4=Image.createImage("ghost.png");
            tx1=110;
            ty1=199;
            tx3=0;
            ty3=100;
            tx4=221;
            ty4=130;
            levelGameOver=false;
            level1=true;
            level2=false;
            score=0;
            x3goleft=false;
            x4goleft=false;
            totalFruit=22;
            x2=new Image[totalFruit];
            tx2=new int[totalFruit];
            ty2=new int[totalFruit];
            x2eat=new boolean[totalFruit];
            for(int i=0; i<totalFruit; i++)
            {
                x2[i]=Image.createImage("food.png");
                tx2[i]=221;
                ty2[i]=105;
                x2eat[i]=false;
            }
            tx2[0]=221;
            ty2[0]=119;
            tx2[1]=211;
            ty2[1]=119;
            tx2[2]=201;
            ty2[2]=119;
            tx2[3]=191;
            ty2[3]=119;
            tx2[4]=181;
            ty2[4]=119;
            tx2[5]=171;
            ty2[5]=119;
            tx2[6]=161;
            ty2[6]=119;
            tx2[7]=151;
            ty2[7]=119;
            tx2[8]=141;
            ty2[8]=119;
            tx2[9]=131;
            ty2[9]=119;
            tx2[10]=121;
            ty2[10]=119;
            tx2[11]=111;
            ty2[11]=119;
            tx2[12]=101;
            ty2[12]=119;
            tx2[13]=91;
            ty2[13]=119;
            tx2[14]=81;
            ty2[14]=119;
            tx2[15]=71;
            ty2[15]=119;
            tx2[16]=61;
            ty2[16]=119;
            tx2[17]=51;
            ty2[17]=119;
            tx2[18]=41;
            ty2[18]=119;
            tx2[19]=31;
            ty2[19]=119;
            tx2[20]=21;
            ty2[20]=119;
            tx2[21]=11;
            ty2[21]=119;
            totalFruit2=9;
            x5=new Image[totalFruit2];
            tx5=new int[totalFruit2];
            ty5=new int[totalFruit2];
            x5eat=new boolean[totalFruit2];
            for(int i=0; i<totalFruit2; i++)
            {
                x5[i]=Image.createImage("food.png");
                tx5[i]=120;
                ty5[i]=160;
                x5eat[i]=false;
            }
            tx5[0]=100;
            ty5[0]=100;
            tx5[1]=110;
            ty5[1]=100;
            tx5[2]=120;
            ty5[2]=100;
            tx5[3]=100;
            ty5[3]=110;
            tx5[4]=110;
            ty5[4]=110;
            tx5[5]=120;
            ty5[5]=110;
            tx5[6]=100;
            ty5[6]=120;
            tx5[7]=110;
            ty5[7]=120;
            tx5[8]=120;
            ty5[8]=120;
            x7=Image.createImage("ghost.png");
            tx7=94;
            ty7=134;
            x8=Image.createImage("ghost.png");
            tx8=114;
            ty8=134;
            x9=Image.createImage("ghost.png");
            tx9=74;
            ty9=94;
            x10=Image.createImage("ghost.png");
            tx10=74;
            ty10=114;
            x11=Image.createImage("ghost.png");
            tx11=134;
            ty11=94;
            x12=Image.createImage("ghost.png");
            tx12=134;
            ty12=114;
            x6=Image.createImage("ghost.png");
            tx6=94;
            ty6=74;
            x13=Image.createImage("ghost.png");
            tx13=114;
            ty13=74;
        }
        catch(Exception e)
        {
        }
    }
    public void start()
    {
        Thread runner = new Thread(this);
        runner.start();
    }
    public void run()
    {
        try
        {
            InputStream in = getClass().getResourceAsStream("/move.mid");
            p1=Manager.createPlayer(in, "audio/x-midi");
            p1.start();
        }
        catch(Exception err)
        {
        }
        while(true)
        {
            keyboard(getKeyStates());
            if(levelGameOver==true)
            {
                levelGameOver();
            }
            else if(level1==true)
            {
                level1();
            }
            else if(level2==true)
            {
                level2();
            }
            flushGraphics();
            try
            {
                Thread.currentThread().sleep(30);
            }
            catch(Exception e)
            {
            }
        }
    }
    public void level1()
    {
        try
        {
            p1.start();
        }
        catch(Exception err)
        {
        }
        Graphics g = getGraphics();
        
        //black : draw background and object
        g.setColor(0,0,0);
        g.fillRect(0,0,getWidth(),getHeight());
        for(int i=0; i<totalFruit; i++)
        {
            if(x2eat[i]==false)
            {
                g.drawImage(x2[i],tx2[i],ty2[i],0);
            }
        }
        g.drawImage(x1,tx1,ty1,0);
        g.drawImage(x3,tx3,ty3,0);
        g.drawImage(x4,tx4,ty4,0);

        //yellow : draw scoreboard
        g.setColor(255,255,0);
        g.setFont(Font.getDefaultFont());
        g.drawString("SCORE",0,0,0);
        g.drawString(""+score,15,18,0);
        g.drawString("LEVEL",190,0,0);
        g.drawString("1",205,18,0);
            
        //blue : draw wall
        g.setColor(0,0,255);
        //top
        g.drawLine(0,40,240,40);
        //bottom
        g.drawLine(0,218,240,218);
        //right
        g.drawLine(239,40,239,218);
        //left
        g.drawLine(0,40,0,218);
        
        //monster path setup
        if( (tx3<221) && (x3goleft==false) )
        {
            tx3++;
        }
        if(tx3==221)
        {
            x3goleft=true;
        }
        if(tx3>0 && x3goleft==true)
        {
            tx3--;
        }
        if(tx3==0)
        {
            x3goleft=false;
        }
        
        if( (tx4<221) && (x4goleft==false) )
        {
            tx4++;
        }
        if(tx4==221)
        {
            x4goleft=true;
        }
        if(tx4>0 && x4goleft==true)
        {
            tx4--;
        }
        if(tx4==0)
        {
            x4goleft=false;
        }
        
        if(score==220)
        {
            level1=false;
            level2=true;
            tx1=110;
            ty1=199;
        }
    }
    public void level2()
    {
        try
        {
            p1.start();
        }
        catch(Exception err)
        {
        }
        Graphics g = getGraphics();
        
        //black : draw background and object
        g.setColor(0,0,0);
        g.fillRect(0,0,getWidth(),getHeight());
        g.drawImage(x1,tx1,ty1,0);
        for(int i=0; i<totalFruit2; i++)
        {
            if(x5eat[i]==false)
            {
                g.drawImage(x5[i],tx5[i],ty5[i],0);
            }
        }
        g.drawImage(x7,tx7,ty7,0);
        g.drawImage(x8,tx8,ty8,0);
        g.drawImage(x9,tx9,ty9,0);
        g.drawImage(x10,tx10,ty10,0);
        g.drawImage(x11,tx11,ty11,0);
        g.drawImage(x12,tx12,ty12,0);
        g.drawImage(x6,tx6,ty6,0);
        g.drawImage(x13,tx13,ty13,0);
        
        //yellow : draw scoreboard
        g.setColor(255,255,0);
        g.setFont(Font.getDefaultFont());
        g.drawString("SCORE",0,0,0);
        g.drawString(""+score,15,18,0);
        g.drawString("LEVEL",190,0,0);
        g.drawString("2",205,18,0);
        g.drawString("Tips : Find the illusion ghost",0,280,0);
            
        //blue : draw wall
        g.setColor(0,0,255);
        //top
        g.drawLine(0,40,240,40);
        //bottom
        g.drawLine(0,218,240,218);
        //right
        g.drawLine(239,40,239,218);
        //left
        g.drawLine(0,40,0,218);
        
        if(score==310)
        {
            level1=false;
            level2=false;
            tx1=110;
            ty1=199;
            levelGameOver=true;
        }
    }
    public void levelGameOver()
    {
        Graphics g = getGraphics();
        
        //black : draw background and object
        g.setColor(0,0,0);
        g.fillRect(0,0,getWidth(),getHeight());

        //yellow : draw scoreboard
        g.setColor(255,255,0);
        g.setFont(Font.getDefaultFont());
        g.drawString("Game over, your score is "+score,20,120,0);
        g.drawString("Please fire key to restart.",20,150,0);
    }
    private void keyboard(int e)
    {
        if( ((e & FIRE_PRESSED)!=0) && (levelGameOver==true) )
        {
            levelGameOver=false;
            level1=true;
            level2=false;
            score=0;
            tx1=110;
            ty1=199;
            for(int i=0; i<totalFruit; i++)
            {
                x2eat[i]=false;
            }
            for(int i=0; i<totalFruit2; i++)
            {
                x5eat[i]=false;
            }
        }
        if((e & LEFT_PRESSED)!=0)
        {
            if(tx1>1)
            {
                tx1 -= 1;
            }
        }
        else if((e & RIGHT_PRESSED)!=0)
        {
            if(tx1<221)
            {
                tx1 += 1;
            }
        }
        else if((e & UP_PRESSED)!=0)
        {
            if(ty1>41)
            {
                ty1 -= 1;
            }
        }
        else if((e & DOWN_PRESSED)!=0)
        {
            if(ty1<199)
            {
                ty1 += 1;
            }
        }
        if(level1==true)
        {   
        if( (tx1>=(tx3-15)&&tx1<=(tx3+15)) && (ty1>=(ty3-15)&&ty1<=(ty3+15)) )
        {
            level1=false;
            levelGameOver=true;
            playDeath();
        }
        if( (tx1>=(tx4-15)&&tx1<=(tx4+15)) && (ty1>=(ty4-15)&&ty1<=(ty4+15)) )
        {
            level1=false;
            levelGameOver=true;
            playDeath();
        }
        for(int i=0; i<totalFruit; i++)
        {
            if( (tx1>=(tx2[i]-7)&&tx1<=(tx2[i]+7)) && (ty1>=(ty2[i]-7)&&ty1<=(ty2[i]+7)) )
            {
                if(x2eat[i]==false)
                {
                    score+=10;
                }
                x2eat[i]=true;
            }
        }
        }
        if(level2==true)
        {
        for(int i=0; i<totalFruit2; i++)
        {
            if( (tx1>=(tx5[i]-7)&&tx1<=(tx5[i]+7)) && (ty1>=(ty5[i]-7)&&ty1<=(ty5[i]+7)) )
            {
                if(x5eat[i]==false)
                {
                    score+=10;
                }
                x5eat[i]=true;
            }
        }
            if( (tx1>=(tx6-15)&&tx1<=(tx6+15)) && (ty1>=(ty6-15)&&ty1<=(ty6+15)) )
            {
            level2=false;
            levelGameOver=true;
            playDeath();
            }
            else if( (tx1>=(tx7-15)&&tx1<=(tx7+15)) && (ty1>=(ty7-15)&&ty1<=(ty7+15)) )
            {
            level2=false;
            levelGameOver=true;
            playDeath();
            }
            else if( (tx1>=(tx8-15)&&tx1<=(tx8+15)) && (ty1>=(ty8-15)&&ty1<=(ty8+15)) )
            {
            level2=false;
            levelGameOver=true;
            playDeath();
            }
            else if( (tx1>=(tx9-15)&&tx1<=(tx9+15)) && (ty1>=(ty9-15)&&ty1<=(ty9+15)) )
            {
            level2=false;
            levelGameOver=true;
            playDeath();
            }
            else if( (tx1>=(tx10-15)&&tx1<=(tx10+15)) && (ty1>=(ty10-15)&&ty1<=(ty10+15)) )
            {
            level2=false;
            levelGameOver=true;
            playDeath();
            }
            else if( (tx1>=(tx11-15)&&tx1<=(tx11+15)) && (ty1>=(ty11-15)&&ty1<=(ty11+15)) )
            {
            level2=false;
            levelGameOver=true;
            playDeath();
            }
            else if( (tx1>=(tx12-15)&&tx1<=(tx12+15)) && (ty1>=(ty12-15)&&ty1<=(ty12+15)) )
            {
            level2=false;
            levelGameOver=true;
            playDeath();
            }
        }
        System.out.println("x : "+tx1+" | y : "+ty1);
    }
    public void playDeath()
    {
        try
        {
            p1.stop();
            InputStream in = getClass().getResourceAsStream("/ghost.wav");
            Player p2=Manager.createPlayer(in, "audio/x-wav");
            p2.start();
            Thread.currentThread().sleep(1000);
        }
        catch(Exception err)
        {
        }
    }
}
