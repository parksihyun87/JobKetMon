import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Battle {

    public boolean fight(ArrayList<PMAction> landList, ArrayList<PMAction> mJobKiMonBox){
        PMAction oppenent=null;
        PMAction myJobKiMon=null;
        Boolean result=false;

        while(true){
            if(landList.size()==0){
                System.out.println("모두 물리쳤다.");
                for(PMAction myE: mJobKiMonBox){
                    myJobKiMon= myE;
                    if (myJobKiMon instanceof fireMon) {
                        myJobKiMon = (fireMon) myJobKiMon;
                        System.out.print(((fireMon) myJobKiMon).getName()+"(이)가 ");
                        myJobKiMon.victory();
                    } else {
                        myJobKiMon = (electricMon) myJobKiMon;
                        System.out.print(((electricMon) myJobKiMon).getName()+"(이)가 ");
                        myJobKiMon.victory();
                    }
                }
                result=true;
                break;
            }

            if(mJobKiMonBox.size()==0){
                System.out.println("패배하였다.");
                result=false;
                break;
            }


            //상대
            for(PMAction e: landList){
                oppenent=e;
                if (oppenent instanceof fireMon) {
                    oppenent=(fireMon)oppenent;
                } else {
                    oppenent = (electricMon) oppenent;
                }
                break;
            }
            //나
            for(PMAction myE: mJobKiMonBox){
                myJobKiMon= myE;
                if (myJobKiMon instanceof fireMon) {
                    myJobKiMon = (fireMon) myJobKiMon;
                } else {
                    myJobKiMon = (electricMon) myJobKiMon;
                }
                break;
            }
            System.out.println("내 잡키먼:"+((JobKiMon) myJobKiMon).getName()+"이다.");
            System.out.println("상대 잡키먼:"+((JobKiMon) oppenent).getName()+"이다.");

            while(true){
                Scanner input= new Scanner(System.in);
                PMAction looser=null;
                System.out.println("내 잡키먼 행동 입력");
                System.out.println("1"+((JobKiMon) myJobKiMon).s1name+"사용");
                System.out.println("2"+((JobKiMon) myJobKiMon).s2name+"사용");
                int inputNumber=input.nextInt();
                input.nextLine();

                switch (inputNumber){
                    case 1:
                        if(Math.random()*100+1> (100-((JobKiMon) myJobKiMon).getS1precent())){
                            ((JobKiMon) oppenent).setHp(((JobKiMon) oppenent).getHp()-((JobKiMon) myJobKiMon).getS1dmg());
                            System.out.println("dmg"+((JobKiMon) myJobKiMon).getS1dmg());
                            System.out.println("현재 적 hp:"+((JobKiMon) oppenent).getHp());
                        } else {
                            System.out.println("기술 실패");
                        }
                        break;
                    case 2:
                        if(Math.random()*100+1> (100-((JobKiMon) myJobKiMon).getS2precent())){
                            ((JobKiMon) oppenent).setHp(((JobKiMon) oppenent).getHp()-((JobKiMon) myJobKiMon).getS2dmg());
                            System.out.println("dmg"+((JobKiMon) myJobKiMon).getS2dmg());
                            System.out.println("현재 적 hp:"+((JobKiMon) oppenent).getHp());
                        } else {
                            System.out.println("기술 실패");
                        }
                        break;
                    default:
                        System.out.println("잘못된 입력");
                        continue;
                }
                if(((JobKiMon) oppenent).getHp()<=0){
                    looser=oppenent;
                    String name= ((JobKiMon) oppenent).name;
                    System.out.println(name+"는(은) 패배하였다.");
                    for(PMAction myE: landList){
                        if (oppenent instanceof fireMon) {
                            fireMon newMyFireMon = (fireMon) myE;
                            if(newMyFireMon.getName().equals(((fireMon) oppenent).getName())){
                                landList.remove(myE);
                                break;
                            }
                        } else {
                            electricMon newMyElecMon = (electricMon) myE;
                            if(newMyElecMon.getName().equals(((electricMon) oppenent).getName())){
                                landList.remove(myE);
                                break;
                            }
                        }
                    }

//                    // Iterator로 안전하게 제거
//                    Iterator<PMAction> iterator = landList.iterator();
//                    // 이리테이터 문
//                    while (iterator.hasNext()) {
//                        PMAction myE = iterator.next();
//                        if (oppenent instanceof fireMon) {
//                            fireMon newMyFireMon = (fireMon) myE;
//                            if (newMyFireMon.getName().equals(((fireMon) oppenent).getName())) {
//                                iterator.remove();
//                            }
//                        } else {
//                            electricMon newMyElecMon = (electricMon) myE;
//                            if (newMyElecMon.getName().equals(((electricMon) oppenent).getName())) {
//                                iterator.remove();
//                            }
//                        }
//                    }//이리테이터 끝.

                    break;
                }

                System.out.println("상대턴");
                if(Math.random()*100+1 > (100-((JobKiMon) oppenent).getS1precent())){
                    ((JobKiMon) myJobKiMon).setHp(((JobKiMon) myJobKiMon).getHp()-((JobKiMon) oppenent).getS1dmg());
                    System.out.println("dmg"+((JobKiMon) oppenent).getS1dmg());
                    System.out.println("내 hp "+((JobKiMon) myJobKiMon).getHp());
                } else {
                    System.out.println("기술 실패");
                }

                if(((JobKiMon) myJobKiMon).getHp()<=0){
                    looser=myJobKiMon;
                    String name= ((JobKiMon) myJobKiMon).name;
                    System.out.println(name+"는(은) 패배하였다.");

                    for(PMAction myE: mJobKiMonBox){
                        if (myJobKiMon instanceof fireMon) {
                            fireMon newMyFireMon = (fireMon) myE;
                            if(newMyFireMon.getName().equals(((fireMon) myJobKiMon).getName())){
                                mJobKiMonBox.remove(myE);
                                break;
                            }
                        } else {
                            electricMon newMyElecMon = (electricMon) myE;
                            if(newMyElecMon.getName().equals(((electricMon) myJobKiMon).getName())){
                                mJobKiMonBox.remove(myE);
                                break;
                            }
                        }
                    }

                    // Iterator로 안전하게 제거
//                    Iterator<PMAction> iterator = mJobKiMonBox.iterator();
//                    while (iterator.hasNext()) {
//                        PMAction myE = iterator.next();
//                        if (myJobKiMon instanceof fireMon) {
//                            fireMon newMyFireMon = (fireMon) myE;
//                            if (newMyFireMon.getName().equals(((fireMon) myJobKiMon).getName())) {
//                                iterator.remove();
//                            }
//                        } else {
//                            electricMon newMyElecMon = (electricMon) myE;
//                            if (newMyElecMon.getName().equals(((electricMon) myJobKiMon).getName())) {
//                                iterator.remove();
//                            }
//                        }
//                    }

                    break;
                }
            }//2차 와일문 끝
        }//와일문 끝
        return result;
    }//파이트 끝
}
