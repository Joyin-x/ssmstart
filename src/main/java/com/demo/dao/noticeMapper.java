package com.demo.dao;

import com.demo.domain.Image;
import com.demo.domain.notice.Discuss;
import com.demo.domain.notice.Like;
import com.demo.domain.notice.Notice;
import com.demo.domain.notice.noticeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据id查询公告消息
     * */
    Notice getNoticeDetail(int id);

    /**
     * 测试图片上传
     * */
    void addImage(Image image);

    /**
     * 员工发布新公告*/
    int addNotice(noticeVo notice);


    /**
     * 添加评论
     * */
    int addDiscuss(Discuss discuss);

    /**
     * 获取评论*/
    List<Map<String,Object>> getDiscuss(int id);

    /**
     * 查询员工是否点赞该文章
     * */
    int checkLike(Like like);
    /**
     * 添加用户点赞到数据库
     * */
     int addLike(Like like);
     /**
      * 删除用户点赞
      * */
     int deleteLike(Like like);
    /**
     * 评论点赞
     * */
    int likeArticle(Like like);

}
