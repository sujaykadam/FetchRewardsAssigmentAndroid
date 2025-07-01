import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter

class StringAdapter : TypeAdapter<String>() {
    override fun write(out: JsonWriter, value: String?) {
        out.value(value ?: "")
    }

    override fun read(`in`: JsonReader): String {
        return if (`in`.peek() == JsonToken.NULL) {
            `in`.nextNull()
            ""
        } else {
            `in`.nextString()
        }
    }
}
