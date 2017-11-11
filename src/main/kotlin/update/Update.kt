package update

import com.google.api.client.util.Key
import datatypes.Message
import datatypes.not_implemented.CallbackQuery
import datatypes.not_implemented.InlineQuery
import datatypes.not_implemented.ChosenInlineResult

class Updates(
		@Key val ok: Boolean = true,
		@Key var result: List<Update> = listOf()
)

//TODO More fields will be added when relevant.
class Update(
		@Key("update_id") var updateId: Int = -1,
		@Key var message: Message? = null,
		@Key("edited_message") var editedMessage: Message? = null,
		@Key("inline_query") var inlineQuery: InlineQuery? = null,
		@Key("chosen_inline_result") var chosenInlineResult: ChosenInlineResult? = null,
		@Key("callback_query") var callbackQuery: CallbackQuery? = null
)