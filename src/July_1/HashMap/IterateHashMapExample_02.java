package July_1.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @PACKAGE_NAME: July_1.HashMap
 * @NAME: IterateHashMapExample_02
 * @date: 2020/7/1 16:19 周三
 * @author: heqinz
 */

/*
使用 For-each 循环遍历 HashMap
 */
public class IterateHashMapExample_02 {
    public static void main(String[] args) {
        Map< Integer,String> coursesMap = new HashMap<Integer, String>();
        coursesMap.put(1,"C");
        coursesMap.put(2,"C++");
        coursesMap.put(3,"java");
        coursesMap.put(4,"Python");
        coursesMap.put(5,"PHP");

      for(Map.Entry<Integer,String> entry : coursesMap.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }
}
