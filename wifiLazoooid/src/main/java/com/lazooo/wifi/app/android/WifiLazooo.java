package com.lazooo.wifi.app.android;/**
 * Lazooo copyright 2012
 */

import android.graphics.Typeface;
import android.text.Html;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lazooo.wifi.app.android.components.SlidingTabs;
import com.lazooo.wifi.app.android.fragments.Home;
import com.lazooo.wifi.app.android.fragments.Info;
import com.lazooo.wifi.app.android.fragments.Trend;
import com.lazooo.wifi.app.android.fragments.User;

import java.util.LinkedList;
import java.util.List;

/**
 * @author giok57
 * @email gioelemeoni@gmail.com
 * @modifiedBy giok57
 * <p/>
 * Date: 11/06/14
 * Time: 23:14
 */
public class WifiLazooo extends android.app.Application {

    private static WifiLazooo application = null;
    private SlidingTabs mMainTab;
    private Typeface typefaceBariol;
    private Typeface typefaceFontello;
    private Typeface typefaceBariolThin;


    private static final List<SlidingTabs.TabItem> mMainTabs = new LinkedList<SlidingTabs.TabItem>();

    static {
        mMainTabs.add(new SlidingTabs.TabItem(
                        "Home", "This is the very first interaction view, do searches etc.", "!", Home.class, "#F0645A")
        );
        mMainTabs.add(new SlidingTabs.TabItem(
                        "Info", "This is the very first interaction view, do searches etc.", "F", Info.class, "#80C8FE")
        );
        mMainTabs.add(new SlidingTabs.TabItem(
                        "Trend", "This is the very first interaction view, do searches etc.", "?", Trend.class, "#00B366")
        );
        mMainTabs.add(new SlidingTabs.TabItem(
                        "User", "This is the very first interaction view, do searches etc.", "I", User.class, "#FFCC00")
        );
    }
    @Override
    public void onCreate() {

        super.onCreate();
        mMainTab = new SlidingTabs();
        mMainTab.setTabs(mMainTabs);
        WifiLazooo.application = this;
        typefaceBariol = Typeface.createFromAsset(getAssets(), "fonts/Bariol_Bold.otf");
        typefaceFontello = Typeface.createFromAsset(getAssets(), "fonts/fontello.ttf");
        typefaceBariolThin = Typeface.createFromAsset(getAssets(), "fonts/Bariol_Regular.otf");

    }


    public TextView getmTitle(String text, String color){

        TextView mTitle = new TextView(this);
        //mTitle.setTextColor(getResources().getColor(R.color.brown_background));
        mTitle.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        mTitle.setGravity(Gravity.CENTER_VERTICAL);
        mTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 28);
        String htmlText = "</font><font color=#FCF3E1>" + text + "</font><font color=" + color + "></font>";
        mTitle.setText(Html.fromHtml(htmlText));

        //mTitle.setText(text);
        mTitle.setTypeface(typefaceBariol);
        return mTitle;
    }

    public SlidingTabs getmMainTab() {

        return mMainTab;
    }

    public static WifiLazooo getApplication(){

        return application;
    }

    public Typeface getTypefaceFontello(){

        return typefaceFontello;
    }

    public Typeface getTypefaceBAriol(){

        return typefaceBariol;
    }

    public Typeface getTypefaceBariolThin(){

        return typefaceBariolThin;
    }

    public List<SlidingTabs.TabItem> getmMainTabs(){
        return mMainTabs;
    }
}


