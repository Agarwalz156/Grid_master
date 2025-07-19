// File: mypackage/mypackage_class.java
package mypackage;

import assignment_package.assigment_14july;

public class mypackage_class {
    public static void main(String[] args) {

        assigment_14july obj = new assigment_14july();

        // ✅ Public method
        obj.showAsciiSum('A', 'B');

        // ❌ Protected method - NOT accessible without subclass
        // obj.fibonacci(5); // ❌ Error

        // ❌ Default method - NOT accessible from different package
        // obj.greet(); // ❌ Error

        // ❌ Private method - NOT accessible directly
        // obj.internalMethod(); // ❌ Error

        // ✅ Public method that internally calls private method
        obj.callPrivateMethod();

        // ✅ Subclass that accesses protected method
        SubClassApp sub = new SubClassApp();
        sub.accessAll();  // Calls public + protected methods
    }
}
