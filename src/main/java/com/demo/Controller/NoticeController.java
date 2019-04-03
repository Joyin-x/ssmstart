package com.demo.Controller;

import com.demo.domain.Image;
import com.demo.domain.notice.Discuss;
import com.demo.domain.notice.Like;
import com.demo.domain.notice.Notice;
import com.demo.domain.notice.noticeVo;
import com.demo.service.notice.noticeService;
import com.demo.service.task.myService;
import com.demo.util.ResponseCode;
import com.demo.util.ServerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * @author wwx
 * @date 2019/1/26 17:00
 **/
@Controller
@RequestMapping("/notice")
@ResponseBody
public class NoticeController {
    private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

    @Autowired
    private noticeService service;
    @Autowired
    private myService myService;

    /**
     * 查询所有公告信息*/
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ServerResponse<List<Notice>> getNoticeList() {
        List<Notice> list = service.getNoticeList();
        if (list.size() > 0) {
            return ServerResponse.createBySuccess("查询成功", list);
        } else if (list.size() == 0) {
            return ServerResponse.createByError("暂无公告信息");
        } else {
            return ServerResponse.createByError("查询失败");
        }
    }

    /**
     * 查询某个公告的详细内容*/
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ServerResponse<Notice> getNoticeDetail(int id) {
        Notice detail = service.getNoticeDetail(id);
        if (detail != null) {
            return ServerResponse.createBySuccess("查询成功", detail);
        } else {
            return ServerResponse.createByError("查询失败");
        }
    }

    /**
     * 新增公告信息
     * */
    @RequestMapping(value = "/addNotice",method = RequestMethod.POST)
    public ServerResponse getNoticeDetail(@RequestBody noticeVo notice) {
        ServerResponse response=new ServerResponse();
        int result=service.addNotice(notice);
        if(result==1){
            response.setStatus(ResponseCode.SUCCESS);
        }
        return response;
    }


    @RequestMapping(value = "/addImage",method = RequestMethod.POST)
    @Transactional
    public ServerResponse upload(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file)throws IOException{
        ServerResponse response=new ServerResponse();
        request.setCharacterEncoding("UTF-8");
        int userId = Integer.parseInt(request.getParameter("user"));
        if(!file.isEmpty()) {
            System.out.println("成功获取图片");
            //获取文件上传的原名
            String fileName=file.getOriginalFilename();
            fileName=fileName.substring(fileName.lastIndexOf("."));
            //存放图片目录，上传图片类型
            String path=null;
            String type=null;

            type=fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if(type!=null){
                if ("JPEG".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                    // 项目在服务器中实际发布运行的根路径
                    String realPath = request.getSession().getServletContext().getRealPath("/");
                    int index=realPath.lastIndexOf("/");
                    String str="/";//目录后面跟着的是斜杠还是反斜杠
                    if(index==-1){
                        index=realPath.lastIndexOf("\\");
                        realPath=realPath.substring(0,index);
                        index=realPath.lastIndexOf("\\");
                        realPath=realPath.substring(0,index);
                        str="\\image\\";
                    }else{
                        realPath=realPath.substring(0,index);
                        index=realPath.lastIndexOf("/");
                        realPath=realPath.substring(0,index);
                        str="/image/";
                    }
                    System.out.println(realPath);
                    // 自定义保存的图片名称
                    String trueFileName = UUID.randomUUID() +fileName;
                    // 设置存放图片文件的路径
                   path = realPath + str + trueFileName;
                    System.out.println("存放图片文件的路径:" + path);
                    file.transferTo(new File(path));
                    Image image=new Image();
                    image.setUserId(userId);
                    image.setPicture("https://weixiong.info/image/"+trueFileName);
                    System.out.println(image);
                    int result=myService.addImage(image);
                    System.out.println("result:"+result);
                    if(result==1){
                        response.setData(path);
                        response.setStatus(ResponseCode.SUCCESS);
                    }else{
                        response.setMsg("图片存储失败");
                    }
                }else {
                    response.setMsg("图片不是想要的上传类型");
                }
            }
        }else {
        response.setMsg("图片为空");
        }
        return response;
    }

    /**
     * 添加评论信息
     * */
    @RequestMapping(value = "/addDiscuss",method = RequestMethod.POST)
    public ServerResponse addDiscuss(@RequestBody Discuss discuss){
        ServerResponse response=new ServerResponse();
        int result=service.addDiscuss(discuss);
        if(result==1){
            response.setStatus(ResponseCode.SUCCESS);
        }
        return response;
    }

    @RequestMapping(value = "/getDiscuss")
    public ServerResponse getDiscuss(int id){
        ServerResponse response=new ServerResponse();
        List<Map<String,Object>> list=service.getDiscuss(id);
        if(list.size()>0){
            response.setData(list);
            response.setStatus(ResponseCode.SUCCESS);
        }
        return response;
    }

    //检查用户是否点赞
    @RequestMapping(value = "/checkLike",method = RequestMethod.POST)
    public ServerResponse checkLike(@RequestBody Like like){
        System.out.println(like);
        ServerResponse response=new ServerResponse();
        int result=service.checkLike(like);
        if(result==1){
            response.setStatus(ResponseCode.SUCCESS);
        }
        return response;
    }

    /**
     * 对文章点赞
     * */
    @RequestMapping(value = "/like",method = RequestMethod.POST)
    @Transactional
    public ServerResponse like(@RequestBody Like like){
        ServerResponse response=new ServerResponse();
        int result=service.checkLike(like);
        Like a=new Like();
        a.setArticleId(like.getArticleId());
        int result1;
        //表示已经点赞
        if(result==1){
            //更新该文章的点赞数（减1）
            a.setId(-1);
            result1=service.likeArticle(a);
            if(result1==1){
                int deleteResult=service.deleteLike(like);
                if(deleteResult==1){
                    response.setStatus(ResponseCode.SUCCESS);
                    response.setMsg("已取消点赞");
                }
            }
        }
        //表示未点赞
        else{
            //更新该文章的点赞数（加1）
            a.setId(1);
            result1=service.likeArticle(a);
            if(result1==1){
                //增加用户点赞记录
                int addResult=service.addLike(like);
                if(addResult==1){
                    response.setStatus(ResponseCode.SUCCESS);
                    response.setMsg("已点赞");
                }
            }


        }
        return response;
    }
}
