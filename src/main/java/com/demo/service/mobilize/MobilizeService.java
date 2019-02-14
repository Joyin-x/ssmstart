package com.demo.service.mobilize;

import com.demo.dao.mobilizeMapper;
import com.demo.domain.mobilize.MobilizeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wwx
 * @date 2019/2/14 9:47
 **/
@Service
public class MobilizeService {
    @Autowired
    private mobilizeMapper mapper;


    /**
     * 返回工作调动记录
     * */
    public List<MobilizeRecord> getAllMobilize(){return mapper.getAllMobilize();}

}
