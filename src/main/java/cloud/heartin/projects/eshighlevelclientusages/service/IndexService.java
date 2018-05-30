package cloud.heartin.projects.eshighlevelclientusages.service;

import java.io.IOException;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.ElasticsearchStatusException;
import org.elasticsearch.action.admin.indices.close.CloseIndexRequest;
import org.elasticsearch.action.admin.indices.close.CloseIndexResponse;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.open.OpenIndexRequest;
import org.elasticsearch.action.admin.indices.open.OpenIndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.rest.RestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * Synchronous Index services.
 * See https://www.elastic.co/guide/en/elasticsearch/client/java-rest/
 *                                  current/java-rest-high-supported-apis.html
 */
@Slf4j
@Service
public class IndexService {

    private final RestHighLevelClient client;

    @Autowired
    IndexService(final RestHighLevelClient client) {
        this.client = client;
    }

    /**
     * Create an index synchronously.
     * @param index index.
     * @throws IOException not handled, not a great thing.
     */
    public final void createIndex(final String index) throws IOException {
        try {
            CreateIndexRequest request = new CreateIndexRequest(index);
            /* You may set additional settings on request in real world. */
            CreateIndexResponse createIndexResponse =
                    client.indices().create(request);

            log.info("acknowledged={}, shardsAcknowledged={}",
                    createIndexResponse.isAcknowledged(),
                    createIndexResponse.isShardsAcknowledged());
        } catch (ElasticsearchStatusException e) {
            log.error(e.getDetailedMessage());
            throw e;
        }
    }


    /**
     * Delete an index.
     * @param index index.
     * @throws IOException not handled, not a great thing.
     */
    public final void deleteIndex(final String index) throws IOException {
        try {
            DeleteIndexRequest request = new DeleteIndexRequest(index);
            DeleteIndexResponse response = client.indices().delete(request);
            log.info("acknowledged={}", response.isAcknowledged());
        } catch (ElasticsearchException e) {
            log.error(e.getDetailedMessage());
            if (e.status() == RestStatus.NOT_FOUND) {
                throw e;
            }
        }
    }


    /**
     * Open an index synchronously.
     * @param index index.
     * @throws IOException not handled, not a great thing.
     */
    public final void openIndex(final String index) throws IOException {
        try {
            OpenIndexRequest request = new OpenIndexRequest(index);
            /* You may set additional settings on request in real world. */
            OpenIndexResponse openIndexResponse =
                    client.indices().open(request);

            log.info("acknowledged={}, shardsAcknowledged={}",
                    openIndexResponse.isAcknowledged(),
                    openIndexResponse.isShardsAcknowledged());

        } catch (ElasticsearchStatusException e) {
            log.error(e.getDetailedMessage());
            throw new RuntimeException(e.getMessage());
        }

    }


    /**
     * Close an index synchronously.
     * @param index index.
     * @throws IOException not handled, not a great thing.
     */
    public final void closeIndex(final String index) throws IOException {
        try {
            CloseIndexRequest request = new CloseIndexRequest(index);
            /* You may set additional settings on request in real world. */
            CloseIndexResponse closeIndexResponse =
                    client.indices().close(request);

            log.info("acknowledged={}, shardsAcknowledged={}",
                    closeIndexResponse.isAcknowledged());
        } catch (ElasticsearchStatusException e) {
            log.error(e.getDetailedMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

}

