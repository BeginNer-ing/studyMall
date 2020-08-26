package studyMall.service;

import studyMall.common.api.CommonResult;

/**
 * @Description:会员管理service
 * @Auther: Yanis_CC
 * @CreateDate: 2020-08-26 09:29
 **/

public interface UmsMemberService {
    /**
     * 生成验证码
     * @param telephone
     * @return
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     * @param telephone
     * @param authCode
     * @return
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
