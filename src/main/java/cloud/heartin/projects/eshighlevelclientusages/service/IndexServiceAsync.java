package cloud.heartin.projects.eshighlevelclientusages.service;

import org.elasticsearch.action.admin.indices.close.CloseIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.open.OpenIndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.heartin.projects.eshighlevelclientusages.listeners.CloseIndexResponseActionListener;
import cloud.heartin.projects.eshighlevelclientusages.listeners.CreateIndexResponseActionListener;
import cloud.heartin.projects.eshighlevelclientusages.listeners.DeleteIndexResponseActionListener;
import cloud.heartin.projects.eshighlevelclientusages.listeners.OpenIndexResponseActionListener;

import lombok.extern.slf4j.Slf4j;

/**
 * Synchronous Index services.
 * See https://www.elastic.co/guide/en/elasticsearch/client/java-rest/
 *                                  current/java-rest-high-supported-apis.html
 */
@Slf4j
@Service
public class IndexServiceAsync {

    private final RestHighLevelClient client;

    @Autowired
    IndexServiceAsync(final RestHighLevelClient client) {
        this.client = client;
    }

    /**
     * Create an index asynchronously.
     * @param index index.
     */
    public final void createIndex(final String index) {
        CreateIndexRequest request = new CreateIndexRequest(index);
        client.indices().createAsync(request,
                new CreateIndexResponseActionListener());
    }

    /**
     * Delete an index asynchronously.
     * @param index index.
     */
    public final void deleteIndex(final String index) {
        DeleteIndexRequest request = new DeleteIndexRequest(index);
        client.indices().deleteAsync(request,
                new DeleteIndexResponseActionListener());
    }

    /**
     * Open an index asynchronously.
     * @param index index.
     */
    public final void openIndex(final String index) {
        OpenIndexRequest request = new OpenIndexRequest(index);
        client.indices().openAsync(request,
                new OpenIndexResponseActionListener());
    }

    /**
     * Close an index asynchronously.
     * @param index index.
     */
    public final void closeIndex(final String index) {
        CloseIndexRequest request = new CloseIndexRequest(index);
        client.indices().closeAsync(request,
                new CloseIndexResponseActionListener());
    }

}

