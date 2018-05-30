package cloud.heartin.projects.eshighlevelclientusages.listeners;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * ActionListener implementation for callback from Async calls.
 */
@Slf4j
public class CreateIndexResponseActionListener
        implements ActionListener<CreateIndexResponse> {

    @Override
    public final void onResponse(
            final CreateIndexResponse createIndexResponse) {
        log.info("onResponse: acknowledged={}, shardsAcknowledged={}",
                createIndexResponse.isAcknowledged(),
                createIndexResponse.isShardsAcknowledged());
    }

    @Override
    public final void onFailure(final Exception e) {
        log.error("Error Occurred (onFailure): " + e.getMessage());
    }
}
