package July_9;

/**
 * @PACKAGE_NAME: July_9
 * @NAME: Strip
 * @date: 2020/7/9 9:38 周四
 * @author: heqinz
 */

//长图形
public class Strip extends Block{
    private final int w = 4,h = 1;
    Strip(){
        super();
        bk = new int[h][w];
        kb = new int[w][h];

        for(int i = 0; i < w;i++){
            bk[h -1][i] = 1;
            kb[i][h - 1] = 1;
        }
    }

    public void Turn(){
        if(type == 0){
            type = 1;
        }else {
            type = 0;
        }
    }
}
