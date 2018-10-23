package test.com.test.interfacet;

import test.com.Event;

public interface Listener {
    /**
     * @description: 学生读书触发的事件
     * @param event 事件对象引用，通过这个引用，获取事件源的引用，然后就可以对事件源进行操作
     * @return void
     * @throws
     */
    public void isReading(Event event);
}