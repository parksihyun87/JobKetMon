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
        elecList.add(new electricMon("큰부리꽁지",150,"꽁지꽁지","몸통박치기",20,80,"번개멍때리기",0,80));
    }

    public boolean callStrangerField(ArrayList<PMAction> mJobKiMonBox){
        for(PMAction eMon : elecList){
            //for문안에서는 자료형 변수 재선언 안됨.
            electricMon newMon = (electricMon) eMon;
            System.out.println(newMon.getName()+"(이)가 말합니다."+ newMon.getHowling()+" ");
            eMon.taunt();
        }
        System.out.println("전투가 시작됩니다.");

        if(mBattle.fight(elecList,mJobKiMonBox)){
            System.out.println("'주절거림은 주절거림으로,,,그래도 인생에 있어 의미정도는 담아도 되겠지");
//            System.out.println("좋은 승부였다.'");
            System.out.println("낯선 사람이 전기 배지를 주었습니다. 승리");
            return  true;
        } else {
            System.out.println("패배");
            return false;
        }
    }//콜 파이어필드 끝
}//파필 클래스 끝
