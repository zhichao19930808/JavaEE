package util;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Administrator on 2017/6/26.
 */
@WebListener
public class SessionListenerTest implements HttpSessionListener,HttpSessionAttributeListener{
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //sessionCreated 创建会话
        System.out.println("sessionCreated 创建会话:"+se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //sessionDestroyed 破坏会话
        System.out.println("sessionDestroyed 破坏会话:"+se.getSession().getId());
        System.out.println("------------------------------------------------------------------------------------------");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        //attributeAdded 附加属性
        System.out.println("attributeAdded 附加属性se:"+event.getName()+","+event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        //attributeRemoved 删除属性
        System.out.println("attributeRemoved 删除属性se:"+event.getName()+","+event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        //attributeReplaced 代替属性
        System.out.println("attributeReplaced 代替属性se:"+event.getName()+","+event.getValue());
    }
}
