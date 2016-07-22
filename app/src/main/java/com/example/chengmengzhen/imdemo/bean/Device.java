package com.example.chengmengzhen.imdemo.bean;

import java.util.List;

/**
 * Created by APLEX on 2016/7/21.
 */
public class Device {

    /**
     * action : get
     * path : /users
     * uri : http://a1.easemob.com/chengmengzhen/imdemo/users/
     * entities : [{"uuid":"68ac3500-4754-11e6-9fee-81f57002acde","type":"user","created":1468233854032,"modified":1468300792791,"username":"11111","activated":true},{"uuid":"2e160650-47ef-11e6-962d-997a24a81237","type":"user","created":1468300327733,"modified":1468301175307,"username":"cmz8888","activated":true},{"uuid":"3a8cca40-47ef-11e6-81b4-a9b9975b89cf","type":"user","created":1468300348644,"modified":1468300348644,"username":"cmz1111","activated":true}]
     * timestamp : 1469157020976
     * duration : 10
     * count : 3
     * statusCode : 200
     */

    public String action;
    public String path;
    public String uri;
    public long timestamp;
    public int duration;
    public int count;
    public int statusCode;
    /**
     * uuid : 68ac3500-4754-11e6-9fee-81f57002acde
     * type : user
     * created : 1468233854032
     * modified : 1468300792791
     * username : 11111
     * activated : true
     */

    public List<EntitiesBean> entities;

    public static class EntitiesBean {
        public String uuid;
        public String type;
        public long created;
        public long modified;
        public String username;
        public boolean activated;
    }

    @Override
    public String toString() {
        return "Device{" +
                "action='" + action + '\'' +
                ", path='" + path + '\'' +
                ", uri='" + uri + '\'' +
                ", timestamp=" + timestamp +
                ", duration=" + duration +
                ", count=" + count +
                ", statusCode=" + statusCode +
                ", entities=" + entities +
                '}';
    }
}
