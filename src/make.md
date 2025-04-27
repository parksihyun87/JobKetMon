* 작성 키워드
1. 진행 메뉴(이동 있음) 생성
2. 지역 모드 메뉴 생성(진행 있음)
3. 지역 이동시 적대 잡키먼 옵저빙으로 메시지 발동하고 적 배열에 추가 한후 꺼내와 
파이트 함수에 등록 및 서로의 set에 영향주는 구문 시작  
4.자료부 정리
4-1. 푸키먼 부모로부터 잡키먼들 클래스 상속. 잡키먼들은 체력, 기술을 가지고 있으며, 기술은 랜덤 발동하는데
기술 발동시 랜덤 숫자로 영향을 받아 확률로 상대의 체력을 일정 인트씩 깎음.
4-2. 주인공 스타트 객체 3개 고정하고 배열에 있음
5. 의존성 주입으로 다음지역 잡키몬 및 보스 생성. 


* 실현 목표 키워드: 
1. 옵저빙 개체를 이용한 sout 반응// 옵저빙에서 interface로 각 객체의 오버라이딩을 한 후 sout문 호출은 어레이리스트에 다 넣은 후 공통적으로 해당 대사를 하게 하면 된다. 
2. 상속받은 객체들 서로 영향 미치는 상태에 돌입시키기
3. 상속받은 객체들 이용 서로에게 영향 미치는 hp관련 set 발동
4. 적 상대자 배열 이용한 연속 참전
5. 적 상대자는 의존성 주입을 통해 두개의 지역형 잡키먼 형태로 변형(하는것은 이해까지만)


interface Observer {
void update(String message);
}

class ConcreteObserver implements Observer {
private String name;

    ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}

class Subject {
private List<Observer> observers = new ArrayList<>();

    void addObserver(Observer observer) {
        observers.add(observer);
    }

    void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
