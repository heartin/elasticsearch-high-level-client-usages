package cloud.heartin.projects.eshighlevelclientusages.service;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexServiceTest {

    static final String INDEX = "index1";

    @Autowired
    private IndexService service;

    @Test
    public void testCreateAndDelete() throws IOException {
        service.createIndex(INDEX);
        service.deleteIndex(INDEX);
    }

    @Test
    @Ignore
    public void createIndexTest() throws IOException {
        service.createIndex(INDEX);
        //TODO: Need to verify
    }

    @Test
    @Ignore
    public void deleteIndexTest() throws IOException {
        service.deleteIndex(INDEX);
        //TODO: Need to verify
    }

    @Test
    @Ignore
    public void openIndexTest() throws IOException {
        service.openIndex(INDEX);
        //TODO: Need to verify
    }

    @Test
    @Ignore
    public void closeIndexTest() throws IOException {
        service.closeIndex(INDEX);
        //TODO: Need to verify
    }

}
