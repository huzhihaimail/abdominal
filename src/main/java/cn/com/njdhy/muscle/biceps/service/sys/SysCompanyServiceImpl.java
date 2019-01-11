package cn.com.njdhy.muscle.biceps.service.sys;

import cn.com.njdhy.muscle.biceps.dao.SysCompanyDao;
import cn.com.njdhy.muscle.biceps.dao.srvc.SrvcDesignerDao;
import cn.com.njdhy.muscle.biceps.model.SysCompany;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcDesigner;
import cn.com.njdhy.muscle.biceps.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 公司信息业务层实现类
 * @author rain
 * @date 2018/11/17 23:14
 **/
@Service
public class SysCompanyServiceImpl extends BaseServiceImpl<SysCompanyDao,SysCompany> implements SysCompanyService {

    @Autowired
    private SysCompanyDao sysCompanyDao;

}
