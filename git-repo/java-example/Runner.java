public class Runner {
    public static void main(String[] args) {
        Engine eA=new EngineA();
        Engine eB=new EngineB();


        Car c1=new Car(eA);
        c1.run(); 
        // 
        // 
        // 
        // 
        // 
        // 
        //  let;s switch to EngineB
        c1=new Car(eB);
        c1.run();
        // Constructor Injection

        
        Car c2=new Car();
        c2.setEngine(eB);
        c2.run();
        // Setter Injection\
        // 
        // 
        // 
        // 
        // 
        // 
        // 
        c2.setEngine(eA);
        c2.run();

        Car c3=new Car();
        c3.e=eA;
        c3.run();
        // Property injection

        // 1. Setter Injection
        // 2. Constructor Injection
        // 3. Property Injection
    }
}
