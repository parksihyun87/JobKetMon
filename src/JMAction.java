
class fireMon extends JobKiMon implements PMAction {
    public fireMon(String name, int hp,String howling, String s1name, int s1dmg, int s1precent, String s2name, int s2dmg, int s2precent) {
        super(name,hp,howling,s1name,s1dmg,s1precent,s2name,s2dmg,s2precent);
    }
    @Override
    public void howling(){
        System.out.println();
    }

    @Override
    public void attack1(){

    }

    @Override
    public void attack2(){

    }

    @Override
    public void taunt(){
        System.out.println("너희들은 지나갈 수 없다.");
    }

    @Override
    public void victory() {
        System.out.println("방방 뛴다.");
    }
}

class electricMon extends JobKiMon implements PMAction {
    public electricMon(String name, int hp,String howling, String s1name, int s1dmg, int s1precent, String s2name, int s2dmg, int s2precent) {
        super(name,hp,howling,s1name,s1dmg,s1precent,s2name,s2dmg,s2precent);
    }
    @Override
    public void howling(){
        System.out.println();
    }

    @Override
    public void attack1(){

    }

    @Override
    public void attack2(){

    }

    @Override
    public void taunt(){

    }

    public void victory() {
        System.out.println("방방 뛴다.");
    }

}

