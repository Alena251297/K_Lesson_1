package ru.lesson.socialnetwork_lesson8;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

public class CardDate implements Parcelable {
    private String title;
    private String description;
    private int picture;
    private  boolean like;

    protected CardDate(Parcel in) {
        title = in.readString();
        description = in.readString();
        picture = in.readInt();
        like = in.readByte() != 0;
    }

    public static final Creator<CardDate> CREATOR = new Creator<CardDate>() {
        @Override
        public CardDate createFromParcel(Parcel in) {
            return new CardDate(in);
        }

        @Override
        public CardDate[] newArray(int size) {
            return new CardDate[size];
        }
    };

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;

    public void setTitle(String title) {
        this.title = title;
    }

    public CardDate(String title, String description, int picture, boolean like, Date date) {
        this.title = title;
        this.description = description;
        this.picture = picture;
        this.like = like;
        this.date = date;
    }



    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPicture() {
        return picture;
    }

    public boolean isLike() {
        return like;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeInt(picture);
        dest.writeByte((byte) (like ? 1 : 0));
    }
}
