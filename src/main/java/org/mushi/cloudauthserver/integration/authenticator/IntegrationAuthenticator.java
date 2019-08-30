package org.mushi.cloudauthserver.integration.authenticator;


import org.mushi.cloudauthserver.integration.IntegrationAuthenticationEntity;
import org.mushi.cloudauthserver.model.BaseUser;

/**
 * 集成认证-认证器接口
 */
public interface IntegrationAuthenticator {

    /**
     * 处理集成认证
     * @param entity    集成认证实体
     * @return 用户表实体
     */
    BaseUser authenticate(IntegrationAuthenticationEntity entity);

    /**
     * 预处理
     * @param entity    集成认证实体
     */
    void prepare(IntegrationAuthenticationEntity entity);

    /**
     * 判断是否支持集成认证类型
     * @param entity    集成认证实体
     */
    boolean support(IntegrationAuthenticationEntity entity);

    /**
     * 认证结束后执行
     * @param entity    集成认证实体
     */
    void complete(IntegrationAuthenticationEntity entity);
}
