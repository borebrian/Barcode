//package com.example.barcode
//
//import java.io.*
//import java.net.HttpURLConnection
//import java.net.URL
//import java.net.URLEncoder
//import javax.net.ssl.HttpsURLConnection
//
//
//public class RequestHandler {
//
//    fun sendPostRequest(
//        requestURL: String?,
//        postDataParams: HashMap<String?, String?>?
//    ): String? {
//        val url: URL
//        var sb = StringBuilder()
//        try {
//            url = URL(requestURL)
//            val conn: HttpURLConnection = url.openConnection() as HttpURLConnection
//            conn.readTimeout = 15000
//            conn.connectTimeout = 15000
//            conn.requestMethod = "POST"
//            conn.doInput = true
//            conn.doOutput = true
//            val os: OutputStream = conn.getOutputStream()
//            val writer = BufferedWriter(
//                OutputStreamWriter(os, "UTF-8")
//            )
//            writer.write(getPostDataString(postDataParams))
//            writer.flush()
//            writer.close()
//            os.close()
//            val responseCode: Int = conn.getResponseCode()
//            if (responseCode == HttpsURLConnection.HTTP_OK) {
//                val br = BufferedReader(InputStreamReader(conn.getInputStream()))
//                sb = StringBuilder()
//                var response: String?
//                while (br.readLine().also { response = it } != null) {
//                    sb.append(response)
//                }
//            }
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//        return sb.toString()
//    }
//
////    @Throws(UnsupportedEncodingException::class)
////    private fun getPostDataString(params: HashMap<String?, String?>?): String? {
////        val result = java.lang.StringBuilder()
////        var first = true
////        for ((key, value) in params.entrySet()) {
////            if (first) first = false else result.append("&")
////            result.append(URLEncoder.encode(key, "UTF-8"))
////            result.append("=")
////            result.append(URLEncoder.encode(value, "UTF-8"))
////        }
////        return result.toString()
////    }
//}