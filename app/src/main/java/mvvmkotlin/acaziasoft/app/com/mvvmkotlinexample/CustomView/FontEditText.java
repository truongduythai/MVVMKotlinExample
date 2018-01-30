package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.CustomView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.R;
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.manager.FontManager;


public class FontEditText extends AppCompatEditText {
	private static final String TAG = FontEditText.class.getSimpleName();
	private int fontColor;

	public FontEditText(Context context) {
		this(context, null, R.attr.editTextStyle);
		setNormal(true);
	}

	public FontEditText(Context context, AttributeSet attrs) {
		this(context, attrs, R.attr.editTextStyle);
		setNormal(true);

	}

	public FontEditText(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		setNormal(true);

		if (isInEditMode()) {
			return;
		}
		TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.FontEditText,
				defStyleAttr, 0);
		try {
			fontName = a.getString(R.styleable.FontEditText_fontAssets);
			fontColor = a.getColor(R.styleable.FontTextView_fontColor, getResources().getColor(R.color.color_blank));

		} finally {
			a.recycle();
		}
		Typeface typeface = FontManager.INSTANCE.setTypeface(fontName);
		setTextColor(fontColor);
		setTypeface(typeface);
	}

	private String fontName;

	public String getFontName() {
		return fontName;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
		Typeface typeface = FontManager.INSTANCE.setTypeface(fontName);
		setTypeface(typeface);
		invalidate();
	}

	public void setNormal(boolean isNormal){
		if(isNormal)
			setFontName(getResources().getString(R.string.prompt_light_font));
		else
			setFontName(FontManager.Companion.getDEFAULT_FONT());
	}
}