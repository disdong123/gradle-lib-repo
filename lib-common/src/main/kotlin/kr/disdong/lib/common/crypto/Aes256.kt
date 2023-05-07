package kr.disdong.lib.common.crypto

import kr.disdong.lib.common.crypto.generator.IvGeneratorUtil
import kr.disdong.lib.common.crypto.generator.KeyGeneratorUtil
import javax.crypto.Cipher

/**
 * AES256 암호화를 수행합니다.
 * @property key key 는 32 바이트(256 비트) 입니다. (128, 192, 256 비트 키도 지원합니다.)
 * @property iv IV 는 16 bytes 입니다.
 */
class Aes256(
    private val key: String,
    private val iv: String,
) {

    private val secretKeySpec = KeyGeneratorUtil.keyStringToKeySpec(key)
    private val ivParameterSpec = IvGeneratorUtil.ivStringToKeySpec(iv)
    private val TRANSFORMATION = "AES/CBC/PKCS5Padding"

    fun encrypt(data: String): ByteArray {
        return Cipher.getInstance(TRANSFORMATION).run {
            init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec)
            doFinal(data.toByteArray(Charsets.UTF_8))
        }
    }

    fun decrypt(data: ByteArray): String {
        return Cipher.getInstance(TRANSFORMATION)
            .run {
                init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec)
                doFinal(data)
            }.let {
                String(it)
            }
    }
}
