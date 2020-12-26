package am.develop.rssfeed.core.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.prof.rssparser.Image

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

    @TypeConverter
    fun imageDataToJson(additionalDataList: Image) : String{
        return Gson().toJson(additionalDataList)
    }

    @TypeConverter
    fun fromJsonToImageDataList(json: String): Image{
        val listType = object : TypeToken<Image>() {}.type
        return Gson().fromJson(json, listType)
    }
}