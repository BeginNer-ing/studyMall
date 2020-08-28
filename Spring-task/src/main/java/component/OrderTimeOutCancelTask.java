package component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description:订单超时取消并解锁库存的定时器
 * @Auther: Yanis_CC
 * @CreateDate: 2020-08-28 14:36
 **/
@Component
@Slf4j
public class OrderTimeOutCancelTask {

    /**
     * cron表达式：Seconds Minutes Hours DayofMonth Month DayofWeek [Year]
     * 每10分钟扫描一次，扫描设定超时时间之前下的订单，如果没支付则取消该订单
     */
    @Scheduled(cron = "0 0/10 * ? * ?")
    private void cancelTimeOutOrder() {
        Integer count = portalOrderService.cancelTimeOutOrder();
        log.info("取消订单,并根据sku编号释放锁定库存");
    }

}
