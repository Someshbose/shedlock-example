package main.infra;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;


@Configuration
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "5m")
public class SchedulingConfiguration {

  @Bean
  public LockProvider lockProvider(DataSource dataSource) {
    return new JdbcTemplateLockProvider(Configuration.builder()
            .withJdbcTemplate(new JdbcTemplate(dataSource))
            .withTableName("shedlock")
            .withColumnNames(new JdbcTemplateLockProvider.ColumnNames("n", "lck_untl", "lckd_at", "lckd_by"))
            .withLockedByValue("my-value")
            .build());
  }
}
