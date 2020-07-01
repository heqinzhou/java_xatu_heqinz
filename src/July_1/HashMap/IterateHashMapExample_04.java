package July_1.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @PACKAGE_NAME: July_1.HashMap
 * @NAME: IterateHashMapExample_04
 * @date: 2020/7/1 16:23 周三
 * @author: heqinz
 */

/*
使用 Stream API 遍历 HashMap
 */
public class IterateHashMapExample_04 {
    public static void main(String[] args) {
        Map< Integer,String> coursesMap = new HashMap<Integer, String>();
        coursesMap.put(1,"C");
        coursesMap.put(2,"C++");
        coursesMap.put(3,"java");
        coursesMap.put(4,"Python");
        coursesMap.put(5,"PHP");
        coursesMap.entrySet().stream().forEach((entry) ->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });
    }
}
