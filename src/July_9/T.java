package July_9;

import java.util.Random;

/**
 * @PACKAGE_NAME: July_9
 * @NAME: T
 * @date: 2020/7/9 10:19 周四
 * @author: heqinz
 */
public class T  extends Block{
    private final int w = 3,h = 2;
    T(){
        super();
        bk = new int[h][w];
        kb = new int[w][h];
        T(type);
    }

    private void T(int type){
        Random random =new Random();
        if(type==0)
        {
            if(random.nextInt(2)==0)
                bk[0][1]=bk[1][0]=bk[1][1]=bk[1][2]=1;
            else
                bk[1][1]=bk[0][0]=bk[0][1]=bk[0][2]=1;
        }
        else
        {
            if(random.nextInt(2)==0)
                kb[1][0]=kb[0][1]=kb[1][1]=kb[2][1]=1;
            else
                kb[1][1]=kb[0][0]=kb[1][0]=kb[2][0]=1;
        }
    }
    public void Turn(){
        if(type == 0){
            for(int i = 0;i < w ; i++){
                for (int j = 0; j < h; j++) {
                    kb[j][h - i - 1] = bk[i][j];
                }
            }
        }else {
            for(int i = 0;i < w ; i++){
                for (int j = 0; j < h; j++) {
                    bk[j][w - i - 1] = kb[i][j];
                }
            }
        }
    }

}
