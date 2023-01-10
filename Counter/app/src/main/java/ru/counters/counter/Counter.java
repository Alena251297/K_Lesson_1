package ru.counters.counter;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Counter implements Parcelable {
    private int counter_1 =0;
    private int counter_2 =0;
    private int counter_3 =0;
    private int counter_4 =0;

Counter()
{

}
    public void incCounter1()
    {
        this.counter_1++;
    }
    public void incCounter2()
    {
        this.counter_2++;
    }
    public void incCounter3()
    {
        this.counter_3++;
    }
    public void incCounter4()
    {
        this.counter_4++;
    }



    public void setCounter_1(int counter_1) {
        this.counter_1 = counter_1;
    }

    public void setCounter_2(int counter_2) {
        this.counter_2 = counter_2;
    }

    public void setCounter_3(int counter_3) {
        this.counter_3 = counter_3;
    }

    public void setCounter_4(int counter_4) {
        this.counter_4 = counter_4;
    }

    public int getCounter_1() {
        return counter_1;
    }

    public int getCounter_2() {
        return counter_2;
    }

    public int getCounter_3() {
        return counter_3;
    }

    public int getCounter_4() {
        return counter_4;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(counter_1);
        dest.writeInt(counter_2);
        dest.writeInt(counter_3);
        dest.writeInt(counter_4);
    }
    protected Counter(Parcel in) {
        counter_1 = in.readInt();
        counter_2 = in.readInt();
        counter_3 = in.readInt();
        counter_4 = in.readInt();
    }
    public static final Creator<Counter> CREATOR = new Creator<Counter>() {
        @Override
        public Counter createFromParcel(Parcel in) {
            return new Counter(in);
        }

        @Override
        public Counter[] newArray(int size) {
            return new Counter[size];
        }
    };
}
