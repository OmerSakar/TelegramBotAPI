package datatypes

data class MessageEntity (
	val type: String = "",
	val offset: Int = -1,
	val length: Int = -1,
	val url: String? = null,
	val user: User? = null
)