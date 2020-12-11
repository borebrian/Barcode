@file:Suppress("DEPRECATION")

package com.example.barcode


import android.graphics.Color
import android.os.AsyncTask
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.httpGet
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.welcomepage.*
import kotlinx.android.synthetic.main.welcomepage.view.*
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
        load.visibility=View.GONE;



        forgot.setOnClickListener {
            HTTPAsyncTask().execute("http://hmkcode-api.appspot.com/rest/api/hello/Android")
        }
        button.setOnClickListener() {
            val user = editTextPhone.text.toString();
            val passdata = pass.text.toString();
            if (TextUtils.isEmpty(user)) {
                editTextPhone.error = "Please enter username here!";

            } else if (TextUtils.isEmpty(passdata)) {
                pass.error = "Please enter password here!";

            } else{

                HTTPAsyncTask().execute("http://hmkcode-api.appspot.com/rest/api/hello/Android")


                    Toast.makeText(this,"Filled",Toast.LENGTH_LONG).show()

//                button.text = pass.text
//
//                val snackBar = Snackbar.make(
//                    it, "Username or password is required!",
//                    Snackbar.LENGTH_LONG
//                ).setAction("Action", null)
//                snackBar.setActionTextColor(Color.parseColor("#01a9be"))
//                val snackBarView = snackBar.view
//                snackBarView.setBackgroundColor(Color.parseColor("#01a9be"))
//                val textView =
//                    snackBarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
//                textView.setTextColor(Color.WHITE)
//                snackBar.show()
//                button.text = editTextPhone.text;

                }
            }

    }


    inner class HTTPAsyncTask : AsyncTask<String, Void, String>() {
        override fun doInBackground(vararg urls: String?): String {

            runOnUiThread {
                forgot.visibility = View.GONE;
                button.visibility=View.GONE;
                load.visibility=View.VISIBLE;
            }




            return   URL("http://fuelaholdings-002-site28.itempurl.com/configuration.php").readText()

        }
        override fun onPostExecute(result: String?) {
            runOnUiThread {

            forgot.visibility = View.VISIBLE;
            button.visibility=View.VISIBLE;
            load.visibility=View.GONE;
                val obj = JSONObject(result)
                val employee: JSONObject = obj.getJSONObject("error")

            forgot.text = employee.toString()
        }
        }
    }
}







