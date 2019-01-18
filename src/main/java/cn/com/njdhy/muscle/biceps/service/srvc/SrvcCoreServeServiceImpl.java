package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.dao.srvc.SrvcCoreServeDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcCoreServe;
import cn.com.njdhy.muscle.biceps.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rain
 * @description
 * @date 2019/1/16 10:41
 */
@Service
public class SrvcCoreServeServiceImpl extends BaseServiceImpl<SrvcCoreServeDao, SrvcCoreServe> implements SrvcCoreServeService {

    @Autowired
    private SrvcCoreServeDao srvcCoreServeDao;

    @Override
    public List<SrvcCoreServe> selectByCompanyId(Integer companyId) {
        return srvcCoreServeDao.selectByCompanyId(companyId);
    }
}
