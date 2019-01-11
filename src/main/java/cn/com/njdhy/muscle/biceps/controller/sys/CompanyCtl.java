package cn.com.njdhy.muscle.biceps.controller.sys;

import cn.com.njdhy.muscle.biceps.controller.Query;
import cn.com.njdhy.muscle.biceps.controller.Result;
import cn.com.njdhy.muscle.biceps.exception.ApplicationException;
import cn.com.njdhy.muscle.biceps.exception.sys.CompanyErrorCode;
import cn.com.njdhy.muscle.biceps.model.SysCompany;
import cn.com.njdhy.muscle.biceps.properties.AppCommonProperties;
import cn.com.njdhy.muscle.biceps.service.sys.SysCompanyService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 公司信息控制器
 * @author rain
 * @date 2018/11/17 22:22
 **/
@RestController
@RequestMapping("/sys/company")
public class CompanyCtl {

    @Autowired
    private AppCommonProperties appCommonProperties;

    @Autowired
    private SysCompanyService sysCompanyService;

    /**
     * 查询banner图列表
     *
     * @param params     参数列表
     * @param pageNumber 当前页码
     * @param pageSize   每页大小
     * @return 用户列表
     */
    @RequestMapping("/list")
    public Result banner(@RequestParam Map<String, Object> params, Integer pageNumber, Integer pageSize) {
        PageInfo<SysCompany> result=null;
        try {
            Query queryParam = new Query(params);
            result = sysCompanyService.queryList(queryParam, pageNumber, pageSize);
            List<SysCompany> list = result.getList();
            for(SysCompany sysCompany: list) {
                String s = appCommonProperties.getImagesPrefix()+sysCompany.getLogo();
                sysCompany.setLogo(s);
            }
            result.setList(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CompanyErrorCode.SYS_COMPANY_SELECT_ERROR_CODE,CompanyErrorCode.SYS_COMPANY_SELECT_ERROR_MESSAGE);
        }

        return Result.success(result.getTotal(), result.getList());
    }

    /**
     * 根据id查询用户信息
     *
     * @param id 用户ID
     * @return 用户实体
     */
    @RequestMapping("/{id}")
    public Result queryById(@PathVariable String id) {

        SysCompany model=null;
        try {
            if (null == id) {
                return Result.error(CompanyErrorCode.SYS_COMPANY_PARAMS_ERROR_CODE,CompanyErrorCode.SYS_COMPANY_PARAMS_ERROR_MESSAGE);
            }
            model = sysCompanyService.queryById(id);
            if (ObjectUtils.isEmpty(model)) {
                model = new SysCompany();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CompanyErrorCode.SYS_COMPANY_SELECT_ERROR_CODE,CompanyErrorCode.SYS_COMPANY_SELECT_ERROR_MESSAGE);
        }

        return Result.success().put("model", model);
    }


    /**
     * 保存
     *
     * @param sysCompany 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/insert")
    public Result insert(@RequestBody SysCompany sysCompany) {

        try {
            // 校验参数
            if (null == sysCompany) {
                return Result.error(CompanyErrorCode.SYS_COMPANY_PARAMS_ERROR_CODE,CompanyErrorCode.SYS_COMPANY_PARAMS_ERROR_MESSAGE);
            }
            // 执行入库操作
            sysCompanyService.insert(sysCompany);
        } catch (ApplicationException e) {
            e.printStackTrace();
            return Result.error(CompanyErrorCode.SYS_COMPANY_SAVE_APP_ERROR_CODE, CompanyErrorCode.SYS_COMPANY_SAVE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CompanyErrorCode.SYS_COMPANY_SAVE_ERROR_CODE, CompanyErrorCode.SYS_COMPANY_SAVE_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 修改操作
     *
     * @param sysCompany 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/update")
    public Result update(@RequestBody SysCompany sysCompany) {

        try {
            // 校验参数
            if (null == sysCompany) {
                return Result.error(CompanyErrorCode.SYS_COMPANY_PARAMS_ERROR_CODE,CompanyErrorCode.SYS_COMPANY_PARAMS_ERROR_MESSAGE);
            }
            // 执行修改
            sysCompanyService.update(sysCompany);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return Result.error(CompanyErrorCode.SYS_COMPANY_UPDATE_APP_ERROR_CODE, CompanyErrorCode.SYS_COMPANY_UPDATE_APP_ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CompanyErrorCode.SYS_COMPANY_UPDATE_ERROR_CODE, CompanyErrorCode.SYS_COMPANY_UPDATE_ERROR_MESSAGE);
        }

        return Result.success();
    }

    /**
     * 删除多个记录
     *
     * @param ids 请求数据对象
     * @return 结果对象
     */
    @RequestMapping("/delete")
    public Result deleteByIds(@RequestBody List<String> ids) {

        try {
            // 校验参数
            for (String id : ids) {
                if (id == null || id.length() <= 0) {
                    return Result.error(CompanyErrorCode.SYS_COMPANY_PARAMS_ERROR_CODE,CompanyErrorCode.SYS_COMPANY_PARAMS_ERROR_MESSAGE);
                }
            }
            sysCompanyService.deleteByIds(ids);
        } catch (ApplicationException e) {
            e.printStackTrace();
            return Result.error(e.getCode(), e.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }

        return Result.success();
    }
}
