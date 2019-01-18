package cn.com.njdhy.muscle.biceps.service.srvc;

import cn.com.njdhy.muscle.biceps.model.srvc.SrvcFourModule;
import cn.com.njdhy.muscle.biceps.service.BaseService;

import java.util.List;

/**
 * @author rain
 * @description
 * @date 2019/1/17 15:42
 */
public interface SrvcFourModuleService extends BaseService<SrvcFourModule> {

    /**
     * 根据模块类型查询
     *
     * @param type
     * @return
     */
    List<SrvcFourModule> queryByType(Integer type);
}
