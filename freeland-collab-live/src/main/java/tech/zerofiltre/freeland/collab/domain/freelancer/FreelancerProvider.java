package tech.zerofiltre.freeland.collab.domain.freelancer;


import tech.zerofiltre.freeland.collab.domain.freelancer.model.*;

import java.util.*;

public interface FreelancerProvider {

  Optional<Freelancer> freelancerOfId(FreelancerId freelancerId);

  Freelancer registerFreelancer(Freelancer freelancer);

}
