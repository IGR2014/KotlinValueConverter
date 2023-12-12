package com.example.valueconverter


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.valueconverter.core.UnitLength


// Активность конвертёра длин
class ActivityLength : AppCompatActivity() {


	// Текущая единица измерения
	private var selectedUnit: UnitLength = UnitLength.METER


	// Метод вызываемый при создании активности
	@Override
	override fun onCreate(savedInstanceState: Bundle?) {

		// Вызов родительского метода
		super.onCreate(savedInstanceState)

		// Установка UI
		setContentView(R.layout.activity_length)
		setSupportActionBar(findViewById(R.id.activity_toolbar))

		// Параметры верхних кнопок
		supportActionBar?.let { actionBar ->
			actionBar.setDisplayShowTitleEnabled(false)
			actionBar.setDisplayHomeAsUpEnabled(true)
		}

		// Вводимое значение
		val editTextValue: EditText = findViewById(R.id.input_length)
		// Обработчик введённого значения
		editTextValue.addTextChangedListener(object : TextWatcher {

			// До изменения значения - без реализации
			@Override
			override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

			// В процессе изменения значения - без реализации
			@Override
			override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

			// После изменения значения
			@Override
			override fun afterTextChanged(s: Editable?) {
				// Пересчёт всех значений
				convertValue()
			}
		})

		// Выпадающий список единиц измерения длины
		val unitsValue: Spinner = findViewById(R.id.spinner_length)
		// Обработчик выпадающего списка единиц измерения длины
		unitsValue.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

			// Выбран элемент списка
			@Override
			override fun onItemSelected(
				parent: AdapterView<*>?,
				view: View?,
				position: Int,
				id: Long
			) {
				// Запоминание выбранной единицы измерения
				selectedUnit = UnitLength.entries[position]
				// Пересчёт всех значений
				convertValue()
			}

			// Ничего не выбрано - без реализации
			@Override
			override fun onNothingSelected(parent: AdapterView<*>?) {}

		}

	}

	// Метод вызываемый при обработке взаимодействия с различными елементами интерфейса
	@Override
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		// Нажата кнопка "Назад"
		if (item.itemId == android.R.id.home) {
			// Возврат назад
			onBackPressed()
			return true
		}
		// Обработчик по-умолчанию
		return super.onOptionsItemSelected(item)
	}


	// Пересчёт всех значений
	fun convertValue() {
		// Получение поля ввода пользовательского значения
		val editTextValue: EditText = findViewById(R.id.input_length)
		// Получение введённого пользователем значения и преобразование к общему знаменателю
		val inputValue = (editTextValue.text.toString().toDoubleOrNull() ?: 0.0) / selectedUnit.conversionFactor
		// Пересчёт и отображение миллиметров
		val millimeters: TextView = findViewById(R.id.value_millimeters)
		millimeters.text = (inputValue * UnitLength.MILLIMETER.conversionFactor).toString()
		// Пересчёт и отображение сантиметров
		val centimeters: TextView = findViewById(R.id.value_centimeters)
		centimeters.text = (inputValue * UnitLength.CENTIMETER.conversionFactor).toString()
		// Пересчёт и отображение дециметров
		val decimeters: TextView = findViewById(R.id.value_decimeters)
		decimeters.text = (inputValue * UnitLength.DECIMETER.conversionFactor).toString()
		// Пересчёт и отображение метров
		val meters: TextView = findViewById(R.id.value_meters)
		meters.text = (inputValue * UnitLength.METER.conversionFactor).toString()
		// Пересчёт и отображение километров
		val kilometers: TextView = findViewById(R.id.value_kilometers)
		kilometers.text = (inputValue * UnitLength.KILOMETER.conversionFactor).toString()
		// Пересчёт и отображение дюймов
		val inches: TextView = findViewById(R.id.value_inches)
		inches.text = (inputValue * UnitLength.INCH.conversionFactor).toString()
		// Пересчёт и отображение футов
		val feet: TextView = findViewById(R.id.value_feet)
		feet.text = (inputValue * UnitLength.FOOT.conversionFactor).toString()
		// Пересчёт и отображение ярдов
		val yards: TextView = findViewById(R.id.value_yards)
		yards.text = (inputValue * UnitLength.YARD.conversionFactor).toString()
		// Пересчёт и отображение миль
		val miles: TextView = findViewById(R.id.value_miles)
		miles.text = (inputValue * UnitLength.MILE.conversionFactor).toString()
	}


}
