package tech.zerofiltre.freeland.collab.infra.entrypoints.rest.client;

import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import tech.zerofiltre.freeland.collab.domain.client.*;
import tech.zerofiltre.freeland.collab.domain.client.model.*;
import tech.zerofiltre.freeland.collab.infra.entrypoints.rest.client.mapper.*;
import tech.zerofiltre.freeland.collab.infra.entrypoints.rest.client.model.*;

import javax.validation.*;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientVMMapper clientVMMapper;
    private final ClientProvider clientProvider;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ClientVM registerClient(@RequestBody @Valid ClientVM clientVM) {
        Client client = clientProvider.registerClient(clientVMMapper.fromVM(clientVM));
        return clientVMMapper.toVM(client);
    }
}
