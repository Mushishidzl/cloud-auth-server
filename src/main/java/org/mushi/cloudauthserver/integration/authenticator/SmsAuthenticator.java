package org.mushi.cloudauthserver.integration.authenticator;

import org.mushi.cloudauthserver.integration.IntegrationAuthenticationEntity;
import org.mushi.cloudauthserver.model.BaseUser;
import org.mushi.cloudauthserver.model.BaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;



@Component
public class SmsAuthenticator extends AbstractPreparableIntegrationAuthenticator {

    private final String  AUTH_TYPE = "sms";

    @Autowired
    private BaseUserService baseUserService;

    @Override
    public BaseUser authenticate(IntegrationAuthenticationEntity entity) {
        String mobile = entity.getAuthParameter("mobile");
        if(StringUtils.isEmpty(mobile)){
            throw new OAuth2Exception("手机号不能为空");
        }
        String code = entity.getAuthParameter("code");
        //测试项目
        if(! "1234".equals(code)){
            throw new OAuth2Exception("验证码错误或已过期");
        }
        return baseUserService.findByMobile(mobile);
    }

    @Override
    public boolean support(IntegrationAuthenticationEntity entity) {
        return AUTH_TYPE.equals(entity.getAuthType());
    }
}
