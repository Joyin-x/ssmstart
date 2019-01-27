package com.demo.Controller;


import com.demo.domain.Notice;
import com.demo.service.notice.noticeService;
import com.demo.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;



/**
 * @author wwx
 * @date 2019/1/26 17:00
 **/
@Controller
@RequestMapping("/notice")
public class NoticeController {

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

    @RequestMapping(value = "/addImage")
    @ResponseBody
    public String upload(HttpServletRequest request, HttpServletResponse response) throws Exception{

        return "success";
    }
}
