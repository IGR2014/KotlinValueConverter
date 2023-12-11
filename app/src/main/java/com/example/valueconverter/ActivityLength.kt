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


	//
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

		//
		val editTextValue: EditText = findViewById(R.id.input_length)
		editTextValue.addTextChangedListener(object : TextWatcher {

			@Override
			override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

			@Override
			override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

			@Override
			override fun afterTextChanged(s: Editable?) {
				convertValue()
			}
		})

		//
		val unitsValue: Spinner = findViewById(R.id.spinner_length)
		unitsValue.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

			@Override
			override fun onItemSelected(
				parent: AdapterView<*>?,
				view: View?,
				position: Int,
				id: Long
			) {
				selectedUnit = UnitLength.entries[position]
				convertValue()
			}

			@Override
			override fun onNothingSelected(parent: AdapterView<*>?) {}

		}

	}

	// Метод вызываемый при обработке взаимодействия с различными елементами интерфейса
	@Override
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		if (item.itemId == android.R.id.home) {
			onBackPressed()
			return true
		}
		return super.onOptionsItemSelected(item)
	}


	//
	fun convertValue() {
		//
		val editTextValue: EditText = findViewById(R.id.input_length)
		//
		val inputValue = editTextValue.text.toString().toDoubleOrNull()
		//
		if (null != inputValue) {
			//
			val millimeters: TextView = findViewById(R.id.value_millimeters)
			millimeters.text = (inputValue / selectedUnit.conversionFactor * UnitLength.MILLIMETER.conversionFactor).toString()
			//
			val centimeters: TextView = findViewById(R.id.value_centimeters)
			centimeters.text = (inputValue / selectedUnit.conversionFactor * UnitLength.CENTIMETER.conversionFactor).toString()
		}
	}


}
