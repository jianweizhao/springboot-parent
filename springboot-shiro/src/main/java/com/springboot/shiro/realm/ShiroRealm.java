package com.springboot.shiro.realm;

import com.springboot.shiro.entity.Permission;
import com.springboot.shiro.entity.Role;
import com.springboot.shiro.entity.User;
import com.springboot.shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhaojw
 * Date: 2017/10/25
 * Time: 14:11
 * 实现自己的权限
 * @author: zhaojw
 */
public class ShiroRealm extends AuthorizingRealm {

    private static Logger logger= LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private UserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("授权中。。。。。。");
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        User user=(User) principalCollection.getPrimaryPrincipal();
        if (user!=null){
            List<Role> roles=user.getUserRoles();
            for(Role role:roles){
                authorizationInfo.addRole(role.getRole());
                List<Permission> permissions=role.getRolePermissions();
                if (permissions!=null){
                    for (Permission permission:permissions){
                        authorizationInfo.addStringPermission(permission.getPermission());
                    }
                }
            }
        }
        return authorizationInfo;
    }
    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("登录验证中。。。。。。");
        String userName=(String) authenticationToken.getPrincipal();
        logger.info("登录输入账号为：{}",userName);
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User user=userService.selectUserByName(userName);
        logger.info("查询到的user：{}",user);
        if (user==null){
            return null;
        }
        /**
         * SimpleAuthenticationInfo 的构造方法传入当前登录对象，登录密码，盐值，以及当前的用户名称
         */
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(user.getUsername()+user.getSalt()),getName());
        return authenticationInfo;
    }
}
