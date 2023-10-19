package ktelabs.edu.hospitalmanagement.controller;


import jakarta.xml.bind.JAXBElement;
import ktelabs.edu.hospitalmanagement.jaxb.soapEntities.AddTicketsRequest;
import ktelabs.edu.hospitalmanagement.jaxb.soapEntities.AddTicketsResponse;
import ktelabs.edu.hospitalmanagement.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.namespace.QName;
import java.time.LocalDate;

@Endpoint
@RequiredArgsConstructor
public class TicketEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8080/SoapService/addTicket";
    private final TicketService ticketService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addTicketsRequest")
    @ResponsePayload
    public JAXBElement<AddTicketsResponse> addTickets(@RequestPayload JAXBElement<AddTicketsRequest> request) {
        ticketService.addTickets(request.getValue().getDoctorId()
                , request.getValue().getNumberOfAppointments()
                , LocalDate.of(request.getValue().getDate().getYear(), request.getValue().getDate().getMonth(), request.getValue().getDate().getDay())
                , request.getValue().getDurationOfAppointments()
                , request.getValue().getHourOfStart());
        AddTicketsResponse addTicketsResponse = new AddTicketsResponse();
        addTicketsResponse.setResponse("ok");
        return new JAXBElement<>(new QName(AddTicketsResponse.class.getSimpleName()), AddTicketsResponse.class, addTicketsResponse);
    }
}
