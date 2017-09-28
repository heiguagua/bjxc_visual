package com.chinawiserv.dsp.dir.enums.catalog;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dataset {

    /** 资源目录状态 */
    public enum DatasetStatus{

        /** 待注册 */
        UnRegister("0", "待注册"),

        /** 待审核 */
        UnAudit("1", "待审核"),

        /** 审核不通过 */
        AuditFail("2", "审核不通过"),

        /** 待发布 */
        UnRelease("3", "待发布"),

        /** 驳回审核 */
        AuditReject("4", "驳回审核"),

        /** 已发布 */
        Released("5", "已发布"),

        /** 已下架 */
        Offshelf("6", "已下架");

        /** 主键 */
        private final String key;

        /** 描述 */
        private final String desc;


        DatasetStatus(final String key, final String desc) {
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
            for(DatasetStatus item : DatasetStatus.values()){
                Map<String,Object> map = new HashMap<>();
                map.put("id",item.getKey());
                map.put("text",item.getDesc());
                resultList.add(map);
            }
            return resultList;
        }
    }


    /** 发布类型 */
    public enum PublishType{

        /** 发布到互联网 */
        ToNet("1", "发布到互联网"),

        /** 发布到电子政务外网 */
        ToDzzw("2", "发布到电子政务外网"),

        /** 同时发布 */
        ToAll("3", "同时发布");

        /** 主键 */
        private final String key;

        /** 描述 */
        private final String desc;


        PublishType(final String key, final String desc) {
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
            for(PublishType item : PublishType.values()){
                Map<String,Object> map = new HashMap<>();
                map.put("id",item.getKey());
                map.put("text",item.getDesc());
                resultList.add(map);
            }
            return resultList;
        }
    }


}
