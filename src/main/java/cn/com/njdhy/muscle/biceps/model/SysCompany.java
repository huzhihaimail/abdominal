package cn.com.njdhy.muscle.biceps.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rain
 * @description 公司实体类
 * @date 2019/1/10 17:08
 */
@Getter
@Setter
public class SysCompany extends BaseModel{

    /**
     * 公司名
     */
    private String companyName;
    /**
     * 公司logo
     */
    private String logo;
    /**
     * 域名
     */
    private String website;
    /**
     * 公司简介
     */
    private String introduce;
}
