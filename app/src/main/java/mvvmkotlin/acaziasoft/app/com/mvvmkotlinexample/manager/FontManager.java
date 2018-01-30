package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.manager;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;

import java.util.HashMap;

public enum FontManager {
	INSTANCE;

	public static final String DEFAULT_FONT ="opensansregular.ttf";
	private Context mContext;
	private HashMap<String, Typeface> mapTypefaces = new HashMap<>(16);

	public static void init(Context mContext) {
		INSTANCE.mContext = mContext;
	}

	public Typeface setTypeface(String fontName) {
		if (TextUtils.isEmpty(fontName)){
			fontName = DEFAULT_FONT;
		}
		Typeface tf = mapTypefaces.get(fontName);
		if (tf != null) {
			return tf;
		}
		tf = getTypefaceAsset(fontName);
		mapTypefaces.put(fontName, tf);
		return tf;
	}


	public Typeface getTypefaceAsset(String fontName) {
		try {
			return Typeface.createFromAsset(mContext.getAssets(), "fonts/" + fontName);
		} catch (Exception e) {
			return Typeface.DEFAULT;
		}
	}
}