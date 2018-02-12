package com.yihengliu.demo.test;

import com.yihengliu.demo.common.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 测试类
 *
 * @author liucheng
 * @version 0.1
 * @since 0.1 2018-02-06 上午8:23
 **/
public class Test6 {
    public static void main(String[] args) {
/*        String str33 = "D:/KAKOU/192.168.1.1/20180206/xxxx.png";
        System.out.println(str33.indexOf("/", str33.indexOf("/") + 1));
        System.out.println(str33.substring(0, str33.indexOf("/", str33.indexOf("/") + 1) + 1));
        System.out.println(str33.substring(8, str33.length()));

        User user = null;
        Optional<User> optionalUser = Optional.ofNullable(user);
        // 获取名字，由于对象位空异常返回默认值
        String name = optionalUser.map(u -> u.getName()).orElse("获取名字失败，返回默认名字");
        System.out.println(name);

        User user2 = new User();
        // 这个时候可以用of，因为user2非null
        Optional<User> optionalUser2 = Optional.of(user2);
        // 获取名字，对象部位空，get获取到的name位null也会返回默认值
        String name2 = optionalUser.map(u -> u.getName()).orElse("获取名字失败，返回默认名字2");
        System.out.println(name2);


        String str = null;
        Optional<String> stringOptional = Optional.ofNullable(str);
        // filter用来给Optional对象增加过滤条件
        Optional<String> stringOptional1 = stringOptional.filter((s) -> s != null);
        System.out.println(stringOptional1.orElse("因为上面增加了filter条件，所以获取String内容的时候如果会空就会返回这里面的默认值"));

        String str2 = "123456";
        Optional<String> stringOptional3 = Optional.of(str2);
        Optional<String> stringOptional4 = stringOptional3.filter((s) -> s.length() > 5);
        System.out.println(stringOptional4.orElse("根据上面的filter条件，字符串长度大于5就会输出本身内容，否则会输出这里面的内容"));
*/

        // 返回的对象直接为null
        ReturnBean b1 = null;
        // bpmParam为null
        ReturnBean b2 = new ReturnBean(null);
        // taskDefinitionKey为null
        ReturnBean b3 = new ReturnBean(new HashMap<>());
        // taskDefinitionKey值不为zjjs
        ReturnBean b4 = new ReturnBean(new HashMap<String, String>() {{ put("taskDefinitionKey", "zjjs1"); put("candidateUsers", "候选人");}});
        // taskDefinitionKey值为zjjs，candidateUser为null
        ReturnBean b5 = new ReturnBean(new HashMap<String, String>() {{ put("taskDefinitionKey", "zjjs"); put("candidateUsers", null);}});
        // 正确情况
        ReturnBean b6 = new ReturnBean(new HashMap<String, String>() {{ put("taskDefinitionKey", "zjjs"); put("candidateUsers", "候选人");}});
        System.out.println(getCandidate(b1));
        System.out.println(getCandidate(b2));
        System.out.println(getCandidate(b3));
        System.out.println(getCandidate(b4));
        System.out.println(getCandidate(b5));
        System.out.println(getCandidate(b6));
    }

    private static String getCandidate(ReturnBean bean) {
        System.out.println("获取到的bean:" + bean);
        Optional<ReturnBean> returnBean = Optional.ofNullable(bean);
        Optional<ReturnBean> returnBeanOptional = returnBean.filter(b -> b.getBpmParam() != null).filter(b -> "zjjs".equals(b.getBpmParam().get("taskDefinitionKey")));
        if (returnBeanOptional.isPresent()) {
            // 不满足条件taskDefinitionKey为zjjs
            System.out.println("满足条件");
        } else {
            // 满足条件
            System.out.println("不满足条件");
        }
        String candidateUsers = returnBeanOptional.map(b -> b.getBpmParam().get("candidateUsers")).orElse("失败后获得默认候选者");
        return candidateUsers;
    }
}

class ReturnBean {
    private Map<String, String> bpmParam;

    public ReturnBean(Map<String, String> bpmParam) {
        this.bpmParam = bpmParam;
    }

    public Map<String, String> getBpmParam() {
        return bpmParam;
    }

    public void setBpmParam(Map<String, String> bpmParam) {
        this.bpmParam = bpmParam;
    }

    @Override
    public String toString() {
        return "ReturnBean{" +
                "bpmParam=" + bpmParam +
                '}';
    }
}
