package vn.luongvo.appcompatviewex;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/**
 * Created by luongvo on 3/26/18.
 */

public class AppCompatButtonEx extends AppCompatButton {

    public AppCompatButtonEx(Context context) {
        super(context);
    }

    public AppCompatButtonEx(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
    }

    public AppCompatButtonEx(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
    }

    void initAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray attributeArray = context.obtainStyledAttributes(
                    attrs,
                    R.styleable.AppCompatButtonEx);

            Drawable drawableLeft = null;
            Drawable drawableRight = null;
            Drawable drawableBottom = null;
            Drawable drawableTop = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                drawableLeft = attributeArray.getDrawable(R.styleable.AppCompatButtonEx_drawableLeftCompat);
                drawableRight = attributeArray.getDrawable(R.styleable.AppCompatButtonEx_drawableRightCompat);
                drawableBottom = attributeArray.getDrawable(R.styleable.AppCompatButtonEx_drawableBottomCompat);
                drawableTop = attributeArray.getDrawable(R.styleable.AppCompatButtonEx_drawableTopCompat);
            } else {
                final int drawableLeftId = attributeArray.getResourceId(R.styleable.AppCompatButtonEx_drawableLeftCompat, -1);
                final int drawableRightId = attributeArray.getResourceId(R.styleable.AppCompatButtonEx_drawableRightCompat, -1);
                final int drawableBottomId = attributeArray.getResourceId(R.styleable.AppCompatButtonEx_drawableBottomCompat, -1);
                final int drawableTopId = attributeArray.getResourceId(R.styleable.AppCompatButtonEx_drawableTopCompat, -1);

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
