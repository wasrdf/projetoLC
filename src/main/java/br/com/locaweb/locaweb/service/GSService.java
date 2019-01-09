package br.com.locaweb.locaweb.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.locaweb.locaweb.model.ElegibleTW;
import br.com.locaweb.locaweb.model.Statuses;
import br.com.locaweb.locaweb.model.StatusesResponse;
import br.com.locaweb.locaweb.util.GlobalProperties;


@Service
public class GSService {
	
	@Autowired
	private GlobalProperties properties;

	public List<ElegibleTW> getTweets() throws ClientProtocolException, IOException {
		
		
//		final String jsonMock = "{\"statuses\":[{\"coordinates\":null,\"favorited\":true,\"truncated\":false,\"created_at\":\"Mon Sep 24 03:35:21 +0000 2012\",\"id_str\":\"549363\",\"entities\":{\"urls\":[],\"hashtags\":[],\"user_mentions\":[{\"screen_name\":\"locaweb\",\"name\":\"Locaweb\",\"id\":42,\"id_str\":\"42\",\"indices\":[12,20]}]},\"in_reply_to_user_id_str\":\"344040\",\"contributors\":null,\"text\":\"Try to synt @locaweb th, maybe it will generate the haptic driver!\",\"metadata\":{\"iso_language_code\":\"pt\",\"result_type\":\"recent\"},\"retweet_count\":115,\"in_reply_to_status_id_str\":\"239971\",\"id\":549363,\"geo\":null,\"retweeted\":false,\"in_reply_to_user_id\":344040,\"place\":null,\"favorite_count\":96,\"user\":{\"profile_sidebar_fill_color\":\"DDEEF6\",\"profile_sidebar_border_color\":\"C0DEED\",\"profile_background_tile\":false,\"name\":\"Cali Smith\",\"profile_image_url\":\"http://a0.twimg.com/profile_images/2359746665/1v6zfgqo8g0d3mk7ii5s_normal.jpeg\",\"created_at\":\"Mon Apr 26 06:01:55 +0000 2010\",\"location\":\"LA, CA\",\"follow_request_sent\":null,\"profile_link_color\":\"0084B4\",\"is_translator\":false,\"id_str\":\"190275\",\"entities\":{\"url\":{\"urls\":[{\"expanded_url\":null,\"url\":\"\",\"indices\":[0,0]}]},\"description\":{\"urls\":[]}},\"default_profile\":true,\"contributors_enabled\":false,\"favourites_count\":45,\"url\":null,\"profile_image_url_https\":\"https://si0.twimg.com/profile_images/2359746665/1v6zfgqo8g0d3mk7ii5s_normal.jpeg\",\"utc_offset\":-28800,\"id\":190275,\"profile_use_background_image\":true,\"listed_count\":2,\"profile_text_color\":\"333333\",\"lang\":\"en\",\"followers_count\":231,\"protected\":false,\"notifications\":null,\"profile_background_image_url_https\":\"https://si0.twimg.com/images/themes/theme1/bg.png\",\"profile_background_color\":\"C0DEED\",\"verified\":false,\"geo_enabled\":true,\"time_zone\":\"Pacific Time (US & Canada)\",\"description\":\"Born 330 Live 310\",\"default_profile_image\":false,\"profile_background_image_url\":\"http://a0.twimg.com/images/themes/theme1/bg.png\",\"statuses_count\":579,\"friends_count\":231,\"following\":null,\"show_all_inline_media\":false,\"screen_name\":\"cali_smith\"},\"in_reply_to_screen_name\":\"conn_laney\",\"source\":\"web\",\"in_reply_to_status_id\":239971}]}";		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Username", properties.getHTTP_USERNAME());
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		
		ResponseEntity<StatusesResponse> s = restTemplate.exchange(properties.getUPI_TWITTER(), HttpMethod.POST, entity, StatusesResponse.class);
			
		List<ElegibleTW> elegiblesTw = new ArrayList<ElegibleTW>();
		for (Statuses st : s.getBody().getStatuses()) {
			ElegibleTW elegibleTW = new ElegibleTW();
				// tweet que mencione o usuário da Locaweb
				if (st.getText().contains("@locaweb")) {
					// tweet que não é reply para tweets da Locaweb

					if (!st.getIn_reply_to_screen_name().equalsIgnoreCase("locaweb")) {
						
						elegibleTW.setRetweets(st.getRetweet_count());
						elegibleTW.setConteudoTweet(st.getText());
						elegibleTW.setDataEHora(st.getCreated_at());
						elegibleTW.setLinkTweet(st.getUrl());
						
						if(st.getUser() != null) {
							elegibleTW.setScreen_name(st.getUser().getScreen_name());
							elegibleTW.setLinkPerfil(st.getUser().getProfile_image_url());
							elegibleTW.setNumeroSeguidores(st.getUser().getFollowers_count());
							elegibleTW.setNumeroFavoritos(st.getUser().getFavourites_count());
						}
						
			
						elegiblesTw.add(elegibleTW);

					}

				}

			}

		

		// Sorting 1. Usuários com mais seguidores
		Collections.sort(elegiblesTw, new Comparator<ElegibleTW>() {
			@Override
			public int compare(ElegibleTW elegibleTW1, ElegibleTW elegibleTW2) {

				return elegibleTW1.getNumeroSeguidores().compareTo(elegibleTW2.getNumeroSeguidores());
			}
		});

		// Sorting 2. Tweets que tenham mais retweets (considerar apenas o RT oficial do
		// Twitter)
		Collections.sort(elegiblesTw, new Comparator<ElegibleTW>() {
			@Override
			public int compare(ElegibleTW elegibleTW1, ElegibleTW elegibleTW2) {

				return elegibleTW1.getRetweets().compareTo(elegibleTW2.getRetweets());
			}
		});

		// Sorting 3. Tweet com mais likes
		// Não sei se o campo de like é esse pq não encontrei o campo like no json do serviço
		Collections.sort(elegiblesTw, new Comparator<ElegibleTW>() {
			@Override
			public int compare(ElegibleTW elegibleTW1, ElegibleTW elegibleTW2) {

				return elegibleTW1.getNumeroFavoritos().compareTo(elegibleTW2.getNumeroFavoritos());
			}
		});

		System.out.println(elegiblesTw.size());
		return elegiblesTw;

	}
	
	
	public static void main(String[] args) {
		
	}

}
