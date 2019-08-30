package org.mushi.cloudauthserver.integration.authenticator;


import org.mushi.cloudauthserver.integration.IntegrationAuthenticationEntity;
import org.mushi.cloudauthserver.model.BaseUser;
import org.mushi.cloudauthserver.model.BaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class QrAuthenticator extends AbstractPreparableIntegrationAuthenticator{


    private final String AUTH_TYPE = "qr";

    @Autowired
    private BaseUserService baseUserService;

    @Override
    public BaseUser authenticate(IntegrationAuthenticationEntity entity) {
        String qrCode = entity.getAuthParameter("qrCode");
        if(StringUtils.isEmpty(qrCode)){
            throw new OAuth2Exception("二维码信息不能为空！");
        }
        return getUserByQrCode(qrCode);
    }

    @Override
    public boolean support(IntegrationAuthenticationEntity entity) {
        return AUTH_TYPE.equals(entity.getAuthType());
    }



    private BaseUser getUserByQrCode(String qrCode){
        // 校验qrCode是否合法
        BaseUser byQrCode = baseUserService.findByQrCode(qrCode);
        return byQrCode;

    }


}
