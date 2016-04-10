package linzhenhuan.jrrc_android_new.linzhenhuan.jrrc.dao;

/**
 * Created by linzhenhuan on 16/4/9.
 */
public class functionCell {


    private String name;
    private String descrition;
    private int imageId;


    public functionCell(String descrition, int imageId, String name) {
        this.descrition = descrition;
        this.imageId = imageId;
        this.name = name;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
