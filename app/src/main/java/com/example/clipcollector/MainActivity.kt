   package com.example.clipcollector
     
         import android.content.Intent
         import android.net.Uri
         import android.os.Bundle
         import android.provider.Settings
         import android.widget.TextView
         import android.widget.Button
         import androidx.appcompat.app.AppCompatActivity
import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
    

         class MainActivity : AppCompatActivity() {
       
             private val logPath = "/sdcard/ClipCollector/cliplog.txt"

/*override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    checkStoragePermission()
}
      
private fun checkStoragePermission() {
    if (ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ),
            1001
        )
    }
}
*/
               override fun onCreate(savedInstanceState: Bundle?) {
                  super.onCreate(savedInstanceState)
                  setContentView(R.layout.activity_main)
         
                   val tvStatus = findViewById<TextView>(R.id.tvStatus)
                   val btnStart = findViewById<Button>(R.id.btnStart)
        
                   tvStatus.text = "Log file:\n$logPath"
         
                   btnStart.setOnClickListener {
                      if (!Settings.canDrawOverlays(this)) {
                          val intent = Intent(
                              Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                              Uri.parse("package:$packageName")
                           )
                          startActivity(intent)
                       } else {
                          startService(Intent(this, FloatingService::class.java))
                           tvStatus.text = "Сервис запущен\nЛог: $logPath"
                      }
                  }
               }
           }
       
