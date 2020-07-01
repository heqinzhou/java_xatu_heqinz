package July_1.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @PACKAGE_NAME: July_1.HashMap
 * @NAME: IterateHashMapExample
 * @date: 2020/7/1 16:09 周三
 * @author: heqinz
 */

/*
使用 Iterator 遍历 HashMap EntrySet
 */
public class IterateHashMapExample {
    public static void main(String[] args) {
        Map< Integer,String> coursesMap = new HashMap<Integer, String>();
        coursesMap.put(1,"C");
        coursesMap.put(2,"C++");
        coursesMap.put(3,"java");
        coursesMap.put(4,"Python");
        coursesMap.put(5,"PHP");

        Iterator <Map.Entry< Integer ,String>> iterator = coursesMap.entrySet().iterator();

        while ((iterator.hasNext())){
            Map.Entry<Integer ,String > entry = iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }
}
