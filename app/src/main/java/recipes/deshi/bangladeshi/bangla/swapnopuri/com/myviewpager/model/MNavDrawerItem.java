package recipes.deshi.bangladeshi.bangla.swapnopuri.com.myviewpager.model;

/**
 * Created by NAYAN on 5/9/2017.
 */
public class MNavDrawerItem {
    private boolean showNotify;
    private String title;
    private int imgRes;

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public MNavDrawerItem() {

    }

    public MNavDrawerItem(boolean showNotify, String title) {
        this.showNotify = showNotify;
        this.title = title;
    }

    public boolean isShowNotify() {
        return showNotify;
    }

    public void setShowNotify(boolean showNotify) {
        this.showNotify = showNotify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
