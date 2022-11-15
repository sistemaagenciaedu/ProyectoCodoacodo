package codoacodo.example.codo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Array;
import java.util.ArrayList;

@SpringBootApplication
@EnableAsync
public class CodoaApplication {
@Bean("threadPoolExecutor")
public TaskExecutor getAsyncExecutor(){
	ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
	executor.setCorePoolSize(2);
	executor.setMaxPoolSize(4);
	executor.setQueueCapacity(100);
	executor.setThreadNamePrefix("Async-");
	executor.initialize();
	return executor;
}



	public static void main(String[] args) {
		SpringApplication.run(CodoaApplication.class, args);



	}

}
