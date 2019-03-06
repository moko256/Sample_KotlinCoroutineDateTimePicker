package com.github.moko256.kotlincoroutinedatetimepicker

import android.app.TimePickerDialog
import android.content.Context
import kotlinx.coroutines.suspendCancellableCoroutine
import java.util.*
import kotlin.coroutines.resume

/**
 * Created by moko256 on 2019/03/05.
 *
 * @author moko256
 */
suspend fun Context.asyncTimePickerDialog(
    is24HourView: Boolean
): PickerTime {
    val now = Calendar.getInstance()
    return asyncTimePickerDialog(
        now.get(Calendar.HOUR_OF_DAY),
        now.get(Calendar.MINUTE),
        is24HourView
    )
}

suspend fun Context.asyncTimePickerDialog(
    defaultHourOfDay: Int,
    defaultMinute: Int,
    is24HourView: Boolean
): PickerTime = suspendCancellableCoroutine { continuation ->
    TimePickerDialog(
        this,
        { _, hourOfDay, minute ->
            continuation.resume(
                PickerTime(hourOfDay, minute)
            )
        },
        defaultHourOfDay,
        defaultMinute,
        is24HourView
    ).apply {
        setOnCancelListener { continuation.cancel() }
        show()
    }
}