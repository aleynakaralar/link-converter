package com.link.linkconverter;
import org.springframework.stereotype.Component;

@Component
public class LinkHelper {
    public String[] getUrlParts(String webUrl) {
        return webUrl.split("/");
    }
    public String getContentId(String[] parts) {
        return parts[4].split("-p-")[1].split("\\?")[0];
    }
    public String getBoutiqueId(String queryString) {
        String boutiqueId;
        boutiqueId = queryString.split("boutiqueId=")[1].split("&")[0];
        return boutiqueId;
    }
    public String getQueryString(String[] parts) {
        return parts[4].split("-p-")[1];
    }
    public String getMerchantId(String queryString) {
        String merchantId;
        merchantId = queryString.split("merchantId=")[1].split("&")[0];
        return merchantId;
    }
    public String getQuerySearch(String webUrl) {
        return webUrl.split("\\?")[1];
    }
    public String[] getPartsForDeeplink(String deeplink) {
        return deeplink.split("&");
    }
    public String getContentIdForDeeplink(String[] partsForDeeplink) {
        String contentId;
        if (partsForDeeplink.length > 1) {
            contentId = partsForDeeplink[1].split("ContentId=")[1];
            return contentId;
        }   else {
            return contentId = "";
        }
    }
    public String getBoutiqueIdForDeeplink(String[] partsForDeeplink) {
        String boutiqueId;
        if (partsForDeeplink.length > 2) {
            boutiqueId = partsForDeeplink[2].split("=")[1].split("ContentId=")[0];
            return boutiqueId;
        }   else {
            return boutiqueId = "";
        }
    }
    public String getMerchantIdForDeeplink(String[] partsForDeeplink) {
        String merchantId;
        if (partsForDeeplink.length > 3) {
            merchantId = partsForDeeplink[3].split("=")[1].split("MerchantId=")[0];
             return merchantId;
        }   else {
            return merchantId = "";
        }
    }
    public String getSearchDeeplink(String deeplink) {
        return deeplink.split("=")[2];
    }
}

