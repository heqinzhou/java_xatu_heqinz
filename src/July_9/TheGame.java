package July_9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * @PACKAGE_NAME: July_9
 * @NAME: TheGame
 * @date: 2020/7/9 10:33 周四
 * @author: heqinz
 */
public class TheGame extends JPanel implements Runnable {

    private int score;//游戏得分
    private int speed;//方块下落速度
    private int MAX_blockheight;//方块堆积的最大高度
    private final int widht=10,height=20,size=30;//面板宽度，高度和大小
    private final int[][] board;//游戏面板
    private Block[] block;//游戏运行时的方块
    private boolean isgameover,iscontinue;//游戏是否结束，游戏是否继续

    TheGame()
    {
        board=new int[height][widht];
        block=new Block[2];//定义两个方块，一个运行，另一个预览
        buildblock();//初始化预览个方块
        MAX_blockheight=height-1;//初始化方块堆积最大高度
        score=0;
        speed=500;
        isgameover=false;
        iscontinue=true;
        this.addKeyListener(new Move());//对面板键盘监听

    }


    public void Start()//开始方法，由按钮控制
    {
        Thread run=new Thread(this);
        run.start();//创建线程1，游戏开始
    }

    public void setcontinue(boolean b) //设置是否继续游戏
    {
        iscontinue=b;
    }

