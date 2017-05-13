# FlatDialer
An Android Dialer used for android fundamentals  on Google Developer Groups PR  
![Dialer](https://github.com/jrsosa/FlatDialer/blob/master/screenshots/screen_wide_1.jpg)  

What students/professionals learn with this simple yet beautiful app? 

* Android lifecycle
* Intents
* Image resources in Android Studio
* Resource reusability
* View reusability
* App store publishing
* And more!

An example of a separate view to prevent deep nested xml layout files  
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="80dp"
    android:layout_margin="@dimen/numbers_margin"
    android:gravity="center"
    android:orientation="horizontal"
    android:weightSum="3">

    <android.support.design.widget.FloatingActionButton
        android:id="@+id/number_one_button"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginEnd="16dp"
        android:layout_marginStart="16dp"
        android:layout_weight="1"
        android:src="@drawable/number_1"
        app:fabSize="normal"
        app:rippleColor="@android:color/white" />

    <android.support.design.widget.FloatingActionButton
        android:id="@+id/number_two_button"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginEnd="16dp"
        android:layout_marginStart="16dp"
        android:layout_weight="1"
        android:src="@drawable/number_2"
        app:fabSize="normal"
        app:rippleColor="@android:color/white" />

    <android.support.design.widget.FloatingActionButton
        android:id="@+id/number_three_button"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginEnd="16dp"
        android:layout_marginStart="16dp"
        android:layout_weight="1"
        android:src="@drawable/number_3"
        app:fabSize="normal"
        app:rippleColor="@android:color/white" />


</LinearLayout>
```  
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"

    android:layout_height="match_parent"
    tools:context="com.jrsosa.flatdialer.DialerActivity">


    <include
        android:id="@+id/input_view"
        layout="@layout/phone_action_view" />

    <include
        android:id="@+id/number_set_one"
        layout="@layout/number_set_1"
        android:layout_width="match_parent"
        android:layout_height="80dp"
        android:layout_below="@+id/input_view" />

    <include
        android:id="@+id/number_set_two"
        layout="@layout/number_set_2"
        android:layout_width="match_parent"
        android:layout_height="80dp"
        android:layout_below="@+id/number_set_one" />

    <include
        android:id="@+id/number_set_three"
        layout="@layout/number_set_3"
        android:layout_width="match_parent"
        android:layout_height="80dp"
        android:layout_below="@+id/number_set_two" />


    <android.support.design.widget.FloatingActionButton
        android:id="@+id/make_call_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:layout_margin="@dimen/fab_margin"
        app:fabSize="normal"
        app:srcCompat="@android:drawable/stat_sys_phone_call" />

    <android.support.design.widget.FloatingActionButton
        android:id="@+id/number_zero_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
       android:layout_above="@id/make_call_button"
        android:layout_centerHorizontal="true"
        android:layout_margin="@dimen/fab_margin"
        app:fabSize="normal"
        app:srcCompat="@drawable/ic_number_zero" />


</RelativeLayout>
```  



