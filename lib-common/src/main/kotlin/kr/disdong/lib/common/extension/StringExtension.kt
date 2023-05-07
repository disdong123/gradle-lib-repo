package kr.disdong.lib.common.extension

import java.util.Base64

fun String.decodeBase64(): ByteArray = Base64.getDecoder().decode(this)
