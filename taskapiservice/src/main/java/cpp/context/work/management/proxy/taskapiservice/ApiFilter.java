package cpp.context.work.management.proxy.taskapiservice;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

@Provider
public class ApiFilter implements ContainerResponseFilter, ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
        response.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
        response.getHeaders().putSingle("Access-Control-Allow-Credentials", "true");
        response.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, PUT, PATCH, DELETE");
        response.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-type, X-Requested-With");
    }

    @Override
    public void filter(ContainerRequestContext request) throws IOException {
        SecurityContext securityContext = request.getSecurityContext();
        String authentication = securityContext.getAuthenticationScheme();
        Principal principal = securityContext.getUserPrincipal();
        String credentials = " ";
        if (notNull(principal) || notNull(authentication)) {
            credentials = " Authentication: " + authentication + " Principal: " + principal + " ";
        }

        UriInfo uriInfo = request.getUriInfo();
        String method = request.getMethod();
        List<Object> matchedResources = uriInfo.getMatchedResources();
        String matchedresources = "";
        for (Object matchedresource : matchedResources) {
            matchedresources += matchedresource.getClass().getName();
        }
 }

    public boolean notNull(Object value) {
        return value != null;
    }

}
