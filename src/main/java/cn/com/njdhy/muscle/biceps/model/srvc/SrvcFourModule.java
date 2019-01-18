package cn.com.njdhy.muscle.biceps.model.srvc;

import cn.com.njdhy.muscle.biceps.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

/**
 * 三大模块公司介绍
 * @author rain
 * @date 2018/11/17 19:58
 **/
@Getter
@Setter
public class SrvcFourModule extends BaseModel{

    /**
     * 模块标题
     */
    private String headTitle;
    /**
     * 小标题
     */
    private String subTitle;

    /**
     * 模块图片地址
     */
    private String imageUrl;

    /**
     * 模块类型：1、弹窗     2、文章
     */
    private Integer type;
    /**
     * 内容
     */
    private String content;

    /**
     * 图片排序
     */
    private Integer orderNum;

    private Integer companyId;
}