    //游戏运行线程
    public void run()
    {
        do
        {
            passblock();//将预览方块传递给运行方块
            buildblock();//新建预览方块
            PaintNext();//显示预览方块
            createblock();//在面板产生方块
            while(!collideD())//碰撞检测
            {
                makeDown();	//方块下落方法

                try {
                    Thread.sleep(speed);//挂起线程，控制方块速度
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(!iscontinue)//若不继续，挂起该线程直到点击继续
                {

                    Threadt t=new Threadt();
                    synchronized(t)
                    {
                        try
                        {
                            t.start();
                            t.wait();
                        }catch(InterruptedException e) {}
                    }
                }
            }
            create_stable_block();//方块无法下落，固定方块
            setMax_ofblockheight();//记录方块堆积的最高高度
            score();//计分方法
            destoryblock();//销毁方块

        }while(!gameover());//检测游戏是否结束

        repaint();
    }


    private void PaintNext() //显示预览方块方法
    {
        new Nextb(block[1].getBlock(block[1].getType()));//将预览方块数组传递给预览面板类构造对象
        newtetris.menu.repaint();//刷新菜单面板
    }

    private void create_stable_block() //固定方块方法
    {
        for(int bi=block[0].getY();bi<block[0].getY()+block[0].getheigth();bi++)
            for(int bj=block[0].getX();bj<block[0].getX()+block[0].getwidth();bj++)
                if(board[bi][bj]==1)
                    board[bi][bj]=2;
    }

    private void destoryblock() //销毁方块方法
    {
        block[0]=null;
        System.gc();
    }

    private void setMax_ofblockheight() //设置方块堆积的最高点
    {
        if(block[0].getY()<MAX_blockheight)
            MAX_blockheight=block[0].getY();
    }

    private void score() //计分方法
    {
        int n;
        for(int i=height-1;i>=MAX_blockheight;i--)
        {
            n=0;//计算这行方块数

            for(int j=0;j<widht;j++)
            {
                if(board[i][j]==0)
                    break;
                else
                    n++;
            }

            if(n==widht)//判断这行是否布满方块
            {
                enLine(i);//消去这行
                score++;
                newtetris.score.setText(""+score);
                i+=1;
            }
        }
    }

    //消行方法
    private void enLine(int x)
    {
        for(int i=x;i>=MAX_blockheight;i--)
            for(int j=0;j<widht;j++)
                board[i][j]=board[i-1][j];

        MAX_blockheight+=1;
    }

    private boolean gameover() //判断游戏是否结束方法
    {
        if(MAX_blockheight<=3)
        {
            isgameover=true;
            return true;
        }
        return false;
    }

    private boolean collideD() //下落碰撞检测
    {
        if(block[0].getY()+block[0].getheigth()>=height)//检测是否最低点
            return true;

        //检测下方是否有方块
        for(int i=block[0].getY()+block[0].getheigth()-1;i>=0;i--)
            for(int j=block[0].getX()+block[0].getwidth()-1;j>=0;j--)
                if(board[i][j]==1&&board[i+1][j]==2)
                    return true;
        return false;
    }

    private void makeDown() //下降方法
    {

        erasureblock();//擦除原方块
        block[0].Down();//改变y值使下降
        createblock();//产生新方块
        repaint();
    }

    //在新坐标上产生一个方块
    private void createblock()
    {
        for(int bi=block[0].getY(),i=0;i<block[0].getheigth();i++,bi++)
            for(int bj=block[0].getX(),j=0;j<block[0].getwidth();j++,bj++)
                if(board[bi][bj]==0&&block[0].getBlock(block[0].getType())[i][j]==1)
                    board[bi][bj]=block[0].getBlock(block[0].getType())[i][j];
    }

    //擦除原来坐标上的方块
    private void erasureblock()
    {
        for(int bi=block[0].getY();bi<block[0].getY()+block[0].getheigth();bi++)
            for(int bj=block[0].getX();bj<block[0].getX()+block[0].getwidth();bj++)
                if(board[bi][bj]==1)
                    board[bi][bj]=0;


    }

    private void passblock() //将预览方块传给运行方块方法
    {
        block[0]=block[1];

    }

    private void buildblock() //创建预览方块方法
    {
        Random r=new Random();
        switch(r.nextInt(7))//随机创建七种方块
        {
            case 0:block[1]=new Strip();break;
            case 1:block[1]=new Square();break;
            case 2:block[1]=new Z1();break;
            case 3:block[1]=new Z2();break;
            case 4:block[1]=new T();break;
            case 5:block[1]=new L1();break;
            case 6:block[1]=new L2();break;

        }


    }


    public void makeTurn() //旋转方法
    {
        erasureblock();//擦除原方块
        block[0].Turn();//调用方块的旋转方法
        createblock();//产生新方块
        repaint();
    }

    public boolean collideT() //旋转碰撞检测
    {

        for(int bi=block[0].getY()+block[0].getwidth()-1;bi>=block[0].getY();bi--)
            for(int bj=block[0].getX()+block[0].getheigth()-1;bj>=block[0].getX();bj--)
                if(board[bi][bj]==2)
                    return true;

        return false;
    }

    public void makeRight() //右移方法
    {
        erasureblock();//擦除原方块
        block[0].Right();//调用方块的右移方法
        createblock();//产生新方块
        repaint();
    }

    public boolean collideR() //右移碰撞检测
    {
        if(block[0].getX()+block[0].getwidth()>=widht)
            return true;

        for(int bj=block[0].getX()+block[0].getwidth()-1;bj>=block[0].getX();bj--)
            for(int bi=block[0].getY();bi<block[0].getY()+block[0].getheigth();bi++)
                if(board[bi][bj]==1&&board[bi][bj+1]==2)
                    return true;

        return false;
    }

    public void makeLeft() //左移方法
    {
        //和前面一样，不写了
        erasureblock();
        block[0].Left();
        createblock();
        repaint();
    }

    public boolean collideL() //左移碰撞检测
    {
        if(block[0].getX()<=0)//是否在最左端
            return true;

        //左边是否有方块
        for(int bj=block[0].getX();bj<block[0].getX()+block[0].getwidth();bj++)
            for(int bi=block[0].getY();bi<block[0].getY()+block[0].getheigth();bi++)
                if(board[bi][bj]==1&&board[bi][bj-1]==2)
                    return true;

        return false;
    }

    class Threadt extends Thread
    {
        public void run()//线程2，用来启动线程1
        {
            synchronized(this)
            {
                while(true)
                {
                    try
                    {
                        Thread.sleep(1000);
                    } catch (Exception e) {}

                    if(iscontinue)//游戏是否继续
                    {
                        this.notify();
                        break;
                    }
                }
            }
        }
    }


    class Move extends KeyAdapter//键盘适配器
    {

        public void keyReleased(KeyEvent e)
        {

            if(e.getKeyCode()==KeyEvent.VK_DOWN)//释放下键，速度变慢
            {
                if(speed==50)
                    speed=500;
            }
        }

        public void keyPressed(KeyEvent e)
        {
            if(e.getKeyCode()==KeyEvent.VK_LEFT)//按下左键触发事件
            {
                if(!collideL())//是否可以左移
                    makeLeft();//左移方法
            }
            //以下同上
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                if(!collideR())
                    makeRight();
            }
            else if (e.getKeyCode() == KeyEvent.VK_UP)
            {
                if(!collideT())
                    makeTurn();
            }
            else if(e.getKeyCode()==KeyEvent.VK_DOWN)
            {
                speed=50;
            }
        }
    }

    public void paintComponent(Graphics g)//绘制面板
    {
        super.paintComponent(g);

        for(int i=0;i<height;i++)
        {
            for(int j=0;j<widht;j++)
            {
                switch(board[i][j])//三种型号对应三种颜色
                {
                    case 0:g.setColor(Color.BLACK);break;//没有方块
                    case 1:g.setColor(Color.WHITE);break;//移动中的方块
                    case 2:g.setColor(Color.GRAY);break;//已固定的方块
                }
                g.fillRect((size+1)*j+15, (size+1)*i+25, size, size);//画方块
            }
            if(i==4)//方块堆积界限
            {
                g.setColor(Color.RED);
                g.drawLine(15, (size+1)*i+25, (size+1)*10+15, (size+1)*i+25);
            }
        }

        if(isgameover)//游戏结束则打印“Game Over”
        {
            Font lose=new Font("黑体",Font.BOLD,50);
            g.setFont(lose);
            g.setColor(Color.RED);
            g.drawString("Game Over", 50, 250);
        }
    }
}
