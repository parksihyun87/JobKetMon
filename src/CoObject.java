public class CoObject {
    public MObject mObject;
    private int x=0;
    private int y=0;
    String cString;

    public CoObject() {
    }

    public CoObject(int y) {
        this.y = y;
    }

    public CoObject(int y, String cString) {
        this.y = y;
        this.cString = cString;
    }

    public MObject getmObject() {
        return mObject;
    }

    public void setmObject(MObject mObject) {
        this.mObject = mObject;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getcString() {
        return cString;
    }

    public void setcString(String cString) {
        this.cString = cString;
    }
}

