package xyz.sydns.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zkn
 * @date 2016/8/14
 * [SpringBoot之退出服务（exit）时调用自定义的销毁方法 - CSDN博客](http://blog.csdn.net/zknxx/article/details/52204036 '0.0')
 */
@Component
public class MeDisposableBeanAndExitCodeGenerator implements DisposableBean, ExitCodeGenerator {

    @Override
    public void destroy() {
        String stopRabbitmq = "brew services stop rabbitmq";
        stopService(stopRabbitmq);

        String stopRedis = "brew services stop redis";
        stopService(stopRedis);
    }

    private void stopService(String command) {
        // [Java开发之调用shell命令并获取执行结果（Mac） - 你见，或者不见 - CSDN博客](http://blog.csdn.net/yxys01/article/details/76209612 '0.0')
        Process process;
        List<String> processList = new ArrayList<>();
        try {
            process = Runtime.getRuntime().exec(command);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                processList.add(line);
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line : processList) {
            System.out.println(line);
        }

    }


    @Override
    public int getExitCode() {
        return 5;
    }
}  