package eji;

import lombok.experimental.Delegate;

class MyClass implements MyInterface {
    @Delegate
    private MyImplementation impl = new MyImplementation();
}
