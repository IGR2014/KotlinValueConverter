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
import com.example.valueconverter.core.UnitMass


// Активность конвертёра масс
class ActivityMass : AppCompatActivity() {


	// Текущая единица измерения
	private var selectedUnit: UnitMass = UnitMass.KILOGRAM


	// Метод вызываемый при создании активности
	@Override
	override fun onCreate(savedInstanceState: Bundle?) {

		// Вызов родительского метода
		super.onCreate(savedInstanceState)

		// Установка UI
		setContentView(R.layout.activity_mass)
		setSupportActionBar(findViewById(R.id.activity_toolbar))

		// Параметры верхних кнопок
		supportActionBar?.let { actionBar ->
			actionBar.setDisplayShowTitleEnabled(false)
			actionBar.setDisplayHomeAsUpEnabled(true)
		}

		// Вводимое значение
		val editTextValue: EditText = findViewById(R.id.input_mass)
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

		// Выпадающий список единиц измерения массы
		val unitsValue: Spinner = findViewById(R.id.spinner_mass)
		// Обработчик выпадающего списка единиц измерения массы
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
				selectedUnit = UnitMass.entries[position]
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
			onBackPressedDispatcher.onBackPressed()
			return true
		}
		// Обработчик по-умолчанию
		return super.onOptionsItemSelected(item)
	}


	// Пересчёт всех значений
	fun convertValue() {
		// Получение поля ввода пользовательского значения
		val editTextValue: EditText = findViewById(R.id.input_mass)
		// Получение введённого пользователем значения и преобразование к общему знаменателю
		val inputValue = (editTextValue.text.toString().toDoubleOrNull() ?: 0.0) / selectedUnit.conversionFactor
		// Пересчёт и отображение миллиграм
		val milligrams: TextView = findViewById(R.id.value_milligrams)
		milligrams.text = (inputValue * UnitMass.MILLIGRAM.conversionFactor).toString()
		// Пересчёт и отображение грам
		val grams: TextView = findViewById(R.id.value_grams)
		grams.text = (inputValue * UnitMass.GRAM.conversionFactor).toString()
		// Пересчёт и отображение вилограм
		val kilograms: TextView = findViewById(R.id.value_kilograms)
		kilograms.text = (inputValue * UnitMass.KILOGRAM.conversionFactor).toString()
		// Пересчёт и отображение центнер
		val centners: TextView = findViewById(R.id.value_centners)
		centners.text = (inputValue * UnitMass.CENTNER.conversionFactor).toString()
		// Пересчёт и отображение тонн
		val tonnes: TextView = findViewById(R.id.value_tonnes)
		tonnes.text = (inputValue * UnitMass.TONNE.conversionFactor).toString()
		// Пересчёт и отображение фунтов
		val pounds: TextView = findViewById(R.id.value_pounds)
		pounds.text = (inputValue * UnitMass.POUND.conversionFactor).toString()
		// Пересчёт и отображение унций
		val ounces: TextView = findViewById(R.id.value_ounces)
		ounces.text = (inputValue * UnitMass.OUNCE.conversionFactor).toString()
	}


}
