package com.mapache.mychords.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.firebase.ui.auth.AuthUI
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.mapache.mychords.R
import com.mapache.mychords.utilities.AppConstants.REQUEST_LOGIN_CODE
import com.mapache.mychords.utilities.AppConstants.pref
import com.mapache.mychords.utilities.Preferences
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var providers: List<AuthUI.IdpConfig>
    private lateinit var alertBuilder: AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this)
        initData()

        if(auth.currentUser == null && !pref.first_time){
            pref.first_time = true
            alertBuilder.create().show()
        }

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    fun initData(){
        pref = Preferences(applicationContext)
        auth = FirebaseAuth.getInstance()
        providers = Arrays.asList(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
        )

        alertBuilder = AlertDialog.Builder(this)
        alertBuilder.setMessage(R.string.welcome_message)

        alertBuilder.setPositiveButton(R.string.dialog_agree){dialogInterface, i ->
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setLockOrientation(true)
                .setAlwaysShowSignInMethodScreen(true)
                .build(), REQUEST_LOGIN_CODE)
        }
        alertBuilder.setNegativeButton(R.string.dialog_cancel, {dialogInterface, i -> })
    }
}