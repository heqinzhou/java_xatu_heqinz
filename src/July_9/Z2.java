package July_9;

/**
 * @PACKAGE_NAME: July_9
 * @NAME: Z2
 * @date: 2020/7/9 10:16 周四
 * @author: heqinz
 */
public class Z2 extends Block{
    private final int w = 3,h = 2;
    Z2(){
        super();
        bk = new int[h][w];
        kb = new int[w][h];
        bk[0][2] = bk[0][1] = bk[1][1] = bk[1][0] = 1;
        kb[0][0] = kb[1][0] = kb[1][1] = kb[2][1] = 1;
    }
    public void Turn(){
        if(type == 0){
            type = 1;
        }else {
            type = 0;
        }
    }
}
