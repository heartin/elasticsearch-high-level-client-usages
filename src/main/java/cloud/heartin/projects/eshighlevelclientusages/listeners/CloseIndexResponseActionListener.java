package cloud.heartin.projects.eshighlevelclientusages.listeners;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.close.CloseIndexResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * ActionListener implementation for callback from Async calls.
 */
@Slf4j
public class CloseIndexResponseActionListener
        implements ActionListener<CloseIndexResponse> {

    @Override
    public final void onResponse(
            final CloseIndexResponse createIndexResponse) {
        log.info("onResponse: acknowledged={}",
                createIndexResponse.isAcknowledged());
    }

    @Override
    public final void onFailure(final Exception e) {
        log.error("Error Occurred (onFailure): " + e.getMessage());
    }
}
