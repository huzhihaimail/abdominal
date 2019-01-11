package cn.com.njdhy.muscle.biceps.service.sys;

import cn.com.njdhy.muscle.biceps.model.SysCompany;
import cn.com.njdhy.muscle.biceps.service.BaseService;

import java.util.List;

/**
 * 公司信息业务层接口
 *
 * @author rain
 * @date 2018/11/17 23:12
 **/
public interface SysCompanyService extends BaseService<SysCompany> {

    /**
     * 查询所有公司
     *
     * @return
     */
    List<SysCompany> selectAllCompany();
}
