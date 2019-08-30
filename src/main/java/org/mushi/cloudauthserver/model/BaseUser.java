package org.mushi.cloudauthserver.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseUser implements Serializable {

    private Integer id;
    private String name;
    private String mobile;
    private String mail;
    private String pwd;

    public BaseUser() {
    }
}
