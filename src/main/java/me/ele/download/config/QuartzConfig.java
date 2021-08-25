package me.ele.download.config;


import me.ele.download.quartz.ExecuteOrderExportJob;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class QuartzConfig {
    // FactoryBean可简化Bean的实例化过程:
    // 1.通过FactoryBean封装Bean的实例化过程.
    // 2.将FactoryBean装配到Spring容器里.
    // 3.将FactoryBean注入给其他的Bean.
    // 4.该Bean得到的是FactoryBean所管理的对象实例.
    //@Bean
    public JobDetailFactoryBean executeOrderExportJobDetail(){
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(ExecuteOrderExportJob.class);
        factoryBean.setName("executeOrderExportJob");
        factoryBean.setGroup("ezhandaodiJobGroup");
        factoryBean.setDurability(true);
        factoryBean.setRequestsRecovery(true);
        return factoryBean;
    }

    //@Bean
    public SimpleTriggerFactoryBean executeOrderExportTrigger(JobDetail executeOrderExportJobDetail){
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        factoryBean.setJobDetail(executeOrderExportJobDetail);
        factoryBean.setName("executeOrderExportTrigger");
        factoryBean.setGroup("ezhandaodiTriggerGroup");
        factoryBean.setRepeatInterval(3000);
        factoryBean.setJobDataMap(new JobDataMap());
        return factoryBean;
    }

}
