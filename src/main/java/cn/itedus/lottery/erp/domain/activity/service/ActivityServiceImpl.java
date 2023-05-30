package cn.itedus.lottery.erp.domain.activity.service;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.erp.application.IActivityService;
import cn.itedus.lottery.erp.domain.activity.model.ActivityListPageReq;
import cn.itedus.lottery.erp.infrastructure.common.EasyResult;
import cn.itedus.lottery.rpc.activity.deploy.ILotteryActivityDeploy;
import cn.itedus.lottery.rpc.activity.deploy.req.ActivityPageReq;
import cn.itedus.lottery.rpc.activity.deploy.res.ActivityRes;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @description: 活动配置服务实现类，通过Dubbo实现远程过程调用。
 * @author: BAISHUN
 * @date: 2023/5/23
 * @Copyright: 博客：https://www.cnblogs.com/baishun666/
 */
@Service
public class ActivityServiceImpl implements IActivityService {

    @Reference(interfaceClass = ILotteryActivityDeploy.class)
    private ILotteryActivityDeploy activityDeploy;

    @Override
    public EasyResult queryActivityListPage(ActivityListPageReq req) {
        // 1. 组装参数
        ActivityPageReq activityPageReq = new ActivityPageReq(req.getPage(), req.getRows());
        activityPageReq.setErpId(req.getErpId());
        activityPageReq.setActivityId(req.getActivityId());
        activityPageReq.setActivityName(req.getActivityName());

        // 2. 查询数据
        ActivityRes activityRes = activityDeploy.queryActivityListByPageForErp(activityPageReq);

        // 3. 封装结果
        if (Constants.ResponseCode.SUCCESS.getCode().equals(activityRes.getResult().getCode())) {
            return EasyResult.buildEasyResultSuccess(activityRes.getCount(), activityRes.getActivityDTOList());
        } else {
            return EasyResult.buildEasyResultError(activityRes.getResult().getCode());
        }

    }

}
