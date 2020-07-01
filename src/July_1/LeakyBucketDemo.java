package July_1;

/**
 * @PACKAGE_NAME: July_1
 * @NAME: LeakyBucketDemo
 * @date: 2020/7/1 10:28 周三
 * @author: heqinz
 */
public class LeakyBucketDemo {
    private static long time = System.currentTimeMillis();
    private static int water = 0;
    private static int size = 10;
    private static int rate = 3;

    public static boolean grant(){
        long now = System.currentTimeMillis();
        int out = (int) ((now - time) / 700 * rate);
        water = Math.max(0,water - out);

        time = out;
        if((water + 1) < size){
            ++ water;
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 103; i++) {
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

