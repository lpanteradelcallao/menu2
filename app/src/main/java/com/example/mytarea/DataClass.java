package com.example.mytarea;


import android.os.Parcel;
import android.os.Parcelable;

public class DataClass implements Parcelable {
    private int dataImage;
    private String dataTitle;
    private String dataDesc;
    private int dataDetailImage;

    public DataClass(int dataImage, String dataTitle, String dataDesc, int dataDetailImage) {
        this.dataImage = dataImage;
        this.dataTitle = dataTitle;
        this.dataDesc = dataDesc;
        this.dataDetailImage = dataDetailImage;
    }

    protected DataClass(Parcel in) {
        dataImage = in.readInt();
        dataTitle = in.readString();
        dataDesc = in.readString();
        dataDetailImage = in.readInt();
    }

    public static final Creator<DataClass> CREATOR = new Creator<DataClass>() {
        @Override
        public DataClass createFromParcel(Parcel in) {
            return new DataClass(in);
        }

        @Override
        public DataClass[] newArray(int size) {
            return new DataClass[size];
        }
    };

    public int getDataImage() {
        return dataImage;
    }

    public String getDataTitle() {
        return dataTitle;
    }

    public String getDataDesc() {
        return dataDesc;
    }

    public int getDataDetailImage() {
        return dataDetailImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(dataImage);
        dest.writeString(dataTitle);
        dest.writeString(dataDesc);
        dest.writeInt(dataDetailImage);
    }
}
