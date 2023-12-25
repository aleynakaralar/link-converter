package com.link.linkconverter;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
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
    public String getMerchantId(String queryString) {
        String merchantId;
        merchantId = queryString.split("merchantId=")[1].split("&")[0];
        return merchantId;
    }
    public String getQuerySearch(String webUrl) {
        String querySearch = webUrl.split("\\?")[1];
        return querySearch;
    }
    public String[] getPartsForDeeplink(String deeplink) {
        return deeplink.split("&");
    }
    public  String getContentIdForDeeplink(String[] parts) {
        String contentId;
        contentId = parts[1].split("ContentId=")[1];
        return contentId;
    }
    public  String getBoutiqueIdForDeeplink(String[] parts) {
        String boutiqueId;
        boutiqueId = parts[2].split("=")[1].split("MerchantId=")[0];
        return boutiqueId;
    }
    public  String getMerchantId(String[] parts) {
        String merchantId;
        merchantId = parts[3].split("=")[1].split("ContentId=")[0];
        return merchantId;
    }
    public String getSearchDeeplink(String deeplink) {
        String querySearchDeeplink = deeplink.split("=")[2];
        return querySearchDeeplink;
    }
}
