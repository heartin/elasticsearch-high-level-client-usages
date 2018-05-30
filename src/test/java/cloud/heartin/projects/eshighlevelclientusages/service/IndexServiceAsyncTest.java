package cloud.heartin.projects.eshighlevelclientusages.service;

import java.io.IOException;

import org.elasticsearch.ElasticsearchException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexServiceAsyncTest {

    static final String INDEX = "index1";

    @Autowired
    private IndexServiceAsync service;

    @Autowired
    private IndexService syncService;

    @Test
    public void createIndexTest() {
        service.createIndex(INDEX);

        //Using Thread.sleep to wait for async methods is not a great thing.
        try {
            Thread.sleep(1000);
            syncService.deleteIndex(INDEX);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //TODO: Need to check if callback methods are called.
    }

    @Test (expected = ElasticsearchException.class)
    public void deleteIndexTest() {

        try {
            syncService.createIndex(INDEX);
        } catch (IOException e) {
            e.printStackTrace();
        }

        service.deleteIndex(INDEX);

        //Using Thread.sleep to wait for async methods is not a great thing.
        try {
            Thread.sleep(1000);
            syncService.deleteIndex(INDEX);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        //TODO: Need to check if callback methods are called.

    }

    @Test
    @Ignore
    public void openIndexTest() {
        service.openIndex(INDEX);
        //TODO: Need to add explicit verification code
        //TODO: Need to check if callback methods are called.
    }

    @Test
    @Ignore
    public void closeIndexTest() {
        service.closeIndex(INDEX);
        //TODO: Need to add explicit verification code
        //TODO: Need to check if callback methods are called.
    }

}
