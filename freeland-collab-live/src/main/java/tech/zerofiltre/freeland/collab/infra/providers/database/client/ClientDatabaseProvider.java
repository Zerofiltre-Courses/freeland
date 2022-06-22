package tech.zerofiltre.freeland.collab.infra.providers.database.client;

import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import tech.zerofiltre.freeland.collab.domain.client.*;
import tech.zerofiltre.freeland.collab.domain.client.model.*;
import tech.zerofiltre.freeland.collab.infra.providers.database.client.mapper.*;
import tech.zerofiltre.freeland.collab.infra.providers.database.client.model.*;

import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientDatabaseProvider implements ClientProvider {

    private final ClientJPARepository repository;
    private final ClientJPAMapper mapper;

    @Override
    public Optional<Client> clientOfId(ClientId clientId) {
        return repository.findById(clientId.getSiren())
                .map(mapper::fromJPA);
    }

    @Override
    public Client registerClient(Client client) {
        ClientJPA clientJPA = mapper.toJPA(client);
        return mapper.fromJPA(repository.save(clientJPA));
    }
}
