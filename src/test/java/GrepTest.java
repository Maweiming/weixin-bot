import com.xiaoleilu.hutool.util.ReUtil;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version GrepTest.java, v 0.1 2018-11-02 00:25
 */
public class GrepTest {

    public static void main(String[] args) {

        //String regex = "window.QRLogin.code = (\\d+); window.QRLogin.uuid = \"(\\S+?)\"";
        String content = "window.synccheck={retcode:\"1100\",selector:\"0\"}";
        String regex = "window.synccheck=\\{retcode:\"(\\d+)\",selector:\"(\\S+?)\"\\}";
        System.out.println(ReUtil.get(regex, content,1));
        System.out.println(ReUtil.get(regex, content,2));

    }

}
