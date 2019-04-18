package com.demo.Controller;

import com.demo.domain.department.Department;
import com.demo.domain.wage.Reward;
import com.demo.domain.wage.Wage;
import com.demo.service.money.moneyService;
import com.demo.util.Base.ResponseCode;
import com.demo.util.Base.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * @Author: 千城暮雪
 * @DATE： 2019/4/5 13:08
 * @Version 1.0.0
 */
@ResponseBody
@Controller
@RequestMapping("/money")
public class MoneyController {

    @Autowired
    private moneyService service;

    /**
     * 查找该部门的底薪信息
     */
    @RequestMapping("/selectDepartment")
    public ServerResponse selectDepartment(int id) {
        ServerResponse response = new ServerResponse();
        Map<String, Object> result = service.selectDepartment(id);
        response.setStatus(ResponseCode.SUCCESS);
        response.setData(result);
        return response;
    }

    /**
     * 更新该部门底薪
     */
    @RequestMapping(value = "/updateBasicSalary", method = RequestMethod.POST)
    public ServerResponse updateBasicSalary(@RequestBody Department department) {
        ServerResponse response = new ServerResponse();
        int result = service.updateBasicSalary(department);
        if (result == 1) {
            response.setStatus(ResponseCode.SUCCESS);
            response.setData(result);
        }
        return response;
    }

    /**
     * 增加奖惩记录
     */
    @RequestMapping(value = "/addReward", method = RequestMethod.POST)
    public ServerResponse addReward(@RequestBody Reward reward) {
        ServerResponse response = new ServerResponse();
        int result = service.addReward(reward);
        if (result == 1) {
            response.setStatus(ResponseCode.SUCCESS);
        }
        return response;
    }

    /**
     * 查看出勤天数
     */
    @RequestMapping(value = "/countAttendance")
    public ServerResponse countAttendance(int id) {
        ServerResponse response = new ServerResponse();
        int result = service.countAttendance(id);
        if (result > 0) {
            response.setStatus(ResponseCode.SUCCESS);
            response.setData(result);
        } else {
            response.setStatus(ResponseCode.SUCCESS);
            response.setData(0);
        }
        return response;
    }

    /**
     * 按部门发送员工工资
     */
    @RequestMapping(value = "/payMoney")
    @Transactional
    public ServerResponse payMoney(int id) {
        ServerResponse response = new ServerResponse();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        String first = format.format(cal.getTime());
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        String end = format.format(cal.getTime());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String now = df.format(new Date());
        /**
         * 1.根据id查找到所有的员工列表
         * 2.循环这个员工列表，查找部门底薪，奖惩，加班费，加到数组中
         * 3.循环执行这个数组，添加到数据库中*/
        List<Map<String, Integer>> employeeList = service.selectEmployeeID(id);
        int checkWage = service.checkWage(employeeList.get(0).get("employeeId"));
        //工资未发放
        if(checkWage<1){
            List<Wage> wages = new ArrayList<>();
            for (int i = 0; i < employeeList.size(); i++) {
                Wage example = new Wage();
                //查找员工id
                int employeeId = employeeList.get(i).get("employeeId");
                //查找部门底薪
                int baseSalary = service.selectBasicSalary(id);
                //查询本月员工出勤天数
                int attendances = service.countAttendance(employeeId);
                //查找奖惩
                int reward = 0;
                List<Map<String, Integer>> rewards = service.selectRewards(employeeId);
                for (int j = 0; j < rewards.size(); j++) {
                    reward = rewards.get(j).get("money") + reward;
                }
                //查找加班费
                int days = service.selectOverTime(employeeId) * 60;
                example.setBasicSalsry((baseSalary * attendances) / 30);
                example.setEmployeeId(employeeId);
                example.setBonus(reward);
                example.setOvertimePay(days);
                example.setNetPayroll((baseSalary * attendances) / 30 + reward + days);
                example.setStartTime(first);
                example.setEndTime(end);
                example.setPayDate(now);
                wages.add(example);
            }
            int result = service.addWage(wages);
            if (result > 0) {
                response.setStatus(ResponseCode.SUCCESS);
                List<Map<String, Object>> wageList = service.getWageList(id);
                response.setData(wageList);
            }
        }
        else{
            response.setStatus(ResponseCode.PAY_MONEY);
            List<Map<String, Object>> wageList = service.getWageList(id);
            response.setData(wageList);
        }
        return response;
    }

    /**
     * 按部门查找员工工资列表
     */
    @RequestMapping(value = "/getWageList")
    @Transactional
    public ServerResponse getWageList(int id) {
        ServerResponse response = new ServerResponse();
        List<Map<String, Object>> wageList = service.getWageList(id);
        if (wageList.size() > 0) {
            response.setStatus(ResponseCode.SUCCESS);
            response.setData(wageList);
        }
        return response;
    }

}
