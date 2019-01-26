package com.demo.service.notice;

import com.demo.dao.noticeMapper;
import com.demo.domain.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wwx
 * @date 2019/1/26 16:55
 **/
@Service
public class noticeService {

    @Autowired
    public noticeMapper mapper;

    /**
     * 返回所有公告信息
     * */
    public List<Notice> getNoticeList(){
        return mapper.getNoticeList();
    }
}
