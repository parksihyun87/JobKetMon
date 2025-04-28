import java.util.ArrayList;

public class ElectricField implements Field{

    Battle mBattle= new Battle();
    ArrayList<PMAction> elecList = new ArrayList<>();

    @Override
    public void introduce(){
        System.out.println("전기지대에 온것을 환영합니다.");
    }

    public ElectricField(){
        elecList.add(new electricMon("치지직볼",190,"치지직","정전기",15,80,"번개멍때리기",0,80));
        elecList.add(new electricMon("나이추",190,"나이나이","99만볼트",15,80,"번개멍때리기",0,80));
    }

    public void callElectricField(ArrayList<PMAction> mJobKiMonBox){
        for(PMAction eMon : elecList){
            //for문안에서는 자료형 변수 재선언 안됨.
            electricMon newMon = (electricMon) eMon;
            System.out.println(newMon.getName()+"(이)가 말합니다."+ newMon.getHowling()+" ");
            eMon.taunt();
        }
        System.out.println("전투가 시작됩니다.");

        if(mBattle.fight(elecList,mJobKiMonBox)){
            System.out.println("승리");            
        } else {
            System.out.println("패배");
        }
    }//콜 파이어필드 끝
}//파필 클래스 끝
