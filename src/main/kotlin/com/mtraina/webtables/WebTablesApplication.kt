package com.mtraina.webtables

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebTablesApplication

fun main(args: Array<String>) {
    //runApplication<WebTablesApplication>(*args)
    CSVReader().read()
}
