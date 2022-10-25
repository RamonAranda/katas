package com.katas

@JvmInline
value class Dice(private val value: Int): Comparable<Dice> {
    override operator fun compareTo(other: Dice): Int = value.compareTo(other.value)
    operator fun rangeTo(other: Dice): List<Dice> =
        (value..other.value).map(::Dice)
}
