package com.example.LinkConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LinkConverterService {
    private final LinkConverterRepository repository;
    private final ObjectMapper objectMapper;
    public LinkResponse convertWebUrlToDeeplink(String webUrl) {
        String contentId = "";
        String boutiqueId = "";
        String merchantId = "";
        String pageName ="";
        String query = "";

        if (webUrl.contains("-p-")) {
            String[] parts = webUrl.split("/");
            contentId = parts[4].split("-p-")[1].split("\\?")[0];
            pageName = "Product";

            String queryString = parts[4].split("-p-")[1];
            if (queryString.contains("boutiqueId=")) {
                boutiqueId = queryString.split("boutiqueId=")[1].split("&")[0];
            }
            if (queryString.contains("merchantId=")) {
                merchantId = queryString.split("merchantId=")[1].split("&")[0];
            }}
        else if (webUrl.contains("/sr?q=")) {
            String queryString2 = webUrl.split("\\?")[1];
            pageName = "Search&Query=";
            query = queryString2.split("q=")[1];
        }
        else {
            pageName = "Home";
        }
        String deeplink = "ak://?Page=" + pageName +
                (query.isEmpty() ? "" : query) +
                (contentId.isEmpty() ? "" : "&ContentId=" + contentId) +
                (boutiqueId.isEmpty() ? "" : "&CampaignId=" + boutiqueId) +
                (merchantId.isEmpty() ? "" : "&MerchantId=" + merchantId);
        Link link = new Link();
        link.setDeeplink(deeplink);
        link.setWebUrl(webUrl);
        repository.save(link);

        return new LinkResponse(deeplink, webUrl);

    }
}