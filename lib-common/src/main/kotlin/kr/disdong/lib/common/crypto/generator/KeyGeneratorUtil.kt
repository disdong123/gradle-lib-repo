package kr.disdong.lib.common.crypto.generator

import javax.crypto.spec.SecretKeySpec

class KeyGeneratorUtil {
    companion object {

        /**
         * key 값으로 Secret Key Spec 을 생성합니다.
         * @param key
         * @return
         */
        fun keyStringToKeySpec(key: String): SecretKeySpec {
            return SecretKeySpec(key.toByteArray(Charsets.UTF_8), "AES")
        }
    }
}
