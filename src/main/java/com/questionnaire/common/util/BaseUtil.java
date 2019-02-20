package com.questionnaire.common.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.TreeMap;

/**
 * Created by ihaojing on 2017/7/18.
 */
public class BaseUtil {


    /***
     * 获取客户端IP
     *
     * @param request
     * @return
     */
    public static String getIp(HttpServletRequest request) {
        //http://api.map.baidu.com/location/ip?ak=F454f8a5efe5e577997931cc01de3974&ip=202.198.16.3 百度IP接口
        String ip = request.getHeader("X-Forwarded-For");
        if (null!=ip && !"unKnown".equalsIgnoreCase(ip)) {
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (null!=ip && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }




    /***
     * 获取所有的参数
     * @param req
     * @return
     */
    public static TreeMap<String, String> getAllRequestParam(final HttpServletRequest req) {
        TreeMap<String, String> res = new TreeMap<>();
        res.put("ip", getIp(req));
        Enumeration<?> temp = req.getParameterNames();
        if (null != temp) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = req.getParameter(en);
                res.put(en, value);
                if (null == res.get(en) || "".equals(res.get(en))) {
                    res.remove(en);
                }
            }
        }
        return res;
    }

}
