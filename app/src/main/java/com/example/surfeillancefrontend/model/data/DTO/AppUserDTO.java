package com.example.surfeillancefrontend.model.data.DTO;


import android.os.Parcel;
import android.os.Parcelable;

public class AppUserDTO implements Parcelable {
    private int id;
    private String userName;
    private String profileText;
    private String location;
    private String skillLevel;
    private String imageUrl;
    private String email;
    private String token;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfileText() {
        return profileText;
    }

    public void setProfileText(String profileText) {
        this.profileText = profileText;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    protected AppUserDTO(Parcel in) {
        id = in.readInt();
        userName = in.readString();
        profileText = in.readString();
        location = in.readString();
        skillLevel = in.readString();
        imageUrl = in.readString();
        email = in.readString();
        token = in.readString();
    }

    public static final Creator<AppUserDTO> CREATOR = new Creator<AppUserDTO>() {
        @Override
        public AppUserDTO createFromParcel(Parcel in) {
            return new AppUserDTO(in);
        }

        @Override
        public AppUserDTO[] newArray(int size) {
            return new AppUserDTO[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(userName);
        dest.writeString(profileText);
        dest.writeString(location);
        dest.writeString(skillLevel);
        dest.writeString(imageUrl);
        dest.writeString(email);
        dest.writeString(token);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}


