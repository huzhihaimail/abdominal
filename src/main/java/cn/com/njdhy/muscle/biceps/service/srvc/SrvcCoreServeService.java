package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.model.srvc.SrvcCoreServe;
import cn.com.njdhy.muscle.biceps.service.BaseService;

import java.util.List;

/**
 * @author rain
 * @description
 * @date 2019/1/16 10:40
 */
public interface SrvcCoreServeService extends BaseService<SrvcCoreServe> {

    /**
     * 更加公司id查询核心模块做首页展示
     * @param companyId
     * @return
     */
    List<SrvcCoreServe> selectByCompanyId(Integer companyId);
}
