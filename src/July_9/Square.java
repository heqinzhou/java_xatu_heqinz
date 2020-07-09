package July_9;

/**
 * @PACKAGE_NAME: July_9
 * @NAME: Square
 * @date: 2020/7/9 9:45 周四
 * @author: heqinz
 */

//正方形类
public class Square extends Block{
    private final int w = 2,h = 2;
    Square(){
        super();
        bk = new int[h][w];
        kb = new int[w][h];

        for(int i = 0; i < w;i++){
            for(int j = 0;j < h;j++ ){
                bk[i][j] = 1;
                kb[j][i] = 1;
            }
        }
    }
}
