/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * aapt tool from the resource data it found.  It
 * should not be modified by hand.
 */

package com.ricky.materialdesign.recyclerview;

public final class R {
    public static final class attr {
        /**  Class name of the Layout Manager to be used.
        <p/>
        The class must extend android.support.v7.widget.RecyclerView$LayoutManager
        and have either a default constructor or constructor with the signature
        (android.content.Context, android.util.AttributeSet, int, int).
         <p/>
         If the name starts with a '.', application package is prefixed.
         Else, if the name contains a '.', the classname is assumed to be a full class name.
         Else, the recycler view package name (android.support.v7.widget) is prefixed. 
         <p>Must be a string value, using '\\;' to escape characters such as '\\n' or '\\uxxxx' for a unicode character.
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static final int layoutManager=0x7f010000;
        /** <p>Must be a boolean value, either "<code>true</code>" or "<code>false</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static final int reverseLayout=0x7f010002;
        /** <p>Must be an integer value, such as "<code>100</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static final int spanCount=0x7f010001;
        /** <p>Must be a boolean value, either "<code>true</code>" or "<code>false</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static final int stackFromEnd=0x7f010003;
    }
    public static final class dimen {
        /**  Default screen margins, per the Android Design guidelines. 

         Example customization of dimensions originally defined in res/values/dimens.xml
         (such as screen margins) for screens with more than 820dp of available width. This
         would include 7" and 10" devices in landscape (~960dp and ~1280dp respectively).
    
         */
        public static final int activity_horizontal_margin=0x7f040001;
        public static final int activity_vertical_margin=0x7f040002;
        /**  The max amount of scroll ItemTouchHelper will trigger if dragged view is out of
    RecyclerView's bounds.
         */
        public static final int item_touch_helper_max_drag_scroll_per_frame=0x7f040000;
    }
    public static final class drawable {
        public static final int ic_launcher=0x7f020000;
    }
    public static final class id {
        public static final int action_settings=0x7f050004;
        public static final int button1=0x7f050001;
        /**  ItemTouchHelper uses this id to save a View's original elevation. 
         */
        public static final int item_touch_helper_previous_elevation=0x7f050000;
        public static final int recylerview=0x7f050002;
        public static final int tv=0x7f050003;
    }
    public static final class layout {
        public static final int activity_main=0x7f030000;
        public static final int listitem=0x7f030001;
    }
    public static final class menu {
        public static final int main=0x7f080000;
    }
    public static final class string {
        public static final int action_settings=0x7f060002;
        public static final int app_name=0x7f060000;
        public static final int hello_world=0x7f060001;
    }
    public static final class style {
        /** 
        Base application theme, dependent on API level. This theme is replaced
        by AppBaseTheme from res/values-vXX/styles.xml on newer devices.
    

            Theme customizations available in newer API levels can go in
            res/values-vXX/styles.xml, while customizations related to
            backward-compatibility can go here.
        

        Base application theme for API 11+. This theme completely replaces
        AppBaseTheme from res/values/styles.xml on API 11+ devices.
    
 API 11 theme customizations can go here. 

        Base application theme for API 14+. This theme completely replaces
        AppBaseTheme from BOTH res/values/styles.xml and
        res/values-v11/styles.xml on API 14+ devices.
    
 API 14 theme customizations can go here. 
         */
        public static final int AppBaseTheme=0x7f070000;
        /**  Application theme. 
 All customizations that are NOT specific to a particular API-level can go here. 
         */
        public static final int AppTheme=0x7f070001;
    }
    public static final class styleable {
        /** Attributes that can be used with a RecyclerView.
           <p>Includes the following attributes:</p>
           <table>
           <colgroup align="left" />
           <colgroup align="left" />
           <tr><th>Attribute</th><th>Description</th></tr>
           <tr><td><code>{@link #RecyclerView_android_orientation android:orientation}</code></td><td></td></tr>
           <tr><td><code>{@link #RecyclerView_layoutManager com.ricky.materialdesign.recyclerview:layoutManager}</code></td><td> Class name of the Layout Manager to be used.</td></tr>
           <tr><td><code>{@link #RecyclerView_reverseLayout com.ricky.materialdesign.recyclerview:reverseLayout}</code></td><td></td></tr>
           <tr><td><code>{@link #RecyclerView_spanCount com.ricky.materialdesign.recyclerview:spanCount}</code></td><td></td></tr>
           <tr><td><code>{@link #RecyclerView_stackFromEnd com.ricky.materialdesign.recyclerview:stackFromEnd}</code></td><td></td></tr>
           </table>
           @see #RecyclerView_android_orientation
           @see #RecyclerView_layoutManager
           @see #RecyclerView_reverseLayout
           @see #RecyclerView_spanCount
           @see #RecyclerView_stackFromEnd
         */
        public static final int[] RecyclerView = {
            0x010100c4, 0x7f010000, 0x7f010001, 0x7f010002,
            0x7f010003
        };
        /**
          <p>This symbol is the offset where the {@link android.R.attr#orientation}
          attribute's value can be found in the {@link #RecyclerView} array.
          @attr name android:orientation
        */
        public static final int RecyclerView_android_orientation = 0;
        /**
          <p>
          @attr description
           Class name of the Layout Manager to be used.
        <p/>
        The class must extend android.support.v7.widget.RecyclerView$LayoutManager
        and have either a default constructor or constructor with the signature
        (android.content.Context, android.util.AttributeSet, int, int).
         <p/>
         If the name starts with a '.', application package is prefixed.
         Else, if the name contains a '.', the classname is assumed to be a full class name.
         Else, the recycler view package name (android.support.v7.widget) is prefixed. 


          <p>Must be a string value, using '\\;' to escape characters such as '\\n' or '\\uxxxx' for a unicode character.
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          <p>This is a private symbol.
          @attr name com.ricky.materialdesign.recyclerview:layoutManager
        */
        public static final int RecyclerView_layoutManager = 1;
        /**
          <p>This symbol is the offset where the {@link com.ricky.materialdesign.recyclerview.R.attr#reverseLayout}
          attribute's value can be found in the {@link #RecyclerView} array.


          <p>Must be a boolean value, either "<code>true</code>" or "<code>false</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          @attr name com.ricky.materialdesign.recyclerview:reverseLayout
        */
        public static final int RecyclerView_reverseLayout = 3;
        /**
          <p>This symbol is the offset where the {@link com.ricky.materialdesign.recyclerview.R.attr#spanCount}
          attribute's value can be found in the {@link #RecyclerView} array.


          <p>Must be an integer value, such as "<code>100</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          @attr name com.ricky.materialdesign.recyclerview:spanCount
        */
        public static final int RecyclerView_spanCount = 2;
        /**
          <p>This symbol is the offset where the {@link com.ricky.materialdesign.recyclerview.R.attr#stackFromEnd}
          attribute's value can be found in the {@link #RecyclerView} array.


          <p>Must be a boolean value, either "<code>true</code>" or "<code>false</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          @attr name com.ricky.materialdesign.recyclerview:stackFromEnd
        */
        public static final int RecyclerView_stackFromEnd = 4;
    };
}
