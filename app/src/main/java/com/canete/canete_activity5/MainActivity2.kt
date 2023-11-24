package com.canete.canete_activity5

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    private val takePictureLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                showToast("Photo captured successfully")
                // Handle the captured photo if needed
            } else {
                showToast("Photo capture canceled or failed")
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val cameraButton: Button = findViewById(R.id.cameraButton)
        val locationButton: Button = findViewById(R.id.locationButton)
        val storageButton: Button = findViewById(R.id.storageButton)

        cameraButton.setOnClickListener {
            openCamera()
        }

        locationButton.setOnClickListener {
            openLocation()
        }

        storageButton.setOnClickListener {
            openStorage()
        }
    }

    private fun openCamera() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) == null) {
            takePictureLauncher.launch(takePictureIntent)
        } else {
            showToast("No camera app found on the device")
        }
    }

    private fun openLocation() {
        showToast("Opening map for location...")
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="))
        startActivity(intent)
    }

    private fun openStorage() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "*/*"
        startActivityForResult(intent, 0) // You can replace 0 with an appropriate request code
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}