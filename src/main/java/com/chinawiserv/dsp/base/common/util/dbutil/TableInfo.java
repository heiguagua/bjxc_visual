package com.chinawiserv.dsp.base.common.util.dbutil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiest on 2015/10/23.
 */
public class TableInfo {
    public String remarks;
    public String tableCat;
    public String tableName;
    public String tableType;
    public List<CloumnInfo> cloumnBeanList;

    public int getClomunNum(){
        if (cloumnBeanList != null) {
            return cloumnBeanList.size();
        }else {
            return 0;
        }
    }
    public List<String> getCloumnNameList(){
        List<String> cloLists = new ArrayList<String>();
        try {
            if(cloumnBeanList != null) {
                for (CloumnInfo temp : cloumnBeanList) {
                    cloLists.add(temp.columnName);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  cloLists;
    }

}
