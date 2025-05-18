import java.util.ArrayList;
import java.util.Scanner;

public class JobKetMonManager {
    //멤버 변수
    Scanner input = new Scanner((System.in));
    String mCurrentUser;
    ArrayList<PMAction> mJobKiMonBox= new ArrayList<>();
    FireField mFire = new FireField();
    ElectricField mElec = new ElectricField();
    // 자료형으로 변수 만들고 뉴는 생성자 함수로 (뉴와, 자료형이름의 생성자 함수와, ())3개가 꼭 필요하다.
    MovingField mMoving = new MovingField();
    //움직임 필드

    //전체 매니저 시작
    JobKetMonManager(){
        mJobKiMonBox.add(new electricMon("잡카츄",200,"쟙카쟙카","전기",20,80,"몸통박치기",10,80));
        mJobKiMonBox.add(new fireMon("파일리",200,"파일파일","불지지기",20,80,"꼬리치기",10,80));
        mJobKiMonBox.add(new fireMon("불브이",200,"불브불브","불날리기",20,80,"불꽃베기",10,80));
    }

    public void run(){
        boolean exitFlag=false;

        System.out.println("플레이어의 이름을 입력");
        String inputName = input.nextLine();
        mCurrentUser=inputName;

        while(true){
            System.out.println("<<잡켓 로그>>");
            System.out.println("1.내 잡켓몬 보기");
            System.out.println("2.잡켓몬 모험하기");
            System.out.println("3.엔딩보기");
            System.out.println("4.종료하기");
            System.out.println("번호 입력");
            int inputNum= input.nextInt();
            input.nextLine();

            switch (inputNum){
                case 1:
                    menuViewMyMon();
                    break;
                case 2:
                    menuAdventure();
                    break;
                case 3:
                    if(mFire.fireList.size()==0 && mElec.elecList.size()==0){
                        mMoving.movingField();
                        exitFlag=true;
                        break;
                    }else{
                        System.out.println("완료하지 못한 지대가 있습니다.");
                    }
                    break;
                case 4:
                    exitFlag=true;
                    break;
            }
            if(exitFlag){
                System.out.println(mCurrentUser+" 코더님 안녕~,"+"you're hot coder!");
                break;
            }
        }
    }// 런 함수 끝

    public void menuViewMyMon(){
        for(PMAction myE:mJobKiMonBox){
            PMAction newMyE=myE;
            if (newMyE instanceof fireMon) {
                newMyE = (fireMon) newMyE;
                System.out.println("이름: "+((fireMon) newMyE).getName());
                System.out.println("기술1: "+((fireMon) newMyE).getS1name());
                System.out.println("기술2: "+((fireMon) newMyE).getS2name());
            } else {
                newMyE = (electricMon) newMyE;
                System.out.println("이름: "+((electricMon) newMyE).getName());
                System.out.println("기술1: "+((electricMon) newMyE).getS1name());
                System.out.println("기술2: "+((electricMon) newMyE).getS2name());
            }
        }

    }//뷰마이몬 끝

    public void menuAdventure(){
        loadAdventure();
    }//어드벤쳐 메뉴 끝

    // 모험 선택 메뉴
    public void loadAdventure(){
            boolean exitFlag2=false;

        while(true){
            System.out.println("어느 곳으로 탐험할까요");
            System.out.println("1. 불지대");
            System.out.println("2. 전기지대");
            System.out.println("3. 메뉴로 돌아가기");
            int inputNum= input.nextInt();
            input.nextLine();

            switch (inputNum){
                case 1:
                    Field fireField= new FireField();
                    fireField.introduce();
                    menuIntoFire();
                    exitFlag2=true;
                    break;

                case 2:
                    Field electricField= new ElectricField();
                    electricField.introduce();
                    menuIntoElec();
                    break;

                case 3:
                    exitFlag2=true;
                    break;

            }//스위치문 끝

            if(exitFlag2){
                break;
            }

        }//트루문 끝
    }// 로드어느벤쳐 메뉴 끝

    // 지역 모드-불
    public void menuIntoFire(){
        mFire.callFireField(mJobKiMonBox);
    }

    // 지역 모드-전기
    public void menuIntoElec(){
        mElec.callElectricField(mJobKiMonBox);
    }

}// 잡켓몬 매니저 클래스 끝




