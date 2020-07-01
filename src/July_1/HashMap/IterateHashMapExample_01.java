package July_1.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @PACKAGE_NAME: July_1.HashMap
 * @NAME: IterateHashMapExample_01
 * @date: 2020/7/1 16:17 周三
 * @author: heqinz
 */

/*
使用 Iterator 遍历 HashMap KeySet
 */
public class IterateHashMapExample_01 {
    public static void main(String[] args) {
        Map< Integer,String> coursesMap = new HashMap<Integer, String>();
        coursesMap.put(1,"C");
        coursesMap.put(2,"C++");
        coursesMap.put(3,"java");
        coursesMap.put(4,"Python");
        coursesMap.put(5,"PHP");

        Iterator<Integer> iterator = coursesMap.keySet().iterator();

        while ((iterator.hasNext())){
            Integer key = iterator.next();
            System.out.println(key);
            System.out.println(coursesMap.get(key));
        }

    }
}
