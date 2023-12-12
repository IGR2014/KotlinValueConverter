package com.example.valueconverter.core


// Описание идиниц измерения массы
enum class UnitMass(
	val conversionFactor: Double,
	val unitName: String
) {
	MILLIGRAM(1000000.0, "Milligram"),
	GRAM(1000.0, "Gram"),
	KILOGRAM(1.0, "Kilogram"),
	CENTNER(0.01, "Centner"),
	TONNE(0.001, "Tonne"),
	POUND(2.20462262, "Pound"),
	OUNCE(35.2739619, "Ounce")
}
