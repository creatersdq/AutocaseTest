import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//声明被springboot托管了
@SpringBootApplication
//声明需要扫描的包，包括方法和配置文件
@ComponentScan("com.course")

public class Application {



    public static void main(String[] args) {

        //固定写法，入口函数main
        SpringApplication.run(Application.class,args);
    }
}
