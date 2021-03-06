
package cn.com.njdhy.muscle.biceps.dao;

import cn.com.njdhy.muscle.biceps.model.SysMenu;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 菜单数据访问层接口
 *
 * @author 胡志海
 */
public interface SysMenuDao extends BaseDao<SysMenu> {

    /**
     * 根据用户授权查询系统菜单
     *
     * @param userName 查询条件（用户名）
     * @return 授权菜单列表
     */
    List<SysMenu> loadMenus(String userName);

    /**
     * 查询一级菜单和二级菜单
     *
     * @return
     */
    List<SysMenu> queryMenu();

    /**
     * 查询所有菜单
     *
     * @return 所有菜单
     */
    List<SysMenu> queryAllMenu();

    /**
     * @param map
     * @return
     */
    List<SysMenu> queryMenuForHaiHang(ConcurrentHashMap map);

    /**
     * 根据用户登录名称查询用户菜单权限
     *
     * @param loginName 登录名称
     * @return 该用户所具备的菜单权限
     */
    List<String> queryPermissionByUserName(String loginName);

    /**
     * 通过用户id查询树列表
     * @param id
     * @return
     */
    List<SysMenu> queryZtreeListByUserId(Integer id);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Integer id);
    /**
     * 更加parentId查询
     * @param id
     * @return
     */
    List<Integer> queryByParentId(Integer id);
}
