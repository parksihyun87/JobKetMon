import java.util.ArrayList;

public class FireField implements Field{

    Battle mBattle= new Battle();
    ArrayList<PMAction> fireList = new ArrayList<>();

    @Override
    public void introduce(){
        System.out.println("불지대에 온것을 환영합니다.");
    }

    public FireField(){
        fireList.add(new fireMon("활활몬",190,"활활활활","불뿜기",15,80,"불멍때리기",0,80));
        fireList.add(new fireMon("화산몬",190,"화산화산","불뿜기",15,80,"불멍때리기",0,80));
    }

    public void callFireField(ArrayList<PMAction> mJobKiMonBox){
        for(PMAction eMon : fireList){
            //for문안에서는 자료형 변수 재선언 안됨.
            fireMon newMon = (fireMon) eMon;
            System.out.println(newMon.getName()+"(이)가 말합니다."+ newMon.getHowling()+" ");
            eMon.taunt();
        }
        System.out.println("전투가 시작됩니다.");

        if(mBattle.fight(fireList,mJobKiMonBox)){
            System.out.println("승리");            
        } else {
            System.out.println("패배");
        }
    }//콜 파이어필드 끝
}//파필 클래스 끝
