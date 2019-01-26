package com.demo.dao;

import com.demo.domain.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wwx
 * @date 2019/1/26 16:47
 **/
@Mapper
public interface noticeMapper {
    /**
     * 查询发布所有的公告信息
     * */
    List<Notice> getNoticeList();
}
