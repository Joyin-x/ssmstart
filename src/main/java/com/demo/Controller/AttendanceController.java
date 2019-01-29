package com.demo.Controller;

import com.demo.service.attendance.attendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wwx
 * @date 2019/1/29 15:28
 **/
@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private attendanceService service;


}
