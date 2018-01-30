package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.manager

import android.content.Context
import android.graphics.Typeface
import android.text.TextUtils

import java.util.HashMap

enum class FontManager {
    INSTANCE;

    private var mContext: Context? = null
    private val mapTypefaces = HashMap<String, Typeface>(16)

    fun setTypeface(fontName: String): Typeface? {
        var fontName = fontName
        if (TextUtils.isEmpty(fontName)) {
            fontName = DEFAULT_FONT
        }
        var tf: Typeface? = mapTypefaces[fontName]
        if (tf != null) {
            return tf
        }
        tf = getTypefaceAsset(fontName)
        mapTypefaces.put(fontName, tf)
        return tf
    }


    fun getTypefaceAsset(fontName: String): Typeface {
        try {
            return Typeface.createFromAsset(mContext!!.assets, "fonts/" + fontName)
        } catch (e: Exception) {
            return Typeface.DEFAULT
        }

    }

    companion object {

        val DEFAULT_FONT = "opensansregular.ttf"

        fun init(mContext: Context) {
            INSTANCE.mContext = mContext
        }
    }
}