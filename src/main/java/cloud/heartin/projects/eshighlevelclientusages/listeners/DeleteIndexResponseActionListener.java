package cloud.heartin.projects.eshighlevelclientusages.listeners;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * ActionListener implementation for callback from Async calls.
 */
@Slf4j
public class DeleteIndexResponseActionListener
        implements ActionListener<DeleteIndexResponse> {

    @Override
    public final void onResponse(
            final DeleteIndexResponse deleteIndexResponse) {
        log.info("acknowledged={}", deleteIndexResponse.isAcknowledged());
    }

    @Override
    public final void onFailure(final Exception e) {
        log.error("Error Occurred (onFailure): " + e.getMessage());
    }
}
