package update

import com.google.api.client.http.GenericUrl
import com.google.api.client.util.Key

class TelegramUrl(encodedUrl: String) : GenericUrl(encodedUrl) {

	@Key
	var fields: String? = null
}
