package July_2.copy1;

/**
 * @PACKAGE_NAME: July_2.copy1
 * @NAME: Cline
 * @date: 2020/7/2 15:10 周四
 * @author: heqinz
 */
public class Cline {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype p1 = new Prototype("张三");
        p1.setAddress(new Address("陕西","西安"));
        p1.setName("张三");

        Prototype p2 = (Prototype) p1.clone();
        p2.setName("李四");
        p2.getAddress().setProvince("北京");
        System.out.println(p2.getName() + p2.getAddress().getProvince());
        System.out.println(p1.getName() + p1.getAddress().getProvince());
    }
}
