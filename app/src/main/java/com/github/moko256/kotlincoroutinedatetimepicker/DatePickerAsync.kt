package com.github.moko256.kotlincoroutinedatetimepicker

import android.app.DatePickerDialog
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

/**
 * Created by moko256 on 2019/03/05.
 *
 * @author moko256
 */
suspend fun DatePickerDialog.await(): PickerDate = suspendCancellableCoroutine { continuation ->
    setOnDateSetListener { _, year, month, dayOfMonth ->
        continuation.resume(
            PickerDate(year, month, dayOfMonth)
        )
    }
    setOnCancelListener { continuation.cancel() }
    show()
}