/*
 * projectName: tds.
 * copyright(c) ©2003-2020 Talebase. All Rights Reserved.
 */
package com.talebase.common.constant.global;

import java.util.concurrent.TimeUnit;

/**
 * 状态枚举。
 *
 * @author guohao.yang
 * @version v1.0
 */
public class RedisStatusEnum {
    /**
     * 过期时间相关枚举
     */
    public static enum ExpireEnum{
        //未读消息的有效期为30天
        UNREAD_MSG(30L, TimeUnit.DAYS)
        ;

        /**
         * 过期时间
         */
        private Long time;
        /**
         * 时间单位
         */
        private TimeUnit timeUnit;

        ExpireEnum(Long time, TimeUnit timeUnit) {
            this.time = time;
            this.timeUnit = timeUnit;
        }

        public Long getTime() {
            return this.time;
        }

        public TimeUnit getTimeUnit() {
            return this.timeUnit;
        }
    }
}
