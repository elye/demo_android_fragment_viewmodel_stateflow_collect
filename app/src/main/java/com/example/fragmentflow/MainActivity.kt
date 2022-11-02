package com.example.fragmentflow

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private fun getRandomTag() = Random(100000).toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Track", "MainActivity onCreate")

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, XmlFragment())
                .commit()
        }

        findViewById<Button>(R.id.btn_add_xml_fragment).setOnClickListener {
            addXmlFragment()
        }

        findViewById<Button>(R.id.btn_add_compose_fragment).setOnClickListener {
            addComposeFragment()
        }
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        Log.d("Track", "MainActivity onCreateView")
        return super.onCreateView(name, context, attrs)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Track", "MainActivity onDestroy")
    }

    private fun addXmlFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, XmlFragment())
            .addToBackStack(getRandomTag())
            .commit()
    }

    private fun addComposeFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, ComposeFragment())
            .addToBackStack(getRandomTag())
            .commit()
    }
}
