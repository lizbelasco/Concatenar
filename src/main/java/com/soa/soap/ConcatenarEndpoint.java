/**
 * 
 */
package com.soa.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.google.gson.Gson;
import com.soa.ConcatenarResponse;
import com.soa.ConcatenarRequest;
import com.soa.business.ConcatenarBusiness;

/**
 * Clase que publica un servicio web tipo SOAP. Capa Boundary
 */
@Endpoint
public class ConcatenarEndpoint {
    /** Objeto inyectado de la capa de negocio. */
    @Autowired
    private ConcatenarBusiness business;

    /** Targetnamespace. */
    private static final String NAMESPACE_URI = "http://soa.com";

    /**
     * Operación SOAP expuesta en http.
     * @param request Objeto con datos de entrada. (Capa de Modelo).
     * @return objeto con datos de salida (Capa de modelo)
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ConcatenarRequest")
    @ResponsePayload
    public ConcatenarResponse concatenarOperation(
            @RequestPayload ConcatenarRequest request) {
        
        ConcatenarResponse out = new ConcatenarResponse();
        
        String nombreCompleto = business.concatenar(
                request.getNombre(), request.getApellidos());
        
        out.setNombreCompleto(nombreCompleto);
        
        Gson gson = new Gson();
        
        return out;
    }
}