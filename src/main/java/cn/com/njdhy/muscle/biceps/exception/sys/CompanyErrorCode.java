
package cn.com.njdhy.muscle.biceps.exception.sys;

/**
 * <类功能简述> 异常码常量类
 *
 * @author 胡志海
 */
public interface CompanyErrorCode {

    /**
     * 首页
     */
    String SYS_COMPANY = "6000";


    /**
     * 新建公司系统异常
     */
    String SYS_COMPANY_SAVE_APP_ERROR_CODE = SYS_COMPANY + "1";
    String SYS_COMPANY_SAVE_APP_ERROR_MESSAGE = "新建公司出现系统异常";

    /**
     * 新建菜单根异常
     */
    String SYS_COMPANY_SAVE_ERROR_CODE = SYS_COMPANY + "2";
    String SYS_COMPANY_SAVE_ERROR_MESSAGE = "新建公司出现根异常";

    /**
     * 更新菜单系统异常
     */
    String SYS_COMPANY_UPDATE_APP_ERROR_CODE = SYS_COMPANY + "3";
    String SYS_COMPANY_UPDATE_APP_ERROR_MESSAGE = "更新公司出现系统异常";

    /**
     * 更新菜单根异常
     */
    String SYS_COMPANY_UPDATE_ERROR_CODE = SYS_COMPANY + "4";
    String SYS_COMPANY_UPDATE_ERROR_MESSAGE = "更新公司出现根异常";

    /**
     * 加载菜单系统异常
     */
    String SYS_COMPANY_SELECT_ERROR_CODE = SYS_COMPANY + "5";
    String SYS_COMPANY_SELECT_ERROR_MESSAGE = "查询公司出现系统异常";

    /**
     * 加载菜单系统异常
     */
    String SYS_COMPANY_PARAMS_ERROR_CODE = SYS_COMPANY + "6";
    String SYS_COMPANY_PARAMS_ERROR_MESSAGE = "公司参数不能为空";

    /**
     * 删除菜单系统异常
     */
    String SYS_COMPANY_DELETE_ERROR_CODE = SYS_COMPANY + "7";
    String SYS_COMPANY_DELETE_ERROR_MESSAGE = "删除菜单出现异常";
    /**
     * 删除菜单系统异常
     */
    String SYS_COMPANY_DELETE_APP_ERROR_CODE = SYS_COMPANY + "8";
    String SYS_COMPANY_DELETE_APP_ERROR_MESSAGE = "删除公司出现异常";

}
