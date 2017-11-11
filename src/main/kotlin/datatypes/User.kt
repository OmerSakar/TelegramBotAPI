package datatypes

import com.google.api.client.util.Key


data class User (
		@Key var id: Int = -1,
		@Key("first_name") var firstName: String = "",
		@Key("last_name") var lastName: String? = null,
		@Key var username: String? = null,
        @Key("language_code") var languageCode: String? = null
)