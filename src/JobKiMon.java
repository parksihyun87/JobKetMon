public class JobKiMon extends PookiMon {
    String howling;
    String s1name;
    int s1dmg;
    int s1precent;
    String s2name;
    int s2dmg;
    int s2precent;

    public JobKiMon(String name, int hp,String howling, String s1name, int s1dmg, int s1precent, String s2name, int s2dmg, int s2precent) {
        super(name,hp);
        this.howling = howling;
        this.s1name = s1name;
        this.s1dmg = s1dmg;
        this.s1precent = s1precent;
        this.s2name = s2name;
        this.s2dmg = s2dmg;
        this.s2precent = s2precent;
    }

    public String getS1name() {
        return s1name;
    }

    public int getS1dmg() {
        return s1dmg;
    }

    public int getS1precent() {
        return s1precent;
    }

    public String getS2name() {
        return s2name;
    }

    public int getS2dmg() {
        return s2dmg;
    }

    public int getS2precent() {
        return s2precent;
    }

    public String getHowling() {
        return howling;
    }
}
