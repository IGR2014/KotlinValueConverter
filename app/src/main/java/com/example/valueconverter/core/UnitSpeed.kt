package com.example.valueconverter.core

enum class UnitSpeed(
	val conversionFactor: Double,
	val unitName: String
) {
	METERS_PER_SECOND(1.0, "MPS"),
	KILOMETERS_PER_HOUR(3.6, "KMPH"),
	MILES_PER_HOUR(2.23693629205, "MPH")
}