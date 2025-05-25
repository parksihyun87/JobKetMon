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
        while(true) {
            boolean qtrue= false;
            System.out.println(" 망토를 뒤집어 쓴 수상한 사람이 중얼거리며 나타났다.");
            System.out.println("'과연 끝이란 있는가, 모두 영겁의 되풀이인 것을. 성취란 있는가, 금세 공허해질 것을.");
            System.out.println(" 친밀함 이란 있는가, 눈만 감아도 마음은 천리길 밖인 것을.");
            System.out.println("수상한 남자에게 도전하시겠습니까?(y/n)");
            Scanner input = new Scanner(System.in);
            String confirm = input.nextLine();
            if (confirm.equals("y")) {
                System.out.println("나와 대결하려면 3가지 질문에 대답해야 한다.");
                System.out.println("1. 지금 위치에서 북쪽으로 5km, 동쪽으로 10km, 서쪽으로 5km, 남쪽으로 5km를 이동해도 나는 제자리이다. 나의 원래 위치는 어디인가");
                String answer1 = input.nextLine();
                if("남극".equals(answer1)) {
                    System.out.println("2. A은(는) 남쪽에 있지만 A은(는) 남쪽에 없다. A는 무엇인가(띄어쓰기 입력 필요)");
                    String answer2 = input.nextLine();
                    if("지구의 반".equals(answer2)||"지구의 절반".equals(answer2)||"세계의 반".equals(answer2) ||"세계의 절반".equals(answer2)) {
                        System.out.println("3. 정오에 시에네의 땅에 막대기를 수직으로 세우면 그림자가 없다. 같은 시각 알렉산드리아의 땅에 막대기를 세우면 그림자 끝과 7.2도이다. 그 둘 사이 거리가 5000스타디아일때");
                        System.out.println("지구의 둘레는 몇 스타디아인가?(두 도시의 경도가 같고, 지구가 완전한 구형이라고 가정한다.)");
                        Integer answer3 =0;
                        try {
                            answer3 = input.nextInt();
                            input.nextLine();
                        } catch (Exception e) {
                            System.out.println("숫자를 정확히 입력하세요.");
                            input.nextLine();
                            continue;
                        }
                        if(answer3==250000) {
                            System.out.println("모두 정답이다.");
                            System.out.println("전투가 시작됩니다.");
                            stranger.introduce();
                            stranger.callStrangerField(mJobKiMonBox);
                            break;
                        }
                    }
                }

            }
            System.out.println("답이 틀려 처음으로 돌아갑니다.");
        }
    }//콜 파이어필드 끝
}//파필 클래스 끝
