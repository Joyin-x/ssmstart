package com.demo.dao;

import com.demo.domain.mobilize.MobilizeRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wwx
 * @date 2019/2/14 9:45
 **/
@Mapper
public interface mobilizeMapper {
    /**
     * 返回工作调动记录
     * */
    public List<MobilizeRecord> getAllMobilize();

}
