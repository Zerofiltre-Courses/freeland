package tech.zerofiltre.freeland.collab.domain.client;


import tech.zerofiltre.freeland.collab.domain.client.model.*;

import java.util.*;

public interface ClientProvider {

  Optional<Client> clientOfId(ClientId clientId);

  Client registerClient(Client client);

}
