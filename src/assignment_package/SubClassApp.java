package mypackage;

import assignment_package.assigment_14july;

public class SubClassApp extends assigment_14july {
    public void accessAll() {
        showAsciiSum('C', 'D');      // ✅ public
        fibonacci(6);                // ✅ protected via subclass
        callPrivateMethod();         // ✅ public method calls private internally
    }
}
