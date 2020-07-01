package July_1.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @PACKAGE_NAME: July_1.HashMap
 * @NAME: IterateHashMapExample_03
 * @date: 2020/7/1 16:20 周三
 * @author: heqinz
 */

/*
使用 Lambda 表达式遍历 HashMap
 */
public class IterateHashMapExample_03 {
    public static void main(String[] args) {
        Map< Integer,String> coursesMap = new HashMap<Integer, String>();
        coursesMap.put(1,"C");
        coursesMap.put(2,"C++");
        coursesMap.put(3,"java");
        coursesMap.put(4,"Python");
        coursesMap.put(5,"PHP");

       coursesMap.forEach((key,value) ->{
           System.out.println(key);
           System.out.println(value);
       });
    }
}

