package July_9;

import java.util.Random;

/**
 * @PACKAGE_NAME: July_9
 * @NAME: Block
 * @date: 2020/7/9 9:25 周四
 * @author: heqinz
 */

//方块类
public class Block {

    //方块坐标
    private int x,y;

    protected int type;

    protected int[][] bk;

    protected int[][] kb;

    //创建方块的坐标，类型
    protected Block(){
        Random random = new Random();
        x = random.nextInt(7);
        y = 0;
        type = random.nextInt(2);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //方块的形状，0为横，1为竖
    public int getType() {
        return type;
    }

    //获取数组宽度和高度
    public int getwidth()
    {
        return getBlock(type)[0].length;
    }

    public int getheigth()
    {
        return getBlock(type).length;
    }

    //根据类型反馈状态方法
    int[][] getBlock(int type) {
        if(type == 0){
            return bk;
        }else {
            return kb;
        }
    }

    //下降
    public void Down(){
        y ++;
    }

    //左
    public void Left(){
       x --;
    }

    //右
    public void Right(){
        x --;
    }

    //变化图形形状
    public void Turn(){
    }
}
