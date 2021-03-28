package mysite.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    //생성자를 private으로 선언하여 외부에서 new로 생성못하게
    private SingletonService(){}
    
    public void logic(){
        System.out.println("싱글톤 객체  로직 호출");
    }
}
