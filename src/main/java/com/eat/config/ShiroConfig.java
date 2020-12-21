package com.eat.config;



import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;
/**
 * @version V1.0
 * @Package com.eat.config
 * @ClassName ShiroConfig
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/10/23 22:22
 **/
@Configuration
public class ShiroConfig {

    /**
     * @Summary
     * @Param: []
     * @Return: CustomRealm
     * @Author: TheRaging
     * @Date: 2020/10/23 22:28
     * @Description 配置ShiroRealm用于登录验证逻辑，返回自定义的ShiroRealm 相当于一个数据源
     * 身份验证（getAuthenticationInfo 方法）验证账户和密码，并返回相关信息
     * 权限获取（getAuthorizationInfo 方法） 获取指定身份的权限，并返回相关信息
     * 令牌支持（supports方法）判断该令牌（Token）是否被支持
     */
    @Bean
    public MyRealm myShiroRealm() {
        MyRealm customRealm = new MyRealm();
        //自定义密码验证
        //customRealm.setCredentialsMatcher(myCredentialsMatcher());
        return customRealm;
    }

    /**
     * @Summary
     * @Param: []
     * @Return: java.lang.SecurityManager
     * @Author: TheRaging
     * @Date: 2020/10/23 22:29
     * @Description 配置SecurityManager，用于管理认证
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        //设置自定义的session管理器
        //securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    /**
     * @Summary
     * @Param: [securityManager]
     * @Return: ShiroFilterFactoryBean
     * @Author: TheRaging
     * @Date: 2020/10/23 22:30
     * @Description 配置ShiroFilterFactoryBean过滤器，用于过滤url地址，然后决定哪些路径需要认证
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置使用自定义的filter进行过滤
        Map<String, Filter> filters = new HashMap<>();
        filters.put("filter", new MyFilter());
        //配置自定义的过滤规则
        shiroFilterFactoryBean.setFilters(filters);
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> map = new HashMap<>();
        //登录
        map.put("/test/login", "anon");
        //注册
        map.put("/test/CreateUser", "anon");
        //登出
        map.put("/logout", "logout");
        //登录失败跳转的页面
       // shiroFilterFactoryBean.setLoginUrl("/test/login");
        //配置登录成功的跳转页面，默认跳转到/
        //shiroFilterFactoryBean.setSuccessUrl("/index");
        //没有权限，权限校验失败跳转的页面
        //shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        //对所有用户认证
        map.put("/**", "filter");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    /**
     * shiro缓存管理器
     * 1 添加相关的maven支持
     * 2 注册这个bean，将缓存的配置文件导入
     * 3 在securityManager 中注册缓存管理器，之后就不会每次都会去查询数据库了，相关的权限和角色会保存在缓存中，但需要注意一点，更新了权限等操作之后，需要及时的清理缓存
     */
   /* @Bean
    public EhCacheManager ehCacheManager() {
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:config/ehcache.xml");
        return cacheManager;
    }*/


    /**
     * 自定义的 shiro session 缓存管理器，用于跨域等情况下使用 token 进行验证，不依赖于sessionId
     * @return
     */
   /* @Bean
    public SessionManager sessionManager(){
        //将我们继承后重写的shiro session 注册
        MySession shiroSession = new MySession();
        //如果后续考虑多tomcat部署应用，可以使用shiro-redis开源插件来做session 的控制，或者nginx 的负载均衡
        shiroSession.setSessionDAO(new EnterpriseCacheSessionDAO());
        return shiroSession;
    }*/

    /**
     * @Summary
     * @Param: []
     * @Return: MyCredentialsMatcher
     * @Author: TheRaging
     * @Date: 2020/10/23 23:45
     * @Description 配置自定义的密码校验类MyCredentialsMatcher
     * MyCredentialsMatcher 需要继承CredentialsMatcher 实现重写
     * 但是同时需要在SecurityManager中设置
     * SecurityManager.setCredentialsMatcher(myCredentialsMatcher());
     */
   /* @Bean
    public MyCredentialsMatcher myCredentialsMatcher() {
        return new MyCredentialsMatcher();
    }
*/

    /**
     * @Summary
     * @Param: []
     * @Return: org.apache.shiro.mgt.SecurityManager
     * @Author: TheRaging
     * @Date: 2020/10/23 23:51
     * @Description 配置实现自定义的securityManager
     * MySessionManager需要继承 DefaultWebSessionManager 实现重写
     * 但是同时也需要在 securityManager 中添加
     * SecurityManager.setSessionManager(sessionManager());
     */
  /*  @Bean
    public SessionManager sessionManager(){
        MySessionManager mySessionManager = new MySessionManager();
        //这里可以不设置。Shiro有默认的session管理。如果缓存为Redis则需改用Redis的管理
        mySessionManager.setSessionDAO(new EnterpriseCacheSessionDAO());
        return mySessionManager;
    }*/



    //DefaultAdvisorAutoProxyCreator 和AuthorizationAttributeSourceAdvisor两个在一起才能支Shiro的注解权限控制实现
    /**
     * @Summary
     * @Param: []
     * @Return: org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator
     * @Author: TheRaging
     * @Date: 2020/10/23 22:33
     * @Description  配置，这个是AOP的，相当于一个切面
     *  他会扫描所有的类中的Advisor，
     *  然后这些Advisor应用到所有符合切入点的Bean中
     */
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

    /**
     * @Summary
     * @Param: [securityManager]
     * @Return: AuthorizationAttributeSourceAdvisor
     * @Author: TheRaging
     * @Date: 2020/10/23 22:38
     * @Description 配置 aop  这个类就相当于切点了
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
