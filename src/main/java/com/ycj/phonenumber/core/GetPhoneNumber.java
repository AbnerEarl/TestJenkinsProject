package com.ycj.phonenumber.core;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author: Frank
 * @email 1320259466@qq.com
 * @date: 2020/5/13
 * @time: 22:16
 * @fuction: about the role of class.
 */
public class GetPhoneNumber {





    private URLConnection connection = null;
    public String getDoucument(String url) throws IOException {

        URL newUrl = new URL(url);
        connection = newUrl.openConnection();
        InputStream is = connection.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String line = "";
        StringBuffer sb = new StringBuffer();

        while( (line =  br.readLine()) != null) {
            sb.append(line +"\n");
        }

        return sb.toString();

    }

    public String MyFilter( String string ) {//内容过滤器-获取网页上的电话，没有去重

        String regex = "18[\\d]{9}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        String result = "";
        while(matcher.find()) {
            result += matcher.group()+"\n";
        }

        return result;
    }

    public static void main(String[] args) throws IOException {

        GetPhoneNumber test = new GetPhoneNumber();
//        String page = test.getDoucument("https://power.baidu.com/question/1511959129473915060.html?qbl=relate_question_1");
//        String page = test.getDoucument("http://www.52014991.xyz/home.html");
        String page = test.getDoucument("https://www.baidu.com/");
//        String page = test.getDoucument("http://www.hnzdgs.com/");
        System.out.println(page);
        String result = test.MyFilter(page);
        //        System.out.println(page);

        if ( result != null ) {
            System.out.println("从该网页上找到的号码：\n"+result);
        }
        else {
            System.out.println("该网页上没有电话号码");
        }

    }
}