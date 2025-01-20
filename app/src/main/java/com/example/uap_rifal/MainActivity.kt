package com.example.uap_rifal

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputNama: EditText
    private lateinit var inputHeight: EditText
    private lateinit var radioGroupGender: RadioGroup
    private lateinit var radioMale: RadioButton
    private lateinit var radioFemale: RadioButton
    private lateinit var buttonhitung: Button
    private lateinit var outputResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi View
        inputNama = findViewById(R.id.et_name)
        inputHeight = findViewById(R.id.et_height)
        radioGroupGender = findViewById(R.id.rg_gender)
        radioMale = findViewById(R.id.rb_male)
        radioFemale = findViewById(R.id.rb_feemale)
        buttonhitung = findViewById(R.id.buttonHitung)
        outputResult = findViewById(R.id.tv_result)

        // Tombol Hitung
        buttonhitung.setOnClickListener {
            val nama = inputNama.text.toString()
            val tinggiStr = inputHeight.text.toString()

            // Validasi input
            if (nama.isEmpty() || tinggiStr.isEmpty() || radioGroupGender.checkedRadioButtonId == -1) {
                outputResult.text = "Harap isi semua data!"
                return@setOnClickListener
            }

            val tinggi = tinggiStr.toInt()
            val jenisKelamin = if (radioMale.isChecked) "Laki-laki" else "Perempuan"
            val beratIdeal: Double

            // Rumus Berat Badan Ideal
            beratIdeal = if (radioMale.isChecked) {
                (tinggi - 100) - (0.1 * (tinggi - 100))
            } else {
                (tinggi - 100) - (0.15 * (tinggi - 100))
            }

            // Menampilkan hasil
            val hasil = "Saudara $nama, Jenis Kelamin $jenisKelamin. " +
                    "Berat Badan Ideal Anda adalah %.1f kg.".format(beratIdeal)
            outputResult.text = hasil
        }
    }
}
