package tech.zerofiltre.freeland.collab.infra.entrypoints.rest.error;

import lombok.*;

@Getter
@RequiredArgsConstructor
public class FreelandError {
    private final String status;
    private final String message;
    private final String description;
}
