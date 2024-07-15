class Car{

    
    Engine e;

    Car(){

    }
 
    Car(Engine e){
        this.e=e;
    }

 
    public void setEngine(Engine e){
        this.e=e;
    }
    public Engine getEngine(){
        return this.e;
    }



    public void run(){
        e.providePower();
        System.out.println("Car is running now");
    }
}

// Car is dependent on Engine 

// 1. Hard Coded-- Tight Coupling