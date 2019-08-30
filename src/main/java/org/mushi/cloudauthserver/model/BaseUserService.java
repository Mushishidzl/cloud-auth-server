package org.mushi.cloudauthserver.model;


import org.springframework.stereotype.Service;

@Service
public class BaseUserService {



    public BaseUser findByMobile(String mobile) {
        BaseUser baseUser = new BaseUser();
        baseUser.setId(83);
        baseUser.setMail("10086@qq.com");
        baseUser.setName("root");
        baseUser.setMobile("13555555555");
        baseUser.setPwd("$2a$10$hcMi5tIUGGGim/Xe0Z7q4e5Zz3QlK.EAek3an3nZf0B.ZdN0GJgSe");
        return baseUser;
    }

    public BaseUser findByName(String name) {
        BaseUser baseUser = new BaseUser();
        baseUser.setId(83);
        baseUser.setMail("10086@qq.com");
        baseUser.setName("root");
        baseUser.setMobile("13555555555");
        baseUser.setPwd("$2a$10$hcMi5tIUGGGim/Xe0Z7q4e5Zz3QlK.EAek3an3nZf0B.ZdN0GJgSe");
        return baseUser;
    }

    public BaseUser findByQrCode(String qrCode) {
        BaseUser baseUser = new BaseUser();
        baseUser.setId(83);
        baseUser.setMail("10086@qq.com");
        baseUser.setName("root");
        baseUser.setMobile("13555555555");
        baseUser.setPwd("$2a$10$hcMi5tIUGGGim/Xe0Z7q4e5Zz3QlK.EAek3an3nZf0B.ZdN0GJgSe");
        return baseUser;
    }
}
