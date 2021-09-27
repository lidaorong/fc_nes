/**
 * projectName: tds
 * copyright(c) ©2003-2020 Talebase. All Rights Reserved.
 */
package com.talebase.common.constant.global;

import com.talebase.common.exception.*;
import org.springframework.http.HttpStatus;
//import org.apache.http.HttpStatus;

/**
 * 异常种类枚举。
 *
 * @author guohao.yang
 * @version v1.0
 * @since 2020/11/2 17:46
 */
public enum ExceptionTypeEnum {
    /**
     * 全局业务异常
     */
    BUSINESS_ERROR(BusinessException.class, HttpStatus.INTERNAL_SERVER_ERROR, ResponseCodeEnum.FAIL),

    /**
     * 无效参数
     */
    PARAMETER_INVALID(ParameterInvalidException.class, HttpStatus.BAD_REQUEST, ResponseCodeEnum.PARAM_INVALID),

    /**
     * 数据未找到
     */
    NOT_FOUND(DataNotFoundException.class, HttpStatus.NOT_FOUND, ResponseCodeEnum.NOT_EXIST),

    /**
     * 数据已存在
     */
    CONFLICT(DataConflictException.class, HttpStatus.CONFLICT, ResponseCodeEnum.DATA_EXSIT),

    /**
     * 用户未登录
     */
    UNAUTHORIZED(NotLoginException.class, HttpStatus.UNAUTHORIZED, ResponseCodeEnum.TOKEN_INVALID),

    /**
     * 无访问权限
     */
    FORBIDDEN(AccessDeniedException.class, HttpStatus.FORBIDDEN, ResponseCodeEnum.PERMISSION_NOT),

    /**
     * 系统错误
     */
    INTERNAL_SERVER_ERROR(InternalServerException.class, HttpStatus.INTERNAL_SERVER_ERROR, ResponseCodeEnum.SYSTEM_ERROR);



    private Class<? extends BusinessException> eClass;

    private HttpStatus httpStatus;

    private ResponseCodeEnum resultCode;

    ExceptionTypeEnum(Class<? extends BusinessException> eClass, HttpStatus httpStatus, ResponseCodeEnum resultCode) {
        this.eClass = eClass;
        this.httpStatus = httpStatus;
        this.resultCode = resultCode;
    }

    public Class<? extends BusinessException> getEClass() {
        return this.eClass;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public ResponseCodeEnum getResponseCodeEnum() {
        return this.resultCode;
    }

    public static boolean isSupportHttpStatus(int httpStatus) {
        for (ExceptionTypeEnum exceptionEnum : ExceptionTypeEnum.values()) {
            if (exceptionEnum.httpStatus.value() == httpStatus) {
                return true;
            }
        }

        return false;
    }

    public static boolean isSupportException(Class<?> z) {
        for (ExceptionTypeEnum exceptionEnum : ExceptionTypeEnum.values()) {
            if (exceptionEnum.eClass.equals(z)) {
                return true;
            }
        }

        return false;
    }

    public static ExceptionTypeEnum getByHttpStatus(HttpStatus httpStatus) {
        if (httpStatus == null) {
            return null;
        }

        for (ExceptionTypeEnum exceptionEnum : ExceptionTypeEnum.values()) {
            if (httpStatus.equals(exceptionEnum.httpStatus)) {
                return exceptionEnum;
            }
        }

        return null;
    }

    public static ExceptionTypeEnum getByEClass(Class<? extends BusinessException> eClass) {
        if (eClass == null) {
            return null;
        }

        for (ExceptionTypeEnum exceptionEnum : ExceptionTypeEnum.values()) {
            if (eClass.equals(exceptionEnum.eClass)) {
                return exceptionEnum;
            }
        }

        return null;
    }
}
