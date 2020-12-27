package am.develop.rssfeed.core.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by Ara Hakobyan on 12/24/2020.
 * Company IDT
 */
class Converters {
    @TypeConverter
    fun categoryDataToJson(additionalDataList: List<String>) : String{
        return Gson().toJson(additionalDataList)
    }

    @TypeConverter
    fun fromJsonToCategoryDataList(json: String): List<String>{
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(json, listType)
    }
}