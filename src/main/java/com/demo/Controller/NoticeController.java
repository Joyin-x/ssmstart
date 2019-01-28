package com.demo.Controller;

import com.demo.domain.Notice;
import com.demo.service.notice.noticeService;
import com.demo.util.ServerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.UUID;


/**
 * @author wwx
 * @date 2019/1/26 17:00
 **/
@Controller
@RequestMapping("/notice")
public class NoticeController {
    private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

    @Autowired
    private noticeService service;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
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

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<Notice> getNoticeDetail(int id) {
        Notice detail = service.getNoticeDetail(id);
        if (detail != null) {
            return ServerResponse.createBySuccess("查询成功", detail);
        } else {
            return ServerResponse.createByError("查询失败");
        }
    }

    @RequestMapping(value = "/addImage",method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public String upload(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file)throws IOException{
        request.setCharacterEncoding("UTF-8");
        String user = request.getParameter("user");
        System.out.println("user:"+user);
        System.out.println(file);
        if(!file.isEmpty()) {
            System.out.println("成功获取图片");

            //获取文件上传的原名
            String fileName=file.getOriginalFilename();
            //存放图片目录，上传图片类型
            String path=null;
            String type=null;

            type=fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            System.out.println("图片初始名称为：" + fileName + " 类型为：" + type);
            if(type!=null){
                if ("JPEG".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                    // 项目在服务器中实际发布运行的根路径
                    String realPath = request.getSession().getServletContext().getRealPath("/");
                    // 自定义保存的图片名称
                    String trueFileName = UUID.randomUUID() + fileName;
                    // 设置存放图片文件的路径
                   //path = realPath + "/uploads/" + trueFileName;
                    path="E:/image/"+trueFileName;
                    System.out.println("存放图片文件的路径:" + path);
                    file.transferTo(new File(path));
                }else {
                    System.out.println("不是我们想要的文件类型,请按要求重新上传");
                    return "error";
                }
            }
        }
        return "哈哈";
    }
}
