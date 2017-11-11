package update

import com.google.api.client.http.HttpRequest
import com.google.api.client.http.HttpRequestFactory
import com.google.api.client.http.HttpRequestInitializer
import com.google.api.client.http.HttpTransport
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.JsonFactory
import com.google.api.client.json.JsonObjectParser
import com.google.api.client.json.jackson2.JacksonFactory

/**
 * Created by omer on 20-11-16.
 */
object Variables {
	val HTTP_TRANSPORT = NetHttpTransport()
	val jsonFactory: JsonFactory = JacksonFactory()
	var token = ""
	val baseUrl = "https://api.telegram.org/bot" + token

	val httpRequestFactory: HttpRequestFactory
		get() = HTTP_TRANSPORT.createRequestFactory { request -> request.parser = JsonObjectParser(jsonFactory) }

}

