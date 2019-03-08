package cn.cqupt.lq.zy.pri.servic;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cqupt.lq.zy.pri.vo.History;

public interface Historyservice {
    //增加历史记录
   public int addhistory(@Param("History")History history);
    //显示历史记录
   public List<History> showHisotory();
}
