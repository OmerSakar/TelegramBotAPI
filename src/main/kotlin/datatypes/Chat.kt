package datatypes

import com.google.api.client.util.Key


//TODO More fields will be added when needed.
data class Chat (
    @Key var id: Int = -1,
    @Key var type: String = "",
    @Key var title: String? = null,
    @Key var username: String? = null,
    @Key("first_name") var firstName: String? = null,
    @Key("last_name") var lastName: String? = null
)