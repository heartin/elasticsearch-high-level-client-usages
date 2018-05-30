package cloud.heartin.projects.eshighlevelclientusages.listeners;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.open.OpenIndexResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * ActionListener implementation for callback from Async calls.
 */
@Slf4j
public class OpenIndexResponseActionListener
        implements ActionListener<OpenIndexResponse> {

    @Override
    public final void onResponse(
            final OpenIndexResponse createIndexResponse) {
        log.info("onResponse: acknowledged={}, shardsAcknowledged={}",
                createIndexResponse.isAcknowledged(),
                createIndexResponse.isShardsAcknowledged());
    }

    @Override
    public final void onFailure(final Exception e) {
        log.error("Error Occurred (onFailure): " + e.getMessage());
    }
}
