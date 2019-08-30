package org.mushi.cloudauthserver.integration.authenticator;

import org.mushi.cloudauthserver.integration.IntegrationAuthenticationEntity;
import org.mushi.cloudauthserver.model.BaseUser;
import org.mushi.cloudauthserver.model.BaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;



@Component
@Primary
public class UsernamePasswordAuthenticator extends AbstractPreparableIntegrationAuthenticator {

    @Autowired
    private BaseUserService baseUserService;

    @Override
    public BaseUser authenticate(IntegrationAuthenticationEntity entity) {
        String name = entity.getAuthParameter("name");
        String pwd = entity.getAuthParameter("pwd");
        if(name == null || pwd == null){
            throw new OAuth2Exception("用户名或密码不能为空");
        }
        BaseUser pojo = baseUserService.findByName(name);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder != null && encoder.matches(pwd,pojo.getPwd())){
            return pojo;
        }
        return null;
    }

    @Override
    public boolean support(IntegrationAuthenticationEntity entity) {
        return StringUtils.isEmpty(entity.getAuthType());
    }
}
