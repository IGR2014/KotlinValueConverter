package com.example.valueconverter


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


// Главная активность приложения
class ActivityMain : AppCompatActivity() {


	// Переключатель выезжающего меню
	private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle


	// Метод вызываемый при создании активности
	@Override
	override fun onCreate(savedInstanceState: Bundle?) {

		// Вызов родительского метода
		super.onCreate(savedInstanceState)

		// Установка UI
		setContentView(R.layout.activity_main)
		setSupportActionBar(findViewById(R.id.activity_toolbar))

		// Установка UI выезжающего меню
		val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
		// Установка навигации выезжающего меню
		val navigationView: NavigationView = findViewById(R.id.navigation_view)

		// Установка переключателя выезжающего меню
		actionBarDrawerToggle = ActionBarDrawerToggle(
			this as Activity,
			drawerLayout,
			R.string.drawer_open,
			R.string.drawer_close
		)
		// Устанвока обработчика выезжающего меню
		drawerLayout.addDrawerListener(actionBarDrawerToggle)
		// Синхронизация состояния выезжающего меню
		actionBarDrawerToggle.syncState()

		// Обработка навигации выезжающего меню
		navigationView.setNavigationItemSelectedListener { item: MenuItem ->
			when (item.itemId) {
				// Конвертёр длин
				R.id.nav_length -> {
					// Запуск активности конвертёра длин
					startActivity(
						Intent(
							applicationContext,
							ActivityLength::class.java
						)
					)
					// Закрытие выезжающих меню
					drawerLayout.closeDrawers()
				}
				// Конвертёр масс
				R.id.nav_mass -> {
					// Запуск активности конвертёра масс
					startActivity(
						Intent(
							applicationContext,
							ActivityMass::class.java
						)
					)
					// Закрытие выезжающих меню
					drawerLayout.closeDrawers()
				}
				// Конвертёр времени
				R.id.nav_time -> {
					// Запуск активности конвертёра времени
					startActivity(
						Intent(
							applicationContext,
							ActivityTime::class.java
						)
					)
					// Закрытие выезжающих меню
					drawerLayout.closeDrawers()
				}
				// Конвертёр скорости
				R.id.nav_speed -> {
					// Запуск активности конвертёра скорости
					startActivity(
						Intent(
							applicationContext,
							ActivitySpeed::class.java
						)
					)
					// Закрытие выезжающих меню
					drawerLayout.closeDrawers()
				}
			}
			true
		}

		// Параметры верхних кнопок
		supportActionBar?.let { actionBar ->
			actionBar.setDisplayShowTitleEnabled(false)
			actionBar.setHomeAsUpIndicator(R.drawable.ic_list)
			actionBar.setDisplayHomeAsUpEnabled(true)
		}

		// Обработчик кнопки конвертёра длин
		val buttonLength: Button = findViewById(R.id.button_length)
		buttonLength.setOnClickListener {
			// Запуск активности конвертёра длин
			startActivity(
				Intent(
					applicationContext,
					ActivityLength::class.java
				)
			)
		}

		// Обработчик кнопки конвертёра масс
		val buttonMass: Button = findViewById(R.id.button_mass)
		buttonMass.setOnClickListener {
			// Запуск активности конвертёра длин
			startActivity(
				Intent(
					applicationContext,
					ActivityMass::class.java
				)
			)
		}

		// Обработчик кнопки конвертёра времени
		val buttonTime: Button = findViewById(R.id.button_time)
		buttonTime.setOnClickListener {
			// Запуск активности конвертёра длин
			startActivity(
				Intent(
					applicationContext,
					ActivityTime::class.java
				)
			)
		}

		// Обработчик кнопки конвертёра скорости
		val buttonSpeed: Button = findViewById(R.id.button_speed)
		buttonSpeed.setOnClickListener {
			// Запуск активности конвертёра длин
			startActivity(
				Intent(
					applicationContext,
					ActivitySpeed::class.java
				)
			)
		}

	}


	// Метод вызываемый при обработке взаимодействия с различными елементами интерфейса
	@Override
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
			true
		} else super.onOptionsItemSelected(item)
	}


}
