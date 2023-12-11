package com.example.valueconverter.core


// Описание идиниц измерения длины
enum class UnitLength(
	val conversionFactor: Double,
	val unitName: String
) {
	MILLIMETER(1000.0, "Millimeter"),
	CENTIMETER(100.0, "Centimeter"),
	DECIMETER(10.0, "Decimeter"),
	METER(1.0, "Meter"),
	KILOMETER(0.001, "Kilometer"),
	INCH(39.3701, "Inch"),
	FOOT(3.28084, "Foot"),
	YARD(1.09361, "Yard"),
	MILE(0.000621371, "Mile")
}
