package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @Description git一键提交
 * @Author lyz
 * @Date 2022/9/13 15:15
 */
public class GitUtils {
    public static void main(String[] args) throws IOException, InterruptedException {
        InputStream in = null;
        System.out.print("请输入msg信息：");
        Scanner cin = new Scanner(System.in);
        String msg = cin.nextLine();
        String command0 = "cmd /c ";
        String command1 = "git add .";
        String command2 = "git commit -m " + msg;
        String command3 = "git push";
        String cmd = command0 + command1 + " && " + command2 + " && " + command3;
        Process process = Runtime.getRuntime().exec(cmd);
        InputStream successStream = process.getInputStream();
        InputStream errorStream = process.getErrorStream();
        int wait = process.waitFor();
        if (wait == 0) {
            in = successStream;
        } else {
            in = errorStream;
        }
        StringBuffer out = new StringBuffer();
        byte[] bytes = new byte[1024];
        int readCount = 0;
        while ((readCount = in.read(bytes)) != -1) {
            out.append(new String(bytes, 0, readCount, "gbk"));
        }
        System.out.println(out.toString());
        in.close();
        process.destroy();
    }
}
