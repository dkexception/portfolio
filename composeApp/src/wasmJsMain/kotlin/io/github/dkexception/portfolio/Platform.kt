package io.github.dkexception.portfolio

import kotlinx.browser.window

class WasmPlatform {

    val name: String = "Web with Kotlin/Wasm"

    fun openUrlExternally(url: String) {
        window.open(url, "_blank")?.focus()
    }
}

fun getPlatform() = WasmPlatform()
