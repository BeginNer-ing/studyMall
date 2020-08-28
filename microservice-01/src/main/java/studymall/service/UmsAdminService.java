package studymall.service;

import mbg.model.UmsAdmin;
import mbg.model.UmsPermission;

import java.util.List;

/**
 * @Description: 后台管理员Service
 * @Auther: Yanis_CC
 * @CreateDate: 2020-08-27 15:55
 **/

public interface UmsAdminService {
    /**
     * 根据用户名获取后台管理员
     * @param username
     * @return
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     * @param umsAdminParam
     * @return
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登陆功能
     * @param username
     * @param password
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 获取用户所有权限(包括角色权限和+-权限)
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
