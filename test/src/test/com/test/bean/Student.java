package test.com.test.bean;

import test.com.Event;
import test.com.test.interfacet.Listener;

public class Student {

    // read方法事件监听器引用
    private Listener listener;

    /**
     * @description: 注册read方法的事件监听器
     * @param listener 事件监听器引用
     * @return void
     * @throws
     */
    public void setReadListener(Listener listener) {
        this.listener = listener;
    }

    /**
     * @description: 学生的read方法
     * @return void
     * @throws
     */
    public void read() {
        if (listener != null) {
            Event event = new Event();
            event.setStudent(this);
            // 学生正在读书...
            listener.isReading(event);
        }
    }
}