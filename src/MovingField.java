import java.util.ArrayList;
import java.util.Scanner;

public class MovingField {
    public void movingField(){
        int fieldWidth=10;
        int fieldHeight=5;
        MObject mObject = new MObject(1,1);
        ArrayList<CoObject> coObjects = new ArrayList<>();
        for(int i=1;i<=fieldHeight; i++){
            coObjects.add(new CoObject(i,fieldWidth,"*".repeat(fieldWidth)));
        }
        System.out.println("엔딩을 위해 끝 표시까지 움직여주세요.");
        movement(mObject, coObjects);

        while(true){
            Scanner input = new Scanner(System.in);
            System.out.println("움직임 입력 좌우(a/d),상하(w/s)");
            String inputPosition = input.nextLine();
            if(inputPosition.toUpperCase().equals("D")){
                if(mObject.getX()==10){
                    break;
                }
                mObject.setX(mObject.getX()+1);
                movement(mObject, coObjects);
            }
            if(inputPosition.toUpperCase().equals("A")){
                mObject.setX(mObject.getX()-1);
                movement(mObject, coObjects);
            }

            if(inputPosition.toUpperCase().equals("S")){
                mObject.setY(mObject.getY()+1);
                movement(mObject, coObjects);
            }

            if(inputPosition.toUpperCase().equals("W")){
                mObject.setY(mObject.getY()-1);
                movement(mObject, coObjects);
            }
        }
        System.out.println("엔딩까지 플레이해주셔서 감사합니다.");
    }

    public void movement(MObject mObject, ArrayList<CoObject> coObjects) {
        String remove="*".repeat(10);
        int x2 = coObjects.get(0).getFieldWidth() - mObject.getX();
        int x1 = coObjects.get(0).getFieldWidth() - 1 - x2;
        String location = "*".repeat(x1) + "o" + "*".repeat(x2);
        for (CoObject m : coObjects) {
            m.setcString(remove);
            if (m.getY() == mObject.getY()) {
                m.setcString(location);
            }
            System.out.print(m.getcString());
            System.out.print("끝");
            System.out.println("");
        }
    }
}