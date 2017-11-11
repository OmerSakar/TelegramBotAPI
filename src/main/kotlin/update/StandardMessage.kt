package update

import com.google.api.client.util.Key

/**
 * Created by omer on 20-11-16.
 */
data class StandardMessage<T> (
	@Key var ok: Boolean = true,
	@Key var result: T? = null
)