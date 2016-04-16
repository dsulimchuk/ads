package ui.resources;

import com.ds.ads.model.Country;
import com.ds.ads.model.Region;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.client.Traverson;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ds on 03/11/15.
 */
public class GenericResource {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(GenericResource.class);

    private static Traverson traverson = null;

    static {
        try {
            traverson = new Traverson(new URI("http://localhost:8080/api/repo"), MediaTypes.HAL_JSON);
        } catch (URISyntaxException e) {
            LOGGER.error("error during instantiate Traverson", e);
        }
    }

    public static Resources<Country> getAllCountries() {
        if (traverson == null) {
            return null;
        }
        ParameterizedTypeReference<Resources<Country>> resourceParameterizedTypeReference = new ParameterizedTypeReference<Resources<Country>>() {};


        Resources<Country> itemResource = traverson.
                follow("countries").
                toObject(resourceParameterizedTypeReference);
        return itemResource;
    }

    public static Resources<Region> getAllRegionsByCountryId(Long countryId) {
        if (traverson == null) {
            return null;
        }
        ParameterizedTypeReference<Resources<Region>> resourceParameterizedTypeReference = new ParameterizedTypeReference<Resources<Region>>() {};
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("countryId", countryId);

        Resources<Region> itemResource = traverson.
                follow("regions").
                follow("search").
                follow("findByCountryId").
                withTemplateParameters(parameters).
                toObject(resourceParameterizedTypeReference);
        return itemResource;
    }
}
