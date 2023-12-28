package com.link.linkconverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class LinkConverterService {
    private final LinkConverterRepository repository;
    private final LinkHelper helper;
    public LinkResponse convertWebUrlToDeeplink(String webUrl) {
       /* Link existingLink = repository.findByWebUrl(webUrl);
        if (existingLink != null) {
            return new LinkResponse(existingLink.getDeeplink(), existingLink.getWebUrl());
        }*/
        String contentId = "";
        String boutiqueId = "";
        String merchantId = "";
        String pageName = "";
        String query = "";
        if (webUrl.contains("-p-")) {
            String[] parts = helper.getUrlParts(webUrl);
            contentId = helper.getContentId(parts);
            pageName = "Product";
            String queryString = parts[4].split("-p-")[1];
            if (queryString.contains("boutiqueId=")) {
                boutiqueId = helper.getBoutiqueId(queryString);
            }
            if (queryString.contains("merchantId=")) {
                merchantId = helper.getMerchantId(queryString);
            }
        } else if (webUrl.contains("/sr?q=")) {
            String querySearch = helper.getQuerySearch(webUrl);
            pageName = "Search&Query=";
            query = querySearch.split("q=")[1];
        } else {
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
    public LinkResponse convertDeeplinkToWebUrl(String deeplink) {
        String contentId = "";
        String boutiqueId = "";
        String merchantId = "";
        String webUrl = "";
        if (deeplink.contains("Product")) {
            String[] partsForDeeplink = helper.getPartsForDeeplink(deeplink);
            contentId = helper.getContentIdForDeeplink(partsForDeeplink);
            boutiqueId = helper.getBoutiqueIdForDeeplink(partsForDeeplink);
            merchantId = helper.getMerchantIdForDeeplink(partsForDeeplink);

            webUrl = "https://www.aleynakaralar.com/brand/name-p-" +
                    (contentId.isEmpty() ? "" :  contentId) +
                    (boutiqueId.isEmpty() ? "" : "?boutiqueId=" + boutiqueId) +
                    (merchantId.isEmpty() ? "" : "&merchantId=" + merchantId);
        } else if (deeplink.contains("Search")) {
            String querySearchDeeplink = helper.getSearchDeeplink(deeplink);
            webUrl = "https://www.aleynakaralar.com/sr?q=" +
                    (querySearchDeeplink.isEmpty() ? "" :  querySearchDeeplink);
         } else {
            webUrl = "https://www.aleynakaralar.com/";
        }
        Link link = new Link();
        link.setDeeplink(deeplink);
        link.setWebUrl(webUrl);
        repository.save(link);
        return new LinkResponse(deeplink, webUrl);
    }
}
