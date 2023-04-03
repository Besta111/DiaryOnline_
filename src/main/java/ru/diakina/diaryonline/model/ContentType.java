package ru.diakina.diaryonline.model;

public enum ContentType {
    IMAGE(1), MEDIA(2);
    private final int numVal;
    ContentType(int numVal) {
        this.numVal = numVal;
    }
    public int getNumVal() {
        return numVal;
    }
}
