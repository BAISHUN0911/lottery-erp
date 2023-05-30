package cn.itedus.lottery.erp.application;

import cn.itedus.lottery.erp.domain.activity.model.ActivityListPageReq;
import cn.itedus.lottery.erp.infrastructure.common.EasyResult;

/**
 * @description: 活动配置服务接口
 * @author: BAISHUN
 * @date: 2023/5/23
 * @Copyright: 博客：https://www.cnblogs.com/baishun666/
 */
public interface IActivityService {

    /**
     * 查询活动分页数据
     * @param req   入参
     * @return      结果
     */
    EasyResult queryActivityListPage(ActivityListPageReq req);

    //查询所有抽奖活动、查询所有奖品、查询所有策略、查询所有策略详情....

}
