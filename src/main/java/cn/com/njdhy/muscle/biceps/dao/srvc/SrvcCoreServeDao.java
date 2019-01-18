package cn.com.njdhy.muscle.biceps.dao.srvc;

import cn.com.njdhy.muscle.biceps.dao.BaseDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcCoreServe;

import java.util.List;

/**
 * @author rain
 * @description
 * @date 2019/1/16 9:54
 */
public interface SrvcCoreServeDao extends BaseDao<SrvcCoreServe> {

    /**
     * 更加公司id查询核心模块做首页展示
     * @param companyId
     * @return
     */
    List<SrvcCoreServe> selectByCompanyId(Integer companyId);
}
