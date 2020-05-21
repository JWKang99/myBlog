package com.kang.blog.utils;

import java.util.ArrayList;
import java.util.List;

public class String2List {
    //把ids字符串转换为集合,   1,2,3->[1,2,3]
    public static List<Long> convertToList(String ids){
        List<Long> list = new ArrayList<>();
        if(!"".equals(ids) && ids!=null){
            String[] idArray = ids.split(",");
            for(int i=0;i<idArray.length;i++){
                list.add(new Long(idArray[i]));
            }
        }
        return list;
    }
}
