package July_2.copy1;

/**
 * @PACKAGE_NAME: July_2.copy1
 * @NAME: Address
 * @date: 2020/7/2 15:05 周四
 * @author: heqinz
 */
public class Address {
    private String province; //省份
    private String city;

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address(String province,String city){
        this.province = province;
        this.city = city;
    }

}
