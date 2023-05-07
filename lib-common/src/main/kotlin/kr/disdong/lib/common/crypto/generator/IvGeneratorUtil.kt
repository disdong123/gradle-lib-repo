package kr.disdong.lib.common.crypto.generator

import javax.crypto.spec.IvParameterSpec

class IvGeneratorUtil {
    companion object {

        /**
         * iv 값으로 Iv Parameter Spec 을 생성합니다.
         * @param iv
         * @return
         */
        fun ivStringToKeySpec(iv: String): IvParameterSpec {
            return IvParameterSpec(iv.toByteArray(Charsets.UTF_8))
        }
    }
}
