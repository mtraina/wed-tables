package com.mtraina.webtables

import java.io.File


interface Reader {
    fun read(): List<String>
}

class CSVReader : Reader {
    override fun read(): List<String> {
        val file = File(ClassLoader.getSystemResource("guest.csv").file)

//        file.forEachLine {
//            println(it)
//        }

        return file.readLines()
    }
}