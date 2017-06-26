package ip;

/**
 * Created by Administrator on 2017/6/26.
 */
public class IPS {
    private int id;
    private String min;
    private String max;
    private  String geo;

    public IPS() {
    }

    public IPS(int id, String min, String max, String geo) {
        this.id = id;
        this.min = min;
        this.max = max;
        this.geo = geo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public int getId() {

        return id;
    }

    public String getMin() {
        return min;
    }

    public String getMax() {
        return max;
    }

    public String getGeo() {
        return geo;
    }
}
