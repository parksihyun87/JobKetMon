import java.util.ArrayList;
import java.util.Scanner;

public class MovingField {
    public void movingField(){
        String remove="*".repeat(10);
        MObject mObject = new MObject(1,1);
        ArrayList<CoObject> coObjects = new ArrayList<>();
        for(int i=1;i<=5; i++){
            coObjects.add(new CoObject(i,"*".repeat(10)));
        }
        int xMObject= mObject.getX();

        int x2_1=10-xMObject;
        int x1_1=9-x2_1;
        String y1="*".repeat(x1_1);
        String mObj="o";
        String y2="*".repeat(x2_1);
        String location1=y1+mObj+y2;
        System.out.println("엔딩을 위해 끝 표시까지 움직여주세요.");
        for(CoObject m: coObjects){
            m.setcString(remove);
            if(m.getY()==mObject.getY()){
                m.setcString(location1);
            }
            System.out.print(m.getcString());
            System.out.print("끝");
            System.out.println("");
        }
        while(true){
            Scanner input = new Scanner(System.in);
            System.out.println("움직임 입력 좌우(d/a),상하(w/s)");
            String inputPosition = input.nextLine();
            if(inputPosition.toUpperCase().equals("D")){
                if(xMObject==10){
                    break;
                }
                xMObject=xMObject+1;
                x2_1=10-xMObject;
                x1_1=9-x2_1;
                y1="*".repeat(x1_1);
                mObj="o";
                y2="*".repeat(x2_1);
                location1=y1+mObj+y2;
                for(CoObject m: coObjects){
                    m.setcString(remove);
                    if(m.getY()==mObject.getY()){
                        m.setcString(location1);
                    }
                    System.out.print(m.getcString());
                    System.out.print("끝");
                    System.out.println("");
                }
            }
            if(inputPosition.toUpperCase().equals("A")){
                xMObject=xMObject-1;
                x2_1=10-xMObject;
                x1_1=9-x2_1;
                y1="*".repeat(x1_1);
                mObj="o";
                y2="*".repeat(x2_1);
                location1=y1+mObj+y2;
                for(CoObject m: coObjects){
                    m.setcString(remove);
                    if(m.getY()==mObject.getY()){
                        m.setcString(location1);
                    }
                    System.out.print(m.getcString());
                    System.out.print("끝");
                    System.out.println("");
                }
            }

            if(inputPosition.toUpperCase().equals("S")){
                mObject.setY(mObject.getY()+1);
                x2_1=10-xMObject;
                x1_1=9-x2_1;
                y1="*".repeat(x1_1);
                mObj="o";
                y2="*".repeat(x2_1);
                location1=y1+mObj+y2;
                for(CoObject m: coObjects){
                    m.setcString(remove);
                    if(m.getY()==mObject.getY()){
                        m.setcString(location1);
                    }
                    System.out.print(m.getcString());
                    System.out.print("끝");
                    System.out.println("");
                }
            }

            if(inputPosition.toUpperCase().equals("W")){
                mObject.setY(mObject.getY()-1);
                x2_1=10-xMObject;
                x1_1=9-x2_1;
                y1="*".repeat(x1_1);
                mObj="o";
                y2="*".repeat(x2_1);
                location1=y1+mObj+y2;
                for(CoObject m: coObjects){
                    m.setcString(remove);
                    if(m.getY()==mObject.getY()){
                        m.setcString(location1);
                    }
                    System.out.print(m.getcString());
                    System.out.print("끝");
                    System.out.println("");
                }
            }
        }
        System.out.println("엔딩까지 플레이해주셔서 감사합니다.");
    }
}

