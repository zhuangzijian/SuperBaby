package cn.zzj.mapper;

import cn.zzj.pojo.CBumen;
import cn.zzj.pojo.CBumenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CBumenMapper {
    int countByExample(CBumenExample example);

    int deleteByExample(CBumenExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CBumen record);

    int insertSelective(CBumen record);

    List<CBumen> selectByExample(CBumenExample example);

    CBumen selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CBumen record, @Param("example") CBumenExample example);

    int updateByExample(@Param("record") CBumen record, @Param("example") CBumenExample example);

    int updateByPrimaryKeySelective(CBumen record);

    int updateByPrimaryKey(CBumen record);
}