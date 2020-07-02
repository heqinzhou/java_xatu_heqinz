package July_2.copy1;

/**
 * @PACKAGE_NAME: July_2.copy1
 * @NAME: Prototype
 * @date: 2020/7/2 15:07 周四
 * @author: heqinz
 */
public class Prototype implements Cloneable {

    private String name;
    private  Address address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Prototype(String name){
        this.name = name;
    }

    public Object clone() throws CloneNotSupportedException {
        Prototype proto = (Prototype) super.clone();
        return proto;
    }




}
