package com.github.moko256.kotlincoroutinedatetimepicker

import java.util.*

/**
 * Created by moko256 on 2019/03/05.
 *
 * @author moko256
 */

data class PickerDate(
    val year: Int,
    val month: Int,
    val dayOfMonth: Int
)

data class PickerTime(
    val hourOfDay: Int,
    val minute: Int
)

fun generateCalendar(day: PickerDate, time: PickerTime): Calendar = GregorianCalendar(
    day.year,
    day.month,
    day.dayOfMonth,
    time.hourOfDay,
    time.minute
)