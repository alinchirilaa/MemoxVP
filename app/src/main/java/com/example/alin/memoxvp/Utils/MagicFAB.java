package com.example.alin.memoxvp.Utils;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.alin.memoxvp.R;

public class MagicFAB extends FrameLayout {

    private RelativeLayout relativeLayout;
    private FloatingActionButton fab;
    private static OnClickListener onClickListener;
    private TypedArray attrs;
    private int fabBackground;
    private Context context;
    private Intent intent;


    public MagicFAB(Context context) {
        this(context, null);
    }

    public MagicFAB(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.magic_fab, this);
        this.context = context;
        this.attrs = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MagicFAB, 0, 0);
    }

    public interface OnClickListener {
        void onClick(MagicFAB magicFAB, View v);
    }


    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public void onResume() {
        this.relativeLayout.setVisibility(INVISIBLE);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        loadViews();
        registerListeners();
        initialize();

    }

    private void loadViews() {
        fab = (FloatingActionButton) findViewById(R.id.magic_fab_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.fab_container);

    }

    private void registerListeners() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(MagicFAB.this, v);
            }
        });
    }

    private void initialize() {
        try {
            fab.setImageDrawable(attrs.getDrawable(R.styleable.MagicFAB_fab_icon));
            int white = 0x0fFFFFFF;
            fab.setBackgroundTintList(ColorStateList.valueOf(attrs.getColor(R.styleable.MagicFAB_fab_color, white)));
            fabBackground = attrs.getColor(R.styleable.MagicFAB_reveal_color, 0);
            relativeLayout.setBackgroundColor(fabBackground);
        } finally {
            attrs.recycle();
        }
    }

    public void activityAnimation() {
        float finalRadius = Math.max(relativeLayout.getWidth(), relativeLayout.getHeight());
        animateReveal(0, finalRadius);
    }

    public void setOnClickListener(OnClickListener listener) {
        onClickListener = listener;
    }

    private void animateReveal(float initialRadius, float finalRadius) {
        int x = fab.getLeft() + fab.getMeasuredWidth() / 2;
        int y = fab.getTop() + fab.getMeasuredHeight() / 2;

        Animator animator = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            animator = ViewAnimationUtils.createCircularReveal(relativeLayout, x, y, initialRadius, finalRadius);
            relativeLayout.setVisibility(VISIBLE);
            animator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    context.startActivity(intent);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }


            });

            animator.start();

        } else {
            context.startActivity(intent);
        }

    }
}