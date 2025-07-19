public class java_inheritance {
    void seed(){
        System.out.println("I the main method ");
    }
    public static void main(String[] args) {
        System.out.println("\n-------------------------------------------\n");
        System.out.println("Simple Inheritance:-");
        Sim_Inheritance_base_class bs= new Sim_Inheritance_base_class();
        System.out.println(bs.fee_structure);
        Sim_Inheritance_derived_class ds=new Sim_Inheritance_derived_class();
        System.out.println(ds.x);
        System.out.println(ds.fee_structure);
        System.out.println("\n-------------------------------------------\n");
        System.out.println("Multiple Inheritance :-");
        multilevel_Inheritance_Puppy p = new multilevel_Inheritance_Puppy();
        p.sound();
        p.bark();
        p.weep();
        p.seed();
        System.out.println("\n============================================\n");
        System.out.println("Non Static Inner class concept");
        OuterClass outer = new OuterClass();
        OuterClass. InnerClass inner = outer.new InnerClass();
        inner.show();
        System.out.println("\n------------------------------------------\n");
        System.out.println("Stactic Inner class concept ");
        OuterClassWithStatic.StaticNestedClass nested = new OuterClassWithStatic.StaticNestedClass();
        nested.show();
        System.out.println("\n============================================\n");
        System.out.println("En:-");


        privateplay pri = new privateplay(10);

        // Accessing public, default, and protected methods
        pri.publicmethod();
        pri.defaultmethod();
        pri.protectedmethod();

        // Accessing private variable via getter/setter
        pri.setPrivitevar(23);
        System.out.println("Private Variable Value: " + pri.getPrivitevar());
    }
}
class Sim_Inheritance_base_class {
     int fee_structure =505000;
}
class Sim_Inheritance_derived_class extends Sim_Inheritance_base_class{
    int x=45000;

}
class multilevel_Inheritance_Animal extends java_inheritance{
    void sound() {
        System.out.println("Animal makes a sound");
    }
}


class multilevel_Inheritance_Dog extends multilevel_Inheritance_Animal{
    void bark() {
        System.out.println("Dog barks");
    }
}

class multilevel_Inheritance_Puppy extends multilevel_Inheritance_Dog {
    void weep() {
        System.out.println("Puppy weeps");
    }
}
class OuterClass {
    int outerVar = 10;

    public class InnerClass {
        void show() {
            System.out.println("Inside Non-static Inner Class");
            System.out.println("outerVar = " + outerVar);
        }
    }
}
class OuterClassWithStatic {

    static  private int staticVar = 20;

    // Static Nested Class
    static class StaticNestedClass {
        void show() {
            System.out.println("Inside Static Nested Class");
            System.out.println("staticVar = " + staticVar);
        }
    }
}
class privateplay{
    private int privitevar;
    public privateplay(int privitevar){this.privitevar=privitevar;    }
    public int getPrivitevar(){return privitevar;}
    public void setPrivitevar(int privitevar){this.privitevar=privitevar;}
    public int publicvar=12;
    protected int protectedvar=78;
    int  defalutvar=34;

    public void publicmethod(){//9837476323 7505405151, 8218482867,7579120622,9105120622,
        System.out.println("Public Method:-");
        System.out.println(publicvar);
    }
    void protectedmethod(){
        System.out.println("Protected Method:-");
        System.out.println(protectedvar);
    }
    void defaultmethod(){
        System.out.println("Default Method: ");
        System.out.println(defalutvar);
    }
}