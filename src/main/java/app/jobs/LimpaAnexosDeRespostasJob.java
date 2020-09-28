/**
 * As alterações neste arquivo podem causar um comportamento incorreto e serão
 * perdidas se a IDE precisar atualizá-lo
 */
package app.jobs;

import cronapp.framework.scheduler.SchedulerConfigurer;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

import cronapi.Var;

/**
 * Tarefa Agendada Limpa anexos de respostas
 *
 * Tarefa para verificar os anexos de respostas quue não estão sincronizados com o
 * banco e exclui
 */
@Component
@DisallowConcurrentExecution
public class LimpaAnexosDeRespostasJob implements Job {

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    try {
      //Limpa Anexos
      blockly.Utilidades.limpaAnexosResposta();
    } catch (Exception e) {
      throw new JobExecutionException(e);
    }
  }

  @Bean(name = "limpaAnexosDeRespostasJobDetail")
  public JobDetailFactoryBean limpaAnexosDeRespostasJobDetail() {
    return SchedulerConfigurer.createJobDetail(this.getClass());
  }

  /**
   * Disparador diário
   * Às 20:20, somente segunda-feira, terça-feira, quarta-feira, quinta-feira, sexta-feira, sábado e domingo
   */
  @Bean(name = "limpaAnexosDeRespostasJobDisparadorDiarioTrigger")
  public CronTriggerFactoryBean limpaAnexosDeRespostasJobDisparadorDiarioTrigger(@Qualifier("limpaAnexosDeRespostasJobDetail") JobDetail jobDetail) {

    return SchedulerConfigurer.createCronTrigger(jobDetail, "0 20 20 ? * 1,2,3,4,5,6,7");
  }
}