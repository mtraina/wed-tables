package com.mtraina.webtables

import org.springframework.stereotype.Service


interface GuestService {
    fun guests(): List<Guest>
}

@Service
class GuestServiceImpl(private val reader: Reader, private val guestConverter: GuestConverter): GuestService {
    override fun guests(): List<Guest> {
        return guestConverter.convert(reader.read())
    }
}