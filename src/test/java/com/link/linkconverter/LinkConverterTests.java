package com.link.linkconverter;

import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LinkConverterTests {
	@InjectMocks
	private LinkHelper helper;
	private final String sampleWebUrl = "https://www.aleynakaralar.com/casio/saat-p-1925865?boutiqueId=439892&merchantId=105064";
	private final String  sampleDeeplink = "ak://?Page=Product&ContentId=1925865&CampaignId=439892&MerchantId=105064";
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	public void getUrlParts_whenWebUrlWithFiveParts_shouldReturnFiveParts() {
		String[] result = helper.getUrlParts(sampleWebUrl);
		int expectedCount = 5;
		assertEquals(expectedCount, result.length);
	}
	@Test
	public void getContentId_whenWebUrlPartOfContentId_shouldReturnContentId() {
		String[] parts = helper.getUrlParts(sampleWebUrl);
		String result = helper.getContentId(parts);
		assertEquals("1925865", result);
	}
	@Test
	public void getBoutiqueId_whenWebUrlPartOfBoutiqueId_shouldReturnBoutiqueId() {
		String result = helper.getBoutiqueId(sampleWebUrl);
		assertEquals("439892", result);
	}
	@Test
	public void getMerchantId_whenWebUrlPartOfMerchantId_shouldReturnMerchantId() {
		String result = helper.getMerchantId(sampleWebUrl);
		assertEquals("105064", result);
	}
	@Test
	public void getQuerySearch_whenWebUrlSearch_shouldReturnPartOfSearch() {
		String searchWebUrl = "https://www.aleynakaralar.com/sr?q=elbise";
		String result = helper.getQuerySearch(searchWebUrl);
		assertEquals("q=elbise", result);
	}
	@Test
	public void getPartsForDeeplink_whenDeeplinkWithParts_shouldReturnParts() {
		String[] partsForDeeplink = helper.getPartsForDeeplink(sampleDeeplink);
		int expectedCount = 4;
		assertEquals(expectedCount, partsForDeeplink.length);
	}
	@Test
	public void getContentIdForDeeplink_whenDeeplinkPartOfContentId_shouldReturnContentId() {
		String[] partsForDeeplink = helper.getPartsForDeeplink(sampleDeeplink);
		String result = helper.getContentIdForDeeplink(partsForDeeplink);
		assertEquals("1925865", result);
	}
	@Test
	public void getBoutiqueIdForDeeplink_whenDeeplinkPartOfBoutiqueId_shouldReturnBoutiqueId() {
		String[] partsForDeeplink = helper.getPartsForDeeplink(sampleDeeplink);
		String result = helper.getBoutiqueIdForDeeplink(partsForDeeplink);
		assertEquals("439892", result);
	}
	@Test
	public void getMerchantIdForDeeplink_whenDeeplinkPartOfMerchantId_shouldReturnMerchantId() {
		String[] partsForDeeplink = helper.getPartsForDeeplink(sampleDeeplink);
		String result = helper.getMerchantId(partsForDeeplink);
		assertEquals("105064", result);
	}
	@Test
	public void getQuerySearchForDeeplink_whenDeeplinkSearch_shouldReturnPartOfSearch() {
		String searchDeeplink = "ak://?Page=Search&Query=elbise";
		String result = helper.getSearchDeeplink(searchDeeplink);
		assertEquals("elbise", result);
	}
}