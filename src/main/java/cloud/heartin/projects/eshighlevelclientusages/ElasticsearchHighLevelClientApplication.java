package cloud.heartin.projects.eshighlevelclientusages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Modified Spring Boot Main to pass checkstyle checks.
 */
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
@SpringBootApplication
public class ElasticsearchHighLevelClientApplication {

    /**
     * Spring Boot Application class main method.
     * @param args args accept command line arguments.
     */
    public static void main(final String[] args) {
        SpringApplication.run(
                ElasticsearchHighLevelClientApplication.class, args);
    }
}
