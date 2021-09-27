package com.talebase.common.constant.global;

/**
 * 类描述。
 *
 * @author daorong.li
 * @version v1.0
 * @since 2021-5-27 17:19
 */
public enum ServiceParamEnum {
    MASTER("master"),
    TENANTID("tenantId");
    /**
     * 返回说明
     */
    private String value;

    ServiceParamEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
