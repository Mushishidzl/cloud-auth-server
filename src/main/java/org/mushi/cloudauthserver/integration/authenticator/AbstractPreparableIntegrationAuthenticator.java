package org.mushi.cloudauthserver.integration.authenticator;


import org.mushi.cloudauthserver.integration.IntegrationAuthenticationEntity;

/**
 * 集成认证-认证器抽象类
 */
public abstract class AbstractPreparableIntegrationAuthenticator implements IntegrationAuthenticator {

    @Override
    public void prepare(IntegrationAuthenticationEntity entity) {

    }

    @Override
    public void complete(IntegrationAuthenticationEntity entity) {

    }
}
