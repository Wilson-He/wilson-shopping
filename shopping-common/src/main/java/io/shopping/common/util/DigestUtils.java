package io.shopping.common.util;

import cn.hutool.crypto.digest.MD5;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Wilson
 * @date 2019/9/24
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DigestUtils {
    private static final String SALT = "1q2w3e";


    public static String md5(String val) {
        return MD5.create().digestHex(val);
    }

    /**
     * 字符串加盐后md5加密
     *
     * @param data
     * @return
     */
    public static String md5ByFixSalt(String data) {
        String salted = StringUtils.join(SALT.charAt(0), SALT.charAt(2), data, SALT.charAt(4));
        return MD5.create().digestHex(salted);
    }

    /**
     * 字符串加盐后md5加密
     *
     * @param data
     * @param salt
     * @return
     */
    public static String md5BySalt(String data, String salt) {
        String salted = StringUtils.join(SALT.charAt(0), SALT.charAt(2), data, SALT.charAt(4));
        return MD5.create().digestHex(salted);
    }

    /**
     * 判断明文加密后是否与已加密目标字符串相等
     *
     * @param data           明文
     * @param dbSalt         盐
     * @param digestedTarget 已加密字符串
     * @return
     */
    public static boolean isDbDigestEqual(String data, String dbSalt, String digestedTarget) {
        String firstSalted = MD5.create().digestHex(data + dbSalt);
        return md5ByFixSalt(firstSalted).equals(digestedTarget);
    }

    public static String toDbDigest(String data, String dbSalt) {
        String firstSalted = md5ByFixSalt(data);
        return md5(firstSalted + dbSalt);
    }

    public static void main(String[] args) {
        String data = "11111111";
        String firstMd5 = md5ByFixSalt(data);
        System.out.println(firstMd5);
    }
}
