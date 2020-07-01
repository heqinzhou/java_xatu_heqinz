package July_1;

/**
 * @PACKAGE_NAME: July_1
 * @NAME: CountDemo
 * @date: 2020/7/1 10:07 周三
 * @author: heqinz
 */
public class CountDemo {
    private static long timeStamp = System.currentTimeMillis();

    private static long limitCount = 100;

    private static long interval = 1000;

     private static long reqCount = 0;

     public static boolean grant(){
         long now = System.currentTimeMillis();
         if(now < timeStamp + interval){
             if(reqCount < limitCount){
                 ++ reqCount;
                 return true;
             }else {
                 return false;
             }
         }else {
             timeStamp = System.currentTimeMillis();
             reqCount = 0;
             return false;
         }
     }

    public static void main(String[] args) {

        for (int i = 0; i < 101; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if(grant()){
                        System.out.println("业务正常");
                    }else {
                        System.out.println("限流");
                    }
                }
            }).start();
        }
    }
}
