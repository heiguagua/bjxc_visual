package com.chinawiserv.dsp.dir.enums.apply;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class userRegister {

    public enum AuditStatus{

        /** 目录（默认） */
        AUDITED("0", "未审核"),

        /** 菜单 */
        UNAUDIT("1", "已审核");

        /** 主键 */
        private final String key;

        /** 描述 */
        private final String desc;


        AuditStatus(final String key, final String desc) {
            this.key = key;
            this.desc = desc;
        }

        public String getKey() {
            return this.key;
        }

        public String getDesc() {
            return this.desc;
        }

        /**
         * 获取枚举类型列表（转为List<Map>形式）
         * @return
         */
        public static List<Map<String,Object>> getEnumList(){
            List<Map<String,Object>> resultList = new ArrayList<>();
            for(AuditStatus item : AuditStatus.values()){
                Map<String,Object> map = new HashMap<>();
                map.put("id",item.getKey());
                map.put("text",item.getDesc());
                resultList.add(map);
            }
            return resultList;
        }
    }


}
