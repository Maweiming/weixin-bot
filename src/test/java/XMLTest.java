import com.maweiming.wechat.bot.model.login.LoginModel;
import com.maweiming.wechat.bot.utils.XMLUtils;
import com.xiaoleilu.hutool.json.JSONUtil;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version XMLTest.java, v 0.1 2018-10-31 00:21
 */
public class XMLTest {

    public static void main(String[] args) throws Exception {
        String loginXML = "<error>\n" +
                "    <ret>0</ret>\n" +
                "    <message></message>\n" +
                "    <skey>@crypt_89c64de5_5f481f027e89b97cb65ea7be339e4cde</skey>\n" +
                "    <wxsid>Xxq2CE+7DQ6JeT1l</wxsid>\n" +
                "    <wxuin>1393807808</wxuin>\n" +
                "    <pass_ticket>9HUqFF1vfm9ldIgnQXoTd4AfA1qzGT6OrAxC%2FF4RHDXcFi5mdzvjMuxMT4voQryS</pass_ticket>\n" +
                "    <isgrayscale>1</isgrayscale>\n" +
                "</error>";
        /**
         <error>
         <ret>0</ret>
         <message></message>
         <skey>@crypt_89c64de5_5f481f027e89b97cb65ea7be339e4cde</skey>
         <wxsid>Xxq2CE+7DQ6JeT1l</wxsid>
         <wxuin>1393807808</wxuin>
         <pass_ticket>9HUqFF1vfm9ldIgnQXoTd4AfA1qzGT6OrAxC%2FF4RHDXcFi5mdzvjMuxMT4voQryS</pass_ticket>
         <isgrayscale>1</isgrayscale>
         </error>
         */
        LoginModel loginModel = XMLUtils.toObject(loginXML, LoginModel.class);
        System.out.println(JSONUtil.toJsonStr(loginModel));

    }

}
