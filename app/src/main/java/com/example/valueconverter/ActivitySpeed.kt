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
import com.example.valueconverter.core.UnitSpeed


// Активность конвертёра скорости
class ActivitySpeed : AppCompatActivity() {


	// Текущая единица измерения
	private var selectedUnit: UnitSpeed = UnitSpeed.METERS_PER_SECOND


	// Метод вызываемый при создании активности
	@Override
	override fun onCreate(savedInstanceState: Bundle?) {

		// Вызов родительского метода
		super.onCreate(savedInstanceState)

		// Установка UI
		setContentView(R.layout.activity_speed)
		setSupportActionBar(findViewById(R.id.activity_toolbar))

		// Параметры верхних кнопок
		supportActionBar?.let { actionBar ->
			actionBar.setDisplayShowTitleEnabled(false)
			actionBar.setDisplayHomeAsUpEnabled(true)
		}

		// Вводимое значение
		val editTextValue: EditText = findViewById(R.id.input_speed)
		// Обработчик введённого значения
		editTextValue.addTextChangedListener(object : TextWatcher {

			// До изменения значения - без реализации
			@Override
			override fun beforeTextChanged(
				s: CharSequence?,
				start: Int,
				count: Int,
				after: Int
			) {
			}

			// В процессе изменения значения - без реализации
			@Override
			override fun onTextChanged(
				s: CharSequence?,
				start: Int,
				before: Int,
				count: Int
			) {
			}

			// После изменения значения
			@Override
			override fun afterTextChanged(s: Editable?) {
				// Пересчёт всех значений
				convertValue()
			}

		})

		// Выпадающий список единиц измерения скорости
		val unitsValue: Spinner = findViewById(R.id.spinner_speed)
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
				selectedUnit = UnitSpeed.entries[position]
				// Пересчёт всех значений
				convertValue()
			}

			// Ничего не выбрано - без реализации
			@Override
			override fun onNothingSelected(parent: AdapterView<*>?) {
			}

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
		val editTextValue: EditText = findViewById(R.id.input_speed)
		// Получение введённого пользователем значения и преобразование к общему знаменателю
		val inputValue = (editTextValue.text.toString().toDoubleOrNull() ?: 0.0) / selectedUnit.conversionFactor
		// Пересчёт и отображение метров в секунду
		val mps: TextView = findViewById(R.id.value_meters_per_second)
		mps.text = (inputValue * UnitSpeed.METERS_PER_SECOND.conversionFactor).toString()
		// Пересчёт и отображение километров в час
		val kmph: TextView = findViewById(R.id.value_kilometers_per_hour)
		kmph.text = (inputValue * UnitSpeed.KILOMETERS_PER_HOUR.conversionFactor).toString()
		// Пересчёт и отображение миль в час
		val milph: TextView = findViewById(R.id.value_miles_per_hour)
		milph.text = (inputValue * UnitSpeed.MILES_PER_HOUR.conversionFactor).toString()
	}


}
