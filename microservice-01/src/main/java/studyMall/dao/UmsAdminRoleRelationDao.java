package studyMall.dao;

import org.apache.ibatis.annotations.Param;
import studyMall.mbg.model.UmsPermission;

import java.util.List;

/**
 * @Description: 后台用户与角色管理自定义Dao
 * @Auther: Yanis_CC
 * @CreateDate: 2020-08-27 16:19
 **/

public interface UmsAdminRoleRelationDao {
    /**
     * 获取用户所有权限(包括+-权限)
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
