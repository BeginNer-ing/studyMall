package studyMall.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import studyMall.common.api.CommonResult;
import studyMall.service.RedisService;
import studyMall.service.UmsMemberService;

import java.util.Random;

/**
 * @Description:
 * @Auther: Yanis_CC
 * @CreateDate: 2020-08-26 09:37
 **/
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Qualifier
    private RedisService redisService;
    @Value("${spring.redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${spring.redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    /**
     * 验证码绑定手机号并存储到redis
     * @param telephone
     * @return
     */
    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(sb.toString(), "获取验证码成功");
    }

    /**
     * 对输入的验证码进行校验
     * @param telephone
     * @param authCode
     * @return
     */
    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return CommonResult.failed("请输入验证码");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        boolean result = authCode.equals(realAuthCode);
        if (result) {
            return CommonResult.success(null, "验证码校验成功");
        } else {
            return CommonResult.failed("验证码不正确");
        }
    }
}
