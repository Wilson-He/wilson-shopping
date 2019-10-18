package io.shopping.common.util;

import cn.hutool.core.lang.UUID;
import lombok.NoArgsConstructor;

/**
 * @author Wilson
 * @date 2019/10/14
 **/
@NoArgsConstructor
public class UUIDUtils {
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
