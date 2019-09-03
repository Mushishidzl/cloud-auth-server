package org.mushi.cloudauthserver.integration.authenticator;


import lombok.extern.slf4j.Slf4j;
import org.mushi.cloudauthserver.integration.IntegrationAuthenticationEntity;

/**
 * 集成认证-认证器抽象类
 */
@Slf4j
public abstract class AbstractPreparableIntegrationAuthenticator implements IntegrationAuthenticator {

    @Override
    public void prepare(IntegrationAuthenticationEntity entity) {
        // 可在此处验证短信验证码是否匹配、图片验证码是否匹配、是否是登录IP白名单等处理
        log.info("处理认证之前的操作！！！！");
    }

    @Override
    public void complete(IntegrationAuthenticationEntity entity) {
        log.info("处理认证之后的操作！！！！");
    }
}
