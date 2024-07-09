package com.example.surfeillancefrontend.model.data.dto;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class AppUser extends BaseObservable implements Parcelable  {
        private long id;
        private String userName;
        private String profileText;
        private String location;
        private String skillLevel;
        private String imageUrl;
        private String email;
        private String token;

    public AppUser(long id) {
        this.id = id;
    }

    public AppUser() {

    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
                notifyPropertyChanged(BR.userName);
    }

    public AppUser(Parcel in) {
        id = in.readLong();
        userName = in.readString();
        profileText = in.readString();
        location = in.readString();
        skillLevel = in.readString();
        imageUrl = in.readString();
        email = in.readString();
        token = in.readString();
    }

    public static final Creator<AppUser> CREATOR = new Creator<AppUser>() {
        @Override
        public AppUser createFromParcel(Parcel in) {
            return new AppUser(in);
        }

        @Override
        public AppUser[] newArray(int size) {
            return new AppUser[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(userName);
        dest.writeString(profileText);
        dest.writeString(location);
        dest.writeString(skillLevel);
        dest.writeString(imageUrl);
        dest.writeString(email);
        dest.writeString(token);
    }
}
