
package cn.com.njdhy.muscle.biceps.exception.srvc;

/**
 * <类功能简述> BANNER异常常量类
 *
 * @author 胡志海
 */
public interface CoreErrorCode {

    /**
     * 首页
     */
    String SRVC_CORE_SERVE = "4550";


    /**
     * 新建核心服务模块系统异常
     */
    String SRVC_CORE_SERVE_SAVE_APP_ERROR_CODE = SRVC_CORE_SERVE + "1";
    String SRVC_CORE_SERVE_SAVE_APP_ERROR_MESSAGE = "新建核心服务模块出现系统异常";

    /**
     * 新建核心服务模块
     */
    String SRVC_CORE_SERVE_SAVE_ERROR_CODE = SRVC_CORE_SERVE + "2";
    String SRVC_CORE_SERVE_SAVE_ERROR_MESSAGE = "新建核心服务模块出现根异常";

    /**
     * 更新核心服务模块
     */
    String SRVC_CORE_SERVE_UPDATE_APP_ERROR_CODE = SRVC_CORE_SERVE + "3";
    String SRVC_CORE_SERVE_UPDATE_APP_ERROR_MESSAGE = "更新核心服务模块出现系统异常";

    /**
     * 更新核心服务模块
     */
    String SRVC_CORE_SERVE_UPDATE_ERROR_CODE = SRVC_CORE_SERVE + "4";
    String SRVC_CORE_SERVE_UPDATE_ERROR_MESSAGE = "更新核心服务模块出现根异常";

    /**
     * 入参校验
     */
    String SRVC_CORE_SERVE_PARAMS_ERROR_CODE = SRVC_CORE_SERVE + "5";
    String SRVC_CORE_SERVE_PARAMS_ERROR_MESSAGE = "入参校验出现异常";

    /**
     * 查询核心服务模块
     */
    String SRVC_CORE_SERVE_SELECT_ERROR_CODE = SRVC_CORE_SERVE + "6";
    String SRVC_CORE_SERVE_SELECT_ERROR_MESSAGE = "查询核心服务模块列表出现异常";
}
