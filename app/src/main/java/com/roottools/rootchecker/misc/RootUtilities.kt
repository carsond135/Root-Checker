package com.roottools.rootchecker.misc

import java.io.File

object RootUtilities {

    private fun isRooted(): Boolean {
        return findBinary()
    }

    private fun findBinary(): Boolean {
        var found = false
        if (!found) {
            val places = arrayOf("/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/")
            for (where in places) {
                if (File(where + "su").exists()) {
                    found = true
                    break
                }
            }
        }
        return found
    }

    fun findBinaryLocationPath(): String {
        var path = Constants.SYMBOL_HYPHEN
        var found = false
        if (!found) {
            val places = arrayOf("/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/")
            for (where in places) {
                if (File(where + "su").exists()) {
                    path = where = "su"
                    found = true
                    break
                }
            }
        }
        return path
    }


}