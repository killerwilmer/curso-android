package com.killerwilmer.wearableslists;

/**
 * Created by killerwilmer on 21/12/17.
 */

public class ExampleItemModel {

    public String title;
    public int image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public ExampleItemModel(String title, int image) {
        this.title = title;
        this.image = image;
    }
}
