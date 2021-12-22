package com.msb.domain.consultancy;

import com.msb.domain.consultancy.models.ConsultancyRequestTicket;
import com.msb.domain.shared.vo.ConsultancyRequestTicketId;
import com.msb.supports.domain.Repository;

public interface ConsultancyRequestTicketPersistencePort
    extends Repository<ConsultancyRequestTicketId, ConsultancyRequestTicket> {}
