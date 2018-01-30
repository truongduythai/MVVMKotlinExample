package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.CustomView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.R;
import mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.manager.FontManager;


public class FontTextView extends AppCompatTextView {

    public FontTextView(Context context) {
        this(context, null, 0);
        setNormal(true);
    }

    public FontTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        setNormal(true);
        if (isInEditMode()) {
            return;
        }
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.FontTextView);
        try {
            fontName = a.getString(R.styleable.FontTextView_fontAssets);
            fontColor = a.getColor(R.styleable.FontTextView_fontColor, getResources().getColor(R.color.color_blank));
        } finally {
            a.recycle();
        }
        Typeface typeface = FontManager.INSTANCE.setTypeface(fontName);
        setTextColor(fontColor);
        setTypeface(typeface);
        invalidate();
    }

    public FontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setNormal(true);
        if (isInEditMode()) {
            return;
        }
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.FontTextView, defStyleAttr, 0);
        try {
            fontName = a.getString(R.styleable.FontTextView_fontAssets);
            fontColor = a.getColor(R.styleable.FontTextView_fontColor, getResources().getColor(R.color.color_blank));
        } finally {
            a.recycle();
        }
        Typeface typeface = FontManager.INSTANCE.setTypeface(fontName);
        setTextColor(fontColor);
        setTypeface(typeface);
        invalidate();
    }

    private String fontName;
    private int fontColor;
//    private String fontColor;

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
        Typeface typeface = FontManager.INSTANCE.setTypeface(fontName);
        setTypeface(typeface);
        invalidate();
    }

    public void setFontColor(int fontColor) {
        this.fontColor = fontColor;
        setTextColor(getResources().getColor(fontColor));
        invalidate();
    }
    //    public void setFontColor(int fontColor) {
//        this.fontColor = fontColor;
//        setTextColor(fontColor);
//        invalidate();
//    }

    public void setNormal(boolean isNormal) {
        if (isNormal)
            setFontName(getResources().getString(R.string.prompt_light_font));
        else
            setFontName(FontManager.DEFAULT_FONT);
    }


    public void setBold(boolean isBold) {
        if (isBold)
            setFontName(getResources().getString(R.string.prompt_regular_font));
        else
            setFontName(FontManager.DEFAULT_FONT);
    }

    public void setSpacing(float spacing) {
        if (Build.VERSION.SDK_INT >= 21)
            setLetterSpacing(spacing);
    }

}