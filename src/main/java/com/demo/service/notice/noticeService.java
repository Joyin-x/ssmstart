package com.demo.service.notice;

import com.demo.dao.noticeMapper;
import com.demo.domain.Image;
import com.demo.domain.notice.Discuss;
import com.demo.domain.notice.Like;
import com.demo.domain.notice.Notice;
import com.demo.domain.notice.noticeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据id返回对应的公告消息
     * */
    public Notice getNoticeDetail(int id){return mapper.getNoticeDetail(id);}

    /**
     * 测试图片上传
     * */
    public void addImage(Image image){mapper.addImage(image);}

    /**
     * 员工发布新公告*/
    public int addNotice(noticeVo notice){return mapper.addNotice(notice);}

    /**
     * 添加评论
     * */
    public int addDiscuss(Discuss discuss){return mapper.addDiscuss(discuss);}

    /**
     * 获取评论*/
    public List<Map<String,Object>> getDiscuss(int id){return mapper.getDiscuss(id);}

    /**
     * 查询员工是否点赞该文章
     * */
    public int checkLike(Like like){return mapper.checkLike(like);}

    /**
     * 添加用户点赞到数据库
     * */
    public int addLike(Like like){return mapper.addLike(like);}

    /**
     * 删除用户点赞
     * */
    public int deleteLike(Like like){return mapper.deleteLike(like);}

    /**
     * 为文章评论点赞
     * */
    public int likeArticle(Like like){return mapper.likeArticle(like);}
}
