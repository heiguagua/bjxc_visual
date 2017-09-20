package com.chinawiserv.dsp.base.enums.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zengpzh on 2017/9/20.
 */
public enum AuthObjTypeEnum {

    DEPT("1","部门数据权限"),
    USER("2","用户数据权限");

    /** 主键 */
    private final String key;

    /** 描述 */
    private final String desc;

    AuthObjTypeEnum(final String key, final String desc) {
        this.key = key;
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getKey() {
        return this.key;
    }

    public static String getDescByKey(String key){
        for(UserTypeEnum item : UserTypeEnum.values()){
            if(item.getKey().equals(key)){
                return item.getDesc();
            }
        }
        return null;
    }

    public static UserTypeEnum getEnumByKey(String key){
        for(UserTypeEnum item : UserTypeEnum.values()){
            if(item.getKey().equals(key)){
                return item;
            }
        }
        return null;
    }

    /**
     * 获取枚举类型列表（转为List<Map>形式）
     * @return
     */
    public static List<Map<String,Object>> getEnumList(){
        List<Map<String,Object>> resultList = new ArrayList<>();
        for(UserTypeEnum item : UserTypeEnum.values()){
            Map<String,Object> map = new HashMap<>();
            map.put("id",item.getKey());
            map.put("text",item.getDesc());
            resultList.add(map);
        }
        return resultList;
    }

}
