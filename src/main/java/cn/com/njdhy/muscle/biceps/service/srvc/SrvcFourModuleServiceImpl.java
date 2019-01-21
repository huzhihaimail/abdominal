package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.dao.srvc.SrvcFourModuleDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcFourModule;
import cn.com.njdhy.muscle.biceps.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 四大模块业务层实现类
 * @author rain
 * @date 2018/11/17 23:27
 **/
@Service
public class SrvcFourModuleServiceImpl extends BaseServiceImpl<SrvcFourModuleDao,SrvcFourModule> implements SrvcFourModuleService{

    @Autowired
    private SrvcFourModuleDao srvcFourModuleDao;

    @Override
    public List<SrvcFourModule> queryByCompanyId(Integer companyId) {
        return srvcFourModuleDao.queryByCompanyId(companyId);
    }
}
