package util;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/6/26.
 */
@WebListener
public class RequestListenerTest implements ServletRequestListener ,ServletRequestAttributeListener{
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        //requestInitialized 请求初始化
        HttpServletRequest request= (HttpServletRequest) sre.getServletRequest();
        System.out.println("requestInitialized 请求初始化:"+request.getRequestURI());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {//Event 事件
        //requestDestroyed 请求破坏
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        System.out.println("requestDestroyed 请求破坏："+request.getRequestURI());
        System.out.println("************************************************************************************");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        //attributeAdded 附加属性
        System.out.println("attributeAdded 附加属性:"+srae.getName()+","+srae.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        //attributeRemoved 删除属性
        System.out.println("attributeRemoved 删除属性:"+srae.getName()+","+srae.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        //attributeReplaced 代替属性
        System.out.println("attributeReplaced 代替属性:"+srae.getName()+","+srae.getValue());
    }
}
