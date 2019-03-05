package com.gg.tlt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandRunner implements CommandLineRunner {

    @Value("${spring.web.loginurl}")
    private String loginUrl;

    @Value("${spring.web.googleexcute}")
    private String googleExcutePath;

    @Value("${spring.auto.openurl}")
    private boolean isOpen;

    @Override
    public void run(String... args)throws Exception {
        if(isOpen){
            System.out.println("正在打开浏览器");
            String cmd = googleExcutePath +" "+ loginUrl;
            System.out.println(cmd);
            Runtime run = Runtime.getRuntime();
            try{
                run.exec(cmd);
                System.out.println("启动浏览器打开项目成功");
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }
}
