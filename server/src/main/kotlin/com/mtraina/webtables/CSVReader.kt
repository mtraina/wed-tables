package com.mtraina.webtables

import org.springframework.stereotype.Component
import java.io.File

interface Reader {
    fun read(): List<String>
}

@Component
class CSVReader : Reader {
    override fun read(): List<String> {
        val file = File(ClassLoader.getSystemResource("guests.csv").file)
        return file.readLines()
    }
}