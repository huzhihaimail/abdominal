
package cn.com.njdhy.muscle.biceps.dao;

import cn.com.njdhy.muscle.biceps.model.SysCompany;

import java.util.List;

/**
 * <类功能简述> 用户管理数据访问层接口
 *
 * @author 胡志海
 */
public interface SysCompanyDao extends BaseDao<SysCompany> {

    /**
     * 查询所有公司
     *
     * @return
     */
    List<SysCompany> selectAllCompany();
}
