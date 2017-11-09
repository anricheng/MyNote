package aspect.chou.aric.com.myapplication;

import android.os.Parcel;
import android.os.Parcelable;
import android.webkit.JavascriptInterface;

/**
 * aspect.chou.aric.com.myapplication
 * Created by Aric on 下午11:43.
 */

public class Student implements Parcelable {

    public String name;

    public String age;

    @JavascriptInterface
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @JavascriptInterface
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.age);
    }

    protected Student(Parcel in) {
        this.name = in.readString();
        this.age = in.readString();
    }

    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
