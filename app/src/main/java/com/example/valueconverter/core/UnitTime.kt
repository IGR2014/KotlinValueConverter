package com.example.valueconverter.core


// Описание идиниц измерения времени
enum class UnitTime(
	val conversionFactor: Double,
	val unitName: String
) {
	MICROSECOND(100000.0, "Microsecond"),
	MILLISECOND(1000.0, "Millisecond"),
	SECOND(1.0, "Second"),
	MINUTE(1.0 / 60.0, "Minute"),
	HOUR(1.0 / 3600.0, "Hour"),
	DAY(1.0 / 86400.0, "Day"),
	WEEK(1.0 / 604800.0, "Week"),
	MONTH(1.0 / 2592000.0, "Month"),
	YEAR(1.0 / 31557600.0, "Year")
}
