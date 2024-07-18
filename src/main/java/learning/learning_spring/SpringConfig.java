package learning.learning_spring;

import jakarta.persistence.EntityManager;
import learning.learning_spring.repository.JdbcMemberRepository;
import learning.learning_spring.repository.JdbcTemplateMemberRepository;
import learning.learning_spring.repository.JpaMemberRepository;
import learning.learning_spring.repository.MemberRepository;
import learning.learning_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
