package com.github.moko256.kotlincoroutinedatetimepicker

import android.app.DatePickerDialog
import kotlinx.coroutines.CompletableDeferred

/**
 * Created by moko256 on 2019/03/05.
 *
 * @author moko256
 */
suspend fun DatePickerDialog.await(): PickerDate = CompletableDeferred<PickerDate>().also { deferred ->
    setOnDateSetListener { _, year, month, dayOfMonth ->
        deferred.complete(
            PickerDate(year, month, dayOfMonth)
        )
    }
    setOnCancelListener { deferred.cancel() }
    show()
}.await()