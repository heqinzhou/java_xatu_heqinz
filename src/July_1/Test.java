package July_1;

/**
 * @PACKAGE_NAME: July_1
 * @NAME: Test
 * @date: 2020/7/1 10:52 周三
 * @author: heqinz
 */
public class Test {
    private static long time = System.currentTimeMillis();
    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            long time1 = System.currentTimeMillis();
            System.out.println(time - time1);
        }
    }
}
