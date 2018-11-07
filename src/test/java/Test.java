import com.alibaba.fastjson.JSON;
import com.maweiming.wechat.bot.service.impl.ListenMessageServiceImpl;
import com.maweiming.wechat.bot.utils.FileUtils;
import com.maweiming.wechat.bot.utils.HttpUtils;
import com.maweiming.wechat.bot.utils.IdGenerate;
import com.maweiming.wechat.bot.utils.TimeUtils;
import com.xiaoleilu.hutool.util.ReUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        String content = "@9abcdb1f46f547ddddd16c5b76270106b05af1d40affcd65d7c0f57bb2f051e6:<br/>&lt;sysmsg type=\"revokemsg\"&gt;&lt;revokemsg&gt;&lt;session&gt;10635087412@chatroom&lt;/session&gt;&lt;oldmsgid&gt;1088798387&lt;/oldmsgid&gt;&lt;msgid&gt;7032570294236529159&lt;/msgid&gt;&lt;replacemsg&gt;&lt;![CDATA[\"施嘉威\" 撤回了一条消息]]&gt;&lt;/replacemsg&gt;&lt;/revokemsg&gt;&lt;/sysmsg&gt;";
        //msgid&gt;7032570294236529159&lt;/msgid&gt;
        String msgId = ReUtil.get("msgid&gt;(\\d+)&lt;/msgid", content, 1);
        System.out.println(msgId);
    }

}
