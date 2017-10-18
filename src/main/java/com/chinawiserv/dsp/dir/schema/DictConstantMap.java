package com.chinawiserv.dsp.dir.schema;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lianrongfa on 2017/10/17.
 */
public class DictConstantMap {
    private static Map<String,String> map=new HashMap<>();
    private static Lock lock=new ReentrantLock();
    public static String getDictCode(String key){
        if(!StringUtils.isEmpty(key)){
            if(map.containsKey(key)){
                return map.get(key);
            }else{
                return "";
            }
        }
        return "";
    }

    public static void putKeyValue(String key,String value){
        if(!StringUtils.isEmpty(key)){
            try {
                lock.lock();
                map.put(key,value);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
