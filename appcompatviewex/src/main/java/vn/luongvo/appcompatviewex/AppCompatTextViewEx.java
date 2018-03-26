package vn.luongvo.appcompatviewex;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by luongvo on 3/26/18.
 */

public class AppCompatTextViewEx extends AppCompatTextView {

    public AppCompatTextViewEx(Context context) {
        super(context);
    }

    public AppCompatTextViewEx(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
    }

    public AppCompatTextViewEx(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
    }

    void initAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray attributeArray = context.obtainStyledAttributes(
                    attrs,
                    R.styleable.AppCompatTextViewEx);

            Drawable drawableLeft = null;
            Drawable drawableRight = null;
            Drawable drawableBottom = null;
            Drawable drawableTop = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                drawableLeft = attributeArray.getDrawable(R.styleable.AppCompatTextViewEx_drawableLeftCompat);
                drawableRight = attributeArray.getDrawable(R.styleable.AppCompatTextViewEx_drawableRightCompat);
                drawableBottom = attributeArray.getDrawable(R.styleable.AppCompatTextViewEx_drawableBottomCompat);
                drawableTop = attributeArray.getDrawable(R.styleable.AppCompatTextViewEx_drawableTopCompat);
            } else {
                final int drawableLeftId = attributeArray.getResourceId(R.styleable.AppCompatTextViewEx_drawableLeftCompat, -1);
                final int drawableRightId = attributeArray.getResourceId(R.styleable.AppCompatTextViewEx_drawableRightCompat, -1);
                final int drawableBottomId = attributeArray.getResourceId(R.styleable.AppCompatTextViewEx_drawableBottomCompat, -1);
                final int drawableTopId = attributeArray.getResourceId(R.styleable.AppCompatTextViewEx_drawableTopCompat, -1);

                if (drawableLeftId != -1)
                    drawableLeft = AppCompatResources.getDrawable(context, drawableLeftId);
                if (drawableRightId != -1)
                    drawableRight = AppCompatResources.getDrawable(context, drawableRightId);
                if (drawableBottomId != -1)
                    drawableBottom = AppCompatResources.getDrawable(context, drawableBottomId);
                if (drawableTopId != -1)
                    drawableTop = AppCompatResources.getDrawable(context, drawableTopId);
            }
            setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom);
            attributeArray.recycle();
        }
    }
}
