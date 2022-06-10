package tech.zerofiltre.freeland.billing.domain.client;


import tech.zerofiltre.freeland.billing.domain.client.model.*;

import java.util.*;

public interface ClientProvider {

  Optional<Client> clientOfId(ClientId clientId);

  Client registerClient(Client client);

}
