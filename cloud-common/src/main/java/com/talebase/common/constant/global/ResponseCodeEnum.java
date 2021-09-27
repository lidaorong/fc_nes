/**
 * projectName: tds
 * copyright(c) ©2003-2020 Talebase. All Rights Reserved.
 */
package com.talebase.common.constant.global;

/**
 * 错误码类型。。
 *
 * @author guohao.yang
 * @version v1.0
 * @since 2020/11/2 17:33
 */
public enum ResponseCodeEnum {
    //1xxxx 系统级异常

    /**
     * 成功
     */
    SUCCESS(0, "成功"),

    /**
     * 失败
     */
    FAIL(1, "失败"),

    /**
     * 系统错误
     */
    SYSTEM_ERROR(10001, "系统错误"),

    /**
     * 无效token
     */
    TOKEN_INVALID(10002, "无效token"),

    /**
     * 无权访问
     */
    PERMISSION_NOT(10003, "无权访问"),

    /**
     * 不支持的MediaType
     */
    MEDIATYPE_NOT_SUPPORT(10004, "不支持的MediaType"),

    /**
     * 接口不存在
     */
    INTERFASE_NOT(10005, "接口不存在"),

    /**
     * 无效参数
     */
    PARAM_INVALID(10006, "无效参数"),

    /**
     * 参数为空
     */
    PARAM_EMPTY(10007, "参数为空"),

    /**
     * 参数类型错误
     */
    PARAM_TYPE(10008, "参数类型错误"),

    /**
     * 数据不存在
     */
    NOT_EXIST(10009, "数据不存在"),

    /**
     * 数据已存在
     */
    DATA_EXSIT(10010, "数据已存在"),


    /**
     * 验证码无效
     */
    INVALID_CODE(10011, "验证码无效"),


    ERROR_URL_INVALID(10012, "无效请求"),



    //2xxxx开始定义业务模块异常

    /**
     * 单位已存在，无法删除
     */
    UNIT_EXIST(20202, "单位已存在，无法删除"),

    /**
     * 该年度绩效已存在
     */
    PERFORMANCE_EXIST(20301, "该年度绩效已存在"),

    /**

     * 该分类已存在
     */
    CLASSIFY_EXIST(20401, "该分类已存在"),
    /**
     * 该文件夹已存在
     */
    FOlDER_EXIST(20402, "该文件夹已存在"),

    DOWNLOAD_LOADING(20801, "下载中"),

    DOWNLOAD_SUCESS(20802, "下载完成"),

    DOWNLOAD_FALSE(20803, "下载失败"),

    INSPECTION_EXIST(20501, "该日期的考察已存在"),

    INVENTORY_NOT_EXIST(20601, "没有数据"),


    ;


    /**
     * 返回码
     */
    private int value;

    /**
     * 返回说明
     */
    private String message;

    ResponseCodeEnum(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public int getValue() {
        return this.value;
    }

    public String getMessage() {
        return this.message;
    }
}

