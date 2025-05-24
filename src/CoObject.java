public class CoObject {
    public MObject mObject;
    private int fieldWidth;
    private int y=0;
    String cString;

    public CoObject() {
    }

    public CoObject(int y) {
        this.y = y;
    }

    public CoObject(int y, int fieldWidth,String cString) {
        this.y = y;
        this.fieldWidth = fieldWidth;
        this.cString = cString;
    }

    public MObject getmObject() {
        return mObject;
    }

    public void setmObject(MObject mObject) {
        this.mObject = mObject;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getFieldWidth() {
        return fieldWidth;
    }

    public void setFieldWidth(int fieldWidth) {
        this.fieldWidth = fieldWidth;
    }

    public String getcString() {
        return cString;
    }

    public void setcString(String cString) {
        this.cString = cString;
    }
}

