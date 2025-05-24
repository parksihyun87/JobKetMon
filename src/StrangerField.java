import java.util.ArrayList;
import java.util.Scanner;

public class StrangerField implements Field{

    Battle mBattle= new Battle();
    ArrayList<PMAction> elecList = new ArrayList<>();

    @Override
    public void introduce(){
        System.out.println("수상한 사람의 알 수 없는 공간이다.");
    }

    public StrangerField(){
        elecList.add(new electricMon("큰부리꽁지",200,"꽁지꽁지","몸통박치기",20,80,"번개멍때리기",0,80));
    }

    public void callStrangerField(ArrayList<PMAction> mJobKiMonBox){
        for(PMAction eMon : elecList){
            //for문안에서는 자료형 변수 재선언 안됨.
            electricMon newMon = (electricMon) eMon;
            System.out.println(newMon.getName()+"(이)가 말합니다."+ newMon.getHowling()+" ");
            eMon.taunt();
        }
        System.out.println("전투가 시작됩니다.");

        if(mBattle.fight(elecList,mJobKiMonBox)){
            System.out.println("'잘 도전하였다. 나는 인생들의 원류 그 자체이다. 인생은 계속 생겨나고, 그안의 생동성들은 도전하도록 만들겠지.");
            System.out.println("태어날때부터 고정된 길은 없으나, 발걸음이 헤이하면 의미없는 모래로 풀어져 돌아가게 된다.");
            System.out.println("길을 만드려고 심장을 듣는 자의 종국에 닥칠일도 일반이나, 최후에 누여질 장소의 의미가 다르리라.");
            System.out.println("비록 시간속에서 많은 것들이 퇴색하겠으나 사람들안에서 전해지는 '의미'라는 것들은 인생의 바다안에 영원히 존재할 것이다.'");
            System.out.println("낯선 사람이 가벼운 발걸음으로 떠났습니다. 승리");
        } else {
            System.out.println("패배");
        }
    }//콜 파이어필드 끝
}//파필 클래스 끝
