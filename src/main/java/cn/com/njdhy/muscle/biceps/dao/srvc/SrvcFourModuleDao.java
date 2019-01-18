package cn.com.njdhy.muscle.biceps.dao.srvc;

import cn.com.njdhy.muscle.biceps.dao.BaseDao;
import cn.com.njdhy.muscle.biceps.model.srvc.SrvcFourModule;

import java.util.List;

/**
 * 四大模块数据访问层接口
 * @author rain
 * @date 2018/11/17 20:57
 **/
public interface SrvcFourModuleDao extends BaseDao<SrvcFourModule> {

    /**
     * 根据模块类型查询
     * @param type
     * @return
     */
    List<SrvcFourModule> queryByType(Integer type);
}
