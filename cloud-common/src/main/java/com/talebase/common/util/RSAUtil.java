/**
 * projectName: tds-kaisa
 * copyright(c) ©2003-2020 Talebase. All Rights Reserved.
 */
package com.talebase.common.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

/**
 * 非对称加密（RSA）。
 * 在透传外界的信息中，不要直接使用MD5进行加密，网络有大量的MD5
 * 解密库。最好使用非对称加密算法，谨慎使用对称加密算法。对称加密算法，是
 * 加解密的双方使用的秘钥相同，双方都可以进行加密解密。假若双方是非可信关
 * 系，需使用非对称加密算法，公钥给非信任方，私钥进行妥善保存。
 *
 * 非对称加密算法：使用RSA或椭圆曲线算法，RSA密钥长度应不小于1024
 * 位，椭圆曲线密钥长度应不小于256位。
 *
 * @author guohao.yang
 * @version v2.0
 * @since 2020/12/25 11:07
 */
public class RSAUtil {

    //todo 公私钥存储在配置文件中，禁止硬编码密码

    private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC4OUgj6j5apiNiuNRFXkL6GOajdstin5JBji00kS0p0Gzkf2PSboxoOUuxXnBgEMMszDsdzYOBQwB992CWd1LfsH/Az64/pHKfGfzMSOJodLceTAwUbV15L+lpJAG3H6fzOjV+OpGNfeoP5QbLTZsp1gq9aowBwMjlmAG7qrQ0WQIDAQAB";

    private static final String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALg5SCPqPlqmI2K41EVeQvoY5qN2y2KfkkGOLTSRLSnQbOR/Y9JujGg5S7FecGAQwyzMOx3Ng4FDAH33YJZ3Ut+wf8DPrj+kcp8Z/MxI4mh0tx5MDBRtXXkv6WkkAbcfp/M6NX46kY196g/lBstNmynWCr1qjAHAyOWYAbuqtDRZAgMBAAECgYBX24GrFzCrnKYtk8YwWvcIPU3pUWNH4qAmwX6PnljyoyL7ikF5/xzZK9IMgeSH/BaIy9G5seRwhhq6+HpI6BlOIjWIMwAT5nIq1FUEOP4s96QrL2NAgqn6f5QzsTKHeoP4aObaBXMU8u8OjUq9DlyBmyQGxXkMryryeVNCB5ijrQJBAPV4Oyqhyo/w//GUP15caoncCZChAUHcfBtnui5ymcS4s8GHCi40yoeZXkz+M156oNGeMDxsgtm/D0RAtRxRalcCQQDAIHFmsujLO1wWoK9VU6TepooEqf0H/CrDYVgowdm3VH5ggBpTM+lNewC6vkr7U5zVXQO0G5h9CZxeG/bEB4jPAkEAv9V7X8DbPgyY6SHzN/o/ZIeqjfXVtrPp5bz1mrEDDONPz9GKGjw1fy1TrhYG7TImlkrq5X3j8OnIs41iPMQ/twJBAKJqSrNQxy8XDTArwkzVmuiFzONIeJkJeXUVk5tQ1KYAjZ0ybg6sMavIMcOsHmL8Ofa83Oai9XOubju4VBE/dU0CQHCqtKBjaPD0hPHGa2UIOvabkURL3iVE53Aa/Xe4fAnFyikyrQWb4IvcKsYt9ycvDAVYsyhU6Bv2bo8zNomjUe4=";

    public static void main(String... strs) {
        String plaintext = "123456Xx";
        String ciphertext = encrypt(PUBLIC_KEY,plaintext);
        System.out.println(ciphertext);
        plaintext = decrypt(PRIVATE_KEY,ciphertext);
        System.out.println(plaintext);
    }

    /**
     * 使用私钥和密文解密.
     *
     * @param privateKey 私钥
     * @param ciphertext 密文
     * @return java.lang.String
     *
     * @author guohao.yang
     * @since 2020/12/25 11:31
     */
    public static String decrypt(String privateKey, String ciphertext) {
        RSA rsa = new RSA(privateKey,null);
        byte[] aByte = Base64.decode(ciphertext);
        byte[] decrypt = rsa.decrypt(aByte, KeyType.PrivateKey);
        return StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8);
    }

    /**
     * 使用公钥加密(加密出来的byte[]使用base64或者hex编码).
     *
     * @param publicKey 公钥
     * @param plaintext 明文
     * @return java.lang.String
     *
     * @author guohao.yang
     * @since 2020/12/25 11:31
     */
    public static String encrypt(String publicKey, String plaintext) {
        RSA rsa = new RSA(null,publicKey);
        return rsa.encryptBase64(plaintext,KeyType.PublicKey);
    }
}
