package datatypes

import com.google.api.client.util.Key
import datatypes.not_implemented.*

class Message(

		@Key("message_id") var messageId: Int = -1,
		@Key var from: User? = null,
		@Key var date: Int = -1,
		@Key var chat: Chat = Chat(),
		@Key("forward_from") var forwardFrom: User? = null,
		@Key("forward_from_chat") var forwardFromChat: Chat? = null,
		@Key("forward_from_message_id") var forwardFromMessageId: Int? = null,
		@Key("forward_date") var forwardDate: Int? = null,
		@Key("reply_to_message") var replyToMessage: Message? = null,
		@Key("edit_date") var editDate: Int? = null,
		@Key var text: String? = null,
		@Key var entities: Array<MessageEntity>? = null,
		@Key var audio: Audio? = null,
		@Key var document: Document? = null,
		@Key var photo: Array<MessageEntity>? = null,
		@Key var sticker: Sticker? = null,
		@Key var video: Video? = null,
		@Key var voice: Voice? = null,
		@Key var caption: String? = null,
		@Key var contact: Contact? = null,
		@Key var location: Location? = null,
		@Key var venue: Venue? = null,
		@Key("new_char_member") var newCharMember: User? = null,
		@Key("left_chat_member") var leftChatMember: User? = null,
		@Key("new_char_title") var newCharTitle: String? = null,
		@Key("new_chat_photo") var newChatPhoto: Array<PhotoSize>? = null,
		@Key("delete_chat_photo") var deleteChatPhoto: Boolean? = null,
		@Key("group_chat_created") var groupChatCreated: Boolean? = null,
		@Key("supergroup_chat_created") var supergroupChatCreated: Boolean? = null,
		@Key("channel_chat_created") var channelChatCreated: Boolean? = null,
		@Key("migrate_to_chat_id") var migrateToChatId: Int? = null,
		@Key("migrate_from_chat_id") var migrateFromChatId: Int? = null,
		@Key("pinned_message") var pinnedMessage: Message? = null
)