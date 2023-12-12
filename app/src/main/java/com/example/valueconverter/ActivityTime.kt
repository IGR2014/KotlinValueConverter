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
import com.example.valueconverter.core.UnitTime


// Активность конвертёра времени
class ActivityTime : AppCompatActivity() {


	// Текущая единица измерения
	private var selectedUnit: UnitTime = UnitTime.SECOND


	// Метод вызываемый при создании активности
	@Override
	override fun onCreate(savedInstanceState: Bundle?) {

		// Вызов родительского метода
		super.onCreate(savedInstanceState)

		// Установка UI
		setContentView(R.layout.activity_time)
		setSupportActionBar(findViewById(R.id.activity_toolbar))

		// Параметры верхних кнопок
		supportActionBar?.let { actionBar ->
			actionBar.setDisplayShowTitleEnabled(false)
			actionBar.setDisplayHomeAsUpEnabled(true)
		}

		// Вводимое значение
		val editTextValue: EditText = findViewById(R.id.input_time)
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

		// Выпадающий список единиц измерения времени
		val unitsValue: Spinner = findViewById(R.id.spinner_time)
		// Обработчик выпадающего списка единиц измерения времени
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
				selectedUnit = UnitTime.entries[position]
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
		val editTextValue: EditText = findViewById(R.id.input_time)
		// Получение введённого пользователем значения и преобразование к общему знаменателю
		val inputValue = (editTextValue.text.toString().toDoubleOrNull() ?: 0.0) / selectedUnit.conversionFactor
		// Пересчёт и отображение микросекунд
		val microseconds: TextView = findViewById(R.id.value_microseconds)
		microseconds.text = (inputValue * UnitTime.MICROSECOND.conversionFactor).toString()
		// Пересчёт и отображение милисекунд
		val milliseconds: TextView = findViewById(R.id.value_milliseconds)
		milliseconds.text = (inputValue * UnitTime.MILLISECOND.conversionFactor).toString()
		// Пересчёт и отображение секунд
		val seconds: TextView = findViewById(R.id.value_seconds)
		seconds.text = (inputValue * UnitTime.SECOND.conversionFactor).toString()
		// Пересчёт и отображение минут
		val minutes: TextView = findViewById(R.id.value_minutes)
		minutes.text = (inputValue * UnitTime.MINUTE.conversionFactor).toString()
		// Пересчёт и отображение часов
		val hours: TextView = findViewById(R.id.value_hours)
		hours.text = (inputValue * UnitTime.HOUR.conversionFactor).toString()
		// Пересчёт и отображение дней
		val days: TextView = findViewById(R.id.value_days)
		days.text = (inputValue * UnitTime.DAY.conversionFactor).toString()
		// Пересчёт и отображение недель
		val weeks: TextView = findViewById(R.id.value_weeks)
		weeks.text = (inputValue * UnitTime.WEEK.conversionFactor).toString()
		// Пересчёт и отображение месяцев
		val months: TextView = findViewById(R.id.value_months)
		months.text = (inputValue * UnitTime.MONTH.conversionFactor).toString()
		// Пересчёт и отображение лет
		val years: TextView = findViewById(R.id.value_years)
		years.text = (inputValue * UnitTime.YEAR.conversionFactor).toString()
	}


}
