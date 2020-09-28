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
 * Tarefa Agendada Limpa anexos de perguntas
 *
 * Tarefa para verificar os anexos de perguntas quue não estão sincronizados com o
 * banco e exclui
 */
@Component
@DisallowConcurrentExecution
public class LimpaAnexosDePerguntasJob implements Job {

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    try {
      //Limpa Anexos
      blockly.Utilidades.limpaAnexosPergunta();
    } catch (Exception e) {
      throw new JobExecutionException(e);
    }
  }

  @Bean(name = "limpaAnexosDePerguntasJobDetail")
  public JobDetailFactoryBean limpaAnexosDePerguntasJobDetail() {
    return SchedulerConfigurer.createJobDetail(this.getClass());
  }

  /**
   * Disparador diário
   * Às 20:00, somente segunda-feira, terça-feira, quarta-feira, quinta-feira, sexta-feira, sábado e domingo
   */
  @Bean(name = "limpaAnexosDePerguntasJobDisparadorDiarioTrigger")
  public CronTriggerFactoryBean limpaAnexosDePerguntasJobDisparadorDiarioTrigger(@Qualifier("limpaAnexosDePerguntasJobDetail") JobDetail jobDetail) {

    return SchedulerConfigurer.createCronTrigger(jobDetail, "0 0 20 ? * 1,2,3,4,5,6,7");
  }
}