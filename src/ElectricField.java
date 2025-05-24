import java.util.ArrayList;
import java.util.Scanner;

public class ElectricField implements Field{
    StrangerField stranger = new StrangerField();

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
        System.out.println("망토를 뒤집어 쓴 수상한 사람이 나타났다.");
        System.out.println("'과연 끝이란 있는가, 모두 영겁의 되풀이인 것을. 성취란 있는가, 금세 공허해질 것을.");
        System.out.println(" 친밀함 이란 있는가, 눈만 감아도 마음은 천리길 밖인 것을. 그대, 없어질 무엇을 이룩키 위하여 끝없이 쌓아올리려 하는가.");
        System.out.println("너의 존재는 우주 가운데 한 낱 모래알, 까마득히 많은 새떼 무리의 일개 구성원일뿐이지만, 이곳에 너의 심장이 뛰고 있음을 증명하여 보여라.'");
        System.out.println("수상한 남자에게 도전하시겠습니까?(y/n)");
        Scanner input = new Scanner(System.in);
        String confirm = input.nextLine();
        if(confirm.equals("y")){
            System.out.println("전투가 시작됩니다.");
            stranger.introduce();
            stranger.callStrangerField(mJobKiMonBox);
        }
    }//콜 파이어필드 끝
}//파필 클래스 끝
