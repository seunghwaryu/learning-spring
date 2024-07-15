package learning.learning_spring;

import learning.learning_spring.repository.MemberRepository;
import learning.learning_spring.repository.MemoryMemberRepository;
import learning.learning_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
