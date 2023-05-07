package kr.disdong.lib.common.crypto

import kr.disdong.lib.common.extension.encodeBase64
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.security.InvalidAlgorithmParameterException

internal class Aes256Test {

    val data = "hello, world"

    @Test
    fun `key, iv 길이는 각각 32 bytes, 16bytes 여야 한다`() {
        val key = "12345678901234561234567890123456"
        val iv = "1234567890123456"

        val aes = Aes256(key, iv)
        val enc = aes.encrypt(data)
        val dec = aes.decrypt(enc)

        // 테스트: https://www.devglan.com/online-tools/aes-encryption-decryption
        assertEquals(enc.encodeBase64(), "N0/g1B5NZwlpVTBBT7s2Gw==")
        assertEquals(dec, data)
    }

    @Test
    fun `key, iv 길이가 올바르지 않으면 예외가 발생한다`() {
        val key = "1"
        val iv = "1"

        assertThrows(InvalidAlgorithmParameterException::class.java) {
            Aes256(key, iv).encrypt(data)
        }
    }
}
