package kr.disdong.lib.common.extension

import java.util.Base64

fun ByteArray.encodeBase64(): String = Base64.getEncoder().encodeToString(this)
