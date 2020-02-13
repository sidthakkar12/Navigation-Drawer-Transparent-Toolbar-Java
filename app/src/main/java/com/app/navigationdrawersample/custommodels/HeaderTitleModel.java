package com.app.navigationdrawersample.custommodels;

public class HeaderTitleModel {

    private Boolean showNext = false;
    private Boolean showBack = false;
    private Boolean showShare = false;

    public Boolean getShowShare() {
        return showShare;
    }

    public void setShowShare(Boolean showShare) {
        this.showShare = showShare;
    }

    public Boolean getShowBack() {
        return showBack;
    }

    public void setShowBack(Boolean showBack) {
        this.showBack = showBack;
    }

    public Boolean getShowNext() {
        return showNext;
    }

    public void setShowNext(Boolean showNext) {
        this.showNext = showNext;
    }

    private String headerTitle;

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    private Integer headerTitlePosition;

    public Integer getHeaderTitlePosition() {
        return headerTitlePosition;
    }

    public void setHeaderTitlePosition(Integer headerTitlePosition) {
        this.headerTitlePosition = headerTitlePosition;
    }
}
