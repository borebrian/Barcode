@file:Suppress("DEPRECATION")

package com.example.barcode


import android.graphics.Color
import android.os.AsyncTask
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.httpGet
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.welcomepage.*
import okhttp3.OkHttpClient
import org.apache.http.client.methods.HttpGet
import org.json.JSONObject
import java.net.URL

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.welcomepage)
        setSupportActionBar(findViewById(R.id.toolbar))
        val user = editTextPhone.text.toString();
        val pass = pass.text.toString();

        forgot.setOnClickListener {
            run("http://fuelaholdings-002-site28.itempurl.com/configuration.php");
        }
        button.setOnClickListener() {
            if (user.trim().count() > 0 || pass.trim().count() > 0) {
                button.text = user.count().toString();
            } else {
                val snackBar = Snackbar.make(
                    it, "Username or password is required!",
                    Snackbar.LENGTH_LONG
                ).setAction("Action", null)
                snackBar.setActionTextColor(Color.parseColor("#01a9be"))
                val snackBarView = snackBar.view
                snackBarView.setBackgroundColor(Color.parseColor("#01a9be"))
                val textView =
                    snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
                textView.setTextColor(Color.WHITE)
                snackBar.show()
            }
        }











//    val obj = JSONObject(json.toString())
//    val personFirstName: String = obj.getString("message")
////    val personLastName: String = obj.getString("message")
//    snack(personFirstName)
////    val url1:URL;
//    val conn = url1.openConnection() as HttpURLConnection
}
    private fun run(url: String) {
//
//var response1:String
//        Fuel.get(url)
//            .response { request, response, result ->
//                println(request)
//                println(response)
//                val json_contact = JSONObject(result.get().toString())
//                val name: String = json_contact.getString("error")
//                forgot.text = name
//                println(name)
//                print(result.toString())
//                response1=name;
//                handleJSON(name)
//
////
//            }
        HTTPAsyncTask().execute("http://hmkcode-api.appspot.com/rest/api/hello/Android")
    }
    private fun handleJSON(json: String) {
        Toast.makeText(applicationContext, json,Toast.LENGTH_LONG).show()

    }
    inner class HTTPAsyncTask : AsyncTask<String, Void, String>() {
        override fun doInBackground(vararg urls: String?): String {

            return   URL("http://hmkcode-api.appspot.com/rest/api/hello/Android").readText()

        }
        override fun onPostExecute(result: String?) {
            forgot.text = result.toString()
        }
    }
}







